package pe.edu.pucp.lp2soft.ventas.model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.lp2soft.gestclientes.model.Cliente;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
public class OrdenVenta {
    private int idOrdenVenta;
    private double total;
    private Date fechaHora;
    private boolean activo;
    private Cliente cliente;
    private Empleado empleado;
    private ArrayList<LineaOrdenVenta> lineasOrdenVenta;

    public OrdenVenta(){
        
    }
    
    public OrdenVenta(int idOrdenVenta, Date fechaHora){
        this.idOrdenVenta = idOrdenVenta;
        this.fechaHora = fechaHora;
    }
    
    public int getIdOrdenVenta() {
        return idOrdenVenta;
    }

    public void setIdOrdenVenta(int idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ArrayList<LineaOrdenVenta> getLineasOrdenVenta() {
        return lineasOrdenVenta;
    }

    public void setLineasOrdenVenta(ArrayList<LineaOrdenVenta> lineasOrdenVenta) {
        this.lineasOrdenVenta = lineasOrdenVenta;
    }
    
    public void calcularTotal(){
        this.total = 0;
        for(LineaOrdenVenta lov : lineasOrdenVenta){
            total = total + lov.getSubtotal();
        }
    }
    
    public String devolverReporte(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String reporte = "";
        reporte = reporte + "Orden Venta N°. " + idOrdenVenta + "\n";
        reporte = reporte + "Fecha de Venta: " + sdf.format(fechaHora) + "\n";
        reporte = reporte + "---------------------------------------------------------" + "\n";
        reporte = reporte + "Cliente: " + cliente.getDNI() + " - " + cliente.getNombre() + 
                " " + cliente.getApellidoPaterno() + "\n";
        reporte = reporte + "Empleado: " + empleado.getDNI() + " - " + empleado.getNombre() +
                " " + empleado.getApellidoPaterno() + "\n";
        reporte = reporte + "---------------------------------------------------------" + "\n";
        for(LineaOrdenVenta lov : lineasOrdenVenta){
            reporte = reporte + lov.imprimirLinea() + "\n";
        }
        reporte = reporte + "---------------------------------------------------------" + "\n";
        reporte = reporte + "TOTAL: S/. " + total;
        return reporte;
    }
    
}
