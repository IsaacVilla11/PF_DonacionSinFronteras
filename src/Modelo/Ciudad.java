package Modelo;

/**
 *
 * @author IV
 */
public class Ciudad {

    private int id_ciudad;
    private String nombre_ciud;

    public Ciudad() {
    }

    public Ciudad(int id_ciudad, String nombre_ciud) {
        this.id_ciudad = id_ciudad;
        this.nombre_ciud = nombre_ciud;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre_ciud() {
        return nombre_ciud;
    }

    public void setNombre_ciud(String nombre_ciud) {
        this.nombre_ciud = nombre_ciud;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "id_ciudad=" + id_ciudad + ", nombre_ciud=" + nombre_ciud + '}';
    }

}
