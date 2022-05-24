using LP2SoftDBManager;
using LP2SoftLogisticaController.Ventas.DAO;
using LP2SoftLogisticaModel.Almacen;
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
    public class LineaOrdenVentaMySQL : LineaOrdenVentaDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public BindingList<LineaOrdenVenta> listarPorIdOrdenVenta(int idOrdenVenta)
        {
            BindingList<LineaOrdenVenta> lineasOrdenVenta = new BindingList<LineaOrdenVenta>();
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "LISTAR_LINEAS_ORDEN_VENTA_X_ID_ORDEN_VENTA";
                comando.Parameters.AddWithValue("_id_orden_venta", idOrdenVenta);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    LineaOrdenVenta lineaOrdenVenta = new LineaOrdenVenta();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_linea_orden_venta"))) lineaOrdenVenta.IdLineaOrdenVenta = lector.GetInt32("id_linea_orden_venta");
                    lineaOrdenVenta.Producto = new Producto();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_producto"))) lineaOrdenVenta.Producto.IdProducto = lector.GetInt32("id_producto");
                    if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) lineaOrdenVenta.Producto.Nombre = lector.GetString("nombre");
                    if (!lector.IsDBNull(lector.GetOrdinal("unidad_medida"))) lineaOrdenVenta.Producto.UnidadMedida = lector.GetString("unidad_medida");
                    if (!lector.IsDBNull(lector.GetOrdinal("precio"))) lineaOrdenVenta.Producto.Precio = lector.GetDouble("precio");
                    if (!lector.IsDBNull(lector.GetOrdinal("cantidad"))) lineaOrdenVenta.Cantidad = lector.GetInt32("cantidad");
                    if (!lector.IsDBNull(lector.GetOrdinal("subtotal"))) lineaOrdenVenta.Subtotal = lector.GetDouble("subtotal");
                    lineasOrdenVenta.Add(lineaOrdenVenta);
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
            return lineasOrdenVenta;
        }
    }
}
