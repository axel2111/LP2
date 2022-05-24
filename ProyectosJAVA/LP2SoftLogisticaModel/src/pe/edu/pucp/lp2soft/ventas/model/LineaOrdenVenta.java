package pe.edu.pucp.lp2soft.ventas.model;
import pe.edu.pucp.lp2soft.almacen.model.Producto;
public class LineaOrdenVenta {
    private int ideLineaOrdenVenta;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    private boolean activo;

    public LineaOrdenVenta(){}
    
    public LineaOrdenVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public int getIdeLineaOrdenVenta() {
        return ideLineaOrdenVenta;
    }

    public void setIdeLineaOrdenVenta(int ideLineaOrdenVenta) {
        this.ideLineaOrdenVenta = ideLineaOrdenVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void calcularSubtotal(){
        subtotal = cantidad * producto.getPrecio();
    }
    
    public String imprimirLinea(){
        return producto.getNombre() + " " + producto.getUnidadMedida() + " - "+
                "S/. " + producto.getPrecio() + " x " + cantidad + " unid. - S/." + 
                subtotal;
    }
}
