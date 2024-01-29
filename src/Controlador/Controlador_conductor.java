/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Conductor;
import Modelo.ModeloConductor;
import Modelo.ModeloUsuario;
import Vista.Registro_Conductor;
import Vista.vistaAdministrador;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author ASUS TUF
 */
public class Controlador_conductor {

    private static final int columnaIdConductor = 0;
    private JButton btnGuardar;
    Registro_Conductor vistaConduct;
    ModeloConductor modConduct = new ModeloConductor();

    public Controlador_conductor(Registro_Conductor vistaConduct) {
        this.vistaConduct = vistaConduct;
        vistaConduct.setVisible(true);
        //iniciarControl();
    }

    public void iniciarControl() {
        cargarTabla();
        btnGuardar = vistaConduct.getBtnGuardar();
        vistaConduct.getBntVolver().addActionListener(l -> RegresarModuloAdmin());
        vistaConduct.getBtnGuardar().addActionListener(l -> RegistrarConductor());
        vistaConduct.getBtnEliminar().addActionListener(l -> eliminarConductorSeleccionado());

        vistaConduct.getBtncargar().addActionListener(l -> buscarConductorPorCedula());
         vistaConduct.getBtnModificar().addActionListener(l -> guardarCambiosConductor());
        
        //vistaConduct.getBtnModificar().addActionListener(l -> guardarCambios());

        // Otros eventos...
    }

    public void RegresarModuloAdmin() {
        vistaConduct.dispose();
        vistaAdministrador vistaAdmin = new vistaAdministrador();
        vistaAdmin.setLocationRelativeTo(null);
        vistaAdmin.setVisible(true);

        ControladorModuloAdmin controlAdmin = new ControladorModuloAdmin(vistaAdmin);
        controlAdmin.iniciarControl();
    }
    
    public void guardarCambiosConductor() {
        try {
            String cedula = vistaConduct.getTxtcedula().getText();

            // Verificar duplicidad de la cédula de la persona
//            if (modConduct.verificarDuplicidadCedulaConductor(cedula)) {
//                JOptionPane.showMessageDialog(vistaConduct, "La cedula ingresada ya existe en el sistema");
//                vistaConduct.getTxtcedula().setText("");
//                return;
//            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaConduct, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }

            // Obtén los datos cargados en la vista
            String nombre = vistaConduct.getTxtnombre().getText();
            String apellido = vistaConduct.getTxtapellido().getText();
            String genero;
            if (vistaConduct.getBtnH().isSelected()) {
                genero = "Hombre";
            } else if (vistaConduct.getBtnM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaConduct, "Seleccione un género");
                return;
            }
            String celular = vistaConduct.getTxtcelular().getText();
            String correo = vistaConduct.getTxtcorreo().getText();
            String direccion = vistaConduct.getTxtdirecion().getText();
            String contrase = vistaConduct.getTxtcontra().getText();
            String tipoSangre = vistaConduct.getCbBoxSangre().getSelectedItem().toString();
            String ciudad = (String) vistaConduct.getCbboxCiudad().getSelectedItem();
            String jornada = (String) vistaConduct.getComboJornada().getSelectedItem();
            String tipoLicencia = (String) vistaConduct.getComboLicencia().getSelectedItem();

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaConduct.getF_nacimiento().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaConduct.getF_nacimiento().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaConduct.getF_nacimiento().getCalendar().get(Calendar.YEAR));
            String fechaNacimiento = año + "-" + mes + "-" + dia;

            // Crear un nuevo modeloConductor con los datos actualizados
            ModeloConductor conductorActualizado = new ModeloConductor();
            conductorActualizado.setCedula_usu(cedula);
            conductorActualizado.setNombre_usu(nombre);
            conductorActualizado.setApellido_usu(apellido);
            conductorActualizado.setSexo_usu(genero);
            conductorActualizado.setCelular_usu(celular);
            conductorActualizado.setCorreo_usu(correo);
            conductorActualizado.setDireccion_usu(direccion);
            conductorActualizado.setContraseña_usu(contrase);
            conductorActualizado.setTipoSangre_usu(tipoSangre);
            conductorActualizado.setCiudad_usu(ciudad);
            conductorActualizado.setFechaNacimiento_usu(fechaNacimiento);
            conductorActualizado.setJornada_con(jornada);
            conductorActualizado.setTipoLicencia_con(tipoLicencia);

