package pe.edu.pucp.lp2soft.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import pe.edu.pucp.lp2soft.almacen.dao.ProductoDAO;
import pe.edu.pucp.lp2soft.almacen.model.Producto;
import pe.edu.pucp.lp2soft.almacen.mysql.ProductoMySQL;

public class frmBusquedaProductos extends javax.swing.JPanel {
    
    private JDialog formDialogo;
    private Producto productoSeleccionado;
    private ProductoDAO daoProducto;
    private ArrayList<Producto> productos;
    private DefaultTableModel modeloProductos;
    
    public frmBusquedaProductos() {
        initComponents();
    }
    
    public frmBusquedaProductos(JDialog formDialogo) {
        initComponents();
        this.formDialogo = formDialogo;
        daoProducto = new ProductoMySQL();
        modeloProductos = (DefaultTableModel) tblProductos.getModel();
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }
    
    public void completarTabla(){
        modeloProductos.setRowCount(0);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        Object[] fila = new Object[2];
        for(Producto producto : productos){
            fila[0] = producto.getNombre() + " " + producto.getUnidadMedida();
            fila[1] = decimalFormat.format(producto.getPrecio()).replace(",",".");
            modeloProductos.addRow(fila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbMenu = new javax.swing.JToolBar();
        jspProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        jtbMenu.setBackground(new java.awt.Color(102, 204, 255));
        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspProductos.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setResizable(false);
            tblProductos.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblProductos.getColumnModel().getColumn(1).setResizable(false);
            tblProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        lblNombre.setText("Ingrese el nombre del producto:");

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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar))
                    .addComponent(jspProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        productos = daoProducto.listarPorNombre(txtNombre.getText());
        completarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int indice = tblProductos.getSelectedRow();
        if(indice != -1){
            productoSeleccionado = productos.get(indice);
            this.formDialogo.setVisible(false);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jspProductos;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
