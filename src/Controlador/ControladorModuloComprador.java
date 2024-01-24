package Controlador;

import Modelo.ConexionPg;
import Modelo.ModeloComprador;
import Modelo.TablaImagenRender;
import Vista.VC_Inicio;
import Vista.VC_Productos;
import Vista.VC_Reporte;
import Vista.V_Comprador;
import static Vista.V_Comprador.Contenido;
import Vista.V_Principal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author IV
 */
public class ControladorModuloComprador {

    V_Comprador vistaModCom; // Principal y unica vista

    public ControladorModuloComprador(V_Comprador vistaModCom) {
        this.vistaModCom = vistaModCom;
        this.vistaModCom.setVisible(true);  // ---> Estas llamando a la vista del modeloCotrolador del parametro, coloca this

        initVentanaInicio(); // o ShowJPanel(new VC_Inicio());
    }

    /*
        Inicializaciones 
     */
    public void iniciarControl() {

        //ajustarAltoFilas();
        //crearTablaConImagenes();
        vistaModCom.getBtnregresar().addActionListener(l -> regresesarMenuPrincipal());
        vistaModCom.getBtnInicio().addActionListener(l -> initVentanaInicio());
        vistaModCom.getBtnProductos().addActionListener(l -> initProductoVenta());
        vistaModCom.getBtnReporte().addActionListener(l -> initReporteCompras());

    }

    public void initVentanaInicio() {
        VC_Inicio view = new VC_Inicio();
        ShowJPanel(view);
    }

    public void initProductoVenta() {
        VC_Productos view = new VC_Productos();

        ShowJPanel(view);

        view.getBtnAgregar().addActionListener(l -> agregarCarrito(view));
        view.getBtnReset().addActionListener(l -> System.out.println("Boton de RESETEO"));
        view.getBtnPagar().addActionListener(l -> System.out.println("Boton de PAGAR"));
        view.getBtnDelete().addActionListener(l -> System.out.println("Boton de DELETE"));

    }

    public void initReporteCompras() {
        VC_Reporte view = new VC_Reporte();
        ShowJPanel(view);
        view.getBtnImprimir().addActionListener(e -> {
            imprimirReporteComp();
        });

    }

    // metodo para generar reporte de compras en jasper
    public void imprimirReporteComp() {
        ConexionPg connection = new ConexionPg();
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/Vista/Reportes/reporteCompraProductos.jasper") // colocar el nombre del archivo.jasper
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

    public void regresesarMenuPrincipal() {
        vistaModCom.dispose();
        V_Principal vista = new V_Principal();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorMenuPrincipal controP = new ControladorMenuPrincipal(vista);
        controP.iniciarControl();

    }

    // Método para ajustar el alto de las filas del JTable en función del tamaño de las imágenes
    private void ajustarAltoFilas(VC_Productos view) {
        try {
            for (int row = 0; row < view.getTablaProductos().getRowCount(); row++) {
                int rowHeight = view.getTablaProductos().getRowHeight();

                // Obtenemos el JLabel de la columna de imágenes
                JLabel imagenLabel = (JLabel) view.getTablaProductos().getValueAt(row, 2); // el numero corresponde al numero de columna de imagen

                // Verificamos si hay una imagen en la celda y ajustamos el alto de la fila
                if (imagenLabel != null) {
                    int imgHeight = imagenLabel.getPreferredSize().height;
                    if (imgHeight > rowHeight) {
                        view.getTablaProductos().setRowHeight(row, imgHeight);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No hay imagenes de productos");
        }

    }
    // Método para crear la tabla y cargar los datos desde la base de datos

    public void crearTablaConImagenes(VC_Productos view) {
        ModeloComprador mimodel = new ModeloComprador();
        try {
            DefaultTableModel modelo = mimodel.obtenerModeloTablaDesdeBD();
            view.getTablaProductos().setModel(modelo);

            // Configuramos el renderizador personalizado
            view.getTablaProductos().getColumnModel().getColumn(2).setCellRenderer(new TablaImagenRender());
        } catch (Exception e) {
            System.out.println("No hay imagenes de productos");
            System.out.println(e);
        }

    }

    // metodo seleccionar un producto y click en botn agregar al un jtable susproductos
    public void agregarCarrito(VC_Productos view) {
        int filaSeleccionada = view.getTablaProductos().getSelectedRow();
        try {
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Aún no ha seleccionado una fila");
            } else {
                int cantidadProductos = (int) view.getSpnCantidad().getValue();
                if (cantidadProductos > 0) {

                    // Obtener los valores de las celdas de la fila seleccionada
                    Object[] rowData = new Object[view.getTablaProductos().getColumnCount() + 1]; // Añadir una columna para la cantidad de productos
                    for (int i = 0; i < view.getTablaProductos().getColumnCount(); i++) {
                        rowData[i] = view.getTablaProductos().getValueAt(filaSeleccionada, i);
                    }
                    rowData[view.getTablaProductos().getColumnCount()] = cantidadProductos; // Agregar la cantidad de productos

                    // Agregar la fila al modelo de tabla "susProductos"
                    DefaultTableModel modeloSusProductos = (DefaultTableModel) view.getTblSusProductos().getModel();
                    modeloSusProductos.addRow(rowData);
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad de productos debe ser mayor a 0");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void ShowJPanel(JPanel p) {
        p.setSize(897, 547);
        p.setLocation(0, 0);

        Contenido.removeAll();
        Contenido.add(p, BorderLayout.CENTER);
        Contenido.revalidate();
        Contenido.repaint();
    }
}
