/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.crud_RegistroDonacion;
import Vista.vistaAdministrador;

/**
 *
 * @author PC01
 */
public class ControladorCrud_RegistroDonacion {

    crud_RegistroDonacion  vistaDonaciones;

    public ControladorCrud_RegistroDonacion(crud_RegistroDonacion vistaDonaciones) {
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
