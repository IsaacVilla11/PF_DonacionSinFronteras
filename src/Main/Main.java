package Main;

import Controlador.ControladorMenuPrincipal;
import Vista.V_Principal;

public class Main {

    public static void main(String[] args) {
        V_Principal vistaP = new V_Principal();
        ControladorMenuPrincipal controlPrincipal = new ControladorMenuPrincipal(vistaP);
        controlPrincipal.iniciarControl();
    }
}
