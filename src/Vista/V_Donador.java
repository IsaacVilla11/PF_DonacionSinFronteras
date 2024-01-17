package Vista;

public class V_Donador extends javax.swing.JFrame {

 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpSecciones = new javax.swing.JPanel();
        jpEncabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        BtnDonarAlimentos = new javax.swing.JButton();
        btnDonarMedi = new javax.swing.JButton();
        btnDonarMUbeles = new javax.swing.JButton();
        BtnDonarRopa = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSecciones.setBackground(new java.awt.Color(0, 204, 255));
        jpSecciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jpSecciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 505, -1, 496));

        jpEncabezado.setBackground(new java.awt.Color(182, 214, 222));

        jLabel1.setFont(new java.awt.Font("Castellar", 3, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO DONADOR");

        javax.swing.GroupLayout jpEncabezadoLayout = new javax.swing.GroupLayout(jpEncabezado);
        jpEncabezado.setLayout(jpEncabezadoLayout);
        jpEncabezadoLayout.setHorizontalGroup(
            jpEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEncabezadoLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addContainerGap(769, Short.MAX_VALUE))
        );
        jpEncabezadoLayout.setVerticalGroup(
            jpEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEncabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jpEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 100));

        Contenido.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        jPanel1.add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 980, 590));

        jPanel2.setBackground(new java.awt.Color(182, 214, 222));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setBackground(new java.awt.Color(139, 227, 249));
        btnInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInicio.setText("INICIO");
        btnInicio.setBorder(null);
        btnInicio.setContentAreaFilled(false);
        jPanel2.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 40));

        BtnDonarAlimentos.setBackground(new java.awt.Color(139, 227, 249));
        BtnDonarAlimentos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnDonarAlimentos.setText("DONAR ALIMENTOS");
        BtnDonarAlimentos.setBorder(null);
        BtnDonarAlimentos.setContentAreaFilled(false);
        jPanel2.add(BtnDonarAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 40));

        btnDonarMedi.setBackground(new java.awt.Color(139, 227, 249));
        btnDonarMedi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDonarMedi.setText("DONAR MEDICINA");
        btnDonarMedi.setBorder(null);
        btnDonarMedi.setContentAreaFilled(false);
        jPanel2.add(btnDonarMedi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 200, 50));

        btnDonarMUbeles.setBackground(new java.awt.Color(139, 227, 249));
        btnDonarMUbeles.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDonarMUbeles.setText("DONAR MUEBLES");
        btnDonarMUbeles.setBorder(null);
        btnDonarMUbeles.setContentAreaFilled(false);
        jPanel2.add(btnDonarMUbeles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        BtnDonarRopa.setBackground(new java.awt.Color(139, 227, 249));
        BtnDonarRopa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnDonarRopa.setText("DONAR ROPA");
        BtnDonarRopa.setBorder(null);
        BtnDonarRopa.setContentAreaFilled(false);
        jPanel2.add(BtnDonarRopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 60));

        btnReporte.setBackground(new java.awt.Color(139, 227, 249));
        btnReporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReporte.setText("REPORTE");
        btnReporte.setBorder(null);
        btnReporte.setContentAreaFilled(false);
        jPanel2.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, 60));

        btnregresar.setBackground(new java.awt.Color(139, 227, 249));
        btnregresar.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/usuario.png"))); // NOI18N
        btnregresar.setText("Cerrar sesión");
        jPanel2.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 200, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDonarAlimentos;
    private javax.swing.JButton BtnDonarRopa;
    public static javax.swing.JPanel Contenido;
    private javax.swing.JButton btnDonarMUbeles;
    private javax.swing.JButton btnDonarMedi;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpEncabezado;
    private javax.swing.JPanel jpSecciones;
    // End of variables declaration//GEN-END:variables
}
