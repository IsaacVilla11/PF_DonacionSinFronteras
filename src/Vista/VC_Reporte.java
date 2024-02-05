/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorModuloComprador;
import Modelo.ConexionPg;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class VC_Reporte extends javax.swing.JPanel {

    /**
     * Creates new form VC_Reporte
     */
    public VC_Reporte() {
        initComponents();
    }


    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JTable getTblReportCompras() {
        return tblReportCompras;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReportCompras = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(897, 495));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel1.setText("FACTURAS GENERADAS:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 25, -1, -1));

        tblReportCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "FACTURA", "CANTIDAD", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReportCompras);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 63, -1, 347));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/solicitante-login.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 50, -1, -1));

        btnImprimir.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 428, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReportCompras;
    // End of variables declaration//GEN-END:variables
}
