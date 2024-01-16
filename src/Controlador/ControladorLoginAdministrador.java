package Controlador;

import Vista.Login_Administrador;
import Vista.vistaAdministrador;
import Vista.vistaLogins;

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
        vistaLogAdmin.getBtnIniciarSesionAdmin().addActionListener(l -> iniciarSesion());
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
}
