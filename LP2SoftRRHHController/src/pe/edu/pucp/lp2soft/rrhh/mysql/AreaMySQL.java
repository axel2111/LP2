/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.lp2soft.rrhh.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;

public class AreaMySQL implements AreaDAO{
    private Connection con ; 
    private Statement st ;
    private ResultSet rs ; 
    private PreparedStatement ps ;
    private CallableStatement cs ;
//    @Override
//    public ArrayList<Area> listarTodas() {
//        ArrayList<Area> areas = new ArrayList<>() ; 
//        int resultado = 0 ; 
//        try{
//            REGISTRAMOS DRIVER DE CONECCION ; 
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Establecer la conexion ;
//            con = DriverManager.getConnection("jdbc:mysql://database-lp2.cdwk0pjnvpcl.us-east-1.rds.amazonaws.com:3306/lp2","admin","lp220221") ;
//            
//            st = con.createStatement(); 
//            String sql = "SELECT * FROM area WHERE activo = 1" ;
//            rs = st.executeQuery(sql) ; 
//            
//            while(rs.next()){
//                Area area = new Area() ; 
//                area.setIdArea(rs.getInt("id_area"));
//                area.setNombre(rs.getString("nombre"));
//                area.setActivo(true);
//                areas.add(area); 
//            }
//            
//            
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
//        }
//        
//        return areas ; 
//    }
    @Override
    public ArrayList<Area> listarTodas(){
        ArrayList<Area> areas = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_AREAS_TODAS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Area area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                area.setActivo(true);
                areas.add(area);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return areas ;
    }
//    @Override
//    public int insertar(Area area) {
//        int resultado = 0 ; 
//        int hola = 1 ; 
//        try{
//            //REGISTRAMOS DRIVER DE CONECCION ; 
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //Establecer la conexion ;
//            con = DriverManager.getConnection("jdbc:mysql://database-lp2.cdwk0pjnvpcl.us-east-1.rds.amazonaws.com:3306/lp2","admin","lp220221") ;
//            
//            //Ejecutar una instruccion SQL
//            
//            String sql = "INSERT INTO area (nombre,activo) VALUES('"+area.getNombre()+"',1)"; 
//            //Creamos un objeto statement 
//            st = con.createStatement(); 
//            resultado = st.executeUpdate(sql) ;
//            //Capturar el id generado por la bd 
//            sql = "SELECT @@last_insert_id as id" ;
//            rs = st.executeQuery(sql) ; 
//            rs.next();
//            
//            area.setIdArea(rs.getInt("id"));
//            
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
//        }
//        
//        return resultado ;
//    }
/*
    @Override
    public int insertar(Area area) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            String sql = "INSERT INTO area(nombre, activo) VALUES (?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, area.getNombre());
            ps.setBoolean(2, true);
            resultado = ps.executeUpdate();
            sql = "SELECT @@last_insert_id as id";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            area.setIdArea(rs.getInt("id"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    */
    @Override
    public int insertar (Area area){
        int resultado = 0 ;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_AREA(?,?)}");
            cs.registerOutParameter("_id_area", java.sql.Types.INTEGER);
            cs.setString("_nombre", area.getNombre());
            cs.executeUpdate();
            area.setIdArea(cs.getInt("_id_area"));
            resultado = 1 ; 
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        
        return resultado ; 
    }
    
    @Override
    public int modificar(Area area) {
        int resultado = 0 ; 
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_AREA(?,?)}");
            cs.setInt("_id_area", area.getIdArea());
            cs.setString("_nombre",area.getNombre());
            cs.executeUpdate();
            resultado = 1; 
            
        }catch (Exception ex ){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        
        return resultado ; 
    }

    @Override
    public int eliminar(int idArea) {
        int resultado = 0 ; 
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_AREA(?)}");
            cs.setInt("_id_area", idArea);
            cs.executeUpdate();
            resultado = 1; 
            
        }catch (Exception ex ){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        
        return resultado ; 
    }

    @Override
    public Area buscarPorId(int idArea) {
        Area area = null ; 
        int resultado = 0 ; 
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call BUSCAR_AREA_POR_ID(?)}");   
            cs.setInt("_id_area", idArea);
            rs = cs.executeQuery();
            if (rs.next()){
                area = new Area();
                area.setIdArea(idArea);
                area.setNombre(rs.getString("nombre"));
                area.setActivo(true);
            }
            resultado = 1 ;
            
        }catch (Exception ex ){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        
        return area ; 
    }

    
}
