package Controlador;

import Vista.V_ModuloProducto;
import Vista.vistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author IV
 */
public class ControladorModuloProductos {

    private V_ModuloProducto vistaModProducto;
    private Timer timer;
    ImageIcon icon = new ImageIcon("src\\Vista\\Iconos\\iconoExito.png");

    public ControladorModuloProductos(V_ModuloProducto vistaModProducto) {
        this.vistaModProducto = vistaModProducto;
        vistaModProducto.setVisible(true);
    }

    public void iniciarControl() {
        vistaModProducto.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
        //Ventana Ropa
        vistaModProducto.getBtnAyuda().addActionListener(l -> ayuda());
        vistaModProducto.getBtnCrear().addActionListener(l -> crearRopa());
        vistaModProducto.getBtnConsultar().addActionListener(l -> consultarRopa());
        vistaModProducto.getBtnModificar().addActionListener(l -> modificarRopa());
        vistaModProducto.getBtnEliminar().addActionListener(l -> eliminarRopa());
        vistaModProducto.getBtnReporte().addActionListener(l -> reporteRopa());

    }

    private void regresarModuloAdmin() {
        vistaModProducto.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }

    private void ayuda() {
        JOptionPane.showMessageDialog(null, "Aqui se encuentra la ventana para el registro de ropa"
                + "\nBotones "
                + "\n1. Crear: En este boton se guardara los datos ingresados en los campos del formulario en la base de datos,"
                + "\n                 los datos ingresados deben pertenecer a su tipo de dato correspondiente."
                + "\n2. Consultar: Este boton realizara una consulta de los registros en la base de datos."
                + "\n3. Modificar: Este boton modificara los datos que se ingresan en los campos, cuando se hace una consulta."
                + "\n4. Eliminar: Este boton eliminara un registro de la base de datos."
                + "\n5. Reporte: Este boton realizara una actualizacion en la tabla de los registros de la base de datos.");
    }

    private void crearRopa() {
        mostrarMensaje("CREACION EXITOSA", 1000, icon);
        //JOptionPane.showMessageDialog(vistaModProducto, "Error al crear un registro.", "Error", JOptionPane.ERROR_MESSAGE);

    }

    private void consultarRopa() {
        mostrarMensaje("CONSULTA EXITOSA", 1000, icon);
    }

    private void modificarRopa() {
        mostrarMensaje("MODIFICACION EXITOSA", 1000, icon);
    }

    private void eliminarRopa() {
        mostrarMensaje("ELIMINACION EXITOSA", 1000, icon);
    }

    private void reporteRopa() {
        mostrarMensaje("REPORTE EXITOSO", 1000, icon);
    }

    // Método para mostrar el mensaje en el JLabel durante un tiempo determinado
    private void mostrarMensaje(String mensaje, int duracionMillisegundos, Icon icono) {
        vistaModProducto.getMensajeExito().setText(mensaje);
        vistaModProducto.getMensajeExito().setIcon(icono); // Establecer el icono en el JLabel

        // Iniciar el temporizador para ocultar el mensaje después de la duración especificada
        timer = new Timer(duracionMillisegundos, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ocultarMensaje();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void ocultarMensaje() {
        vistaModProducto.getMensajeExito().setText("");
        vistaModProducto.getMensajeExito().setIcon(null);
    }
}
