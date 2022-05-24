using LP2SoftDBManager;
using LP2SoftRRHHController.DAO;
using LP2SoftRRHHModel;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2SoftRRHHController.MySQL
{
    public class EmpleadoMySQL : EmpleadoDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public int insertar(Empleado empleado)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "INSERTAR_EMPLEADO";
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("_id_persona", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;
                comando.Parameters.AddWithValue("_fid_area", empleado.Area.IdArea);
                comando.Parameters.AddWithValue("_fid_cuenta_usuario", empleado.CuentaUsuario.IdCuentaUsuario);
                comando.Parameters.AddWithValue("_DNI", empleado.DNI);
                comando.Parameters.AddWithValue("_nombre", empleado.Nombre);
                comando.Parameters.AddWithValue("_apellido_paterno", empleado.ApellidoPaterno);
                comando.Parameters.AddWithValue("_genero", empleado.Genero);
                comando.Parameters.AddWithValue("_fecha_nacimiento", empleado.FechaNacimiento);
                comando.Parameters.AddWithValue("_cargo", empleado.Cargo);
                comando.Parameters.AddWithValue("_sueldo", empleado.Sueldo);
                comando.ExecuteNonQuery();
                empleado.IdPersona = Int32.Parse(comando.Parameters["_id_persona"].Value.ToString());
                resultado = 1;
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                try { con.Close(); } catch (Exception ex) { throw new Exception(ex.Message); }
            }
            return resultado;
        }

        public int modificar(Empleado empleado)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "MODIFICAR_EMPLEADO";
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.AddWithValue("_id_persona", empleado.IdPersona);
                comando.Parameters.AddWithValue("_fid_area", empleado.Area.IdArea);
                comando.Parameters.AddWithValue("_fid_cuenta_usuario", empleado.CuentaUsuario.IdCuentaUsuario);
                comando.Parameters.AddWithValue("_DNI", empleado.DNI);
                comando.Parameters.AddWithValue("_nombre", empleado.Nombre);
                comando.Parameters.AddWithValue("_apellido_paterno", empleado.ApellidoPaterno);
                comando.Parameters.AddWithValue("_genero", empleado.Genero);
                comando.Parameters.AddWithValue("_fecha_nacimiento", empleado.FechaNacimiento);
                comando.Parameters.AddWithValue("_cargo", empleado.Cargo);
                comando.Parameters.AddWithValue("_sueldo", empleado.Sueldo);
                comando.ExecuteNonQuery();
                resultado = 1;
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                try { con.Close(); } catch (Exception ex) { throw new Exception(ex.Message); }
            }
            return resultado;
        }

        public int eliminar(int idEmpleado)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "ELIMINAR_EMPLEADO";
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.AddWithValue("_id_persona", idEmpleado);
                comando.ExecuteNonQuery();
                resultado = 1;
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                try { con.Close(); } catch (Exception ex) { throw new Exception(ex.Message); }
            }
            return resultado;
        }

        public BindingList<Empleado> listarTodos()
        {
            BindingList<Empleado> empleados = new BindingList<Empleado>();
            try{
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "LISTAR_EMPLEADOS_TODOS";
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Empleado empleado = new Empleado();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_persona"))) empleado.IdPersona = lector.GetInt32("id_persona");
                    if (!lector.IsDBNull(lector.GetOrdinal("DNI"))) empleado.DNI = lector.GetString("DNI");
                    if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) empleado.Nombre = lector.GetString("nombre");
                    if (!lector.IsDBNull(lector.GetOrdinal("apellido_paterno"))) empleado.ApellidoPaterno = lector.GetString("apellido_paterno");
                    if (!lector.IsDBNull(lector.GetOrdinal("genero"))) empleado.Genero = lector.GetChar("genero");
                    if (!lector.IsDBNull(lector.GetOrdinal("fecha_nacimiento"))) empleado.FechaNacimiento = lector.GetDateTime("fecha_nacimiento");
                    if (!lector.IsDBNull(lector.GetOrdinal("sueldo"))) empleado.Sueldo = lector.GetDouble("sueldo");
                    if (!lector.IsDBNull(lector.GetOrdinal("cargo"))) empleado.Cargo = lector.GetString("cargo");

                    empleado.Area = new Area();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_area"))) empleado.Area.IdArea = lector.GetInt32("id_area");
                    if (!lector.IsDBNull(lector.GetOrdinal("nombre_area"))) empleado.Area.Nombre = lector.GetString("nombre_area");
                    empleado.Area.Activo = true;

                    empleado.CuentaUsuario = new CuentaUsuario();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_cuenta_usuario"))) empleado.CuentaUsuario.IdCuentaUsuario = lector.GetInt32("id_cuenta_usuario");
                    if (!lector.IsDBNull(lector.GetOrdinal("username"))) empleado.CuentaUsuario.Username = lector.GetString("username");
                    if (!lector.IsDBNull(lector.GetOrdinal("password"))) empleado.CuentaUsuario.Password = lector.GetString("password");
                    empleado.CuentaUsuario.Activo = true;

                    empleados.Add(empleado);
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                try { con.Close(); } catch (Exception ex) { throw new Exception(ex.Message); }
            }
            return empleados;
        }

        public BindingList<Empleado> listarPorNombre(string nombre)
        {
            BindingList<Empleado> empleados = new BindingList<Empleado>();
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "LISTAR_EMPLEADOS_X_NOMBRE";
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.AddWithValue("_nombre",nombre);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Empleado empleado = new Empleado();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_persona"))) empleado.IdPersona = lector.GetInt32("id_persona");
                    if (!lector.IsDBNull(lector.GetOrdinal("DNI"))) empleado.DNI = lector.GetString("DNI");
                    if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) empleado.Nombre = lector.GetString("nombre");
                    if (!lector.IsDBNull(lector.GetOrdinal("apellido_paterno"))) empleado.ApellidoPaterno = lector.GetString("apellido_paterno");
                    if (!lector.IsDBNull(lector.GetOrdinal("genero"))) empleado.Genero = lector.GetChar("genero");
                    if (!lector.IsDBNull(lector.GetOrdinal("fecha_nacimiento"))) empleado.FechaNacimiento = lector.GetDateTime("fecha_nacimiento");
                    if (!lector.IsDBNull(lector.GetOrdinal("sueldo"))) empleado.Sueldo = lector.GetDouble("sueldo");
                    if (!lector.IsDBNull(lector.GetOrdinal("cargo"))) empleado.Cargo = lector.GetString("cargo");

                    empleado.Area = new Area();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_area"))) empleado.Area.IdArea = lector.GetInt32("id_area");
                    if (!lector.IsDBNull(lector.GetOrdinal("nombre_area"))) empleado.Area.Nombre = lector.GetString("nombre_area");
                    empleado.Area.Activo = true;

                    empleado.CuentaUsuario = new CuentaUsuario();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_cuenta_usuario"))) empleado.CuentaUsuario.IdCuentaUsuario = lector.GetInt32("id_cuenta_usuario");
                    if (!lector.IsDBNull(lector.GetOrdinal("username"))) empleado.CuentaUsuario.Username = lector.GetString("username");
                    if (!lector.IsDBNull(lector.GetOrdinal("password"))) empleado.CuentaUsuario.Password = lector.GetString("password");
                    empleado.CuentaUsuario.Activo = true;

                    empleados.Add(empleado);
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                try { con.Close(); } catch (Exception ex) { throw new Exception(ex.Message); }
            }
            return empleados;
        }
    }
}