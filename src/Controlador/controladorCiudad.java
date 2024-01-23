/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.crudCiudad;
import Vista.vistaAdministrador;
/**
 *
 * @author jose
 */
public class controladorCiudad {
    
    crudCiudad vistaCiudad;

    public controladorCiudad(crudCiudad vistaCiudad) {
        this.vistaCiudad = vistaCiudad;
        vistaCiudad.setVisible(true);
    }
    
    public void iniciarControl() {
        
        vistaCiudad.getBtnVolver().addActionListener(l -> mostrarVistaAdmin());

    }
    public   void mostrarVistaAdmin(){
        vistaCiudad.dispose();
        vistaAdministrador vista1 = new vistaAdministrador();
        vista1.setLocationRelativeTo(null);
        vista1.setVisible(true);

        ControladorModuloAdmin controR = new ControladorModuloAdmin(vista1);
        controR.iniciarControl();
    }
    
}
