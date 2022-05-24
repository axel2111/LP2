package pe.edu.pucp.lp2soft.rrhh.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.edu.pucp.lp2soft.rrhh.dao.CuentaUsuarioDAO;
import pe.edu.pucp.lp2soft.rrhh.model.CuentaUsuario;

public class CuentaUsuarioMySQL implements CuentaUsuarioDAO{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    @Override
    public int insertar(CuentaUsuario cuentaUsuario) {
        int resultado = 0;
        try{
            //Registramos el Driver de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer la conexión
            con = DriverManager.getConnection(
                    "jdbc:mysql://database-lp2.cre3dummjuet.us-east-1.rds.amazonaws.com:3306/lp2", 
                    "admin", "lp220221");
            //Creamos la instrucción SQL
            st = con.createStatement();
            String sql = "INSERT INTO cuenta_usuario(username,password,activo) "
                    + "values('"+cuentaUsuario.getUsername()+"','"
                    +cuentaUsuario.getPassword()+"',1)";
            resultado = st.executeUpdate(sql);
            sql = "SELECT @@last_insert_id AS id";
            rs = st.executeQuery(sql);
            rs.next();
            cuentaUsuario.setIdCuentaUsuario(rs.getInt("id"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
}
