package Controlador;

import Vista.Login_Donador;
import Vista.Registro_Donante;
import Vista.vistaLogins;

/**
 *
 * @author IV
 */
public class ControladorLoginDonador {

    Login_Donador vistaLogDon;

    public ControladorLoginDonador(Login_Donador vistaLogDon) {
        this.vistaLogDon = vistaLogDon;
        vistaLogDon.setVisible(true);
    }

    public void iniciarControl() {
        //vistaLogDon.getBtnIniciarSesionComprador().addActionListener(l -> iniciarSesion());
        vistaLogDon.getBtnRegistar().addActionListener(l -> registroDonante());
        vistaLogDon.getBtnRegresar().addActionListener(l -> regresesarMenuLogins());

    }

    public void iniciarSesion() {
        vistaLogDon.dispose();
        //V_Donador vista = new V_Donador();-Hacer el modulo donador
//        vista.setLocationRelativeTo(null);
//        vista.setVisible(true);

//        ControladorModuloDonador control = new ControladorModuloDonador(vista);
//        control.iniciarControl();
    }

    public void registroDonante() {
        vistaLogDon.dispose();
        Registro_Donante vista = new Registro_Donante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorRegistroDonante control = new ControladorRegistroDonante(vista);
        control.iniciarControl();
    }

    public void regresesarMenuLogins() {
        vistaLogDon.dispose();
        vistaLogins vista = new vistaLogins();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLogins control = new ControladorLogins(vista);
        control.iniciarControl();

    }
}
