
package pe.edu.pucp.lp2soft.ventas.model;

import pe.edu.pucp.lp2soft.almacen.model.Producto;

public class LineaOrdenVenta {
    private int idLineaOrdenVenta ; 
    private int cantidad ;
    private Producto producto ; 
    private double subtotal ; 
    private boolean activo   ;

    public LineaOrdenVenta(Producto producto , int cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    
    
    public int getIdLineaOrdenVenta() {
        return idLineaOrdenVenta;
    }

    public void setIdLineaOrdenVenta(int idLineaOrdenVenta) {
        this.idLineaOrdenVenta = idLineaOrdenVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
    // METODOS
    public double calcularSubtotal(){
        this.subtotal = this.cantidad * this.producto.getPrecio() ; 
        return this.subtotal ; 
    }
    public String imprimirLinea(){
        return producto.getNombre() + " "+ producto.getUnidadMedida() + " " +"s/."+ producto.getPrecio() + "x" + cantidad+" " + subtotal; 
    }
}
