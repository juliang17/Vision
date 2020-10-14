package modelo;

public class referencia_de_pago {
   
    private int idreferenciadepago;
    private String descripcion;
    private int fechadepago;
    private int medio_de_pago_idMedioDePago_;   

    public int getIdreferenciadepago() {
        return idreferenciadepago;
    }

    public void setIdreferenciadepago(int idreferenciadepago) {
        this.idreferenciadepago = idreferenciadepago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFechadepago() {
        return fechadepago;
    }

    public void setFechadepago(int fechadepago) {
        this.fechadepago = fechadepago;
    }

    public int getMedio_de_pago_idMedioDePago_() {
        return medio_de_pago_idMedioDePago_;
    }

    public void setMedio_de_pago_idMedioDePago_(int medio_de_pago_idMedioDePago_) {
        this.medio_de_pago_idMedioDePago_ = medio_de_pago_idMedioDePago_;
    }
}
