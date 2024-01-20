package Controlador;

import Modelo.Comprador;
import Modelo.ModeloComprador;
import Vista.Login_Comprador;
import Vista.Registro_Comprador;
import Vista.V_Comprador;
import Vista.V_Principal;
import Vista.vistaLogins;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author IV
 */
public class ControladorLoginComprador {

    Login_Comprador LoginCom;

    public ControladorLoginComprador(Login_Comprador LoginCom) {
        this.LoginCom = LoginCom;
        LoginCom.setVisible(true);
    }

    public void iniciarControl() {
        LoginCom.getBtnIniciarSesionComprador().addActionListener(l -> LoginComprador());
        LoginCom.getBtnRegistrarComprador().addActionListener(l -> registroComprador());
        LoginCom.getBtnRegresar().addActionListener(l -> regresesarMenuLogins());

    }

    public void iniciarSesion() {
        LoginCom.dispose();
        V_Comprador vista = new V_Comprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloComprador control = new ControladorModuloComprador(vista);
        control.iniciarControl();
    }

    public void registroComprador() {
        LoginCom.dispose();
        Registro_Comprador vista = new Registro_Comprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorRegistroComprador control = new ControladorRegistroComprador(vista);
        control.iniciarControl();
    }

       // Método para Credenciales  login del comprador
    public void LoginComprador() {
       ModeloComprador modCompra = new ModeloComprador();
        List<Comprador> com = modCompra.ListaComprador();

        boolean bandera = modCompra.ConsultarComprador(LoginCom.getTxtUsuario().getText(), LoginCom.getTxtContrasenia().getText(), com);

        if (bandera) {
            iniciarSesion();
            LoginCom.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecto");
            limpiarcampos();
        }
    }
    public void limpiarcampos(){
        LoginCom.getTxtUsuario().setText("");
        LoginCom.getTxtContrasenia().setText("");
    }
    public void regresesarMenuLogins() {
        LoginCom.dispose();
        vistaLogins vista = new vistaLogins();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorLogins control = new ControladorLogins(vista);
        control.iniciarControl();

    }

}
