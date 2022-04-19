/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.lp2soft.rrhh.model;

import java.util.Date;

/**
 *
 * @author axeli
 */
public class Empleado extends Persona {
    private String cargo ; 
    private double sueldo ; 
    private boolean activo ; 
    private Area area ;
    private CuentaUsuario cuentaUsuario ;

    public Empleado (int idPersona, String DNI, String nombre, String apellidoPaterno, char genero, Date fechaNacimiento ,String cargo, double sueldo, Area area) {
        super(idPersona, DNI, nombre, apellidoPaterno, genero, fechaNacimiento);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.area = area;
    }

    
    
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public CuentaUsuario getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(CuentaUsuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }
    
    
}
