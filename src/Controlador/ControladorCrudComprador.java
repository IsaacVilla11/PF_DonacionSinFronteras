package Controlador;


import Modelo.Administrador;
import Modelo.Comprador;

import Modelo.ModeloComprador;
import Modelo.ModeloUsuario;
import Vista.CRUD_Comprador;
import Vista.CRUD_Comprador;
import Vista.vistaAdministrador;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IV
 */
public class ControladorCrudComprador {
    
    CRUD_Comprador vistaCrudCompra;
     ModeloComprador modCompra = new ModeloComprador();
    
    public ControladorCrudComprador(CRUD_Comprador vistaCrudCompra) {
        this.vistaCrudCompra = vistaCrudCompra;
        vistaCrudCompra.setVisible(true);
    }
    
    public void iniciarControl() {
        cargarTabla();
        vistaCrudCompra.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
        vistaCrudCompra.getBtnGuardar().addActionListener(l->RegistrarComprador());
        vistaCrudCompra.getBtnConsultar().addActionListener(l-> consultarComprador());
        vistaCrudCompra.getBtnDelete().addActionListener(l-> eliminarComprador());
    }
    
    public void regresarModuloAdmin() {
        vistaCrudCompra.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }
    
    
    public void RegistrarComprador() {
        ModeloComprador compra = new ModeloComprador();
        ModeloUsuario per = new ModeloUsuario();

        try {
            String cedula = vistaCrudCompra.getTxtCedu().getText();

            // Verificar duplicidad de la cédula de la persona
            if (per.verificarDuplicidadCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudCompra, "La cedula ingresada ya existe en el sistema");
                vistaCrudCompra.getTxtCedu().setText("");
                return;
            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudCompra, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            per.setCedula_usu(cedula);

            String nombre = vistaCrudCompra.getTxtNomb().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaCrudCompra, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            per.setNombre_usu(nombre);

            String apellido = vistaCrudCompra.getTxtApe().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaCrudCompra, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            per.setApellido_usu(apellido);

            String genero;
            if (vistaCrudCompra.getBtnH().isSelected()) {
                genero = "Hombre";
            } else if (vistaCrudCompra.getBtnM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaCrudCompra, "Seleccione un género");
                return;
            }
            per.setSexo_usu(genero);

            String celular = vistaCrudCompra.getTxtCelular().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaCrudCompra, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            per.setCelular_usu(celular);

            String correo = vistaCrudCompra.getTxtCorreo().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaCrudCompra, "Correo no válido. Ingrese de nuevo");
                return;
            }
            per.setCorreo_usu(correo);

            String tipoSangre = vistaCrudCompra.getCbBoxSangre().getSelectedItem().toString();
            per.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaCrudCompra.getCbboxCiudad().getSelectedItem();
            per.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaCrudCompra.getjDnacimiento().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaCrudCompra.getjDnacimiento().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaCrudCompra.getjDnacimiento().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaCrudCompra.getjDnacimiento() == null) {
                JOptionPane.showMessageDialog(vistaCrudCompra, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            per.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaCrudCompra.getTxtDirecc().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaCrudCompra, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            per.setDireccion_usu(direccion);

            String contraseniaAdmi = vistaCrudCompra.getTxtPass().getText();
            if (!Validaciones.ValidarContrasena(contraseniaAdmi)) {
                JOptionPane.showMessageDialog(vistaCrudCompra, "Contraseña no valida. Ingrese de nuevo");
                return;
            }
            per.setContraseña_usu(contraseniaAdmi);

            if (per.InsertarPersona(FechaNacimiento)) {
                // Obtener el id_persona recién insertado
                int idPersona = per.traerCodigoDePersonaCrear(cedula);

                if (idPersona > 0) {
                    // Asignar el id_persona al modeloAdmin
                    compra.setId_persona(idPersona);

                    // Resto del código para validar y asignar los datos al modelo admin...
                    String pagos = vistaCrudCompra.getCbboxMetPagos().getSelectedItem().toString();
                    compra.setMetodoPago_com(pagos);
                    String estadoCivil = vistaCrudCompra.getCbboxEstCivil().getSelectedItem().toString();
                    compra.setEstadoCivil_com(estadoCivil);
                    
                    if (compra.InsertarComprador()) {
                        JOptionPane.showMessageDialog(vistaCrudCompra, "Se guardó exitosamente");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vistaCrudCompra, "No se pudo registrar el comprador");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaCrudCompra, "No se pudo obtener el id_persona");
                }
            } else {
                JOptionPane.showMessageDialog(vistaCrudCompra, "No se pudo registrar la persona");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            // Resto del código para manejar la excepción...
        }
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
        tb.addColumn("Metodo Pago");
        tb.addColumn("Estado civil");
        tb.addColumn("Contraseña");

        List<Comprador> com = modCompra.ListaComprador();
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
                p.getMetodoPago_com(),
                p.getEstadoCivil_com(),
                p.getContraseña_usu()
            };
            tb.addRow(rowData);
        });

        vistaCrudCompra.getTablaComprador().setModel(tb);
    }
    
    private void eliminarComprador() {
        String cedula = vistaCrudCompra.getTxtCedu().getText();

        if (cedula != null && !cedula.isEmpty()) {
            int response = JOptionPane.showConfirmDialog(vistaCrudCompra, "¿Seguro que desea eliminar al comprador con cédula " + cedula + "?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    // Llamar al método para eliminar el comprador
                    modCompra.eliminar_comprador(cedula);
                    JOptionPane.showMessageDialog(vistaCrudCompra, "Comprador eliminado exitosamente");
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
     // metodo para consultar si existe un comprador por cedula
    private void consultarComprador() {
        String cedula = vistaCrudCompra.getTxtCedu().getText();
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
        tb.addColumn("Metodo Pago");
        tb.addColumn("Estado Civil");
        tb.addColumn("Contraseña");

        Comprador compra = null;
        try {
            compra = modCompra.buscarComprador(cedula); // Llama al método para buscar el comprador por la cédula

        } catch (SQLException ex) {
            Logger.getLogger(ControladorCrudComprador.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (compra != null) {
            JOptionPane.showMessageDialog(vistaCrudCompra, "Si existe ese comprador");
            Object[] rowData = {
                compra.getCedula_usu(),
                compra.getNombre_usu(),
                compra.getApellido_usu(),
                compra.getFechaNacimiento_usu(),
                compra.getSexo_usu(),
                compra.getCorreo_usu(),
                compra.getTipoSangre_usu(),
                compra.getCelular_usu(),
                compra.getCiudad_usu(),
                compra.getDireccion_usu(),
                compra.getMetodoPago_com(),
                compra.getEstadoCivil_com(),
                compra.getContraseña_usu()
            };
            tb.addRow(rowData);
        } else {
            JOptionPane.showMessageDialog(vistaCrudCompra, "No se encontró el comprador con la cédula especificada");
        }

        vistaCrudCompra.getTablaComprador().setModel(tb);
    }
}
