package pe.edu.pucp.lp2soft.main;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import pe.edu.pucp.lp2soft.rrhh.mysql.EmpleadoMySQL;
public class frmBusquedaEmpleados extends javax.swing.JPanel {
    
    private EmpleadoDAO daoEmpleado;
    private ArrayList<Empleado> empleados;
    private DefaultTableModel modeloEmpleados;
    private Empleado empleadoSeleccionado;
    private JDialog dialogo;

    public frmBusquedaEmpleados() {
        initComponents();
        daoEmpleado = new EmpleadoMySQL();
        modeloEmpleados = (DefaultTableModel) jtEmpleados.getModel();
    }
    
    public frmBusquedaEmpleados(JDialog dialogo) {
        initComponents();
        daoEmpleado = new EmpleadoMySQL();
        modeloEmpleados = (DefaultTableModel) jtEmpleados.getModel();
        this.dialogo = dialogo;
    }
    
    public void completarDatosTabla(){
        modeloEmpleados.setRowCount(0);
        Object[] fila = new Object[2];
        for(Empleado emp : empleados){
            fila[0] = emp.getDNI();
            fila[1] = emp.getNombre() + " " + emp.getApellidoPaterno();
            modeloEmpleados.addRow(fila);
        }
    }
    
    public Empleado getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jspEmpleados = new javax.swing.JScrollPane();
        jtEmpleados = new javax.swing.JTable();

        lblNombre.setText("Ingrese el nombre del empleado:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jtEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre Completo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspEmpleados.setViewportView(jtEmpleados);
        if (jtEmpleados.getColumnModel().getColumnCount() > 0) {
            jtEmpleados.getColumnModel().getColumn(0).setResizable(false);
            jtEmpleados.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtEmpleados.getColumnModel().getColumn(1).setResizable(false);
            jtEmpleados.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspEmpleados)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        empleados = daoEmpleado.listarPorNombre(txtNombre.getText());
        completarDatosTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int indice = jtEmpleados.getSelectedRow();
        if(indice != -1){
            empleadoSeleccionado = empleados.get(indice);
            dialogo.setVisible(false);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jspEmpleados;
    private javax.swing.JTable jtEmpleados;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
