/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author ASUS
 */
public class VA_Solicitudes extends javax.swing.JFrame {

    /**
     * Creates new form VA_Solicitudes
     */
    public VA_Solicitudes() {
        initComponents();
    }

    public JButton getBtnAprobar() {
        return btnAprobar;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
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
        btnAprobar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 51, 166));
        jLabel1.setText("SOLICITUDES");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 30));

        tabla_solicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO DE SOLICITANTE ", "CODIGO DE SOLICIUD", "FECHA ", "REQUERIMIENTOS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_solicitudes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 190));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 650, 20));

        btnAprobar.setBackground(new java.awt.Color(20, 51, 166));
        btnAprobar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAprobar.setForeground(new java.awt.Color(255, 255, 255));
        btnAprobar.setText("APROBAR SOLICITUDES");
        btnAprobar.setBorderPainted(false);
        jPanel1.add(btnAprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 780, 40));

        btnRegresar.setBackground(new java.awt.Color(20, 51, 166));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegresar.setBorderPainted(false);
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 90, 30));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla_solicitudes;
    // End of variables declaration//GEN-END:variables
}
