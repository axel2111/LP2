package pe.edu.pucp.lp2soft.ventas.dao;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.ventas.model.LineaOrdenVenta;
public interface LineaOrdenVentaDAO {
    ArrayList<LineaOrdenVenta> listarPorIdOrdenVenta(int idOrdenVenta);
}