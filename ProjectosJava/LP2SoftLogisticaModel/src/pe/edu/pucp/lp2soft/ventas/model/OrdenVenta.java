/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.lp2soft.ventas.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.lp2soft.gestclientes.model.Cliente;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;

public class OrdenVenta {
    private int idOrdenVenta ; 
    private double total ; 
    private boolean activo ; 
    private Date fechaHora ;
    
    private Cliente cliente ;
    private Empleado empleado ; 
    
    private ArrayList <LineaOrdenVenta> lineasOrdenVenta ;

    public OrdenVenta(int idOrdenVenta, Date fechaHora) {
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
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

  
    public void calcularTotalySubtotales(){
        this.total = 0 ;
        for(LineaOrdenVenta lov:lineasOrdenVenta){
            total = total + lov.calcularSubtotal(); 
        }
    }
    
    public String devolverReporte(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String reporte = "" ;
        reporte = reporte + "Orden venta N" + idOrdenVenta + "\n" ;
        reporte = reporte + "Fecha de Venta" + sdf.format(fechaHora) + "\n" ;
        reporte = reporte + "------------------------------------\n" ;
        reporte =reporte + "Cliente:" +  cliente.getDNI() + "-" + cliente.getNombre() + "-" + cliente.getApellidoPaterno() + "\n";
        reporte = reporte + "Empleado: " + empleado.getDNI() + "-"+ empleado.getNombre() + "-" + empleado.getApellidoPaterno() + "\n";
        
        reporte = reporte + " -------------------------------\n" ; 
        
        for (LineaOrdenVenta lov:lineasOrdenVenta){
            reporte = reporte + lov.imprimirLinea() + "\n";
        }
        reporte = reporte + " ---------------------\n" ; 
        reporte = reporte + "TOTAL: S/. " + total + "\n"; 
        
        
        return reporte;  
    }
    
}
