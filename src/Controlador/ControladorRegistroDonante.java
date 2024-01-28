package Controlador;

import Modelo.ModeloDonante;
import Modelo.ModeloUsuario;
import Vista.Login_Donador;
import Vista.Registro_Donante;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author IV
 */
public class ControladorRegistroDonante {

    Registro_Donante vistaRegDon;
    

    public ControladorRegistroDonante(Registro_Donante vistaRegDon) {
        this.vistaRegDon = vistaRegDon;
        vistaRegDon.setVisible(true);
    }

    public void iniciarControl() {
        vistaRegDon.getBtnGuardar().addActionListener(l -> registrarDonador());
        vistaRegDon.getBtnAtras().addActionListener(l -> IrLoginDonador());

    }

    public void registrarDonador() {
        //Crear Codigo
         ModeloUsuario per = new ModeloUsuario();
         ModeloDonante perDona=new ModeloDonante();
         
         try {
            String cedula = vistaRegDon.getTxtCedu().getText();

            // Verificar duplicidad de la cédula de la persona
            if (per.verificarDuplicidadCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaRegDon, "La cedula ingresada ya existe en el sistema");
                vistaRegDon.getTxtCedu().setText("");
                return;
            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaRegDon, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            per.setCedula_usu(cedula);

            String nombre = vistaRegDon.getTxtNomb().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaRegDon, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            per.setNombre_usu(nombre);

            String apellido = vistaRegDon.getTxtApe().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaRegDon, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            per.setApellido_usu(apellido);

            String genero;
            if (vistaRegDon.getBtnH().isSelected()) {
                genero = "Hombre";
            } else if (vistaRegDon.getBtnM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaRegDon, "Seleccione un género");
                return;
            }
            per.setSexo_usu(genero);

            String celular = vistaRegDon.getTxtCelular().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaRegDon, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            per.setCelular_usu(celular);

            String correo = vistaRegDon.getTxtCorreo().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaRegDon, "Correo no válido. Ingrese de nuevo");
                return;
            }
            per.setCorreo_usu(correo);

            String tipoSangre = vistaRegDon.getCbBoxSangre().getSelectedItem().toString();
            per.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaRegDon.getCbboxCiudad().getSelectedItem();
            per.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaRegDon.getjDnacimiento().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaRegDon.getjDnacimiento().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaRegDon.getjDnacimiento().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaRegDon.getjDnacimiento() == null) {
                JOptionPane.showMessageDialog(vistaRegDon, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            per.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaRegDon.getTxtDirecc().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaRegDon, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            per.setDireccion_usu(direccion);

            String contraseniaDonant = vistaRegDon.getTxtPass().getText();
            if (!Validaciones.ValidarContrasena(contraseniaDonant)) {
                JOptionPane.showMessageDialog(vistaRegDon, "Contraseña no valida. Ingrese de nuevo");
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
                    String proyecto = vistaRegDon.getTxtproyecto().getText();
                    if (!Validaciones.ValidarNomApe(proyecto)) {
                        JOptionPane.showMessageDialog(vistaRegDon, "Nombre Del Proyecto incorrecto. Ingrese de nuevo");
                        return;
                    }
                    perDona.setProyecto_dont(proyecto);

                    String entidad = vistaRegDon.getTxtentidad().getText();
                    if (!Validaciones.ValidarNomApe(entidad)) {
                        JOptionPane.showMessageDialog(vistaRegDon, "Nombre De Entidad incorrecto. Ingrese de nuevo");
                        return;
                    }
                    perDona.setEntidad_dont(entidad);

                    String motivo = vistaRegDon.getTxtMotivo().getText();
                    if (!Validaciones.validarLetras(motivo)) {
                        JOptionPane.showMessageDialog(vistaRegDon, "Motivo incorrecto. Ingrese de nuevo");
                        return;
                    }
                    perDona.setMotivo_dont(motivo);

                    if (perDona.insertarDonante()) {
                        JOptionPane.showMessageDialog(vistaRegDon, "Se guardó exitosamente");
                     
                    } else {
                        JOptionPane.showMessageDialog(vistaRegDon, "No se pudo registrar el donante");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaRegDon, "No se pudo obtener el id_persona");
                }
            } else {
                JOptionPane.showMessageDialog(vistaRegDon, "No se pudo registrar la persona");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            System.out.println(e);
            // Resto del código para manejar la excepción...
        }
    }

    public void IrLoginDonador() {
        vistaRegDon.dispose();
        Login_Donador vista = new Login_Donador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLoginDonador control = new ControladorLoginDonador(vista);
        control.iniciarControl();
    }
}
