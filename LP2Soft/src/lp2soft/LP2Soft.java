/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lp2soft;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.almacen.model.Producto;
import pe.edu.pucp.lp2soft.gestclientes.model.Categoria;
import pe.edu.pucp.lp2soft.gestclientes.model.Cliente;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import pe.edu.pucp.lp2soft.rrhh.mysql.AreaMySQL;
import pe.edu.pucp.lp2soft.rrhh.mysql.EmpleadoMySQL;
import pe.edu.pucp.lp2soft.ventas.model.LineaOrdenVenta;
import pe.edu.pucp.lp2soft.ventas.model.OrdenVenta;


/**
 *
 * @author axeli
 */

public class LP2Soft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        OrdenVenta venta1 = new OrdenVenta(1,sdf.parse("13-04-2022"));
        
        Cliente cliente1 = new Cliente(3000.00 , Categoria.Clasico,1,"28732829" , "Juan" ,"Perez" , 'M' , sdf.parse("01-01-1998")) ;
        Empleado empleado1 = new Empleado(1, "70201022", "Luis", "Ramirez", 'M', sdf.parse("01-01-1966"), "Vendedor", 2000.00, new Area("ventas"));
        
        
        venta1.setEmpleado(empleado1) ;
        venta1.setCliente(cliente1);
        
        Producto prod1 = new Producto(1,"Coca cola","1L" , 3.00);
        Producto prod2 = new Producto(2,"LavaVajillas","1kg" , 7.50);
        
        LineaOrdenVenta lov1 = new LineaOrdenVenta (3,prod1 ) ; 
        LineaOrdenVenta lov2 = new LineaOrdenVenta (2 , prod2); 
        
        venta1.setLineasOrdenVenta(new ArrayList<>()); // inicializar
        venta1.getLineasOrdenVenta().add(lov1);
        venta1.getLineasOrdenVenta().add(lov2);
        
        
        venta1.calcularTotalYSubtotales();
        String reporte = venta1.devolverReporte();
        
        System.out.println(reporte); 
        //Crear un area 
        Area area1 = new Area("CONTABILIDAD") ;
        //CREAMOS UN DAO DE CONEXION
        AreaDAO daoArea = new AreaMySQL() ; 
        //INsertamos en la Base de datos ; 
        int resultado = daoArea.insertar(area1);
        if (resultado == 1 ){
            System.out.println("Se ha insertado correctamente el area");
        }else {
            System.out.println("NO se ha insertado el area");
        }
        empleado1.setArea(area1);
        EmpleadoDAO daoEmpleado = new EmpleadoMySQL() ;
        // insertamos el empleado 
        
        int resultado2 = daoEmpleado.insertar(empleado1) ;
        if (resultado2 == 1 ){
            System.out.println("Se ha insertado correctamente el empleado");
        }else {
            System.out.println("NO se ha insertado el empleado");
        }
        
        
        ArrayList<Area> areas = daoArea.listarTodas();
        
        for(int i = 0 ; i < areas.size() ; i++){
            System.out.println(areas.get(i).getIdArea() + " " + areas.get(i).getNombre() + "\n");
        }
    }
    
}
