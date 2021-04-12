package modelo;

public class referencia_de_pago {
   
    private int idreferenciadepago;
    private String fechadepago;
    private int medio_de_pago_idMedioDePago;   

    public int getIdreferenciadepago() {
        return idreferenciadepago;
    }

    public void setIdreferenciadepago(int idreferenciadepago) {
        this.idreferenciadepago = idreferenciadepago;
    }

    public String getFechadepago() {
        return fechadepago;
    }

    public void setFechadepago(String fechadepago) {
        this.fechadepago = fechadepago;
    }

    public int getMedio_de_pago_idMedioDePago() {
        return medio_de_pago_idMedioDePago;
    }

    public void setMedio_de_pago_idMedioDePago(int medio_de_pago_idMedioDePago) {
        this.medio_de_pago_idMedioDePago = medio_de_pago_idMedioDePago;
    }

}