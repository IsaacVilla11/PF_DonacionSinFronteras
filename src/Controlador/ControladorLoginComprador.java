package Controlador;

import Vista.Login_Comprador;
import Vista.Registro_Comprador;
import Vista.V_Comprador;
import Vista.V_Principal;
import Vista.vistaLogins;

/**
 *
 * @author IV
 */
public class ControladorLoginComprador {

    Login_Comprador LoginCom;

    public ControladorLoginComprador(Login_Comprador LoginCom) {
        this.LoginCom = LoginCom;
        LoginCom.setVisible(true);
    }

    public void iniciarControl() {
        LoginCom.getBtnIniciarSesionComprador().addActionListener(l -> iniciarSesion());
        LoginCom.getBtnRegistrarComprador().addActionListener(l -> registroComprador());
        LoginCom.getBtnRegresar().addActionListener(l -> regresesarMenuLogins());

    }

    public void iniciarSesion() {
        LoginCom.dispose();
        V_Comprador vista = new V_Comprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloComprador control = new ControladorModuloComprador(vista);
        control.iniciarControl();
    }

    public void registroComprador() {
        LoginCom.dispose();
        Registro_Comprador vista = new Registro_Comprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorRegistroComprador control = new ControladorRegistroComprador(vista);
        control.iniciarControl();
    }

    public void regresesarMenuLogins() {
        LoginCom.dispose();
        vistaLogins vista = new vistaLogins();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLogins control = new ControladorLogins(vista);
        control.iniciarControl();

    }

}
