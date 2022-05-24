using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Runtime.InteropServices;
using LP2SoftRRHHModel;

namespace LP2Soft
{
    public partial class frmPrincipal : Form
    {
        private Form formularioActivo = null;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmPrincipal()
        {
            InitializeComponent();
        }
        public frmPrincipal(Empleado empleado)
        {
            InitializeComponent();
            if (empleado.Cargo == "administrador")
            {
                //se muestra todo
            }
            else if(empleado.Cargo == "vendedor")
            {
                btnListarEmpleados.Visible = false;
                btnEmpleados.Visible = false;
            }
        }

        public void abrirFormulario(Form formularioMostrar)
        {
            if (formularioActivo != null)
                formularioActivo.Close();
            formularioActivo = formularioMostrar;
            formularioMostrar.TopLevel = false;
            formularioMostrar.FormBorderStyle = FormBorderStyle.None;
            formularioMostrar.Dock = DockStyle.Fill;
            panelContenedor.Controls.Add(formularioMostrar);
            formularioMostrar.Show();
        }

        private void btnEmpleados_Click(object sender, EventArgs e)
        {
            abrirFormulario(new frmGestionarEmpleados());
        }

        private void pbCerrar_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void panelSuperior_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void btnGestionPedidos_Click(object sender, EventArgs e)
        {
            abrirFormulario(new frmGestionarOrdenesVenta());
        }

        private void btnListarEmpleados_Click(object sender, EventArgs e)
        {
            abrirFormulario(new frmBusquedaEmpleados2());
        }
    }
}
