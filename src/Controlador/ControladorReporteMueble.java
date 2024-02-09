package Controlador;

import Modelo.ConexionPg;
import Modelo.ModeloMueble;
import Modelo.ModeloRopa;
import Modelo.Mueble;
import Modelo.Ropa;
import Vista.VP_Mueble;
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
public class ControladorReporteMueble {

    private VP_Mueble vistaMueble;

    public ControladorReporteMueble(VP_Mueble vistaMueble) {
        this.vistaMueble = vistaMueble;
        vistaMueble.setVisible(true);
        cargarDatosEnTablaMueble();
        cargarIdsMuebleEnComboBox();
    }

    public void iniciarControl() {
        vistaMueble.getBtnConsultarId().addActionListener(l -> buscarMueblePorId());
        vistaMueble.getBtnConsultarEstado().addActionListener(l -> buscarMueblePorEstado());
        vistaMueble.getBtnConsultarTipo().addActionListener(l -> buscarMueblePorTipo());
        vistaMueble.getBtnTodos().addActionListener(l -> cargarDatosEnTablaMueble());
        vistaMueble.getBtnReportePdf().addActionListener(l -> reporteMueble());
        vistaMueble.getBtnReporteEstado().addActionListener(l -> reporteMuebleEstado());
        vistaMueble.getBtnReporteTipo().addActionListener(l -> reporteMuebleTipo());
    }

    private void cargarDatosEnTablaMueble() {
        // Obtener la lista de detalles de ropa desde el modelo
        List<Mueble> listaDetallesMueble = ModeloMueble.obtenerDetallesMueble();

        // Crear un DefaultTableModel con las columnas necesarias
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Material");
        modeloTabla.addColumn("Tamaño");
        modeloTabla.addColumn("Precio");

        // Llenar el modelo de la tabla con los datos de la lista de detalles de ropas
        for (Mueble detalle : listaDetallesMueble) {
            Object[] fila = {
                detalle.getId_mueb(),
                detalle.getTipo(),
                detalle.getEstado(),
                detalle.getMaterial_mue(),
                detalle.getTamaño_mue(),
                detalle.getPrecio()
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo de la tabla en la vista
        vistaMueble.getTblMueble().setModel(modeloTabla);
    }

    public void actualizarTabla(List<Mueble> listaMueble) {
        DefaultTableModel modeloTabla = new DefaultTableModel();

        // Definir las columnas de la tabla
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Material");
        modeloTabla.addColumn("Tamaño");
        modeloTabla.addColumn("Precio");

        // Agregar filas a la tabla
        for (Mueble detalle : listaMueble) {
            Object[] fila = {
                detalle.getId_mueb(),
                detalle.getTipo(),
                detalle.getEstado(),
                detalle.getMaterial_mue(),
                detalle.getTamaño_mue(),
                detalle.getPrecio()
            };
            modeloTabla.addRow(fila);
        }

        // Asignar el modelo de tabla actualizado a tu JTable
        vistaMueble.getTblMueble().setModel(modeloTabla);
    }

    private void cargarIdsMuebleEnComboBox() {
        List<Integer> idsMueble = ModeloMueble.obtenerIdsMueble();
        vistaMueble.getCbxCodigosMuebles().removeAllItems();
        for (int idMueble : idsMueble) {
            // Convertir el entero a cadena antes de agregarlo al JComboBox
            vistaMueble.getCbxCodigosMuebles().addItem(String.valueOf(idMueble));
        }
    }

    public void buscarMueblePorId() {
        String idFiltroStr = vistaMueble.getCbxCodigosMuebles().getSelectedItem().toString();
        int id = Integer.parseInt(idFiltroStr);
        // Llamar al modelo para buscar la ropa por ID
        List<Mueble> resultado = ModeloMueble.buscarMueblePorId(id);

        // Actualizar la tabla en la vista con los resultados
        actualizarTabla(resultado);
    }

    public void buscarMueblePorTipo() {
        String tipo = vistaMueble.getCbxTipoMueble().getSelectedItem().toString();
        List<Mueble> resultado = ModeloMueble.buscarMueblePorTipo(tipo);

        // Actualizar la tabla en la vista con los resultados
        actualizarTabla(resultado);
    }

    public void buscarMueblePorEstado() {
        String estado = vistaMueble.getCbxEstado1().getSelectedItem().toString();
        List<Mueble> resultado = ModeloMueble.buscarMueblePorEstado(estado);

        // Actualizar la tabla en la vista con los resultados
        actualizarTabla(resultado);
    }

    private void reporteMueble() {
        ConexionPg connection = new ConexionPg();
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/Vista/Reportes/ReporteMueble.jasper") // colocar el nombre del archivo.jasper
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

    private void reporteMuebleEstado() {
        ConexionPg connection = new ConexionPg();
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/Vista/Reportes/ReporteMuebleEstado.jasper")
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

    private void reporteMuebleTipo() {
        ConexionPg connection = new ConexionPg();
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/Vista/Reportes/ReporteMuebleTipo.jasper") // colocar el nombre del archivo.jasper
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
