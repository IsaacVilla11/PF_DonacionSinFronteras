package Controlador;

import Modelo.*;
import Vista.V_ModuloProducto;
import Vista.vistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IV
 */
public class ControladorModuloProductos {

    private V_ModuloProducto vistaModProducto;
    private Timer timer;
    ImageIcon icon = new ImageIcon("src\\Vista\\Iconos\\iconoExito.png");
    byte[] imagenBytes;

    public ControladorModuloProductos(V_ModuloProducto vistaModProducto) {
        this.vistaModProducto = vistaModProducto;
        vistaModProducto.setVisible(true);
        cargarDatosEnTabla();
        deshabilitarCamposRopa();
        cargarIdsRopaEnComboBox();
        cargarIdsCamposRopa();
    }
    // <editor-fold desc="">
    // </editor-fold>

    public void iniciarControl() {
        vistaModProducto.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
        //Ventana Ropa
        vistaModProducto.getBtnAyuda().addActionListener(l -> ayuda());
        vistaModProducto.getBtnCrear().addActionListener(l -> crearRopa());
        vistaModProducto.getBtnConsultar().addActionListener(l -> consultarRopa());
        vistaModProducto.getBtnModificar().addActionListener(l -> modificarRopa());
        vistaModProducto.getBtnEliminar().addActionListener(l -> eliminarRopa());
        vistaModProducto.getBtnReporte().addActionListener(l -> reporteRopa());
        vistaModProducto.getBtnCargarImagen().addActionListener(l -> cargarImagen());
        vistaModProducto.getBtnImagenProducto().addActionListener(l -> mostrarImagenEnDialogoEmergente());
        vistaModProducto.getBtnLimpiar().addActionListener(l -> limpiarCamposRopa());

    }

