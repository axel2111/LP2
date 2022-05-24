package pe.edu.pucp.lp2soft.main;
import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.dao.CuentaUsuarioDAO;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
import pe.edu.pucp.lp2soft.rrhh.model.CuentaUsuario;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import pe.edu.pucp.lp2soft.rrhh.mysql.AreaMySQL;
import pe.edu.pucp.lp2soft.rrhh.mysql.CuentaUsuarioMySQL;
import pe.edu.pucp.lp2soft.rrhh.mysql.EmpleadoMySQL;
public class frmGestionarEmpleados extends javax.swing.JPanel {
    
    private AreaDAO daoArea;
    private EmpleadoDAO daoEmpleado;
    private CuentaUsuarioDAO daoCuentaUsuario;
    private DefaultComboBoxModel modeloArea;
    private Empleado empleado;
    private Estado estado;
    
    public frmGestionarEmpleados() {
        initComponents();
        colocarIconos();
        daoArea = new AreaMySQL();
        daoEmpleado = new EmpleadoMySQL();
        daoCuentaUsuario = new CuentaUsuarioMySQL();
        modeloArea = new DefaultComboBoxModel(daoArea.listarTodas().toArray());
        cboArea.setModel(modeloArea);
        cboArea.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Area){
                    setText(((Area)value).getNombre());
                }
                return this;
            }
        });
        this.estado = Estado.Inicial;
        estadoComponentes();
    }
    
    public void estadoComponentes(){
        switch (this.estado)
        {
            case Inicial:
                btnNuevo.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnBuscar.setEnabled(true);
                btnCancelar.setEnabled(true);
                txtIDEmpleado.setEnabled(false);
                txtNombre.setEnabled(false);
                txtApellidoPaterno.setEnabled(false);
                txtDNI.setEnabled(false);
                rbMasculino.setEnabled(false);
                rbFemenino.setEnabled(false);
                jdcFechaNacimiento.setEnabled(false);
                txtSueldo.setEnabled(false);
                txtCargo.setEnabled(false);
                cboArea.setEnabled(false);
                break;
            case Nuevo:
            case Modificar:
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnBuscar.setEnabled(false);
                btnCancelar.setEnabled(true);
                txtIDEmpleado.setEnabled(true);
                txtNombre.setEnabled(true);
                txtNombre.setEditable(true);
                txtApellidoPaterno.setEnabled(true);
                txtApellidoPaterno.setEditable(true);
                txtDNI.setEnabled(true);
                txtDNI.setEditable(true);
                rbMasculino.setEnabled(true);
                rbFemenino.setEnabled(true);
                jdcFechaNacimiento.setEnabled(true);
                txtSueldo.setEnabled(true);
                txtSueldo.setEditable(true);
                txtCargo.setEnabled(true);
                txtCargo.setEditable(true);
                cboArea.setEnabled(true);
                break;
            case Buscar:
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(true);
                btnModificar.setEnabled(true);
                btnBuscar.setEnabled(false);
                btnCancelar.setEnabled(true);
                txtIDEmpleado.setEnabled(true);
                txtIDEmpleado.setEditable(false);
                txtNombre.setEnabled(true);
                txtNombre.setEditable(false);
                txtApellidoPaterno.setEnabled(true);
                txtApellidoPaterno.setEditable(false);
                txtDNI.setEnabled(true);
                txtDNI.setEditable(false);
                txtCargo.setEnabled(true);
                txtCargo.setEditable(false);
                txtSueldo.setEnabled(true);
                txtSueldo.setEditable(false);
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGenero = new javax.swing.ButtonGroup();
        jtbMenu = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblIDEmpleado = new javax.swing.JLabel();
        txtIDEmpleado = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFemenino = new javax.swing.JRadioButton();
        lblGenero = new javax.swing.JLabel();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblFechaNacimiento = new javax.swing.JLabel();
        cboArea = new javax.swing.JComboBox<>();
        lblArea = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        txtSueldo = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        lblSueldo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(674, 410));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbMenu.setBackground(new java.awt.Color(204, 204, 255));
        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

        btnNuevo.setBackground(new java.awt.Color(204, 204, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jtbMenu.add(btnNuevo);

        btnGuardar.setBackground(new java.awt.Color(204, 204, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jtbMenu.add(btnGuardar);

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jtbMenu.add(btnBuscar);

        btnModificar.setBackground(new java.awt.Color(204, 204, 255));
        btnModificar.setText("Modificar");
        btnModificar.setFocusable(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jtbMenu.add(btnModificar);

        btnEliminar.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jtbMenu.add(btnEliminar);

        btnCancelar.setBackground(new java.awt.Color(204, 204, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jtbMenu.add(btnCancelar);

        add(jtbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 38));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblTitulo.setText("Gestión de Empleados");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 56, -1, -1));

        lblIDEmpleado.setText("ID del Empleado:");
        add(lblIDEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 96, -1, -1));

        txtIDEmpleado.setEditable(false);
        add(txtIDEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 93, 67, -1));
        add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 125, 172, -1));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 157, 295, -1));
        add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 189, 295, -1));

        lblDNI.setText("DNI:");
        add(lblDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 128, -1, -1));

        lblNombre.setText("Nombre:");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 160, -1, -1));

        lblApellidoPaterno.setText("Apellido Paterno:");
        add(lblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 192, -1, -1));

        bgGenero.add(rbMasculino);
        rbMasculino.setText("Masculino");
        add(rbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 225, -1, -1));

        bgGenero.add(rbFemenino);
        rbFemenino.setText("Femenino");
        add(rbFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 225, -1, -1));

        lblGenero.setText("Género:");
        add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 229, -1, -1));
        add(jdcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 256, 295, -1));

        lblFechaNacimiento.setText("Fecha de Nacimiento:");
        add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 261, -1, -1));

        add(cboArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 294, 295, -1));

        lblArea.setText("Área:");
        add(lblArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 297, -1, -1));
        add(txtCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 326, 227, -1));
        add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 358, 227, -1));

        lblCargo.setText("Cargo:");
        add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 329, -1, -1));

        lblSueldo.setText("Sueldo:");
        add(lblSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 361, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if("".equals(txtDNI.getText().trim())){
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            Integer.parseInt(txtDNI.getText().trim());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "El DNI ingresado debe ser un número de 8 dígitos", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(txtDNI.getText().trim().length() != 8)
        {
            JOptionPane.showMessageDialog(this, "El DNI ingresado debe tener 8 dígitos", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if("".equals(txtNombre.getText().trim()))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if("".equals(txtNombre.getText().trim()))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un apellido", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(rbMasculino.isSelected() == false && rbFemenino.isSelected() == false)
        {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un género", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(cboArea.getModel().getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(this, "No ha seleccionado el área del empleado", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if("".equals(txtCargo.getText().trim()))
        {
            JOptionPane.showMessageDialog(this, "No ha ingresado el cargo", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if("".equals(txtSueldo.getText().trim()))
        {
            JOptionPane.showMessageDialog(this, "No ha ingresado el sueldo", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            Double.parseDouble(txtSueldo.getText().trim());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No ha ingresado correctamente el sueldo", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        empleado.setDNI(txtDNI.getText());
        empleado.setNombre(txtNombre.getText());
        empleado.setApellidoPaterno(txtApellidoPaterno.getText());
        if(rbMasculino.isSelected())
            empleado.setGenero('M');
        else
            empleado.setGenero('F');
        empleado.setFechaNacimiento(jdcFechaNacimiento.getDate());
        empleado.setArea((Area)cboArea.getModel().getSelectedItem());
        empleado.setCargo(txtCargo.getText());
        empleado.setSueldo(Double.parseDouble(txtSueldo.getText()));
        if(estado == Estado.Nuevo){
            CuentaUsuario cu = new CuentaUsuario();
            cu.setUsername(empleado.getNombre().substring(0, 1).toLowerCase() + empleado.getApellidoPaterno().toLowerCase());
            cu.setPassword("123456");
            daoCuentaUsuario.insertar(cu);
            empleado.setCuentaUsuario(cu);
            int resultado = daoEmpleado.insertar(empleado);
            if(resultado != 0){
                JOptionPane.showMessageDialog(this, "Se ha registrado con éxito","Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
                estado = Estado.Inicial;
                estadoComponentes();
            }else
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error con el registro","Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }else if(estado == Estado.Modificar){
            int resultado = daoEmpleado.modificar(empleado);
            if(resultado != 0){
                JOptionPane.showMessageDialog(this, "Se ha modificado correctamente","Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
                estado = Estado.Inicial;
                estadoComponentes();
            }else
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error con la modificación","Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      
        JDialog formDialogBusqEmp = new JDialog();
        frmBusquedaEmpleados panelBusqEmp = new frmBusquedaEmpleados(formDialogBusqEmp);
        formDialogBusqEmp.add(panelBusqEmp);
        formDialogBusqEmp.pack();
        formDialogBusqEmp.setFocusable(true);
        formDialogBusqEmp.setTitle("Formulario de Búsqueda de Empleados");
        formDialogBusqEmp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        formDialogBusqEmp.setModal(true);
        formDialogBusqEmp.setVisible(true);
        if(panelBusqEmp.getEmpleadoSeleccionado() != null){
            empleado = panelBusqEmp.getEmpleadoSeleccionado();
            txtIDEmpleado.setText(String.valueOf(empleado.getIdPersona()));
            txtDNI.setText(empleado.getDNI());
            txtNombre.setText(empleado.getNombre());
            txtApellidoPaterno.setText(empleado.getApellidoPaterno());
            if(empleado.getGenero() == 'M')
                rbMasculino.setSelected(true);
            else
                rbFemenino.setSelected(true);
            txtCargo.setText(empleado.getCargo());
            cboArea.getModel().setSelectedItem(empleado.getArea());
            jdcFechaNacimiento.setDate(empleado.getFechaNacimiento());
            txtSueldo.setText(String.valueOf(empleado.getSueldo()));
            estado = Estado.Buscar;
            estadoComponentes();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.estado = Estado.Nuevo;
        estadoComponentes();
        limpiarComponentes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        estado = Estado.Inicial;
        estadoComponentes();
        limpiarComponentes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        estado = Estado.Modificar;
        estadoComponentes();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Esta seguro que desea eliminar este empleado?","Mensaje de Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            int resultado = daoEmpleado.eliminar(empleado.getIdPersona());
            if (resultado != 0)
            {
                JOptionPane.showMessageDialog(null,"Se ha eliminado con éxito", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.estado = Estado.Inicial;
                estadoComponentes();
            }
            else JOptionPane.showMessageDialog(null,"Ha ocurrido un error", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void colocarIconos(){
        URL iconUrl = this.getClass().getResource("/pe/edu/pucp/lp2soft/img/nuevo.png");
        Image img = new ImageIcon(iconUrl).getImage();
        Image newimg = img.getScaledInstance(15, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnNuevo.setIcon(new ImageIcon(newimg));
        btnNuevo.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/lp2soft/img/guardar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnGuardar.setIcon(new ImageIcon(newimg));
        btnGuardar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/lp2soft/img/buscar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnBuscar.setIcon(new ImageIcon(newimg));
        btnBuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/lp2soft/img/cancelar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnCancelar.setIcon(new ImageIcon(newimg));
        btnCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/lp2soft/img/modificar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnModificar.setIcon(new ImageIcon(newimg));
        btnModificar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/lp2soft/img/eliminar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnEliminar.setIcon(new ImageIcon(newimg));
        btnEliminar.setHorizontalTextPosition(SwingConstants.RIGHT);
    }
    
    public void limpiarComponentes(){
        txtIDEmpleado.setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtDNI.setText("");
        rbMasculino.setSelected(false);
        rbFemenino.setSelected(false);
        jdcFechaNacimiento.setDate(new Date());
        cboArea.setSelectedIndex(-1);
        txtCargo.setText("");
        txtSueldo.setText("");
        empleado = new Empleado();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGenero;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboArea;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIDEmpleado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSueldo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtIDEmpleado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
