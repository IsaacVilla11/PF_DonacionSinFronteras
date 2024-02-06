/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Camion;
import Modelo.Conductor;
import Modelo.ModeloCamion;
import Modelo.ModeloConductor;
import Modelo.ModeloUsuario;
import Vista.Registro_Camion;
import Vista.vistaAdministrador;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS TUF
 */
public class ControladorRegistroCamion {

    Registro_Camion vistaCamion;
    ModeloCamion modCam = new ModeloCamion();
    private JButton btnGuardar;

    public ControladorRegistroCamion(Registro_Camion vistaCamion) {
        this.vistaCamion = vistaCamion;
        vistaCamion.setVisible(true);
        // iniciarControl();

    }

    public void iniciarControl() {

        //  cargarTabla
        btnGuardar = vistaCamion.getBtnGuardar();
        cargarComboConductores();
        cargarTablaCamion();

        System.out.println("Iniciando control...");

//        btnGuardar = vistaConduct.getBtnGuardar();
        vistaCamion.getBtnVolver().addActionListener(l -> RegresarModuloAdmin());
        vistaCamion.getBtnGuardar().addActionListener(l -> crearCamionDesdeInterfaz());
        vistaCamion.getBtnEliminar().addActionListener(l -> eliminarCamionSeleccionado());
        vistaCamion.getBtnConsultar().addActionListener(l -> cargarDatosCamion());
        vistaCamion.getBtnModificar().addActionListener(l -> modificarCamionDesdeInterfaz());

    }

    public void RegresarModuloAdmin() {
        vistaCamion.dispose();
        vistaAdministrador vistaAdmin = new vistaAdministrador();
        vistaAdmin.setLocationRelativeTo(null);
        vistaAdmin.setVisible(true);

        ControladorModuloAdmin controlAdmin = new ControladorModuloAdmin(vistaAdmin);
        controlAdmin.iniciarControl();
    }

    public int obtenerIdNuevoConductorSeleccionado() {
        String selectedConductor = (String) vistaCamion.getCombo_donductores().getSelectedItem();
        if (selectedConductor != null) {
            // Parsea el ID del conductor del String seleccionado
            return Integer.parseInt(selectedConductor.split(" - ")[0]);
        }
        return -1; // Otra opción podría ser lanzar una excepción si no hay ningún conductor seleccionado
    }

