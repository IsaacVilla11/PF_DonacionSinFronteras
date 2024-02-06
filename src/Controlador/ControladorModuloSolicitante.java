package Controlador;

import static Controlador.ControladorModuloComprador.ShowJPanel;
import Modelo.ModeloSolicitante;
import Modelo.ModeloSolicitud;
import Vista.VA_Solicitudes;
import Vista.V_Principal;
import Vista.V_Solicitante;
import Vista.VS_Inicio;
import Vista.VS_SolicitarDonacion;
import Vista.VS_EstadoSolicitud;
import javax.swing.JPanel;
import static Vista.V_Solicitante.Contenido;
import java.awt.BorderLayout;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author IV
 */
public class ControladorModuloSolicitante {

    VA_Solicitudes vistaModSolicitudes;
    String cedula;
    V_Solicitante vistaSoli;

    public ControladorModuloSolicitante(V_Solicitante vistaSoli, String cedula) {
        this.cedula = cedula;
        this.vistaSoli = vistaSoli;
        vistaSoli.setVisible(true);
        VentanaInicio();
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
        
        view.getBtnEnviarSolic().addActionListener(l -> RegistrarSolicitud(view));
    }
    
    public void EstadoSolicitud(){
        VS_EstadoSolicitud view = new VS_EstadoSolicitud();
        ShowJPanel(view);
    }
    
    public void RegistrarSolicitud(VS_SolicitarDonacion view){

        ModeloSolicitud solicud = new ModeloSolicitud();
        ModeloSolicitante solctnt = new ModeloSolicitante();
        
        try {
        
            LocalDate fechaFactura = LocalDate.now();
            solicud.setFecha_soli(java.sql.Date.valueOf(fechaFactura));
            
            String requerimientos = view.getjTextAreaREQUERIMIENTOS().getText();
            if (!Validaciones.validarLetras(requerimientos)) {
                JOptionPane.showMessageDialog(view, "Requerimientos incorrectos. Ingrese de nuevo");
                return;
            }
            solicud.setRazon_soli(requerimientos);
            
            solicud.setId_solicitante_soli(solicud.traerCodigoDePersona(cedula));
            
            if (solicud.insertarSolicitud(solicud.traerCodigoDePersona(cedula))) {
                
                int idSolicidtud = solicud.obtenerUltimoIdSolicitud();
                
                if (idSolicidtud > 0) {
                    // Asignar el id_encabezadoFact al modelo DetalleFactura
                    solctnt.setId_solicitante(idSolicidtud);
                    
                    JOptionPane.showMessageDialog(view, "SOLICITUD ENVIADA: Uno De Nuestros Representantes Analizara Su Solicitud Y Se Comunicara Con Ud. En Las Proximas 24 Horas");
    
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo obtener el id_encabezadoFact");
                }
                                       
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo Enviar la Solicitud");
            }
                              
        } catch (Exception e){
            // Manejo de la excepción
        }
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
