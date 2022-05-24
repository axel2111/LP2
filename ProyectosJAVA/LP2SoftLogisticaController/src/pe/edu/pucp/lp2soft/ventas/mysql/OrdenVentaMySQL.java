package pe.edu.pucp.lp2soft.ventas.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.gestclientes.model.Cliente;
import pe.edu.pucp.lp2soft.ventas.dao.OrdenVentaDAO;
import pe.edu.pucp.lp2soft.ventas.model.LineaOrdenVenta;
import pe.edu.pucp.lp2soft.ventas.model.OrdenVenta;

public class OrdenVentaMySQL implements OrdenVentaDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(OrdenVenta ordenVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_ORDEN_VENTA(?,?,?,?)}");
            cs.registerOutParameter("_id_orden_venta", java.sql.Types.INTEGER);
            cs.setInt("_fid_cliente", ordenVenta.getCliente().getIdPersona());
            cs.setInt("_fid_empleado", ordenVenta.getEmpleado().getIdPersona());
            cs.setDouble("_total", ordenVenta.getTotal());
            cs.executeUpdate();
            ordenVenta.setIdOrdenVenta(cs.getInt("_id_orden_venta"));
            for(LineaOrdenVenta lov : ordenVenta.getLineasOrdenVenta()){
                cs = con.prepareCall("{call INSERTAR_LINEA_ORDEN_VENTA(?,?,?,?,?)}");
                cs.registerOutParameter("_id_linea_orden_venta", java.sql.Types.INTEGER);
                cs.setInt("_fid_orden_venta", ordenVenta.getIdOrdenVenta());
                cs.setInt("_fid_producto", lov.getProducto().getIdProducto());
                cs.setInt("_cantidad", lov.getCantidad());
                cs.setDouble("_subtotal", lov.getSubtotal());
                cs.executeUpdate();
            }
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(OrdenVenta ordenVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_ORDEN_VENTA(?,?,?,?)}");
            cs.setInt("_id_orden_venta", ordenVenta.getIdOrdenVenta());
            cs.setInt("_fid_cliente", ordenVenta.getCliente().getIdPersona());
            cs.setInt("_fid_empleado", ordenVenta.getEmpleado().getIdPersona());
            cs.setDouble("_total", ordenVenta.getTotal());
            cs.executeUpdate();
            for(LineaOrdenVenta lov : ordenVenta.getLineasOrdenVenta()){
                cs = con.prepareCall("{call INSERTAR_LINEA_ORDEN_VENTA(?,?,?,?,?)}");
                cs.registerOutParameter("_id_linea_orden_venta", java.sql.Types.INTEGER);
                cs.setInt("_fid_orden_venta", ordenVenta.getIdOrdenVenta());
                cs.setInt("_fid_producto", lov.getProducto().getIdProducto());
                cs.setInt("_cantidad", lov.getCantidad());
                cs.setDouble("_subtotal", lov.getSubtotal());
                cs.executeUpdate();
            }
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idOrdenVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_ORDEN_VENTA(?)}");
            cs.setInt("_id_orden_venta", idOrdenVenta);
            cs.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<OrdenVenta> listarPorIdDNINombreCliente(String idDNINombreCliente) {
        ArrayList<OrdenVenta> ordenesVenta = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ORDENES_VENTA_X_ID_NOMBRE_DNI_CLIENTE(?)}");
            cs.setString("_idDniNombreCliente", idDNINombreCliente);
            rs = cs.executeQuery();
            while(rs.next()){
                OrdenVenta ordenVenta = new OrdenVenta();
                ordenVenta.setIdOrdenVenta(rs.getInt("id_orden_venta"));
                ordenVenta.setCliente(new Cliente());
                ordenVenta.getCliente().setIdPersona(rs.getInt("id_cliente"));
                ordenVenta.getCliente().setDNI(rs.getString("DNI"));
                ordenVenta.getCliente().setNombre(rs.getString("nombre"));
                ordenVenta.getCliente().setApellidoPaterno(rs.getString("apellido_paterno"));
                ordenVenta.setFechaHora(rs.getDate("fecha_hora_registro"));
                ordenVenta.setTotal(rs.getDouble("total"));
                ordenesVenta.add(ordenVenta);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ordenesVenta;
    }
}