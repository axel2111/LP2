using LP2SoftDBManager;
using LP2SoftLogisticaController.Almacen.DAO;
using LP2SoftLogisticaModel.Almacen;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2SoftLogisticaController.Almacen.MySQL
{
    public class ProductoMySQL : ProductoDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public BindingList<Producto> listarPorNombre(string nombre)
        {
            BindingList<Producto> productos = new BindingList<Producto>();
            try
            {
                con = DBManager.Instance.getConnection();
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "LISTAR_PRODUCTOS_X_NOMBRE";
                comando.Parameters.AddWithValue("_nombre", nombre);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Producto producto = new Producto();
                    if (!lector.IsDBNull(lector.GetOrdinal("id_producto"))) producto.IdProducto = lector.GetInt32("id_producto");
                    if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) producto.Nombre = lector.GetString("nombre");
                    if (!lector.IsDBNull(lector.GetOrdinal("unidad_medida"))) producto.UnidadMedida = lector.GetString("unidad_medida");
                    if (!lector.IsDBNull(lector.GetOrdinal("precio"))) producto.Precio = lector.GetDouble("precio");
                    productos.Add(producto);
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
            return productos;
        }
    }
}
