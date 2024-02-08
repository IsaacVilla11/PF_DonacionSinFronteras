/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jose
 */
public class Detalle_donacion {
    private int id_donacion;
    private int id_producto;
    private int id_donante;

    public Detalle_donacion(int id_donacion, int id_producto, int id_donante) {
        this.id_donacion = id_donacion;
        this.id_producto = id_producto;
        this.id_donante = id_donante;
    }

    public Detalle_donacion() {
    }

    public int getId_donacion() {
        return id_donacion;
    }

    public void setId_donacion(int id_donacion) {
        this.id_donacion = id_donacion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_donante() {
        return id_donante;
    }

    public void setId_donante(int id_donante) {
        this.id_donante = id_donante;
    }

    @Override
    public String toString() {
        return "Detalle_donacion{" + "id_donacion=" + id_donacion + ", id_producto=" + id_producto + ", id_donante=" + id_donante + '}';
    }
    

    
    
    
}
