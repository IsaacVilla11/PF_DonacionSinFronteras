package Controlador;

import Modelo.Administrador;
import Modelo.ModeloAdministrador;
import Modelo.ModeloUsuario;
import Vista.crudAdministrador;
import Vista.vistaAdministrador;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IV
 */
public class ControladorCrudAdmin {

    crudAdministrador vistaCrudAdmin;
    ModeloAdministrador modeloAdmin;
    ModeloUsuario modeloUsuario;
    ModeloAdministrador modAdmi = new ModeloAdministrador();

    public ControladorCrudAdmin(crudAdministrador vistaCrudAdmin, ModeloAdministrador modeloAdmin, ModeloUsuario modeloUsuario) {
        this.vistaCrudAdmin = vistaCrudAdmin;
        this.modeloUsuario = modeloUsuario;
        this.modeloAdmin = modeloAdmin;
        vistaCrudAdmin.setVisible(true);
    }

    public ControladorCrudAdmin(crudAdministrador vistaCrudAdmin) {
        this.vistaCrudAdmin = vistaCrudAdmin;
        vistaCrudAdmin.setVisible(true);
    }

    public void iniciarControl() {
        cargarTabla();
        vistaCrudAdmin.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
        vistaCrudAdmin.getBtnGuardar().addActionListener(l -> RegistrarAdministrador());
        vistaCrudAdmin.getBtnCargar().addActionListener(l -> cargarAdmin());
        vistaCrudAdmin.getBtnConsultar().addActionListener(l -> consultarAdmin());
        vistaCrudAdmin.getBtnModi().addActionListener(l -> modificarAdministrador());
        vistaCrudAdmin.getBtnDelete().addActionListener(l -> eliminarAdmin());
    }

    public void regresarModuloAdmin() {
        vistaCrudAdmin.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }

    public void RegistrarAdministrador() {
        ModeloAdministrador admin = new ModeloAdministrador();
        ModeloUsuario per = new ModeloUsuario();

        try {
            String cedula = vistaCrudAdmin.getTxtCedu().getText();

            // Verificar duplicidad de la cédula de la persona
            if (per.verificarDuplicidadCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "La cedula ingresada ya existe en el sistema");
                vistaCrudAdmin.getTxtCedu().setText("");
                return;
            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            per.setCedula_usu(cedula);

            String nombre = vistaCrudAdmin.getTxtNomb().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            per.setNombre_usu(nombre);

            String apellido = vistaCrudAdmin.getTxtApe().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            per.setApellido_usu(apellido);

            String genero;
            if (vistaCrudAdmin.getBtnH().isSelected()) {
                genero = "Hombre";
            } else if (vistaCrudAdmin.getBtnM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Seleccione un género");
                return;
            }
            per.setSexo_usu(genero);

            String celular = vistaCrudAdmin.getTxtCelular().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            per.setCelular_usu(celular);

            String correo = vistaCrudAdmin.getTxtCorreo().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Correo no válido. Ingrese de nuevo");
                return;
            }
            per.setCorreo_usu(correo);

            String tipoSangre = vistaCrudAdmin.getCbBoxSangre().getSelectedItem().toString();
            per.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaCrudAdmin.getCbboxCiudad().getSelectedItem();
            per.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaCrudAdmin.getjDnacimiento().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaCrudAdmin.getjDnacimiento().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaCrudAdmin.getjDnacimiento().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaCrudAdmin.getjDnacimiento() == null) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            per.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaCrudAdmin.getTxtDirecc().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            per.setDireccion_usu(direccion);

            String contraseniaAdmi = vistaCrudAdmin.getTxtPass().getText();
            if (!Validaciones.ValidarContrasena(contraseniaAdmi)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Contraseña no valida. Ingrese de nuevo");
                return;
            }
            per.setContraseña_usu(contraseniaAdmi);

