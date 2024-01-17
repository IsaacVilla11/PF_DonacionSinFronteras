package Controlador;

import Vista.crudAdministrador;
import Vista.vistaAdministrador;

/**
 *
 * @author IV
 */
public class ControladorCrudAdmin {

    crudAdministrador vistaCrudAdmin;

    public ControladorCrudAdmin(crudAdministrador vistaCrudAdmin) {
        this.vistaCrudAdmin = vistaCrudAdmin;
        vistaCrudAdmin.setVisible(true);
    }

    public void iniciarControl() {
        vistaCrudAdmin.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
    }

    public void regresarModuloAdmin() {
        vistaCrudAdmin.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }
}
