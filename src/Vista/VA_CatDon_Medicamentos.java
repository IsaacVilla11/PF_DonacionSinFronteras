package Vista;

public class VA_CatDon_Medicamentos extends javax.swing.JPanel {

    public VA_CatDon_Medicamentos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        disponibilidad = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        mensajeExito = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxFormaFarmac = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        datFechaElaboracion = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnReporte = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        datFechaVencimiento = new com.toedter.calendar.JDateChooser();
        va2 = new javax.swing.JLabel();
        mensaje1 = new javax.swing.JLabel();
        va3 = new javax.swing.JLabel();
        chbxDisponibliidad_Producto_Si = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtTipoProducto = new javax.swing.JTextField();
        txtCodigoMedicamento = new javax.swing.JTextField();
        va6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        spnCantidadDonables = new javax.swing.JSpinner();
        va5 = new javax.swing.JLabel();
        va1 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtCodigoDonable = new javax.swing.JTextField();
        btnImagenProducto = new javax.swing.JButton();
        btnCargarImagen = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        spnCantidadProducto = new javax.swing.JSpinner();
        va4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        vaSi = new javax.swing.JCheckBox();
        cbxCodigosMedicamentos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicamentos = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mensajeExito.setBackground(new java.awt.Color(0, 204, 255));
        mensajeExito.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        mensajeExito.setForeground(new java.awt.Color(0, 204, 255));
        mensajeExito.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mensajeExito.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(mensajeExito, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 220, 70));

        jLabel10.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nombre/Descripcion:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 120, -1));

        jLabel11.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Forma farmaceutica: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Imagen:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Fecha de vencimiento : ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 120, -1));

        cbxFormaFarmac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Tableta", "Cápsula", "Jarabe", "Inyección", "Crema", "Ungüento", "Suspensión", "Supositorio", "Solución (oral, inyectable, etc.)", "Aerosol", "Emulsión", "Gel", "Parche transdérmico", "Polvo para reconstitución", "Comprimido masticable", "Gotas oftálmicas", "Pastilla sublingual", "Loción", "Aerosol nasal", "Líquido oral", "Polvo para inhalación", "Granulado", "Polvo efervescente", "Polvo para suspensión oral", "Polvo para uso tópico", "Comprimido efervescente", "Gragea", "Cápsula de liberación prolongada", "Cápsula de liberación modificada", "Crema tópica de liberación prolongada", "Comprimido recubierto", "Comprimido de liberación prolongada", "Cápsula de gelatina blanda", "Inyectable de liberación prolongada", "Supositorio de liberación prolongada", "Pellet (gránulos pequeños)", "Tableta bucodispersable", "Polvo para solución inyectable", "Polvo para solución nasal", "Otros" }));
        cbxFormaFarmac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFormaFarmacActionPerformed(evt);
            }
        });
        jPanel1.add(cbxFormaFarmac, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 240, 30));

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
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 130, 50));

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
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 130, 50));

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
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 130, 50));

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
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 130, 50));
        jPanel1.add(datFechaElaboracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 140, -1));

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

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/interrogacion2.jpg"))); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 100, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 204, 255));
        jSeparator3.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 1050, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 204, 255));
        jSeparator4.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setPreferredSize(new java.awt.Dimension(5, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 20, 300));

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
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 450, 130, 50));

        jLabel16.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Fecha de elaboración : ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));
        jPanel1.add(datFechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 140, -1));

        va2.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va2.setForeground(new java.awt.Color(0, 0, 0));
        va2.setText("Codigo donable: ");
        jPanel1.add(va2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 100, -1));

        mensaje1.setBackground(new java.awt.Color(102, 255, 255));
        jPanel1.add(mensaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 60, 10));

        va3.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va3.setForeground(new java.awt.Color(0, 0, 0));
        va3.setText("Tipo producto:  ");
        jPanel1.add(va3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, -1));

        disponibilidad.add(chbxDisponibliidad_Producto_Si);
        chbxDisponibliidad_Producto_Si.setText("Si");
        jPanel1.add(chbxDisponibliidad_Producto_Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, 40, -1));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registro de medicamentos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        txtTipoProducto.setText("Donable");
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
        jPanel1.add(txtTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 110, 30));

        txtCodigoMedicamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoMedicamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoMedicamentoFocusLost(evt);
            }
        });
        txtCodigoMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCodigoMedicamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCodigoMedicamentoMouseExited(evt);
            }
        });
        txtCodigoMedicamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoMedicamentoKeyReleased(evt);
            }
        });
        jPanel1.add(txtCodigoMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 120, 30));

        va6.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va6.setForeground(new java.awt.Color(0, 0, 0));
        va6.setText("Disponibilidad:");
        jPanel1.add(va6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Codigo medicamento: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 130, -1));

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
        jPanel1.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 110, 30));
        jPanel1.add(spnCantidadDonables, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 70, -1));

        va5.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va5.setForeground(new java.awt.Color(0, 0, 0));
        va5.setText("Cantidad donable:");
        jPanel1.add(va5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, -1, -1));

        va1.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va1.setForeground(new java.awt.Color(0, 0, 0));
        va1.setText("Codigo producto: ");
        jPanel1.add(va1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 100, -1));

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
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 240, 30));

        txtCodigoDonable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoDonableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoDonableFocusLost(evt);
            }
        });
        txtCodigoDonable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCodigoDonableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCodigoDonableMouseExited(evt);
            }
        });
        txtCodigoDonable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoDonableActionPerformed(evt);
            }
        });
        txtCodigoDonable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoDonableKeyReleased(evt);
            }
        });
        jPanel1.add(txtCodigoDonable, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 110, 30));

        btnImagenProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnImagenProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/signo-de-interrogacion.png"))); // NOI18N
        btnImagenProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnImagenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 200, 130));

        btnCargarImagen.setBackground(new java.awt.Color(255, 255, 255));
        btnCargarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/AGREGAR FOTO.PNG"))); // NOI18N
        btnCargarImagen.setBorder(null);
        btnCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, 90));

        jLabel8.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Codigo medicamento: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 130, -1));
        jPanel1.add(spnCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 80, -1));

        va4.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        va4.setForeground(new java.awt.Color(0, 0, 0));
        va4.setText("Cantidad Productos:");
        jPanel1.add(va4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Datos de administrador");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, -1, -1));

        vaSi.setBorder(null);
        vaSi.setContentAreaFilled(false);
        vaSi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vaSi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver.png"))); // NOI18N
        vaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaSiActionPerformed(evt);
            }
        });
        jPanel1.add(vaSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 40, 30));

        cbxCodigosMedicamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxCodigosMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 130, 30));

        tblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMedicamentos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 640, 460));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/limpieza.png"))); // NOI18N
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 50, 40));

        jScrollPane3.setViewportView(jPanel1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 590));
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
    }//GEN-LAST:event_btnAyudaActionPerformed

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

    private void txtTipoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoProductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoKeyReleased

    private void txtCodigoMedicamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoMedicamentoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMedicamentoFocusGained

    private void txtCodigoMedicamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoMedicamentoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMedicamentoFocusLost

    private void txtCodigoMedicamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoMedicamentoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMedicamentoMouseEntered

    private void txtCodigoMedicamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoMedicamentoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMedicamentoMouseExited

    private void txtCodigoMedicamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoMedicamentoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMedicamentoKeyReleased

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

    private void txtCodigoDonableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoDonableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoDonableFocusGained

    private void txtCodigoDonableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoDonableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoDonableFocusLost

    private void txtCodigoDonableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoDonableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoDonableMouseEntered

    private void txtCodigoDonableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoDonableMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoDonableMouseExited

    private void txtCodigoDonableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoDonableKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoDonableKeyReleased

    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void txtCodigoDonableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoDonableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoDonableActionPerformed

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
    }//GEN-LAST:event_btnCargarImagenActionPerformed

    private void txtTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoActionPerformed

    private void cbxFormaFarmacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFormaFarmacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFormaFarmacActionPerformed

    private void btnImagenProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenProductoActionPerformed
    }//GEN-LAST:event_btnImagenProductoActionPerformed

    private void vaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaSiActionPerformed

    }//GEN-LAST:event_vaSiActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    }//GEN-LAST:event_btnLimpiarActionPerformed


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
    private javax.swing.JComboBox<String> cbxCodigosMedicamentos;
    private javax.swing.JComboBox<String> cbxFormaFarmac;
    private javax.swing.JCheckBox chbxDisponibliidad_Producto_Si;
    private com.toedter.calendar.JDateChooser datFechaElaboracion;
    private com.toedter.calendar.JDateChooser datFechaVencimiento;
    private javax.swing.ButtonGroup disponibilidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel mensaje1;
    private javax.swing.JLabel mensajeExito;
    private javax.swing.JSpinner spnCantidadDonables;
    private javax.swing.JSpinner spnCantidadProducto;
    private javax.swing.JTable tblMedicamentos;
    private javax.swing.JTextField txtCodigoDonable;
    private javax.swing.JTextField txtCodigoMedicamento;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtTipoProducto;
    private javax.swing.JLabel va1;
    private javax.swing.JLabel va2;
    private javax.swing.JLabel va3;
    private javax.swing.JLabel va4;
    private javax.swing.JLabel va5;
    private javax.swing.JLabel va6;
    private javax.swing.JCheckBox vaSi;
    // End of variables declaration//GEN-END:variables

}
