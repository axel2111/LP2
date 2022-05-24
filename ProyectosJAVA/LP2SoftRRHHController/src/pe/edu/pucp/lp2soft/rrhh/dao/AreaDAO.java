package pe.edu.pucp.lp2soft.rrhh.dao;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
public interface AreaDAO {
    ArrayList<Area> listarTodas();
    int insertar(Area area);
    int modificar(Area area);
    int eliminar(int idArea);
    Area buscarPorId(int idArea);
}