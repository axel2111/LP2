/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.lp2soft.almacen.model;

import java.util.ArrayList;
import pe.edu.pucp.lp2soft.ventas.model.OrdenVenta;

/**
 *
 * @author axeli
 */
public class Producto {
    private int idProducto;
    private ArrayList<OrdenVenta>ordenesVenta ;
    private String nombre ;
    private String unidadMedida ; 
    private double precio ; 
    private boolean activo ; 

    public Producto(int idProducto, String nombre, String unidadMedida, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public ArrayList<OrdenVenta> getOrdenesVenta() {
        return ordenesVenta;
    }

    public void setOrdenesVenta(ArrayList<OrdenVenta> ordenesVenta) {
        this.ordenesVenta = ordenesVenta;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
