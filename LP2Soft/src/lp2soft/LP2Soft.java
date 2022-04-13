/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lp2soft;

import pe.edu.pucp.lp2soft.rrhh.model.Persona;

/**
 *
 * @author axeli
 */
public class LP2Soft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Axel");
        p.prueba = 10 ; 
        System.out.println(p.getNombre());
        
    }
    
}
