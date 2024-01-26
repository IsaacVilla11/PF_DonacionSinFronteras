/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Ciudad;
import Modelo.ModeloCiudad;
import Vista.crudCiudad;
import Vista.vistaAdministrador;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jose
 */
public class controladorCiudad {
    
    crudCiudad vistaCiudad;
    ModeloCiudad modCiudad = new ModeloCiudad();

    public controladorCiudad(crudCiudad vistaCiudad) {
        this.vistaCiudad = vistaCiudad;
        vistaCiudad.setVisible(true);
    }

    
    
    public void iniciarControl() {
        
        vistaCiudad.getBtnVolver().addActionListener(l -> mostrarVistaAdmin());
        vistaCiudad.getBtnGuardar().addActionListener(l->RegistrarCiudad());
//        vistaCiudad.getBtnConsultar().addActionListener(l-> consultarCiudad());
        vistaCiudad.getBtnEliminar().addActionListener(l-> eliminarCiudad());
        vistaCiudad.getBtnCargar().addActionListener(l-> cargarTabla());
        vistaCiudad.getBtnModificar().addActionListener(l->modificarCiudad());
        
        vistaCiudad.getTblCiudad().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSeleccionada();
            }
        });
        
   

    }
    public   void mostrarVistaAdmin(){
        vistaCiudad.dispose();
        vistaAdministrador vista1 = new vistaAdministrador();
        vista1.setLocationRelativeTo(null);
        vista1.setVisible(true);

        ControladorModuloAdmin controR = new ControladorModuloAdmin(vista1);
        controR.iniciarControl();
    }
    
    
    private void cargarTabla() {    
        
        try {
        List<Ciudad> listaCiudad = modCiudad.consultarCiudad();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID CIUDAD");
        model.addColumn("NOMBRE CIUDAD");

        for (Ciudad ciudad : listaCiudad) {
            Object[] fila = {
                ciudad.getId_ciudad(),
                ciudad.getNombre_ciud()
            };
                
            model.addRow(fila);
        }
        
        vistaCiudad.getTblCiudad().setModel(model);
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
    }

            
    } 
    public void RegistrarCiudad() { 
        
    try {
        // Verificar que todos los campos estén llenos
        
//        vistaCiudad.getTxtIdCiudad().setEditable(false);
        if (vistaCiudad.getTxtNombreCiudad().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos antes de registrar una ciudad.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Salir del método si algún campo está vacío
        }

        // Asegúrate de que modCiudad no sea null
        if (modCiudad == null) {
            System.out.println("El objeto modCiudad es null");
            return;
        }

        String nombre_ciud = vistaCiudad.getTxtNombreCiudad().getText();
        Ciudad ciudad = new Ciudad(0, nombre_ciud); // ID se generará automáticamente en la base de datos

        // Asegúrate de que el método InsertarCiudad no retorne null
        boolean resultadoInserccion = modCiudad.InsertarCiudad(ciudad);
        if (resultadoInserccion) {
            // Obtener el ID generado automáticamente
            int idGenerado = ciudad.getId_ciudad();

//            // Actualizar la interfaz de usuario con el ID generado
//            

            JOptionPane.showMessageDialog(vistaCiudad, "Registro creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaCiudad, "Error al registrar Ciudad.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(vistaCiudad, "Error en el formato de valores al registrar Ciudad.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
        // Manejar otras excepciones según sea necesario
    }
         
        
    }
    private void eliminarCiudad() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = vistaCiudad.getTblCiudad().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idpersona de la fila seleccionada
            int id_ciudad = (Integer)vistaCiudad.getTblCiudad().getValueAt(filaSeleccionada, 0);

            // Lógica para eliminar la persona con el idpersona obtenido
            if (modCiudad.eliminarCiudad(id_ciudad)) {
                JOptionPane.showMessageDialog(null, "Ciudad eliminado satisfactoriamente");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar la ciudad, existe una relacion");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una Ciudad para eliminar");
        }
    }
    private void modificarCiudad() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = vistaCiudad.getTblCiudad().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idCine de la fila seleccionada
            int id_ciudad = (Integer)vistaCiudad.getTblCiudad().getValueAt(filaSeleccionada, 0);

            // Obtener los nuevos valores de los campos de texto
           
            String nuevoNombre = vistaCiudad.getTxtNombreCiudad().getText();


            // Lógica para modificar el cine con los nuevos valores
            if (modCiudad.modificarCiudad(id_ciudad,nuevoNombre)) {
                JOptionPane.showMessageDialog(vistaCiudad, "Ciudad modificada satisfactoriamente");
                cargarTabla(); // Método para actualizar la tabla después de la modificación
            } else {
                JOptionPane.showMessageDialog(vistaCiudad, "Error al modificar la ciudad");
            }
        } else {
            JOptionPane.showMessageDialog(vistaCiudad, "Seleccione una ciudad para modificar");
        }
    }
    
    private void limpiarCampos() {      
        vistaCiudad.getTxtNombreCiudad().setText("");   
    }
    
    private void filaSeleccionada() {
    int filaSeleccionada = vistaCiudad.getTblCiudad().getSelectedRow();
    
    if (filaSeleccionada != -1) {
        int id_ciudad = (Integer) vistaCiudad.getTblCiudad().getValueAt(filaSeleccionada, 0);

        // Obtener los detalles del cine seleccionado
        Ciudad cine = modCiudad.obtenerDetallesCiudad(id_ciudad);

        // Cargar los datos en los campos de texto
           
       vistaCiudad.getTxtNombreCiudad().setText(cine.getNombre_ciud());      
    }}
    
    
}