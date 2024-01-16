package Controlador;

import Vista.V_Comprador;
import Vista.V_Principal;

/**
 *
 * @author IV
 */
public class ControladorModuloComprador {

    V_Comprador vistaModCom;

    public ControladorModuloComprador(V_Comprador vistaModCom) {
        this.vistaModCom = vistaModCom;
        vistaModCom.setVisible(true);
    }

    public void iniciarControl() {
        vistaModCom.getBtnregresar().addActionListener(l -> regresesarMenuPrincipal());

    }

    public void regresesarMenuPrincipal() {
        vistaModCom.dispose();
        V_Principal vista = new V_Principal();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorMenuPrincipal controP = new ControladorMenuPrincipal(vista);
        controP.iniciarControl();

    }

}
