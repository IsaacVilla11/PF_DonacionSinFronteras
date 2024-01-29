package Controlador;

import Modelo.*;
import Vista.V_ModuloProducto;
import Vista.vistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JTextField;
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
        //vistaModProducto.getBtnCrear().setEnabled(true);
        vistaModProducto.getBtnEliminar().setEnabled(false);
        vistaModProducto.getBtnModificar().setEnabled(false);
        validacionesEventosKeyTyped();
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

            // Atributos de producto
            String tipoProducto = vistaModProducto.getTxtTipoProducto().getText();
            //Atributos de tipoVendible
            String precioVendibleStr = vistaModProducto.getTxtPrecioVendible().getText();
            double precioVendible = precioVendibleStr.isEmpty() ? 0.0 : Double.parseDouble(precioVendibleStr);
            String tipo = vistaModProducto.getCbxTipoRopa().getSelectedItem().toString();
            String estado = vistaModProducto.getCbxEstado().getSelectedItem().toString();
            //Atributos de ropa
            String talla = vistaModProducto.getCbxTalla().getSelectedItem().toString();

            // Validar que los campos requeridos estén llenos
            if ("Seleccionar".equals(talla) || "Seleccionar".equals(tipo) || "Seleccionar".equals(estado)) {
                JOptionPane.showMessageDialog(vistaModProducto, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si hay campos vacíos
            }
            Producto producto = new Producto(tipoProducto, imagenBytes);

            // Iniciar la transacción
            conexion = new ConexionPg().getCon();
            conexion.setAutoCommit(false);

            // Llamar al método insertarProducto
            int idProducto = ModeloProducto.insertarProducto(producto);

            if (idProducto != -1) {
                //System.out.println("Producto insertado correctamente. ID generado: " + idProducto);

                // Crear un objeto TipoVendible con los datos necesarios
                TipoVendible tipoVendible = new TipoVendible();

                tipoVendible.setPrecio(precioVendible);
                tipoVendible.setTipo(tipo);
                tipoVendible.setEstado(estado);
                tipoVendible.setId_pro_ven(idProducto); // ID del producto generado

                // Llamar al método insertarTipoVendible del modelo para insertar el registro
                int idTipoVendible = ModeloTipoVendible.insertarTipoVendible(tipoVendible);

                if (idTipoVendible != -1) {
                    //System.out.println("Registro TipoVendible insertado con éxito. ID generado: " + idTipoVendible);

                    // Crear un objeto Ropa con los datos necesarios
                    Ropa ropa = new Ropa();

                    ropa.setTalla_rop(talla);
                    ropa.setId_vendible_rop(idTipoVendible); // ID del TipoVendible generado

                    // Llamar al método insertarRopa del modelo para insertar el registro
                    int idRopa = ModeloRopa.insertarRopa(ropa);

                    if (idRopa != -1) {
                        //System.out.println("Registro de Ropa insertado con éxito. ID generado: " + idRopa);
                        mostrarMensaje("CREACION EXITOSA", 2000, icon);
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
        vistaModProducto.getBtnCrear().setEnabled(false);
        vistaModProducto.getBtnEliminar().setEnabled(true);
        vistaModProducto.getBtnModificar().setEnabled(true);

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
            vistaModProducto.getCbxTalla().setSelectedItem(ropaSeleccionada.getTalla_rop());

            // Obtener el TipoVendible asociado a la Ropa
            TipoVendible tipoVendibleAsociado = ModeloTipoVendible.obtenerTipoVendiblePorId(ropaSeleccionada.getId_vendible_rop());

            // Verificar si se encontró el TipoVendible
            if (tipoVendibleAsociado != null) {
                // Mostrar los datos en los campos correspondientes de TipoVendible
                vistaModProducto.getTxtCodigoVendible().setText(String.valueOf(tipoVendibleAsociado.getId_vendible()));
                vistaModProducto.getTxtPrecioVendible().setText(String.valueOf(tipoVendibleAsociado.getPrecio()));
                vistaModProducto.getCbxTipoRopa().setSelectedItem(tipoVendibleAsociado.getTipo());
                vistaModProducto.getCbxEstado().setSelectedItem(tipoVendibleAsociado.getEstado());

                // Obtener el Producto asociado al TipoVendible
                Producto productoAsociado = ModeloProducto.obtenerProductoPorId(tipoVendibleAsociado.getId_pro_ven());

                // Verificar si se encontró el Producto
                if (productoAsociado != null) {
                    // Mostrar los datos en los campos correspondientes de Producto
                    vistaModProducto.getTxtCodigoProducto().setText(String.valueOf(productoAsociado.getId_producto()));
                    vistaModProducto.getTxtTipoProducto().setText(productoAsociado.getTipo_pro());
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

        try {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de modificar este registro de ropa ?", "Confirmar modificacion", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                String idRopaStr = vistaModProducto.getTxtCodigoRopa().getText();
                int idRopa = Integer.parseInt(idRopaStr);
                Ropa ropa = ModeloRopa.obtenerRopaPorId(idRopa);

                if (ropa != null) {
                    //Atributos de Ropa

                    String talla = vistaModProducto.getCbxTalla().getSelectedItem().toString();

                    ropa.setTalla_rop(talla);

                    boolean resulModRopa = ModeloRopa.modificarRopa(ropa);
                    if (resulModRopa) {

                        System.out.println("Modifiacion exitosa de ropa");
                    } else {
                        JOptionPane.showMessageDialog(vistaModProducto, "Error al modificar la ropa.", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(vistaModProducto, "La ropa con id " + idRopa + " no existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);

                }
                //Modificar atributos de tipoVendible

                String idTipoVendibleStr = vistaModProducto.getTxtCodigoVendible().getText();
                int idTipoVendible = Integer.parseInt(idTipoVendibleStr);
                TipoVendible tipoVendible = ModeloTipoVendible.obtenerTipoVendiblePorId(idTipoVendible);
                if (tipoVendible != null) {
                    String precioVendibleStr = vistaModProducto.getTxtPrecioVendible().getText();
                    double precioVendible = precioVendibleStr.isEmpty() ? 0.0 : Double.parseDouble(precioVendibleStr);
                    String tipo = vistaModProducto.getCbxTipoRopa().getSelectedItem().toString();

                    String estado = vistaModProducto.getCbxEstado().getSelectedItem().toString();
                    tipoVendible.setPrecio(precioVendible);
                    tipoVendible.setTipo(tipo);
                    tipoVendible.setEstado(estado);
                    boolean resulModficacionTipoVendible = ModeloTipoVendible.modificarTipoVendible(tipoVendible);
                    if (resulModficacionTipoVendible) {
                        System.out.println("Modificaion exitosa de tipoVendible");

                    } else {
                        System.out.println("Error al modificar el tipoVendible");

                    }
                } else {
                    System.out.println("El id " + idTipoVendible + "de tipoVendible no existe en la base de datos");
                }
                //Modificar atributos de producto
                String idProductotr = vistaModProducto.getTxtCodigoProducto().getText();
                int idProducto = Integer.parseInt(idProductotr);

                Producto producto = ModeloProducto.obtenerProductoPorId(idProducto);

                if (producto != null) {
                    // Verificar si se ha seleccionado una nueva imagen y actualizar el atributo imagen_pro del producto
                    if (rutaImagenSeleccionada != null && !rutaImagenSeleccionada.isEmpty()) {
                        byte[] nuevaImagenBytes = obtenerBytesImagen(rutaImagenSeleccionada);
                        producto.setImagen_pro(nuevaImagenBytes);
                    }

                    boolean resulModficacionProducto = ModeloProducto.modificarProducto(producto);
                    if (resulModficacionProducto) {
                        System.out.println("Modificaion exitosa de producto");
                        mostrarMensaje("MODIFICACION EXITOSA", 2000, icon);

                        limpiarCamposRopa();
                        cargarDatosEnTabla();
                        vistaModProducto.getBtnCrear().setEnabled(true);
                    } else {
                        System.out.println("Error al modificar producto");

                    }
                } else {
                    System.out.println("El id " + idProducto + " de producto no existe en la base de datos");
                }
            } else {
                JOptionPane.showMessageDialog(vistaModProducto, "Modficacion cancelada");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al modificar atributos de ropa, tipovendible y ropa");
        }

    }

    private void eliminarRopa() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este registro de ropa ?", "Confirmar modificacion", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Obtener el ID de la Ropa seleccionada en el ComboBox
                String idRopaString = (String) vistaModProducto.getCbxCodigosRopa().getSelectedItem();
                int idRopa = Integer.parseInt(idRopaString);

                // Obtener el ID del TipoVendible asociado a la Ropa
                int idTipoVendible = ModeloRopa.obtenerIdTipoVendiblePorIdRopa(idRopa);

                // Obtener el ID del Producto asociado al TipoVendible
                int idProducto = ModeloTipoVendible.obtenerIdProductoPorIdTipoVendible(idTipoVendible);

                // Eliminar la Ropa (esto eliminará automáticamente el TipoVendible debido a la restricción de clave foránea)
                boolean eliminacionExitosaRopa = ModeloRopa.eliminarRopa(idRopa);

                // Verificar si la eliminación de la Ropa fue exitosa
                if (eliminacionExitosaRopa) {
                    // Eliminar el TipoVendible asociado
                    boolean eliminacionExitosaTipoVendible = ModeloTipoVendible.eliminarTipoVendible(idTipoVendible);

                    // Verificar si la eliminación del TipoVendible fue exitosa
                    if (eliminacionExitosaTipoVendible) {
                        // Eliminar el Producto asociado
                        boolean eliminacionExitosaProducto = ModeloProducto.eliminarProducto(idProducto);

                        // Verificar si la eliminación del Producto fue exitosa
                        if (eliminacionExitosaProducto) {
                            // Puedes mostrar un mensaje de éxito
                            mostrarMensaje("ELIMINACIÓN EXITOSA", 2000, icon);
                            cargarDatosEnTabla();
                            cargarIdsRopaEnComboBox();
                            limpiarCamposRopa();
                            return;
                        }
                    }
                }

                // Si algo falla, mostrar un mensaje de error
                JOptionPane.showMessageDialog(vistaModProducto, "ERROR AL ELIMINAR LA ROPA ", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException | NumberFormatException ex) {
                // Manejar posibles excepciones al obtener el ID seleccionado
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vistaModProducto, "ERROR AL OBTENER EL ID DE LA ROPA ", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(vistaModProducto, "Modficacion cancelada");
        }
    }

    private void reporteRopa() {

        mostrarMensaje("REPORTE EXITOSO", 1000, icon);
    }

    private void limpiarCamposRopa() {

        vistaModProducto.getCbxTalla().setSelectedIndex(0);
        vistaModProducto.getCbxTipoRopa().setSelectedIndex(0);
        vistaModProducto.getCbxEstado().setSelectedIndex(0);
        vistaModProducto.getBtnImagenProducto().setIcon(null);
        vistaModProducto.getTxtPrecioVendible().setText("");
        cargarIdsCamposRopa();
        vistaModProducto.getBtnCrear().setEnabled(true);
        vistaModProducto.getBtnEliminar().setEnabled(false);
        vistaModProducto.getBtnModificar().setEnabled(false);

    }

    private void deshabilitarCamposRopa() {
        vistaModProducto.getTxtCodigoRopa().setEditable(false);
        vistaModProducto.getTxtCodigoProducto().setEditable(false);
        vistaModProducto.getTxtCodigoVendible().setEditable(false);
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

    private void agregarValidacionCampoTexto(JTextField campoTexto, int longitudMaxima) {//para campos e texto
        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validarCampoTexto(e, campoTexto, longitudMaxima);
            }
        });
    }

    private void agregarValidacionCampoNumerico(JTextField campoTexto, int longitudMaxima) {
        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validarCampoNumerico(e, campoTexto, longitudMaxima);
            }
        });
    }

    private void validarCampoTexto(KeyEvent e, JTextField campoTexto, int longitudMaxima) {
        String texto = campoTexto.getText();
        char caracter = e.getKeyChar();
        boolean esLetra = Character.isLetter(caracter);
        boolean esEspacio = (caracter == ' ');
        boolean esRetroceso = (caracter == KeyEvent.VK_BACK_SPACE);
        boolean esEnter = (caracter == KeyEvent.VK_ENTER);

        if (!(esLetra || (texto.length() > 0 && esEspacio) || esRetroceso || esEnter)) {
            e.consume();
        } else if (texto.length() >= longitudMaxima) {
            e.consume();
        }
    }

    private void validarCampoNumerico(KeyEvent e, JTextField campoTexto, int longitudMaxima) {
        String texto = campoTexto.getText();
        char caracter = e.getKeyChar();
        boolean esDigito = Character.isDigit(caracter);
        boolean esPuntoDecimal = (caracter == '.');

        boolean esRetroceso = (caracter == KeyEvent.VK_BACK_SPACE);
        boolean esEnter = (caracter == KeyEvent.VK_ENTER);

        if (!(esDigito || esPuntoDecimal || esRetroceso || esEnter)) {
            e.consume();
        } else if (texto.length() >= longitudMaxima) {
            e.consume();
        } else if (esPuntoDecimal && texto.contains(".")) {
            e.consume();  // Permite solo un punto decimal
        }
    }

    private void validacionesEventosKeyTyped() {
        agregarValidacionCampoNumerico(vistaModProducto.getTxtPrecioVendible(), Integer.MAX_VALUE);
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
