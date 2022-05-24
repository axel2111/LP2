﻿
using LP2SoftLogisticaController.Almacen.DAO;
using LP2SoftLogisticaController.Almacen.MySQL;
using LP2SoftLogisticaModel.Almacen;
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
    public partial class frmBusquedaProducto : Form
    {
        private ProductoDAO daoProducto;
        private Producto _productoSeleccionado;
        public frmBusquedaProducto()
        {
            InitializeComponent();
            daoProducto = new ProductoMySQL();
            dgvProductos.AutoGenerateColumns = false;
        }

        public Producto ProductoSeleccionado { get => _productoSeleccionado; set => _productoSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvProductos.DataSource = daoProducto.listarPorNombre
                (txtNombre.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            _productoSeleccionado = (Producto)dgvProductos.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void dgvProdPres_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            Producto producto = (Producto)dgvProductos.Rows[e.RowIndex].DataBoundItem;
            dgvProductos.Rows[e.RowIndex].Cells[0].Value = producto.Nombre + " " + producto.UnidadMedida;
            dgvProductos.Rows[e.RowIndex].Cells[1].Value = producto.Precio;
        }
    }
}
