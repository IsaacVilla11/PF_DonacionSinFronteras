package Vista;


public class Registro_Donante extends javax.swing.JFrame {
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroupSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnregresodonate = new javax.swing.JButton();
        BTNCrear = new javax.swing.JButton();
        txtceduladona = new javax.swing.JTextField();
        txtnomdona = new javax.swing.JTextField();
        txtapedona = new javax.swing.JTextField();
        jDnacimiento = new com.toedter.calendar.JDateChooser();
        btnH = new javax.swing.JRadioButton();
        btnM = new javax.swing.JRadioButton();
        jbxtipodona = new javax.swing.JComboBox<>();
        txtcorredona = new javax.swing.JTextField();
        jbxciudona = new javax.swing.JComboBox<>();
        txtceludona = new javax.swing.JTextField();
        txtdiredona = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcodigo_don = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtproyecto = new javax.swing.JTextField();
        txtentidad = new javax.swing.JTextField();
        txtcontradona = new javax.swing.JPasswordField();
        txtMotivo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnregresodonate.setBackground(new java.awt.Color(255, 255, 255));
        btnregresodonate.setText("Regresar");
        btnregresodonate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(204, 255, 204), null, null));
        jPanel1.add(btnregresodonate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 150, 40));

        BTNCrear.setBackground(new java.awt.Color(255, 255, 255));
        BTNCrear.setText("CREAR CUENTA");
        BTNCrear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 204), new java.awt.Color(255, 255, 255), null, null));
        jPanel1.add(BTNCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 150, 40));
        jPanel1.add(txtceduladona, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 170, -1));
        jPanel1.add(txtnomdona, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 170, 20));
        jPanel1.add(txtapedona, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 170, -1));
        jPanel1.add(jDnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 110, -1));

        btnH.setBackground(new java.awt.Color(255, 255, 255));
        btngroupSexo.add(btnH);
        btnH.setText("Hombre");
        jPanel1.add(btnH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        btnM.setBackground(new java.awt.Color(255, 255, 255));
        btngroupSexo.add(btnM);
        btnM.setText("Mujer");
        jPanel1.add(btnM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 70, -1));

        jbxtipodona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORH+", "ORH-", "ARH+", "ARH-", "BRH+", "BRH-", "ABRH+", "ABRH-" }));
        jPanel1.add(jbxtipodona, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));
        jPanel1.add(txtcorredona, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 170, -1));

        jbxciudona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuenca", "Quito", "Guayaquil", "Loja", "Ambato" }));
        jPanel1.add(jbxciudona, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));
        jPanel1.add(txtceludona, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 170, -1));
        jPanel1.add(txtdiredona, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 170, -1));

        jLabel2.setText("Cedula:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        jLabel3.setText("Nombre: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jLabel4.setText("Apellido: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jLabel5.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel6.setText("Sexo: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jLabel7.setText("Tipo de Sangre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        jLabel8.setText("Correo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        jLabel9.setText("Ciudad: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        jLabel10.setText("Celular:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel11.setText("Direccion: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jLabel12.setText("Motivo: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        jLabel13.setText("Contraseña:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, -1, -1));

        jLabel14.setText("Codigo:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));
        jPanel1.add(txtcodigo_don, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 80, -1));

        jLabel15.setText("Proyecto: ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        jLabel16.setText("Entidad:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));
        jPanel1.add(txtproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 170, -1));
        jPanel1.add(txtentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 170, -1));
        jPanel1.add(txtcontradona, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 170, -1));
        jPanel1.add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 170, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel17.setText("REGISTRO DONANTE");
        jLabel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 210, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNCrear;
    private javax.swing.JRadioButton btnH;
    private javax.swing.JRadioButton btnM;
    private javax.swing.ButtonGroup btngroupSexo;
    private javax.swing.JButton btnregresodonate;
    private com.toedter.calendar.JDateChooser jDnacimiento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jbxciudona;
    private javax.swing.JComboBox<String> jbxtipodona;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtapedona;
    private javax.swing.JTextField txtceduladona;
    private javax.swing.JTextField txtceludona;
    private javax.swing.JTextField txtcodigo_don;
    private javax.swing.JPasswordField txtcontradona;
    private javax.swing.JTextField txtcorredona;
    private javax.swing.JTextField txtdiredona;
    private javax.swing.JTextField txtentidad;
    private javax.swing.JTextField txtnomdona;
    private javax.swing.JTextField txtproyecto;
    // End of variables declaration//GEN-END:variables
}
