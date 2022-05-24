package pe.edu.pucp.lp2soft.almacen.dao;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.almacen.model.Producto;
public interface ProductoDAO {
    ArrayList<Producto> listarPorNombre(String nombre);
}
