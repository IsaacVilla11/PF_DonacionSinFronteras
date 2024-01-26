package Controlador;

import Modelo.Administrador;
import Modelo.Comprador;
import Modelo.ModeloAdministrador;
import Modelo.ModeloComprador;
import Vista.Login_Administrador;
import Vista.vistaAdministrador;
import Vista.vistaLogins;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author IV
 */
public class ControladorLoginAdministrador {

    Login_Administrador vistaLogAdmin;

    public ControladorLoginAdministrador(Login_Administrador vistaLogAdmin) {
        this.vistaLogAdmin = vistaLogAdmin;
        vistaLogAdmin.setVisible(true);
    }

    public void iniciarControl() {
        vistaLogAdmin.getBtnIniciarSesionAdmin().addActionListener(l -> LoginAdministrador());
        vistaLogAdmin.getBtnRegresar().addActionListener(l -> regresesarMenuLogins());

    }

    public void iniciarSesion() {
        vistaLogAdmin.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }

    public void regresesarMenuLogins() {
        vistaLogAdmin.dispose();
        vistaLogins vista = new vistaLogins();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLogins control = new ControladorLogins(vista);
        control.iniciarControl();

    }
         // Método para Credenciales  login del administrador
    public void LoginAdministrador() {
       ModeloAdministrador modAdmin = new ModeloAdministrador();
        List<Administrador> adm = modAdmin.ListaAdministrador();

        boolean bandera = modAdmin.ConsultarAdministrador(vistaLogAdmin.getTxtUsuario().getText(), vistaLogAdmin.getTxtContrasenia().getText(), adm);

        if (bandera) {
            iniciarSesion();
            vistaLogAdmin.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecto");
            limpiarcampos();
        }
    }
    public void limpiarcampos(){
        vistaLogAdmin.getTxtUsuario().setText("");
        vistaLogAdmin.getTxtContrasenia().setText("");
    }
    /*/public void validarU_Admnistrador() {
        String auxUsuario = vistaLogAdmin.getTxtUsuario().getText();
        String auxPassword = vistaLogAdmin.getTxtContrasenia().getText();
        String usuario = "admin";
        String contraseña = "123";
        if (auxUsuario.isEmpty() || auxPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "CAMPOS VACIOS");
        } else {
            if (auxUsuario.equals(usuario) && auxPassword.equals(contraseña)) {
                //JOptionPane.showMessageDialog(null, "BIENVENIDO AL SISTEMA");

                vistaLogAdmin.dispose();
               iniciarSesion();
            } else {
                JOptionPane.showMessageDialog(null, " ERROR: USUARIO O CONTRASEÑA INCORRECTO");
            }
        }
    }*/
}
