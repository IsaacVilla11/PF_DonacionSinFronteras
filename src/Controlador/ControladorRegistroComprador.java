package Controlador;

import Vista.Login_Comprador;
import Vista.Registro_Comprador;

/**
 *
 * @author IV
 */
public class ControladorRegistroComprador {

    Registro_Comprador vistaRegCom;

    public ControladorRegistroComprador(Registro_Comprador vistaRegCom) {
        this.vistaRegCom = vistaRegCom;
        vistaRegCom.setVisible(true);

    }

    public void iniciarControl() {
        vistaRegCom.getBtnGuardar().addActionListener(l -> crearComprador());
        vistaRegCom.getBtnAtras().addActionListener(l -> IrLoginComprador());
        
    }

    public void crearComprador() {
        System.out.println("Crear codigo");
    }

    public void IrLoginComprador() {
        vistaRegCom.dispose();
        Login_Comprador vista = new Login_Comprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        ControladorLoginComprador control = new ControladorLoginComprador(vista);
        control.iniciarControl();
    }
    

}
