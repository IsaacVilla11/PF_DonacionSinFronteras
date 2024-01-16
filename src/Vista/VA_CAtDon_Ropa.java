package Vista;

import javax.swing.JScrollPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class VA_CAtDon_Ropa {

    public VA_CAtDon_Ropa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        mensajeExito = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnReporte = new javax.swing.JButton();
        va2 = new javax.swing.JLabel();
        va4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        chbxDisponibliidad_Producto_Si = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtTipoProducto = new javax.swing.JTextField();
        txtCodigoRopa = new javax.swing.JTextField();
        spnCantidadProducto = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        spnStock = new javax.swing.JSpinner();
        va5 = new javax.swing.JLabel();
        va1 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtCodigoVendible = new javax.swing.JTextField();
        btnImagenProducto = new javax.swing.JButton();
        btnCargarImagen = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        va3 = new javax.swing.JLabel();
        txtPrecioVendible = new javax.swing.JTextField();
        va6 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        cbxCodigosRopa = new javax.swing.JComboBox<>();
        vaSi = new javax.swing.JCheckBox();
        cbxColor = new javax.swing.JComboBox<>();
        txtMarca = new javax.swing.JTextField();
        cbxTalla = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRopa = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxTipoRopa = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mensajeExito.setBackground(new java.awt.Color(0, 204, 255));
        mensajeExito.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        mensajeExito.setForeground(new java.awt.Color(0, 204, 255));
        mensajeExito.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mensajeExito.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(mensajeExito, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 220, 60));

        jLabel10.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nombre Producto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 110, -1));

        jLabel11.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tipo:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Imagen:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnCrear.png"))); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 130, 50));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 130, 50));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mod.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 130, 50));

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/busqueda.png"))); // NOI18N
        btnConsultar.setText("CONSULTAR");
        btnConsultar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 130, 50));

        jLabel14.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoTabla.png"))); // NOI18N
        jLabel14.setText("Tabla de registros");
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 150, 40));

        jLabel15.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoFormulario.png"))); // NOI18N
        jLabel15.setText("Formulario:");
        jLabel15.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 204, 255));
        jSeparator3.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 950, 10));

        jSeparator4.setBackground(new java.awt.Color(0, 204, 255));
        jSeparator4.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setPreferredSize(new java.awt.Dimension(5, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 20, 300));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/informe.png"))); // NOI18N
        btnReporte.setText("REPORTE");
        btnReporte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 130, 50));

        va2.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va2.setForeground(new java.awt.Color(0, 0, 0));
        va2.setText("Codigo vendible: ");
        jPanel1.add(va2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 100, -1));

        va4.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va4.setForeground(new java.awt.Color(0, 0, 0));
        va4.setText("Cantidad Productos:");
        jPanel1.add(va4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Precio:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, -1, -1));

        chbxDisponibliidad_Producto_Si.setText("Si");
        jPanel1.add(chbxDisponibliidad_Producto_Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 40, -1));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("REGISTRO DE ROPA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 230, -1));

        txtTipoProducto.setText("Vendible");
        jPanel1.add(txtTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 110, 30));
        jPanel1.add(txtCodigoRopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, 30));
        jPanel1.add(spnCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 80, -1));

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Codigo ropa: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 80, -1));
        jPanel1.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, 110, 30));
        jPanel1.add(spnStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 80, -1));

        va5.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va5.setForeground(new java.awt.Color(0, 0, 0));
        va5.setText("Stock:");
        jPanel1.add(va5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, -1, -1));

        va1.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va1.setForeground(new java.awt.Color(0, 0, 0));
        va1.setText("Codigo producto: ");
        jPanel1.add(va1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 100, -1));
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 240, 30));
        jPanel1.add(txtCodigoVendible, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 110, 30));

        btnImagenProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnImagenProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/signo-de-interrogacion.png"))); // NOI18N
        jPanel1.add(btnImagenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 200, 130));

        btnCargarImagen.setBackground(new java.awt.Color(255, 255, 255));
        btnCargarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/AGREGAR FOTO.PNG"))); // NOI18N
        btnCargarImagen.setBorder(null);
        jPanel1.add(btnCargarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 110, 90));

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/interrogacion2.jpg"))); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.setContentAreaFilled(false);
        jPanel1.add(btnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 100, -1));

        jLabel17.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Marca:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Talla");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        va3.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va3.setForeground(new java.awt.Color(0, 0, 0));
        va3.setText("Tipo:  ");
        jPanel1.add(va3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, -1, -1));
        jPanel1.add(txtPrecioVendible, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 110, 30));

        va6.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va6.setForeground(new java.awt.Color(0, 0, 0));
        va6.setText("Disponibilidad:");
        jPanel1.add(va6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/limpieza.png"))); // NOI18N
        btnLimpiar.setContentAreaFilled(false);
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 50, 40));

        jLabel5.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Opcional");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 204, 255));
        jSeparator5.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator5.setPreferredSize(new java.awt.Dimension(5, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 230, 10));

        jLabel19.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Datos de administrador");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, -1));

        cbxCodigosRopa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxCodigosRopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 466, 130, 30));

        vaSi.setBorder(null);
        vaSi.setContentAreaFilled(false);
        vaSi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vaSi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver.png"))); // NOI18N
        jPanel1.add(vaSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 40, 30));

        cbxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Blanco", "Negro", "Gris", "Rojo", "Azul", "Verde", "Amarillo", "Naranja", "Rosa", "Morado", "Marrón", "Beige", "Celeste", "Turquesa", "Dorado", "Plateado", "Verde oliva", "Lavanda", "Cian", "Magenta", "Índigo", "Verde menta", "Coral", "Azul marino", "Cobre", "Otro" }));
        jPanel1.add(cbxColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 150, -1));
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 120, -1));

        cbxTalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Talla S = Small ", "Talla P = Pequeña", "Talla M = Medium ", "Talla M = Mediana", "Talla L = Large", "Talla L = Grande", "Talla XL = Extra Large", "Talla EG = Extra Grande", "Otros" }));
        jPanel1.add(cbxTalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 150, -1));

        tblRopa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRopa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 860, -1));

        jLabel4.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Codigo ropa: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 119, 80, -1));

        jLabel16.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Color:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        cbxTipoRopa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Informal", "Semiformal", "Formal" }));
        jPanel1.add(cbxTipoRopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 150, -1));

        jScrollPane2.setViewportView(jPanel1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 590));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnCargarImagen;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImagenProducto;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxCodigosRopa;
    private javax.swing.JComboBox<String> cbxColor;
    private javax.swing.JComboBox<String> cbxTalla;
    private javax.swing.JComboBox<String> cbxTipoRopa;
    private javax.swing.JCheckBox chbxDisponibliidad_Producto_Si;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel mensajeExito;
    private javax.swing.JSpinner spnCantidadProducto;
    private javax.swing.JSpinner spnStock;
    private javax.swing.JTable tblRopa;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoRopa;
    private javax.swing.JTextField txtCodigoVendible;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioVendible;
    private javax.swing.JTextField txtTipoProducto;
    private javax.swing.JLabel va1;
    private javax.swing.JLabel va2;
    private javax.swing.JLabel va3;
    private javax.swing.JLabel va4;
    private javax.swing.JLabel va5;
    private javax.swing.JLabel va6;
    private javax.swing.JCheckBox vaSi;
    // End of variables declaration//GEN-END:variables

    private void add(JScrollPane jScrollPane2, AbsoluteConstraints absoluteConstraints) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setLayout(AbsoluteLayout absoluteLayout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
