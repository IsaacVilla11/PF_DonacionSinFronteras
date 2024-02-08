/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Detalle_donacion;
import Modelo.Donacion;
import Modelo.Donante;
import Modelo.ModeloDonacion;
import Modelo.Producto;
import Vista.crud_Donacion;
import Vista.vistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.EOFException;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author jose
 */
public class controladorDonaciones {
    
    crud_Donacion vistaDonaciones;
    ModeloDonacion modDon = new ModeloDonacion();
    private ArrayList<Integer> idsProductos;
    private ArrayList<Integer> idsDonantes;
    private int cantidadRelaciones;
    
    
    public controladorDonaciones(crud_Donacion vistaDonaciones) {
        this.vistaDonaciones = vistaDonaciones;
        vistaDonaciones.setVisible(true);
        this.idsProductos = new ArrayList<>();
        this.idsDonantes = new ArrayList<>();
        this.cantidadRelaciones = 0;
          
    }
    
    public void iniciarControl() {   

    vistaDonaciones.getBtnVolver().addActionListener(l -> mostrarVistaAdmin());
    vistaDonaciones.getBtnDeshacer().addActionListener(l->deshacerAccion());
    vistaDonaciones.getBtnGuardar().addActionListener(l->registrarDonacion());
    vistaDonaciones.getBtnCargar().addActionListener(l->cargarTabla());
    vistaDonaciones.getBtnEliminarReg().addActionListener(l->eliminarProductoSeleccionado());
    vistaDonaciones.getBtnEliminar().addActionListener(l->eliminarDonacionSeleccionada());
    
    // Llenar ComboBox de productos y donantes
    modDon.llenarComboBoxDonantes(vistaDonaciones.getCbDonantes()); 
    modDon.llenarComboBoxProductos(vistaDonaciones.getCbProductos());
        JComboBox<String> cbProductos = vistaDonaciones.getCbProductos();
        JLabel lblFoto = vistaDonaciones.getLblFoto();
        if (cbProductos != null) {
            cbProductos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object selectedItem = cbProductos.getSelectedItem();
                    if (selectedItem != null && !selectedItem.toString().isEmpty()) {
                        String selectedItemString = selectedItem.toString();
                        int idProducto = Integer.parseInt(selectedItemString.split(":")[0].trim());
                        try {
                            modDon.mostrarFotoProductoSeleccionado(idProducto, lblFoto);
                        } catch (IOException ex) {
                            Logger.getLogger(controladorDonaciones.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        // No hay ningún producto seleccionado, limpiar lblFoto
                        lblFoto.setIcon(null);
                    }
                }
            });
        } else {
            System.err.println("El JComboBox es nulo.");
        }
        // Agregar ActionListener al botón "Agregar"
        JButton btnAgregar = vistaDonaciones.getBtnAgregar();
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRelacion();
            }
        });
    vistaDonaciones.getTblDonaciones().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) { // Para evitar que se ejecute dos veces
                tablaRelaciones(); // Llama al método tablaRelaciones() cuando se selecciona una fila
            }
        }
    });
    
    vistaDonaciones.getTblProd().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {
            int selectedRow = vistaDonaciones.getTblProd().getSelectedRow();
            if (selectedRow != -1) {
                int idProducto = (int) vistaDonaciones.getTblProd().getValueAt(selectedRow, 1); // Ajusta el índice de la columna según corresponda

                try {
                    modDon.mostrarFotoProductoSeleccionado(idProducto, lblFoto);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
});
    }

     public   void mostrarVistaAdmin(){
        vistaDonaciones.dispose();
        vistaAdministrador vista1 = new vistaAdministrador();
        vista1.setLocationRelativeTo(null);
        vista1.setVisible(true);

        ControladorModuloAdmin controR = new ControladorModuloAdmin(vista1);
        controR.iniciarControl();
    }
    private void agregarRelacion() {
       JComboBox<String> cbDonantes = vistaDonaciones.getCbDonantes();
       JComboBox<String> cbProductos = vistaDonaciones.getCbProductos();
       JSpinner spnCantidad = vistaDonaciones.getSpnCantidad();

       if (cbProductos.getItemCount() == 0) {
           JOptionPane.showMessageDialog(null, "No hay productos disponibles para agregar.");
           return;
       }

       if (cbDonantes.getSelectedIndex() != -1 && cbProductos.getSelectedIndex() != -1) {
           
           String selectedItemProducto = cbProductos.getSelectedItem().toString();
           String selectedItemDonante = cbDonantes.getSelectedItem().toString();
           String[] partesProducto = selectedItemProducto.split(":");
           String[] partesDonante = selectedItemDonante.split(":");
           int idDonante = Integer.parseInt(partesDonante[0].trim());
           int idProducto = Integer.parseInt(partesProducto[0].trim());

           idsProductos.add(idProducto);
           idsDonantes.add(idDonante);

           cantidadRelaciones = idsProductos.size(); // Actualizar la cantidad de relaciones

           spnCantidad.setValue(cantidadRelaciones);

           cbProductos.removeItemAt(cbProductos.getSelectedIndex());
       } else {
           JOptionPane.showMessageDialog(null, "Debe seleccionar un donante y un producto antes de agregar la relación.");
       }
   }

   public void deshacerAccion() {
       if (!idsProductos.isEmpty() && !idsDonantes.isEmpty()) {
           // Eliminar el último producto y donante agregado al array
           idsProductos.remove(idsProductos.size() - 1);
           idsDonantes.remove(idsDonantes.size() - 1);

           // Actualizar la cantidad de relaciones
           cantidadRelaciones = idsProductos.size();

           // Actualizar el Spinner de cantidad
           vistaDonaciones.getSpnCantidad().setValue(cantidadRelaciones);
           modDon.llenarComboBoxProductos(vistaDonaciones.getCbProductos());
           modDon.llenarComboBoxDonantes(vistaDonaciones.getCbDonantes());
       }
   }
 public boolean registrarDonacion() {
    ModeloDonacion modDon = new ModeloDonacion();

    // Obtener la cantidad donada del Spinner
    int cantidadDonada = (int) vistaDonaciones.getSpnCantidad().getValue();

    // Verificar que existan relaciones de productos y donantes
    if (idsProductos.isEmpty() || idsDonantes.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No se pueden registrar donaciones sin productos o donantes relacionados.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Obtener los arrays de IDs de productos y donantes
    int[] idsProductosArray = idsProductos.stream().mapToInt(Integer::intValue).toArray();
    int[] idsDonantesArray = idsDonantes.stream().mapToInt(Integer::intValue).toArray();

    // Crear una instancia de Donacion con todos los datos
    Donacion donacion = new Donacion(0, cantidadDonada, null, 0, 0);

    // Insertar la donación en la base de datos utilizando el método insertarDonacion del modelo
    boolean donacionInsertada = modDon.insertarDonacion(donacion, idsProductosArray, idsDonantesArray);
  
    if (donacionInsertada) {
        // Limpiar los arrays y restablecer la cantidad de relaciones
        idsProductos.clear();
        idsDonantes.clear();
        cantidadRelaciones = 0;

        // Volver a llenar los ComboBox de productos y donantes
        modDon.llenarComboBoxProductos(vistaDonaciones.getCbProductos());
        modDon.llenarComboBoxDonantes(vistaDonaciones.getCbDonantes());
        
        // Establecer la cantidad del Spinner en 0
        vistaDonaciones.getSpnCantidad().setValue(0);
        
        // Actualizar la tabla con las donaciones
        cargarTabla();

        // Mostrar mensaje de confirmación
        JOptionPane.showMessageDialog(null, "La donación ha sido registrada correctamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Mostrar mensaje de error
        JOptionPane.showMessageDialog(null, "No se pudo registrar la donación.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    return donacionInsertada;
}
 
private void cargarTabla() {
    try {
        // Obtener la lista de donaciones
        List<Donacion> listaDonaciones = modDon.consultarDonacion();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id donacion");
        model.addColumn("Fecha donacion");
        model.addColumn("Cantidad productos");

        // Iterar sobre la lista de donaciones para agregar las filas a la tabla
        for (Donacion donacion : listaDonaciones) {        
                // Agregar la fila a la tabla con los detalles de la donación y el donante
                Object[] fila = {
                    donacion.getId_donacion(),
                    donacion.getFechaDonacion(),
                    donacion.getCantidad_pro()
                };

                model.addRow(fila);         
        }
        // Establecer el modelo de la tabla con los registros cargados
        vistaDonaciones.getTblDonaciones().setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



private void eliminarProductoSeleccionado() {
    // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = vistaDonaciones.getTblProd().getSelectedRow();
    
    if (filaSeleccionada != -1) {
        // Obtener el idproducto de la fila seleccionada
        int id_producto = (Integer) vistaDonaciones.getTblProd().getValueAt(filaSeleccionada, 1);

        // Lógica para eliminar el detalle con el idproducto obtenido
        if (modDon.eliminarDetalle(id_producto)) {
            JOptionPane.showMessageDialog(null, "Detalle eliminado satisfactoriamente");          
        } else {
            JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione un registro para eliminar");
    }
    tablaRelaciones();
    modDon.llenarComboBoxProductos(vistaDonaciones.getCbProductos());
}
    
private void eliminarDonacionSeleccionada() {
    // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = vistaDonaciones.getTblDonaciones().getSelectedRow();
    
    if (filaSeleccionada != -1) {
        // Obtener el id_donacion de la fila seleccionada
        int id_donacion = (Integer) vistaDonaciones.getTblDonaciones().getValueAt(filaSeleccionada, 0);

        // Lógica para eliminar la donación con el id_donacion obtenido
        if (modDon.eliminarDonacion(id_donacion)) {
            JOptionPane.showMessageDialog(null, "Donación eliminada satisfactoriamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la donación. Verifique si existen productos, donantes o solicitudes relacionadas.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione una donación para eliminar");
    }
    tablaRelaciones();
    cargarTabla(); // Asegúrate de cargar nuevamente la tabla de donaciones después de la eliminación
}

private void tablaRelaciones() {
    int filaSeleccionada = vistaDonaciones.getTblDonaciones().getSelectedRow();

    if (filaSeleccionada != -1) {
        int idDonacion = (int) vistaDonaciones.getTblDonaciones().getValueAt(filaSeleccionada, 0);

        DefaultTableModel modeloTabla = (DefaultTableModel) vistaDonaciones.getTblProd().getModel();
        modeloTabla.setRowCount(0);

        try {
            List<Detalle_donacion> detallesDonacion = modDon.obtenerDetallesDonacion(idDonacion);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id Donacion");
            model.addColumn("Id Producto");
            model.addColumn("Id Donante");
            model.addColumn("Nombre");
            model.addColumn("Apellido");

            for (Detalle_donacion detalle : detallesDonacion) {
                List<Donante> donantes = modDon.obtenerNombresApellidosDonantes(detalle.getId_donante());
                if (!donantes.isEmpty()) {
                    Donante donante = donantes.get(0);
                    Object[] fila = {
                            detalle.getId_donacion(),
                            detalle.getId_producto(),
                            detalle.getId_donante(),
                            donante.getNombre_usu(),
                            donante.getApellido_usu()
                    };
                    model.addRow(fila);
                } else {
                    // Si no se encuentra el donante, agregar una fila vacía
                    Object[] filaVacia = {detalle.getId_donacion(), detalle.getId_producto(), detalle.getId_donante(), "", ""};
                    model.addRow(filaVacia);
                }
            }
            vistaDonaciones.getTblProd().setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

}


   





