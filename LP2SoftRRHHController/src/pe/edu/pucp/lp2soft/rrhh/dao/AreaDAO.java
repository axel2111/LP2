/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.lp2soft.rrhh.dao;

import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.model.Area;

public interface AreaDAO {
    ArrayList<Area> listarTodas ();
    int insertar (Area area);
    int modificar (Area area );
    int eliminar (int idArea );
    Area listarPorId (int idArea );
}
