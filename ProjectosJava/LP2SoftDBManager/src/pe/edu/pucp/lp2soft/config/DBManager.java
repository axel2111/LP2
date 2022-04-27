/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.lp2soft.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author axeli
 */
public class DBManager {
    private static DBManager dbManager ;
    private String url = "jdbc:mysql://database-lp2.cdwk0pjnvpcl.us-east-1.rds.amazonaws.com:3306/lp2" ;
    private String user = "admin";
    private String password = "lp220221" ;
    private Connection con ; 
    
    public Connection getConnection(){
        try {
            //Registrar el drive de conexion 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer conexion ; 
            con = DriverManager.getConnection(url,user,password);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con ; 
    }
    
    private synchronized static void createInstance(){
        if(dbManager == null){
            dbManager = new DBManager();
        }
    }
    
    public static DBManager getInstance(){
        if(dbManager == null){
            createInstance();
        }
        return dbManager ;
    }
}
