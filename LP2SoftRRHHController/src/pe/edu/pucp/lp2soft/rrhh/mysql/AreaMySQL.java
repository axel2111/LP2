/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.lp2soft.rrhh.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;

public class AreaMySQL implements AreaDAO{
    private Connection con ; 
    private Statement st ;
    private ResultSet rs ; 
    @Override
    public ArrayList<Area> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertar(Area area) {
        int resultado = 0 ; 
        int hola = 1 ; 
        try{
            //REGISTRAMOS DRIVER DE CONECCION ; 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer la conexion ;
            con = DriverManager.getConnection("jdbc:mysql://database-lp2.cdwk0pjnvpcl.us-east-1.rds.amazonaws.com:3306/lp2","admin","lp220221") ;
            
            //Ejecutar una instruccion SQL
            
            String sql = "INSERT INTO area (nombre,activo) VALUES('"+area.getNombre()+"',1)"; 
            //Creamos un objeto statement 
            st = con.createStatement(); 
            resultado = st.executeUpdate(sql) ;
            //Capturar el id generado por la bd 
            sql = "SELECT @@last_insert_id as id" ;
            rs = st.executeQuery(sql) ; 
            rs.next();
            
            area.setIdArea(rs.getInt("id"));
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        
        return resultado ;
    }

    @Override
    public int modificar(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idArea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Area listarPorId(int idArea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
