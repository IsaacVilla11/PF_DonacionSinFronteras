package Controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

    public static final String PATTERN_CEDULA = "^\\d{10}$";
    public static final String PATTERN_NOM_APE = "^[A-Z][a-zA-Z\\s]{2,20}$";
    public static final String PATTERN_CORREO = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    public static final String PATTERN_COD = "[A-Z]{3,}-\\d{3}$";
    public static final String PATTERN_CONTRASENA = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%.!%-_^*&+=()])(?=\\S+$).{5,20}$";
    public static final String PATTERN_USUARIO = "^[a-zA-Z]{3,}[\\d]*$";
    private static final String PATTERN_LETRAS = "^[A-Za-z\\s]{1,}$";//150 PALABRAS
    private static final String PATTERN_RUC = "^RUC-\\d{3}$";
    private static final String PATTERN_DIRECCION = "^[A-Za-z0-9\\s.,'-]*$";
    private static final String PATTERN_NOMBRE_LUGAR = "^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s.,'-]*$";

    public static boolean ValidarCedula(String cedula) {
        Pattern pattern = Pattern.compile(PATTERN_CEDULA);
        Matcher matcher = pattern.matcher(cedula);
        return matcher.matches();
    }

    public static boolean ValidarNomApe(String nomape) {
        Pattern pattern = Pattern.compile(PATTERN_NOM_APE);
        Matcher matcher = pattern.matcher(nomape);
        return matcher.matches();
    }

    public static boolean ValidarCorreo(String correo) {
        Pattern pattern = Pattern.compile(PATTERN_CORREO);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static boolean ValidarCod(String codigo) {
        Pattern pattern = Pattern.compile(PATTERN_COD);
        Matcher matcher = pattern.matcher(codigo);
        return matcher.matches();
    }

    public static boolean ValidarContrasena(String contrasena) {
        Pattern pattern = Pattern.compile(PATTERN_CONTRASENA);
        Matcher matcher = pattern.matcher(contrasena);
        return matcher.matches();
    }

    public static boolean ValidarUsuario(String usuario) {
        Pattern pattern = Pattern.compile(PATTERN_USUARIO);
        Matcher matcher = pattern.matcher(usuario);
        return matcher.matches();
    }

    public static boolean validarLetras(String motivo) {
        Pattern pattern = Pattern.compile(PATTERN_LETRAS);
        Matcher matcher = pattern.matcher(motivo);
        return matcher.matches();
    }

    public static boolean ValidarRUC(String ruc) {
        Pattern pattern = Pattern.compile(PATTERN_RUC);
        Matcher matcher = pattern.matcher(ruc);
        return matcher.matches();
    }

    public static boolean ValidarDireccion(String direccion) {
        Pattern pattern = Pattern.compile(PATTERN_DIRECCION);
        Matcher matcher = pattern.matcher(direccion);
        return matcher.matches();
    }

    public static boolean ValidarNombreLugar(String nombreLugar) {
        Pattern pattern = Pattern.compile(PATTERN_NOMBRE_LUGAR);
        Matcher matcher = pattern.matcher(nombreLugar);
        return matcher.matches();
    }

}
