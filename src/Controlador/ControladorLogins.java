package Controlador;

import Vista.Login_Administrador;
import Vista.Login_Comprador;
import Vista.Login_Solicitante;
import Vista.Registro_Comprador;
import Vista.Registro_Solicitante;
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
     
        vistaLogin.getBtnLoginComprador().addActionListener(l -> mostrarLoginComprador());
        vistaLogin.getBtnLoginSolicitante().addActionListener(l -> mostrarLoginSolicitante());
        vistaLogin.getJmiLoginAdmin().addActionListener(l -> mostrarLoginAdministrador());
        vistaLogin.getBtnRegresarMenu().addActionListener(l -> regresesarMenuPrincipal());
        vistaLogin.getBtnRegistroComprador().addActionListener(l -> mostrarRegistroComprador());
      
        vistaLogin.getBtnRegistroSolicitante().addActionListener(l-> mostrarRegistroSolicitante());
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
    


    public void mostrarRegistroSolicitante() {
        vistaLogin.dispose();
        Registro_Solicitante vista = new Registro_Solicitante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorRegistroSolicitante control = new ControladorRegistroSolicitante(vista);
        control.iniciarControl();
    }
    
}
