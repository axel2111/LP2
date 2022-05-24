using LP2SoftRRHHController.DAO;
using LP2SoftRRHHController.MySQL;
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
    public partial class frmBusquedaEmpleados : Form
    {
        private EmpleadoDAO daoEmpleado;
        private Empleado _empleadoSeleccionado;

        public frmBusquedaEmpleados()
        {
            InitializeComponent();
            dgvEmpleados.AutoGenerateColumns = false;
            daoEmpleado = new EmpleadoMySQL();
        }

        public Empleado EmpleadoSeleccionado { get => _empleadoSeleccionado; set => _empleadoSeleccionado = value; }
        private void btnBuscar_Click(object sender, EventArgs e)
        {
            
            dgvEmpleados.DataSource = daoEmpleado.listarPorNombre(txtNombre.Text);

        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            _empleadoSeleccionado = (Empleado) dgvEmpleados.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void dgvEmpleados_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
