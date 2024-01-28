package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class V_Comprador extends javax.swing.JFrame {

    public V_Comprador() {
        initComponents();
    }

    public JLabel getLblFecha() {
        return lblFecha;
    }
    
    public JButton getBtnregresar() {
        return btnregresar;
    }

    public static JPanel getContenido() {
        return Contenido;
    }

    public JButton getBtnFactura() {
        return btnFactura;
    }

    public JButton getBtnInicio() {
        return btnInicio;
    }

    public JButton getBtnProductos() {
        return btnProductos;
    }

    public JButton getBtnReporte() {
        return btnReporte;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpSecciones = new javax.swing.JPanel();
        btnProductos = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        jpEncabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSecciones.setBackground(new java.awt.Color(255, 255, 255));
        jpSecciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnProductos.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/producto-34.png"))); // NOI18N
        btnProductos.setText("       PRODUCTOS");
        btnProductos.setBorder(null);
        btnProductos.setBorderPainted(false);
        btnProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpSecciones.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, 50));

        btnFactura.setBackground(new java.awt.Color(255, 255, 255));
        btnFactura.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        btnFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/factura-34.png"))); // NOI18N
        btnFactura.setText("        FACTURA");
        btnFactura.setBorder(null);
        btnFactura.setBorderPainted(false);
        btnFactura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpSecciones.add(btnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, 50));

        btnReporte.setBackground(new java.awt.Color(255, 255, 255));
        btnReporte.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/Informe-24.png"))); // NOI18N
        btnReporte.setText("        REPORTE");
        btnReporte.setBorder(null);
        btnReporte.setBorderPainted(false);
        btnReporte.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpSecciones.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 170, 50));

        btnregresar.setBackground(new java.awt.Color(255, 255, 255));
        btnregresar.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/usuario.png"))); // NOI18N
        btnregresar.setText("CERRAR SESION");
        btnregresar.setBorder(null);
        btnregresar.setBorderPainted(false);
        jpSecciones.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 140, 50));

        btnInicio.setBackground(new java.awt.Color(255, 255, 255));
        btnInicio.setFont(new java.awt.Font("Dubai", 1, 11)); // NOI18N
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/pagina-de-inicio (1).png"))); // NOI18N
        btnInicio.setText("         INICIO");
        btnInicio.setBorder(null);
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpSecciones.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 170, 50));

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

        lblFecha.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jpEncabezado.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 110, 30));

        jPanel1.add(jpEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1087, -1));

        Contenido.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jPanel1.add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 106, -1, -1));

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
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpEncabezado;
    private javax.swing.JPanel jpSecciones;
    private javax.swing.JLabel lblFecha;
    // End of variables declaration//GEN-END:variables
}
