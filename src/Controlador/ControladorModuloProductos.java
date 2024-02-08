package Controlador;

import Modelo.*;
import Vista.VP_Ropa;
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
import java.sql.SQLException;
import java.util.List;
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
    Connection conexion = null;

    public ControladorModuloProductos(V_ModuloProducto vistaModProducto) {
        this.vistaModProducto = vistaModProducto;
        vistaModProducto.setVisible(true);
        //Ropa
        cargarDatosEnTabla();
        deshabilitarCamposRopa();
        cargarIdsRopaEnComboBox();
        cargarIdsCamposRopa();
        vistaModProducto.getBtnEliminar().setEnabled(false);
        vistaModProducto.getBtnModificar().setEnabled(false);
        validacionesEventosKeyTyped();
        //Mueble
        cargarDatosEnTablaMueble();
        deshabilitarCamposMueble();
        cargarIdsMuebleEnComboBox();
        cargarIdsCamposMueble();
        vistaModProducto.getBtnEliminar1().setEnabled(false);
        vistaModProducto.getBtnModificar1().setEnabled(false);
        //Medicamento
        cargarDatosEnTablaMedicamento();
        deshabilitarCamposMedicamento();
        cargarIdsMedicamentoEnComboBox();
        cargarIdsCamposMedicamento();
        vistaModProducto.getBtnEliminar2().setEnabled(false);
        vistaModProducto.getBtnModificar2().setEnabled(false);
        //Alimento
        cargarDatosEnTablaAlimento();
        deshabilitarCamposAlimento();
        cargarIdsAlimentoEnComboBox();
        cargarIdsCamposAlimento();
        vistaModProducto.getBtnEliminar3().setEnabled(false);
        vistaModProducto.getBtnModificar3().setEnabled(false);
    }
    // <editor-fold desc="">
    // </editor-fold>

    public void iniciarControl() {
        vistaModProducto.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
        //Ropa
        vistaModProducto.getBtnAyuda().addActionListener(l -> ayudaRopa());
        vistaModProducto.getBtnCrear().addActionListener(l -> crearRopa());
        vistaModProducto.getBtnConsultar().addActionListener(l -> consultarRopa());
        vistaModProducto.getBtnModificar().addActionListener(l -> modificarRopa());
        vistaModProducto.getBtnEliminar().addActionListener(l -> eliminarRopa());
        vistaModProducto.getBtnReporte().addActionListener(l -> reporteRopa());
        vistaModProducto.getBtnCargarImagen().addActionListener(l -> cargarImagenRopa());
        vistaModProducto.getBtnImagenProducto().addActionListener(l -> mostrarImagenEnDialogoEmergenteRopa());
        vistaModProducto.getBtnLimpiar().addActionListener(l -> limpiarCamposRopa());
        //Mueble
        vistaModProducto.getBtnAyuda1().addActionListener(l -> ayudaMueble());
        vistaModProducto.getBtnCrear1().addActionListener(l -> crearMueble());
        vistaModProducto.getBtnConsultar1().addActionListener(l -> consultarMueble());
        vistaModProducto.getBtnModificar1().addActionListener(l -> modificarMueble());
        vistaModProducto.getBtnEliminar1().addActionListener(l -> eliminarMueble());
        vistaModProducto.getBtnReporte1().addActionListener(l -> reporteMueble());
        vistaModProducto.getBtnCargarImagen1().addActionListener(l -> cargarImagenMueble());
        vistaModProducto.getBtnImagenProducto1().addActionListener(l -> mostrarImagenEnDialogoEmergenteMueble());
        vistaModProducto.getBtnLimpiar1().addActionListener(l -> limpiarCamposMueble());
        //Medicamento
        vistaModProducto.getBtnAyuda2().addActionListener(l -> ayudaMedicamento());
        vistaModProducto.getBtnCrear2().addActionListener(l -> crearMedicamento());
        vistaModProducto.getBtnConsultar2().addActionListener(l -> consultarMedicamento());
        vistaModProducto.getBtnModificar2().addActionListener(l -> modificarMedicamento());
        vistaModProducto.getBtnEliminar2().addActionListener(l -> eliminarMedicamento());
        vistaModProducto.getBtnReporte2().addActionListener(l -> reporteMedicamento());
        vistaModProducto.getBtnCargarImagen2().addActionListener(l -> cargarImagenMedicamento());
        vistaModProducto.getBtnImagenProducto2().addActionListener(l -> mostrarImagenEnDialogoEmergenteMedicamento());
        vistaModProducto.getBtnLimpiar2().addActionListener(l -> limpiarCamposMedicamento());
        //Alimento
        vistaModProducto.getBtnAyuda3().addActionListener(l -> ayudaAlimento());
        vistaModProducto.getBtnCrear3().addActionListener(l -> crearAlimento());
        vistaModProducto.getBtnConsultar3().addActionListener(l -> consultarAlimento());
        vistaModProducto.getBtnModificar3().addActionListener(l -> modificarAlimento());
        vistaModProducto.getBtnEliminar3().addActionListener(l -> eliminarAlimento());
        vistaModProducto.getBtnReporte3().addActionListener(l -> reporteAlimento());
        vistaModProducto.getBtnCargarImagen3().addActionListener(l -> cargarImagenAlimento());
        vistaModProducto.getBtnImagenProducto3().addActionListener(l -> mostrarImagenEnDialogoEmergenteAlimento());
        vistaModProducto.getBtnLimpiar3().addActionListener(l -> limpiarCamposAlimento());
    }

    // <editor-fold desc="Metodos para el crud de ropa">
    private void crearRopa() {

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
                        mostrarMensajeRopa("CREACION EXITOSA", 2000, icon);
                        cargarDatosEnTabla();
                        limpiarCamposRopa();
                        cargarIdsCamposRopa();
                        cargarIdsCamposMueble();
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

                    mostrarMensajeRopa("CONSULTA EXITOSA", 1000, icon);
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
                        mostrarMensajeRopa("MODIFICACION EXITOSA", 2000, icon);

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
                            mostrarMensajeRopa("ELIMINACIÓN EXITOSA", 2000, icon);
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
        VP_Ropa vista = new VP_Ropa();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorReporteRopa control = new ControladorReporteRopa(vista);
        control.iniciarControl();
        mostrarMensajeRopa("REPORTE EXITOSO", 1000, icon);
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
        agregarValidacionCampoNumerico(vistaModProducto.getTxtPrecioVendible1(), Integer.MAX_VALUE);
    }

    private void cargarImagenRopa() {
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

    private void mostrarImagenEnDialogoEmergenteRopa() {
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

    private void mostrarMensajeRopa(String mensaje, int duracionMillisegundos, Icon icono) {
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

    private void ayudaRopa() {
        JOptionPane.showMessageDialog(null, "Aqui se encuentra la ventana para el registro de ropa"
                + "\nBotones "
                + "\n1. Crear: En este boton se guardara los datos ingresados en los campos del formulario en la base de datos,"
                + "\n                 los datos ingresados deben pertenecer a su tipo de dato correspondiente."
                + "\n2. Consultar: Este boton realizara una consulta de los registros en la base de datos."
                + "\n3. Modificar: Este boton modificara los datos que se ingresan en los campos, cuando se hace una consulta."
                + "\n4. Eliminar: Este boton eliminara un registro de la base de datos."
                + "\n5. Reporte: Este boton realizara una actualizacion en la tabla de los registros de la base de datos.");
    }

    private void ayudaMueble() {
        JOptionPane.showMessageDialog(null, "Aqui se encuentra la ventana para el registro de muebles"
                + "\nBotones "
                + "\n1. Crear: En este boton se guardara los datos ingresados en los campos del formulario en la base de datos,"
                + "\n                 los datos ingresados deben pertenecer a su tipo de dato correspondiente."
                + "\n2. Consultar: Este boton realizara una consulta de los registros en la base de datos."
                + "\n3. Modificar: Este boton modificara los datos que se ingresan en los campos, cuando se hace una consulta."
                + "\n4. Eliminar: Este boton eliminara un registro de la base de datos."
                + "\n5. Reporte: Este boton realizara una actualizacion en la tabla de los registros de la base de datos.");
    }

    private void ayudaMedicamento() {
        JOptionPane.showMessageDialog(null, "Aqui se encuentra la ventana para el registro de medicamentos"
                + "\nBotones "
                + "\n1. Crear: En este boton se guardara los datos ingresados en los campos del formulario en la base de datos,"
                + "\n                 los datos ingresados deben pertenecer a su tipo de dato correspondiente."
                + "\n2. Consultar: Este boton realizara una consulta de los registros en la base de datos."
                + "\n3. Modificar: Este boton modificara los datos que se ingresan en los campos, cuando se hace una consulta."
                + "\n4. Eliminar: Este boton eliminara un registro de la base de datos."
                + "\n5. Reporte: Este boton realizara una actualizacion en la tabla de los registros de la base de datos.");
    }

    private void ayudaAlimento() {
        JOptionPane.showMessageDialog(null, "Aqui se encuentra la ventana para el registro de alimentos"
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

    private void ocultarMensaje() {
        vistaModProducto.getMensajeExito().setText("");
        vistaModProducto.getMensajeExito().setIcon(null);
        vistaModProducto.getMensajeExito1().setText("");
        vistaModProducto.getMensajeExito1().setIcon(null);
        vistaModProducto.getMensajeExito2().setText("");
        vistaModProducto.getMensajeExito2().setIcon(null);
        vistaModProducto.getMensajeExito3().setText("");
        vistaModProducto.getMensajeExito3().setIcon(null);
    }

    // </editor-fold>
    // <editor-fold desc="Metodos para el crud de mueble">
    private void crearMueble() {
        try {
            // Atributos de producto
            String tipoProducto = vistaModProducto.getTxtTipoProducto1().getText();
            //Atributos de tipoVendible
            String precioVendibleStr = vistaModProducto.getTxtPrecioVendible1().getText();
            double precioVendible = precioVendibleStr.isEmpty() ? 0.0 : Double.parseDouble(precioVendibleStr);
            String tipo = vistaModProducto.getCbxTipoMueble().getSelectedItem().toString();
            String estado = vistaModProducto.getCbxEstado1().getSelectedItem().toString();
            //Atributos de mueble
            String material = vistaModProducto.getCbxMaterialMueble().getSelectedItem().toString();
            String tamaño = vistaModProducto.getCbxTamañoMueble().getSelectedItem().toString();

            // Validar que los campos requeridos estén llenos
            if ("Seleccionar".equals(tipo) || "Seleccionar".equals(estado) || "Seleccionar".equals(tamaño)) {
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
                    Mueble mueble = new Mueble();

                    mueble.setMaterial_mue(material);
                    mueble.setTamaño_mue(tamaño);
                    mueble.setId_vendible_mue(idTipoVendible); // ID del TipoVendible generado

                    // Llamar al método insertarRopa del modelo para insertar el registro
                    int idMueble = ModeloMueble.insertarMueble(mueble);

                    if (idMueble != -1) {
                        //System.out.println("Registro de Mueble insertado con éxito. ID generado: " + idRopa);
                        mostrarMensajeMueble("CREACION EXITOSA", 2000, icon);
                        cargarDatosEnTablaMueble();
                        limpiarCamposMueble();
                        cargarIdsCamposMueble();
                        cargarIdsCamposRopa();
                        cargarIdsMuebleEnComboBox();
                        // Confirmar la transacción
                        conexion.commit();
                    } else {
                        // Si hay un error en la inserción de Ropa, hacer rollback
                        conexion.rollback();
                        JOptionPane.showMessageDialog(vistaModProducto, "Error al crear el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Error al insertar el registro de Mueble.");
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

    private void consultarMueble() {
        vistaModProducto.getBtnCrear1().setEnabled(false);
        vistaModProducto.getBtnEliminar1().setEnabled(true);
        vistaModProducto.getBtnModificar1().setEnabled(true);

        // Obtener el código seleccionado del ComboBox
        String codigoSeleccionado = vistaModProducto.getCbxCodigosMuebles().getSelectedItem().toString();

        // Convertir el código a un entero
        int idRopaSeleccionado = Integer.parseInt(codigoSeleccionado);

        // Obtener la Ropa correspondiente al ID seleccionado
        Mueble muebleSeleccionada = ModeloMueble.obtenerMueblePorId(idRopaSeleccionado);

        // Verificar si se encontró la Ropa
        if (muebleSeleccionada != null) {
            // Mostrar los datos en los campos correspondientes de Ropa
            vistaModProducto.getTxtCodigoMueble().setText(String.valueOf(muebleSeleccionada.getId_mueb()));
            vistaModProducto.getCbxMaterialMueble().setSelectedItem(muebleSeleccionada.getMaterial_mue());
            vistaModProducto.getCbxTamañoMueble().setSelectedItem(muebleSeleccionada.getTamaño_mue());

            // Obtener el TipoVendible asociado a la Ropa
            TipoVendible tipoVendibleAsociado = ModeloTipoVendible.obtenerTipoVendiblePorId(muebleSeleccionada.getId_vendible_mue());

            // Verificar si se encontró el TipoVendible
            if (tipoVendibleAsociado != null) {
                // Mostrar los datos en los campos correspondientes de TipoVendible
                vistaModProducto.getTxtCodigoVendible1().setText(String.valueOf(tipoVendibleAsociado.getId_vendible()));
                vistaModProducto.getTxtPrecioVendible1().setText(String.valueOf(tipoVendibleAsociado.getPrecio()));
                vistaModProducto.getCbxTipoMueble().setSelectedItem(tipoVendibleAsociado.getTipo());
                vistaModProducto.getCbxEstado1().setSelectedItem(tipoVendibleAsociado.getEstado());

                // Obtener el Producto asociado al TipoVendible
                Producto productoAsociado = ModeloProducto.obtenerProductoPorId(tipoVendibleAsociado.getId_pro_ven());

                // Verificar si se encontró el Producto
                if (productoAsociado != null) {
                    // Mostrar los datos en los campos correspondientes de Producto
                    vistaModProducto.getTxtCodigoProducto1().setText(String.valueOf(productoAsociado.getId_producto()));
                    vistaModProducto.getTxtTipoProducto1().setText(productoAsociado.getTipo_pro());
                    if (productoAsociado.getImagen_pro() != null) {
                        ImageIcon imagen = new ImageIcon(productoAsociado.getImagen_pro());
                        vistaModProducto.getBtnImagenProducto1().setIcon(imagen);
                    } else {
                        // Si la imagen es nula, eliminar la imagen del botón
                        vistaModProducto.getBtnImagenProducto1().setIcon(null);
                    }
                    // Otros campos del Producto...

                    mostrarMensajeMueble("CONSULTA EXITOSA", 1000, icon);
                } else {
                    System.out.println("Error: No se encontró el Producto asociado al TipoVendible");
                }
            } else {
                System.out.println("Error: No se encontró el TipoVendible asociado al mueble");

            }
        } else {
            System.out.println("Error: No se encontró el mueble con el ID especificado");
        }
    }

    private void modificarMueble() {

        try {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de modificar este registro de mueble ?", "Confirmar modificacion", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                String idMuebleStr = vistaModProducto.getTxtCodigoMueble().getText();
                int idMueble = Integer.parseInt(idMuebleStr);
                Mueble mueble = ModeloMueble.obtenerMueblePorId(idMueble);

                if (mueble != null) {
                    //Atributos de Mueble

                    String material = vistaModProducto.getCbxMaterialMueble().getSelectedItem().toString();
                    String tamaño = vistaModProducto.getCbxTamañoMueble().getSelectedItem().toString();

                    mueble.setMaterial_mue(material);
                    mueble.setTamaño_mue(tamaño);

                    boolean resulModificacionMueble = ModeloMueble.modificarMueble(mueble);
                    if (resulModificacionMueble) {

                        //System.out.println("Modifiacion exitosa de mueble");
                    } else {
                        JOptionPane.showMessageDialog(vistaModProducto, "Error al modificar el mueble.", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(vistaModProducto, "El mueble con id " + idMueble + " no existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);

                }
                //Modificar atributos de tipoVendible

                String idTipoVendibleStr = vistaModProducto.getTxtCodigoVendible1().getText();
                int idTipoVendible = Integer.parseInt(idTipoVendibleStr);
                TipoVendible tipoVendible = ModeloTipoVendible.obtenerTipoVendiblePorId(idTipoVendible);
                if (tipoVendible != null) {
                    String precioVendibleStr = vistaModProducto.getTxtPrecioVendible1().getText();
                    double precioVendible = precioVendibleStr.isEmpty() ? 0.0 : Double.parseDouble(precioVendibleStr);
                    String tipo = vistaModProducto.getCbxTipoMueble().getSelectedItem().toString();

                    String estado = vistaModProducto.getCbxEstado1().getSelectedItem().toString();
                    tipoVendible.setPrecio(precioVendible);
                    tipoVendible.setTipo(tipo);
                    tipoVendible.setEstado(estado);
                    boolean resulModficacionTipoVendible = ModeloTipoVendible.modificarTipoVendible(tipoVendible);
                    if (resulModficacionTipoVendible) {
                        //System.out.println("Modificaion exitosa de tipoVendible");

                    } else {
                        //System.out.println("Error al modificar el tipoVendible");

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
                        //System.out.println("Modificaion exitosa de producto");
                        mostrarMensajeMueble("MODIFICACION EXITOSA", 2000, icon);

                        limpiarCamposMueble();
                        cargarDatosEnTablaMueble();
                        vistaModProducto.getBtnCrear1().setEnabled(true);
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
            System.out.println("Error al modificar atributos de mueble, tipovendible y ropa");
        }

    }

    private void eliminarMueble() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este registro de mueble ?", "Confirmar modificacion", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Obtener el ID de la Ropa seleccionada en el ComboBox
                String idMuebleStr = (String) vistaModProducto.getCbxCodigosMuebles().getSelectedItem();
                int idMueble = Integer.parseInt(idMuebleStr);

                // Obtener el ID del TipoVendible asociado a la Ropa
                int idTipoVendible = ModeloMueble.obtenerIdTipoVendiblePorIdMueble(idMueble);

                // Obtener el ID del Producto asociado al TipoVendible
                int idProducto = ModeloTipoVendible.obtenerIdProductoPorIdTipoVendible(idTipoVendible);

                // Eliminar la Ropa (esto eliminará automáticamente el TipoVendible debido a la restricción de clave foránea)
                boolean resulEliminacionMueble = ModeloMueble.eliminarMueble(idMueble);

                // Verificar si la eliminación de la Ropa fue exitosa
                if (resulEliminacionMueble) {
                    // Eliminar el TipoVendible asociado
                    boolean eliminacionExitosaTipoVendible = ModeloTipoVendible.eliminarTipoVendible(idTipoVendible);

                    // Verificar si la eliminación del TipoVendible fue exitosa
                    if (eliminacionExitosaTipoVendible) {
                        // Eliminar el Producto asociado
                        boolean eliminacionExitosaProducto = ModeloProducto.eliminarProducto(idProducto);

                        // Verificar si la eliminación del Producto fue exitosa
                        if (eliminacionExitosaProducto) {
                            // Puedes mostrar un mensaje de éxito
                            mostrarMensajeMueble("ELIMINACIÓN EXITOSA", 2000, icon);
                            cargarDatosEnTablaMueble();
                            cargarIdsMuebleEnComboBox();
                            limpiarCamposMueble();
                            return;
                        }
                    }
                }

                // Si algo falla, mostrar un mensaje de error
                JOptionPane.showMessageDialog(vistaModProducto, "ERROR AL ELIMINAR El MUEBLE ", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException | NumberFormatException ex) {
                // Manejar posibles excepciones al obtener el ID seleccionado
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vistaModProducto, "ERROR AL OBTENER EL ID DEL MUEBLE ", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(vistaModProducto, "MODIFICACION CANCELADA");
        }
    }

    private void reporteMueble() {

        mostrarMensajeMueble("REPORTE EXITOSO", 1000, icon);
    }

    private void limpiarCamposMueble() {

        vistaModProducto.getCbxTipoMueble().setSelectedIndex(0);
        vistaModProducto.getCbxMaterialMueble().setSelectedIndex(0);
        vistaModProducto.getCbxTamañoMueble().setSelectedIndex(0);
        vistaModProducto.getCbxEstado1().setSelectedIndex(0);
        vistaModProducto.getBtnImagenProducto1().setIcon(null);
        vistaModProducto.getTxtPrecioVendible1().setText("");
        cargarIdsCamposMueble();
        vistaModProducto.getBtnCrear1().setEnabled(true);
        vistaModProducto.getBtnEliminar1().setEnabled(false);
        vistaModProducto.getBtnModificar1().setEnabled(false);
    }

    private void deshabilitarCamposMueble() {
        vistaModProducto.getTxtCodigoMueble().setEditable(false);
        vistaModProducto.getTxtCodigoProducto1().setEditable(false);
        vistaModProducto.getTxtCodigoVendible1().setEditable(false);
        vistaModProducto.getTxtTipoProducto1().setEditable(false);

    }

    private void cargarIdsMuebleEnComboBox() {
        List<Integer> idsMueble = ModeloMueble.obtenerIdsMueble();
        vistaModProducto.getCbxCodigosMuebles().removeAllItems();
        for (int idMueble : idsMueble) {
            // Convertir el entero a cadena antes de agregarlo al JComboBox
            vistaModProducto.getCbxCodigosMuebles().addItem(String.valueOf(idMueble));
        }
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
        vistaModProducto.getTblMuebles().setModel(modeloTabla);
    }

    private void cargarIdsCamposMueble() {
        int idUltimoMueble = ModeloMueble.obtenerUltimoIdMueble();
        vistaModProducto.getTxtCodigoMueble().setText(String.valueOf(idUltimoMueble + 1));
        int idUltimoTipoVendible = ModeloTipoVendible.obtenerUltimoIdTipoVendible();
        vistaModProducto.getTxtCodigoVendible1().setText(String.valueOf(idUltimoTipoVendible + 1));
        int idUltimoProducto = ModeloProducto.obtenerUltimoIdProducto();
        vistaModProducto.getTxtCodigoProducto1().setText(String.valueOf(idUltimoProducto + 1));
    }

    private void cargarImagenMueble() {
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        if (jf.showOpenDialog(vistaModProducto) == JFileChooser.APPROVE_OPTION) {
            rutaImagenSeleccionada = jf.getSelectedFile().toString();

            // Mostrar la imagen en el botón btnImagenProducto
            vistaModProducto.getBtnImagenProducto1().setIcon(new ImageIcon(rutaImagenSeleccionada));

            // Obtener los bytes de la imagen y guardarlos en la variable imagenBytes
            imagenBytes = obtenerBytesImagen(rutaImagenSeleccionada);
        }
    }

    private void mostrarImagenEnDialogoEmergenteMueble() {
        // Obtener la imagen actual del botón
        Icon imagenActual = vistaModProducto.getBtnImagenProducto1().getIcon();

        // Si el botón no tiene una imagen, no hacemos nada
        if (imagenActual == null) {
            return;
        }

        // Crear un componente JLabel para mostrar la imagen en el diálogo emergente
        JLabel lblImagen = new JLabel(imagenActual);

        // Crear un diálogo emergente de JOptionPane para mostrar la imagen
        JOptionPane.showMessageDialog(vistaModProducto, lblImagen, "Imagen del Producto", JOptionPane.PLAIN_MESSAGE);
    }

    private void mostrarMensajeMueble(String mensaje, int duracionMillisegundos, Icon icono) {
        vistaModProducto.getMensajeExito1().setText(mensaje);
        vistaModProducto.getMensajeExito1().setIcon(icono); // Establecer el icono en el JLabel

        // Iniciar el temporizador para ocultar el mensaje después de la duración especificada
        timer = new Timer(duracionMillisegundos, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ocultarMensaje();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    // </editor-fold>
    // <editor-fold desc="Metodos para el crud de medicamento">
    private void crearMedicamento() {
        try {
            // Atributos de producto
            String tipoProducto = vistaModProducto.getTxtTipoProducto2().getText();
            //Atributos de tipoDonable
            String nombre = vistaModProducto.getTxtNombreMedicamento().getText();
            java.util.Date fechaElaboracionUtil = vistaModProducto.getDatFechaElaboracion() != null ? vistaModProducto.getDatFechaElaboracion().getDate() : null;
            java.sql.Date fechaEla = (fechaElaboracionUtil != null) ? new java.sql.Date(fechaElaboracionUtil.getTime()) : null;

            java.util.Date fechaVencimientoUtil = vistaModProducto.getDatFechaVencimiento() != null ? vistaModProducto.getDatFechaVencimiento().getDate() : null;
            java.sql.Date fechaVen = (fechaVencimientoUtil != null) ? new java.sql.Date(fechaVencimientoUtil.getTime()) : null;

            //Atributos de medicamento
            String formaFarmace = vistaModProducto.getCbxFormaFarmac().getSelectedItem().toString();

            // Validar que los campos requeridos estén llenos
            if (nombre.isEmpty() || fechaEla == null || fechaVen == null || formaFarmace.equals("Seleccionar")) {
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
                TipoDonable tipoDonable = new TipoDonable();

                tipoDonable.setNombre_dona(nombre);
                tipoDonable.setFechaElaboracion(fechaEla);
                tipoDonable.setFechaVencimiento(fechaVen);
                tipoDonable.setId_pro_dona(idProducto);// ID del producto generado

                // Llamar al método insertarTipoVendible del modelo para insertar el registro
                int idTipoDonable = ModeloTipoDonable.insertarTipoDonable(tipoDonable);

                if (idTipoDonable != -1) {
                    //System.out.println("Registro TipoDonable insertado con éxito. ID generado: " + idTipoDonable);

                    // Crear un objeto Ropa con los datos necesarios
                    Medicamentos medicamento = new Medicamentos();

                    medicamento.setFormaFarmaceutica_med(formaFarmace);
                    medicamento.setId_donable_med(idTipoDonable); // ID del TipoVendible generado

                    // Llamar al método insertarRopa del modelo para insertar el registro
                    int idMedicamento = ModeloMedicamento.insertarMedicamento(medicamento);

                    if (idMedicamento != -1) {
                        //System.out.println("Registro de Medicamento insertado con éxito. ID generado: " + idMedicamento);
                        mostrarMensajeMedicamento("CREACION EXITOSA", 2000, icon);
                        cargarDatosEnTablaMedicamento();
                        limpiarCamposMedicamento();
                        cargarIdsCamposMedicamento();
                        cargarIdsCamposMueble();
                        cargarIdsCamposRopa();
                        cargarIdsCamposAlimento();
                        cargarIdsMedicamentoEnComboBox();
                        // Confirmar la transacción
                        conexion.commit();
                    } else {
                        // Si hay un error en la inserción, hacer rollback
                        conexion.rollback();
                        JOptionPane.showMessageDialog(vistaModProducto, "Error al crear el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Error al insertar el registro de medicamento.");
                    }
                } else {
                    // Si hay un error en la inserción de TipoDonable, hacer rollback
                    conexion.rollback();
                    System.out.println("Error al insertar el registro tipoDonable.");
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

    private void consultarMedicamento() {
        vistaModProducto.getBtnCrear2().setEnabled(false);
        vistaModProducto.getBtnEliminar2().setEnabled(true);
        vistaModProducto.getBtnModificar2().setEnabled(true);

        // Obtener el código seleccionado del ComboBox
        String codigoSeleccionado = vistaModProducto.getCbxCodigosMedicamentos().getSelectedItem().toString();

        // Convertir el código a un entero
        int idMediSeleccionado = Integer.parseInt(codigoSeleccionado);

        // Obtener la Ropa correspondiente al ID seleccionado
        Medicamentos mediSeleccionado = ModeloMedicamento.obtenerMedicamentoPorId(idMediSeleccionado);

        // Verificar si se encontró la Ropa
        if (mediSeleccionado != null) {
            // Mostrar los datos en los campos correspondientes de Medicamento
            vistaModProducto.getTxtCodigoMedicamento().setText(String.valueOf(mediSeleccionado.getId_med()));
            vistaModProducto.getCbxFormaFarmac().setSelectedItem(mediSeleccionado.getFormaFarmaceutica_med());

            // Obtener el TipoVendible asociado a la Ropa
            TipoDonable tipoDonableAsociado = ModeloTipoDonable.obtenerTipoDonablePorId(mediSeleccionado.getId_donable_med());

            // Verificar si se encontró el TipoDonable
            if (tipoDonableAsociado != null) {
                // Mostrar los datos en los campos correspondientes de TipoDonable
                vistaModProducto.getTxtCodigoDonable().setText(String.valueOf(tipoDonableAsociado.getId_donable()));
                vistaModProducto.getTxtNombreMedicamento().setText(tipoDonableAsociado.getNombre_dona());
                vistaModProducto.getDatFechaElaboracion().setDate(tipoDonableAsociado.getFechaElaboracion());
                vistaModProducto.getDatFechaVencimiento().setDate(tipoDonableAsociado.getFechaVencimiento());

                // Obtener el Producto asociado al TipoVendible
                Producto productoAsociado = ModeloProducto.obtenerProductoPorId(tipoDonableAsociado.getId_pro_dona());

                // Verificar si se encontró el Producto
                if (productoAsociado != null) {
                    // Mostrar los datos en los campos correspondientes de Producto
                    vistaModProducto.getTxtCodigoProducto2().setText(String.valueOf(productoAsociado.getId_producto()));
                    vistaModProducto.getTxtTipoProducto2().setText(productoAsociado.getTipo_pro());
                    if (productoAsociado.getImagen_pro() != null) {
                        ImageIcon imagen = new ImageIcon(productoAsociado.getImagen_pro());
                        vistaModProducto.getBtnImagenProducto2().setIcon(imagen);
                    } else {
                        // Si la imagen es nula, eliminar la imagen del botón
                        vistaModProducto.getBtnImagenProducto2().setIcon(null);
                    }
                    // Otros campos del Producto...

                    mostrarMensajeMueble("CONSULTA EXITOSA", 1000, icon);
                } else {
                    System.out.println("Error: No se encontró el Producto asociado al TipoDonable");
                }
            } else {
                System.out.println("Error: No se encontró el TipoDonable asociado al medicamento");

            }
        } else {
            System.out.println("Error: No se encontró el medicametno con el ID especificado");
        }
    }

    private void modificarMedicamento() {

        try {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de modificar este registro de medicamento ?", "Confirmar modificacion", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                String idMediStr = vistaModProducto.getTxtCodigoMedicamento().getText();
                int idMedi = Integer.parseInt(idMediStr);
                Medicamentos medicamento = ModeloMedicamento.obtenerMedicamentoPorId(idMedi);

                if (medicamento != null) {
                    //Atributos de medicamento

                    String formaFarmaceutica = vistaModProducto.getCbxFormaFarmac().getSelectedItem().toString();

                    medicamento.setFormaFarmaceutica_med(formaFarmaceutica);

                    boolean resulModificacionMedicamento = ModeloMedicamento.modificarMedicamento(medicamento);
                    if (resulModificacionMedicamento) {

                        //System.out.println("Modifiacion exitosa de medicamento");
                    } else {
                        JOptionPane.showMessageDialog(vistaModProducto, "Error al modificar el medicamento.", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(vistaModProducto, "El medicamento con id " + idMedi + " no existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);

                }
                //Modificar atributos de TipoDonable

                String idTipoDonableStr = vistaModProducto.getTxtCodigoDonable().getText();
                int idTipoDonable = Integer.parseInt(idTipoDonableStr);
                TipoDonable tipoDonable = ModeloTipoDonable.obtenerTipoDonablePorId(idTipoDonable);
                if (tipoDonable != null) {
                    String nuevoNombre = vistaModProducto.getTxtNombreMedicamento().getText();
                    java.util.Date fechaElaboracionUtil = vistaModProducto.getDatFechaElaboracion().getDate();
                    java.sql.Date nuevaFechaElab = new java.sql.Date(fechaElaboracionUtil.getTime());

                    java.util.Date fechaVencimientoUtil = vistaModProducto.getDatFechaVencimiento().getDate();
                    java.sql.Date nuevaFechaVenc = new java.sql.Date(fechaVencimientoUtil.getTime());

                    tipoDonable.setNombre_dona(nuevoNombre);
                    tipoDonable.setFechaElaboracion(nuevaFechaElab);
                    tipoDonable.setFechaVencimiento(nuevaFechaVenc);

                    boolean resulModficacionTipoDonable = ModeloTipoDonable.modificarTipoDonable(tipoDonable);
                    if (resulModficacionTipoDonable) {
                        //System.out.println("Modificaion exitosa de tipoDonable");

                    } else {
                        System.out.println("Error al modificar el tipoDonable");

                    }
                } else {
                    System.out.println("El id " + idTipoDonable + "de tipoDonable no existe en la base de datos");
                }
                //Modificar atributos de producto
                String idProductotr = vistaModProducto.getTxtCodigoProducto2().getText();
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
                        //System.out.println("Modificacion exitosa de producto");
                        mostrarMensajeMedicamento("MODIFICACION EXITOSA", 2000, icon);

                        limpiarCamposMedicamento();
                        cargarDatosEnTablaMedicamento();
                        vistaModProducto.getBtnCrear2().setEnabled(true);
                    } else {
                        System.out.println("Error al modificar producto");

                    }
                } else {
                    System.out.println("El id " + idProducto + " de producto no existe en la base de datos");
                }
            } else {
                JOptionPane.showMessageDialog(vistaModProducto, "Modificacion cancelada");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al modificar atributos de producto, tipoDonable y medicamento");
        }

    }

    private void eliminarMedicamento() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este registro de medicamento ?", "Confirmar modificacion", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Obtener el ID del medicamento seleccionada en el ComboBox
                String idMediStr = (String) vistaModProducto.getCbxCodigosMedicamentos().getSelectedItem();
                int idMedi = Integer.parseInt(idMediStr);

                // Obtener el ID del TipoVendible asociado a la Ropa
                int idTipoDonable = ModeloMedicamento.obtenerIdTipoDonablePorIdMedicamento(idMedi);

                // Obtener el ID del Producto asociado al TipoVendible
                int idProducto = ModeloTipoDonable.obtenerIdProductoPorIdTipoDonable(idTipoDonable);

                // Eliminar la Ropa (esto eliminará automáticamente el TipoVendible debido a la restricción de clave foránea)
                boolean resulEliminacionMedi = ModeloMedicamento.eliminarMedicamento(idMedi);

                // Verificar si la eliminación de la Ropa fue exitosa
                if (resulEliminacionMedi) {
                    // Eliminar el TipoVendible asociado
                    boolean eliminacionExitosaTipoDonable = ModeloTipoDonable.eliminarTipoDonable(idTipoDonable);

                    // Verificar si la eliminación del TipoVendible fue exitosa
                    if (eliminacionExitosaTipoDonable) {
                        // Eliminar el Producto asociado
                        boolean eliminacionExitosaProducto = ModeloProducto.eliminarProducto(idProducto);

                        // Verificar si la eliminación del Producto fue exitosa
                        if (eliminacionExitosaProducto) {
                            // Puedes mostrar un mensaje de éxito
                            mostrarMensajeMedicamento("ELIMINACIÓN EXITOSA", 2000, icon);
                            cargarDatosEnTablaMedicamento();
                            cargarIdsMedicamentoEnComboBox();
                            limpiarCamposMedicamento();
                            return;
                        }
                    }
                }

                // Si algo falla, mostrar un mensaje de error
                JOptionPane.showMessageDialog(vistaModProducto, "ERROR AL ELIMINAR El MEDICAMENTO ", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException | NumberFormatException ex) {
                // Manejar posibles excepciones al obtener el ID seleccionado
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vistaModProducto, "ERROR AL OBTENER EL ID DEL MEDICAMENTO ", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(vistaModProducto, "MODIFICACION CANCELADA");
        }
    }

    private void reporteMedicamento() {

        mostrarMensajeMedicamento("REPORTE EXITOSO", 1000, icon);
    }

    private void limpiarCamposMedicamento() {

        vistaModProducto.getTxtNombreMedicamento().setText("");
        vistaModProducto.getCbxFormaFarmac().setSelectedIndex(0);
        vistaModProducto.getDatFechaElaboracion().setDate(null);
        vistaModProducto.getDatFechaVencimiento().setDate(null);
        vistaModProducto.getBtnImagenProducto2().setIcon(null);
        cargarIdsCamposMedicamento();
        vistaModProducto.getBtnCrear2().setEnabled(true);
        vistaModProducto.getBtnEliminar2().setEnabled(false);
        vistaModProducto.getBtnModificar2().setEnabled(false);
    }

    private void deshabilitarCamposMedicamento() {
        vistaModProducto.getTxtCodigoMedicamento().setEditable(false);
        vistaModProducto.getTxtCodigoProducto2().setEditable(false);
        vistaModProducto.getTxtCodigoDonable().setEditable(false);
        vistaModProducto.getTxtTipoProducto2().setEditable(false);

    }

    private void cargarIdsMedicamentoEnComboBox() {
        List<Integer> idsMedi = ModeloMedicamento.obtenerIdsMedicamentos();
        vistaModProducto.getCbxCodigosMedicamentos().removeAllItems();
        for (int idMedi : idsMedi) {
            // Convertir el entero a cadena antes de agregarlo al JComboBox
            vistaModProducto.getCbxCodigosMedicamentos().addItem(String.valueOf(idMedi));
        }
    }

    private void cargarDatosEnTablaMedicamento() {
        // Obtener la lista de detalles de ropa desde el modelo
        List<Medicamentos> listaDetallesMedi = ModeloMedicamento.obtenerDetallesMedicamento();

        // Crear un DefaultTableModel con las columnas necesarias
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha Elaboracion");
        modeloTabla.addColumn("Fecha Vencimiento");
        modeloTabla.addColumn("Forma Farmaceutica");

        // Llenar el modelo de la tabla con los datos de la lista de detalles de ropas
        for (Medicamentos detalle : listaDetallesMedi) {
            Object[] fila = {
                detalle.getId_med(),
                detalle.getNombre_dona(),
                detalle.getFechaElaboracion(),
                detalle.getFechaVencimiento(),
                detalle.getFormaFarmaceutica_med()
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo de la tabla en la vista
        vistaModProducto.getTblMedicamentos().setModel(modeloTabla);
    }

    private void cargarIdsCamposMedicamento() {
        int idUltimoMedi = ModeloMedicamento.obtenerUltimoIdMedicamento();
        vistaModProducto.getTxtCodigoMedicamento().setText(String.valueOf(idUltimoMedi + 1));
        int idUltimoTipoDonable = ModeloTipoDonable.obtenerUltimoIdTipoDonable();
        vistaModProducto.getTxtCodigoDonable().setText(String.valueOf(idUltimoTipoDonable + 1));
        int idUltimoProducto = ModeloProducto.obtenerUltimoIdProducto();
        vistaModProducto.getTxtCodigoProducto2().setText(String.valueOf(idUltimoProducto + 1));
    }

    private void cargarImagenMedicamento() {
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        if (jf.showOpenDialog(vistaModProducto) == JFileChooser.APPROVE_OPTION) {
            rutaImagenSeleccionada = jf.getSelectedFile().toString();

            // Mostrar la imagen en el botón btnImagenProducto
            vistaModProducto.getBtnImagenProducto2().setIcon(new ImageIcon(rutaImagenSeleccionada));

            // Obtener los bytes de la imagen y guardarlos en la variable imagenBytes
            imagenBytes = obtenerBytesImagen(rutaImagenSeleccionada);
        }
    }

    private void mostrarImagenEnDialogoEmergenteMedicamento() {
        // Obtener la imagen actual del botón
        Icon imagenActual = vistaModProducto.getBtnImagenProducto2().getIcon();

        // Si el botón no tiene una imagen, no hacemos nada
        if (imagenActual == null) {
            return;
        }

        // Crear un componente JLabel para mostrar la imagen en el diálogo emergente
        JLabel lblImagen = new JLabel(imagenActual);

        // Crear un diálogo emergente de JOptionPane para mostrar la imagen
        JOptionPane.showMessageDialog(vistaModProducto, lblImagen, "Imagen del Producto", JOptionPane.PLAIN_MESSAGE);
    }

    private void mostrarMensajeMedicamento(String mensaje, int duracionMillisegundos, Icon icono) {
        vistaModProducto.getMensajeExito2().setText(mensaje);
        vistaModProducto.getMensajeExito2().setIcon(icono); // Establecer el icono en el JLabel

        // Iniciar el temporizador para ocultar el mensaje después de la duración especificada
        timer = new Timer(duracionMillisegundos, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ocultarMensaje();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    // </editor-fold>
    // <editor-fold desc="Metodos para el crud de alimento">
    private void crearAlimento() {
        try {
            // Atributos de producto
            String tipoProducto = vistaModProducto.getTxtTipoProducto3().getText();
            //Atributos de tipoDonable
            String nombre = vistaModProducto.getTxtNombreAlimento().getText();
            java.util.Date fechaElaboracionUtil = vistaModProducto.getDatFechaElaboracion1() != null ? vistaModProducto.getDatFechaElaboracion1().getDate() : null;
            java.sql.Date fechaEla = (fechaElaboracionUtil != null) ? new java.sql.Date(fechaElaboracionUtil.getTime()) : null;

            java.util.Date fechaVencimientoUtil = vistaModProducto.getDatFechaVencimiento1() != null ? vistaModProducto.getDatFechaVencimiento1().getDate() : null;
            java.sql.Date fechaVen = (fechaVencimientoUtil != null) ? new java.sql.Date(fechaVencimientoUtil.getTime()) : null;

            //Atributos de alimento
            String tipoAli = vistaModProducto.getCbxTipoAlimento().getSelectedItem().toString();

            // Validar que los campos requeridos estén llenos
            if (nombre.isEmpty() || fechaEla == null || fechaVen == null || tipoAli.equals("Seleccionar")) {
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

                // Crear un objeto tipo donable con los datos necesarios
                TipoDonable tipoDonable = new TipoDonable();

                tipoDonable.setNombre_dona(nombre);
                tipoDonable.setFechaElaboracion(fechaEla);
                tipoDonable.setFechaVencimiento(fechaVen);
                tipoDonable.setId_pro_dona(idProducto);// ID del producto generado

                // Llamar al método insertarTipoDonable del modelo para insertar el registro
                int idTipoDonable = ModeloTipoDonable.insertarTipoDonable(tipoDonable);

                if (idTipoDonable != -1) {
                    //System.out.println("Registro TipoDonable insertado con éxito. ID generado: " + idTipoDonable);

                    // Crear un objeto Ropa con los datos necesarios
                    Alimentos alimento = new Alimentos();

                    alimento.setTipo_ali(tipoAli);
                    alimento.setId_donable_ali(idTipoDonable); // ID del TipoDonable generado

                    // Llamar al método insertarRopa del modelo para insertar el registro
                    int idAli = ModeloAlimento.insertarAlimento(alimento);

                    if (idAli != -1) {
                        //System.out.println("Registro de Alimento insertado con éxito. ID generado: " + idAli);
                        mostrarMensajeAlimento("CREACION EXITOSA", 2000, icon);
                        cargarDatosEnTablaAlimento();
                        limpiarCamposAlimento();
                        cargarIdsCamposAlimento();
                        cargarIdsCamposMedicamento();
                        cargarIdsCamposMueble();
                        cargarIdsCamposRopa();
                        cargarIdsAlimentoEnComboBox();
                        // Confirmar la transacción
                        conexion.commit();
                    } else {
                        // Si hay un error en la inserción, hacer rollback
                        conexion.rollback();
                        JOptionPane.showMessageDialog(vistaModProducto, "Error al crear el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Error al insertar el registro de Alimento.");
                    }
                } else {
                    // Si hay un error en la inserción de TipoDonable, hacer rollback
                    conexion.rollback();
                    System.out.println("Error al insertar el registro tipoDonable.");
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

    private void consultarAlimento() {
        vistaModProducto.getBtnCrear3().setEnabled(false);
        vistaModProducto.getBtnEliminar3().setEnabled(true);
        vistaModProducto.getBtnModificar3().setEnabled(true);

        // Obtener el código seleccionado del ComboBox
        String codigoSeleccionado = vistaModProducto.getCbxCodigosAlimentos().getSelectedItem().toString();

        // Convertir el código a un entero
        int idAliSeleccionado = Integer.parseInt(codigoSeleccionado);

        // Obtener la Ropa correspondiente al ID seleccionado
        Alimentos aliSeleccionado = ModeloAlimento.obtenerAlimentoPorId(idAliSeleccionado);

        // Verificar si se encontró el medicamento
        if (aliSeleccionado != null) {
            // Mostrar los datos en los campos correspondientes de Medicamento
            vistaModProducto.getTxtCodigoAlimento().setText(String.valueOf(aliSeleccionado.getId_ali()));
            vistaModProducto.getCbxTipoAlimento().setSelectedItem(aliSeleccionado.getTipo_ali());

            // Obtener el TipoVendible asociado a la Ropa
            TipoDonable tipoDonableAsociado = ModeloTipoDonable.obtenerTipoDonablePorId(aliSeleccionado.getId_donable_ali());

            // Verificar si se encontró el TipoDonable
            if (tipoDonableAsociado != null) {
                // Mostrar los datos en los campos correspondientes de TipoDonable
                vistaModProducto.getTxtCodigoDonable1().setText(String.valueOf(tipoDonableAsociado.getId_donable()));
                vistaModProducto.getTxtNombreAlimento().setText(tipoDonableAsociado.getNombre_dona());
                vistaModProducto.getDatFechaElaboracion1().setDate(tipoDonableAsociado.getFechaElaboracion());
                vistaModProducto.getDatFechaVencimiento1().setDate(tipoDonableAsociado.getFechaVencimiento());

                // Obtener el Producto asociado al TipoVendible
                Producto productoAsociado = ModeloProducto.obtenerProductoPorId(tipoDonableAsociado.getId_pro_dona());

                // Verificar si se encontró el Producto
                if (productoAsociado != null) {
                    // Mostrar los datos en los campos correspondientes de Producto
                    vistaModProducto.getTxtCodigoProducto3().setText(String.valueOf(productoAsociado.getId_producto()));
                    vistaModProducto.getTxtTipoProducto3().setText(productoAsociado.getTipo_pro());
                    if (productoAsociado.getImagen_pro() != null) {
                        ImageIcon imagen = new ImageIcon(productoAsociado.getImagen_pro());
                        vistaModProducto.getBtnImagenProducto3().setIcon(imagen);
                    } else {
                        // Si la imagen es nula, eliminar la imagen del botón
                        vistaModProducto.getBtnImagenProducto3().setIcon(null);
                    }

                    mostrarMensajeAlimento("CONSULTA EXITOSA", 1000, icon);
                } else {
                    System.out.println("Error: No se encontró el Producto asociado al TipoDonable");
                }
            } else {
                System.out.println("Error: No se encontró el TipoDonable asociado al alimento");

            }
        } else {
            System.out.println("Error: No se encontró el alimento con el ID especificado");
        }
    }

    private void modificarAlimento() {

        try {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de modificar este registro de alimento ?", "Confirmar modificacion", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                String idAliStr = vistaModProducto.getTxtCodigoAlimento().getText();
                int idAli = Integer.parseInt(idAliStr);
                Alimentos alimento = ModeloAlimento.obtenerAlimentoPorId(idAli);

                if (alimento != null) {
                    //Atributos de alimento

                    String nuevoTipoAli = vistaModProducto.getCbxTipoAlimento().getSelectedItem().toString();

                    alimento.setTipo_ali(nuevoTipoAli);

                    boolean resulModificacionAlimento = ModeloAlimento.modificarAlimento(alimento);
                    if (resulModificacionAlimento) {

                        //System.out.println("Modifiacion exitosa de alimento");
                    } else {
                        JOptionPane.showMessageDialog(vistaModProducto, "Error al modificar el Alimento.", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(vistaModProducto, "El Alimento con id " + idAli + " no existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);

                }
                //Modificar atributos de TipoDonable

                String idTipoDonableStr = vistaModProducto.getTxtCodigoDonable1().getText();
                int idTipoDonable = Integer.parseInt(idTipoDonableStr);
                TipoDonable tipoDonable = ModeloTipoDonable.obtenerTipoDonablePorId(idTipoDonable);
                if (tipoDonable != null) {
                    String nuevoNombre = vistaModProducto.getTxtNombreAlimento().getText();
                    java.util.Date fechaElaboracionUtil = vistaModProducto.getDatFechaElaboracion1().getDate();
                    java.sql.Date nuevaFechaElab = new java.sql.Date(fechaElaboracionUtil.getTime());

                    java.util.Date fechaVencimientoUtil = vistaModProducto.getDatFechaVencimiento1().getDate();
                    java.sql.Date nuevaFechaVenc = new java.sql.Date(fechaVencimientoUtil.getTime());

                    tipoDonable.setNombre_dona(nuevoNombre);
                    tipoDonable.setFechaElaboracion(nuevaFechaElab);
                    tipoDonable.setFechaVencimiento(nuevaFechaVenc);

                    boolean resulModficacionTipoDonable = ModeloTipoDonable.modificarTipoDonable(tipoDonable);
                    if (resulModficacionTipoDonable) {
                        //System.out.println("Modificaion exitosa de tipoDonable");

                    } else {
                        System.out.println("Error al modificar el tipoDonable");

                    }
                } else {
                    System.out.println("El id " + idTipoDonable + "de tipoDonable no existe en la base de datos");
                }
                //Modificar atributos de producto
                String idProductotr = vistaModProducto.getTxtCodigoProducto3().getText();
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
                        //System.out.println("Modificacion exitosa de producto");
                        mostrarMensajeAlimento("MODIFICACION EXITOSA", 2000, icon);

                        limpiarCamposAlimento();
                        cargarDatosEnTablaAlimento();
                        vistaModProducto.getBtnCrear3().setEnabled(true);
                    } else {
                        System.out.println("Error al modificar producto");

                    }
                } else {
                    System.out.println("El id " + idProducto + " de producto no existe en la base de datos");
                }
            } else {
                JOptionPane.showMessageDialog(vistaModProducto, "Modificacion cancelada");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al modificar atributos de producto, tipoDonable y alimento");
        }

    }

    private void eliminarAlimento() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este registro de alimento ?", "Confirmar modificacion", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Obtener el ID del medicamento seleccionada en el ComboBox
                String idAliStr = (String) vistaModProducto.getCbxCodigosAlimentos().getSelectedItem();
                int idAli = Integer.parseInt(idAliStr);

                // Obtener el ID del TipoVendible asociado al almento
                int idTipoDonable = ModeloAlimento.obtenerIdTipoDonablePorIdAlimento(idAli);

                // Obtener el ID del Producto asociado al TipoVendible
                int idProducto = ModeloTipoDonable.obtenerIdProductoPorIdTipoDonable(idTipoDonable);

                // Eliminar la Ropa (esto eliminará automáticamente el TipoVendible debido a la restricción de clave foránea)
                boolean resulEliminacionAli = ModeloAlimento.eliminarAlimento(idAli);

                // Verificar si la eliminación de la Ropa fue exitosa
                if (resulEliminacionAli) {
                    // Eliminar el TipoDonable asociado
                    boolean eliminacionExitosaTipoDonable = ModeloTipoDonable.eliminarTipoDonable(idTipoDonable);

                    // Verificar si la eliminación del TipoVendible fue exitosa
                    if (eliminacionExitosaTipoDonable) {
                        // Eliminar el Producto asociado
                        boolean eliminacionExitosaProducto = ModeloProducto.eliminarProducto(idProducto);

                        // Verificar si la eliminación del Producto fue exitosa
                        if (eliminacionExitosaProducto) {
                            // Puedes mostrar un mensaje de éxito
                            mostrarMensajeAlimento("ELIMINACIÓN EXITOSA", 2000, icon);
                            cargarDatosEnTablaAlimento();
                            cargarIdsAlimentoEnComboBox();
                            limpiarCamposAlimento();
                            return;
                        }
                    }
                }

                // Si algo falla, mostrar un mensaje de error
                JOptionPane.showMessageDialog(vistaModProducto, "ERROR AL ELIMINAR El ALIMENTO ", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException | NumberFormatException ex) {
                // Manejar posibles excepciones al obtener el ID seleccionado
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vistaModProducto, "ERROR AL OBTENER EL ID DEL ALIMENTO ", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(vistaModProducto, "MODIFICACION CANCELADA");
        }
    }

    private void reporteAlimento() {

        mostrarMensajeMedicamento("REPORTE EXITOSO", 1000, icon);
    }

    private void limpiarCamposAlimento() {

        vistaModProducto.getTxtNombreAlimento().setText("");
        vistaModProducto.getCbxTipoAlimento().setSelectedIndex(0);
        vistaModProducto.getDatFechaElaboracion1().setDate(null);
        vistaModProducto.getDatFechaVencimiento1().setDate(null);
        vistaModProducto.getBtnImagenProducto3().setIcon(null);
        cargarIdsCamposAlimento();
        vistaModProducto.getBtnCrear3().setEnabled(true);
        vistaModProducto.getBtnEliminar3().setEnabled(false);
        vistaModProducto.getBtnModificar3().setEnabled(false);
    }

    private void deshabilitarCamposAlimento() {
        vistaModProducto.getTxtCodigoAlimento().setEditable(false);
        vistaModProducto.getTxtCodigoProducto3().setEditable(false);
        vistaModProducto.getTxtCodigoDonable1().setEditable(false);
        vistaModProducto.getTxtTipoProducto3().setEditable(false);

    }

    private void cargarIdsAlimentoEnComboBox() {
        List<Integer> idsAli = ModeloAlimento.obtenerIdsAlimentos();
        vistaModProducto.getCbxCodigosAlimentos().removeAllItems();
        for (int idAli : idsAli) {
            // Convertir el entero a cadena antes de agregarlo al JComboBox
            vistaModProducto.getCbxCodigosAlimentos().addItem(String.valueOf(idAli));
        }
    }

    private void cargarDatosEnTablaAlimento() {
        // Obtener la lista de detalles de ropa desde el modelo
        List<Alimentos> listaDetallesAli = ModeloAlimento.obtenerDetallesAlimentos();

        // Crear un DefaultTableModel con las columnas necesarias
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha Elaboracion");
        modeloTabla.addColumn("Fecha Vencimiento");
        modeloTabla.addColumn("Tipo alimento");

        // Llenar el modelo de la tabla con los datos de la lista de detalles de ropas
        for (Alimentos detalle : listaDetallesAli) {
            Object[] fila = {
                detalle.getId_ali(),
                detalle.getNombre_dona(),
                detalle.getFechaElaboracion(),
                detalle.getFechaVencimiento(),
                detalle.getTipo_ali()
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo de la tabla en la vista
        vistaModProducto.getTblAlimentos().setModel(modeloTabla);
    }

    private void cargarIdsCamposAlimento() {
        int idUltimoAli = ModeloAlimento.obtenerUltimoIdAlimento();
        vistaModProducto.getTxtCodigoAlimento().setText(String.valueOf(idUltimoAli + 1));
        int idUltimoTipoDonable = ModeloTipoDonable.obtenerUltimoIdTipoDonable();
        vistaModProducto.getTxtCodigoDonable1().setText(String.valueOf(idUltimoTipoDonable + 1));
        int idUltimoProducto = ModeloProducto.obtenerUltimoIdProducto();
        vistaModProducto.getTxtCodigoProducto3().setText(String.valueOf(idUltimoProducto + 1));
    }

    private void cargarImagenAlimento() {
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        if (jf.showOpenDialog(vistaModProducto) == JFileChooser.APPROVE_OPTION) {
            rutaImagenSeleccionada = jf.getSelectedFile().toString();

            // Mostrar la imagen en el botón btnImagenProducto
            vistaModProducto.getBtnImagenProducto3().setIcon(new ImageIcon(rutaImagenSeleccionada));

            // Obtener los bytes de la imagen y guardarlos en la variable imagenBytes
            imagenBytes = obtenerBytesImagen(rutaImagenSeleccionada);
        }
    }

    private void mostrarImagenEnDialogoEmergenteAlimento() {
        // Obtener la imagen actual del botón
        Icon imagenActual = vistaModProducto.getBtnImagenProducto3().getIcon();

        // Si el botón no tiene una imagen, no hacemos nada
        if (imagenActual == null) {
            return;
        }

        // Crear un componente JLabel para mostrar la imagen en el diálogo emergente
        JLabel lblImagen = new JLabel(imagenActual);

        // Crear un diálogo emergente de JOptionPane para mostrar la imagen
        JOptionPane.showMessageDialog(vistaModProducto, lblImagen, "Imagen del Producto", JOptionPane.PLAIN_MESSAGE);
    }

    private void mostrarMensajeAlimento(String mensaje, int duracionMillisegundos, Icon icono) {
        vistaModProducto.getMensajeExito3().setText(mensaje);
        vistaModProducto.getMensajeExito3().setIcon(icono); // Establecer el icono en el JLabel

        // Iniciar el temporizador para ocultar el mensaje después de la duración especificada
        timer = new Timer(duracionMillisegundos, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ocultarMensaje();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    // </editor-fold>
}
