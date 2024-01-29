package Controlador;

import Modelo.ModeloSolicitante;
import Modelo.ModeloUsuario;
import Modelo.Solicitante;
import Vista.CRUD_Solicitante;
import Vista.vistaAdministrador;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorCrudSolicitante {
    CRUD_Solicitante vistaCrudSolicitante;
    ModeloSolicitante modeloSolicitante;
    ModeloUsuario modeloUsuario;
    ModeloSolicitante modSolictnt = new ModeloSolicitante();

    public ControladorCrudSolicitante(CRUD_Solicitante vistaCrudSolicitante, ModeloSolicitante modeloSolicitante, ModeloUsuario modeloUsuario) {
        this.vistaCrudSolicitante = vistaCrudSolicitante;
        this.modeloSolicitante = modeloSolicitante;
        this.modeloUsuario = modeloUsuario;
        vistaCrudSolicitante.setVisible(true);
    }

    public ControladorCrudSolicitante(CRUD_Solicitante vistaCrudSolicitante) {
        this.vistaCrudSolicitante = vistaCrudSolicitante;
        vistaCrudSolicitante.setVisible(true);
    }
    
    public void iniciarControl() {
        cargarTabla();
        vistaCrudSolicitante.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
        vistaCrudSolicitante.getBtnCrear().addActionListener(l -> RegistrarSolicitante());
        vistaCrudSolicitante.getBtnCargar().addActionListener(l -> cargarSolic());
        vistaCrudSolicitante.getBtnConsultar().addActionListener(l -> consultarSolictnt());
        //vistaCrudSolicitante.getBtnModificar().addActionListener(l -> modificarAdministrador());
        vistaCrudSolicitante.getBtnEliminar().addActionListener(l -> eliminarSolictnt());
    }
    
    public void regresarModuloAdmin() {
        vistaCrudSolicitante.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }
    
    public void RegistrarSolicitante() {
        ModeloSolicitante solictnt = new ModeloSolicitante();
        ModeloUsuario per = new ModeloUsuario();

        try {
            String cedula = vistaCrudSolicitante.getTxtcedula_soli().getText();

            // Verificar duplicidad de la cédula de la persona
            if (per.verificarDuplicidadCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "La cedula ingresada ya existe en el sistema");
                vistaCrudSolicitante.getTxtcedula_soli().setText("");
                return;
            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            per.setCedula_usu(cedula);

            String nombre = vistaCrudSolicitante.getTxtnombre_soli().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            per.setNombre_usu(nombre);

            String apellido = vistaCrudSolicitante.getTxtapellido_soli().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            per.setApellido_usu(apellido);

            String genero;
            if (vistaCrudSolicitante.getRbH().isSelected()) {
                genero = "Hombre";
            } else if (vistaCrudSolicitante.getRbM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Seleccione un género");
                return;
            }
            per.setSexo_usu(genero);

            String celular = vistaCrudSolicitante.getTxtcelular_soli().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            per.setCelular_usu(celular);

            String correo = vistaCrudSolicitante.getTxtcorreo_soli().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Correo no válido. Ingrese de nuevo");
                return;
            }
            per.setCorreo_usu(correo);

            String tipoSangre = vistaCrudSolicitante.getCbBoxSangre().getSelectedItem().toString();
            per.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaCrudSolicitante.getCboxciudad_soli().getSelectedItem();
            per.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaCrudSolicitante.getF_nac_soli().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaCrudSolicitante.getF_nac_soli().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaCrudSolicitante.getF_nac_soli().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaCrudSolicitante.getF_nac_soli() == null) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            per.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaCrudSolicitante.getTxtdireccion().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            per.setDireccion_usu(direccion);

            String contraseniaSolctnt = vistaCrudSolicitante.getTxtContra_soli().getText();
            if (!Validaciones.ValidarContrasena(contraseniaSolctnt)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Contraseña no valida. Ingrese de nuevo");
                return;
            }
            per.setContraseña_usu(contraseniaSolctnt);

            if (per.InsertarPersona(FechaNacimiento)) {
                // Obtener el id_persona recién insertado
                int idPersona = per.traerCodigoDePersonaCrear(cedula);

                if (idPersona > 0) {
                    // Asignar el id_persona al modeloSolicitante
                    solictnt.setId_persona(idPersona);

                    // Resto del código para validar y asignar los datos al modelo admin...
//                    String cargo = vistaCrudSolicitante.getCbBoxCargo().getSelectedItem().toString();
//                    solictnt.setCargo_adm(cargo);
                    if (solictnt.InsertarSolicitante()) {
                        JOptionPane.showMessageDialog(vistaCrudSolicitante, "Se guardó exitosamente");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se pudo registrar el solicitante");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se pudo obtener el id_persona");
                }
            } else {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se pudo registrar la persona");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            // Resto del código para manejar la excepción...
        }
    }
    
