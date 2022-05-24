
using LP2SoftLogisticaController.Ventas.DAO;
using LP2SoftLogisticaController.Ventas.MySQL;
using LP2SoftLogisticaModel.Ventas;
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
    public partial class frmBusquedaOrdenesVenta : Form
    {
        private OrdenVentaDAO daoOrdenVenta;
        private LineaOrdenVentaDAO daoLineaOrdenVenta;
        private OrdenVenta _ordenVentaseleccionada;
        public frmBusquedaOrdenesVenta()
        {
            InitializeComponent();
            dgvOrdenesVenta.AutoGenerateColumns = false;
            daoOrdenVenta = new OrdenVentaMySQL();
            daoLineaOrdenVenta = new LineaOrdenVentaMySQL();
        }
        public OrdenVenta OrdenVentaseleccionada { get => _ordenVentaseleccionada; set => _ordenVentaseleccionada = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvOrdenesVenta.DataSource = daoOrdenVenta.listarPorIdDNINombreCliente(txtBusqueda.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvOrdenesVenta.CurrentRow != null)
            {
                _ordenVentaseleccionada = (OrdenVenta) dgvOrdenesVenta.CurrentRow.DataBoundItem;
                _ordenVentaseleccionada.LineasOrdenVenta = daoLineaOrdenVenta.listarPorIdOrdenVenta(_ordenVentaseleccionada.IdOrdenVenta);
                this.DialogResult = DialogResult.OK;
            }
        }

        private void dgvOrdenesVenta_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            OrdenVenta ordenVenta = (OrdenVenta) dgvOrdenesVenta.Rows[e.RowIndex].DataBoundItem;
            dgvOrdenesVenta.Rows[e.RowIndex].Cells[0].Value = ordenVenta.IdOrdenVenta;
            dgvOrdenesVenta.Rows[e.RowIndex].Cells[1].Value = ordenVenta.Cliente.DNI;
            dgvOrdenesVenta.Rows[e.RowIndex].Cells[2].Value = ordenVenta.Cliente.Nombre + " " + ordenVenta.Cliente.ApellidoPaterno;
            dgvOrdenesVenta.Rows[e.RowIndex].Cells[3].Value = ordenVenta.FechaHora.ToString("dd-MM-yyyy");
            dgvOrdenesVenta.Rows[e.RowIndex].Cells[4].Value = ordenVenta.Total.ToString("N2");
        }
    }
}
