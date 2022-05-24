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
    public partial class frmDatosEmpleado : Form
    {
        public frmDatosEmpleado()
        {
            InitializeComponent();
        }

        public frmDatosEmpleado(Empleado empleado)
        {
            InitializeComponent();
            lblDNI.Text = empleado.DNI;
            lblNombreCompleto.Text = empleado.NombreCompleto;
            lblArea.Text = empleado.Area.Nombre;
            lblCargo.Text = empleado.Cargo;
        }
    }
}