//    public void ModificarSolicitante() {
//        ModeloSolicitante solictnt = new ModeloSolicitante();
//        ModeloUsuario per = new ModeloUsuario();
//
//        try {
//            String cedula = vistaCrudSolicitante.getTxtcedula_soli().getText();
//
//            String nombre = vistaCrudSolicitante.getTxtnombre_soli().getText();
//            if (!Validaciones.ValidarNomApe(nombre)) {
//                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Nombre incorrecto. Ingrese de nuevo");
//                return;
//            }
//            per.setNombre_usu(nombre);
//
//            String apellido = vistaCrudSolicitante.getTxtapellido_soli().getText();
//            if (!Validaciones.ValidarNomApe(apellido)) {
//                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Apellido incorrecto. Ingrese de nuevo");
//                return;
//            }
//            per.setApellido_usu(apellido);
//
//            String genero;
//            if (vistaCrudSolicitante.getRbH().isSelected()) {
//                genero = "Hombre";
//            } else if (vistaCrudSolicitante.getRbM().isSelected()) {
//                genero = "Mujer";
//            } else {
//                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Seleccione un género");
//                return;
//            }
//            per.setSexo_usu(genero);
//
//            String celular = vistaCrudSolicitante.getTxtcelular_soli().getText();
//            if (!Validaciones.ValidarCedula(celular)) {
//                JOptionPane.showMessageDialog(vistaCrudSolicitante, "# Celular no válido. Ingrese de nuevo");
//                return;
//            }
//            per.setCelular_usu(celular);
//
//            String correo = vistaCrudSolicitante.getTxtcorreo_soli().getText();
//            if (!Validaciones.ValidarCorreo(correo)) {
//                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Correo no válido. Ingrese de nuevo");
//                return;
//            }
//            per.setCorreo_usu(correo);
//
//            String tipoSangre = vistaCrudSolicitante.getCbBoxSangre().getSelectedItem().toString();
//            per.setTipoSangre_usu(tipoSangre);
//
//            String ciudad = (String) vistaCrudSolicitante.getCboxciudad_soli().getSelectedItem();
//            per.setCiudad_usu(ciudad);
//
//            // Obtener fecha de nacimiento del JCalendar
//            String dia = Integer.toString(vistaCrudSolicitante.getF_nac_soli().getCalendar().get(Calendar.DAY_OF_MONTH));
//            String mes = Integer.toString(vistaCrudSolicitante.getF_nac_soli().getCalendar().get(Calendar.MONTH) + 1);
//            String año = Integer.toString(vistaCrudSolicitante.getF_nac_soli().getCalendar().get(Calendar.YEAR));
//            String FechaNacimiento = (dia + "-" + mes + "-" + año);
//
//            if (vistaCrudSolicitante.getF_nac_soli() == null) {
//                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Seleccione una fecha de nacimiento");
//                return; // O realiza alguna otra acción apropiada para manejar el error
//            }
//            per.setFechaNacimiento_usu(FechaNacimiento);
//
//            String direccion = vistaCrudSolicitante.getTxtdireccion().getText();
//            if (!Validaciones.ValidarNomApe(direccion)) {
//                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Dirección incorrecta. Ingrese de nuevo");
//                return;
//            }
//            per.setDireccion_usu(direccion);
//
//            String contraseniaSolctnt = vistaCrudSolicitante.getTxtContra_soli().getText();
//            if (!Validaciones.ValidarContrasena(contraseniaSolctnt)) {
//                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Contraseña no valida. Ingrese de nuevo");
//                return;
//            }
//            per.setContraseña_usu(contraseniaSolctnt);
//
//            if (per.InsertarPersona(FechaNacimiento)) {
//                // Obtener el id_persona recién insertado
//                int idPersona = per.traerCodigoDePersonaCrear(cedula);
//
//                if (idPersona > 0) {
//                    // Asignar el id_persona al modeloSolicitante
//                    solictnt.setId_persona(idPersona);
//
//                    if (solictnt.InsertarSolicitante()) {
//                        JOptionPane.showMessageDialog(vistaCrudSolicitante, "Se modifico exitosamente");
//                        cargarTabla();
//                    } else {
//                        JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se pudo modifico el solicitante");
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se pudo obtener el id_persona");
//                }
//            } else {
////                JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se pudo modifico la persona");
//            }
//        } catch (Exception e) {
//            // Manejo de la excepción
//            // Resto del código para manejar la excepción...
//        }
//    }
    
    private void eliminarSolictnt() {
        String cedula = vistaCrudSolicitante.getTxtcedula_soli().getText();

        if (cedula != null && !cedula.isEmpty()) {
            int response = JOptionPane.showConfirmDialog(vistaCrudSolicitante, "¿Seguro que desea eliminar al solicitante con cédula " + cedula + "?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    // Llamar al método para eliminar el administrador
                    modSolictnt.eliminar_solicitante(cedula);
                    JOptionPane.showMessageDialog(vistaCrudSolicitante, "Solicitante eliminado exitosamente");
                    cargarTabla(); // Actualizar el JTable después de la eliminación
                } catch (Exception ex) {
                    // Manejo de excepciones
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al intentar eliminar el registro: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La cédula ingresada no es válida");
        }

    }
    
    private void cargarTabla() {
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Cedula");
        tb.addColumn("Nombre");
        tb.addColumn("Apellido");
        tb.addColumn("Fecha Nacimiento");
        tb.addColumn("Correo");
        tb.addColumn("Ciudad");
        tb.addColumn("Direccion");
        tb.addColumn("Tipo Sangre");
        tb.addColumn("Sexo");
        tb.addColumn("Celular");
        tb.addColumn("Contraseña");

        List<Solicitante> com = modSolictnt.ListaSolicitante();
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
                p.getContraseña_usu()
            };
            tb.addRow(rowData);
        });

        vistaCrudSolicitante.getTabla_Solicitante().setModel(tb);
    } 
    
    // metod para llenar los campos con los datos segun cedula
    private void cargarDatosFormulario(Solicitante solictnt) {

        vistaCrudSolicitante.getTxtcedula_soli().setText(solictnt.getCedula_usu());
        vistaCrudSolicitante.getTxtnombre_soli().setText(solictnt.getNombre_usu());
        vistaCrudSolicitante.getTxtapellido_soli().setText(solictnt.getApellido_usu());

        if ("Hombre".equals(solictnt.getSexo_usu())) {
            vistaCrudSolicitante.getRbH().setSelected(true);
        } else if ("Mujer".equals(solictnt.getSexo_usu())) {
            vistaCrudSolicitante.getRbM().setSelected(true);
        }

        vistaCrudSolicitante.getTxtcelular_soli().setText(solictnt.getCelular_usu());
        vistaCrudSolicitante.getTxtcorreo_soli().setText(solictnt.getCorreo_usu());
        vistaCrudSolicitante.getCbBoxSangre().setSelectedItem(solictnt.getTipoSangre_usu());
        vistaCrudSolicitante.getCboxciudad_soli().setSelectedItem(solictnt.getCiudad_usu());

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatofecha.parse(solictnt.getFechaNacimiento_usu());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(vistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        vistaCrudSolicitante.getF_nac_soli().setDate(fecha);

        vistaCrudSolicitante.getTxtdireccion().setText(solictnt.getDireccion_usu());
        vistaCrudSolicitante.getTxtContra_soli().setText(solictnt.getContraseña_usu());
    }
    
    //Metodo para buscar solicitante y llamar al metodo para llenar los campos
    private void cargarSolic() {
        String cedula = vistaCrudSolicitante.getTxtcedula_soli().getText();

        try {
            // Buscar el solicitante en la base de datos
            Solicitante solicit = modSolictnt.buscarSolicitante(cedula);

            // Verificar si se encontró el solicitante
            if (solicit != null) {
                // Cargar los datos del solicitante en el formulario
                cargarDatosFormulario(solicit);
                vistaCrudSolicitante.getTxtcedula_soli().setEditable(false);
            } else {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se encontró el solicitante");
                vistaCrudSolicitante.getTxtcedula_soli().setEditable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // metodo para consultar si existe un Solicitante por cedula
    private void consultarSolictnt() {
        String cedula = vistaCrudSolicitante.getTxtcedula_soli().getText();
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Cedula");
        tb.addColumn("Nombre");
        tb.addColumn("Apellido");
        tb.addColumn("Fecha Nacimiento");
        tb.addColumn("Correo");
        tb.addColumn("Ciudad");
        tb.addColumn("Direccion");
        tb.addColumn("Tipo Sangre");
        tb.addColumn("Sexo");
        tb.addColumn("Celular");
        tb.addColumn("Contraseña");

        Solicitante solic = null;
        try {
            solic = modSolictnt.buscarSolicitante(cedula); // Llama al método para buscar el solicitante por la cédula

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ControladorCrudSolicitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (solic != null) {
            JOptionPane.showMessageDialog(vistaCrudSolicitante, "Si existe ese Solicitante");
            Object[] rowData = {
                solic.getCedula_usu(),
                solic.getNombre_usu(),
                solic.getApellido_usu(),
                solic.getFechaNacimiento_usu(),
                solic.getSexo_usu(),
                solic.getCorreo_usu(),
                solic.getTipoSangre_usu(),
                solic.getCelular_usu(),
                solic.getCiudad_usu(),
                solic.getDireccion_usu(),
                solic.getContraseña_usu()
            };
            tb.addRow(rowData);
        } else {
            JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se encontró el Solicitante con la cédula especificada");
        }

        vistaCrudSolicitante.getTabla_Solicitante().setModel(tb);
    }
}
