package Vista;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author jose
 */
public class vistaLogins extends javax.swing.JFrame {

    public vistaLogins() {
        initComponents();
    }

    public JMenuItem getJmiLoginAdmin() {
        return jmiLoginAdmin;
    }

    public JButton getBtnLoginComprador() {
        return btnLoginComprador;
    }

    public JButton getBtnLoginDonador() {
        return btnLoginDonador;
    }

    public JButton getBtnLoginSolicitante() {
        return btnLoginSolicitante;
    }

    public JButton getBtnRegistroComprador() {
        return btnRegistroComprador;
    }

    public JButton getBtnRegistroDonador() {
        return btnRegistroDonador;
    }

    public JButton getBtnRegistroSolicitante() {
        return btnRegistroSolicitante;
    }

    public JButton getBtnRegresarMenu() {
        return btnRegresarMenu;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLoginSolicitante = new javax.swing.JButton();
        btnLoginComprador = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRegresarMenu = new javax.swing.JButton();
        btnRegistroComprador = new javax.swing.JButton();
        btnRegistroSolicitante = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistroDonador = new javax.swing.JButton();
        btnLoginDonador = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmnR = new javax.swing.JMenu();
        jmiLoginAdmin = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLoginSolicitante.setBackground(new java.awt.Color(241, 244, 255));
        btnLoginSolicitante.setForeground(new java.awt.Color(98, 98, 98));
        btnLoginSolicitante.setText("Solicitante");
        btnLoginSolicitante.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 65, 187), 1, true));
        btnLoginSolicitante.setContentAreaFilled(false);
        jPanel1.add(btnLoginSolicitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 280, 40));

        btnLoginComprador.setBackground(new java.awt.Color(241, 244, 255));
        btnLoginComprador.setForeground(new java.awt.Color(98, 98, 98));
        btnLoginComprador.setText("Comprador");
        btnLoginComprador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 65, 187), 1, true));
        btnLoginComprador.setContentAreaFilled(false);
        jPanel1.add(btnLoginComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 280, 40));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Donación Sin Fronteras: Transformando vidas, traspasando fronteras. ©️🌐 ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 730, -1, -1));

        btnRegresarMenu.setBackground(new java.awt.Color(31, 65, 187));
        btnRegresarMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresarMenu.setText("Regresar");
        btnRegresarMenu.setBorderPainted(false);
        jPanel1.add(btnRegresarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 220, 40));

        btnRegistroComprador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/registro (1).png"))); // NOI18N
        btnRegistroComprador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 65, 187)));
        btnRegistroComprador.setContentAreaFilled(false);
        jPanel1.add(btnRegistroComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 80, 40));

        btnRegistroSolicitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/registro (1).png"))); // NOI18N
        btnRegistroSolicitante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 65, 187)));
        btnRegistroSolicitante.setContentAreaFilled(false);
        jPanel1.add(btnRegistroSolicitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 80, 40));

        jLabel3.setForeground(new java.awt.Color(31, 65, 187));
        jLabel3.setText("Registro");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, -1));

        jLabel1.setForeground(new java.awt.Color(31, 65, 187));
        jLabel1.setText("Inicia Sesión");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        btnRegistroDonador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/registro (1).png"))); // NOI18N
        btnRegistroDonador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 65, 187)));
        btnRegistroDonador.setContentAreaFilled(false);
        jPanel1.add(btnRegistroDonador, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 80, 40));

        btnLoginDonador.setBackground(new java.awt.Color(241, 244, 255));
        btnLoginDonador.setForeground(new java.awt.Color(98, 98, 98));
        btnLoginDonador.setText("Donador");
        btnLoginDonador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 65, 187), 1, true));
        btnLoginDonador.setContentAreaFilled(false);
        jPanel1.add(btnLoginDonador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 280, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Login Screen (4).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/candado.png"))); // NOI18N
        jMenu1.setText("Administrador");

        jmnR.setBackground(new java.awt.Color(241, 244, 255));
        jmnR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/usuario (1).png"))); // NOI18N
        jmnR.setText("Registra un administrador para tener dominio del Sistema");

        jmiLoginAdmin.setText("Login");
        jmiLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLoginAdminActionPerformed(evt);
            }
        });
        jmnR.add(jmiLoginAdmin);

        jMenu1.add(jmnR);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLoginAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiLoginAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginComprador;
    private javax.swing.JButton btnLoginDonador;
    private javax.swing.JButton btnLoginSolicitante;
    private javax.swing.JButton btnRegistroComprador;
    private javax.swing.JButton btnRegistroDonador;
    private javax.swing.JButton btnRegistroSolicitante;
    private javax.swing.JButton btnRegresarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmiLoginAdmin;
    private javax.swing.JMenu jmnR;
    // End of variables declaration//GEN-END:variables
}
