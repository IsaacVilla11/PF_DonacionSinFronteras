/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author ASUS
 */
public class V_EstadoSolicitud extends javax.swing.JFrame {

    /**
     * Creates new form V_EstadoSolicitud
     */
    public V_EstadoSolicitud() {
        initComponents();
    }

    public JButton getBtnAprobar() {
        return btnAprobar;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public JComboBox<String> getjCboxIDsolicitud() {
        return jCboxIDsolicitud;
    }

    public JCheckBox getjCheckBoxAPRUEBA() {
        return jCheckBoxAPRUEBA;
    }

    public JDateChooser getjDateFechaAprob() {
        return jDateFechaAprob;
    }

    public JTable getTabla_solicitudes() {
        return tabla_solicitudes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_solicitudes = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateFechaAprob = new com.toedter.calendar.JDateChooser();
        jCboxIDsolicitud = new javax.swing.JComboBox<>();
        btnAprobar = new javax.swing.JButton();
        jCheckBoxAPRUEBA = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 51, 166));
        jLabel1.setText("ESTADO SOLICITUDES");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 30));

        tabla_solicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA DE APROBACION", "ESTADO", "ID SOLICITUD "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_solicitudes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 780, 190));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 530, 20));

        btnRegresar.setBackground(new java.awt.Color(20, 51, 166));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorderPainted(false);
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 100, 30));

        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("ID Solicitud:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 10));

        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Fecha De Aprobacion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 10));

        jDateFechaAprob.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.add(jDateFechaAprob, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 160, -1));

        jCboxIDsolicitud.setForeground(new java.awt.Color(0, 0, 102));
        jCboxIDsolicitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jCboxIDsolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 140, -1));

        btnAprobar.setBackground(new java.awt.Color(20, 51, 166));
        btnAprobar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAprobar.setForeground(new java.awt.Color(255, 255, 255));
        btnAprobar.setText("ENVIAR");
        btnAprobar.setBorderPainted(false);
        jPanel1.add(btnAprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 170, 40));

        jCheckBoxAPRUEBA.setForeground(new java.awt.Color(0, 0, 102));
        jCheckBoxAPRUEBA.setText("APRUEBA");
        jPanel1.add(jCheckBoxAPRUEBA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAprobar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> jCboxIDsolicitud;
    private javax.swing.JCheckBox jCheckBoxAPRUEBA;
    private com.toedter.calendar.JDateChooser jDateFechaAprob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla_solicitudes;
    // End of variables declaration//GEN-END:variables
}
