package pe.edu.pucp.lp2soft.main;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import pe.edu.pucp.lp2soft.almacen.model.Producto;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import pe.edu.pucp.lp2soft.ventas.dao.OrdenVentaDAO;
import pe.edu.pucp.lp2soft.ventas.model.LineaOrdenVenta;
import pe.edu.pucp.lp2soft.ventas.model.OrdenVenta;
import pe.edu.pucp.lp2soft.ventas.mysql.OrdenVentaMySQL;

public class frmGestionarOrdenesVenta extends javax.swing.JPanel {
    
    private Estado estado;
    private Producto producto;
    private OrdenVenta ordenVenta;
    private DefaultTableModel modeloLineasOrdenVenta;
    private OrdenVentaDAO daoOrdenVenta;
    
    public frmGestionarOrdenesVenta() {
       initComponents();
       colocarIconos();
       modeloLineasOrdenVenta = (DefaultTableModel) tblLineasOrdenVenta.getModel();
       daoOrdenVenta = new OrdenVentaMySQL();
       estado = Estado.Inicial;
       limpiarComponentes();
       establecerEstadoComponentes();
    }

    public void establecerEstadoComponentes()
    {
        switch (this.estado)
        {
            case Inicial:
                btnNuevo.setEnabled(true);
                btnBuscar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnBuscarProducto.setEnabled(false);
                btnBuscarCliente.setEnabled(false);
                btnAgregarProducto.setEnabled(false);
                btnEliminarProducto.setEnabled(false);
                txtCantidad.setEnabled(false);
                txtIDOrdenVenta.setEnabled(false);
                txtIDOrdenVenta.setEditable(false);
                break;
            case Nuevo:
            case Modificar:
                btnNuevo.setEnabled(false);
                btnBuscar.setEnabled(false);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnBuscarProducto.setEnabled(true);
                btnBuscarCliente.setEnabled(true);
                btnAgregarProducto.setEnabled(true);
                btnEliminarProducto.setEnabled(true);
                txtCantidad.setEnabled(true);
                txtIDOrdenVenta.setEnabled(true);
                txtIDOrdenVenta.setEditable(false);
                break;
            case Buscar:
                btnNuevo.setEnabled(false);
                btnBuscar.setEnabled(false);
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnBuscarProducto.setEnabled(false);
                btnBuscarCliente.setEnabled(false);
                btnAgregarProducto.setEnabled(false);
                btnEliminarProducto.setEnabled(false);
                txtCantidad.setEnabled(false);
                txtIDOrdenVenta.setEnabled(true);
                txtIDOrdenVenta.setEditable(false);
                break;
        }
    }
    
    public void limpiarComponentes(){
        txtIDOrdenVenta.setText("");
        jdcFechaOrdenVenta.setDate(new Date());
        txtCantidad.setText("");
        txtCodProducto.setText("");
        txtNombreProducto.setText("");
        txtPrecioUnitario.setText("");
        txtDNICliente.setText("");
        txtNombreCliente.setText("");
        txtTotal.setText("");
        this.ordenVenta = new OrdenVenta();
        this.ordenVenta.setLineasOrdenVenta(new ArrayList<>());
        this.modeloLineasOrdenVenta.setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosCliente = new javax.swing.JPanel();
        lblDNICliente = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        txtDNICliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jtbMenu = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelDatosVenta = new javax.swing.JPanel();
        lblIDOVenta = new javax.swing.JLabel();
        lblFechaPedido = new javax.swing.JLabel();
        txtIDOrdenVenta = new javax.swing.JTextField();
        jdcFechaOrdenVenta = new com.toedter.calendar.JDateChooser();
        panelLineasPedido = new javax.swing.JPanel();
        lblCodigoProducto = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        lblProducto = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        lblPrecioUnitario = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jscLineasOrdenVenta = new javax.swing.JScrollPane();
        tblLineasOrdenVenta = new javax.swing.JTable();
        lblBanner = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(660, 514));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Datos del Cliente"));

        lblDNICliente.setText("DNI del Cliente:");

        lblNombreCliente.setText("Nombre del Cliente:");

        txtDNICliente.setEditable(false);

        txtNombreCliente.setEditable(false);

