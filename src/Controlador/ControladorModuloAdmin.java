package Controlador;

import Vista.CRUD_Comprador;
import Vista.Registro_Comprador;
import Vista.V_CrudComprador;
import Vista.V_Principal;
import Vista.crudAdministrador;
import Vista.vistaAdministrador;

/**
 *
 * @author IV
 */
public class ControladorModuloAdmin {

    vistaAdministrador vistaModAdmin;

    public ControladorModuloAdmin(vistaAdministrador vistaModAdmin) {
        this.vistaModAdmin = vistaModAdmin;
        vistaModAdmin.setVisible(true);
    }

    public void iniciarControl() {
        vistaModAdmin.getBtnCerrarSesion().addActionListener(l -> regresesarMenuPrincipal());
        vistaModAdmin.getJmiRegistroComprador().addActionListener(l -> mostrarCrudComprador());
        vistaModAdmin.getJmiCrudAdmin().addActionListener(l -> mostrarCrudAdmin());

    }

    public void regresesarMenuPrincipal() {
        vistaModAdmin.dispose();
        V_Principal vista = new V_Principal();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorMenuPrincipal controP = new ControladorMenuPrincipal(vista);
        controP.iniciarControl();
    }

    public void mostrarCrudComprador() {
        vistaModAdmin.dispose();
        V_CrudComprador vista = new V_CrudComprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorCrudComprador control = new ControladorCrudComprador(vista);
        control.iniciarControl();
    }

    public void mostrarCrudAdmin() {
        vistaModAdmin.dispose();
        crudAdministrador vista = new crudAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorCrudAdmin control = new ControladorCrudAdmin(vista);
        control.iniciarControl();
    }
}
