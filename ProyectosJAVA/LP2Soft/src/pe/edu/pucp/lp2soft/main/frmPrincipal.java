package pe.edu.pucp.lp2soft.main;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class frmPrincipal extends javax.swing.JPanel {

    private JFrame frameContenedor;
    
    public frmPrincipal() {
        initComponents();
    }

    public frmPrincipal(JFrame frameContenedor) {
        initComponents();
        this.frameContenedor = frameContenedor;
    }
    
    public JPanel getPanelSuperior(){
        return panelSuperior;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        pbCerrar = new javax.swing.JLabel();
        panelLateral = new javax.swing.JPanel();
        btnGestionEmpleados = new javax.swing.JButton();
        pbLogo = new javax.swing.JLabel();
        btnGestionOrdenesVenta = new javax.swing.JButton();
        panelContenedor = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(994, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSuperior.setBackground(new java.awt.Color(98, 47, 102));
        panelSuperior.setPreferredSize(new java.awt.Dimension(994, 74));

        pbCerrar.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(pe.edu.pucp.lp2soft.main.frmGestionarOrdenesVenta.class.getResource("/pe/edu/pucp/lp2soft/img/close-window-xxl.png")).getScaledInstance(44,44,Image.SCALE_SMOOTH)));
        pbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pbCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addContainerGap(928, Short.MAX_VALUE)
                .addComponent(pbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        add(panelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        panelLateral.setBackground(new java.awt.Color(230, 178, 234));
        panelLateral.setPreferredSize(new java.awt.Dimension(218, 476));
        panelLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGestionEmpleados.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnGestionEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/pucp/lp2soft/img/icons8-employee-55.png"))); // NOI18N
        btnGestionEmpleados.setText("Gestión de Empleados");
        btnGestionEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGestionEmpleados.setContentAreaFilled(false);
        btnGestionEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionEmpleadosActionPerformed(evt);
            }
        });
        panelLateral.add(btnGestionEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 218, 61));

        pbLogo.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(pe.edu.pucp.lp2soft.main.frmGestionarOrdenesVenta.class.getResource("/pe/edu/pucp/lp2soft/img/logo.png")).getScaledInstance(218,74,Image.SCALE_SMOOTH)));
        panelLateral.add(pbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 218, 80));

        btnGestionOrdenesVenta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnGestionOrdenesVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/pucp/lp2soft/img/icons8-office-70.png"))); // NOI18N
        btnGestionOrdenesVenta.setText("Gestión de Ventas");
        btnGestionOrdenesVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGestionOrdenesVenta.setContentAreaFilled(false);
        btnGestionOrdenesVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionOrdenesVentaActionPerformed(evt);
            }
        });
        panelLateral.add(btnGestionOrdenesVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 218, 56));

        add(panelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 510));

        panelContenedor.setPreferredSize(new java.awt.Dimension(776, 476));
        panelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(panelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 770, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void pbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbCerrarMouseClicked
        
        frameContenedor.removeAll();
        frameContenedor.dispatchEvent(new WindowEvent(frameContenedor, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_pbCerrarMouseClicked

    private void btnGestionEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEmpleadosActionPerformed
        frmGestionarEmpleados formGestEmp = new frmGestionarEmpleados();
        formGestEmp.setLocation(0,0);
        panelContenedor.removeAll();
        panelContenedor.add(formGestEmp, new AbsoluteConstraints(0,0,-1,-1));
        panelContenedor.revalidate();
        panelContenedor.repaint();
    }//GEN-LAST:event_btnGestionEmpleadosActionPerformed

    private void btnGestionOrdenesVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionOrdenesVentaActionPerformed
        frmGestionarOrdenesVenta formGestOrdVentas = new frmGestionarOrdenesVenta();
        formGestOrdVentas.setLocation(0,0);
        panelContenedor.removeAll();
        panelContenedor.add(formGestOrdVentas, new AbsoluteConstraints(0,0,-1,-1));
        panelContenedor.revalidate();
        panelContenedor.repaint();
    }//GEN-LAST:event_btnGestionOrdenesVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionEmpleados;
    private javax.swing.JButton btnGestionOrdenesVenta;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JLabel pbCerrar;
    private javax.swing.JLabel pbLogo;
    // End of variables declaration//GEN-END:variables
}
