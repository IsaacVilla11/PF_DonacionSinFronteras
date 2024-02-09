package Controlador;

import Vista.Login_Solicitante;
import Vista.V_Principal;
import Vista.vistaLogins;

/**
 *
 * @author IV
 */
public class ControladorMenuPrincipal {

    V_Principal vistaP;
    vistaLogins vistaL;

    public ControladorMenuPrincipal(V_Principal vistaP) {
        this.vistaP = vistaP;
        vistaP.setVisible(true);
    }

    public void iniciarControl() {
        vistaP.getBtnIniciarSesion().addActionListener(l -> mostrarLoginUsuarios());
        vistaP.getBtnRegistrarse().addActionListener(l -> mostrarLoginUsuarios());
        vistaP.getBtnAyuda().addActionListener(l -> mostrarLoginSolicitante());

    }

    public void mostrarLoginUsuarios() {
        vistaP.dispose();
        vistaLogins vista = new vistaLogins();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLogins controlLogin = new ControladorLogins(vista);
        controlLogin.iniciarControl();
        
        

    }
    
    public void mostrarLoginSolicitante() {
        vistaP.dispose();
        Login_Solicitante vista = new Login_Solicitante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLoginSolicitante controlLogin = new ControladorLoginSolicitante(vista);
        controlLogin.iniciarControl();
        
    }
}
