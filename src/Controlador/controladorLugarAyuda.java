/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.LugarAfectado;
import Modelo.ModeloLugarAfectado;
import Vista.Crud_lugarAfectado;
import Vista.vistaAdministrador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jose
 */
public class controladorLugarAyuda {
    
    Crud_lugarAfectado vistaLugarAfectdo;
    ModeloLugarAfectado modLugarA = new ModeloLugarAfectado();

    public controladorLugarAyuda(Crud_lugarAfectado vistaLugarAfectdo) {
        this.vistaLugarAfectdo = vistaLugarAfectdo;
        vistaLugarAfectdo.setVisible(true);
    }
    public void iniciarControl() {
        
        vistaLugarAfectdo.getBtnVolver().addActionListener(l -> mostrarVistaAdmin());
        vistaLugarAfectdo.getBtnGuardar().addActionListener(l->RegistrarLA());
        vistaLugarAfectdo.getBtnVer().addActionListener(l->cargarTabla());
        vistaLugarAfectdo.getBtnEliminar().addActionListener(l->eliminarLA());
        vistaLugarAfectdo.getBtnModificar().addActionListener(l->modificarCA());
//        
        List<String> nombresCiudades = modLugarA.obtenerCiudades();
        for (String ciudadFormato : nombresCiudades) {
            vistaLugarAfectdo.getCbCiudad().addItem(ciudadFormato);
        }
        vistaLugarAfectdo.getTableLA().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSeleccionada();
            }
        });
       

    }
    public   void mostrarVistaAdmin(){
        vistaLugarAfectdo.dispose();
        vistaAdministrador vista1 = new vistaAdministrador();
        vista1.setLocationRelativeTo(null);
        vista1.setVisible(true);

        ControladorModuloAdmin controR = new ControladorModuloAdmin(vista1);
        controR.iniciarControl();
    }
    
    private void cargarTabla() {    
      try {
        List<LugarAfectado> listaCa = modLugarA.consultarLA();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ESTADO");
        model.addColumn("ID LUGAR");
        model.addColumn("NOMBRE");
        model.addColumn("DIRECCION");
        model.addColumn("CIUDAD");

        for (LugarAfectado centro : listaCa) {
            String nombreCiudad = modLugarA.obtenerNombreCiudad(centro.getId_ciudad());

            Object[] fila = {
                centro.getEstado_luaf(),             
                centro.getId_lug(),
                centro.getNombre_lug(),
                centro.getDireccion_lug(),
                nombreCiudad // Mostrar solo el nombre de la ciudad
            };

            model.addRow(fila);
        }

        vistaLugarAfectdo.getTableLA().setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }   
    public void RegistrarLA() {      
    try {   
        if (vistaLugarAfectdo.getTxtNombre().getText().isEmpty() || vistaLugarAfectdo.getTxtDireccion().getText().isEmpty()
                || vistaLugarAfectdo.getTxtDescribcion().getText().isEmpty() || vistaLugarAfectdo.getCbEstado().getSelectedItem()==null
                ||  vistaLugarAfectdo.getCbCiudad().getSelectedItem()==null) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos antes de registrar un LugarAfectado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Salir del método si algún campo está vacío
        }
        // Asegúrate de que modCiudad no sea null
        if (modLugarA == null) {
            System.out.println("El objeto modCiudad es null");
            return;
        }
        String Situacion = vistaLugarAfectdo.getTxtDescribcion().getText();
        String Estado = vistaLugarAfectdo.getCbEstado().getSelectedItem().toString();
        String nombreLA = vistaLugarAfectdo.getTxtNombre().getText();
        String DireccionAA =vistaLugarAfectdo.getTxtDireccion().getText();
        int id_ciudad = Integer.parseInt(vistaLugarAfectdo.getCbCiudad().getSelectedItem().toString().split(":")[0]);
        LugarAfectado centro = new LugarAfectado(0, Situacion,Estado,0,nombreLA,DireccionAA,id_ciudad); // ID se generará automáticamente en la base de datos

        // Asegúrate de que el método InsertarCiudad no retorne null
        boolean resultadoInserccion = modLugarA.insertarLugarAF(centro);
        if (resultadoInserccion) {
            // Obtener el ID generado automáticamente
            int idGenerado = centro.getId_lug();
            int rucGenerado = centro.getId_lugarAf();

//            // Actualizar la interfaz de usuario con el ID generado          

            JOptionPane.showMessageDialog(vistaLugarAfectdo, "Registro creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
//            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaLugarAfectdo, "Error al registrar el Lugar Afectado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(vistaLugarAfectdo, "Error en el formato de valores al registrar el centro de Acopio.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
        // Manejar otras excepciones según sea necesario
    }}    
    private void eliminarLA() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = vistaLugarAfectdo.getTableLA().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idpersona de la fila seleccionada
            int id_ca = (Integer)vistaLugarAfectdo.getTableLA().getValueAt(filaSeleccionada, 1);

            // Lógica para eliminar la persona con el idpersona obtenido
            if (modLugarA.eliminarLugarAf(id_ca)) {
                JOptionPane.showMessageDialog(vistaLugarAfectdo, "Lugar Afectado eliminado satisfactoriamente");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(vistaLugarAfectdo, "Error al eliminar el Lugar afectado de acopio, existe una relacion");
            }
        } else {
            JOptionPane.showMessageDialog(vistaLugarAfectdo, "Seleccione un LegarAfectado para eliminar");
        }
    }
    private void modificarCA() {
    // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = vistaLugarAfectdo.getTableLA().getSelectedRow();

    if (filaSeleccionada != -1) {
        // Obtener el centro de acopio de la fila seleccionada
       int id_lugar = (Integer) vistaLugarAfectdo.getTableLA().getValueAt(filaSeleccionada, 1);     

        // Obtener los nuevos valores de los campos de texto
        String nuevoNombre = vistaLugarAfectdo.getTxtNombre().getText();
        String nuevaDireccion = vistaLugarAfectdo.getTxtDireccion().getText();
        String nuevoSituacion = vistaLugarAfectdo.getTxtDescribcion().getText();
        String nuevoEstado= vistaLugarAfectdo.getCbEstado().getSelectedItem().toString();
        int nuevaIdCiudad = Integer.parseInt(vistaLugarAfectdo.getCbCiudad().getSelectedItem().toString().split(":")[0]);

        // Lógica para modificar el centro de acopio
        if (modLugarA.modificarLugarAF(nuevoSituacion,nuevoEstado,id_lugar,nuevoNombre,nuevaDireccion,nuevaIdCiudad)) {
            JOptionPane.showMessageDialog(vistaLugarAfectdo, "Centro de Acopio modificado satisfactoriamente");
            cargarTabla(); // Método para actualizar la tabla después de la modificación
        } else {
            JOptionPane.showMessageDialog(vistaLugarAfectdo, "Error al modificar el LugarAfectado");
        }
    } else {
        JOptionPane.showMessageDialog(vistaLugarAfectdo, "Seleccione un lugar de ayuda para modificar");
    }
    }
    
    private void filaSeleccionada() {
     int filaSeleccionada = vistaLugarAfectdo.getTableLA().getSelectedRow();

      if (filaSeleccionada == -1) {
          JOptionPane.showMessageDialog(null, "Seleccione una fila para ver los detalles del Centro de Acopio");
          return;
      }

      int id_lugar = (Integer) vistaLugarAfectdo.getTableLA().getValueAt(filaSeleccionada, 1);
     

      LugarAfectado centro = modLugarA.obtenerDetallesLugarAf(id_lugar);

      if (centro == null) {
          JOptionPane.showMessageDialog(null, "Error al obtener los detalles del Centro de Acopio");
          return;
      }

    // Cargar los datos en los campos de texto
    vistaLugarAfectdo.getCbEstado().setSelectedItem(centro.getEstado_luaf());
    vistaLugarAfectdo.getTxtNombre().setText(centro.getNombre_lug()); 
    vistaLugarAfectdo.getTxtDireccion().setText(centro.getDireccion_lug());
    vistaLugarAfectdo.getTxtDescribcion().setText(centro.getSituacion_luaf());
    vistaLugarAfectdo.getCbCiudad().setSelectedItem(centro.getId_ciudad() + ": " + modLugarA.obtenerNombreCiudad(centro.getId_ciudad()));
}
}
