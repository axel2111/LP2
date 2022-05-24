package pe.edu.pucp.lp2soft.gestclientes.dao;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.gestclientes.model.Cliente;
public interface ClienteDAO {
    ArrayList<Cliente> listarPorNombreDNI(String nombreDNI);
}
