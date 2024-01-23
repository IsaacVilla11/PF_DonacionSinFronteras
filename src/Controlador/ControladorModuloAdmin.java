package Controlador;

import Vista.CRUD_Comprador;
import Vista.Crud_centroAcopio;
import Vista.Crud_lugarAfectado;
import Vista.Registro_Comprador;
import Vista.V_ModuloProducto;
import Vista.V_Principal;
import Vista.crudAdministrador;
import Vista.crudCiudad;
import Vista.crud_Donacion;
import Vista.crud_RegistroDonacion;
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
       vistaModAdmin.getJmitemRopa().addActionListener(l -> mostrarModuloProductos());
       
       //Notocar
       vistaModAdmin.getJmitemRegDonacion().addActionListener(l->mostrarRegistroDonante());
       vistaModAdmin.getJmitemCiudad().addActionListener(l->MostrorCrudCiudad());
       vistaModAdmin.getBtnDonaciones().addActionListener(l->mostrarCrudDonaciones());
       vistaModAdmin.getBtnCentroAcopio().addActionListener(l->mostrarCentroAcopio());
       vistaModAdmin.getBtnLugarAyuda().addActionListener(l-> mostrarCrudLugarAyuda());
    }   
    
    //jose
    public void mostrarRegistroDonante(){
        
        vistaModAdmin.dispose();
        crud_RegistroDonacion vista = new crud_RegistroDonacion();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorCrud_RegistroDonacion controR = new ControladorCrud_RegistroDonacion(vista);
        controR.iniciarControl();      
    }  
    public void MostrorCrudCiudad(){
        
       vistaModAdmin.dispose();
       crudCiudad vista2 = new crudCiudad();
       vista2.setLocationRelativeTo(null);
       vista2.setVisible(true);
       
       controladorCiudad controlC = new controladorCiudad(vista2);
       controlC.iniciarControl();  
    }
       
    public void mostrarCrudDonaciones(){
       vistaModAdmin.dispose();
       crud_Donacion vista2 = new crud_Donacion();
       vista2.setLocationRelativeTo(null);
       vista2.setVisible(true);
       
       controladorDonaciones controlC = new controladorDonaciones(vista2);
       controlC.iniciarControl();    
    }
    
    public void mostrarCentroAcopio(){
       vistaModAdmin.dispose();
       Crud_centroAcopio vista2 = new Crud_centroAcopio();
       vista2.setLocationRelativeTo(null);
       vista2.setVisible(true);
       
       controladorCentroAcopio controlC = new controladorCentroAcopio(vista2);
       controlC.iniciarControl();  
    }
    
    public void mostrarCrudLugarAyuda(){
       vistaModAdmin.dispose();
       Crud_lugarAfectado vista2 = new Crud_lugarAfectado();
       vista2.setLocationRelativeTo(null);
       vista2.setVisible(true);
       
       controladorLugarAyuda controlC = new controladorLugarAyuda(vista2);
       controlC.iniciarControl();
    }
    //fin..
        
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
        CRUD_Comprador vista = new CRUD_Comprador();
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