package pe.edu.pucp.lp2soft.ventas.dao;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.ventas.model.OrdenVenta;
public interface OrdenVentaDAO {
    int insertar(OrdenVenta ordenVenta);
    int modificar(OrdenVenta ordenVenta);
    int eliminar(int idOrdenVenta);
    ArrayList<OrdenVenta> listarPorIdDNINombreCliente(String idDNINombreCliente);
}
