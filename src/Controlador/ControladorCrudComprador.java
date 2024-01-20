package Controlador;


import Modelo.Comprador;

import Modelo.ModeloComprador;
import Modelo.ModeloUsuario;
import Vista.CRUD_Comprador;
import Vista.CRUD_Comprador;
import Vista.vistaAdministrador;
import java.util.Calendar;
import java.util.List;
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
}