        btnBuscarCliente.setText("...");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosClienteLayout = new javax.swing.GroupLayout(panelDatosCliente);
        panelDatosCliente.setLayout(panelDatosClienteLayout);
        panelDatosClienteLayout.setHorizontalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblDNICliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombreCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panelDatosClienteLayout.setVerticalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNICliente)
                    .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(panelDatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 520, -1));

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

        add(jtbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 32));

        panelDatosVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Datos de la Venta"));

        lblIDOVenta.setText("ID Orden Venta:");

        lblFechaPedido.setText("Fecha del Venta:");

        txtIDOrdenVenta.setEnabled(false);

        javax.swing.GroupLayout panelDatosVentaLayout = new javax.swing.GroupLayout(panelDatosVenta);
        panelDatosVenta.setLayout(panelDatosVentaLayout);
        panelDatosVentaLayout.setHorizontalGroup(
            panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVentaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIDOVenta)
                    .addComponent(lblFechaPedido))
                .addGap(18, 18, 18)
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDOrdenVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcFechaOrdenVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        panelDatosVentaLayout.setVerticalGroup(
            panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVentaLayout.createSequentialGroup()
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIDOVenta)
                    .addComponent(txtIDOrdenVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaPedido)
                    .addComponent(jdcFechaOrdenVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(panelDatosVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, 520, 80));

        panelLineasPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Líneas de Orden Venta"));

        lblCodigoProducto.setText("Código del Producto:");

        txtCodProducto.setEditable(false);

        lblProducto.setText("Producto:");

        txtNombreProducto.setEditable(false);

        lblPrecioUnitario.setText("Precio Unitario:");

        txtPrecioUnitario.setEditable(false);

        btnBuscarProducto.setText("...");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        lblCantidad.setText("Cantidad:");

        btnAgregarProducto.setText("+");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("-");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLineasPedidoLayout = new javax.swing.GroupLayout(panelLineasPedido);
        panelLineasPedido.setLayout(panelLineasPedidoLayout);
        panelLineasPedidoLayout.setHorizontalGroup(
            panelLineasPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLineasPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLineasPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPrecioUnitario)
                    .addComponent(lblProducto)
                    .addComponent(lblCodigoProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLineasPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLineasPedidoLayout.createSequentialGroup()
                        .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLineasPedidoLayout.createSequentialGroup()
                        .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lblCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarProducto))
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        panelLineasPedidoLayout.setVerticalGroup(
            panelLineasPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLineasPedidoLayout.createSequentialGroup()
                .addGroup(panelLineasPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoProducto)
                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLineasPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLineasPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioUnitario)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto)
                    .addComponent(btnEliminarProducto))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        add(panelLineasPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 520, -1));

        tblLineasOrdenVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del Producto", "Precio Unit", "Cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jscLineasOrdenVenta.setViewportView(tblLineasOrdenVenta);
        if (tblLineasOrdenVenta.getColumnModel().getColumnCount() > 0) {
            tblLineasOrdenVenta.getColumnModel().getColumn(0).setResizable(false);
            tblLineasOrdenVenta.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblLineasOrdenVenta.getColumnModel().getColumn(1).setResizable(false);
            tblLineasOrdenVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLineasOrdenVenta.getColumnModel().getColumn(2).setResizable(false);
            tblLineasOrdenVenta.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLineasOrdenVenta.getColumnModel().getColumn(3).setResizable(false);
            tblLineasOrdenVenta.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        add(jscLineasOrdenVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 630, 120));

        lblBanner.setForeground(new java.awt.Color(204, 204, 204));
        lblBanner.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(frmGestionarOrdenesVenta.class.getResource("/pe/edu/pucp/lp2soft/img/cactus_banner.jpg")).getScaledInstance(100,270,Image.SCALE_SMOOTH)));
        lblBanner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        add(lblBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 100, 300));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, 60, -1));

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal.setText("TOTAL:");
        add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 60, 14));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        JDialog frmBusqClientes = new JDialog();
        frmBusquedaClientes panelListarClientes = new frmBusquedaClientes(frmBusqClientes);
        frmBusqClientes.add(panelListarClientes);
        frmBusqClientes.pack();
        frmBusqClientes.setModal(true);
        frmBusqClientes.setFocusable(true);
        frmBusqClientes.setTitle("Formulario de Búsqueda de Clientes");
        frmBusqClientes.setVisible(true);
        if(panelListarClientes.getClienteSeleccionado()!=null){
            ordenVenta.setCliente(panelListarClientes.getClienteSeleccionado());
            txtDNICliente.setText(ordenVenta.getCliente().getDNI());
            txtNombreCliente.setText(ordenVenta.getCliente().getNombre() + " " + ordenVenta.getCliente().getApellidoPaterno());
        }  
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        JDialog dialogBusqProductos = new JDialog();
        frmBusquedaProductos panelBusqProductos = new frmBusquedaProductos(dialogBusqProductos);
        dialogBusqProductos.add(panelBusqProductos);
        dialogBusqProductos.pack();
        dialogBusqProductos.setFocusable(true);
        dialogBusqProductos.setModal(true);
        dialogBusqProductos.setTitle("Formulario de Busqueda de Productos");
        dialogBusqProductos.setVisible(true);
        if(panelBusqProductos.getProductoSeleccionado()!=null){
            producto = panelBusqProductos.getProductoSeleccionado();
            txtCodProducto.setText(String.valueOf(producto.getIdProducto()));
            txtNombreProducto.setText(producto.getNombre() + " " + producto.getUnidadMedida());
            txtPrecioUnitario.setText(String.format("%.2f",producto.getPrecio()).replace(",", "."));
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        if("".equals(txtCodProducto.getText()))
        {
            JOptionPane.showMessageDialog(null,"Debe seleccionar un producto", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if("".equals(txtCantidad.getText()))
        {
            JOptionPane.showMessageDialog(null,"Debe ingresar una cantidad", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try
        {
            Integer.parseInt(txtCantidad.getText());
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"La cantidad ingresada no es valida", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DecimalFormat decimalFormat=new DecimalFormat("#.00");
        for (LineaOrdenVenta linea : this.ordenVenta.getLineasOrdenVenta())
        {
            if (linea.getProducto().getIdProducto() == producto.getIdProducto())
            {
                linea.setCantidad(linea.getCantidad() + Integer.parseInt(txtCantidad.getText()));
                linea.calcularSubtotal();
                this.ordenVenta.calcularTotal();
                txtTotal.setText(decimalFormat.format(this.ordenVenta.getTotal()).replace(",", "."));
                actualizarTabla();
                txtCodProducto.setText("");
                txtNombreProducto.setText("");
                txtPrecioUnitario.setText("");
                txtCantidad.setText("");
                this.producto = null;
                return;
            }
        }
        LineaOrdenVenta lov = new LineaOrdenVenta();        
        lov.setProducto(producto);
        lov.setCantidad(Integer.parseInt(txtCantidad.getText()));
        lov.calcularSubtotal();
        ordenVenta.getLineasOrdenVenta().add(lov);
        this.ordenVenta.calcularTotal();
        txtTotal.setText(decimalFormat.format(this.ordenVenta.getTotal()).replace(",", "."));
        actualizarTabla();
        txtCodProducto.setText("");
        txtNombreProducto.setText("");
        txtPrecioUnitario.setText("");
        txtCantidad.setText("");
        this.producto = null;
    }//GEN-LAST:event_btnAgregarProductoActionPerformed
    
    public void actualizarTabla(){
        modeloLineasOrdenVenta.setRowCount(0);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        for(LineaOrdenVenta lov : this.ordenVenta.getLineasOrdenVenta()){
            Object[] fila = new Object[4];
            fila[0] = lov.getProducto().getNombre() + " " + lov.getProducto().getUnidadMedida();
            fila[1] = decimalFormat.format(lov.getProducto().getPrecio()).replace(",", ".");
            fila[2] = lov.getCantidad();
            fila[3] = decimalFormat.format(lov.getSubtotal()).replace(",",".");
            modeloLineasOrdenVenta.addRow(fila);
        }
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if("".equals(txtDNICliente.getText()))
        {
            JOptionPane.showMessageDialog(null,"No ha seleccionado un cliente", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(this.ordenVenta.getLineasOrdenVenta().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"No se han agregado productos a esta orden de venta", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ordenVenta.setEmpleado(new Empleado());
        ordenVenta.getEmpleado().setIdPersona(1);
        if (this.estado.equals(Estado.Nuevo))
        {
            int resultado = daoOrdenVenta.insertar(this.ordenVenta);
            if (resultado != 0)
            {
                JOptionPane.showMessageDialog(null,"Se ha registrado con éxito", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
                txtIDOrdenVenta.setText(String.valueOf(this.ordenVenta.getIdOrdenVenta()));
                this.estado = Estado.Inicial;
                establecerEstadoComponentes();
            }
            else JOptionPane.showMessageDialog(null,"Ha ocurrido un error", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.estado.equals(Estado.Modificar))
        {
            int resultado = daoOrdenVenta.modificar(this.ordenVenta);
            if (resultado != 0)
            {
                JOptionPane.showMessageDialog(null,"Se ha modificado con éxito", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.estado = Estado.Inicial;
                establecerEstadoComponentes();
            }
            else JOptionPane.showMessageDialog(null,"Ha ocurrido un error", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int indice = tblLineasOrdenVenta.getSelectedRow();
        if(indice != -1){
            DecimalFormat decimalFormat=new DecimalFormat("0.00");
            ordenVenta.getLineasOrdenVenta().remove(indice);
            ordenVenta.calcularTotal();
            txtTotal.setText(decimalFormat.format(this.ordenVenta.getTotal()).replace(",", "."));
            actualizarTabla();
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar una linea de orden de venta", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.estado = Estado.Nuevo;
        limpiarComponentes();
        establecerEstadoComponentes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JDialog formBusquedaOrdenesVenta = new JDialog();
        frmBusquedaOrdenesVenta panelOrdenesVenta = new frmBusquedaOrdenesVenta(formBusquedaOrdenesVenta);
        formBusquedaOrdenesVenta.add(panelOrdenesVenta);
        formBusquedaOrdenesVenta.pack();
        formBusquedaOrdenesVenta.setModal(true);
        formBusquedaOrdenesVenta.setFocusable(true);
        formBusquedaOrdenesVenta.setTitle("Formulario de Búsqueda de Órdenes de Venta");
        formBusquedaOrdenesVenta.setVisible(true);
        if(panelOrdenesVenta.getOrdenVentaSeleccionada()!=null){
            this.ordenVenta = panelOrdenesVenta.getOrdenVentaSeleccionada();
            txtIDOrdenVenta.setText(String.valueOf(ordenVenta.getIdOrdenVenta()));
            txtDNICliente.setText(ordenVenta.getCliente().getDNI());
            txtNombreCliente.setText(ordenVenta.getCliente().getNombre() + " " + ordenVenta.getCliente().getApellidoPaterno());
            txtTotal.setText(String.format("%.2f",this.ordenVenta.getTotal()).replace(",", "."));
            actualizarTabla();
            this.estado = Estado.Buscar;
            establecerEstadoComponentes();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.estado = Estado.Inicial;
        limpiarComponentes();
        establecerEstadoComponentes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        this.estado = Estado.Modificar;
        establecerEstadoComponentes();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Esta seguro que desea eliminar esta orden de venta?","Mensaje de Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            int resultado = daoOrdenVenta.eliminar(ordenVenta.getIdOrdenVenta());
            if (resultado != 0)
            {
                JOptionPane.showMessageDialog(null,"Se ha eliminado con éxito", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.estado = Estado.Inicial;
                establecerEstadoComponentes();
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private com.toedter.calendar.JDateChooser jdcFechaOrdenVenta;
    private javax.swing.JScrollPane jscLineasOrdenVenta;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCodigoProducto;
    private javax.swing.JLabel lblDNICliente;
    private javax.swing.JLabel lblFechaPedido;
    private javax.swing.JLabel lblIDOVenta;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblPrecioUnitario;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JPanel panelDatosVenta;
    private javax.swing.JPanel panelLineasPedido;
    private javax.swing.JTable tblLineasOrdenVenta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtDNICliente;
    private javax.swing.JTextField txtIDOrdenVenta;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