    public void modificarCamionDesdeInterfaz() {
        System.out.println("Modificando camión desde la interfaz...");

        try {
            int idCamion = Integer.parseInt(vistaCamion.getTxtid().getText());
            int idNuevoConductor = obtenerIdNuevoConductorSeleccionado();
            String marca = vistaCamion.getTxtmarca().getText().trim();
            String color = vistaCamion.getTxtcolor().getText().trim();
            String modelo = vistaCamion.getTxtmodelo().getText().trim();

            String pesoInput = vistaCamion.getTxtpeso().getText().trim();
            if (pesoInput.isEmpty()) {
                JOptionPane.showMessageDialog(vistaCamion, "El campo de peso no puede estar vacío.");
                return;
            }

            int pesoMax = Integer.parseInt(pesoInput);

            if (marca.isEmpty() || color.isEmpty() || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(vistaCamion, "Todos los campos deben estar llenos.");
                return;
            }

            boolean modificadoExitosamente = modCam.modificarCamion(idCamion, idNuevoConductor, marca, color, modelo, pesoMax);

            if (modificadoExitosamente) {
                cargarTablaCamion();
                limpiarCamposCamion();
                JOptionPane.showMessageDialog(vistaCamion, "Camión modificado exitosamente.");
                btnGuardar.setEnabled(true);
                vistaCamion.getTxtid().setEnabled(true);
            } else {
                // Si no se modificó exitosamente, no hagas nada en la interfaz.
                // El mensaje de error ya se maneja en el método del modelo.
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistaCamion, "Error en el formato de datos.");
            ex.printStackTrace();
        }
    }

//    public void modificarCamionDesdeInterfaz() {
//        System.out.println("Modificando camión desde la interfaz...");
//        
//        try {
//            
//            int idCamion = Integer.parseInt(vistaCamion.getTxtid().getText());
//            int idNuevoConductor = obtenerIdNuevoConductorSeleccionado(); // Método a implementar en la vista
//            String marca = vistaCamion.getTxtmarca().getText().trim();
//            String color = vistaCamion.getTxtcolor().getText().trim();
//            String modelo = vistaCamion.getTxtmodelo().getText().trim();
//
//            String pesoInput = vistaCamion.getTxtpeso().getText().trim();
//            if (pesoInput.isEmpty()) {
//                JOptionPane.showMessageDialog(vistaCamion, "El campo de peso no puede estar vacío.");
//                return;
//            }
//
//            int pesoMax = Integer.parseInt(pesoInput);
//
//            if (marca.isEmpty() || color.isEmpty() || modelo.isEmpty()) {
//                JOptionPane.showMessageDialog(vistaCamion, "Todos los campos deben estar llenos.");
//                return;
//            }
//
//            modCam.modificarCamion(idCamion, idNuevoConductor, marca, color, modelo, pesoMax);
//
//            cargarTablaCamion();
//            limpiarCamposCamion();
//
//            JOptionPane.showMessageDialog(vistaCamion, "Camión modificado exitosamente.");
//            
//            btnGuardar.setEnabled(true);
//            vistaCamion.getTxtid().setEnabled(true);
//
//        } catch (NumberFormatException ex) {
//            // Manejo de errores si hay problemas al convertir datos numéricos
//            JOptionPane.showMessageDialog(vistaCamion, "Error en el formato de datos.");
//            ex.printStackTrace();
//        }
//    }
    public void cargarDatosCamion() {

        try {
            btnGuardar.setEnabled(false);
            int idCamion = Integer.parseInt(vistaCamion.getTxtid().getText());
            Camion camion = modCam.obtenerDetallesCamionPorId(idCamion);

            if (camion != null) {

                vistaCamion.getTxtmarca().setText(camion.getMarca_cam());
                vistaCamion.getTxtcolor().setText(camion.getColor_cam());
                vistaCamion.getTxtmodelo().setText(camion.getModelo_cam());
                vistaCamion.getTxtpeso().setText(String.valueOf(camion.getPeso_max_cam()));

                // Cargar el ComboBox de conductores
                vistaCamion.getCombo_donductores().removeAllItems();
                List<Conductor> conductores = modCam.obtenerDetallesConductores();
                if (conductores != null && !conductores.isEmpty()) {
                    for (Conductor conductor : conductores) {
                        String infoConductor = conductor.getId_conductor() + " - "
                                + conductor.getNombre_usu() + " " + conductor.getApellido_usu();
                        vistaCamion.getCombo_donductores().addItem(infoConductor);

                        // Si el conductor es el mismo que el del camión, seleccionarlo
                        if (conductor.getId_conductor() == camion.getId_conductor_cam()) {
                            vistaCamion.getCombo_donductores().setSelectedItem(infoConductor);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaCamion, "No se encontraron conductores");
                }

                vistaCamion.getTxtid().setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(vistaCamion, "No se encontró el camión con el ID proporcionado");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistaCamion, "Ingrese un ID de camión válido");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vistaCamion, "Error al cargar los datos del camión");
        }
    }

