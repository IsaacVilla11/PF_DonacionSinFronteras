/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.crud_Donacion;
import Vista.vistaAdministrador;
/**
 *
 * @author jose
 */
public class controladorDonaciones {
    
    crud_Donacion vistaDonaciones;

    public controladorDonaciones(crud_Donacion vistaDonaciones) {
        this.vistaDonaciones = vistaDonaciones;
        vistaDonaciones.setVisible(true);
    }
    public void iniciarControl() {      
        vistaDonaciones.getBtnVolver().addActionListener(l -> mostrarVistaAdmin());
    }
    
     public   void mostrarVistaAdmin(){
        vistaDonaciones.dispose();
        vistaAdministrador vista1 = new vistaAdministrador();
        vista1.setLocationRelativeTo(null);
        vista1.setVisible(true);

        ControladorModuloAdmin controR = new ControladorModuloAdmin(vista1);
        controR.iniciarControl();
    }
    
    
}
