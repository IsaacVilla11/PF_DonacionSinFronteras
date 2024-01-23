/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Crud_lugarAfectado;
import Vista.vistaAdministrador;

/**
 *
 * @author jose
 */
public class controladorLugarAyuda {
    
    Crud_lugarAfectado vistaLugarAfectdo;

    public controladorLugarAyuda(Crud_lugarAfectado vistaLugarAfectdo) {
        this.vistaLugarAfectdo = vistaLugarAfectdo;
        vistaLugarAfectdo.setVisible(true);
    }
    public void iniciarControl() {
        
        vistaLugarAfectdo.getBtnVolver().addActionListener(l -> mostrarVistaAdmin());

    }
    public   void mostrarVistaAdmin(){
        vistaLugarAfectdo.dispose();
        vistaAdministrador vista1 = new vistaAdministrador();
        vista1.setLocationRelativeTo(null);
        vista1.setVisible(true);

        ControladorModuloAdmin controR = new ControladorModuloAdmin(vista1);
        controR.iniciarControl();
    }
    
}
