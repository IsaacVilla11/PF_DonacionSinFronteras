package Vista;

public class VA_CatDon_Muebles extends javax.swing.JPanel {

    public VA_CatDon_Muebles() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vAdmininstrador = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        mensajeExito = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxMaterialMueble = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnAyudaTipoMuebles = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnReporte = new javax.swing.JButton();
        va2 = new javax.swing.JLabel();
        va4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        chbxDisponibliidad_Producto_Si = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtTipoProducto = new javax.swing.JTextField();
        txtCodigoMueble = new javax.swing.JTextField();
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
        jLabel8 = new javax.swing.JLabel();
        btnCargarCampos = new javax.swing.JButton();
        btnAyuda1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbxTipoMueble = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbxTamañoMueble = new javax.swing.JComboBox<>();
        va3 = new javax.swing.JLabel();
        txtPrecioVendible = new javax.swing.JTextField();
        va6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMuebles = new javax.swing.JTable();
        btnConsultarTipo = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        cbxCodigosMuebles = new javax.swing.JComboBox<>();
        vaSi = new javax.swing.JCheckBox();
        vaNo = new javax.swing.JCheckBox();

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
        jLabel11.setText("Tamaño:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Imagen:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        cbxMaterialMueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Madera", "Metal", "Cuero", "Tela", "Rattan y mimbre", "Vidrio", "Plástico", "Mármol y granito", "Corcho", "Melamina", "Acrílico", "Espuma y materiales de relleno", "Cartón", "Otros" }));
        cbxMaterialMueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMaterialMuebleActionPerformed(evt);
            }
        });
        jPanel1.add(cbxMaterialMueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 200, 30));

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnCrear.png"))); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCrearMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCrearMouseReleased(evt);
            }
        });
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 130, 50));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 130, 50));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mod.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 130, 50));

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/busqueda.png"))); // NOI18N
        btnConsultar.setText("CONSULTAR");
        btnConsultar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        btnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultarMouseExited(evt);
            }
        });
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 130, 50));

        jLabel14.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoTabla.png"))); // NOI18N
        jLabel14.setText("Tabla de registros");
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 150, 40));

        jLabel15.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoFormulario.png"))); // NOI18N
        jLabel15.setText("Formulario:");
        jLabel15.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        btnAyudaTipoMuebles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/interrogacion2.jpg"))); // NOI18N
        btnAyudaTipoMuebles.setContentAreaFilled(false);
        btnAyudaTipoMuebles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaTipoMueblesActionPerformed(evt);
            }
        });
        jPanel1.add(btnAyudaTipoMuebles, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 40, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 204, 255));
        jSeparator3.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 950, 10));

        jSeparator4.setBackground(new java.awt.Color(0, 204, 255));
        jSeparator4.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setPreferredSize(new java.awt.Dimension(5, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 20, 300));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/informe.png"))); // NOI18N
        btnReporte.setText("REPORTE");
        btnReporte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N
        btnReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReporteMouseExited(evt);
            }
        });
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
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
        jLabel1.setText("REGISTRO DE MUEBLES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        txtTipoProducto.setText("Vendible");
        txtTipoProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTipoProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTipoProductoFocusLost(evt);
            }
        });
        txtTipoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTipoProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTipoProductoMouseExited(evt);
            }
        });
        txtTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoProductoActionPerformed(evt);
            }
        });
        txtTipoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTipoProductoKeyReleased(evt);
            }
        });
        jPanel1.add(txtTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 110, 30));

        txtCodigoMueble.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoMuebleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoMuebleFocusLost(evt);
            }
        });
        txtCodigoMueble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCodigoMuebleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCodigoMuebleMouseExited(evt);
            }
        });
        txtCodigoMueble.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoMuebleKeyReleased(evt);
            }
        });
        jPanel1.add(txtCodigoMueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, 30));
        jPanel1.add(spnCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 80, -1));

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Codigo mueble: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 90, 40));

        txtCodigoProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoProductoFocusLost(evt);
            }
        });
        txtCodigoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCodigoProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCodigoProductoMouseExited(evt);
            }
        });
        txtCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoActionPerformed(evt);
            }
        });
        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyReleased(evt);
            }
        });
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

        txtNombreProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreProductoFocusLost(evt);
            }
        });
        txtNombreProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNombreProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNombreProductoMouseExited(evt);
            }
        });
        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyReleased(evt);
            }
        });
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 240, 30));

        txtCodigoVendible.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoVendibleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoVendibleFocusLost(evt);
            }
        });
        txtCodigoVendible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCodigoVendibleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCodigoVendibleMouseExited(evt);
            }
        });
        txtCodigoVendible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVendibleActionPerformed(evt);
            }
        });
        txtCodigoVendible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoVendibleKeyReleased(evt);
            }
        });
        jPanel1.add(txtCodigoVendible, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 110, 30));

        btnImagenProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnImagenProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/signo-de-interrogacion.png"))); // NOI18N
        btnImagenProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnImagenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 200, 130));

        btnCargarImagen.setBackground(new java.awt.Color(255, 255, 255));
        btnCargarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/AGREGAR FOTO.PNG"))); // NOI18N
        btnCargarImagen.setBorder(null);
        btnCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 100, 80));

        jLabel8.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Codigo mueble: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 130, -1));

        btnCargarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/busqueda.png"))); // NOI18N
        btnCargarCampos.setText("N/A");
        btnCargarCampos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCargarCampos.setContentAreaFilled(false);
        btnCargarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarCamposActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, 40));

        btnAyuda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/interrogacion2.jpg"))); // NOI18N
        btnAyuda1.setText("Ayuda");
        btnAyuda1.setContentAreaFilled(false);
        btnAyuda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyuda1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAyuda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 100, -1));

        jLabel17.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Material:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        cbxTipoMueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Sofás y sillones", "Mesas", "Sillas", "Camas", "Armarios y roperos", "Cómodas y cajoneras", "Estanterías y libreros", "Escritorios", "Bancos y taburetes", "Otros" }));
        cbxTipoMueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoMuebleActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipoMueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 200, -1));

        jLabel13.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tipo:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        cbxTamañoMueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Pequeño", "Mediano", "Grande", "Muy Grande" }));
        jPanel1.add(cbxTamañoMueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 120, -1));

        va3.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va3.setForeground(new java.awt.Color(0, 0, 0));
        va3.setText("Tipo:  ");
        jPanel1.add(va3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, -1, -1));
        jPanel1.add(txtPrecioVendible, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 110, 30));

        va6.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va6.setForeground(new java.awt.Color(0, 0, 0));
        va6.setText("Disponibilidad:");
        jPanel1.add(va6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        tblMuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO MUEBLE", "MATERIAL", "TAMAÑO", "TIPO", "CODIGO VENDIBLE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMuebles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 910, 370));

        btnConsultarTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/busqueda.png"))); // NOI18N
        btnConsultarTipo.setContentAreaFilled(false);
        btnConsultarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarTipoActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 50, 40));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/limpieza.png"))); // NOI18N
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
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

        cbxCodigosMuebles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCodigosMuebles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCodigosMueblesActionPerformed(evt);
            }
        });
        jPanel1.add(cbxCodigosMuebles, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 466, 130, 30));

        vAdmininstrador.add(vaSi);
        vaSi.setText("Si");
        vaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaSiActionPerformed(evt);
            }
        });
        jPanel1.add(vaSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, -1, -1));

        vAdmininstrador.add(vaNo);
        vaNo.setText("No");
        vaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaNoActionPerformed(evt);
            }
        });
        jPanel1.add(vaNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, -1, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMaterialMuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMaterialMuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMaterialMuebleActionPerformed

    private void btnCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseEntered
    }//GEN-LAST:event_btnCrearMouseEntered

    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited
    }//GEN-LAST:event_btnCrearMouseExited

    private void btnCrearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearMousePressed

    private void btnCrearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearMouseReleased

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnConsultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseEntered
    }//GEN-LAST:event_btnConsultarMouseEntered

    private void btnConsultarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseExited
    }//GEN-LAST:event_btnConsultarMouseExited


    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed


    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAyudaTipoMueblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaTipoMueblesActionPerformed
    }//GEN-LAST:event_btnAyudaTipoMueblesActionPerformed

    private void btnReporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteMouseEntered

    private void btnReporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteMouseExited

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtTipoProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoProductoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoFocusGained

    private void txtTipoProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoProductoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoFocusLost

    private void txtTipoProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTipoProductoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoMouseEntered

    private void txtTipoProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTipoProductoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoMouseExited

    private void txtTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoActionPerformed

    private void txtTipoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoProductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoKeyReleased

    private void txtCodigoMuebleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoMuebleFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMuebleFocusGained

    private void txtCodigoMuebleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoMuebleFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMuebleFocusLost

    private void txtCodigoMuebleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoMuebleMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMuebleMouseEntered

    private void txtCodigoMuebleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoMuebleMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMuebleMouseExited

    private void txtCodigoMuebleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoMuebleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMuebleKeyReleased

    private void txtCodigoProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoProductoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoFocusGained

    private void txtCodigoProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoProductoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoFocusLost

    private void txtCodigoProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoProductoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoMouseEntered

    private void txtCodigoProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoProductoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoMouseExited

    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void txtCodigoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoKeyReleased

    private void txtNombreProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreProductoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoFocusGained

    private void txtNombreProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreProductoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoFocusLost

    private void txtNombreProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreProductoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoMouseEntered

    private void txtNombreProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreProductoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoMouseExited

    private void txtNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoKeyReleased

    private void txtCodigoVendibleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoVendibleFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVendibleFocusGained

    private void txtCodigoVendibleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoVendibleFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVendibleFocusLost

    private void txtCodigoVendibleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoVendibleMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVendibleMouseEntered

    private void txtCodigoVendibleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoVendibleMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVendibleMouseExited

    private void txtCodigoVendibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVendibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVendibleActionPerformed

    private void txtCodigoVendibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVendibleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVendibleKeyReleased

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
    }//GEN-LAST:event_btnCargarImagenActionPerformed

    private void btnCargarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarCamposActionPerformed


    }//GEN-LAST:event_btnCargarCamposActionPerformed

    private void btnAyuda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyuda1ActionPerformed
    }//GEN-LAST:event_btnAyuda1ActionPerformed

    private void cbxTipoMuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoMuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoMuebleActionPerformed

    private void btnImagenProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenProductoActionPerformed
    }//GEN-LAST:event_btnImagenProductoActionPerformed

    private void btnConsultarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarTipoActionPerformed
    }//GEN-LAST:event_btnConsultarTipoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void vaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaSiActionPerformed
    }//GEN-LAST:event_vaSiActionPerformed

    private void vaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaNoActionPerformed
    }//GEN-LAST:event_vaNoActionPerformed

    private void cbxCodigosMueblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCodigosMueblesActionPerformed
    }//GEN-LAST:event_cbxCodigosMueblesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda1;
    private javax.swing.JButton btnAyudaTipoMuebles;
    private javax.swing.JButton btnCargarCampos;
    private javax.swing.JButton btnCargarImagen;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultarTipo;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImagenProducto;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxCodigosMuebles;
    private javax.swing.JComboBox<String> cbxMaterialMueble;
    private javax.swing.JComboBox<String> cbxTamañoMueble;
    private javax.swing.JComboBox<String> cbxTipoMueble;
    private javax.swing.JCheckBox chbxDisponibliidad_Producto_Si;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JTable tblMuebles;
    private javax.swing.JTextField txtCodigoMueble;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoVendible;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioVendible;
    private javax.swing.JTextField txtTipoProducto;
    private javax.swing.ButtonGroup vAdmininstrador;
    private javax.swing.JLabel va1;
    private javax.swing.JLabel va2;
    private javax.swing.JLabel va3;
    private javax.swing.JLabel va4;
    private javax.swing.JLabel va5;
    private javax.swing.JLabel va6;
    private javax.swing.JCheckBox vaNo;
    private javax.swing.JCheckBox vaSi;
    // End of variables declaration//GEN-END:variables

}