    public void cargarComboConductores() {

        try {
            System.out.println("Cargando conductores...");
            // Limpia el ComboBox antes de cargar nuevos datos
            vistaCamion.getCombo_donductores().removeAllItems();

            // Llama al nuevo método en el modelo para obtener los detalles de los conductores
            List<Conductor> conductores = modCam.obtenerDetallesConductores();

            // Verifica si se obtuvieron resultados
            if (conductores != null && !conductores.isEmpty()) {
                // Agrega los conductores al ComboBox con id, nombre y apellido en una misma fila
                for (Conductor conductor : conductores) {
                    // Utiliza el id_conductor en lugar de id_persona_con
                    String infoConductor = conductor.getId_conductor() + " - "
                            + conductor.getNombre_usu() + " "
                            + conductor.getApellido_usu();
                    vistaCamion.getCombo_donductores().addItem(infoConductor);
                }
            } else {
                // Manejo si no se obtuvieron resultados
                JOptionPane.showMessageDialog(vistaCamion, "No hay conductores registrados");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            e.printStackTrace();
            JOptionPane.showMessageDialog(vistaCamion, "Error al cargar los conductores");
        }
    }

    public void crearCamionDesdeInterfaz() {
        System.out.println("Creando camión desde la interfaz...");
        try {

            String selectedConductor = (String) vistaCamion.getCombo_donductores().getSelectedItem();
            int idConductor = Integer.parseInt(selectedConductor.split(" - ")[0]);
            String marca = vistaCamion.getTxtmarca().getText().trim();
            String color = vistaCamion.getTxtcolor().getText().trim();
            String modelo = vistaCamion.getTxtmodelo().getText().trim();

            String pesoInput = vistaCamion.getTxtpeso().getText().trim();
            if (pesoInput.isEmpty()) {
                JOptionPane.showMessageDialog(vistaCamion, "El campo de peso no puede estar vacío.");
                return;
            }

            int pesoMax = Integer.parseInt(pesoInput);

            if (marca.isEmpty() || color.isEmpty() || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(vistaCamion, "Todos los campos deben estar llenos.");
                return;
            }

            if (modCam.conductorAsignadoACamion(idConductor)) {
                JOptionPane.showMessageDialog(vistaCamion, "Este conductor ya está asignado a otro camión.");
                return;
            }

            modCam.crearCamionSeleccionado(idConductor, marca, color, modelo, pesoMax);

            cargarTablaCamion();
            limpiarCamposCamion();

            JOptionPane.showMessageDialog(vistaCamion, "Camión creado exitosamente.");

        } catch (NumberFormatException ex) {
            // Manejo de errores si hay problemas al convertir datos numéricos
            JOptionPane.showMessageDialog(vistaCamion, "Error en el formato de datos.");
            ex.printStackTrace();
        }
    }

    private void limpiarCamposCamion() {
        vistaCamion.getCombo_donductores().setSelectedIndex(0);
        vistaCamion.getTxtmarca().setText("");
        vistaCamion.getTxtcolor().setText("");
        vistaCamion.getTxtmodelo().setText("");
        vistaCamion.getTxtpeso().setText("");
    }

    public void cargarTablaCamion() {
        try {
            List<Camion> camiones = modCam.obtenerDetallesCamiones();

            if (camiones != null && !camiones.isEmpty()) {
                // Crea un DefaultTableModel con columnas específicas
                DefaultTableModel modeloTabla = new DefaultTableModel();
                modeloTabla.addColumn("ID Camion");
                modeloTabla.addColumn("Marca");
                modeloTabla.addColumn("Color");
                modeloTabla.addColumn("Modelo");
                modeloTabla.addColumn("Peso Máximo");
                modeloTabla.addColumn("Conductor");

                for (Camion camion : camiones) {
                    Object[] fila = {
                        camion.getId_cam(),
                        camion.getMarca_cam(),
                        camion.getColor_cam(),
                        camion.getModelo_cam(),
                        camion.getPeso_max_cam(), // Añade el campo de peso
                        camion.getId_conductor_cam() + " - " + camion.getNombre_usu()
                    };
                    modeloTabla.addRow(fila);
                }

                vistaCamion.getTablacamiones().setModel(modeloTabla);
            } else {
                JOptionPane.showMessageDialog(vistaCamion, "No hay camiones registrados");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            e.printStackTrace();
            JOptionPane.showMessageDialog(vistaCamion, "Error al cargar la tabla de camiones");
        }
    }

    public void eliminarCamionSeleccionado() {

        int filaSeleccionada = vistaCamion.getTablacamiones().getSelectedRow();

        if (filaSeleccionada != -1) {

            int idCamion = (int) vistaCamion.getTablacamiones().getValueAt(filaSeleccionada, 0);

            int opcion = JOptionPane.showConfirmDialog(vistaCamion, "¿Está seguro de eliminar el camión seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {

                boolean eliminado = modCam.eliminarCamion(idCamion);

                if (eliminado) {

                    cargarTablaCamion();
                    JOptionPane.showMessageDialog(vistaCamion, "Camión eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(vistaCamion, "Error al eliminar el camión");
                }
            }
        }
    }

}
