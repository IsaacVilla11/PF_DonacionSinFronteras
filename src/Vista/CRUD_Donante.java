/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class CRUD_Donante extends javax.swing.JFrame {

    /**
     * Creates new form CRUD_Donante
     */
    public CRUD_Donante() {
        initComponents();
    }

    public JTable getTablaDonante() {
        return TablaDonante;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JRadioButton getBtnH() {
        return btnH;
    }

    public JRadioButton getBtnM() {
        return btnM;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCedu = new javax.swing.JTextField();
        txtNomb = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnH = new javax.swing.JRadioButton();
        btnM = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDonante = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cbboxCiudad = new javax.swing.JComboBox<>();
        txtCelular = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtproyecto = new javax.swing.JTextField();
        txtentidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        mensajeExito = new javax.swing.JLabel();
        cbBoxSangre = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtDirecc = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jDnacimiento = new com.toedter.calendar.JDateChooser();
        btnCargar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(986, 590));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRO DE DONANTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel4.setText("NOMBRE:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel5.setText("APELLIDO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel7.setText("SEXO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, -1));

        jLabel8.setText("CELULAR:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jLabel9.setText("CORREO:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel10.setText("CONTRASEÑA:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        jLabel11.setText("FECHA DE NACIMIENTO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        jPanel1.add(txtCedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 63, 130, -1));
        jPanel1.add(txtNomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 209, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 209, -1));
        jPanel1.add(txtApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 209, -1));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 210, -1));

        btngroupSexo.add(btnH);
        btnH.setText("Hombre");
        jPanel1.add(btnH, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 90, -1));

        btngroupSexo.add(btnM);
        btnM.setText("Mujer");
        jPanel1.add(btnM, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 80, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel3.setText("LISTA");
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 99, -1));

        TablaDonante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CEDULA", "NOMBRE", "APELLIDO", "FECHA NACIMIENTO", "CORREO", "CIUDAD", "SEXO", "CELULAR", "TELEFONO", "TIPO DE SANGRE", "DIRECCION", "PROYECTO", "ENTIDAD", "MOTIVO", "CONTRASEÑA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaDonante);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 971, 150));

        jLabel12.setText("CIUDAD:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 68, -1, -1));

        cbboxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuenca", "Quito", "Guayaquil", "Loja", "Ambato" }));
        jPanel1.add(cbboxCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 63, 180, -1));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 180, -1));

        jLabel14.setText("CEDULA:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 73, -1, -1));

        jLabel15.setText("MOTIVO:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, -1));

        jLabel6.setText("PROYECTO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, -1, -1));
        jPanel1.add(txtproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 210, -1));
        jPanel1.add(txtentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 210, -1));

        jLabel16.setText("ENTIDAD:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, -1, -1));
        jPanel1.add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 210, -1));

        btnCrear.setText("CREAR");
        btnCrear.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 204, 255))); // NOI18N
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 120, 40));

        btnConsultar.setText("CONSULTAR");
        btnConsultar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 120, 40));

        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 120, 40));

        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, 120, 40));
        jPanel1.add(mensajeExito, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 210, 30));

        cbBoxSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORH+", "ORH-", "ARH+", "ARH-", "BRH+", "BRH-", "ABRH+", "ABRH-" }));
        jPanel1.add(cbBoxSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 100, -1));

        jLabel17.setText("TIPO DE SANGRE:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));
        jPanel1.add(txtDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 210, -1));

        jLabel18.setText("DIRECCION:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));
        jPanel1.add(jDnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 140, -1));

        btnCargar.setText("Cargar");
        jPanel1.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        btnRegresar.setText("REGRESAR");
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDonante;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JRadioButton btnH;
    private javax.swing.JRadioButton btnM;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup btngroupSexo;
    private javax.swing.JComboBox<String> cbBoxSangre;
    private javax.swing.JComboBox<String> cbboxCiudad;
    private com.toedter.calendar.JDateChooser jDnacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mensajeExito;
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
