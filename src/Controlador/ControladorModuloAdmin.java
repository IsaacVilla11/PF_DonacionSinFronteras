package Controlador;

import Modelo.CentroAcopio;
import Modelo.Administrador;
import Modelo.LugarAfectado;
import Modelo.ModeloAdministrador;
import Modelo.ModeloCentroAcopio;
import Modelo.ModeloLugarAfectado;
import Vista.CRUD_Comprador;
import Vista.CRUD_Donante;
import Vista.CRUD_Solicitante;
import Vista.Crud_centroAcopio;
import Vista.Crud_lugarAfectado;
import Vista.Registro_Camion;
import Vista.Registro_Comprador;
import Vista.Registro_Conductor;
import Vista.Registro_trasporte;
import Vista.VA_Solicitudes;
import Vista.V_EstadoSolicitud;
import Vista.V_ModuloProducto;
import Vista.V_Principal;
import Vista.crudAdministrador;
import Vista.crudCiudad;
import Vista.crud_Donacion;
import Vista.vistaAdministrador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JList;

/**
 *
 * @author IV
 */
public class ControladorModuloAdmin {

    vistaAdministrador vistaModAdmin;
    Crud_lugarAfectado vistaLugarAfectado;
    ModeloCentroAcopio modCA = new ModeloCentroAcopio();
    ModeloLugarAfectado modLA = new ModeloLugarAfectado();
    ModeloAdministrador modAdministrador = new ModeloAdministrador();
    private JList<String> adminList;

    public ControladorModuloAdmin(vistaAdministrador vistaModAdmin) {
        this.vistaModAdmin = vistaModAdmin;
        vistaModAdmin.setVisible(true);
        cargarAdministradores();

    }

    public void iniciarControl() {
        
        vistaModAdmin.getBtnLists().addActionListener(l->cargarAdministradores());
        vistaModAdmin.getBtnCerrarSesion().addActionListener(l -> regresesarMenuPrincipal());
        vistaModAdmin.getJmiRegistroComprador().addActionListener(l -> mostrarCrudComprador());
        vistaModAdmin.getJmiRegistroDonante().addActionListener(l -> mostrarCrudDonante());
        vistaModAdmin.getJmiCrudAdmin().addActionListener(l -> mostrarCrudAdmin());
        vistaModAdmin.getBtnCA().addActionListener(e -> cargarTablaCA());
        vistaModAdmin.getJmiModuloProducto().addActionListener(l -> mostrarModuloProductos());
        vistaModAdmin.getRConductor().addActionListener(l -> mostrarCrudConductor());
        vistaModAdmin.getJmiCrudSolicitante().addActionListener(l -> mostrarCrudSolicitante());
        vistaModAdmin.getJmiRegistroTransporte().addActionListener(l -> mostrarRTrasporte());
        vistaModAdmin.getRcamiones().addActionListener(l -> mostrarCrudCamion());
        vistaModAdmin.getBtnSolicitudes().addActionListener(l -> mostrarSolicitudes());

        //No tocar
        vistaModAdmin.getJmitemCiudad().addActionListener(l -> MostrarCrudCiudad());
        vistaModAdmin.getBtnDonaciones().addActionListener(l -> mostrarCrudDonaciones());
        vistaModAdmin.getBtnCentroAcopio().addActionListener(l -> mostrarCentroAcopio());
        vistaModAdmin.getBtnLugarAyuda().addActionListener(l -> mostrarCrudLugarAyuda());
        vistaModAdmin.getBtnLA().addActionListener(l -> CargarTablaLA());
    }

    public void mostrarCrudCamion() {
        vistaModAdmin.dispose();
        Registro_Camion vista = new Registro_Camion();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorRegistroCamion control = new ControladorRegistroCamion(vista);
        control.iniciarControl();
    }

    public void mostrarCrudConductor() {
        vistaModAdmin.dispose();
        Registro_Conductor vista = new Registro_Conductor();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        Controlador_conductor control = new Controlador_conductor(vista);
        control.iniciarControl();
    }

    public void mostrarRTrasporte() {
        vistaModAdmin.dispose();
        Registro_trasporte vista = new Registro_trasporte();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorRegistroTrasporte control = new ControladorRegistroTrasporte(vista);
        control.iniciarControl();
    }

    //jose


    public void MostrarCrudCiudad() {

        vistaModAdmin.dispose();
        crudCiudad vista2 = new crudCiudad();
        vista2.setLocationRelativeTo(null);
        vista2.setVisible(true);

        controladorCiudad controlC = new controladorCiudad(vista2);
        controlC.iniciarControl();
    }

    public void mostrarCrudDonaciones() {
        vistaModAdmin.dispose();
        crud_Donacion vista2 = new crud_Donacion();
        vista2.setLocationRelativeTo(null);
        vista2.setVisible(true);

        controladorDonaciones controlC = new controladorDonaciones(vista2);
        controlC.iniciarControl();
    }

    public void mostrarCentroAcopio() {
        vistaModAdmin.dispose();
        Crud_centroAcopio vista2 = new Crud_centroAcopio();
        vista2.setLocationRelativeTo(null);
        vista2.setVisible(true);

        controladorCentroAcopio controlC = new controladorCentroAcopio(vista2);
        controlC.iniciarControl();
    }

