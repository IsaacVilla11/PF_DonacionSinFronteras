package Modelo;

public class DetalleFactura {

    private int id_detalleFact;
    private int cant_produ_det;
    private double subtotal_det;
    private int id_pro_det;
    private int id_encabezadoFact_det;

    public DetalleFactura() {
    }

    public DetalleFactura(int id_detalleFact, int cant_produ_det, double subtotal_det, int id_pro_det, int id_encabezadoFact_det) {
        this.id_detalleFact = id_detalleFact;
        this.cant_produ_det = cant_produ_det;
        this.subtotal_det = subtotal_det;
        this.id_pro_det = id_pro_det;
        this.id_encabezadoFact_det = id_encabezadoFact_det;
    }

    public int getId_detalleFact() {
        return id_detalleFact;
    }

    public void setId_detalleFact(int id_detalleFact) {
        this.id_detalleFact = id_detalleFact;
    }

    public int getCant_produ_det() {
        return cant_produ_det;
    }

    public void setCant_produ_det(int cant_produ_det) {
        this.cant_produ_det = cant_produ_det;
    }

    public double getSubtotal_det() {
        return subtotal_det;
    }

    public void setSubtotal_det(double subtotal_det) {
        this.subtotal_det = subtotal_det;
    }

    public int getId_pro_det() {
        return id_pro_det;
    }

    public void setId_pro_det(int id_pro_det) {
        this.id_pro_det = id_pro_det;
    }

    public int getId_encabezadoFact_det() {
        return id_encabezadoFact_det;
    }

    public void setId_encabezadoFact_det(int id_encabezadoFact_det) {
        this.id_encabezadoFact_det = id_encabezadoFact_det;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "id_detalleFact=" + id_detalleFact + ", cant_produ_det=" + cant_produ_det + ", subtotal_det=" + subtotal_det + ", id_pro_det=" + id_pro_det + ", id_encabezadoFact_det=" + id_encabezadoFact_det + '}';
    }

}
