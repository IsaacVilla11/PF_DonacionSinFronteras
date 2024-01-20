package Controlador;

import Modelo.ModeloComprador;
import Modelo.ModeloUsuario;
import Vista.Login_Comprador;
import Vista.Registro_Comprador;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author IV
 */
public class ControladorRegistroComprador {

    Registro_Comprador vistaRegCom;
    ModeloComprador modCompra = new ModeloComprador();

    public ControladorRegistroComprador(Registro_Comprador vistaRegCom) {
        this.vistaRegCom = vistaRegCom;
        vistaRegCom.setVisible(true);

    }

    public void iniciarControl() {
        vistaRegCom.getBtnGuardar().addActionListener(l -> RegistrarComprador());
        vistaRegCom.getBtnAtras().addActionListener(l -> IrLoginComprador());

    }

    public void RegistrarComprador() {
        ModeloComprador compra = new ModeloComprador();
        ModeloUsuario per = new ModeloUsuario();

        try {
            String cedula = vistaRegCom.getTxtCedu().getText();

            // Verificar duplicidad de la cédula de la persona
            if (per.verificarDuplicidadCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaRegCom, "La cedula ingresada ya existe en el sistema");
                vistaRegCom.getTxtCedu().setText("");
                return;
            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaRegCom, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            per.setCedula_usu(cedula);

            String nombre = vistaRegCom.getTxtNomb().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaRegCom, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            per.setNombre_usu(nombre);

            String apellido = vistaRegCom.getTxtApe().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaRegCom, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            per.setApellido_usu(apellido);

            String genero;
            if (vistaRegCom.getBtnH().isSelected()) {
                genero = "Hombre";
            } else if (vistaRegCom.getBtnM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaRegCom, "Seleccione un género");
                return;
            }
            per.setSexo_usu(genero);

            String celular = vistaRegCom.getTxtCelular().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaRegCom, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            per.setCelular_usu(celular);

            String correo = vistaRegCom.getTxtCorreo().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaRegCom, "Correo no válido. Ingrese de nuevo");
                return;
            }
            per.setCorreo_usu(correo);

            String tipoSangre = vistaRegCom.getCbBoxSangre().getSelectedItem().toString();
            per.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaRegCom.getCbboxCiudad().getSelectedItem();
            per.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaRegCom.getjDnacimiento().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaRegCom.getjDnacimiento().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaRegCom.getjDnacimiento().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaRegCom.getjDnacimiento() == null) {
                JOptionPane.showMessageDialog(vistaRegCom, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            per.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaRegCom.getTxtDirecc().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaRegCom, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            per.setDireccion_usu(direccion);

            String contraseniaAdmi = vistaRegCom.getTxtPass().getText();
            if (!Validaciones.ValidarContrasena(contraseniaAdmi)) {
                JOptionPane.showMessageDialog(vistaRegCom, "Contraseña no valida. Ingrese de nuevo");
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
                    String pagos = vistaRegCom.getCbboxMetPagos().getSelectedItem().toString();
                    compra.setMetodoPago_com(pagos);
                    String estadoCivil = vistaRegCom.getCbboxEstCivil().getSelectedItem().toString();
                    compra.setEstadoCivil_com(estadoCivil);

                    if (compra.InsertarComprador()) {
                        JOptionPane.showMessageDialog(vistaRegCom, "Su cuenta se registro exitosamente");
                        
                    } else {
                        JOptionPane.showMessageDialog(vistaRegCom, "No se pudo registrar su cuenta como comprador");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaRegCom, "No se pudo obtener el id_persona");
                }
            } else {
                JOptionPane.showMessageDialog(vistaRegCom, "No se pudo registrar la persona");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            // Resto del código para manejar la excepción...
        }
    }

    public void IrLoginComprador() {
        vistaRegCom.dispose();
        Login_Comprador vista = new Login_Comprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLoginComprador control = new ControladorLoginComprador(vista);
        control.iniciarControl();
    }

}
