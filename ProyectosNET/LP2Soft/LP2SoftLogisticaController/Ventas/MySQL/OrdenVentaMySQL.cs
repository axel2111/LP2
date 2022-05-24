using LP2SoftDBManager;
using LP2SoftGestClientesModel;
using LP2SoftLogisticaController.Ventas.DAO;
using LP2SoftLogisticaModel.Ventas;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2SoftLogisticaController.Ventas.MySQL
{
    public class OrdenVentaMySQL : OrdenVentaDAO
    {

        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;

        public int insertar(OrdenVenta ordenVenta)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "INSERTAR_ORDEN_VENTA";
                comando.Parameters.Add("_id_orden_venta", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;
                comando.Parameters.AddWithValue("_fid_cliente", ordenVenta.Cliente.IdPersona);
                comando.Parameters.AddWithValue("_fid_empleado", ordenVenta.Empleado.IdPersona);
                comando.Parameters.AddWithValue("_total", ordenVenta.Total);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.ExecuteNonQuery();
                ordenVenta.IdOrdenVenta =
                    Int32.Parse(comando.Parameters["_id_orden_venta"].Value.ToString());
                foreach (LineaOrdenVenta lov in ordenVenta.LineasOrdenVenta)
                {
                    comando = new MySqlCommand();
                    comando.Connection = con;
                    comando.CommandText = "INSERTAR_LINEA_ORDEN_VENTA";
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("_id_linea_orden_venta", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;
                    comando.Parameters.AddWithValue("_fid_orden_venta", ordenVenta.IdOrdenVenta);
                    comando.Parameters.AddWithValue("_fid_producto", lov.Producto.IdProducto);
                    comando.Parameters.AddWithValue("_cantidad", lov.Cantidad);
                    comando.Parameters.AddWithValue("_subtotal", lov.Subtotal);
                    comando.ExecuteNonQuery();
                    lov.IdLineaOrdenVenta =
                    Int32.Parse(comando.Parameters["_id_linea_orden_venta"].Value.ToString());
                }
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

        public BindingList<OrdenVenta> listarPorIdDNINombreCliente(string idDNINombreCliente)
        {
            BindingList<OrdenVenta> ordenesVenta = new BindingList<OrdenVenta>();
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "LISTAR_ORDENES_VENTA_X_ID_NOMBRE_DNI_CLIENTE";
                comando.Parameters.AddWithValue("_idDniNombreCliente", idDNINombreCliente);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    OrdenVenta ordenVenta = new OrdenVenta();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_orden_venta"))) ordenVenta.IdOrdenVenta = lector.GetInt32("id_orden_venta");
                    ordenVenta.Cliente = new Cliente();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_cliente"))) ordenVenta.Cliente.IdPersona = lector.GetInt32("id_cliente");
                    if (!lector.IsDBNull(lector.GetOrdinal("DNI"))) ordenVenta.Cliente.DNI = lector.GetString("DNI");
                    if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) ordenVenta.Cliente.Nombre = lector.GetString("nombre");
                    if (!lector.IsDBNull(lector.GetOrdinal("apellido_paterno"))) ordenVenta.Cliente.ApellidoPaterno = lector.GetString("apellido_paterno");
                    if (!lector.IsDBNull(lector.GetOrdinal("fecha_hora_registro"))) ordenVenta.FechaHora = lector.GetDateTime("fecha_hora_registro");
                    if (!lector.IsDBNull(lector.GetOrdinal("total"))) ordenVenta.Total = lector.GetDouble("total");
                    ordenesVenta.Add(ordenVenta);
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
            return ordenesVenta;
        }

        public int modificar(OrdenVenta ordenVenta)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "MODIFICAR_ORDEN_VENTA";
                comando.Parameters.AddWithValue("_id_orden_venta", ordenVenta.IdOrdenVenta);
                comando.Parameters.AddWithValue("_fid_cliente", ordenVenta.Cliente.IdPersona);
                comando.Parameters.AddWithValue("_fid_empleado", ordenVenta.Empleado.IdPersona);
                comando.Parameters.AddWithValue("_total", ordenVenta.Total);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.ExecuteNonQuery();
                foreach (LineaOrdenVenta lov in ordenVenta.LineasOrdenVenta)
                {
                    comando = new MySqlCommand();
                    comando.Connection = con;
                    comando.CommandText = "INSERTAR_LINEA_ORDEN_VENTA";
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("_id_linea_orden_venta", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;
                    comando.Parameters.AddWithValue("_fid_orden_venta", ordenVenta.IdOrdenVenta);
                    comando.Parameters.AddWithValue("_fid_producto", lov.Producto.IdProducto);
                    comando.Parameters.AddWithValue("_cantidad", lov.Cantidad);
                    comando.Parameters.AddWithValue("_subtotal", lov.Subtotal);
                    comando.ExecuteNonQuery();
                    lov.IdLineaOrdenVenta =
                    Int32.Parse(comando.Parameters["_id_linea_orden_venta"].Value.ToString());
                }
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

        public int eliminar(int idOrdenVenta)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "ELIMINAR_ORDEN_VENTA";
                comando.Parameters.AddWithValue("_id_orden_venta", idOrdenVenta);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
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
    }
}