    // <editor-fold desc="Metodos para el crud de ropa">
    private void crearRopa() {
        Connection conexion = null;

        try {
            // Crear un objeto Producto con los datos adecuados de cada componente
            String tipoProducto = vistaModProducto.getTxtTipoProducto().getText();
            boolean disponibilidadProducto = vistaModProducto.getChbxDisponibliidad_Producto_Si().isSelected();
            String nombreProducto = vistaModProducto.getTxtNombreProducto().getText();

            Producto producto = new Producto(tipoProducto, disponibilidadProducto, nombreProducto, imagenBytes);

            // Iniciar la transacción
            conexion = new ConexionPg().getCon();
            conexion.setAutoCommit(false);

            // Llamar al método insertarProducto
            int idProducto = ModeloProducto.insertarProducto(producto);

            if (idProducto != -1) {
                System.out.println("Producto insertado correctamente. ID generado: " + idProducto);

                // Crear un objeto TipoVendible con los datos necesarios
                TipoVendible tipoVendible = new TipoVendible();

                String precioVendibleStr = vistaModProducto.getTxtPrecioVendible().getText();
                double precioVendible = precioVendibleStr.isEmpty() ? 0.0 : Double.parseDouble(precioVendibleStr);
                String tipo = vistaModProducto.getCbxTipoRopa().getSelectedItem().toString();
                if (tipo.equals("Seleccionar")) {
                    tipo = "N/A";
                }

                tipoVendible.setPrecio(precioVendible);
                tipoVendible.setTipo(tipo);
                tipoVendible.setId_pro_ven(idProducto); // ID del producto generado

                // Llamar al método insertarTipoVendible del modelo para insertar el registro
                int idTipoVendible = ModeloTipoVendible.insertarTipoVendible(tipoVendible);

                if (idTipoVendible != -1) {
                    System.out.println("Registro TipoVendible insertado con éxito. ID generado: " + idTipoVendible);

                    // Crear un objeto Ropa con los datos necesarios
                    Ropa ropa = new Ropa();

                    //Atributos de Ropa
                    String marca = vistaModProducto.getTxtMarca().getText();
                    if (marca.equals("")) {
                        marca = "N/A";
                    }

                    String talla = vistaModProducto.getCbxTalla().getSelectedItem().toString();
                    if (talla.equals("Seleccionar")) {
                        talla = "N/A";
                    }
                    String color = vistaModProducto.getCbxColor().getSelectedItem().toString();
                    if (color.equals("Seleccionar")) {
                        color = "N/A";
                    }

                    ropa.setMarca_rop(marca);
                    ropa.setTalla_rop(talla);
                    ropa.setColor_rop(color);
                    ropa.setId_vendible_rop(idTipoVendible); // ID del TipoVendible generado

                    // Llamar al método insertarRopa del modelo para insertar el registro
                    int idRopa = ModeloRopa.insertarRopa(ropa);

                    if (idRopa != -1) {
                        System.out.println("Registro de Ropa insertado con éxito. ID generado: " + idRopa);
                        mostrarMensaje("CREACION EXITOSA", 1000, icon);
                        cargarDatosEnTabla();
                        limpiarCamposRopa();
                        cargarIdsCamposRopa();
                        cargarIdsRopaEnComboBox();
                        // Confirmar la transacción
                        conexion.commit();
                    } else {
                        // Si hay un error en la inserción de Ropa, hacer rollback
                        conexion.rollback();
                        JOptionPane.showMessageDialog(vistaModProducto, "Error al crear el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Error al insertar el registro de Ropa.");
                    }
                } else {
                    // Si hay un error en la inserción de TipoVendible, hacer rollback
                    conexion.rollback();
                    System.out.println("Error al insertar el registro TipoVendible.");
                }
            } else {
                // Si hay un error en la inserción de Producto, hacer rollback
                conexion.rollback();
                System.out.println("Error al insertar el producto.");
            }
        } catch (SQLException ex) {
            // Manejar la excepción de SQL
            ex.printStackTrace();
            System.err.println("Error durante la transacción: " + ex.getMessage());

            try {
                // En caso de excepción, hacer rollback
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error al realizar rollback: " + e.getMessage());
            }
        } finally {
            try {
                // Restaurar la configuración de autocommit
                if (conexion != null) {
                    conexion.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error al restaurar autocommit: " + e.getMessage());
            }
        }
    }

    private void consultarRopa() {
        // Obtener el código seleccionado del ComboBox
        String codigoSeleccionado = vistaModProducto.getCbxCodigosRopa().getSelectedItem().toString();

        // Convertir el código a un entero
        int idRopaSeleccionado = Integer.parseInt(codigoSeleccionado);

        // Obtener la Ropa correspondiente al ID seleccionado
        Ropa ropaSeleccionada = ModeloRopa.obtenerRopaPorId(idRopaSeleccionado);

        // Verificar si se encontró la Ropa
        if (ropaSeleccionada != null) {
            // Mostrar los datos en los campos correspondientes de Ropa
            vistaModProducto.getTxtCodigoRopa().setText(String.valueOf(ropaSeleccionada.getId_rop()));
            vistaModProducto.getTxtMarca().setText(ropaSeleccionada.getMarca_rop());
            vistaModProducto.getCbxTalla().setSelectedItem(ropaSeleccionada.getTalla_rop());
            vistaModProducto.getCbxColor().setSelectedItem(ropaSeleccionada.getColor_rop());

            // Obtener el TipoVendible asociado a la Ropa
            TipoVendible tipoVendibleAsociado = ModeloTipoVendible.obtenerTipoVendiblePorId(ropaSeleccionada.getId_vendible_rop());

            // Verificar si se encontró el TipoVendible
            if (tipoVendibleAsociado != null) {
                // Mostrar los datos en los campos correspondientes de TipoVendible
                vistaModProducto.getTxtCodigoVendible().setText(String.valueOf(tipoVendibleAsociado.getId_vendible()));
                vistaModProducto.getTxtPrecioVendible().setText(String.valueOf(tipoVendibleAsociado.getPrecio()));
                vistaModProducto.getCbxTipoRopa().setSelectedItem(tipoVendibleAsociado.getTipo());

                // Obtener el Producto asociado al TipoVendible
                Producto productoAsociado = ModeloProducto.obtenerProductoPorId(tipoVendibleAsociado.getId_pro_ven());

                // Verificar si se encontró el Producto
                if (productoAsociado != null) {
                    // Mostrar los datos en los campos correspondientes de Producto
                    vistaModProducto.getTxtCodigoProducto().setText(String.valueOf(productoAsociado.getId_producto()));
                    vistaModProducto.getTxtTipoProducto().setText(productoAsociado.getTipo_pro());
                    vistaModProducto.getChbxDisponibliidad_Producto_Si().setSelected(productoAsociado.isDisponibilidad_pro());
                    vistaModProducto.getTxtNombreProducto().setText(productoAsociado.getNombre_pro());
                    if (productoAsociado.getImagen_pro() != null) {
                        ImageIcon imagen = new ImageIcon(productoAsociado.getImagen_pro());
                        vistaModProducto.getBtnImagenProducto().setIcon(imagen);
                    } else {
                        // Si la imagen es nula, eliminar la imagen del botón
                        vistaModProducto.getBtnImagenProducto().setIcon(null);
                    }
                    // Otros campos del Producto...

                    mostrarMensaje("CONSULTA EXITOSA", 1000, icon);
                } else {
                    System.out.println("Error: No se encontró el Producto asociado al TipoVendible");
                }
            } else {
                System.out.println("Error: No se encontró el TipoVendible asociado a la Ropa");

            }
        } else {
            System.out.println("Error: No se encontró la Ropa con el ID especificado");
        }
    }

    private void modificarRopa() {
        mostrarMensaje("MODIFICACION EXITOSA", 1000, icon);
    }

    private void eliminarRopa() {
        
        mostrarMensaje("ELIMINACION EXITOSA", 1000, icon);
    }

    private void reporteRopa() {
        mostrarMensaje("REPORTE EXITOSO", 1000, icon);
    }

    private void limpiarCamposRopa() {
        //vistaModProducto.getTxtCodigoRopa().setText("");
        //vistaModProducto.getTxtCodigoProducto().setText("");
        //vistaModProducto.getTxtCodigoVendible().setText("");
        vistaModProducto.getTxtNombreProducto().setText("");
        vistaModProducto.getTxtMarca().setText("");
        vistaModProducto.getCbxTalla().setSelectedIndex(0);
        vistaModProducto.getCbxColor().setSelectedIndex(0);
        vistaModProducto.getCbxTipoRopa().setSelectedIndex(0);
        vistaModProducto.getBtnImagenProducto().setIcon(null);
        //vistaModProducto.getChbxDisponibliidad_Producto_Si().setSelected(false);
        vistaModProducto.getTxtPrecioVendible().setText("");
        cargarIdsCamposRopa();

    }

    private void deshabilitarCamposRopa() {
        vistaModProducto.getTxtCodigoRopa().setEditable(false);
        vistaModProducto.getTxtCodigoProducto().setEditable(false);
        vistaModProducto.getTxtCodigoVendible().setEditable(false);
        vistaModProducto.getChbxDisponibliidad_Producto_Si().setEnabled(false);
        vistaModProducto.getTxtTipoProducto().setEditable(false);

    }

    private void cargarIdsRopaEnComboBox() {
        List<Integer> idsRopa = ModeloRopa.obtenerIdsRopa();
        vistaModProducto.getCbxCodigosRopa().removeAllItems();
        for (int idRopa : idsRopa) {
            // Convertir el entero a cadena antes de agregarlo al JComboBox
            vistaModProducto.getCbxCodigosRopa().addItem(String.valueOf(idRopa));
        }
    }

    private void cargarDatosEnTabla() {
        // Obtener la lista de ropas desde el modelo
        List<Ropa> listaRopas = ModeloRopa.obtenerTodasLasRopas();

        // Crear un DefaultTableModel con las columnas necesarias
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Talla");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("ID Vendible");

        // Llenar el modelo de la tabla con los datos de la lista de ropas
        for (Ropa ropa : listaRopas) {
            Object[] fila = {
                ropa.getId_rop(),
                ropa.getMarca_rop(),
                ropa.getTalla_rop(),
                ropa.getColor_rop(),
                ropa.getId_vendible_rop()
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo de la tabla en la vista
        vistaModProducto.getTblRopa().setModel(modeloTabla);
    }

    private void cargarIdsCamposRopa() {
        int idUltimoRopa = ModeloRopa.obtenerUltimoIdRopa();
        vistaModProducto.getTxtCodigoRopa().setText(String.valueOf(idUltimoRopa + 1));
        int idUltimoTipoVendible = ModeloTipoVendible.obtenerUltimoIdTipoVendible();
        vistaModProducto.getTxtCodigoVendible().setText(String.valueOf(idUltimoTipoVendible + 1));
        int idUltimoProducto = ModeloProducto.obtenerUltimoIdProducto();
        vistaModProducto.getTxtCodigoProducto().setText(String.valueOf(idUltimoProducto + 1));
    }

    // </editor-fold>
    // <editor-fold desc="Metodos utiles">
    private void regresarModuloAdmin() {
        vistaModProducto.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }

    private void ayuda() {
        JOptionPane.showMessageDialog(null, "Aqui se encuentra la ventana para el registro de ropa"
                + "\nBotones "
                + "\n1. Crear: En este boton se guardara los datos ingresados en los campos del formulario en la base de datos,"
                + "\n                 los datos ingresados deben pertenecer a su tipo de dato correspondiente."
                + "\n2. Consultar: Este boton realizara una consulta de los registros en la base de datos."
                + "\n3. Modificar: Este boton modificara los datos que se ingresan en los campos, cuando se hace una consulta."
                + "\n4. Eliminar: Este boton eliminara un registro de la base de datos."
                + "\n5. Reporte: Este boton realizara una actualizacion en la tabla de los registros de la base de datos.");
    }

    private String rutaImagenSeleccionada;

    private byte[] obtenerBytesImagen(String rutaImagen) {
        try {
            // Leer la imagen desde el archivo en la ruta especificada
            File file = new File(rutaImagen);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            fis.close();

            // Obtener el arreglo de bytes de la imagen
            byte[] imagenBytes = bos.toByteArray();
            bos.close();
            return imagenBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void cargarImagen() {
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        if (jf.showOpenDialog(vistaModProducto) == JFileChooser.APPROVE_OPTION) {
            rutaImagenSeleccionada = jf.getSelectedFile().toString();

            // Mostrar la imagen en el botón btnImagenProducto
            vistaModProducto.getBtnImagenProducto().setIcon(new ImageIcon(rutaImagenSeleccionada));

            // Obtener los bytes de la imagen y guardarlos en la variable imagenBytes
            imagenBytes = obtenerBytesImagen(rutaImagenSeleccionada);
        }
    }

    private void mostrarImagenEnDialogoEmergente() {
        // Obtener la imagen actual del botón
        Icon imagenActual = vistaModProducto.getBtnImagenProducto().getIcon();

        // Si el botón no tiene una imagen, no hacemos nada
        if (imagenActual == null) {
            return;
        }

        // Crear un componente JLabel para mostrar la imagen en el diálogo emergente
        JLabel lblImagen = new JLabel(imagenActual);

        // Crear un diálogo emergente de JOptionPane para mostrar la imagen
        JOptionPane.showMessageDialog(vistaModProducto, lblImagen, "Imagen del Producto", JOptionPane.PLAIN_MESSAGE);
    }

    // Método para mostrar el mensaje en el JLabel durante un tiempo determinado
    private void mostrarMensaje(String mensaje, int duracionMillisegundos, Icon icono) {
        vistaModProducto.getMensajeExito().setText(mensaje);
        vistaModProducto.getMensajeExito().setIcon(icono); // Establecer el icono en el JLabel

        // Iniciar el temporizador para ocultar el mensaje después de la duración especificada
        timer = new Timer(duracionMillisegundos, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ocultarMensaje();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void ocultarMensaje() {
        vistaModProducto.getMensajeExito().setText("");
        vistaModProducto.getMensajeExito().setIcon(null);
    }
    // </editor-fold>
}
