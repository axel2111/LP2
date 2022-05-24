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
    public partial class frmBusquedaEmpleados2 : Form
    {
        private EmpleadoDAO daoEmpleado;
        public frmBusquedaEmpleados2()
        {
            InitializeComponent();
            daoEmpleado = new EmpleadoMySQL();
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            panelContenedor.Controls.Clear();
            BindingList<Empleado>
                empleados = daoEmpleado.listarPorNombre
                (txtNombre.Text);
            foreach(Empleado empleado in empleados)
            {
                frmDatosEmpleado formDatosEmp
                    = new frmDatosEmpleado(empleado);
                formDatosEmp.Dock = DockStyle.Top;
                formDatosEmp.TopLevel = false;
                panelContenedor.Controls.Add(formDatosEmp);
                formDatosEmp.Visible = true;
            }
        }

        private void panelContenedor_Paint(object sender, PaintEventArgs e)
        {

        }
    }
}
