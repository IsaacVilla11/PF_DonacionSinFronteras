package Vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;

/**
 *
 * @author jose
 */
public class vistaAdministrador extends javax.swing.JFrame {

    public vistaAdministrador() {
        initComponents();
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public JMenuItem getJmiRegistroComprador() {
        return jmiRegistroComprador;
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

    public JDesktopPane getDeskRegistros() {
        return deskRegistros;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        deskRegistros = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnLA = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCA = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnTables = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jmiRegistroComprador = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jmiCrudAdmin = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(20, 51, 166));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/flecha-hacia-abajo-para-navegar (1).png"))); // NOI18N
        jButton3.setText("  Centros de ayuda");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 16, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(20, 51, 166));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/flecha-hacia-abajo-para-navegar (1).png"))); // NOI18N
        jButton4.setText("  Lugares de Acopio");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 16, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setForeground(new java.awt.Color(20, 51, 166));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/donacion.png"))); // NOI18N
        jButton7.setText("Donaciones");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        jButton6.setForeground(new java.awt.Color(20, 51, 166));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/camion.png"))); // NOI18N
        jButton6.setText("Conductor");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 130, -1));

        jButton5.setForeground(new java.awt.Color(20, 51, 166));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/mensajes.png"))); // NOI18N
        jButton5.setText("Solicitudes");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 130, 30));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 140, 100));

        deskRegistros.setBackground(new java.awt.Color(255, 255, 255));
        deskRegistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout deskRegistrosLayout = new javax.swing.GroupLayout(deskRegistros);
        deskRegistros.setLayout(deskRegistrosLayout);
        deskRegistrosLayout.setHorizontalGroup(
            deskRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        deskRegistrosLayout.setVerticalGroup(
            deskRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel3.add(deskRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 110, 820, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Aqui se muestra", "la cedula", "y nombre de ", "donantes", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 290));

        btnCerrarSesion.setBackground(new java.awt.Color(20, 51, 166));
        btnCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setBorderPainted(false);
        jPanel3.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 140, 40));

        jLabel2.setForeground(new java.awt.Color(20, 51, 166));
        jLabel2.setText("Registros");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabel3.setForeground(new java.awt.Color(20, 51, 166));
        jLabel3.setText("Donaciones registradas");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Aqui solo se mostraran las imagenes de las donaciones, mas nada");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 56, -1, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 990, 230));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/agregar.png"))); // NOI18N
        jButton1.setText("Agregar Donacion");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(20, 51, 166));
        jLabel5.setText(":PDSF");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jToolBar1.setRollover(true);

        btnLA.setText("Lugares de Ayuda");
        btnLA.setBorderPainted(false);
        btnLA.setContentAreaFilled(false);
        btnLA.setFocusable(false);
        btnLA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnLA);
        jToolBar1.add(jSeparator1);

        btnCA.setText("Centro de acopio");
        btnCA.setBorderPainted(false);
        btnCA.setContentAreaFilled(false);
        btnCA.setFocusable(false);
        btnCA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCA);
        jToolBar1.add(jSeparator2);

        btnTables.setText("Agregar");
        btnTables.setBorderPainted(false);
        btnTables.setContentAreaFilled(false);
        btnTables.setFocusable(false);
        btnTables.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTables.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnTables);

        jPanel3.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 320, 20));

        jMenuBar1.setBackground(new java.awt.Color(102, 204, 255));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/usuario (1).png"))); // NOI18N
        jMenu2.setText("Usuarios");

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/solicitud.png"))); // NOI18N
        jMenu4.setText("Solicitante");
        jMenu2.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/donantes.png"))); // NOI18N
        jMenu5.setText("Donante");
        jMenu2.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/comprador.png"))); // NOI18N
        jMenu6.setText("Comprador");

        jmiRegistroComprador.setText("Registro");
        jMenu6.add(jmiRegistroComprador);

        jMenu2.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/chofer.png"))); // NOI18N
        jMenu7.setText("Conductor");
        jMenu2.add(jMenu7);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/candado.png"))); // NOI18N
        jMenu3.setText("Administradores");

        jmiCrudAdmin.setText("Crud");
        jMenu3.add(jmiCrudAdmin);

        jMenuBar1.add(jMenu3);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/pagina-de-inicio (1).png"))); // NOI18N
        jMenu8.setText("Inicio");
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCA;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnLA;
    private javax.swing.JButton btnTables;
    private javax.swing.JDesktopPane deskRegistros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem jmiCrudAdmin;
    private javax.swing.JMenuItem jmiRegistroComprador;
    // End of variables declaration//GEN-END:variables
}
