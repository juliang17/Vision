package modelo;

public class referencia_de_pago {
   
    private String idreferenciadepago;
    private String descripcion;
    private String fechadepago;
    private int medio_de_pago_idMedioDePago_;   

    public String getIdreferenciadepago() {
        return idreferenciadepago;
    }

    public void setIdreferenciadepago(String idreferenciadepago) {
        this.idreferenciadepago = idreferenciadepago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechadepago() {
        return fechadepago;
    }

    public void setFechadepago(String fechadepago) {
        this.fechadepago = fechadepago;
    }

    public int getMedio_de_pago_idMedioDePago_() {
        return medio_de_pago_idMedioDePago_;
    }

    public void setMedio_de_pago_idMedioDePago_(int medio_de_pago_idMedioDePago_) {
        this.medio_de_pago_idMedioDePago_ = medio_de_pago_idMedioDePago_;
    }

    
}
