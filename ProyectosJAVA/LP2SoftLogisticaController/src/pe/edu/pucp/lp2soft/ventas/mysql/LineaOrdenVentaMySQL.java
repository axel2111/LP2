package pe.edu.pucp.lp2soft.ventas.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.almacen.model.Producto;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.ventas.dao.LineaOrdenVentaDAO;
import pe.edu.pucp.lp2soft.ventas.model.LineaOrdenVenta;
public class LineaOrdenVentaMySQL implements LineaOrdenVentaDAO{

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public ArrayList<LineaOrdenVenta> listarPorIdOrdenVenta(int idOrdenVenta) {
        ArrayList<LineaOrdenVenta> lineasOrdenVenta = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_LINEAS_ORDEN_VENTA_X_ID_ORDEN_VENTA(?)}");
            cs.setInt("_id_orden_venta", idOrdenVenta);
            rs = cs.executeQuery();
            while(rs.next()){
                LineaOrdenVenta lov = new LineaOrdenVenta();
                lov.setIdeLineaOrdenVenta(rs.getInt("id_linea_orden_venta"));
                lov.setProducto(new Producto());
                lov.getProducto().setIdProducto(rs.getInt("id_producto"));
                lov.getProducto().setNombre(rs.getString("nombre"));
                lov.getProducto().setUnidadMedida(rs.getString("unidad_medida"));
                lov.getProducto().setPrecio(rs.getDouble("precio"));
                lov.setCantidad(rs.getInt("cantidad"));
                lov.setSubtotal(rs.getDouble("subtotal"));
                lineasOrdenVenta.add(lov);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return lineasOrdenVenta;
    }
    
}
