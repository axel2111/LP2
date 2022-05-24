package pe.edu.pucp.lp2soft.gestclientes.model;
import java.util.Date;
import pe.edu.pucp.lp2soft.rrhh.model.Persona;
public class Cliente extends Persona{
    private double lineaCredito;
    private Categoria categoria;
    private boolean activo;

    public Cliente(){}
    
    public Cliente(int idPersona, String DNI, String nombre, String apellidoPaterno, char genero, Date fechaNacimiento, double lineaCredito, Categoria categoria) {
        super(idPersona, DNI, nombre, apellidoPaterno, genero, fechaNacimiento);
        this.lineaCredito = lineaCredito;
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public double getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(double lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}