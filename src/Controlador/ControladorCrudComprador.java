package Controlador;

import Vista.V_CrudComprador;
import Vista.vistaAdministrador;

/**
 *
 * @author IV
 */
public class ControladorCrudComprador {
    
    V_CrudComprador vistaCrudCompra;
    
    public ControladorCrudComprador(V_CrudComprador vistaCrudCompra) {
        this.vistaCrudCompra = vistaCrudCompra;
        vistaCrudCompra.setVisible(true);
    }
    
    public void iniciarControl() {
        vistaCrudCompra.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
    }
    
    public void regresarModuloAdmin() {
        vistaCrudCompra.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }
}
