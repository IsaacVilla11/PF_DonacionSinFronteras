package Controlador;

import Modelo.ConexionPg;
import Modelo.ModeloRopa;
import Modelo.Ropa;
import Vista.VP_Ropa;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author IV
 */
public class ControladorReporteRopa {

    private VP_Ropa vistaRopa;

    public ControladorReporteRopa(VP_Ropa vistaRopa) {
        this.vistaRopa = vistaRopa;
        vistaRopa.setVisible(true);
        cargarDatosEnTabla();
        cargarIdsRopaEnComboBox();
    }

    public void iniciarControl() {
        vistaRopa.getBtnConsultarId().addActionListener(l -> buscarRopaPorId());
        vistaRopa.getBtnConsultarEstado().addActionListener(l -> buscarRopaPorEstado());
        vistaRopa.getBtnConsultarTalla().addActionListener(l -> buscarRopaPorTalla());
        vistaRopa.getBtnConsultarTipo().addActionListener(l -> buscarRopaPorTipo());
        vistaRopa.getBtnTodos().addActionListener(l -> cargarDatosEnTabla());
        vistaRopa.getBtnReportePdf().addActionListener(l -> reporteRopa());
        vistaRopa.getBtnReporteEstado().addActionListener(l -> reporteRopaEstado());
        vistaRopa.getBtnReporteTalla().addActionListener(l -> reporteRopaTalla());
        vistaRopa.getBtnReporteTipo().addActionListener(l -> reporteRopaTipo());
    }

    private void cargarDatosEnTabla() {
        // Obtener la lista de detalles de ropa desde el modelo
        List<Ropa> listaDetallesRopa = ModeloRopa.obtenerDetallesRopa();

        // Crear un DefaultTableModel con las columnas necesarias
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Talla");
        modeloTabla.addColumn("Precio");

        // Llenar el modelo de la tabla con los datos de la lista de detalles de ropas
        for (Ropa detalle : listaDetallesRopa) {
            Object[] fila = {
                detalle.getId_rop(),
                detalle.getTipo(),
                detalle.getEstado(),
                detalle.getTalla_rop(),
                detalle.getPrecio()
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo de la tabla en la vista
        vistaRopa.getTblRopa().setModel(modeloTabla);
    }

    public void actualizarTabla(List<Ropa> listaRopa) {
        DefaultTableModel modeloTabla = new DefaultTableModel();

        // Definir las columnas de la tabla
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Talla");
        modeloTabla.addColumn("Precio");

        // Agregar filas a la tabla
        for (Ropa ropa : listaRopa) {
            Object[] fila = {
                ropa.getId_rop(),
                ropa.getTipo(),
                ropa.getEstado(),
                ropa.getTalla_rop(),
                ropa.getPrecio()
            };
            modeloTabla.addRow(fila);
        }

        // Asignar el modelo de tabla actualizado a tu JTable
        vistaRopa.getTblRopa().setModel(modeloTabla);
    }

    private void cargarIdsRopaEnComboBox() {
        List<Integer> idsRopa = ModeloRopa.obtenerIdsRopa();
        vistaRopa.getCbxCodigosRopa().removeAllItems();
        for (int idRopa : idsRopa) {
            // Convertir el entero a cadena antes de agregarlo al JComboBox
            vistaRopa.getCbxCodigosRopa().addItem(String.valueOf(idRopa));
        }
    }

    public void buscarRopaPorId() {
        String idFiltroStr = vistaRopa.getCbxCodigosRopa().getSelectedItem().toString();
        int id = Integer.parseInt(idFiltroStr);
        // Llamar al modelo para buscar la ropa por ID
        List<Ropa> resultado = ModeloRopa.buscarRopaPorId(id);

        // Actualizar la tabla en la vista con los resultados
        actualizarTabla(resultado);
    }

    public void buscarRopaPorTipo() {
        String tipo = vistaRopa.getCbxTipoRopa().getSelectedItem().toString();
        List<Ropa> resultado = ModeloRopa.buscarRopaPorTipo(tipo);

        // Actualizar la tabla en la vista con los resultados
        actualizarTabla(resultado);
    }

    public void buscarRopaPorEstado() {
        String estado = vistaRopa.getCbxEstado().getSelectedItem().toString();
        List<Ropa> resultado = ModeloRopa.buscarRopaPorEstado(estado);

        // Actualizar la tabla en la vista con los resultados
        actualizarTabla(resultado);
    }

    public void buscarRopaPorTalla() {
        String talla = vistaRopa.getCbxTalla().getSelectedItem().toString();
        List<Ropa> resultado = ModeloRopa.buscarRopaPorTalla(talla);

        // Actualizar la tabla en la vista con los resultados
        actualizarTabla(resultado);
    }

    private void reporteRopa() {
        ConexionPg connection = new ConexionPg();
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/Vista/Reportes/ReporteRopa.jasper") // colocar el nombre del archivo.jasper
            );

            JasperPrint jp = JasperFillManager.fillReport(
                    reporte,
                    null,
                    connection.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("NO se abre el report");
        }
    }

    private void reporteRopaEstado() {
        ConexionPg connection = new ConexionPg();
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/Vista/Reportes/ReporteRopaEstado.jasper")
            );

            JasperPrint jp = JasperFillManager.fillReport(reporte, null, connection.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            // Manejo específico de excepciones de JasperReports
            ex.printStackTrace();
            System.err.println("Error al generar el reporte: " + ex.getMessage());
        } catch (Exception ex) {
            // Otros tipos de excepciones
            ex.printStackTrace();
            System.err.println("Error desconocido: " + ex.getMessage());
        } finally {
            // Cerrar la conexión a la base de datos
            if (connection != null) {
                connection.cerrarConexion();
            }
        }
    }

    private void reporteRopaTipo() {
        ConexionPg connection = new ConexionPg();
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/Vista/Reportes/ReporteRopaTipo.jasper") // colocar el nombre del archivo.jasper
            );

            JasperPrint jp = JasperFillManager.fillReport(
                    reporte,
                    null,
                    connection.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("NO se abre el report");
        }
    }

    private void reporteRopaTalla() {
        ConexionPg connection = new ConexionPg();
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/Vista/Reportes/ReporteRopaTalla.jasper") // colocar el nombre del archivo.jasper
            );

            JasperPrint jp = JasperFillManager.fillReport(
                    reporte,
                    null,
                    connection.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("NO se abre el report");
        }
    }
}
