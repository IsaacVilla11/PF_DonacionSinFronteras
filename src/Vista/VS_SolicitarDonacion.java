package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class VS_SolicitarDonacion extends javax.swing.JPanel {

    /**
     * Creates new form VS_SolicitarDonacion
     */
    public VS_SolicitarDonacion() {
        initComponents();
    }

    public JButton getBtnEnviarSolic() {
        return btnEnviarSolic;
    }

    public JDateChooser getFecha_solictd() {
        return fecha_solictd;
    }

    public JTextArea getjTextAreaREQUERIMIENTOS() {
        return jTextAreaREQUERIMIENTOS;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fecha_solictd = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaREQUERIMIENTOS = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnEnviarSolic = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 51, 166));
        jLabel1.setText("SOLICITAR DONACION");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 11, 267, 31));

        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("REQUERIMINETOS  DE LA SOLICITUD:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("FECHA DE SOLICITUD:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));
        jPanel1.add(fecha_solictd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 139, -1));

        jTextAreaREQUERIMIENTOS.setColumns(20);
        jTextAreaREQUERIMIENTOS.setRows(5);
        jScrollPane2.setViewportView(jTextAreaREQUERIMIENTOS);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 560, 140));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 620, 20));

        btnEnviarSolic.setBackground(new java.awt.Color(20, 51, 166));
        btnEnviarSolic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEnviarSolic.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviarSolic.setText("ENVIAR SOLICITUD ");
        btnEnviarSolic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEnviarSolic.setBorderPainted(false);
        jPanel1.add(btnEnviarSolic, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 180, 40));

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaREQUERIMIENTOS;
    // End of variables declaration//GEN-END:variables
}
