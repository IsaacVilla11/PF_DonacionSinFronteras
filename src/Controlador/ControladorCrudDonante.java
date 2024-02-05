/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administrador;
import Modelo.Donacion;
import Modelo.Donante;
import Modelo.ModeloDonante;
import Modelo.ModeloUsuario;
import Vista.CRUD_Donante;
import Vista.vistaAdministrador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class ControladorCrudDonante {

    CRUD_Donante vistaCrudDona;
    ModeloDonante modDonante = new ModeloDonante();

    public ControladorCrudDonante(CRUD_Donante vistaCrudDona) {
        this.vistaCrudDona = vistaCrudDona;
        vistaCrudDona.setVisible(true);
    }

    public void iniciarControl() {
        cargarTabla();
        vistaCrudDona.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
        vistaCrudDona.getBtnCrear().addActionListener(l -> registrarDonante());
        vistaCrudDona.getBtnModificar().addActionListener(l -> modificarDonante());
        vistaCrudDona.getBtnCargar().addActionListener(l-> cargarDonant());
        vistaCrudDona.getBtnConsultar().addActionListener(l-> consultarDonante());
        vistaCrudDona.getBtnEliminar().addActionListener(l-> eliminarDonante());
       
    }

    public void registrarDonante() {
        //Crear Codigo
        ModeloDonante perDona = new ModeloDonante();
        ModeloUsuario per = new ModeloUsuario();

        try {
            String cedula = vistaCrudDona.getTxtCedu().getText();

            // Verificar duplicidad de la cédula de la persona
            if (per.verificarDuplicidadCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "La cedula ingresada ya existe en el sistema");
                vistaCrudDona.getTxtCedu().setText("");
                return;
            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            per.setCedula_usu(cedula);

            String nombre = vistaCrudDona.getTxtNomb().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            per.setNombre_usu(nombre);

            String apellido = vistaCrudDona.getTxtApe().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            per.setApellido_usu(apellido);

            String genero;
            if (vistaCrudDona.getBtnH().isSelected()) {
                genero = "Hombre";
            } else if (vistaCrudDona.getBtnM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaCrudDona, "Seleccione un género");
                return;
            }
            per.setSexo_usu(genero);

            String celular = vistaCrudDona.getTxtCelular().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            per.setCelular_usu(celular);

            String correo = vistaCrudDona.getTxtCorreo().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Correo no válido. Ingrese de nuevo");
                return;
            }
            per.setCorreo_usu(correo);

            String tipoSangre = vistaCrudDona.getCbBoxSangre().getSelectedItem().toString();
            per.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaCrudDona.getCbboxCiudad().getSelectedItem();
            per.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaCrudDona.getjDnacimiento().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaCrudDona.getjDnacimiento().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaCrudDona.getjDnacimiento().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaCrudDona.getjDnacimiento() == null) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            per.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaCrudDona.getTxtDirecc().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            per.setDireccion_usu(direccion);

            String contraseniaDonant = vistaCrudDona.getTxtPass().getText();
            if (!Validaciones.ValidarContrasena(contraseniaDonant)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Contraseña no valida. Ingrese de nuevo");
                return;
            }
            per.setContraseña_usu(contraseniaDonant);

            if (per.InsertarPersona(FechaNacimiento)) {
                // Obtener el id_persona recién insertado
                int idPersona = per.traerCodigoDePersonaCrear(cedula);

                if (idPersona > 0) {
                    // Asignar el id_persona al modeloDonante
                    perDona.setId_persona(idPersona);

                    // Resto del código para validar y asignar los datos al modelo donante...
                    String proyecto = vistaCrudDona.getTxtproyecto().getText();
                    if (!Validaciones.ValidarNomApe(proyecto)) {
                        JOptionPane.showMessageDialog(vistaCrudDona, "Nombre Del Proyecto incorrecto. Ingrese de nuevo");
                        return;
                    }
                    perDona.setProyecto_dont(proyecto);

                    String entidad = vistaCrudDona.getTxtentidad().getText();
                    if (!Validaciones.ValidarNomApe(entidad)) {
                        JOptionPane.showMessageDialog(vistaCrudDona, "Nombre De Entidad incorrecto. Ingrese de nuevo");
                        return;
                    }
                    perDona.setEntidad_dont(entidad);

                    String motivo = vistaCrudDona.getTxtMotivo().getText();
                    if (!Validaciones.validarLetras(motivo)) {
                        JOptionPane.showMessageDialog(vistaCrudDona, "Motivo incorrecto. Ingrese de nuevo");
                        return;
                    }
                    perDona.setMotivo_dont(motivo);

                    if (perDona.insertarDonante()) {
                        JOptionPane.showMessageDialog(vistaCrudDona, "Se guardó exitosamente");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vistaCrudDona, "No se pudo registrar el donante");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaCrudDona, "No se pudo obtener el id_persona");
                }
            } else {
                JOptionPane.showMessageDialog(vistaCrudDona, "No se pudo registrar la persona");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            System.out.println(e);
            // Resto del código para manejar la excepción...
        }
    }

    public void modificarDonante() {
        ModeloDonante donanteActualizado = new ModeloDonante();
      

        try {
            String cedula = vistaCrudDona.getTxtCedu().getText();
            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setCedula_usu(cedula);
            
            String nombre = vistaCrudDona.getTxtNomb().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setNombre_usu(nombre);
            String apellido = vistaCrudDona.getTxtApe().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setApellido_usu(apellido);

            String genero;
            if (vistaCrudDona.getBtnH().isSelected()) {
                genero = "Hombre";
            } else if (vistaCrudDona.getBtnM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaCrudDona, "Seleccione un género");
                return;
            }
            donanteActualizado.setSexo_usu(genero);
            
            String celular = vistaCrudDona.getTxtCelular().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setCelular_usu(celular);

            String correo = vistaCrudDona.getTxtCorreo().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Correo no válido. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setCorreo_usu(correo);

            String tipoSangre = vistaCrudDona.getCbBoxSangre().getSelectedItem().toString();
            donanteActualizado.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaCrudDona.getCbboxCiudad().getSelectedItem();
            donanteActualizado.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaCrudDona.getjDnacimiento().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaCrudDona.getjDnacimiento().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaCrudDona.getjDnacimiento().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaCrudDona.getjDnacimiento() == null) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            donanteActualizado.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaCrudDona.getTxtDirecc().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setDireccion_usu(direccion);

            String contraseniaDonant = vistaCrudDona.getTxtPass().getText();
            if (!Validaciones.ValidarContrasena(contraseniaDonant)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Contraseña no valida. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setContraseña_usu(contraseniaDonant);

            // Resto del código para validar y asignar los datos al modelo donante...
            String proyecto = vistaCrudDona.getTxtproyecto().getText();
            if (!Validaciones.ValidarNomApe(proyecto)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Nombre Del Proyecto incorrecto. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setProyecto_dont(proyecto);

            String entidad = vistaCrudDona.getTxtentidad().getText();
            if (!Validaciones.ValidarNomApe(entidad)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Nombre De Entidad incorrecto. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setEntidad_dont(entidad);

            String motivo = vistaCrudDona.getTxtMotivo().getText();
            if (!Validaciones.validarLetras(motivo)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Motivo incorrecto. Ingrese de nuevo");
                return;
            }
            donanteActualizado.setMotivo_dont(motivo);
            // Lógica para modificar eldonante
            if (modDonante.actualizarDonante(donanteActualizado)) {
                JOptionPane.showMessageDialog(vistaCrudDona, "Donante modificado satisfactoriamente");
                cargarTabla(); // Método para actualizar la tabla después de la modificación
                vistaCrudDona.getBtnCrear().setEnabled(true);
                vistaCrudDona.getTxtCedu().setEnabled(true);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vistaCrudDona, "Error al modificar el Donante");
            }
            } catch (Exception e) {
                System.out.println(e);
        }

    }
     public void limpiarCampos() {
        vistaCrudDona.getTxtCedu().setText("");
        vistaCrudDona.getTxtNomb().setText("");
        vistaCrudDona.getTxtApe().setText("");
        vistaCrudDona.getBtnH().setSelected(false);
        vistaCrudDona.getBtnM().setSelected(false);
        vistaCrudDona.getTxtCelular().setText("");
        vistaCrudDona.getTxtCorreo().setText("");
        vistaCrudDona.getTxtDirecc().setText("");
        vistaCrudDona.getTxtPass().setText("");
        vistaCrudDona.getTxtMotivo().setText("");
        vistaCrudDona.getTxtentidad().setText("");
        vistaCrudDona.getTxtproyecto().setText("");
        vistaCrudDona.getCbBoxSangre().setSelectedIndex(0);  // Puedes ajustar el índice según tu necesidad
        vistaCrudDona.getCbboxCiudad().setSelectedIndex(0); // Puedes ajustar el índice según tu necesidad
        vistaCrudDona.getjDnacimiento().setCalendar(null);
    }
     //Metodo para buscar dn¿nante y llamar al metodo para llenar los campos
    private void cargarDonant() {
        String cedula = vistaCrudDona.getTxtCedu().getText();

        try {
            // Buscar el donate en la base de datos
            Donante dona = modDonante.buscarDonante(cedula);

            // Verificar si se encontró el donate
            if (dona != null) {
                // Cargar los datos del donante en el formulario
                cargarDatosFormulario(dona);
                vistaCrudDona.getTxtCedu().setEditable(false);
            } else {
                JOptionPane.showMessageDialog(vistaCrudDona, "No se encontró el donante en la base");
                vistaCrudDona.getTxtCedu().setEditable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // metod para llenar los campos con los datos segun cedula
    private void cargarDatosFormulario(Donante dona) {

        vistaCrudDona.getTxtCedu().setText(dona.getCedula_usu());
        vistaCrudDona.getTxtNomb().setText(dona.getNombre_usu());
        vistaCrudDona.getTxtApe().setText(dona.getApellido_usu());

        if ("Hombre".equals(dona.getSexo_usu())) {
            vistaCrudDona.getBtnH().setSelected(true);
        } else if ("Mujer".equals(dona.getSexo_usu())) {
            vistaCrudDona.getBtnM().setSelected(true);
        }

        vistaCrudDona.getTxtCelular().setText(dona.getCelular_usu());
        vistaCrudDona.getTxtCorreo().setText(dona.getCorreo_usu());
        vistaCrudDona.getCbBoxSangre().setSelectedItem(dona.getTipoSangre_usu());
        vistaCrudDona.getCbboxCiudad().setSelectedItem(dona.getCiudad_usu());

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatofecha.parse(dona.getFechaNacimiento_usu());
        } catch (ParseException ex) {
            Logger.getLogger(vistaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        vistaCrudDona.getjDnacimiento().setDate(fecha);

        vistaCrudDona.getTxtDirecc().setText(dona.getDireccion_usu());
        vistaCrudDona.getTxtproyecto().setText(dona.getProyecto_dont());
        vistaCrudDona.getTxtentidad().setText(dona.getEntidad_dont());
        vistaCrudDona.getTxtMotivo().setText(dona.getMotivo_dont());
        vistaCrudDona.getTxtPass().setText(dona.getContraseña_usu());
    }
    
    // metodo para consultar si existe un administrador por cedula
    private void consultarDonante() {
        String cedula = vistaCrudDona.getTxtCedu().getText();
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
        tb.addColumn("Proyecto");
        tb.addColumn("Entidad");
        tb.addColumn("Motivo");
        tb.addColumn("Contraseña");

        Donante dona = null;
        try {
            dona = modDonante.buscarDonante(cedula); // Llama al método para buscar el donate por la cédula

        } catch (SQLException ex) {
            Logger.getLogger(ControladorCrudAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dona != null) {
            JOptionPane.showMessageDialog(vistaCrudDona, "Si existe ese Donante");
            Object[] rowData = {
                dona.getCedula_usu(),
                dona.getNombre_usu(),
                dona.getApellido_usu(),
                dona.getFechaNacimiento_usu(),
                dona.getSexo_usu(),
                dona.getCorreo_usu(),
                dona.getTipoSangre_usu(),
                dona.getCelular_usu(),
                dona.getCiudad_usu(),
                dona.getDireccion_usu(),
                dona.getProyecto_dont(),
                dona.getEntidad_dont(),
                dona.getMotivo_dont(),
                dona.getContraseña_usu()
            };
            tb.addRow(rowData);
        } else {
            JOptionPane.showMessageDialog(vistaCrudDona, "No se encontró el donante con la cédula especificada");
        }

        vistaCrudDona.getTablaDonante().setModel(tb);
    }

    // metodo para eliminar
    private void eliminarDonante() {
        String cedula = vistaCrudDona.getTxtCedu().getText();

        if (cedula != null && !cedula.isEmpty()) {
            int response = JOptionPane.showConfirmDialog(vistaCrudDona, "¿Seguro que desea eliminar al Donante con cédula " + cedula + "?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    // Llamar al método para eliminar el donante
                    modDonante.eliminar_Donante(cedula);
                    JOptionPane.showMessageDialog(vistaCrudDona, "Donante eliminado exitosamente");
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
    // metodo para cargar el jtable con todos los registros
    private void cargarTabla() {
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("ID");
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
        tb.addColumn("Proyecto");
        tb.addColumn("Entidad");
        tb.addColumn("Motivo");
        tb.addColumn("Contraseña");

        List<Donante> don = modDonante.ListaDonante();
        System.out.println("Tamaño" + don.size());
        don.forEach(p -> {
            Object[] rowData = {
                p.getId_donante(),
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
                p.getProyecto_dont(),
                p.getEntidad_dont(),
                p.getMotivo_dont(),
                p.getContraseña_usu()
            };
            tb.addRow(rowData);
        });

        vistaCrudDona.getTablaDonante().setModel(tb);
    }

    public void regresarModuloAdmin() {
        vistaCrudDona.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }
}
