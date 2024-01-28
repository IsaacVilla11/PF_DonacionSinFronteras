package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Registro_Donante extends javax.swing.JFrame {

    public Registro_Donante() {
        initComponents();
    }

    public JButton getBtnAtras() {
        return btnAtras;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JRadioButton getBtnH() {
        return btnH;
    }

    public JRadioButton getBtnM() {
        return btnM;
    }

    public ButtonGroup getBtngroupSexo() {
        return btngroupSexo;
    }

    public JComboBox<String> getCbBoxSangre() {
        return cbBoxSangre;
    }

    public JComboBox<String> getCbboxCiudad() {
        return cbboxCiudad;
    }

    public JDateChooser getjDnacimiento() {
        return jDnacimiento;
    }

    public JTextField getTxtApe() {
        return txtApe;
    }

    public JTextField getTxtCedu() {
        return txtCedu;
    }

    public JTextField getTxtCelular() {
        return txtCelular;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public JTextField getTxtDirecc() {
        return txtDirecc;
    }

    public JTextField getTxtMotivo() {
        return txtMotivo;
    }

    public JTextField getTxtNomb() {
        return txtNomb;
    }

    public JPasswordField getTxtPass() {
        return txtPass;
    }

    public JTextField getTxtentidad() {
        return txtentidad;
    }

    public JTextField getTxtproyecto() {
        return txtproyecto;
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroupSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtCedu = new javax.swing.JTextField();
        txtNomb = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        jDnacimiento = new com.toedter.calendar.JDateChooser();
        btnH = new javax.swing.JRadioButton();
        btnM = new javax.swing.JRadioButton();
        cbBoxSangre = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        cbboxCiudad = new javax.swing.JComboBox<>();
        txtCelular = new javax.swing.JTextField();
        txtDirecc = new javax.swing.JTextField();
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
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtproyecto = new javax.swing.JTextField();
        txtentidad = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtMotivo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/btnRegresar.png"))); // NOI18N
        btnAtras.setText("Regresar");
        btnAtras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(204, 255, 204), null, null));
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 150, 40));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/btnCrear.png"))); // NOI18N
        btnGuardar.setText("CREAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 204), new java.awt.Color(255, 255, 255), null, null));
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 110, 40));
        jPanel1.add(txtCedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 170, -1));
        jPanel1.add(txtNomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 170, 20));
        jPanel1.add(txtApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 170, -1));
        jPanel1.add(jDnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 170, -1));

        btnH.setBackground(new java.awt.Color(255, 255, 255));
        btngroupSexo.add(btnH);
        btnH.setText("Hombre");
        jPanel1.add(btnH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        btnM.setBackground(new java.awt.Color(255, 255, 255));
        btngroupSexo.add(btnM);
        btnM.setText("Mujer");
        jPanel1.add(btnM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 70, -1));

        cbBoxSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORH+", "ORH-", "ARH+", "ARH-", "BRH+", "BRH-", "ABRH+", "ABRH-" }));
        jPanel1.add(cbBoxSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 170, -1));

        cbboxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuenca", "Quito", "Guayaquil", "Loja", "Ambato" }));
        jPanel1.add(cbboxCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 170, -1));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 170, -1));
        jPanel1.add(txtDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 170, -1));

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
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        jLabel8.setText("Correo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jLabel9.setText("Ciudad: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        jLabel10.setText("Celular:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel11.setText("Direccion: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jLabel12.setText("Motivo: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        jLabel13.setText("Contraseña:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        jLabel15.setText("Proyecto: ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        jLabel16.setText("Entidad:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));
        jPanel1.add(txtproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 170, -1));
        jPanel1.add(txtentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 170, -1));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 170, -1));
        jPanel1.add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 170, -1));

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
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JRadioButton btnH;
    private javax.swing.JRadioButton btnM;
    private javax.swing.ButtonGroup btngroupSexo;
    private javax.swing.JComboBox<String> cbBoxSangre;
    private javax.swing.JComboBox<String> cbboxCiudad;
    private com.toedter.calendar.JDateChooser jDnacimiento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCedu;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDirecc;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtNomb;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtentidad;
    private javax.swing.JTextField txtproyecto;
    // End of variables declaration//GEN-END:variables
}
