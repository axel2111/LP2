package pe.edu.pucp.lp2soft.rrhh.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
import pe.edu.pucp.lp2soft.rrhh.model.CuentaUsuario;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
public class EmpleadoMySQL implements EmpleadoDAO{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private CallableStatement cs;
    
//    @Override
//    public int insertar(Empleado empleado) {
//        int resultado = 0;
//        try{
//            //Registramos el Driver de conexión
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //Establecer la conexión
//            con = DriverManager.getConnection(
//                    "jdbc:mysql://database-lp2.cre3dummjuet.us-east-1.rds.amazonaws.com:3306/lp2", 
//                    "admin", "lp220221");
//            //Formato de fecha
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            //Ejecutar una instrucción SQL
//            String sql = "INSERT INTO persona(DNI,nombre,apellido_paterno,genero,fecha_nacimiento) "
//                    + "VALUES ('"+empleado.getDNI()+"','"+empleado.getNombre()+"',"
//                    + "'"+empleado.getApellidoPaterno()+"','"+empleado.getGenero()+"',"
//                    + "'"+sdf.format(empleado.getFechaNacimiento())+"')";
//            st = con.createStatement();
//            st.executeUpdate(sql);
//            //Ejecutar una instrucción para determinar el id generado
//            sql = "SELECT @@last_insert_id AS id";
//            rs = st.executeQuery(sql);
//            //Colocamos el cursor de lectura en la primera fila de la tabla
//            rs.next();
//            //Leer la columna id
//            empleado.setIdPersona(rs.getInt("id"));
//            //Ejecutar una instrucción para los datos propios del empleado
//            sql = "INSERT INTO empleado(id_empleado,fid_area,fid_cuenta_usuario,cargo,sueldo,activo) "
//                    + "values("+empleado.getIdPersona()+","
//                    + empleado.getArea().getIdArea() + "," + empleado.getCuentaUsuario().getIdCuentaUsuario() + ","
//                    + "'" + empleado.getCargo() + "'," + empleado.getSueldo()
//                    +",1)";
//            resultado = st.executeUpdate(sql);
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
//        }
//        return resultado;
//    }

    /*
    @Override
    public int insertar(Empleado empleado){
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            String sql = "INSERT INTO persona(DNI,nombre,"
                    + "apellido_paterno,genero,fecha_nacimiento) "
                    + "VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getDNI());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellidoPaterno());
            ps.setString(4, String.valueOf(empleado.getGenero()));
            ps.setDate(5, new java.sql.Date(
                    empleado.getFechaNacimiento().getTime()));
            ps.executeUpdate();
            sql = "SELECT @@last_insert_id as id";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            empleado.setIdPersona(rs.getInt("id"));
            sql = "INSERT INTO empleado(id_empleado,fid_area,"
                    + "fid_cuenta_usuario,cargo,sueldo,activo) "
                    + "VALUES(?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setInt(1, empleado.getIdPersona());
            ps.setInt(2, empleado.getArea().getIdArea());
            ps.setInt(3, empleado.getCuentaUsuario().getIdCuentaUsuario());
            ps.setString(4, empleado.getCargo());
            ps.setDouble(5, empleado.getSueldo());
            ps.setBoolean(6, true);
            resultado = ps.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    */
    
    @Override
    public int insertar(Empleado empleado){
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_EMPLEADO(?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_persona", java.sql.Types.INTEGER);
            cs.setInt("_fid_area", empleado.getArea().getIdArea());
            cs.setInt("_fid_cuenta_usuario", empleado.getCuentaUsuario().getIdCuentaUsuario());
            cs.setString("_DNI",empleado.getDNI());
            cs.setString("_nombre",empleado.getNombre());
            cs.setString("_apellido_paterno",empleado.getApellidoPaterno());
            cs.setString("_genero", String.valueOf(empleado.getGenero()));
            cs.setDate("_fecha_nacimiento",new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            cs.setString("_cargo",empleado.getCargo());
            cs.setDouble("_sueldo",empleado.getSueldo());
            
            cs.executeUpdate();
            empleado.setIdPersona(cs.getInt("_id_persona"));
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
    @Override
    public int modificar(Empleado empleado){
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_EMPLEADO(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_persona", empleado.getIdPersona());
            cs.setInt("_fid_area", empleado.getArea().getIdArea());
            cs.setInt("_fid_cuenta_usuario", empleado.getCuentaUsuario().getIdCuentaUsuario());
            cs.setString("_DNI",empleado.getDNI());
            cs.setString("_nombre",empleado.getNombre());
            cs.setString("_apellido_paterno",empleado.getApellidoPaterno());
            cs.setString("_genero", String.valueOf(empleado.getGenero()));
            cs.setDate("_fecha_nacimiento",new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            cs.setString("_cargo",empleado.getCargo());
            cs.setDouble("_sueldo",empleado.getSueldo());
            cs.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
    @Override
    public int eliminar(int idEmpleado){
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_EMPLEADO(?)}");
            cs.setInt("_id_persona", idEmpleado);
            cs.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
    @Override
    public ArrayList<Empleado> listarTodos(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_EMPLEADOS_TODOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
               Empleado empleado = new Empleado();
               empleado.setIdPersona(rs.getInt("id_persona"));
               empleado.setDNI(rs.getString("DNI"));
               empleado.setNombre(rs.getString("nombre"));
               empleado.setApellidoPaterno(rs.getString("apellido_paterno"));
               empleado.setGenero(rs.getString("genero").charAt(0));
               empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
               empleado.setCargo(rs.getString("cargo"));
               empleado.setSueldo(rs.getDouble("sueldo"));
               empleado.setActivo(true);
               empleado.setArea(new Area());
               empleado.getArea().setIdArea(rs.getInt("id_area"));
               empleado.getArea().setNombre(rs.getString("nombre_area"));
               empleado.getArea().setActivo(true);
               empleado.setCuentaUsuario(new CuentaUsuario());
               empleado.getCuentaUsuario().setIdCuentaUsuario(rs.getInt("id_cuenta_usuario"));
               empleado.getCuentaUsuario().setUsername(rs.getString("username"));
               empleado.getCuentaUsuario().setPassword(rs.getString("password"));
               empleado.getCuentaUsuario().setActivo(true);
               empleados.add(empleado);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return empleados;
    }

    @Override
    public ArrayList<Empleado> listarPorNombre(String nombre) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_EMPLEADOS_X_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
               Empleado empleado = new Empleado();
               empleado.setIdPersona(rs.getInt("id_persona"));
               empleado.setDNI(rs.getString("DNI"));
               empleado.setNombre(rs.getString("nombre"));
               empleado.setApellidoPaterno(rs.getString("apellido_paterno"));
               empleado.setGenero(rs.getString("genero").charAt(0));
               empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
               empleado.setCargo(rs.getString("cargo"));
               empleado.setSueldo(rs.getDouble("sueldo"));
               empleado.setActivo(true);
               empleado.setArea(new Area());
               empleado.getArea().setIdArea(rs.getInt("id_area"));
               empleado.getArea().setNombre(rs.getString("nombre_area"));
               empleado.getArea().setActivo(true);
               empleado.setCuentaUsuario(new CuentaUsuario());
               empleado.getCuentaUsuario().setIdCuentaUsuario(rs.getInt("id_cuenta_usuario"));
               empleado.getCuentaUsuario().setUsername(rs.getString("username"));
               empleado.getCuentaUsuario().setPassword(rs.getString("password"));
               empleado.getCuentaUsuario().setActivo(true);
               empleados.add(empleado);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return empleados;
    }
}