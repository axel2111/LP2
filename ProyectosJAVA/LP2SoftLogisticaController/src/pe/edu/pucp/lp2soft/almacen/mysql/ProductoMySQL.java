package pe.edu.pucp.lp2soft.almacen.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.almacen.dao.ProductoDAO;
import pe.edu.pucp.lp2soft.almacen.model.Producto;
import pe.edu.pucp.lp2soft.config.DBManager;
public class ProductoMySQL implements ProductoDAO{
    
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public ArrayList<Producto> listarPorNombre(String nombre) {
        ArrayList<Producto> productos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_PRODUCTOS_X_NOMBRE(?)}");
            cs.setString("_nombre",nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setUnidadMedida(rs.getString("unidad_medida"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setActivo(true);
                productos.add(producto);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return productos;
    }
}