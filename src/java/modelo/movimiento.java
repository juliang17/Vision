package modelo;

public class movimiento {

    private String idmovimiento;
    private String fechamovimiento;
    private int subtotal;
    private int iva;
    private int descuento;
    private int total;
    private int tipo_doc_contable_idtipodoccontable;
    private int medio_de_pago_idmediodepago;

    public String getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(String idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public String getFechamovimiento() {
        return fechamovimiento;
    }

    public void setFechamovimiento(String fechamovimiento) {
        this.fechamovimiento = fechamovimiento;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTipo_doc_contable_idtipodoccontable() {
        return tipo_doc_contable_idtipodoccontable;
    }

    public void setTipo_doc_contable_idtipodoccontable(int tipo_doc_contable_idtipodoccontable) {
        this.tipo_doc_contable_idtipodoccontable = tipo_doc_contable_idtipodoccontable;
    }

    public int getMedio_de_pago_idmediodepago() {
        return medio_de_pago_idmediodepago;
    }

    public void setMedio_de_pago_idmediodepago(int medio_de_pago_idmediodepago) {
        this.medio_de_pago_idmediodepago = medio_de_pago_idmediodepago;
    }
}

