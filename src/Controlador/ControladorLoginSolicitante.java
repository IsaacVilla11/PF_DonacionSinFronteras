package Controlador;

import Vista.Login_Solicitante;
import Vista.Registro_Donante;
import Vista.Registro_Solicitante;
import Vista.V_Donador;
import Vista.V_Solicitante;
import Vista.vistaLogins;

/**
 *
 * @author IV
 */
public class ControladorLoginSolicitante {

    private Login_Solicitante vistaLogSoli;

    public ControladorLoginSolicitante(Login_Solicitante vistaLogSoli) {
        this.vistaLogSoli = vistaLogSoli;
    }

    public void iniciarControl() {
        vistaLogSoli.getBtnIniciarSesion().addActionListener(l -> iniciarSesion());
        vistaLogSoli.getBtnRegistrar().addActionListener(l -> registroSolicitante());
        vistaLogSoli.getBtnRegresar().addActionListener(l -> regresesarMenuLogins());

    }

    public void iniciarSesion() {
        vistaLogSoli.dispose();
        V_Solicitante vista = new V_Solicitante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloSolicitante control = new ControladorModuloSolicitante(vista);
        control.iniciarControl();
    }

    public void registroSolicitante() {
        vistaLogSoli.dispose();
        Registro_Solicitante vista = new Registro_Solicitante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorRegistroSolicitante control = new ControladorRegistroSolicitante(vista);
        control.iniciarControl();
    }

    public void regresesarMenuLogins() {
        vistaLogSoli.dispose();
        vistaLogins vista = new vistaLogins();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLogins control = new ControladorLogins(vista);
        control.iniciarControl();

    }
}
