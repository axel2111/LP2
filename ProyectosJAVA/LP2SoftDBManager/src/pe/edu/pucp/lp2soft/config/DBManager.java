package pe.edu.pucp.lp2soft.config;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBManager {
    private static DBManager dbManager;
    private String url = "jdbc:mysql://database-lp2.cre3dummjuet.us-east-1.rds.amazonaws.com:3306/lp2";
    private String user = "admin";
    private String password = "lp220221";
    private Connection con;
    
    public Connection getConnection(){
        try{
            //Registrar el driver de conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer la conexion
            con = DriverManager.getConnection(url,user,password);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    private synchronized static void createInstance(){
        if(dbManager == null){
            dbManager = new DBManager();
        }
    }
    
    public static DBManager getInstance(){
        if(dbManager == null)
            createInstance();
        return dbManager;
    }
}