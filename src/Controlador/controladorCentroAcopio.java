/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.CentroAcopio;
import Modelo.ModeloCentroAcopio;
import Vista.Crud_centroAcopio;
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
public class controladorCentroAcopio {
    
    Crud_centroAcopio vistaCentroAcopio;
    ModeloCentroAcopio modCA = new ModeloCentroAcopio();

    public controladorCentroAcopio(Crud_centroAcopio vistaCentroAcopio) {
        this.vistaCentroAcopio = vistaCentroAcopio;
        vistaCentroAcopio.setVisible(true);
    }
    public void iniciarControl() {
        vistaCentroAcopio.getBtnVolver().addActionListener(l -> mostrarVistaAdmin());
        vistaCentroAcopio.getBtnGuardar().addActionListener(l->RegistrarCA());
        vistaCentroAcopio.getBtnVerRegistros().addActionListener(l->cargarTabla());
        vistaCentroAcopio.getBtnEliminar().addActionListener(l->eliminarCA());
        vistaCentroAcopio.getBtnModificar().addActionListener(l->modificarCA());
 
        
        List<String> nombresCiudades = modCA.obtenerCiudades();
        for (String ciudadFormato : nombresCiudades) {
            vistaCentroAcopio.getCbCiudad().addItem(ciudadFormato);
        }
        vistaCentroAcopio.getTableCA().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSeleccionada();
            }
        });
        
    }
        public   void mostrarVistaAdmin(){
        vistaCentroAcopio.dispose();
        vistaAdministrador vista1 = new vistaAdministrador();
        vista1.setLocationRelativeTo(null);
        vista1.setVisible(true);

        ControladorModuloAdmin controR = new ControladorModuloAdmin(vista1);
        controR.iniciarControl();
    }

    private void cargarTabla() {    
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

        vistaCentroAcopio.getTableCA().setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public void RegistrarCA() {      
    try {   
        if (vistaCentroAcopio.getTxtNombre().getText().isEmpty() || vistaCentroAcopio.getTxtDireccion().getText().isEmpty()
                || vistaCentroAcopio.getSpnCapacidad().getValue()== null || vistaCentroAcopio.getCbCiudad().getSelectedItem()==null) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos antes de registrar un Centro de acopio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Salir del método si algún campo está vacío
        }
        // Asegúrate de que modCiudad no sea null
        if (modCA == null) {
            System.out.println("El objeto modCiudad es null");
            return;
        }
        String nombreCA = vistaCentroAcopio.getTxtNombre().getText();
        String DireccionCA =vistaCentroAcopio.getTxtDireccion().getText();
        int Capacidad = Integer.parseInt(vistaCentroAcopio.getSpnCapacidad().getValue().toString());
        int id_ciudad = Integer.parseInt(vistaCentroAcopio.getCbCiudad().getSelectedItem().toString().split(":")[0]);
        CentroAcopio centro = new CentroAcopio(0, Capacidad,0,nombreCA,DireccionCA,id_ciudad); // ID se generará automáticamente en la base de datos

        // Asegúrate de que el método InsertarCiudad no retorne null
        boolean resultadoInserccion = modCA.insertarCentroAcopio(centro);
        if (resultadoInserccion) {
            // Obtener el ID generado automáticamente
            int idGenerado = centro.getId_lug();
            int rucGenerado = centro.getRuc_ca();

//            // Actualizar la interfaz de usuario con el ID generado          

            JOptionPane.showMessageDialog(vistaCentroAcopio, "Registro creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
//            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaCentroAcopio, "Error al registrar el centro de acopio.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(vistaCentroAcopio, "Error en el formato de valores al registrar el centro de acopio.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
        // Manejar otras excepciones según sea necesario
    }}
    
    private void eliminarCA() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = vistaCentroAcopio.getTableCA().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idpersona de la fila seleccionada
            int id_ca = (Integer)vistaCentroAcopio.getTableCA().getValueAt(filaSeleccionada, 0);

            // Lógica para eliminar la persona con el idpersona obtenido
            if (modCA.eliminarCA(id_ca)) {
                JOptionPane.showMessageDialog(vistaCentroAcopio, "Centro de Acopio eliminado satisfactoriamente");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(vistaCentroAcopio, "Error al eliminar el Centro de acopio, existe una relacion");
            }
        } else {
            JOptionPane.showMessageDialog(vistaCentroAcopio, "Seleccione un Centro de Acopio para eliminar");
        }
    }

    private void modificarCA() {
    // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = vistaCentroAcopio.getTableCA().getSelectedRow();

    if (filaSeleccionada != -1) {
        // Obtener el centro de acopio de la fila seleccionada
       int id_lugar = (Integer) vistaCentroAcopio.getTableCA().getValueAt(filaSeleccionada, 0);     

        // Obtener los nuevos valores de los campos de texto
        String nuevoNombre = vistaCentroAcopio.getTxtNombre().getText();
        String nuevaDireccion = vistaCentroAcopio.getTxtDireccion().getText();
        int nuevaCapacidad = Integer.parseInt(vistaCentroAcopio.getSpnCapacidad().getValue().toString());
        int nuevaIdCiudad = Integer.parseInt(vistaCentroAcopio.getCbCiudad().getSelectedItem().toString().split(":")[0]);

        // Lógica para modificar el centro de acopio
        if (modCA.modificarCentroAcopio(nuevaCapacidad,id_lugar,nuevoNombre,nuevaDireccion,nuevaIdCiudad)) {
            JOptionPane.showMessageDialog(vistaCentroAcopio, "Centro de Acopio modificado satisfactoriamente");
            cargarTabla(); // Método para actualizar la tabla después de la modificación
        } else {
            JOptionPane.showMessageDialog(vistaCentroAcopio, "Error al modificar el centro de acopio");
        }
    } else {
        JOptionPane.showMessageDialog(vistaCentroAcopio, "Seleccione un centro de acopio para modificar");
    }
}
    
    private void filaSeleccionada() {
      int filaSeleccionada = vistaCentroAcopio.getTableCA().getSelectedRow();

      if (filaSeleccionada == -1) {
          JOptionPane.showMessageDialog(null, "Seleccione una fila para ver los detalles del Centro de Acopio");
          return;
      }

      int id_lugar = (Integer) vistaCentroAcopio.getTableCA().getValueAt(filaSeleccionada, 0);
      int ruc_ca = (Integer) vistaCentroAcopio.getTableCA().getValueAt(filaSeleccionada, 1);

      CentroAcopio centro = modCA.obtenerDetallesCA(id_lugar);

      if (centro == null) {
          JOptionPane.showMessageDialog(null, "Error al obtener los detalles del Centro de Acopio");
          return;
      }

      // Cargar los datos en los campos de texto
      vistaCentroAcopio.getTxtNombre().setText(centro.getNombre_lug()); 
      vistaCentroAcopio.getTxtDireccion().setText(centro.getDireccion_lug());
      vistaCentroAcopio.getSpnCapacidad().setValue(centro.getCapacidad_ca());
      vistaCentroAcopio.getCbCiudad().setSelectedItem(centro.getId_ciudad() + ": " + modCA.obtenerNombreCiudad(centro.getId_ciudad()));
    }
         
}
