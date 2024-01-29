package Controlador;

import Modelo.CentroAcopio;
import Modelo.LugarAfectado;
import Modelo.ModeloCentroAcopio;
import Modelo.ModeloLugarAfectado;
import Vista.CRUD_Comprador;
import Vista.CRUD_Donante;
import Vista.Crud_centroAcopio;
import Vista.Crud_lugarAfectado;
import Vista.Registro_Comprador;
import Vista.Registro_Conductor;
import Vista.V_ModuloProducto;
import Vista.V_Principal;
import Vista.crudAdministrador;
import Vista.crudCiudad;
import Vista.crud_Donacion;
import Vista.crud_RegistroDonacion;
import Vista.vistaAdministrador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author IV
 */
public class ControladorModuloAdmin {

    vistaAdministrador vistaModAdmin;
    Crud_lugarAfectado vistaLugarAfectado;
    ModeloCentroAcopio modCA = new ModeloCentroAcopio();
    ModeloLugarAfectado modLA = new ModeloLugarAfectado();
 

    public ControladorModuloAdmin(vistaAdministrador vistaModAdmin) {
        this.vistaModAdmin = vistaModAdmin;
        vistaModAdmin.setVisible(true);

    }
    public void iniciarControl() {
       vistaModAdmin.getBtnCerrarSesion().addActionListener(l -> regresesarMenuPrincipal());
       vistaModAdmin.getJmiRegistroComprador().addActionListener(l -> mostrarCrudComprador());
       vistaModAdmin.getJmiRegistroDonante().addActionListener(l->mostrarCrudDonante());
       vistaModAdmin.getJmiCrudAdmin().addActionListener(l -> mostrarCrudAdmin());
       vistaModAdmin.getBtnCA().addActionListener(e -> cargarTablaCA());
       vistaModAdmin.getJmiModuloProducto().addActionListener(l -> mostrarModuloProductos());
       vistaModAdmin.getRConductor().addActionListener(l -> mostrarCrudConductor());
       
     
       
       //Notocar
       vistaModAdmin.getJmitemRegDonacion().addActionListener(l->mostrarRegistroDonante());
       vistaModAdmin.getJmitemCiudad().addActionListener(l->MostrarCrudCiudad());
       vistaModAdmin.getBtnDonaciones().addActionListener(l->mostrarCrudDonaciones());
       vistaModAdmin.getBtnCentroAcopio().addActionListener(l->mostrarCentroAcopio());
       vistaModAdmin.getBtnLugarAyuda().addActionListener(l-> mostrarCrudLugarAyuda());
       vistaModAdmin.getBtnLA().addActionListener(l->CargarTablaLA());
    } 
    
         public void mostrarCrudConductor() {
        vistaModAdmin.dispose();
        Registro_Conductor vista = new Registro_Conductor();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        Controlador_conductor control = new Controlador_conductor(vista);
        control.iniciarControl();
    }
    
    
    //jose
    public void mostrarRegistroDonante(){
        
        vistaModAdmin.dispose();
        crud_RegistroDonacion vista = new crud_RegistroDonacion();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorCrud_RegistroDonacion controR = new ControladorCrud_RegistroDonacion(vista);
        controR.iniciarControl();      
    }  
    public void MostrarCrudCiudad(){
        
       vistaModAdmin.dispose();
       crudCiudad vista2 = new crudCiudad();
       vista2.setLocationRelativeTo(null);
       vista2.setVisible(true);
       
       controladorCiudad controlC = new controladorCiudad(vista2);
       controlC.iniciarControl();  
    }
       
    public void mostrarCrudDonaciones(){
       vistaModAdmin.dispose();
       crud_Donacion vista2 = new crud_Donacion();
       vista2.setLocationRelativeTo(null);
       vista2.setVisible(true);
       
       controladorDonaciones controlC = new controladorDonaciones(vista2);
       controlC.iniciarControl();    
    }
    
    public void mostrarCentroAcopio(){
       vistaModAdmin.dispose();
       Crud_centroAcopio vista2 = new Crud_centroAcopio();
       vista2.setLocationRelativeTo(null);
       vista2.setVisible(true);
       
       controladorCentroAcopio controlC = new controladorCentroAcopio(vista2);
       controlC.iniciarControl();  
    }
    
    public void mostrarCrudLugarAyuda(){
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
    public void mostrarCrudDonante(){
        vistaModAdmin.dispose();
        CRUD_Donante  vista=new CRUD_Donante();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        ControladorCrudDonante control= new ControladorCrudDonante(vista);
        control.iniciarControl();
    }
    public void mostrarModuloProductos(){
        vistaModAdmin.dispose();
        V_ModuloProducto vista = new V_ModuloProducto();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        ControladorModuloProductos control = new ControladorModuloProductos(vista);
        control.iniciarControl();
    }
}