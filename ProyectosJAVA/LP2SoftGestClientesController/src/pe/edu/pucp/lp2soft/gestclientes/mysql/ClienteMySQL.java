package pe.edu.pucp.lp2soft.gestclientes.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.gestclientes.dao.ClienteDAO;
import pe.edu.pucp.lp2soft.gestclientes.model.Categoria;
import pe.edu.pucp.lp2soft.gestclientes.model.Cliente;
public class ClienteMySQL implements ClienteDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public ArrayList<Cliente> listarPorNombreDNI(String nombreDNI) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CLIENTES_X_NOMBREDNI(?)}");
            cs.setString("_nombreDNI",nombreDNI);
            rs = cs.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdPersona(rs.getInt("id_persona"));
                cliente.setDNI(rs.getString("DNI"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidoPaterno(rs.getString("apellido_paterno"));
                cliente.setGenero(rs.getString("genero").charAt(0));
                cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                cliente.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                cliente.setLineaCredito(rs.getDouble("linea_credito"));
                cliente.setActivo(true);
                clientes.add(cliente);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return clientes;
    }
}