/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pe.edu.pucp.lp2soft.rrhh.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.CuentaUsuarioDAO;
import pe.edu.pucp.lp2soft.rrhh.model.CuentaUsuario;

/**
 *
 * Axel Romero (20172469)
 */
public class CuentaUsuarioMySQL implements CuentaUsuarioDAO {
    
    private Connection con ; 
    private Statement st ; 
    private ResultSet rs ;
    private PreparedStatement ps ;
    @Override
    public int insertar(CuentaUsuario cuentaUsuario) {
        int resultado = 0 ; 
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "INSERT INTO cuenta_usuario(username , password, activo) VALUES(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, cuentaUsuario.getUsername());
            ps.setString(2, cuentaUsuario.getPassword());
            ps.setBoolean(3, true);
            ps.executeUpdate();
            sql = "SELECT @@last_insert_id as id";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next(); 
            cuentaUsuario.setIdCuentaUsuario(rs.getInt("id"));
            resultado = 1; 
            
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        
        return resultado ; 
        
    }
    
    
}
