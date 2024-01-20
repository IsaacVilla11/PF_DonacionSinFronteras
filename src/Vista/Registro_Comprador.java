package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Registro_Comprador extends javax.swing.JFrame {

    public Registro_Comprador() {
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

    public ButtonGroup getButtonGroupSEXO() {
        return buttonGroupSEXO;
    }

    public JComboBox<String> getCbBoxSangre() {
        return cbBoxSangre;
    }

    public JComboBox<String> getCbboxCiudad() {
        return cbboxCiudad;
    }

    public JComboBox<String> getCbboxEstCivil() {
        return cbboxEstCivil;
    }

    public JComboBox<String> getCbboxMetPagos() {
        return cbboxMetPagos;
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

    public JTextField getTxtNomb() {
        return txtNomb;
    }

    public JPasswordField getTxtPass() {
        return txtPass;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSEXO = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCedu = new javax.swing.JTextField();
        txtNomb = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnH = new javax.swing.JRadioButton();
        btnM = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        cbboxCiudad = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jDnacimiento = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        cbBoxSangre = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtDirecc = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        cbboxMetPagos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbboxEstCivil = new javax.swing.JComboBox<>();
        btnAtras = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(810, 589));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("NOMBRE:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 115, -1, -1));

        jLabel5.setText("APELLIDO:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 143, -1, -1));

        jLabel7.setText("SEXO:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 237, -1, -1));

        jLabel8.setText("CELULAR:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 86, -1, -1));

        jLabel9.setText("CORREO:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 271, -1, -1));

        jLabel10.setText("CONTRASEÑA:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 197, -1, -1));

        jLabel11.setText("FECHA DE NACIMIENTO:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 192, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel6.setText("REGISTRO COMPRADOR");
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 14, -1, -1));
        jPanel2.add(txtCedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 80, 123, -1));
        jPanel2.add(txtNomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 114, 209, -1));
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 268, 198, -1));
        jPanel2.add(txtApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 140, 209, -1));
        jPanel2.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 80, 179, -1));

        txtPass.setText("jPasswordField1");
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 194, 179, -1));

        buttonGroupSEXO.add(btnH);
        btnH.setText("Hombre");
        jPanel2.add(btnH, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 233, 90, -1));

        buttonGroupSEXO.add(btnM);
        btnM.setText("Mujer");
        jPanel2.add(btnM, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 233, 90, -1));

        jLabel12.setText("CIUDAD:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 118, -1, -1));

        cbboxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuenca", "Quito", "Guayaquil", "Loja", "Ambato" }));
        jPanel2.add(cbboxCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 115, 179, -1));

        jLabel14.setText("CEDULA:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 87, -1, -1));
        jPanel2.add(jDnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 186, 146, -1));

        jLabel16.setText("TIPO SANGRE:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 303, -1, -1));

        cbBoxSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORH+", "ORH-", "ARH+", "ARH-", "BRH+", "BRH-", "ABRH+", "ABRH-", " " }));
        jPanel2.add(cbBoxSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 300, 102, -1));

        jLabel2.setText("DIRECCION:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 159, -1, -1));
        jPanel2.add(txtDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 156, 179, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/btnCrear.png"))); // NOI18N
        btnGuardar.setText("CREAR");
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 355, -1, 40));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 52, 601, 10));

        jLabel1.setText("METODO PAGO:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 237, -1, -1));

        cbboxMetPagos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Tarjeta de crédito", "Tarjeta de débito", "Cheque", "Pago en efectivo" }));
        jPanel2.add(cbboxMetPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 234, 173, -1));

        jLabel3.setText("ESTADO CIVIL:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 277, -1, -1));

        cbboxEstCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Soltero", "Casado", "Viudo", "Divorciado" }));
        jPanel2.add(cbboxEstCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 274, 173, -1));

        btnAtras.setBackground(new java.awt.Color(51, 51, 51));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/btnRegresar.png"))); // NOI18N
        btnAtras.setBorder(null);
        jPanel2.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/regCarrito.jpg"))); // NOI18N
        jPanel2.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 192, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JRadioButton btnH;
    private javax.swing.JRadioButton btnM;
    private javax.swing.ButtonGroup buttonGroupSEXO;
    private javax.swing.JComboBox<String> cbBoxSangre;
    private javax.swing.JComboBox<String> cbboxCiudad;
    private javax.swing.JComboBox<String> cbboxEstCivil;
    private javax.swing.JComboBox<String> cbboxMetPagos;
    private javax.swing.JLabel imagen;
    private com.toedter.calendar.JDateChooser jDnacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCedu;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDirecc;
    private javax.swing.JTextField txtNomb;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
