package modelo;

public class tipo_doc_contable {
    
    private int idtipodoccontable;
    private String descripciontipodoccontable;
    private int tipo_movimiento_idTipoMov;

    public int getIdtipodoccontable() {
        return idtipodoccontable;
    }

    public void setIdtipodoccontable(int idtipodoccontable) {
        this.idtipodoccontable = idtipodoccontable;
    }

    public String getDescripciontipodoccontable() {
        return descripciontipodoccontable;
    }

    public void setDescripciontipodoccontable(String descripciontipodoccontable) {
        this.descripciontipodoccontable = descripciontipodoccontable;
    }

    public int getTipo_movimiento_idTipoMov() {
        return tipo_movimiento_idTipoMov;
    }

    public void setTipo_movimiento_idTipoMov(int tipo_movimiento_idTipoMov) {
        this.tipo_movimiento_idTipoMov = tipo_movimiento_idTipoMov;
    }
}
