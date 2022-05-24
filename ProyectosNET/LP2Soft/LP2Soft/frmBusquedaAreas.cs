using LP2SoftRRHHController.DAO;
using LP2SoftRRHHController.MySQL;
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
    public partial class frmBusquedaAreas : Form
    {
        private AreaDAO daoArea;
        public frmBusquedaAreas()
        {
            InitializeComponent();
            dgvAreas.AutoGenerateColumns = false;
            daoArea = new AreaMySQL();
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvAreas.DataSource = daoArea.listarTodas();
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            //frmPrincipal.abrirFormulario(new frmBusquedaEmpleados());
        }
    }
}
