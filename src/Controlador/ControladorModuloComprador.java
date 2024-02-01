package Controlador;

import Modelo.Comprador;
import Modelo.ConexionPg;
import Modelo.DetalleFactura;
import Modelo.EncabezadoFactura;
import Modelo.ModeloComprador;
import Modelo.ModeloDetalleFactura;
import Modelo.ModeloEncabezadoFact;
import Modelo.ModeloReportProduct;
import Modelo.Producto;
import Modelo.TablaImagenRender;
import Vista.Login_Comprador;
import Vista.VC_Inicio;
import Vista.VC_Productos;
import Vista.VC_Reporte;
import Vista.V_Comprador;
import static Vista.V_Comprador.Contenido;
import Vista.V_Principal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
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

    String cedula;
    V_Comprador vistaModCom; // Principal y unica vista
    ModeloReportProduct modProduct=new ModeloReportProduct();
    

    public ControladorModuloComprador(V_Comprador vistaModCom, String cedula) {
        this.vistaModCom = vistaModCom;
        this.vistaModCom.setVisible(true);  // ---> Estas llamando a la vista del modeloCotrolador del parametro, coloca this
        this.cedula = cedula;
        initVentanaInicio(); // o ShowJPanel(new VC_Inicio());
    }

    /*
        Inicializaciones 
     */
    public void iniciarControl() {
        sacarFecha();
        vistaModCom.getBtnregresar().addActionListener(l -> regresesarMenuPrincipal());
        vistaModCom.getBtnInicio().addActionListener(l -> initVentanaInicio());
        vistaModCom.getBtnProductos().addActionListener(l -> initProductoVenta());
        vistaModCom.getBtnReporte().addActionListener(l -> initReporteCompras());

    }

    public void cargarTablaReport(VC_Reporte report){
         
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("ID Factura");
        tb.addColumn("FECHA");
        tb.addColumn("TOTAL");
       

        List<EncabezadoFactura> EnF = modProduct.obtenerReport();
        System.out.println("Tamaño" + EnF.size());
        EnF.forEach(p -> {
            Object[] rowData = {
                p.getId_encabezadoFact(),
                p.getFecha_fact(),
              //  p.,
                p.getTotal()
               
            };
            tb.addRow(rowData);
        });

        report.getTblReportCompras().setModel(tb);
    }
    public void initVentanaInicio() {
        VC_Inicio view = new VC_Inicio();
        ShowJPanel(view);
    }

    public void initProductoVenta() {
        VC_Productos view = new VC_Productos();
        crearTablaConImagenes(view);
        ajustarAltoFilas(view);
        ShowJPanel(view);

        view.getBtnAgregar().addActionListener(l -> agregarCarrito(view));
        view.getBtnReset().addActionListener(l -> resetProductos(view));
        view.getBtnPagar().addActionListener(l -> procesarCompra(view));
        view.getBtnDelete().addActionListener(l -> eliminarSeleccionProduct(view));

    }

    // metodo para sacarla fecha actual
    public void sacarFecha() {
        vistaModCom.getLblFecha().setText(DateTimeFormatter.ofPattern("MMM dd yyyy").format(LocalDateTime.now()));

    }

    public void initReporteCompras() {
        VC_Reporte view = new VC_Reporte();
        ShowJPanel(view);
        cargarTablaReport(view);
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
                    Object[] rowData = new Object[4]; // Se añaden 3 columnas: idProducto, precio, cantidad

                    rowData[0] = view.getTablaProductos().getValueAt(filaSeleccionada, 0); // idProducto
                    rowData[1] = cantidadProductos; // cantidad
                    rowData[2] = view.getTablaProductos().getValueAt(filaSeleccionada, 1); // precio
                    rowData[3] = Double.parseDouble(rowData[2].toString()) * cantidadProductos;
                    // Calcular el subtotal (precio * cantidad)
                    //double precio = Double.parseDouble(rowData[2].toString());
                    //double subtotal = precio * cantidadProductos;

                    // Obtener el total acumulado actual
                    double totalAcumulado = 0.0;
                    try {
                        totalAcumulado = Double.parseDouble(view.getTxtSubtotal().getText());
                    } catch (NumberFormatException e) {
                        // Si el campo está vacío, establecer el total acumulado a 0.0
                        totalAcumulado = 0.0;
                    }

                    // Sumar el subtotal al total acumulado
                    totalAcumulado += Double.parseDouble(rowData[3].toString());

                    // Actualizar el JTextField del subtotal con el total acumulado
                    view.getTxtSubtotal().setText(String.valueOf(totalAcumulado));
                    view.getTxtSubtotal().setEditable(false);

                    // actualizo el JTextField del total con lo acumulado del subtotal
                    view.getTxtTotal().setText(String.valueOf(totalAcumulado));
                    view.getTxtTotal().setEditable(false);
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

    // metodo para vaciar el jtable susProductos
    public void resetProductos(VC_Productos view) {
        DefaultTableModel modeloSusProductos = (DefaultTableModel) view.getTblSusProductos().getModel();
        modeloSusProductos.setRowCount(0); // Elimina todas las filas del modelo
        view.getTxtSubtotal().setText("0.0"); // Establece el subtotal a 0.0
        view.getTxtTotal().setText("0.0");
    }

    // metodo para eliminar fila seleccionada
    public void eliminarSeleccionProduct(VC_Productos view) {
        DefaultTableModel modeloSusProductos = (DefaultTableModel) view.getTblSusProductos().getModel();
        int filaSeleccionada = view.getTblSusProductos().getSelectedRow();

        if (filaSeleccionada != -1) {
            modeloSusProductos.removeRow(filaSeleccionada);

            // Recalcular subtotal después de eliminar la fila
            recalcularSubtotal(view);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }

    private void recalcularSubtotal(VC_Productos view) {
        DefaultTableModel modeloSusProductos = (DefaultTableModel) view.getTblSusProductos().getModel();
        double subtotal = 0.0;

        for (int i = 0; i < modeloSusProductos.getRowCount(); i++) {
            double precio = Double.parseDouble(modeloSusProductos.getValueAt(i, 1).toString());
            int cantidad = Integer.parseInt(modeloSusProductos.getValueAt(i, 2).toString());

            subtotal += precio * cantidad;
        }

        view.getTxtSubtotal().setText(String.valueOf(subtotal));
        view.getTxtTotal().setText(String.valueOf(subtotal));
    }

    public void procesarCompra(VC_Productos view) {
        boolean pagado = true;
        ModeloEncabezadoFact enca = new ModeloEncabezadoFact();
        ModeloDetalleFactura deta = new ModeloDetalleFactura();

        try {
            // 1. Obtener valores de la interfaz
            LocalDate fechaFactura = LocalDate.now();
            enca.setFecha_fact(java.sql.Date.valueOf(fechaFactura));

            double totalFactura = Double.parseDouble(view.getTxtTotal().getText());
            enca.setTotal(totalFactura);

            // Asigna el ID del comprador al encabezado de factura
            enca.setId_comprador_fact(enca.traerCodigoDePersonaCrear(cedula));

            if (enca.insertaEncabezadoFact(enca.traerCodigoDePersonaCrear(cedula))) {
                // Obtener el id_encabezadoFact recién insertado
                int idEncabezadoFact = enca.obtenerUltimoIdEncabezado();

                if (idEncabezadoFact > 0) {
                    // Asignar el id_encabezadoFact al modelo DetalleFactura
                    deta.setId_encabezadoFact_det(idEncabezadoFact);

                    for (int j = 0; j < view.getTblSusProductos().getRowCount(); j++) {

                        deta.setId_pro_det(Integer.valueOf(view.getTblSusProductos().getValueAt(j, 0).toString()));

                        deta.setCant_produ_det(Integer.valueOf(view.getTblSusProductos().getValueAt(j, 1).toString()));

                        deta.setSubtotal_det(Double.valueOf(view.getTblSusProductos().getValueAt(j, 3).toString()));

                        if (!deta.insertaDetalleFact()) {
                            JOptionPane.showMessageDialog(view, "No se guardó");
                            pagado = false;
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo obtener el id_encabezadoFact");
                }
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo registrar el encabezado");
            }
            if (pagado) {
                JOptionPane.showMessageDialog(view, "Su compra se efectuó exitosamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            JOptionPane.showMessageDialog(view, "Error al procesar la compra");
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
