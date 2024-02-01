package Controlador;

import Vista.Login_Solicitante;
import Vista.Registro_Solicitante;

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
