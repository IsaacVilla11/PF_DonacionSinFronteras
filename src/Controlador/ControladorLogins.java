package Controlador;

import Vista.Login_Administrador;
import Vista.Login_Comprador;
import Vista.Login_Donador;
import Vista.Login_Solicitante;
import Vista.Registro_Comprador;
import Vista.Registro_Donante;
import Vista.V_Principal;
import Vista.vistaLogins;

/**
 *
 * @author IV
 */
public class ControladorLogins {

    vistaLogins vistaLogin;

    public ControladorLogins(vistaLogins vistaLogin) {
        this.vistaLogin = vistaLogin;
        vistaLogin.setVisible(true);
    }

    public void iniciarControl() {
        vistaLogin.getBtnLoginDonador().addActionListener(l -> mostrarLoginDonador());
        vistaLogin.getBtnLoginComprador().addActionListener(l -> mostrarLoginComprador());
        vistaLogin.getBtnLoginSolicitante().addActionListener(l -> mostrarLoginSolicitante());
        vistaLogin.getJmiLoginAdmin().addActionListener(l -> mostrarLoginAdministrador());
        vistaLogin.getBtnRegresarMenu().addActionListener(l -> regresesarMenuPrincipal());
        vistaLogin.getBtnRegistroComprador().addActionListener(l -> mostrarRegistroComprador());
        vistaLogin.getBtnRegistroDonador().addActionListener(l-> mostrarRegistroDonante());
    }

    public void mostrarLoginDonador() {
        vistaLogin.dispose();
        Login_Donador vista = new Login_Donador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLoginDonador control = new ControladorLoginDonador(vista);
        control.iniciarControl();

    }

    public void mostrarLoginComprador() {
        vistaLogin.dispose();
        Login_Comprador vista = new Login_Comprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLoginComprador control = new ControladorLoginComprador(vista);
        control.iniciarControl();

    }

    public void mostrarLoginSolicitante() {
        vistaLogin.dispose();
        Login_Solicitante vista = new Login_Solicitante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLoginSolicitante control = new ControladorLoginSolicitante(vista);
        control.iniciarControl();
    }

    public void mostrarLoginAdministrador() {
        vistaLogin.dispose();
        Login_Administrador vista = new Login_Administrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLoginAdministrador control = new ControladorLoginAdministrador(vista);
        control.iniciarControl();
    }

    public void regresesarMenuPrincipal() {
        vistaLogin.dispose();
        V_Principal vista = new V_Principal();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorMenuPrincipal controP = new ControladorMenuPrincipal(vista);
        controP.iniciarControl();

    }

    public void mostrarRegistroComprador() {
        vistaLogin.dispose();
        Registro_Comprador vista = new Registro_Comprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorRegistroComprador control = new ControladorRegistroComprador(vista);
        control.iniciarControl();
    }
    
    public void mostrarRegistroDonante() {
        vistaLogin.dispose();
        Registro_Donante vista = new Registro_Donante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorRegistroDonante control = new ControladorRegistroDonante(vista);
        control.iniciarControl();
    }

}
