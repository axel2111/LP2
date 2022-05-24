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
    public class AreaMySQL : AreaDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        
        public Area buscarporId(int idArea)
        {
            throw new NotImplementedException();
        }

        public int eliminar(int idArea)
        {
            throw new NotImplementedException();
        }

        public int insertar(Area area)
        {
            int resultado = 0;
            try
            {
                //Creamos el objeto de conexión
                con = DBManager.Instance.getConnection();
                //Abrimos la conexión
                con.Open();
                //Establecemos la instrucción SQL
                comando = new MySqlCommand();
                //Indicamos la conexión que debe utilizarse para la instrucción SQL
                comando.Connection = con;
                //Indicamos la instrucción
                comando.CommandText = "INSERT INTO area(nombre," +
                    "fecha_registro,ultima_modificacion,activo) values" +
                    "('"+area.Nombre+ "',now() - INTERVAL 5 HOUR,now() - INTERVAL 5 HOUR,1);";
                //Ejecutamos la instrucción
                comando.ExecuteNonQuery();
                //Cambiamos la instrucción para leer el id generado
                comando.CommandText = "SELECT @@last_insert_id as id";
                //Ejecutamos la lectura del SELECT
                lector = comando.ExecuteReader();
                //Nos ubicamos en la primera fila
                lector.Read();
                //Leemos la columna id que contiene el id generado
                area.IdArea = lector.GetInt32("id");
                resultado = 1;
            }catch(Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                //Cerramos la conexion
                try { con.Close(); } catch (Exception ex) { throw new Exception(ex.Message); }
            }
            return resultado;
        }

        public BindingList<Area> listarTodas()
        {
            BindingList<Area> areas = new BindingList<Area>();
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_AREAS_TODAS";
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Area area = new Area();
                    area.IdArea = lector.GetInt32("id_area");
                    area.Nombre = lector.GetString("nombre");
                    area.Activo = true;
                    areas.Add(area);
                }
            }catch(Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                try { con.Close(); } catch (Exception ex) { throw new Exception(ex.Message); }
            }
            return areas;
        }

        public int modificar(Area area)
        {
            throw new NotImplementedException();
        }
    }
}
