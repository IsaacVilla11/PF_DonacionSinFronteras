package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author IV
 */
public class VP_Mueble extends javax.swing.JFrame {

    public VP_Mueble() {
        initComponents();
    }

    public JButton getBtnAyuda() {
        return btnAyuda;
    }

    public JButton getBtnConsultarEstado() {
        return btnConsultarEstado;
    }

    public JButton getBtnConsultarId() {
        return btnConsultarId;
    }

    public JButton getBtnConsultarTipo() {
        return btnConsultarTipo;
    }

    public JButton getBtnReporteEstado() {
        return btnReporteEstado;
    }

    public JButton getBtnReportePdf() {
        return btnReportePdf;
    }

    public JButton getBtnReporteTamaño() {
        return btnReporteTamaño;
    }

    public JButton getBtnReporteTipo() {
        return btnReporteTipo;
    }

    public JButton getBtnTodos() {
        return btnTodos;
    }

    public JComboBox<String> getCbxCodigosMuebles() {
        return cbxCodigosMuebles;
    }

    public JComboBox<String> getCbxEstado1() {
        return cbxEstado1;
    }

    public JComboBox<String> getCbxTipoMueble() {
        return cbxTipoMueble;
    }

    public JTable getTblMueble() {
        return tblMueble;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRopa = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        mensajeExito = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnReporteEstado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMueble = new javax.swing.JTable();
        btnConsultarId = new javax.swing.JButton();
        btnConsultarEstado = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        btnReportePdf = new javax.swing.JButton();
        btnReporteTipo = new javax.swing.JButton();
        btnReporteTamaño = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        cbxTipoMueble = new javax.swing.JComboBox<>();
        cbxEstado1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        btnConsultarTipo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxCodigosMuebles = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelRopa.setBackground(new java.awt.Color(255, 255, 255));
        panelRopa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mensajeExito.setBackground(new java.awt.Color(0, 204, 255));
        mensajeExito.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        mensajeExito.setForeground(new java.awt.Color(0, 204, 255));
        mensajeExito.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mensajeExito.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel6.add(mensajeExito, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 220, 60));

        jLabel14.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Tabla de registros");
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 150, 40));

        btnReporteEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/iconoPastel.png"))); // NOI18N
        btnReporteEstado.setText("Estado");
        btnReporteEstado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReporteEstado.setContentAreaFilled(false);
        jPanel6.add(btnReporteEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 130, 50));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("REPORTE DE MUEBLES");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 260, -1));

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/interrogacion2.jpg"))); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAyuda.setContentAreaFilled(false);
        jPanel6.add(btnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 100, -1));

        tblMueble.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblMueble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMueble.setAlignmentX(1.0F);
        tblMueble.setAlignmentY(1.0F);
        tblMueble.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblMueble.setShowHorizontalLines(false);
        tblMueble.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblMueble);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 860, 690));

        btnConsultarId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/busqueda.png"))); // NOI18N
        btnConsultarId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnConsultarId.setContentAreaFilled(false);
        jPanel6.add(btnConsultarId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 50, 30));

        btnConsultarEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/busqueda.png"))); // NOI18N
        btnConsultarEstado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnConsultarEstado.setContentAreaFilled(false);
        jPanel6.add(btnConsultarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 50, 30));

        btnTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/iconoTabla.png"))); // NOI18N
        btnTodos.setText("Todos");
        btnTodos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTodos.setBorderPainted(false);
        btnTodos.setContentAreaFilled(false);
        jPanel6.add(btnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 100, 50));

        btnReportePdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/iconoPdf.png"))); // NOI18N
        btnReportePdf.setText("Pdf");
        btnReportePdf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReportePdf.setContentAreaFilled(false);
        jPanel6.add(btnReportePdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 130, 50));

        btnReporteTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/iconoBarras.png"))); // NOI18N
        btnReporteTipo.setText("Tipo");
        btnReporteTipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReporteTipo.setBorderPainted(false);
        btnReporteTipo.setContentAreaFilled(false);
        jPanel6.add(btnReporteTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 130, 50));

        btnReporteTamaño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/iconoPastel.png"))); // NOI18N
        btnReporteTamaño.setText("Talla");
        btnReporteTamaño.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReporteTamaño.setContentAreaFilled(false);
        jPanel6.add(btnReporteTamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 130, 50));

        jLabel26.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Tipo:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        cbxTipoMueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Sofás y sillones", "Mesas", "Sillas", "Camas", "Armarios y roperos", "Cómodas y cajoneras", "Estanterías y libreros", "Escritorios", "Bancos y taburetes", "Otros" }));
        jPanel6.add(cbxTipoMueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 200, -1));

        cbxEstado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Usado", "Seminuevo", "Nuevo", "Otro" }));
        jPanel6.add(cbxEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 200, -1));

        jLabel17.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Estado:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        btnConsultarTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/busqueda.png"))); // NOI18N
        btnConsultarTipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnConsultarTipo.setContentAreaFilled(false);
        jPanel6.add(btnConsultarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 50, 30));

        jLabel8.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ID mueble: ");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 70, -1));

        cbxCodigosMuebles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(cbxCodigosMuebles, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel5);

        panelRopa.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelRopa, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelRopa, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnConsultarEstado;
    private javax.swing.JButton btnConsultarId;
    private javax.swing.JButton btnConsultarTipo;
    private javax.swing.JButton btnReporteEstado;
    private javax.swing.JButton btnReportePdf;
    private javax.swing.JButton btnReporteTamaño;
    private javax.swing.JButton btnReporteTipo;
    private javax.swing.JButton btnTodos;
    private javax.swing.JComboBox<String> cbxCodigosMuebles;
    private javax.swing.JComboBox<String> cbxEstado1;
    private javax.swing.JComboBox<String> cbxTipoMueble;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mensajeExito;
    private javax.swing.JPanel panelRopa;
    private javax.swing.JTable tblMueble;
    // End of variables declaration//GEN-END:variables
}
