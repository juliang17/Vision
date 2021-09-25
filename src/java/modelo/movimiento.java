package modelo;

public class movimiento {

    private String idmovimiento;
    private String numero_documento;
    private String fechamovimiento;
    private double subtotal;
    private double iva;
    private int estadoMov;
    private double total;
    private int usuarios_idusuarios;
    private int tipo_mov_id_tipo_mov;
    private int medio_de_pago_idmediodepago;

    public String getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(String idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getFechamovimiento() {
        return fechamovimiento;
    }

    public void setFechamovimiento(String fechamovimiento) {
        this.fechamovimiento = fechamovimiento;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getEstadoMov() {
        return estadoMov;
    }

    public void setEstadoMov(int estadoMov) {
        this.estadoMov = estadoMov;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getUsuarios_idusuarios() {
        return usuarios_idusuarios;
    }

    public void setUsuarios_idusuarios(int usuarios_idusuarios) {
        this.usuarios_idusuarios = usuarios_idusuarios;
    }

    public int getTipo_mov_id_tipo_mov() {
        return tipo_mov_id_tipo_mov;
    }

    public void setTipo_mov_id_tipo_mov(int tipo_mov_id_tipo_mov) {
        this.tipo_mov_id_tipo_mov = tipo_mov_id_tipo_mov;
    }

    public int getMedio_de_pago_idmediodepago() {
        return medio_de_pago_idmediodepago;
    }

    public void setMedio_de_pago_idmediodepago(int medio_de_pago_idmediodepago) {
        this.medio_de_pago_idmediodepago = medio_de_pago_idmediodepago;
    }

   

}
