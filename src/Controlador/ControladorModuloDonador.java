package Controlador;

import Vista.V_Donador;
import Vista.V_Principal;

/**
 *
 * @author IV
 */
public class ControladorModuloDonador {

    V_Donador vistaDona;

    public ControladorModuloDonador(V_Donador vistaDona) {
        this.vistaDona = vistaDona;
        vistaDona.setVisible(true);
    }

    public void iniciarControl() {
        vistaDona.getBtnCerrarSesion().addActionListener(l -> regresesarMenuPrincipal());

    }

    public void regresesarMenuPrincipal() {
        vistaDona.dispose();
        V_Principal vista = new V_Principal();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorMenuPrincipal controP = new ControladorMenuPrincipal(vista);
        controP.iniciarControl();

    }
}
