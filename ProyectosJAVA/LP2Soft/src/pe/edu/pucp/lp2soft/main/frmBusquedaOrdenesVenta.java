package pe.edu.pucp.lp2soft.main;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import pe.edu.pucp.lp2soft.ventas.dao.LineaOrdenVentaDAO;
import pe.edu.pucp.lp2soft.ventas.dao.OrdenVentaDAO;
import pe.edu.pucp.lp2soft.ventas.model.OrdenVenta;
import pe.edu.pucp.lp2soft.ventas.mysql.LineaOrdenVentaMySQL;
import pe.edu.pucp.lp2soft.ventas.mysql.OrdenVentaMySQL;
public class frmBusquedaOrdenesVenta extends javax.swing.JPanel {
    
    private JDialog formDialogo;
    private DefaultTableModel modeloOrdenesVenta;
    private ArrayList<OrdenVenta> ordenesVenta;
    private OrdenVentaDAO daoOrdenVenta;
    private LineaOrdenVentaDAO daoLineaOrdenVenta;
    private OrdenVenta ordenVentaSeleccionada;
    
    public frmBusquedaOrdenesVenta() {
        initComponents();
    }
    
    public frmBusquedaOrdenesVenta(JDialog formDialogo) {
        initComponents();
        this.formDialogo = formDialogo;
        this.modeloOrdenesVenta = (DefaultTableModel) tblOrdenesVenta.getModel();
        this.daoOrdenVenta = new OrdenVentaMySQL();
        this.daoLineaOrdenVenta = new LineaOrdenVentaMySQL();
    }

    public OrdenVenta getOrdenVentaSeleccionada() {
        return ordenVentaSeleccionada;
    } 
    
     public void completarTabla(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        modeloOrdenesVenta.setRowCount(0);
        for(OrdenVenta ordenVenta : ordenesVenta){
            Object[] fila = new Object[5];
            fila[0] = ordenVenta.getIdOrdenVenta();
            fila[1] = ordenVenta.getCliente().getDNI();
            fila[2] = ordenVenta.getCliente().getNombre() + " " + ordenVenta.getCliente().getApellidoPaterno();
            fila[3] = sdf.format(ordenVenta.getFechaHora());
            fila[4] = String.format("%.2f",ordenVenta.getTotal()).replace(",", ".");
            modeloOrdenesVenta.addRow(fila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbMenu = new javax.swing.JToolBar();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jspOrdenesPedido = new javax.swing.JScrollPane();
        tblOrdenesVenta = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();

        jtbMenu.setBackground(new java.awt.Color(102, 204, 255));
        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

        lblBusqueda.setText("Ingrese el número de Pedido o el DNI/Nombre del Cliente:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblOrdenesVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Orden Venta", "DNI del Cliente", "Nombre del Cliente", "Fecha", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspOrdenesPedido.setViewportView(tblOrdenesVenta);
        if (tblOrdenesVenta.getColumnModel().getColumnCount() > 0) {
            tblOrdenesVenta.getColumnModel().getColumn(0).setResizable(false);
            tblOrdenesVenta.getColumnModel().getColumn(0).setPreferredWidth(107);
            tblOrdenesVenta.getColumnModel().getColumn(1).setResizable(false);
            tblOrdenesVenta.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblOrdenesVenta.getColumnModel().getColumn(2).setResizable(false);
            tblOrdenesVenta.getColumnModel().getColumn(2).setPreferredWidth(240);
            tblOrdenesVenta.getColumnModel().getColumn(3).setResizable(false);
            tblOrdenesVenta.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblOrdenesVenta.getColumnModel().getColumn(4).setResizable(false);
            tblOrdenesVenta.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

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
            .addComponent(jtbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspOrdenesPedido)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusqueda)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspOrdenesPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ordenesVenta = daoOrdenVenta.listarPorIdDNINombreCliente(txtBusqueda.getText());
        completarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int indice = tblOrdenesVenta.getSelectedRow();
        if(indice != -1){
            ordenVentaSeleccionada = ordenesVenta.get(indice);
            ordenVentaSeleccionada.setLineasOrdenVenta(daoLineaOrdenVenta.listarPorIdOrdenVenta(ordenVentaSeleccionada.getIdOrdenVenta()));
            this.formDialogo.setVisible(false);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jspOrdenesPedido;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JTable tblOrdenesVenta;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
