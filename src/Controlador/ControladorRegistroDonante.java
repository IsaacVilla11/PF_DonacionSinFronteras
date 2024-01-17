package Controlador;

import Vista.Login_Donador;
import Vista.Registro_Donante;

/**
 *
 * @author IV
 */
public class ControladorRegistroDonante {

    Registro_Donante vistaRegDon;

    public ControladorRegistroDonante(Registro_Donante vistaRegDon) {
        this.vistaRegDon = vistaRegDon;
        vistaRegDon.setVisible(true);
    }

    public void iniciarControl() {
        vistaRegDon.getBTNCrear().addActionListener(l -> crearDonador());
        vistaRegDon.getBtnregresodonate().addActionListener(l -> IrLoginDonador());

    }

    public void crearDonador() {
        //Crear Codigo
    }

    public void IrLoginDonador() {
        vistaRegDon.dispose();
        Login_Donador vista = new Login_Donador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLoginDonador control = new ControladorLoginDonador(vista);
        control.iniciarControl();
    }
}
