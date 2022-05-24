package pe.edu.pucp.lp2soft.main;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import pe.edu.pucp.lp2soft.gestclientes.dao.ClienteDAO;
import pe.edu.pucp.lp2soft.gestclientes.model.Cliente;
import pe.edu.pucp.lp2soft.gestclientes.mysql.ClienteMySQL;

public class frmBusquedaClientes extends javax.swing.JPanel {
    
    private ClienteDAO daoCliente;
    private JDialog formDialogo;
    private Cliente clienteSeleccionado;
    private ArrayList<Cliente> clientes;
    private DefaultTableModel modeloClientes;
    
    public frmBusquedaClientes() {
        initComponents();
    }
    
    public frmBusquedaClientes(JDialog formDialogo) {
        initComponents();
        daoCliente = new ClienteMySQL();
        this.formDialogo = formDialogo;
        this.modeloClientes = (DefaultTableModel) tblClientes.getModel();
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }
    
    public void completarDatosTabla(){
        modeloClientes.setRowCount(0);
        Object[] fila = new Object[2];
        for(Cliente cliente : clientes){
            fila[0] = cliente.getDNI();
            fila[1] = cliente.getNombre() + " " + cliente.getApellidoPaterno();
            modeloClientes.addRow(fila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbMenu = new javax.swing.JToolBar();
        jspClientes = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtNombreDNI = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        jtbMenu.setBackground(new java.awt.Color(51, 153, 255));
        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jspClientes.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setResizable(false);
            tblClientes.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblClientes.getColumnModel().getColumn(1).setResizable(false);
            tblClientes.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        lblNombre.setText("Ingrese el nombre o DNI del cliente:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jspClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(btnBuscar)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        clientes = daoCliente.listarPorNombreDNI(txtNombreDNI.getText());
        completarDatosTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int indice = tblClientes.getSelectedRow();
        if(indice != -1){
            clienteSeleccionado = clientes.get(indice);
            this.formDialogo.setVisible(false);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jspClientes;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtNombreDNI;
    // End of variables declaration//GEN-END:variables
}
