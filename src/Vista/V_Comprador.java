package Vista;

import javax.swing.JButton;

public class V_Comprador extends javax.swing.JFrame {

    public V_Comprador() {
        initComponents();
    }

    public JButton getBtnregresar() {
        return btnregresar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpSecciones = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnRopa = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jpEncabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSecciones.setBackground(new java.awt.Color(255, 255, 255));
        jpSecciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("INICIO");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jpSecciones.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("PRODUCTOS");
        jpSecciones.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 140, 20));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        jLabel13.setText("CARRITO DE COMPRAS");
        jpSecciones.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        jLabel14.setText("FACTURA");
        jpSecciones.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 20));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        jLabel17.setText("REPORTE");
        jpSecciones.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 20));

        btnInicio.setBackground(new java.awt.Color(255, 255, 255));
        btnInicio.setBorder(null);
        jpSecciones.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 50));

        btnRopa.setBackground(new java.awt.Color(255, 255, 255));
        btnRopa.setBorder(null);
        jpSecciones.add(btnRopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 50));

        btnCompras.setBackground(new java.awt.Color(255, 255, 255));
        btnCompras.setBorder(null);
        jpSecciones.add(btnCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 190, 50));

        btnFactura.setBackground(new java.awt.Color(255, 255, 255));
        btnFactura.setBorder(null);
        jpSecciones.add(btnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 50));

        btnReporte.setBackground(new java.awt.Color(255, 255, 255));
        btnReporte.setBorder(null);
        jpSecciones.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 190, 50));

        btnregresar.setBackground(new java.awt.Color(255, 255, 255));
        btnregresar.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        btnregresar.setText("CERRAR SESION");
        btnregresar.setBorder(null);
        btnregresar.setBorderPainted(false);
        jpSecciones.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 140, 50));
        jpSecciones.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jPanel1.add(jpSecciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 106, -1, 519));

        jpEncabezado.setBackground(new java.awt.Color(255, 255, 255));
        jpEncabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 30)); // NOI18N
        jLabel1.setText("BIENVENIDO COMPRADOR");
        jpEncabezado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 367, 69));

        jLabel2.setFont(new java.awt.Font("Dubai", 1, 30)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/pngCarrito.png"))); // NOI18N
        jLabel2.setText(":PDSF");
        jpEncabezado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        jPanel1.add(jpEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1087, -1));

        Contenido.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 106, 897, 519));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Contenido;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnRopa;
    private javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpEncabezado;
    private javax.swing.JPanel jpSecciones;
    // End of variables declaration//GEN-END:variables
}
