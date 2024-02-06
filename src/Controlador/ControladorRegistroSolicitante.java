package Controlador;

import Modelo.ModeloSolicitante;
import Modelo.ModeloUsuario;
import Vista.Login_Solicitante;
import Vista.Registro_Solicitante;
import javax.swing.JOptionPane;
import java.util.Calendar;

/**
 *
 * @author IV
 */
public class ControladorRegistroSolicitante {

    private Registro_Solicitante vistaSoli;

    public ControladorRegistroSolicitante(Registro_Solicitante vistaSoli) {
        this.vistaSoli = vistaSoli;
        vistaSoli.setVisible(true);
    }

    public void iniciarControl() {
        vistaSoli.getBtnRegistrar().addActionListener(l -> crearSolicitante());
        vistaSoli.getBtnRegresar().addActionListener(l -> irLoginSolicitante());

    }

    public void crearSolicitante() {
        //Crear Codigo
        ModeloSolicitante solicitante = new ModeloSolicitante();
        ModeloUsuario per = new ModeloUsuario();

        try {
            String cedula = vistaSoli.getTxtcedula_soli().getText();

            // Verificar duplicidad de la cédula de la persona
            if (per.verificarDuplicidadCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaSoli, "La cedula ingresada ya existe en el sistema");
                vistaSoli.getTxtcedula_soli().setText("");
                return;
            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaSoli, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            per.setCedula_usu(cedula);

            String nombre = vistaSoli.getTxtnombre_soli().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaSoli, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            per.setNombre_usu(nombre);

            String apellido = vistaSoli.getTxtapellido_soli().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaSoli, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            per.setApellido_usu(apellido);

            String genero;
            if (vistaSoli.getRbH().isSelected()) {
                genero = "Hombre";
            } else if (vistaSoli.getRbM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaSoli, "Seleccione un género");
                return;
            }
            per.setSexo_usu(genero);

            String celular = vistaSoli.getTxtcelular_soli().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaSoli, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            per.setCelular_usu(celular);

            String correo = vistaSoli.getTxtcorreo_soli().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaSoli, "Correo no válido. Ingrese de nuevo");
                return;
            }
            per.setCorreo_usu(correo);

            String tipoSangre = vistaSoli.getCbBoxSangre().getSelectedItem().toString();
            per.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaSoli.getCboxciudad_soli().getSelectedItem();
            per.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaSoli.getjDateChooser1().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaSoli.getjDateChooser1().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaSoli.getjDateChooser1().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaSoli.getjDateChooser1() == null) {
                JOptionPane.showMessageDialog(vistaSoli, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            per.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaSoli.getTxtdireccion().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaSoli, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            per.setDireccion_usu(direccion);

            String contraseniaAdmi = vistaSoli.getTxtContra_soli().getText();
            if (!Validaciones.ValidarContrasena(contraseniaAdmi)) {
                JOptionPane.showMessageDialog(vistaSoli, "Contraseña no valida. Ingrese de nuevo");
                return;
            }
            per.setContraseña_usu(contraseniaAdmi);

            if (per.InsertarPersona(FechaNacimiento)) {
                // Obtener el id_persona recién insertado
                int idPersona = per.traerCodigoDePersonaCrear(cedula);

                if (idPersona > 0) {
                    // Asignar el id_persona al modeloAdmin
                    solicitante.setId_persona(idPersona);


                    if (solicitante.InsertarSolicitante()) {
                        JOptionPane.showMessageDialog(vistaSoli, "Su cuenta se registro exitosamente");
                        
                    } else {
                        JOptionPane.showMessageDialog(vistaSoli, "No se pudo registrar su cuenta como Solicitante");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaSoli, "No se pudo obtener el id_persona");
                }
            } else {
                JOptionPane.showMessageDialog(vistaSoli, "No se pudo registrar la persona");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            // Resto del código para manejar la excepción...
        }
    }

    public void irLoginSolicitante() {
        vistaSoli.dispose();
        Login_Solicitante vista = new Login_Solicitante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLoginSolicitante control = new ControladorLoginSolicitante(vista);
        control.iniciarControl();
    }
}
