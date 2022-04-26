/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.lp2soft.rrhh.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;

public class EmpleadoMySQL implements EmpleadoDAO {
    private Connection con ;
    private Statement st ; 
    private ResultSet rs ;
    private PreparedStatement ps ;
    private CallableStatement cs ;
//    @Override
//    public int insertar(Empleado empleado) {
//        int resultado = 0 ;
//        try{
//             //REGISTRAMOS DRIVER DE CONECCION ; 
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //Establecer la conexion ;
//            con = DriverManager.getConnection("jdbc:mysql://database-lp2.cdwk0pjnvpcl.us-east-1.rds.amazonaws.com:3306/lp2","admin","lp220221") ;
//            
//            //FORMATO DE FECHA
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            //Ejecutar una instruccion SQL
//            
//            String sql = "INSERT INTO persona (DNI,nombre,apellido_paterno,genero,fecha_nacimiento) "
//                    + "VALUES('"+empleado.getDNI()+"','"+empleado.getNombre()+"','"+empleado.getApellidoPaterno()+"','"+empleado.getGenero()+"',"
//                    +"'" + sdf.format(empleado.getFechaNacimiento())+"')"; 
//            
//            //Creamos un objeto statement 
//            st = con.createStatement(); 
//            st.executeUpdate(sql) ;
//            //Ejectuar una instruccion para determinar el id generado
//            sql = "SELECT @@last_insert_id AS id" ; 
//            rs = st.executeQuery(sql) ; 
//            
//            //Colocamos el cursor en la primera fila de la tabla 
//            rs.next() ;
//            //Leer la columna id ; 
//            empleado.setIdPersona(rs.getInt("id"));
//            //ejecutar una instruccion para los datos propios del empleado ; 
//            sql = "INSERT INTO empleado(id_empleado,fid_area, cargo,sueldo,activo)"
//                    + "VALUES(" +empleado.getIdPersona()+","
//                    +empleado.getArea().getIdArea()+",'"+empleado.getCargo()+"',"
//                    +empleado.getSueldo()+",1)"; 
//            resultado = st.executeUpdate(sql) ; 
//        }catch(Exception ex){
//            System.err.println(ex.getMessage());
//        }finally{
//            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
//        }
//        
//        return resultado ;
//    }
    
//    @Override 
//    public int insertar (Empleado empleado ){
//        int resultado = 0 ; 
//         try{
//            con = DBManager.getInstance().getConnection();
//            String sql = "INSERT INTO persona (DNI,nombre , apellido_paterno,genero,fecha_nacimiento) VALUES(?,?,?,?,?)";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, empleado.getDNI());
//            ps.setString(2, empleado.getNombre());
//            ps.setString(3, empleado.getApellidoPaterno());
//            ps.setString(4, String.valueOf(empleado.getGenero()));
//            ps.setDate(5, new java.sql.Date(empleado.getFechaNacimiento().getTime()));
//            ps.executeUpdate();
//            sql = "SELECT @@last_insert_id as id"; 
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            rs.next();
//            empleado.setIdPersona(rs.getInt("id"));
//            
//            sql = "INSERT INTO empleado(id_empleado , fid_area , fid_cuenta_usuario,cargo,sueldo,activo) VALUES(?,?,?,?,?,?)";
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, empleado.getIdPersona());
//            ps.setInt(2, empleado.getArea().getIdArea());
//            ps.setInt(3, empleado.getCuentaUsuario().getIdCuentaUsuario());
//            ps.setString(4, empleado.getCargo());
//            ps.setDouble(5, empleado.getSueldo());
//            ps.setBoolean(6, true);
//            resultado = ps.executeUpdate();
//        }catch(Exception ex){
//            System.err.println(ex.getMessage());
//        }finally{
//            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
//        }
//            
//        return resultado ;
//    }
    
    @Override 
    public int insertar (Empleado empleado){
        int resultado = 0 ; 
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_EMPLEADO(?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_persona", java.sql.Types.INTEGER);
            cs.setInt("_fid_area", empleado.getArea().getIdArea());
            cs.setInt("_fid_cuenta_usuario", empleado.getCuentaUsuario().getIdCuentaUsuario()); // sacar de la tabla cuenta usuario
            cs.setString("_DNI", empleado.getDNI());
            cs.setString("_nombre", empleado.getNombre());
            cs.setString("_apellido_paterno" , empleado.getApellidoPaterno());
            cs.setString("_genero" , String.valueOf(empleado.getGenero()));
            cs.setDate("_fecha_nacimiento", new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            cs.setString("_cargo",empleado.getCargo());
            cs.setDouble("_sueldo" , empleado.getSueldo());
            cs.executeUpdate();
            empleado.setIdPersona(cs.getInt("_id_persona"));
            resultado = 1 ;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        
        
        return resultado ; 
    }
}
