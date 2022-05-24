using LP2SoftLogisticaController.Ventas.DAO;
using LP2SoftLogisticaController.Ventas.MySQL;
using LP2SoftLogisticaModel.Almacen;
using LP2SoftLogisticaModel.Ventas;
using LP2SoftRRHHModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LP2Soft
{
    public partial class frmGestionarOrdenesVenta : Form
    {
        private Estado _estado;
        private OrdenVenta _ordenVenta;
        private Producto _producto;
        private OrdenVentaDAO daoOrdenVenta;
        public frmGestionarOrdenesVenta()
        {
            InitializeComponent();
            dgvDetalleOrdenVenta.AutoGenerateColumns = false;
            daoOrdenVenta = new OrdenVentaMySQL();
            _estado = Estado.Inicial;
            establecerEstadoComponentes();
        }

        public void establecerEstadoComponentes()
        {
            switch (this._estado)
            {
                case Estado.Inicial:
                    btnNuevo.Enabled = true;
                    btnBuscar.Enabled = true;
                    btnModificar.Enabled = false;
                    btnEliminar.Enabled = false;
                    btnGuardar.Enabled = false;
                    btnCancelar.Enabled = true;
                    btnBuscarProducto.Enabled = false;
                    btnBuscarCliente.Enabled = false;
                    btnAgregarProducto.Enabled = false;
                    btnEliminarProducto.Enabled = false;
                    dtpFechaOrdenVenta.Enabled = false;
                    txtCantidad.Enabled = false;
                    txtDNICliente.Enabled = false;
                    txtDNICliente.ReadOnly = true;
                    txtIDOrdenVenta.Enabled = false;
                    txtIDOrdenVenta.ReadOnly = true;
                    txtNombreCliente.Enabled = false;
                    txtNombreCliente.ReadOnly = true;
                    dgvDetalleOrdenVenta.Enabled = false;
                    txtCodigoProducto.Enabled = false;
                    txtNombreProducto.Enabled = false;
                    txtPrecioUnitario.Enabled = false;
                    break;
                case Estado.Nuevo:
                case Estado.Modificar:
                    dtpFechaOrdenVenta.Enabled = false;
                    btnNuevo.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnModificar.Enabled = false;
                    btnEliminar.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnCancelar.Enabled = true;
                    btnBuscarProducto.Enabled = true;
                    btnBuscarCliente.Enabled = true;
                    btnAgregarProducto.Enabled = true;
                    btnEliminarProducto.Enabled = true;
                    txtCantidad.Enabled = true;
                    txtDNICliente.Enabled = true;
                    txtDNICliente.ReadOnly = true;
                    txtIDOrdenVenta.Enabled = true;
                    txtIDOrdenVenta.ReadOnly = true;
                    txtNombreCliente.Enabled = true;
                    txtNombreCliente.ReadOnly = true;
                    dgvDetalleOrdenVenta.Enabled = true;
                    txtCodigoProducto.Enabled = true;
                    txtCodigoProducto.ReadOnly = true;
                    txtNombreProducto.Enabled = true;
                    txtNombreProducto.ReadOnly = true;
                    txtPrecioUnitario.Enabled = true;
                    txtPrecioUnitario.ReadOnly = true;
                    break;
                case Estado.Buscar:
                    btnNuevo.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnModificar.Enabled = true;
                    btnEliminar.Enabled = true;
                    btnGuardar.Enabled = false;
                    btnCancelar.Enabled = true;
                    btnBuscarProducto.Enabled = false;
                    btnBuscarCliente.Enabled = false;
                    btnAgregarProducto.Enabled = false;
                    btnEliminarProducto.Enabled = false;
                    txtCantidad.Enabled = false;
                    txtDNICliente.Enabled = true;
                    txtDNICliente.ReadOnly = true;
                    txtIDOrdenVenta.Enabled = true;
                    txtIDOrdenVenta.ReadOnly = true;
                    txtNombreCliente.Enabled = true;
                    txtNombreCliente.ReadOnly = true;
                    dgvDetalleOrdenVenta.Enabled = false;
                    txtCodigoProducto.Enabled = false;
                    txtNombreProducto.Enabled = false;
                    txtPrecioUnitario.Enabled = false;
                    break;
            }
        }

        public void limpiarComponentes()
        {
            txtIDOrdenVenta.Text = "";
            dtpFechaOrdenVenta.Value = DateTime.Now;
            txtCantidad.Text = "";
            txtCodigoProducto.Text = "";
            txtNombreProducto.Text = "";
            txtPrecioUnitario.Text = "";
            txtDNICliente.Text = "";
            txtNombreCliente.Text = "";
            txtTotal.Text = "";
            this._ordenVenta = new OrdenVenta();
            this._ordenVenta.LineasOrdenVenta = new BindingList<LineaOrdenVenta>();
            dgvDetalleOrdenVenta.DataSource = this._ordenVenta.LineasOrdenVenta;
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            this._estado = Estado.Nuevo;
            establecerEstadoComponentes();
            limpiarComponentes();
        }

        
        private void btnBuscarCliente_Click(object sender, EventArgs e)
        {
            frmBusquedaClientes formBusqClientes = new frmBusquedaClientes();
            if (formBusqClientes.ShowDialog() == DialogResult.OK){
                _ordenVenta.Cliente = formBusqClientes.ClienteSeleccionado;
                txtDNICliente.Text = _ordenVenta.Cliente.DNI;
                txtNombreCliente.Text = _ordenVenta.Cliente.Nombre + " " + _ordenVenta.Cliente.ApellidoPaterno;
            }
        }

        private void btnBuscarProducto_Click(object sender, EventArgs e)
        {
            frmBusquedaProducto formBusqProductos = new frmBusquedaProducto();
            if(formBusqProductos.ShowDialog() == DialogResult.OK)
            {
                _producto = formBusqProductos.ProductoSeleccionado;
                txtCodigoProducto.Text = _producto.IdProducto.ToString();
                txtNombreProducto.Text = _producto.Nombre + " " + _producto.UnidadMedida;
                txtPrecioUnitario.Text = _producto.Precio.ToString("N2");
            }
        }

        private void btnAgregarProducto_Click(object sender, EventArgs e)
        {
            if (txtCodigoProducto.Text == "")
            {
                MessageBox.Show("Debe seleccionar un producto", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (txtCantidad.Text == "" || Int32.Parse(txtCantidad.Text) == 0)
            {
                MessageBox.Show("Debe ingresar una cantidad válida", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            foreach (LineaOrdenVenta linea in this._ordenVenta.LineasOrdenVenta)
            {
                if (linea.Producto.IdProducto.Equals(_producto.IdProducto))
                {
                    linea.Cantidad = linea.Cantidad + Int32.Parse(txtCantidad.Text);
                    linea.calcularSubtotal();
                    this._ordenVenta.calcularTotal();
                    txtTotal.Text = this._ordenVenta.Total.ToString("N2");
                    dgvDetalleOrdenVenta.DataSource = _ordenVenta.LineasOrdenVenta;
                    dgvDetalleOrdenVenta.Refresh();
                    _producto = null;
                    txtCodigoProducto.Text = "";
                    txtNombreProducto.Text = "";
                    txtPrecioUnitario.Text = "";
                    txtCantidad.Text = "";
                    return;
                }
            }
            LineaOrdenVenta lov = new LineaOrdenVenta();
            lov.Producto = _producto;
            lov.Cantidad = Int32.Parse(txtCantidad.Text);
            lov.calcularSubtotal();
            _ordenVenta.LineasOrdenVenta.Add(lov);
            _ordenVenta.calcularTotal();
            txtTotal.Text = _ordenVenta.Total.ToString("N2");
            _producto = null;
            txtCodigoProducto.Text = "";
            txtNombreProducto.Text = "";
            txtPrecioUnitario.Text = "";
            txtCantidad.Text = "";
        }

        private void btnEliminarProducto_Click(object sender, EventArgs e)
        {
            if (dgvDetalleOrdenVenta.CurrentRow != null)
            {
                LineaOrdenVenta lov = (LineaOrdenVenta)dgvDetalleOrdenVenta.CurrentRow.DataBoundItem;
                this._ordenVenta.LineasOrdenVenta.Remove(lov);
                this._ordenVenta.calcularTotal();
                txtTotal.Text = this._ordenVenta.Total.ToString("N2");
            }
            else
            {
                MessageBox.Show("Debe seleccionar una linea de orden de venta", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            if (txtDNICliente.Text == "")
            {
                MessageBox.Show("No ha seleccionado un cliente", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (this._ordenVenta.LineasOrdenVenta.Count == 0)
            {
                MessageBox.Show("No se han agregado productos a esta orden de venta", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            _ordenVenta.Empleado = new Empleado();
            _ordenVenta.Empleado.IdPersona = 1;
            if(_estado == Estado.Nuevo)
            {
                int resultado = daoOrdenVenta.insertar(_ordenVenta);
                if (resultado != 0)
                {
                    MessageBox.Show("Se ha registrado con éxito", "Mensaje de Confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    txtIDOrdenVenta.Text = this._ordenVenta.IdOrdenVenta.ToString();
                    this._estado = Estado.Guardar;
                    establecerEstadoComponentes();
                }
                else
                    MessageBox.Show("Ha ocurrido un error", "Mensaje de Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else if (_estado == Estado.Modificar)
            {
                int resultado = daoOrdenVenta.modificar(this._ordenVenta);
                if (resultado != 0)
                {
                    MessageBox.Show("Se ha modificado con exito", "Mensaje Confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this._estado = Estado.Guardar;
                    establecerEstadoComponentes();
                }
                else MessageBox.Show("Ha ocurrido un error", "Mensaje de Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmBusquedaOrdenesVenta formBusqOV = new frmBusquedaOrdenesVenta();
            if(formBusqOV.ShowDialog() == DialogResult.OK)
            {
                _ordenVenta = formBusqOV.OrdenVentaseleccionada;
                txtIDOrdenVenta.Text = _ordenVenta.IdOrdenVenta.ToString();
                dtpFechaOrdenVenta.Value = _ordenVenta.FechaHora;
                txtDNICliente.Text = _ordenVenta.Cliente.DNI;
                txtNombreCliente.Text = _ordenVenta.Cliente.Nombre + " " + _ordenVenta.Cliente.ApellidoPaterno;
                txtTotal.Text = _ordenVenta.Total.ToString("N2");
                dgvDetalleOrdenVenta.DataSource = _ordenVenta.LineasOrdenVenta;
                _estado = Estado.Buscar;
                establecerEstadoComponentes();
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this._estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
        }

        private void btnModificar_Click(object sender, EventArgs e)
        {
            this._estado = Estado.Modificar;
            establecerEstadoComponentes();
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("¿Esta seguro que desea eliminar esta orden de venta?", "Mensaje de Advertencia", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
            if (dr == DialogResult.Yes)
            {
                int resultado = daoOrdenVenta.eliminar(_ordenVenta.IdOrdenVenta);
                if (resultado != 0)
                {
                    MessageBox.Show("Se ha eliminado con exito", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this._estado = Estado.Inicial;
                    establecerEstadoComponentes();
                }
                else MessageBox.Show("Ha ocurrido un error", "Mensaje de Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void dgvDetalleOrdenVenta_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            LineaOrdenVenta lineaOrdenVenta = (LineaOrdenVenta) dgvDetalleOrdenVenta.Rows[e.RowIndex].DataBoundItem;
            dgvDetalleOrdenVenta.Rows[e.RowIndex].Cells[0].Value = lineaOrdenVenta.Producto.Nombre + " " + lineaOrdenVenta.Producto.UnidadMedida;
            dgvDetalleOrdenVenta.Rows[e.RowIndex].Cells[1].Value = lineaOrdenVenta.Cantidad;
            dgvDetalleOrdenVenta.Rows[e.RowIndex].Cells[2].Value = lineaOrdenVenta.Producto.Precio;
            dgvDetalleOrdenVenta.Rows[e.RowIndex].Cells[3].Value = lineaOrdenVenta.Subtotal;
        }

        private void txtCantidad_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
            }
        }

        private void dgvDetalleOrdenVenta_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}