    public void mostrarCrudLugarAyuda() {
        vistaModAdmin.dispose();
        Crud_lugarAfectado vista2 = new Crud_lugarAfectado();
        vista2.setLocationRelativeTo(null);
        vista2.setVisible(true);

        controladorLugarAyuda controlC = new controladorLugarAyuda(vista2);
        controlC.iniciarControl();
    }

    private void cargarTablaCA() {
        try {
            List<CentroAcopio> listaCa = modCA.consultarCA();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("RUC");
            model.addColumn("CAPACIDAD");
            model.addColumn("ID LUGAR");
            model.addColumn("NOMBRE");
            model.addColumn("DIRECCION");
            model.addColumn("CIUDAD");

            for (CentroAcopio centro : listaCa) {
                String nombreCiudad = modCA.obtenerNombreCiudad(centro.getId_ciudad());

                Object[] fila = {
                    centro.getRuc_ca(),
                    centro.getCapacidad_ca(),
                    centro.getId_lug(),
                    centro.getNombre_lug(),
                    centro.getDireccion_lug(),
                    nombreCiudad // Mostrar solo el nombre de la ciudad
                };

                model.addRow(fila);
            }

            vistaModAdmin.getTableRegistros().setModel(model);
            vistaModAdmin.getLblmsjRegistro().setText("Registro de Centros de Acopio:");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CargarTablaLA() {
        try {
            List<LugarAfectado> listaCa = modLA.consultarLA();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ESTADO");
            model.addColumn("ID LUGAR");
            model.addColumn("NOMBRE");
            model.addColumn("DIRECCION");
            model.addColumn("CIUDAD");

            for (LugarAfectado centro : listaCa) {
                String nombreCiudad = modLA.obtenerNombreCiudad(centro.getId_ciudad());

                Object[] fila = {
                    centro.getEstado_luaf(),
                    centro.getId_lug(),
                    centro.getNombre_lug(),
                    centro.getDireccion_lug(),
                    nombreCiudad // Mostrar solo el nombre de la ciudad
                };

                model.addRow(fila);
            }

            vistaModAdmin.getTableRegistros().setModel(model);
            vistaModAdmin.getLblmsjRegistro().setText("Registro de Lugares Afectados:");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
private void cargarAdministradores() {
    DefaultListModel<String> model = new DefaultListModel<>();
    vistaModAdmin.getListAdm().setModel(model);

    List<Administrador> administradores = modAdministrador.obtenerNombresApellidosDonantes(0); // Suponiendo que este método retorna la lista de administradores

    for (Administrador administrador : administradores) {
        String administradorString = administrador.getId_adm()+ ": " + administrador.getNombre_usu() + " " + administrador.getApellido_usu();
        model.addElement(administradorString);
    }
}

    //No tocar ////////

    public void regresesarMenuPrincipal() {
        vistaModAdmin.dispose();
        V_Principal vista = new V_Principal();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorMenuPrincipal controP = new ControladorMenuPrincipal(vista);
        controP.iniciarControl();
    }

    public void mostrarCrudComprador() {
        vistaModAdmin.dispose();
        CRUD_Comprador vista = new CRUD_Comprador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorCrudComprador control = new ControladorCrudComprador(vista);
        control.iniciarControl();
    }

    public void mostrarCrudAdmin() {
        vistaModAdmin.dispose();
        crudAdministrador vista = new crudAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorCrudAdmin control = new ControladorCrudAdmin(vista);
        control.iniciarControl();
    }

    public void mostrarCrudDonante() {
        vistaModAdmin.dispose();
        CRUD_Donante vista = new CRUD_Donante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorCrudDonante control = new ControladorCrudDonante(vista);
        control.iniciarControl();
    }

    public void mostrarModuloProductos() {
        vistaModAdmin.dispose();
        V_ModuloProducto vista = new V_ModuloProducto();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloProductos control = new ControladorModuloProductos(vista);
        control.iniciarControl();
    }

    public void mostrarCrudSolicitante() {
        vistaModAdmin.dispose();
        CRUD_Solicitante vista = new CRUD_Solicitante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorCrudSolicitante control = new ControladorCrudSolicitante(vista);
        control.iniciarControl();
    }
    
    public void mostrarSolicitudes() {
        vistaModAdmin.dispose();
        VA_Solicitudes vista = new VA_Solicitudes();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        vista.getBtnAprobar().addActionListener(l -> mostrarEstadoSoli()); 
        vista.getBtnRegresar().addActionListener(l -> regresesarMenuAdmin()); 
        //ControladorModuloSolicitante control = new ControladorModuloSolicitante(vista);
        //control.iniciarControl();
    }
    
    public void mostrarEstadoSoli() {
        vistaModAdmin.dispose();
        V_EstadoSolicitud vista = new V_EstadoSolicitud();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        vista.getBtnRegresar().addActionListener(l -> regresesarMenuAdmin());
        //ControladorCrudSolicitante control = new ControladorCrudSolicitante(vista);
        //control.iniciarControl();
    }
    public void regresesarMenuAdmin() {
        //vistaModAdmin.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }
    
}
