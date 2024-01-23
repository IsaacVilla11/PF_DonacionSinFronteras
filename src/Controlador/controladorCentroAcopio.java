/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.Crud_centroAcopio;
import Vista.vistaAdministrador;
/**
 *
 * @author jose
 */
public class controladorCentroAcopio {
    
    Crud_centroAcopio vistaCentroAcopio;

    public controladorCentroAcopio(Crud_centroAcopio vistaCentroAcopio) {
        this.vistaCentroAcopio = vistaCentroAcopio;
        vistaCentroAcopio.setVisible(true);
    }
    public void iniciarControl() {
        vistaCentroAcopio.getBtnVolver().addActionListener(l -> mostrarVistaAdmin());
        
    }
        public   void mostrarVistaAdmin(){
        vistaCentroAcopio.dispose();
        vistaAdministrador vista1 = new vistaAdministrador();
        vista1.setLocationRelativeTo(null);
        vista1.setVisible(true);

        ControladorModuloAdmin controR = new ControladorModuloAdmin(vista1);
        controR.iniciarControl();
    }
    
}
