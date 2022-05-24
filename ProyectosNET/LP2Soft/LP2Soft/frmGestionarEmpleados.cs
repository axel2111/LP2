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
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LP2Soft
{
    public partial class frmGestionarEmpleados : Form
    {
        private EmpleadoDAO daoEmpleado;
        private AreaDAO daoArea;
        private CuentaUsuarioDAO daoCuentaUsuario;
        private Empleado _empleado;
        private Estado _estado;
        public frmGestionarEmpleados()
        {
            InitializeComponent();
            daoEmpleado = new EmpleadoMySQL();
            daoArea = new AreaMySQL();
            daoCuentaUsuario = new CuentaUsuarioMySQL();
            cboArea.DataSource = daoArea.listarTodas();
            cboArea.DisplayMember = "Nombre";
            cboArea.ValueMember = "IdArea";
            _estado = Estado.Inicial;
            establecerEstadoComponentes();
            limpiarComponentes();
        }
        public void establecerEstadoComponentes()
        {
            switch (_estado)
            {
                case Estado.Inicial:
                    btnNuevo.Enabled = true;
                    btnBuscar.Enabled = true;
                    btnGuardar.Enabled = false;
                    btnModificar.Enabled = false;
                    btnEliminar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtIDEmpleado.Enabled = false;
                    txtDNI.Enabled = false;
                    txtNombre.Enabled = false;
                    txtApellidoPaterno.Enabled = false;
                    rbMasculino.Enabled = false;
                    rbFemenino.Enabled = false;
                    dtpFechaNacimiento.Enabled = false;
                    cboArea.Enabled = false;
                    txtCargo.Enabled = false;
                    txtSueldo.Enabled = false;
                    break;
                case Estado.Modificar:
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnModificar.Enabled = false;
                    btnEliminar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtIDEmpleado.Enabled = true;
                    txtDNI.Enabled = true;
                    txtNombre.Enabled = true;
                    txtApellidoPaterno.Enabled = true;
                    rbMasculino.Enabled = true;
                    rbFemenino.Enabled = true;
                    dtpFechaNacimiento.Enabled = true;
                    cboArea.Enabled = true;
                    txtCargo.Enabled = true;
                    txtSueldo.Enabled = true;
                    break;
                case Estado.Buscar:
                    btnNuevo.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnGuardar.Enabled = false;
                    btnModificar.Enabled = true;
                    btnEliminar.Enabled = true;
                    btnCancelar.Enabled = true;
                    txtIDEmpleado.Enabled = true;
                    txtDNI.Enabled = false;
                    txtNombre.Enabled = false;
                    txtApellidoPaterno.Enabled = false;
                    rbMasculino.Enabled = false;
                    rbFemenino.Enabled = false;
                    dtpFechaNacimiento.Enabled = false;
                    cboArea.Enabled = false;
                    txtCargo.Enabled = false;
                    txtSueldo.Enabled = false;
                    break;
            }
        }

        public void limpiarComponentes()
        {
            txtIDEmpleado.Text = "";
            txtDNI.Text = "";
            txtNombre.Text = "";
            txtApellidoPaterno.Text = "";
            rbMasculino.Checked = false;
            rbFemenino.Checked = false;
            dtpFechaNacimiento.Value = DateTime.Now;
            cboArea.SelectedIndex = -1;
            txtCargo.Text = "";
            txtSueldo.Text = "";
            _empleado = new Empleado();
        }
        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _estado = Estado.Nuevo;
            limpiarComponentes();
            establecerEstadoComponentes();
        }
        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmBusquedaEmpleados formBusqEmpleados = new frmBusquedaEmpleados();
            if (formBusqEmpleados.ShowDialog() == DialogResult.OK)
            {
                
                _empleado = formBusqEmpleados.EmpleadoSeleccionado;
                txtIDEmpleado.Text = _empleado.IdPersona.ToString();
                txtNombre.Text = _empleado.Nombre;
                txtApellidoPaterno.Text = _empleado.ApellidoPaterno;
                txtDNI.Text = _empleado.DNI;
                if (_empleado.Genero == 'F')
                    rbFemenino.Checked = true;
                else rbMasculino.Checked = true;
                txtCargo.Text = _empleado.Cargo;
                txtSueldo.Text = _empleado.Sueldo.ToString("N2");
                dtpFechaNacimiento.Value = _empleado.FechaNacimiento;
                cboArea.SelectedValue = _empleado.Area.IdArea;
                _estado = Estado.Buscar;
                establecerEstadoComponentes();
            }
        }
        private void btnGuardar_Click(object sender, EventArgs e)
        {
            if(txtDNI.Text.Trim().Length != 8)
            {
                MessageBox.Show("El DNI ingresado debe tener 8 dígitos","Mensaje de advertencia",MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            try
            {
                Int32.Parse(txtDNI.Text);
            }catch(Exception ex)
            {
                MessageBox.Show("El DNI debe ser un número","Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if(txtNombre.Text.Trim() == "")
            {
                MessageBox.Show("Debe ingresar un nombre", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (txtApellidoPaterno.Text.Trim() == "")
            {
                MessageBox.Show("Debe ingresar un apellido", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (rbMasculino.Checked == false && rbFemenino.Checked == false)
            {
                MessageBox.Show("Debe indicar el género", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (cboArea.SelectedIndex == -1)
            {
                MessageBox.Show("No ha seleccionado el área del empleado", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (txtCargo.Text == "")
            {
                MessageBox.Show("No ha ingresado el cargo", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (txtSueldo.Text == "")
            {
                MessageBox.Show("No ha ingresado el sueldo", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            try
            {
                Double.Parse(txtSueldo.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show("No ha ingresado correctamente el sueldo", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            _empleado.DNI = txtDNI.Text.Trim();
            _empleado.Nombre = txtNombre.Text.Trim();
            _empleado.ApellidoPaterno = txtApellidoPaterno.Text.Trim();
            if (rbMasculino.Checked) _empleado.Genero = 'M';
            else _empleado.Genero = 'F';
            _empleado.FechaNacimiento = dtpFechaNacimiento.Value;
            _empleado.Area = (Area)cboArea.SelectedItem;
            _empleado.Cargo = txtCargo.Text.Trim();
            _empleado.Sueldo = Double.Parse(txtSueldo.Text.Trim());
            if (_estado == Estado.Nuevo)
            {
                CuentaUsuario cuentaUsuario = new CuentaUsuario();
                cuentaUsuario.Username = _empleado.Nombre.Substring(0, 1).ToLower() + _empleado.ApellidoPaterno.ToLower();
                cuentaUsuario.Password = "123456";
                daoCuentaUsuario.insertar(cuentaUsuario);
                _empleado.CuentaUsuario = cuentaUsuario;
                int resultado = daoEmpleado.insertar(_empleado);
                if (resultado != 0)
                {
                    MessageBox.Show("Se ha registrado correctamente", "Mensaje de confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    _estado = Estado.Inicial;
                    establecerEstadoComponentes();
                }
                else
                    MessageBox.Show("Ha ocurrido un error con el registro", "Mensaje de error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }else if(_estado == Estado.Modificar)
            {
                int resultado = daoEmpleado.modificar(_empleado);
                if (resultado != 0)
                {
                    MessageBox.Show("Se ha modificado correctamente", "Mensaje de Confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    _estado = Estado.Inicial;
                    establecerEstadoComponentes();
                }
                else
                    MessageBox.Show("Ha ocurrido un error con la modificación", "Mensaje de error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            
        }
        private void btnModificar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Modificar;
            establecerEstadoComponentes();
        }
        private void btnEliminar_Click(object sender, EventArgs e)
        {
            DialogResult respuesta = MessageBox.Show("¿Está seguro que desea eliminar a este empleado?",
                "Mensaje de Confirmación", MessageBoxButtons.YesNo,
                MessageBoxIcon.Question);
            if (respuesta == DialogResult.Yes)
            {
                int resultado = daoEmpleado.eliminar(_empleado.IdPersona);
                if (resultado != 0)
                    MessageBox.Show("Se ha eliminado correctamente", "Mensaje de Confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                else
                    MessageBox.Show("Ha ocurrido un error con la eliminación", "Mensaje de Confirmación", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
        }

        /* Evitando que se ingresen ciertos caracteres en los campos */
        private void txtDNI_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
            }
        }
        private void txtNombre_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && (!char.IsLetter(e.KeyChar)) && (e.KeyChar != ' '))
            {
                e.Handled = true;
            }
        }

        private void txtApellidoPaterno_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && (!char.IsLetter(e.KeyChar)) && (e.KeyChar != ' '))
            {
                e.Handled = true;
            }
        }
        private void txtCargo_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && (!char.IsLetter(e.KeyChar)) && (e.KeyChar != ' '))
            {
                e.Handled = true;
            }
        }
        private void txtSueldo_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && (e.KeyChar != '.'))
            {
                e.Handled = true;
            }
        }

        /* Indicando aquellos campos que no se han completado apropiadamente */
        private void txtDNI_Validating(object sender, CancelEventArgs e)
        {
            if (txtDNI.Text.Trim() == "")
            {
                epDNI.SetError(txtDNI, "Debe ingresar un DNI");
            }
            else if (txtDNI.Text.Trim().Length != 8)
            {
                epDNI.SetError(txtDNI, "El DNI debe tener 8 dígitos");
            }
            else
            {
                epDNI.SetError(txtDNI, "");
            }
        }
        private void txtNombre_Validating(object sender, CancelEventArgs e)
        {
            if (txtNombre.Text.Trim() == "")
            {
                epNombre.SetError(txtNombre, "Debe ingresar un nombre");
            }
            else
                epNombre.SetError(txtNombre, "");
        }

        private void txtApellidoPaterno_Validating(object sender, CancelEventArgs e)
        {
            if (txtApellidoPaterno.Text.Trim() == "")
            {
                epApellidoPaterno.SetError(txtApellidoPaterno, "Debe ingresar un apellido");
            }
            else
                epApellidoPaterno.SetError(txtApellidoPaterno, "");
        }
        private void rbMasculino_Validating(object sender, CancelEventArgs e)
        {
            if (rbMasculino.Checked == false && rbFemenino.Checked == false)
            {
                epGenero.SetError(rbFemenino, "Debe seleccionar un género");
            }
            else
                epGenero.SetError(rbFemenino, "");
        }

        private void rbFemenino_Validating(object sender, CancelEventArgs e)
        {
            if (rbMasculino.Checked == false && rbFemenino.Checked == false)
            {
                epGenero.SetError(rbFemenino, "Debe seleccionar un género");
            }
            else
                epGenero.SetError(rbFemenino, "");
        }

        private void cboArea_Validating(object sender, CancelEventArgs e)
        {
            if (cboArea.SelectedIndex == -1)
                epArea.SetError(cboArea, "Debe seleccionar el área");
            else
                epArea.SetError(cboArea, "");
        }
        private void txtCargo_Validating(object sender, CancelEventArgs e)
        {
            if (txtCargo.Text.Trim() == "")
            {
                epCargo.SetError(txtCargo, "Debe ingresar el cargo");
            }
            else
                epCargo.SetError(txtCargo, "");
        }

        private void txtSueldo_Validating(object sender, CancelEventArgs e)
        {
            if (txtSueldo.Text.Trim() == "")
            {
                epCargo.SetError(txtCargo, "Debe ingresar el cargo");
            }
        }
    }
}
