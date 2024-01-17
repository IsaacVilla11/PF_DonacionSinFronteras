package Vista;

import javax.swing.JButton;

public class Registro_Solicitante extends javax.swing.JFrame {

    public Registro_Solicitante() {
        initComponents();
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtcedula_soli = new javax.swing.JTextField();
        rbH = new javax.swing.JRadioButton();
        rbM = new javax.swing.JRadioButton();
        cbBoxSangre = new javax.swing.JComboBox<>();
        cboxciudad_soli = new javax.swing.JComboBox<>();
        txtContra_soli = new javax.swing.JPasswordField();
        btnRegresar = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtnombre_soli = new javax.swing.JTextField();
        txtapellido_soli = new javax.swing.JTextField();
        txtcorreo_soli = new javax.swing.JTextField();
        txtcelular_soli = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtnum_solicitud = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        txtcodigo_solicitn = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("INGRESE SUS DATOS ");
        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, -1, -1));

        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("CEDULA:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText("NOMBRE:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 10));

        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText("APELLIDO:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel19.setForeground(new java.awt.Color(0, 0, 102));
        jLabel19.setText("FECHA DE NACIMIENTO:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel20.setForeground(new java.awt.Color(0, 0, 102));
        jLabel20.setText("SEXO:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel21.setForeground(new java.awt.Color(0, 0, 102));
        jLabel21.setText("CORREO:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel22.setForeground(new java.awt.Color(0, 0, 102));
        jLabel22.setText("TIPO DE SANGRE:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jLabel23.setForeground(new java.awt.Color(0, 0, 102));
        jLabel23.setText("CELULAR:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        jLabel24.setForeground(new java.awt.Color(0, 0, 102));
        jLabel24.setText("CIUDAD:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        jLabel25.setForeground(new java.awt.Color(0, 0, 102));
        jLabel25.setText("DIRECCION:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, 20));

        jLabel26.setForeground(new java.awt.Color(0, 0, 102));
        jLabel26.setText("CONTRASEÑA:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, -1));

        jLabel27.setForeground(new java.awt.Color(0, 0, 102));
        jLabel27.setText("NUMERO DE SOLICITUD:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));
        jPanel2.add(txtcedula_soli, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 190, -1));

        rbH.setForeground(new java.awt.Color(0, 0, 102));
        rbH.setText("Hombre");
        jPanel2.add(rbH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        rbM.setForeground(new java.awt.Color(0, 0, 102));
        rbM.setText("Mujer");
        jPanel2.add(rbM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        cbBoxSangre.setForeground(new java.awt.Color(0, 0, 102));
        cbBoxSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORH+", "ORH-", "ARH+", "ARH-", "BRH+", "BRH-", "ABRH+", "ABRH-", " " }));
        jPanel2.add(cbBoxSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 102, -1));

        cboxciudad_soli.setForeground(new java.awt.Color(0, 0, 102));
        cboxciudad_soli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuenca", "Quito", "Guayaquil", "Loja", "Ambato" }));
        jPanel2.add(cboxciudad_soli, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 122, -1));

        txtContra_soli.setForeground(new java.awt.Color(0, 0, 102));
        txtContra_soli.setText("jPasswordField1");
        jPanel2.add(txtContra_soli, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 178, -1));

        btnRegresar.setBackground(new java.awt.Color(0, 0, 102));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorderPainted(false);
        jPanel2.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 160, 40));

        jLabel28.setForeground(new java.awt.Color(0, 0, 102));
        jLabel28.setText("CODIGO:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, -1));
        jPanel2.add(txtnombre_soli, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 190, -1));
        jPanel2.add(txtapellido_soli, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, -1));
        jPanel2.add(txtcorreo_soli, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 190, -1));
        jPanel2.add(txtcelular_soli, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 178, -1));
        jPanel2.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 178, -1));
        jPanel2.add(txtnum_solicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 55, -1));

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 102));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRARME");
        btnRegistrar.setBorderPainted(false);
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 150, 40));
        jPanel2.add(txtcodigo_solicitn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 54, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 29, 700, 10));

        jDateChooser1.setForeground(new java.awt.Color(0, 0, 102));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbBoxSangre;
    private javax.swing.JComboBox<String> cboxciudad_soli;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbH;
    private javax.swing.JRadioButton rbM;
    private javax.swing.JPasswordField txtContra_soli;
    private javax.swing.JTextField txtapellido_soli;
    private javax.swing.JTextField txtcedula_soli;
    private javax.swing.JTextField txtcelular_soli;
    private javax.swing.JTextField txtcodigo_solicitn;
    private javax.swing.JTextField txtcorreo_soli;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre_soli;
    private javax.swing.JTextField txtnum_solicitud;
    // End of variables declaration//GEN-END:variables
}