            // Llamar al método de actualización en el modeloConductor
            if (modConduct.actualizarConductor(conductorActualizado)) {
                JOptionPane.showMessageDialog(vistaConduct, "Cambios guardados exitosamente");
                btnGuardar.setEnabled(true);
                vistaConduct.getTxtcedula().setEnabled(true);
                cargarTabla();
                limpiarCampos();
                
            } else {
                JOptionPane.showMessageDialog(vistaConduct, "Error al guardar cambios");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            e.printStackTrace();
            JOptionPane.showMessageDialog(vistaConduct, "Error al intentar guardar cambios");
        }
    }
    
    



    public void buscarConductorPorCedula() {
        try {
            btnGuardar.setEnabled(false);
            String cedulaBuscada = vistaConduct.getTxtcedula().getText();

            // Verificar la validez de la cédula
            if (!Validaciones.ValidarCedula(cedulaBuscada)) {
                JOptionPane.showMessageDialog(vistaConduct, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }

            ModeloConductor conductor = new ModeloConductor();

            // Realizar la búsqueda en la base de datos
            if (conductor.buscarConductorPorCedula(cedulaBuscada)) {
                // Si se encuentra el conductor, llenar todos los datos en la interfaz
                vistaConduct.getTxtcedula().setEnabled(false); // Bloquear el campo de cédula
                vistaConduct.getTxtnombre().setText(conductor.getNombre_usu());
                vistaConduct.getTxtapellido().setText(conductor.getApellido_usu());
                vistaConduct.getComboJornada().setSelectedItem(conductor.getJornada_con());
                vistaConduct.getComboLicencia().setSelectedItem(conductor.getTipoLicencia_con());
                vistaConduct.getTxtcelular().setText(conductor.getCelular_usu());
                vistaConduct.getTxtcorreo().setText(conductor.getCorreo_usu());
                vistaConduct.getTxtdirecion().setText(conductor.getDireccion_usu());
                vistaConduct.getCbBoxSangre().setSelectedItem(conductor.getTipoSangre_usu());

                // Nuevos campos
                vistaConduct.getF_nacimiento().setCalendar(
                        obtenerCalendarDesdeString(conductor.getFechaNacimiento_usu())
                );
                vistaConduct.getBtnH().setSelected("Hombre".equals(conductor.getSexo_usu()));
                vistaConduct.getBtnM().setSelected("Mujer".equals(conductor.getSexo_usu()));
                vistaConduct.getCbboxCiudad().setSelectedItem(conductor.getCiudad_usu());

                // Contraseña
                vistaConduct.getTxtcontra().setText(conductor.getContraseña_usu());

                JOptionPane.showMessageDialog(vistaConduct, "Datos cargados exitosamente");
            } else {
                JOptionPane.showMessageDialog(vistaConduct, "La cédula ingresada no existe en el sistema");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            e.printStackTrace();
            JOptionPane.showMessageDialog(vistaConduct, "Error al buscar la cédula en la base de datos");
        }
    }

    private Calendar obtenerCalendarDesdeString(String fecha) {
        // Convierte una cadena de fecha en el formato "yyyy-MM-dd" a un objeto Calendar
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(fecha);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void RegistrarConductor() {
        ModeloConductor conductor = new ModeloConductor();
        ModeloUsuario persona = new ModeloUsuario();

        try {
            String cedula = vistaConduct.getTxtcedula().getText();

            // Verificar duplicidad de la cédula de la persona
            if (persona.verificarDuplicidadCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaConduct, "La cedula ingresada ya existe en el sistema");
                vistaConduct.getTxtcedula().setText("");
                return;
            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaConduct, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            persona.setCedula_usu(cedula);

            String nombre = vistaConduct.getTxtnombre().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaConduct, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            persona.setNombre_usu(nombre);

            String apellido = vistaConduct.getTxtapellido().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaConduct, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            persona.setApellido_usu(apellido);

            String genero;
            if (vistaConduct.getBtnH().isSelected()) {
                genero = "Hombre";
            } else if (vistaConduct.getBtnM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaConduct, "Seleccione un género");
                return;
            }
            persona.setSexo_usu(genero);

            String celular = vistaConduct.getTxtcelular().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaConduct, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            persona.setCelular_usu(celular);

            String correo = vistaConduct.getTxtcorreo().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaConduct, "Correo no válido. Ingrese de nuevo");
                return;
            }
            persona.setCorreo_usu(correo);

            String direccion = vistaConduct.getTxtdirecion().getText();
            if (!Validaciones.ValidarDireccion(direccion)) {
                JOptionPane.showMessageDialog(vistaConduct, "Direccion no válido. Ingrese de nuevo");
                return;
            }
            persona.setDireccion_usu(direccion);

            String contrase = vistaConduct.getTxtcontra().getText();
            if (!Validaciones.ValidarContrasena(contrase)) {
                JOptionPane.showMessageDialog(vistaConduct, "Contraseña no válido. Ingrese de nuevo");
                return;
            }
            persona.setContraseña_usu(contrase);

            String tipoSangre = vistaConduct.getCbBoxSangre().getSelectedItem().toString();
            persona.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaConduct.getCbboxCiudad().getSelectedItem();
            persona.setCiudad_usu(ciudad);

            // Otros campos comunes a Usuario...
            String jornada = (String) vistaConduct.getComboJornada().getSelectedItem();
            conductor.setJornada_con(jornada);

            String tipoLicencia = (String) vistaConduct.getComboLicencia().getSelectedItem();
            conductor.setTipoLicencia_con(tipoLicencia);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaConduct.getF_nacimiento().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaConduct.getF_nacimiento().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaConduct.getF_nacimiento().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = año + "-" + mes + "-" + dia;

            if (vistaConduct.getF_nacimiento() == null) {
                JOptionPane.showMessageDialog(vistaConduct, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            persona.setFechaNacimiento_usu(FechaNacimiento);

            System.out.println("Antes de InsertarPersona");
            if (persona.InsertarPersona(FechaNacimiento)) {
                System.out.println("Persona insertada exitosamente");
                // Obtener el id_persona recién insertado
                int idPersona = persona.traerCodigoDePersonaCrear(cedula);

                if (idPersona > 0) {
                    // Asignar el id_persona al modeloConductor
                    conductor.setId_persona_con(idPersona);

                    if (conductor.InsertarConductor()) {
                        System.out.println("Conductor insertado exitosamente");
                        JOptionPane.showMessageDialog(vistaConduct, "Se guardó exitosamente");
                        cargarTabla();
                        limpiarCampos();
                    } else {
                        System.out.println("Error al insertar conductor");
                        JOptionPane.showMessageDialog(vistaConduct, "No se pudo registrar el conductor");
                    }
                } else {
                    System.out.println("No se pudo obtener el id_persona");
                    JOptionPane.showMessageDialog(vistaConduct, "No se pudo obtener el id_persona");
                }
            } else {
                System.out.println("Error al insertar persona");
                JOptionPane.showMessageDialog(vistaConduct, "No se pudo registrar la persona");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            // Resto del código para manejar la excepción...
        }
    }

    public void limpiarCampos() {
        vistaConduct.getTxtcedula().setText("");
        vistaConduct.getTxtnombre().setText("");
        vistaConduct.getTxtapellido().setText("");
        vistaConduct.getBtnH().setSelected(false);
        vistaConduct.getBtnM().setSelected(false);
        vistaConduct.getTxtcelular().setText("");
        vistaConduct.getTxtcorreo().setText("");
        vistaConduct.getTxtdirecion().setText("");
        vistaConduct.getTxtcontra().setText("");
        vistaConduct.getCbBoxSangre().setSelectedIndex(0);  // Puedes ajustar el índice según tu necesidad
        vistaConduct.getCbboxCiudad().setSelectedIndex(0); // Puedes ajustar el índice según tu necesidad
        vistaConduct.getComboJornada().setSelectedIndex(0); // Puedes ajustar el índice según tu necesidad
        vistaConduct.getComboLicencia().setSelectedIndex(0); // Puedes ajustar el índice según tu necesidad
        vistaConduct.getF_nacimiento().setCalendar(null);
    }

    public void eliminarConductorSeleccionado() {
        int filaSeleccionada = vistaConduct.getTablaConductor().getSelectedRow();

        if (filaSeleccionada == -1) {
            // No se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(vistaConduct, "Seleccione una fila para eliminar");
            return;
        }

        String cedulaConductor = (String) vistaConduct.getTablaConductor().getValueAt(filaSeleccionada, columnaIdConductor);

        // Mostrar un cuadro de diálogo de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(vistaConduct, "¿Está seguro de eliminar este conductor?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            ModeloConductor conductor = new ModeloConductor();

            // Eliminar conductor por cédula
            if (conductor.eliminarConductorPorCedula(cedulaConductor)) {
                JOptionPane.showMessageDialog(vistaConduct, "Conductor eliminado correctamente");
                cargarTabla(); // Actualizar la tabla después de la eliminación
            } else {
                JOptionPane.showMessageDialog(vistaConduct, "Error al eliminar el conductor");
            }
        }
    }

    private void cargarTabla() {
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Cedula");
        tb.addColumn("Nombre");
        tb.addColumn("Apellido");
        tb.addColumn("Fecha Nacimiento");
        tb.addColumn("Sexo");
        tb.addColumn("Correo");
        tb.addColumn("Tipo Sangre");
        tb.addColumn("Celular");
        tb.addColumn("Ciudad");
        tb.addColumn("Direccion");
        tb.addColumn("Jornada");
        tb.addColumn("Tipo de Licencia");
        tb.addColumn("Contraseña");

        List<Conductor> com = modConduct.ListaConductor();
        System.out.println("Tamaño" + com.size());
        com.forEach(p -> {
            Object[] rowData = {
                p.getCedula_usu(),
                p.getNombre_usu(),
                p.getApellido_usu(),
                p.getFechaNacimiento_usu(),
                p.getSexo_usu(),
                p.getCorreo_usu(),
                p.getTipoSangre_usu(),
                p.getCelular_usu(),
                p.getCiudad_usu(),
                p.getDireccion_usu(),
                p.getJornada_con(),
                p.getTipoLicencia_con(),
                p.getContraseña_usu()
            };
            tb.addRow(rowData);
        });

        vistaConduct.getTablaConductor().setModel(tb);
    }

}
