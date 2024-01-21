package Controlador;

import Vista.VC_Inicio;
import Vista.VC_Productos;
import Vista.VC_Reporte;
import Vista.V_Comprador;
import static Vista.V_Comprador.Contenido;
import Vista.V_Principal;
import Vista.vistaAdministrador;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author IV
 */
public class ControladorModuloComprador {

    V_Comprador vistaModCom;

    public ControladorModuloComprador(V_Comprador vistaModCom) {
        this.vistaModCom = vistaModCom;
        vistaModCom.setVisible(true);
        ShowJPanel(new VC_Inicio());
    }

    public void iniciarControl() {
        vistaModCom.getBtnregresar().addActionListener(l -> regresesarMenuPrincipal());
        vistaModCom.getBtnInicio().addActionListener(l-> VentanaInicio());
        vistaModCom.getBtnProductos().addActionListener(l->productoVenta());
        vistaModCom.getBtnReporte().addActionListener(l-> reporteCompras());
    }

    public void regresesarMenuPrincipal() {
        vistaModCom.dispose();
        V_Principal vista = new V_Principal();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorMenuPrincipal controP = new ControladorMenuPrincipal(vista);
        controP.iniciarControl();

    }
    
    public void productoVenta(){
        ShowJPanel(new VC_Productos());
    }
    public void VentanaInicio(){
        ShowJPanel(new VC_Inicio());
    }
    public void reporteCompras(){
        ShowJPanel(new VC_Reporte());
    }
    
    public static void ShowJPanel(JPanel p) {
        p.setSize(897, 547);
        p.setLocation(0, 0);

        Contenido.removeAll();
        Contenido.add(p, BorderLayout.CENTER);
        Contenido.revalidate();
        Contenido.repaint();
    }

}
