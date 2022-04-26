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
import pe.edu.pucp.lp2soft.rrhh.dao.CuentaUsuarioDAO;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
import pe.edu.pucp.lp2soft.rrhh.model.CuentaUsuario;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import pe.edu.pucp.lp2soft.rrhh.mysql.AreaMySQL;
import pe.edu.pucp.lp2soft.rrhh.mysql.CuentaUsuarioMySQL;
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
        //Se crea una venta
        OrdenVenta venta1 = new OrdenVenta(1,sdf.parse("13-04-2022"));
        //Se crea un cliente
        Cliente cliente1 = 
        new Cliente(1, "28732829", "JUAN", "PEREZ", 'M', 
                sdf.parse("01-01-1998"),3000.00,Categoria.Clasico);
        //Se crea un empleado
        Empleado empleado1 = 
                new Empleado(1, "72625210", "MARIA", "FERNANDEZ", 'F', 
                sdf.parse("15-08-1994"),"CAJERA",4000.00);
        //Se asocia al empleado que registró la venta
        venta1.setEmpleado(empleado1);
        //Se asocia al cliente que efectuó la venta
        venta1.setCliente(cliente1);
        //Se crean productos
        Producto prod1 = new Producto(1,"Coca cola","1L",3.00);
        Producto prod2 = new Producto(2,"Lavavajillas Sapolio","400 grs",7.50);
        //Se crean las lineas de la venta
        LineaOrdenVenta lov1 = new LineaOrdenVenta(prod1,3);
        LineaOrdenVenta lov2 = new LineaOrdenVenta(prod2,2);
        //Se asocian las lineas a la venta
        venta1.setLineasOrdenVenta(new ArrayList<>());
        venta1.getLineasOrdenVenta().add(lov1);
        venta1.getLineasOrdenVenta().add(lov2);
        //Se calculan los subtotales y el total
        venta1.calcularTotalySubtotales();
        //Se genera un reporte
        String reporte = venta1.devolverReporte();
        //Se imprime el reporte
        System.out.println(reporte);
        
        //Creamos una cuenta de usuario
        CuentaUsuario cu1 = new CuentaUsuario("mfernandez","123456");
        //Creamos un dao de conexion para gestionar cuentas
        CuentaUsuarioDAO daoCuentaUsuario = new CuentaUsuarioMySQL();
        //Insertamos la cuenta de usuario
        int resultado = daoCuentaUsuario.insertar(cu1);
        if(resultado == 1)
            System.out.println("Se ha insertado correctamente la cuenta de usuario");
        else
            System.out.println("Ha ocurrido un error al momento de insertar la cuenta de usuario");
        
        //Crear un area
        Area area1 = new Area("VENTAS");
        Area area2 = new Area("FINANZAS");
        //Creamos un dao de conexión
        AreaDAO daoArea = new AreaMySQL();
        //Insertamos el area en la base de datos
        resultado = daoArea.insertar(area1);
        daoArea.insertar(area2);
        //Verificando la inserción en la base de datos
        if(resultado==1)
            System.out.println("Se ha insertado correctamente el area");
        else
            System.out.println("Ha ocurrido un error al momento de insertar el area");
        
        //Asociamos el area y la cuenta de usuario al empleado que queremos registrar
        empleado1.setArea(area1);
        empleado1.setCuentaUsuario(cu1);
        
        //Creamos un dao de conexión para Empleados
        EmpleadoDAO daoEmpleado = new EmpleadoMySQL();
        //Insertamos el empleado
        resultado = daoEmpleado.insertar(empleado1);
        if(resultado==1)
            System.out.println("Se ha insertado correctamente el empleado");
        else
            System.out.println("Ha ocurrido un error al momento de insertar el empleado");
    
        //Listando todas las areas registradas
        ArrayList<Area> areas = daoArea.listarTodas();
        //for(Area a : areas){
        //}
        for(int i=0;i<areas.size();i++){
            System.out.println(areas.get(i).getIdArea() + ". " + 
                    areas.get(i).getNombre());
        }
        
        //Modificando la segunda area
        areas.get(1).setNombre("CONTABILIDAD");
        resultado = daoArea.modificar(areas.get(1));
        if(resultado == 1)
            System.out.println("Se ha modificado el area de id = " + areas.get(1).getIdArea());
        
        //Listando nuevamente todas las areas registradas
        areas = daoArea.listarTodas();
        for(int i=0;i<areas.size();i++){
            System.out.println(areas.get(i).getIdArea() + ". " + 
                    areas.get(i).getNombre());
        }
        
        //Obteniendo un area por id
        Area area = daoArea.buscarPorId(areas.get(1).getIdArea());
        if(area!=null){
            System.out.println("Se ha obtenido referencia al area de id = " + areas.get(1).getIdArea());
            System.out.println(area.getIdArea()+". "+area.getNombre());
        }
        //Eliminando el area
        if(area!=null)
            resultado = daoArea.eliminar(area.getIdArea());
        if(resultado==1)
            System.out.println("Se ha eliminado el area de id = "+area.getIdArea());
        
        //Listando las areas
        areas = daoArea.listarTodas();
        for(int i=0;i<areas.size();i++){
            System.out.println(areas.get(i).getIdArea() + ". " + 
                    areas.get(i).getNombre());
        }
    }
    
}
