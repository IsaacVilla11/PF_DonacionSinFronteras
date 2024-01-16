package Vista;

import javax.swing.JButton;

public class V_Principal extends javax.swing.JFrame {

    public V_Principal() {
        initComponents();
    }

    public JButton getBtnAyuda() {
        return btnAyuda;
    }

    public JButton getBtnDonaciones() {
        return btnDonaciones;
    }

    public JButton getBtnDonar1() {
        return btnDonar1;
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }

    public JButton getBtnVentas() {
        return btnVentas;
    }

    public JButton getBtnVermas() {
        return btnVermas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVentas = new javax.swing.JButton();
        btnVermas = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        btnDonaciones = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        btnDonar1 = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVentas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(20, 51, 166));
        btnVentas.setText("Ventas");
        btnVentas.setBorderPainted(false);
        btnVentas.setContentAreaFilled(false);
        jPanel1.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 110, 50));

        btnVermas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVermas.setForeground(new java.awt.Color(20, 51, 166));
        btnVermas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/ver-mas.png"))); // NOI18N
        btnVermas.setText("Ver mas");
        btnVermas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVermas.setContentAreaFilled(false);
        jPanel1.add(btnVermas, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 590, 150, 40));

        btnRegistrarse.setBackground(new java.awt.Color(20, 51, 166));
        btnRegistrarse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setBorderPainted(false);
        jPanel1.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 20, 120, 50));

        btnDonaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDonaciones.setForeground(new java.awt.Color(20, 51, 166));
        btnDonaciones.setText("Donaciones");
        btnDonaciones.setBorderPainted(false);
        btnDonaciones.setContentAreaFilled(false);
        jPanel1.add(btnDonaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 110, 50));

        btnIniciarSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(20, 51, 166));
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.setContentAreaFilled(false);
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 130, 50));

        btnDonar1.setBackground(new java.awt.Color(20, 51, 166));
        btnDonar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDonar1.setForeground(new java.awt.Color(255, 255, 255));
        btnDonar1.setText("Donar ahora");
        btnDonar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDonar1.setBorderPainted(false);
        jPanel1.add(btnDonar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 140, 40));

        btnAyuda.setBackground(new java.awt.Color(20, 51, 166));
        btnAyuda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAyuda.setForeground(new java.awt.Color(255, 255, 255));
        btnAyuda.setText("Ayuda");
        btnAyuda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAyuda.setBorderPainted(false);
        jPanel1.add(btnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 590, 140, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/PDSF_HOME.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnDonaciones;
    private javax.swing.JButton btnDonar1;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVermas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