            if (per.InsertarPersona(FechaNacimiento)) {
                // Obtener el id_persona recién insertado
                int idPersona = per.traerCodigoDePersonaCrear(cedula);

                if (idPersona > 0) {
                    // Asignar el id_persona al modeloAdmin
                    admin.setId_persona(idPersona);

                    // Resto del código para validar y asignar los datos al modelo admin...
                    String cargo = vistaCrudAdmin.getCbBoxCargo().getSelectedItem().toString();
                    admin.setCargo_adm(cargo);
                    if (admin.InsertarAdministrador()) {
                        JOptionPane.showMessageDialog(vistaCrudAdmin, "Se guardó exitosamente");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vistaCrudAdmin, "No se pudo registrar el administrador");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaCrudAdmin, "No se pudo obtener el id_persona");
                }
            } else {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "No se pudo registrar la persona");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            // Resto del código para manejar la excepción...
        }
    }

    public void modificarAdministrador() {
        ModeloAdministrador admin = new ModeloAdministrador();
        ModeloUsuario per = new ModeloUsuario();

        try {
            String cedula = vistaCrudAdmin.getTxtCedu().getText();

            // Modificar los datos de la persona
            String nombre = vistaCrudAdmin.getTxtNomb().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            per.setNombre_usu(nombre);

            String apellido = vistaCrudAdmin.getTxtApe().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            per.setApellido_usu(apellido);

            String genero;
            if (vistaCrudAdmin.getBtnH().isSelected()) {
                genero = "Hombre";
            } else if (vistaCrudAdmin.getBtnM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Seleccione un género");
                return;
            }
            per.setSexo_usu(genero);

            String celular = vistaCrudAdmin.getTxtCelular().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            per.setCelular_usu(celular);

            String correo = vistaCrudAdmin.getTxtCorreo().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Correo no válido. Ingrese de nuevo");
                return;
            }
            per.setCorreo_usu(correo);

            String tipoSangre = vistaCrudAdmin.getCbBoxSangre().getSelectedItem().toString();
            per.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaCrudAdmin.getCbboxCiudad().getSelectedItem();
            per.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaCrudAdmin.getjDnacimiento().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaCrudAdmin.getjDnacimiento().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaCrudAdmin.getjDnacimiento().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaCrudAdmin.getjDnacimiento() == null) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            per.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaCrudAdmin.getTxtDirecc().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            per.setDireccion_usu(direccion);

            String contraseniaAdmi = vistaCrudAdmin.getTxtPass().getText();
            if (!Validaciones.ValidarContrasena(contraseniaAdmi)) {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "Contraseña no valida. Ingrese de nuevo");
                return;
            }
            per.setContraseña_usu(contraseniaAdmi);
            if (per.modificarPersona(FechaNacimiento)) {
                // Obtener el id_persona recién insertado
                int idPersona = per.traerCodigoDePersonaCrear(cedula);

                if (idPersona > 0) {
                    // Asignar el id_persona al modeloAdmin
                    admin.setId_persona(idPersona);

                    // Resto del código para validar y asignar los datos al modelo admin...
                    String cargo = vistaCrudAdmin.getCbBoxCargo().getSelectedItem().toString();
                    admin.setCargo_adm(cargo);
                    if (admin.modificarAdministrador()) {
                        JOptionPane.showMessageDialog(vistaCrudAdmin, "Se modificó exitosamente");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vistaCrudAdmin, "No se pudo modifcar el administrador");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaCrudAdmin, "No se pudo obtener el id_persona");
                }
            } else {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "No se pudo modificar la persona");
            }

        } catch (Exception e) {
            // Manejo de la excepción
            // Resto del código para manejar la excepción...
        }
    }

    private void eliminarAdmin() {
        String cedula = vistaCrudAdmin.getTxtCedu().getText();

        if (cedula != null && !cedula.isEmpty()) {
            int response = JOptionPane.showConfirmDialog(vistaCrudAdmin, "¿Seguro que desea eliminar al administrador con cédula " + cedula + "?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    // Llamar al método para eliminar el administrador
                    modAdmi.eliminar_administrador(cedula);
                    JOptionPane.showMessageDialog(vistaCrudAdmin, "Administrador eliminado exitosamente");
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

    // metodo para consultar si existe un administrador por cedula
    private void consultarAdmin() {
        String cedula = vistaCrudAdmin.getTxtCedu().getText();
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
        tb.addColumn("Cargo");
        tb.addColumn("Contraseña");

        Administrador admin = null;
        try {
            admin = modAdmi.buscarAdministrador(cedula); // Llama al método para buscar el administrador por la cédula

        } catch (SQLException ex) {
            Logger.getLogger(ControladorCrudAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (admin != null) {
            JOptionPane.showMessageDialog(vistaCrudAdmin, "Si existe ese administrador");
            Object[] rowData = {
                admin.getCedula_usu(),
                admin.getNombre_usu(),
                admin.getApellido_usu(),
                admin.getFechaNacimiento_usu(),
                admin.getSexo_usu(),
                admin.getCorreo_usu(),
                admin.getTipoSangre_usu(),
                admin.getCelular_usu(),
                admin.getCiudad_usu(),
                admin.getDireccion_usu(),
                admin.getCargo_adm(),
                admin.getContraseña_usu()
            };
            tb.addRow(rowData);
        } else {
            JOptionPane.showMessageDialog(vistaCrudAdmin, "No se encontró el administrador con la cédula especificada");
        }

        vistaCrudAdmin.getTablaAdmi().setModel(tb);
    }

    //Metodo para buscar administrador y llamar al metodo para llenar los campos
    private void cargarAdmin() {
        String cedula = vistaCrudAdmin.getTxtCedu().getText();

        try {
            // Buscar el administrador en la base de datos
            Administrador admin = modAdmi.buscarAdministrador(cedula);

            // Verificar si se encontró el administrador
            if (admin != null) {
                // Cargar los datos del administrador en el formulario
                cargarDatosFormulario(admin);
                vistaCrudAdmin.getTxtCedu().setEditable(false);
            } else {
                JOptionPane.showMessageDialog(vistaCrudAdmin, "No se encontró el administrador");
                vistaCrudAdmin.getTxtCedu().setEditable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // metod para llenar los campos con los datos segun cedula
    private void cargarDatosFormulario(Administrador admin) {

        vistaCrudAdmin.getTxtCedu().setText(admin.getCedula_usu());
        vistaCrudAdmin.getTxtNomb().setText(admin.getNombre_usu());
        vistaCrudAdmin.getTxtApe().setText(admin.getApellido_usu());

        if ("Hombre".equals(admin.getSexo_usu())) {
            vistaCrudAdmin.getBtnH().setSelected(true);
        } else if ("Mujer".equals(admin.getSexo_usu())) {
            vistaCrudAdmin.getBtnM().setSelected(true);
        }

        vistaCrudAdmin.getTxtCelular().setText(admin.getCelular_usu());
        vistaCrudAdmin.getTxtCorreo().setText(admin.getCorreo_usu());
        vistaCrudAdmin.getCbBoxSangre().setSelectedItem(admin.getTipoSangre_usu());
        vistaCrudAdmin.getCbboxCiudad().setSelectedItem(admin.getCiudad_usu());

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatofecha.parse(admin.getFechaNacimiento_usu());
        } catch (ParseException ex) {
            Logger.getLogger(vistaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        vistaCrudAdmin.getjDnacimiento().setDate(fecha);

        vistaCrudAdmin.getTxtDirecc().setText(admin.getDireccion_usu());
        vistaCrudAdmin.getCbBoxCargo().setSelectedItem(admin.getCargo_adm());
        vistaCrudAdmin.getTxtPass().setText(admin.getContraseña_usu());
    }

    // metodo para cargar el jtable con todos los registros
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
        tb.addColumn("Cargo");
        tb.addColumn("Contraseña");

        List<Administrador> com = modAdmi.ListaAdministrador();
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
                p.getCargo_adm(),
                p.getContraseña_usu()
            };
            tb.addRow(rowData);
        });

        vistaCrudAdmin.getTablaAdmi().setModel(tb);
    }

}
