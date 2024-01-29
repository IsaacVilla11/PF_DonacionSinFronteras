package Vista;

public class VS_SolicitarDonacion extends javax.swing.JPanel {

    /**
     * Creates new form VS_SolicitarDonacion
     */
    public VS_SolicitarDonacion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codSolicitud = new javax.swing.JTextField();
        fecha_solictd = new com.toedter.calendar.JDateChooser();
        txt_codSolicitante = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnEnviarSolic = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 51, 166));
        jLabel1.setText("SOLICITAR DONACION");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 11, 267, 31));

        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("CODIGO DE SOLICITUD:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("REQUERIMINETOS  DE LA SOLICITUD:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("FECHA DE SOLICITUD:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("CODIGO DE SOLICITANTE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 10));
        jPanel1.add(txt_codSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 80, 30));
        jPanel1.add(fecha_solictd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 139, -1));
        jPanel1.add(txt_codSolicitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 74, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 320, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 620, 20));

        btnEnviarSolic.setBackground(new java.awt.Color(20, 51, 166));
        btnEnviarSolic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEnviarSolic.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviarSolic.setText("ENVIAR SOLICITUD ");
        btnEnviarSolic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEnviarSolic.setBorderPainted(false);
        jPanel1.add(btnEnviarSolic, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 180, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarSolic;
    private com.toedter.calendar.JDateChooser fecha_solictd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txt_codSolicitante;
    private javax.swing.JTextField txt_codSolicitud;
    // End of variables declaration//GEN-END:variables
}
