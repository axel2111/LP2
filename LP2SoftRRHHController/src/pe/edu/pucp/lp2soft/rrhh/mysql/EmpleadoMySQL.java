/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.lp2soft.rrhh.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;

public class EmpleadoMySQL implements EmpleadoDAO {
    private Connection con ;
    private Statement st ; 
    private ResultSet rs ;
    @Override
    public int insertar(Empleado empleado) {
        int resultado = 0 ;
        try{
             //REGISTRAMOS DRIVER DE CONECCION ; 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer la conexion ;
            con = DriverManager.getConnection("jdbc:mysql://database-lp2.cdwk0pjnvpcl.us-east-1.rds.amazonaws.com:3306/lp2","admin","lp220221") ;
            
            //FORMATO DE FECHA
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //Ejecutar una instruccion SQL
            
            String sql = "INSERT INTO persona (DNI,nombre,apellido_paterno,genero,fecha_nacimiento) "
                    + "VALUES('"+empleado.getDNI()+"','"+empleado.getNombre()+"','"+empleado.getApellidoPaterno()+"','"+empleado.getGenero()+"',"
                    +"'" + sdf.format(empleado.getFechaNacimiento())+"')"; 
            
            //Creamos un objeto statement 
            st = con.createStatement(); 
            st.executeUpdate(sql) ;
            //Ejectuar una instruccion para determinar el id generado
            sql = "SELECT @@last_insert_id AS id" ; 
            rs = st.executeQuery(sql) ; 
            
            //Colocamos el cursor en la primera fila de la tabla 
            rs.next() ;
            //Leer la columna id ; 
            empleado.setIdPersona(rs.getInt("id"));
            //ejecutar una instruccion para los datos propios del empleado ; 
            sql = "INSERT INTO empleado(id_empleado,fid_area, cargo,sueldo,activo)"
                    + "VALUES(" +empleado.getIdPersona()+","
                    +empleado.getArea().getIdArea()+",'"+empleado.getCargo()+"',"
                    +empleado.getSueldo()+",1)"; 
            resultado = st.executeUpdate(sql) ; 
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        
        return resultado ;
    }
    
}
