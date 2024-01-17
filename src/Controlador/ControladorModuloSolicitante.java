package Controlador;

import Vista.V_Principal;
import Vista.V_Solicitante;

/**
 *
 * @author IV
 */
public class ControladorModuloSolicitante {

    V_Solicitante vistaSoli;

    public ControladorModuloSolicitante(V_Solicitante vistaSoli) {
        this.vistaSoli = vistaSoli;
        vistaSoli.setVisible(true);
    }

    public void iniciarControl() {
        vistaSoli.getBtnregresar().addActionListener(l -> regresesarMenuPrincipal());

    }

    public void regresesarMenuPrincipal() {
        vistaSoli.dispose();
        V_Principal vista = new V_Principal();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorMenuPrincipal controP = new ControladorMenuPrincipal(vista);
        controP.iniciarControl();

    }
}
