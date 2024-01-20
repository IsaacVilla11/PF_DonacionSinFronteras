package Controlador;

import Vista.CRUD_Comprador;
import Vista.Crud_lugarAfectado;
import Vista.Registro_Comprador;
import Vista.V_CrudComprador;
import Vista.V_ModuloProducto;
import Vista.V_Principal;
import Vista.crudAdministrador;
import Vista.vistaAdministrador;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

/**
 *
 * @author IV
 */
public class ControladorModuloAdmin {

    vistaAdministrador vistaModAdmin;
    Crud_lugarAfectado vistaLugarAfectado;
 

    public ControladorModuloAdmin(vistaAdministrador vistaModAdmin) {
        this.vistaModAdmin = vistaModAdmin;
        vistaModAdmin.setVisible(true);

    }
    public void iniciarControl() {
        vistaModAdmin.getBtnCerrarSesion().addActionListener(l -> regresesarMenuPrincipal());
        vistaModAdmin.getJmiRegistroComprador().addActionListener(l -> mostrarCrudComprador());
        vistaModAdmin.getJmiCrudAdmin().addActionListener(l -> mostrarCrudAdmin());
        vistaModAdmin.getBtnLA().addActionListener(e -> mostrarTableLA());
       vistaModAdmin.getBtnProductos().addActionListener(l -> mostrarModuloProductos());
        

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
    public void mostrarTableLA() {
     // Abrir la nueva ventana de productos
    Crud_lugarAfectado vistaRegistros = new Crud_lugarAfectado();
    vistaModAdmin.getDeskRegistros().add(vistaRegistros);
    }
    public void mostrarModuloProductos(){
        vistaModAdmin.dispose();
        V_ModuloProducto vista = new V_ModuloProducto();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        ControladorModuloProductos control = new ControladorModuloProductos(vista);
        control.iniciarControl();
    }
}