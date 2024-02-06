package Modelo;

public class Camion extends Conductor {

    private int id_cam;
    private String marca_cam;
    private String color_cam;
    private String modelo_cam;
    private int peso_max_cam;
    private int id_conductor_cam;

    public Camion() {
    }

    public Camion(int id_cam, String marca_cam, String color_cam, String modelo_cam, int peso_max_cam, int id_conductor_cam) {
        this.id_cam = id_cam;
        this.marca_cam = marca_cam;
        this.color_cam = color_cam;
        this.modelo_cam = modelo_cam;
        this.peso_max_cam = peso_max_cam;
        this.id_conductor_cam = id_conductor_cam;
    }

    public Camion(int id_cam, String marca_cam, String color_cam, String modelo_cam, int peso_max_cam, int id_conductor_cam, int id_conductor, String jornada_con, String tipoLicencia_con, int id_persona_con, int id_persona, String cedula_usu, String nombre_usu, String apellido_usu, String fechaNacimiento_usu, String sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, String ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(id_conductor, jornada_con, tipoLicencia_con, id_persona_con, id_persona, cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_cam = id_cam;
        this.marca_cam = marca_cam;
        this.color_cam = color_cam;
        this.modelo_cam = modelo_cam;
        this.peso_max_cam = peso_max_cam;
        this.id_conductor_cam = id_conductor_cam;
    }

    public int getId_cam() {
        return id_cam;
    }

    public void setId_cam(int id_cam) {
        this.id_cam = id_cam;
    }

    public String getMarca_cam() {
        return marca_cam;
    }

    public void setMarca_cam(String marca_cam) {
        this.marca_cam = marca_cam;
    }

    public String getColor_cam() {
        return color_cam;
    }

    public void setColor_cam(String color_cam) {
        this.color_cam = color_cam;
    }

    public String getModelo_cam() {
        return modelo_cam;
    }

    public void setModelo_cam(String modelo_cam) {
        this.modelo_cam = modelo_cam;
    }

    public int getPeso_max_cam() {
        return peso_max_cam;
    }

    public void setPeso_max_cam(int peso_max_cam) {
        this.peso_max_cam = peso_max_cam;
    }

    public int getId_conductor_cam() {
        return id_conductor_cam;
    }

    public void setId_conductor_cam(int id_conductor_cam) {
        this.id_conductor_cam = id_conductor_cam;
    }

    @Override
    public String toString() {
        return "Camion{" + "id_cam=" + id_cam + ", marca_cam=" + marca_cam + ", color_cam=" + color_cam + ", modelo_cam=" + modelo_cam + ", peso_max_cam=" + peso_max_cam + ", id_conductor_cam=" + id_conductor_cam + '}';
    }

    

}
