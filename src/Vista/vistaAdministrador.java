package Vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;

/**
 *
 * @author jose
 */
public class vistaAdministrador extends javax.swing.JFrame {

    public vistaAdministrador() {
        initComponents();
    }

    public vistaAdministrador(JButton btnDonaciones) {
        this.btnDonaciones = btnDonaciones;
    }

    public JButton getBtnDonaciones() {
        return btnDonaciones;
    }

    public JMenuItem getJmiRegistroTransporte() {
        return jmiRegistroTransporte;
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public JButton getBtnLists() {
        return btnLists;
    }

    public JMenuItem getJmiRegistroComprador() {
        return jmiRegistroComprador;
    }

    public JMenuItem getJmiRegistroDonante() {
        return jmiRegistroDonante;
    }

    public JMenuItem getJmiCrudSolicitante() {
        return jmiCrudSolicitante;
    }

    public JButton getBtnSolicitudes() {
        return BtnSolicitudes;
    }

    
    public JMenuItem getJmiCrudAdmin() {
        return jmiCrudAdmin;
    }

    public JButton getBtnCA() {
        return btnCA;
    }

    public JButton getBtnLA() {
        return btnLA;
    }

    public JButton getBtnTables() {
        return btnTables;
    }

    public JButton getBtnCentroAcopio() {
        return btnCentroAcopio;
    }

    public JButton getBtnLugarAyuda() {
        return btnLugarAyuda;
    }

    public JMenuItem getJmitemAlimentos() {
        return jmitemAlimentos;
    }

    public JMenuItem getJmitemCiudad() {
        return jmitemCiudad;
    }

    public JMenuItem getJmitemMedicamentos() {
        return jmitemMedicamentos;
    }

    public JMenuItem getJmitemMueble() {
        return jmitemMueble;
    }

  

    public JMenuItem getJmitemRopa() {
        return jmitemRopa;
    }

    public JTable getTableRegistros() {
        return tableRegistros;
    }

    public JLabel getLblmsjRegistro() {
        return lblmsjRegistro;
    }

    public JMenuItem getJmiModuloProducto() {
        return jmiModuloProducto;
    }

    public JMenuItem getRConductor() {
        return RConductor;
    }

    public JMenuItem getRcamiones() {
        return Rcamiones;
    }

    public JList<String> getListAdm() {
        return listAdm;
    }

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        btnCentroAcopio = new javax.swing.JButton();
        btnLugarAyuda = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnDonaciones = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        BtnSolicitudes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAdm = new javax.swing.JList<>();
        btnCerrarSesion = new javax.swing.JButton();
        lblmsjRegistro = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnLA = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCA = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnTables = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jScrollPane2 = new javax.swing.JScrollPane();
        btnLists = new javax.swing.JButton();
        tableRegistros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jmiCrudSolicitante = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiRegistroDonante = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmiRegistroComprador = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        RConductor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiCrudAdmin = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jmiModuloProducto = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jmitemRopa = new javax.swing.JMenuItem();
        jmitemMueble = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jmitemMedicamentos = new javax.swing.JMenuItem();
        jmitemAlimentos = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jmitemCiudad = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jmiRegistroTransporte = new javax.swing.JMenuItem();
        sa = new javax.swing.JMenu();
        Rcamiones = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 255, 248));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCentroAcopio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCentroAcopio.setForeground(new java.awt.Color(20, 51, 166));
        btnCentroAcopio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/flecha-hacia-abajo-para-navegar (1).png"))); // NOI18N
        btnCentroAcopio.setText("Centros de Acopio");
        btnCentroAcopio.setBorderPainted(false);
        btnCentroAcopio.setContentAreaFilled(false);
        jPanel3.add(btnCentroAcopio, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 16, -1, -1));

        btnLugarAyuda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLugarAyuda.setForeground(new java.awt.Color(20, 51, 166));
        btnLugarAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/flecha-hacia-abajo-para-navegar (1).png"))); // NOI18N
        btnLugarAyuda.setText("  Lugares de Ayuda");
        btnLugarAyuda.setBorderPainted(false);
        btnLugarAyuda.setContentAreaFilled(false);
        jPanel3.add(btnLugarAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 16, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDonaciones.setForeground(new java.awt.Color(20, 51, 166));
        btnDonaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/donacion.png"))); // NOI18N
        btnDonaciones.setText("Donaciones");
        btnDonaciones.setBorderPainted(false);
        btnDonaciones.setContentAreaFilled(false);
        jPanel1.add(btnDonaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        jButton6.setForeground(new java.awt.Color(20, 51, 166));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/camion.png"))); // NOI18N
        jButton6.setText("Conductor");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 130, -1));

        BtnSolicitudes.setForeground(new java.awt.Color(20, 51, 166));
        BtnSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/mensajes.png"))); // NOI18N
        BtnSolicitudes.setText("Solicitudes");
        BtnSolicitudes.setBorderPainted(false);
        BtnSolicitudes.setContentAreaFilled(false);
        jPanel1.add(BtnSolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 130, 30));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 140, 100));

        listAdm.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listAdm);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 290));

        btnCerrarSesion.setBackground(new java.awt.Color(20, 51, 166));
        btnCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setBorderPainted(false);
        jPanel3.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 140, 40));

        lblmsjRegistro.setForeground(new java.awt.Color(20, 51, 166));
        lblmsjRegistro.setText("Registros");
        jPanel3.add(lblmsjRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 250, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(20, 51, 166));
        jLabel5.setText(":PDSF");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        btnLA.setText("Lugares de Ayuda");
        btnLA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btnLA.setContentAreaFilled(false);
        btnLA.setFocusable(false);
        btnLA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnLA);

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jToolBar1.add(jSeparator1);

        btnCA.setText("Centro de acopio");
        btnCA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btnCA.setContentAreaFilled(false);
        btnCA.setFocusable(false);
        btnCA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCA);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jToolBar1.add(jSeparator2);

        btnTables.setText("Agregar");
        btnTables.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btnTables.setContentAreaFilled(false);
        btnTables.setFocusable(false);
        btnTables.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTables.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnTables);
        jToolBar1.add(jSeparator3);

        jPanel3.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 280, 20));
        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 820, 300));

        btnLists.setText("Cargar");
        jPanel3.add(btnLists, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 80, -1));

        tableRegistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tableRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jPanel3.add(tableRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/admm.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-650, 410, -1, 250));

        jMenuBar1.setBackground(new java.awt.Color(102, 204, 255));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/usuario (1).png"))); // NOI18N
        jMenu2.setText("Usuarios");

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/solicitud.png"))); // NOI18N
        jMenu4.setText("Solicitante");

        jmiCrudSolicitante.setText("Crud");
        jMenu4.add(jmiCrudSolicitante);

        jMenu2.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/donantes.png"))); // NOI18N
        jMenu5.setText("Donante");

        jmiRegistroDonante.setText("Registro");
        jMenu5.add(jmiRegistroDonante);

        jMenu2.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/comprador.png"))); // NOI18N
        jMenu6.setText("Comprador");

        jmiRegistroComprador.setText("Registro");
        jMenu6.add(jmiRegistroComprador);

        jMenu2.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/chofer.png"))); // NOI18N
        jMenu7.setText("Conductor");

        RConductor.setText("Crud");
        jMenu7.add(RConductor);

        jMenu2.add(jMenu7);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/candado.png"))); // NOI18N
        jMenu3.setText("Administradores");

        jmiCrudAdmin.setText("Crud");
        jMenu3.add(jmiCrudAdmin);

        jMenuBar1.add(jMenu3);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/products.png"))); // NOI18N
        jMenu11.setText("Productos ");

        jmiModuloProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/InconoRegistro.png"))); // NOI18N
        jmiModuloProducto.setText("Registro");
        jMenu11.add(jmiModuloProducto);

        jMenu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/Money.png"))); // NOI18N
        jMenu12.setText("Tipo Vendible");

        jmitemRopa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/ropa.png"))); // NOI18N
        jmitemRopa.setText("Ropa");
        jMenu12.add(jmitemRopa);

        jmitemMueble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/mueble.png"))); // NOI18N
        jmitemMueble.setText("Mueble");
        jMenu12.add(jmitemMueble);

        jMenu11.add(jMenu12);

        jMenu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/donacion.png"))); // NOI18N
        jMenu13.setText("Tipo Donable");

        jmitemMedicamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/medicine.png"))); // NOI18N
        jmitemMedicamentos.setText("Medicamentos");
        jMenu13.add(jmitemMedicamentos);

        jmitemAlimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/diet.png"))); // NOI18N
        jmitemAlimentos.setText("Alimentos");
        jMenu13.add(jmitemAlimentos);

        jMenu11.add(jMenu13);

        jMenuBar1.add(jMenu11);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/iconoCiudad.png"))); // NOI18N
        jMenu9.setText("Ciudad");

        jmitemCiudad.setText("Resgistro");
        jMenu9.add(jmitemCiudad);

        jMenuBar1.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/InconoRegistro.png"))); // NOI18N
        jMenu10.setText("Registros");

        jmiRegistroTransporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/InconoRegistro.png"))); // NOI18N
        jmiRegistroTransporte.setText("Registro Transporte");
        jMenu10.add(jmiRegistroTransporte);

        jMenuBar1.add(jMenu10);

        sa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/camion.png"))); // NOI18N
        sa.setText("Camion");

        Rcamiones.setText("Registrar Camion");
        sa.add(Rcamiones);

        jMenuBar1.add(sa);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/pagina-de-inicio (1).png"))); // NOI18N
        jMenu8.setText("Inicio");
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSolicitudes;
    private javax.swing.JMenuItem RConductor;
    private javax.swing.JMenuItem Rcamiones;
    private javax.swing.JButton btnCA;
    private javax.swing.JButton btnCentroAcopio;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnDonaciones;
    private javax.swing.JButton btnLA;
    private javax.swing.JButton btnLists;
    private javax.swing.JButton btnLugarAyuda;
    private javax.swing.JButton btnTables;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem jmiCrudAdmin;
    private javax.swing.JMenuItem jmiCrudSolicitante;
    private javax.swing.JMenuItem jmiModuloProducto;
    private javax.swing.JMenuItem jmiRegistroComprador;
    private javax.swing.JMenuItem jmiRegistroDonante;
    private javax.swing.JMenuItem jmiRegistroTransporte;
    private javax.swing.JMenuItem jmitemAlimentos;
    private javax.swing.JMenuItem jmitemCiudad;
    private javax.swing.JMenuItem jmitemMedicamentos;
    private javax.swing.JMenuItem jmitemMueble;
    private javax.swing.JMenuItem jmitemRopa;
    private javax.swing.JLabel lblmsjRegistro;
    private javax.swing.JList<String> listAdm;
    private javax.swing.JMenu sa;
    private javax.swing.JTable tableRegistros;
    // End of variables declaration//GEN-END:variables
}
