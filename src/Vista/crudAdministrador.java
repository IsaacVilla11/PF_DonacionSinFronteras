package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author jose
 */
public class crudAdministrador extends javax.swing.JFrame {

    public crudAdministrador() {
        initComponents();
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public JTable getTablaAdmi() {
        return TablaAdmi;
    }

    public ButtonGroup getBtSexo() {
        return btSexo;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public JButton getBtnDelete() {
        return btnDelete;
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

    public JButton getBtnModi() {
        return btnModi;
    }

    public JComboBox<String> getCbBoxCargo() {
        return cbBoxCargo;
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

    public JTextField getTxtNomb() {
        return txtNomb;
    }

    public JPasswordField getTxtPass() {
        return txtPass;
    }

    public JTextField getTxt_codigo_administrador() {
        return txt_codigo_administrador;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDirecc = new javax.swing.JTextField();
        txtCedu = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        txtNomb = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        btnModi = new javax.swing.JButton();
        txtApe = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        txtCelular = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        btnH = new javax.swing.JRadioButton();
        btnM = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAdmi = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cbboxCiudad = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigo_administrador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDnacimiento = new com.toedter.calendar.JDateChooser();
        btnCargar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbBoxSangre = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbBoxCargo = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Fecha Nacimiento");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel2.setText("Dirección");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        txtDirecc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 179, -1));

        txtCedu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtCedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 210, -1));

        btnConsultar.setBackground(new java.awt.Color(241, 244, 255));
        btnConsultar.setText("CONSULTAR");
        btnConsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 65, 187)));
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 90, 30));

        txtNomb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtNomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 209, -1));

        btnGuardar.setBackground(new java.awt.Color(241, 244, 255));
        btnGuardar.setText("CREAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 65, 187)));
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 90, 30));

        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 209, -1));

        btnModi.setBackground(new java.awt.Color(241, 244, 255));
        btnModi.setText("MODIFICAR");
        btnModi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 65, 187)));
        jPanel1.add(btnModi, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 90, 30));

        txtApe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 209, -1));

        btnDelete.setBackground(new java.awt.Color(241, 244, 255));
        btnDelete.setText("ELIMINAR");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 65, 187)));
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, 90, 30));

        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 179, -1));

        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 179, 20));

        jLabel13.setText("Cargo");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        btSexo.add(btnH);
        btnH.setText("Hombre");
        btnH.setContentAreaFilled(false);
        jPanel1.add(btnH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 90, -1));

        btSexo.add(btnM);
        btnM.setText("Mujer");
        btnM.setContentAreaFilled(false);
        jPanel1.add(btnM, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 100, -1));

        TablaAdmi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CEDULA", "NOMBRE", "APELLIDO", "FECHA NACIMIENTO", "SEXO", "TIPO SANGRE", "CORREO", "CELULAR", "CIUDAD", "DIRECCION", "GARGO", "CONTRASEÑA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaAdmi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 361, 982, 140));

        jLabel12.setText("Ciudad");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        cbboxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuenca", "Quito", "Guayaquil", "Loja", "Ambato" }));
        jPanel1.add(cbboxCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 179, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("Administrador");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jLabel14.setText("Cedula");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 71, -1, -1));

        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 99, -1, -1));

        jLabel15.setText("Codigo adm:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        jLabel5.setText("Apellido");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 127, -1, -1));

        txt_codigo_administrador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_codigo_administrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 100, -1));

        jLabel7.setText("Sexo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel8.setText("Celular");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        jDnacimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jDnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 160, -1));

        btnCargar.setText("Cargar");
        jPanel1.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, 20));

        jLabel9.setText("Correo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel16.setText("Tipo de sangre");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel10.setText("Contraseña:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        cbBoxSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORH+", "ORH-", "ARH+", "ARH-", "BRH+", "BRH-", "ABRH+", "ABRH-", " " }));
        cbBoxSangre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(cbBoxSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 160, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 153, 255));
        jLabel17.setText("Registro:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 153, 255));
        jLabel18.setText("Lista:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        cbBoxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbBoxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 180, 20));

        btnRegresar.setBackground(new java.awt.Color(241, 244, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 65, 187)));
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAdmi;
    private javax.swing.ButtonGroup btSexo;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JRadioButton btnH;
    private javax.swing.JRadioButton btnM;
    private javax.swing.JButton btnModi;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbBoxCargo;
    private javax.swing.JComboBox<String> cbBoxSangre;
    private javax.swing.JComboBox<String> cbboxCiudad;
    private com.toedter.calendar.JDateChooser jDnacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCedu;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDirecc;
    private javax.swing.JTextField txtNomb;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txt_codigo_administrador;
    // End of variables declaration//GEN-END:variables
}
