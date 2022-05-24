using LP2SoftDBManager;
using LP2SoftRRHHController.DAO;
using LP2SoftRRHHModel;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2SoftRRHHController.MySQL
{
    public class CuentaUsuarioMySQL : CuentaUsuarioDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;

        public int insertar(CuentaUsuario cuentaUsuario)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "INSERTAR_CUENTA_USUARIO";
                comando.Parameters.Add("_id_cuenta_usuario", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;
                comando.Parameters.AddWithValue("_username",cuentaUsuario.Username);
                comando.Parameters.AddWithValue("_password", cuentaUsuario.Password);
                comando.ExecuteNonQuery();
                cuentaUsuario.IdCuentaUsuario = Int32.Parse(comando.Parameters["_id_cuenta_usuario"].Value.ToString());
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
    }
}
