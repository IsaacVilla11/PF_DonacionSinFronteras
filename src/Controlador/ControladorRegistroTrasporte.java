/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloConductor;
import Modelo.ModeloRegistroTras;
import Modelo.RegistroTransporte;
import Vista.Registro_Conductor;
import Vista.Registro_trasporte;
import Vista.vistaAdministrador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS TUF
 */
public class ControladorRegistroTrasporte {

    private static final int columnaIdRegistro = 0;
    private JButton btnGuardar;
    Registro_trasporte vistatras;
    ModeloRegistroTras modTras = new ModeloRegistroTras();

    public ControladorRegistroTrasporte(Registro_trasporte vistatras) {
        this.vistatras = vistatras;
        vistatras.setVisible(true);
        //iniciarControl();
    }

    public void iniciarControl() {

        llenarComboBoxLugaresConId();
        llenarComboBoxCamiones();
        llenarComboBoxDonaciones();
        mostrarRegistrosEnTabla();

        btnGuardar = vistatras.getBtnGuardar();
        vistatras.getBtnVolver().addActionListener(l -> RegresarModuloAdmin());
        vistatras.getBtnGuardar().addActionListener(l -> guardarRegistroTransporte());
        vistatras.getBtnBuscar().addActionListener(l -> buscarRegistroTransportePorID());
        vistatras.getBntModificar().addActionListener(l -> guardarCambiosRegistroTransporte());
        vistatras.getBtnEliminar().addActionListener(l -> eliminarRegistroSeleccionado());

    }
    
     public void RegresarModuloAdmin() {
        vistatras.dispose();
        vistaAdministrador vistaAdmin = new vistaAdministrador();
        vistaAdmin.setLocationRelativeTo(null);
        vistaAdmin.setVisible(true);

        ControladorModuloAdmin controlAdmin = new ControladorModuloAdmin(vistaAdmin);
        controlAdmin.iniciarControl();
    }

    public void eliminarRegistroSeleccionado() {
        int filaSeleccionada = vistatras.getTabla().getSelectedRow();

        if (filaSeleccionada == -1) {
           
            JOptionPane.showMessageDialog(vistatras, "Seleccione una fila para eliminar");
            return;
        }

        int idRegistroAEliminar = (int) vistatras.getTabla().getValueAt(filaSeleccionada, columnaIdRegistro);

    
        int confirmacion = JOptionPane.showConfirmDialog(vistatras, "¿Está seguro de eliminar este registro de transporte?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
        
            boolean eliminado = modTras.eliminarRegistroPorId(idRegistroAEliminar);

            if (eliminado) {
                JOptionPane.showMessageDialog(vistatras, "Registro de transporte eliminado correctamente");
                mostrarRegistrosEnTabla(); // Actualizar la tabla después de la eliminación
            } else {
                JOptionPane.showMessageDialog(vistatras, "Error al eliminar el registro de transporte");
            }
        }
    }

