package Controlador;

import static Controlador.ControladorModuloComprador.ShowJPanel;
import Vista.V_Principal;
import Vista.V_Solicitante;
import Vista.VS_Inicio;
import Vista.VS_SolicitarDonacion;
import Vista.VS_EstadoSolicitud;
import javax.swing.JPanel;
import static Vista.V_Solicitante.Contenido;
import java.awt.BorderLayout;

/**
 *
 * @author IV
 */
public class ControladorModuloSolicitante {

    V_Solicitante vistaSoli;

    public ControladorModuloSolicitante(V_Solicitante vistaSoli) {
        this.vistaSoli = vistaSoli;
        vistaSoli.setVisible(true);
    }

    public void iniciarControl() {
        vistaSoli.getBtnregresar().addActionListener(l -> regresesarMenuPrincipal());
        vistaSoli.getBtnInicio().addActionListener(l -> VentanaInicio());
        vistaSoli.getBtnSolicitar().addActionListener(l -> SolicitarDonacion());
        vistaSoli.getBtnEstadoSol().addActionListener(l -> EstadoSolicitud());

    }

    public void VentanaInicio() {
        VS_Inicio view = new VS_Inicio();
        ShowJPanel(view);
    }
    
    public void regresesarMenuPrincipal() {
        vistaSoli.dispose();
        V_Principal vista = new V_Principal();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorMenuPrincipal controP = new ControladorMenuPrincipal(vista);
        controP.iniciarControl();

    }
    
    public void SolicitarDonacion() {
        VS_SolicitarDonacion view = new VS_SolicitarDonacion();
        ShowJPanel(view);
    }
    
    public void EstadoSolicitud(){
        VS_EstadoSolicitud view = new VS_EstadoSolicitud();
        ShowJPanel(view);
    }
    
    public static void ShowJPanel(JPanel p) {
        p.setSize(960, 685);
        p.setLocation(0, 0);

        Contenido.removeAll();
        Contenido.add(p, BorderLayout.CENTER);
        Contenido.revalidate();
        Contenido.repaint();
    }
    
}
