package Controlador;

import Modelo.ModeloSolicitante;
import Modelo.ModeloUsuario;
import Modelo.Solicitante;
import Vista.CRUD_Solicitante;
import Vista.vistaAdministrador;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorCrudSolicitante {
    CRUD_Solicitante vistaCrudSolicitante;
    ModeloSolicitante modeloSolicitante;
    ModeloUsuario modeloUsuario;
    ModeloSolicitante modSolictnt = new ModeloSolicitante();

    public ControladorCrudSolicitante(CRUD_Solicitante vistaCrudSolicitante, ModeloSolicitante modeloSolicitante, ModeloUsuario modeloUsuario) {
        this.vistaCrudSolicitante = vistaCrudSolicitante;
        this.modeloSolicitante = modeloSolicitante;
        this.modeloUsuario = modeloUsuario;
        vistaCrudSolicitante.setVisible(true);
    }

    public ControladorCrudSolicitante(CRUD_Solicitante vistaCrudSolicitante) {
        this.vistaCrudSolicitante = vistaCrudSolicitante;
        vistaCrudSolicitante.setVisible(true);
    }
    
    public void iniciarControl() {
        cargarTabla();
        vistaCrudSolicitante.getBtnRegresar().addActionListener(l -> regresarModuloAdmin());
        vistaCrudSolicitante.getBtnCrear().addActionListener(l -> RegistrarSolicitante());
        //vistaCrudSolicitante.getBtnCargar().addActionListener(l -> cargarAdmin());
        //vistaCrudSolicitante.getBtnConsultar().addActionListener(l -> consultarAdmin());
        //vistaCrudSolicitante.getBtnModificar().addActionListener(l -> modificarAdministrador());
        //vistaCrudSolicitante.getBtnEliminar().addActionListener(l -> eliminarAdmin());
    }
    
    public void regresarModuloAdmin() {
        vistaCrudSolicitante.dispose();
        vistaAdministrador vista = new vistaAdministrador();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        ControladorModuloAdmin control = new ControladorModuloAdmin(vista);
        control.iniciarControl();
    }
    
    public void RegistrarSolicitante() {
        ModeloSolicitante solictnt = new ModeloSolicitante();
        ModeloUsuario per = new ModeloUsuario();

        try {
            String cedula = vistaCrudSolicitante.getTxtcedula_soli().getText();

            // Verificar duplicidad de la cédula de la persona
            if (per.verificarDuplicidadCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "La cedula ingresada ya existe en el sistema");
                vistaCrudSolicitante.getTxtcedula_soli().setText("");
                return;
            }

            if (!Validaciones.ValidarCedula(cedula)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Cédula incorrecta. Ingrese de nuevo");
                return;
            }
            per.setCedula_usu(cedula);

            String nombre = vistaCrudSolicitante.getTxtnombre_soli().getText();
            if (!Validaciones.ValidarNomApe(nombre)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Nombre incorrecto. Ingrese de nuevo");
                return;
            }
            per.setNombre_usu(nombre);

            String apellido = vistaCrudSolicitante.getTxtapellido_soli().getText();
            if (!Validaciones.ValidarNomApe(apellido)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Apellido incorrecto. Ingrese de nuevo");
                return;
            }
            per.setApellido_usu(apellido);

            String genero;
            if (vistaCrudSolicitante.getRbH().isSelected()) {
                genero = "Hombre";
            } else if (vistaCrudSolicitante.getRbM().isSelected()) {
                genero = "Mujer";
            } else {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Seleccione un género");
                return;
            }
            per.setSexo_usu(genero);

            String celular = vistaCrudSolicitante.getTxtcelular_soli().getText();
            if (!Validaciones.ValidarCedula(celular)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "# Celular no válido. Ingrese de nuevo");
                return;
            }
            per.setCelular_usu(celular);

            String correo = vistaCrudSolicitante.getTxtcorreo_soli().getText();
            if (!Validaciones.ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Correo no válido. Ingrese de nuevo");
                return;
            }
            per.setCorreo_usu(correo);

            String tipoSangre = vistaCrudSolicitante.getCbBoxSangre().getSelectedItem().toString();
            per.setTipoSangre_usu(tipoSangre);

            String ciudad = (String) vistaCrudSolicitante.getCboxciudad_soli().getSelectedItem();
            per.setCiudad_usu(ciudad);

            // Obtener fecha de nacimiento del JCalendar
            String dia = Integer.toString(vistaCrudSolicitante.getF_nac_soli().getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(vistaCrudSolicitante.getF_nac_soli().getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(vistaCrudSolicitante.getF_nac_soli().getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            if (vistaCrudSolicitante.getF_nac_soli() == null) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Seleccione una fecha de nacimiento");
                return; // O realiza alguna otra acción apropiada para manejar el error
            }
            per.setFechaNacimiento_usu(FechaNacimiento);

            String direccion = vistaCrudSolicitante.getTxtdireccion().getText();
            if (!Validaciones.ValidarNomApe(direccion)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Dirección incorrecta. Ingrese de nuevo");
                return;
            }
            per.setDireccion_usu(direccion);

            String contraseniaSolctnt = vistaCrudSolicitante.getTxtContra_soli().getText();
            if (!Validaciones.ValidarContrasena(contraseniaSolctnt)) {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "Contraseña no valida. Ingrese de nuevo");
                return;
            }
            per.setContraseña_usu(contraseniaSolctnt);

            if (per.InsertarPersona(FechaNacimiento)) {
                // Obtener el id_persona recién insertado
                int idPersona = per.traerCodigoDePersonaCrear(cedula);

                if (idPersona > 0) {
                    // Asignar el id_persona al modeloSolicitante
                    solictnt.setId_persona(idPersona);

                    // Resto del código para validar y asignar los datos al modelo admin...
//                    String cargo = vistaCrudSolicitante.getCbBoxCargo().getSelectedItem().toString();
//                    solictnt.setCargo_adm(cargo);
                    if (solictnt.InsertarSolicitante()) {
                        JOptionPane.showMessageDialog(vistaCrudSolicitante, "Se guardó exitosamente");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se pudo registrar el solicitante");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se pudo obtener el id_persona");
                }
            } else {
                JOptionPane.showMessageDialog(vistaCrudSolicitante, "No se pudo registrar la persona");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            // Resto del código para manejar la excepción...
        }
    }
    
     
    private void cargarTabla() {
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Cedula");
        tb.addColumn("Nombre");
        tb.addColumn("Apellido");
        tb.addColumn("Fecha Nacimiento");
        tb.addColumn("Correo");
        tb.addColumn("Ciudad");
        tb.addColumn("Direccion");
        tb.addColumn("Tipo Sangre");
        tb.addColumn("Sexo");
        tb.addColumn("Celular");
        tb.addColumn("Contraseña");

        List<Solicitante> com = modSolictnt.ListaSolicitante();
        System.out.println("Tamaño" + com.size());
        com.forEach(p -> {
            Object[] rowData = {
                p.getCedula_usu(),
                p.getNombre_usu(),
                p.getApellido_usu(),
                p.getFechaNacimiento_usu(),
                p.getSexo_usu(),
                p.getCorreo_usu(),
                p.getTipoSangre_usu(),
                p.getCelular_usu(),
                p.getCiudad_usu(),
                p.getDireccion_usu(),
                p.getContraseña_usu()
            };
            tb.addRow(rowData);
        });

        vistaCrudSolicitante.getTabla_Solicitante().setModel(tb);
    } 
    
    //Metodo para buscar solicitante y llamar al metodo para llenar los campos
//    private void cargarSolic() {
//        String cedula = vistaCrudSolicitante.getTxtcedula_soli().getText();
//
//        try {
//            // Buscar el solicitante en la base de datos
//            Solicitante admin = modSolictnt.buscarAdministrador(cedula);
//
//            // Verificar si se encontró el solicitante
//            if (admin != null) {
//                // Cargar los datos del solicitante en el formulario
//                cargarDatosFormulario(admin);
//                vistaCrudAdmin.getTxtCedu().setEditable(false);
//            } else {
//                JOptionPane.showMessageDialog(vistaCrudAdmin, "No se encontró el solicitante");
//                vistaCrudAdmin.getTxtCedu().setEditable(true);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