    public void guardarCambiosRegistroTransporte() {
        try {

            String idRegistro = vistatras.getTxtid().getText();

            if (idRegistro != null && !idRegistro.trim().isEmpty()) {
                int idRegistroInt = Integer.parseInt(idRegistro);

                // Verificar si el registro existe en la base de datos
                if (modTras.existeRegistroTransporteConID(idRegistroInt)) {

                    RegistroTransporte registroActual = modTras.obtenerRegistroConDatosCompletosPorID(idRegistroInt);

                    RegistroTransporte registroModificado = new RegistroTransporte();
                    registroModificado.setId_reg_trans(idRegistroInt);

                    LocalDate fechaLlegada = convertirDateALocalDate(vistatras.getFechafin().getDate());
                    LocalDate hoy = LocalDate.now();

                    if (fechaLlegada.isBefore(hoy)) {
                        JOptionPane.showMessageDialog(null, "Error: La fecha de llegada no puede ser de ayer o anterior.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Salir de la función si la fecha no es válida
                    }

                    registroModificado.setFecha_llegada(vistatras.getFechafin().getDate());

                    String idLugarCombo = (String) vistatras.getCombolugares().getSelectedItem();
                    int idLugarInt = Integer.parseInt(extraerNumeros(idLugarCombo));
                    registroModificado.setId_lugar(idLugarInt);

                    String idCamionCombo = (String) vistatras.getComboCamniones().getSelectedItem();
                    int idCamionInt = Integer.parseInt(extraerNumeros(idCamionCombo));
                    registroModificado.setId_cam_retr(idCamionInt);

                    String idDonacionCombo = (String) vistatras.getComboDonaciones1().getSelectedItem();
                    int idDonacionInt = Integer.parseInt(idDonacionCombo);
                    registroModificado.setId_donacion(idDonacionInt);

                    boolean exito = modTras.actualizarRegistroTransporte(registroModificado);

                    if (exito) {
                        JOptionPane.showMessageDialog(null, "Cambios guardados exitosamente");

                        mostrarRegistrosEnTabla();

                        btnGuardar.setEnabled(true);

                        vistatras.getTxtid().setText("");
                        vistatras.getTxtid().setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un registro con ID: " + idRegistro, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private LocalDate convertirDateALocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void buscarRegistroTransportePorID() {
        try {
            btnGuardar.setEnabled(false);

            String idRegistro = vistatras.getTxtid().getText();

            // Verificar si se ingresó un ID
            if (idRegistro != null && !idRegistro.trim().isEmpty()) {

                int idRegistroInt = Integer.parseInt(idRegistro);

                if (modTras.existeRegistroTransporteConID(idRegistroInt)) {

                    RegistroTransporte registro = modTras.obtenerRegistroConDatosCompletosPorID(idRegistroInt);
                    vistatras.getTxtid().setEnabled(false);
                    // Llenar los campos de la interfaz con los datos obtenidos
                    if (registro != null) {
                        vistatras.getFechafin().setDate(registro.getFecha_llegada());

                        String idNombreLugar = registro.getId_lugar() + " - " + registro.getLugar().getNombre_lug();
                        vistatras.getCombolugares().setSelectedItem(idNombreLugar);

                        String idMarcaCamion = registro.getId_cam_retr() + " - " + registro.getMarca_cam();
                        vistatras.getComboCamniones().setSelectedItem(idMarcaCamion);

                        vistatras.getComboDonaciones1().setSelectedItem(String.valueOf(registro.getId_donacion()));

                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el registro con ID: " + idRegistro, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un registro con ID: " + idRegistro, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void seleccionarItemEnComboBox(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                comboBox.setSelectedIndex(i);
                return;
            }
        }
    }

    public void llenarComboBoxLugaresConId() {
        List<String> idNombresLugares = modTras.listarNombresLugaresConId();

        vistatras.getCombolugares().removeAllItems();

        // Agregar los id + nombre de los lugares al JComboBox solo si hay lugares
        if (idNombresLugares != null) {
            for (String idNombreLugar : idNombresLugares) {
                vistatras.getCombolugares().addItem(idNombreLugar);
            }
        }
    }

    public void llenarComboBoxCamiones() {
        List<String> idMarcaCamiones = modTras.obtenerIdMarcaCamiones();

        vistatras.getComboCamniones().removeAllItems();

        // Agregar los id + marca de los camiones al JComboBox solo si hay camiones
        if (idMarcaCamiones != null) {
            for (String idMarcaCamion : idMarcaCamiones) {
                vistatras.getComboCamniones().addItem(idMarcaCamion);
            }
        }
    }

    public void llenarComboBoxDonaciones() {
        List<Long> idDonaciones = modTras.obtenerIdDonaciones();

        vistatras.getComboDonaciones1().removeAllItems();

        if (idDonaciones != null) {
            for (Long idDonacion : idDonaciones) {
                vistatras.getComboDonaciones1().addItem(idDonacion.toString());
            }
        }
    }

    public void guardarRegistroTransporte() {
        try {
            // Obtener los valores desde la interfaz gráfica
            if (vistatras.getFechafin().getDate() == null) {
                JOptionPane.showMessageDialog(null, "La fecha de llegada no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Date fechaLlegadaDate = vistatras.getFechafin().getDate();
            LocalDate fechaLlegadaLocal = convertirDateALocalDate(fechaLlegadaDate);
            LocalDate hoy = LocalDate.now();

            // Validar que la fecha de llegada sea de hoy en adelante
            if (fechaLlegadaLocal.isBefore(hoy)) {
                JOptionPane.showMessageDialog(null, "Error: La fecha de llegada no puede ser de ayer o anterior.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaLlegada = sdf.format(fechaLlegadaDate);

            String idCamion = (String) vistatras.getComboCamniones().getSelectedItem();
            String idLugar = (String) vistatras.getCombolugares().getSelectedItem();
            String idDonacion = (String) vistatras.getComboDonaciones1().getSelectedItem();

            int idCamionInt = idCamion.isEmpty() ? 0 : Integer.parseInt(extraerNumeros(idCamion));
            int idLugarInt = idLugar.isEmpty() ? 0 : Integer.parseInt(extraerNumeros(idLugar));
            int idDonacionInt = idDonacion.isEmpty() ? 0 : Integer.parseInt(extraerNumeros(idDonacion));

            // Validar que los campos no estén vacíos
            if (fechaLlegada.trim().isEmpty() || idCamion.trim().isEmpty() || idLugar.trim().isEmpty() || idDonacion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            RegistroTransporte nuevoRegistro = new RegistroTransporte();
            nuevoRegistro.setFecha_llegada(sdf.parse(fechaLlegada));
            nuevoRegistro.setId_cam_retr(idCamionInt);
            nuevoRegistro.setId_lugar(idLugarInt);
            nuevoRegistro.setId_donacion(idDonacionInt);

            boolean exito = modTras.insertarRegistroTransporte(nuevoRegistro);

            if (exito) {
                JOptionPane.showMessageDialog(null, "Registro de transporte guardado exitosamente");
                mostrarRegistrosEnTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el registro de transporte");
            }
        } catch (ParseException e) {
            // Manejar la excepción si hay un error al convertir la fecha
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al convertir la fecha de llegada");
        } catch (NumberFormatException e) {
            // Manejar la excepción si hay un error al convertir números
            JOptionPane.showMessageDialog(null, "Error en el formato de datos.");
            e.printStackTrace();
        }
    }

    private String extraerNumeros(String input) {
        return input.replaceAll("\\D", "");
    }

// Método auxiliar para convertir un String en formato "yyyy-MM-dd" a Date
    private Date convertirStringADate(String fechaString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mostrarRegistrosEnTabla() {
        // Obtener la lista de registros con datos completos desde el modelo
        List<RegistroTransporte> registros = modTras.obtenerRegistrosConDatosCompletos();

        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();

        // Agregar columnas al modelo
        modeloTabla.addColumn("ID Registro");
        modeloTabla.addColumn("Fecha Salida");
        modeloTabla.addColumn("Fecha Llegada");
        modeloTabla.addColumn("ID Camión");
        modeloTabla.addColumn("Marca Camión");
        modeloTabla.addColumn("ID Lugar");
        modeloTabla.addColumn("Nombre Lugar");
        modeloTabla.addColumn("ID Donación");

        // Agregar filas al modelo con los datos de los registros
        for (RegistroTransporte registro : registros) {
            Object[] fila = {
                registro.getId_reg_trans(),
                registro.getFecha_salida(),
                registro.getFecha_llegada(),
                registro.getId_cam_retr(),
                registro.getMarca_cam(),
                registro.getId_lugar(),
                registro.getLugar().getNombre_lug(),
                registro.getId_donacion()
            };
            modeloTabla.addRow(fila);
        }

        // Asignar el modelo a la tabla
        vistatras.getTabla().setModel(modeloTabla);
    }

}
