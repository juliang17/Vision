package modelo;


public class detalle_movimiento {
    private int iddetallemovimiento;
    private String descripcion;
    private int cantidad;
    private int precio;
    private int iva;
    private int subtotal;
    private int productos_idproductos;
    private int movimiento_idmovimiento;
  
    public int getIddetallemovimiento() {
        return iddetallemovimiento;
    }

    public void setIddetallemovimiento(int iddetallemovimiento) {
        this.iddetallemovimiento = iddetallemovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getProductos_idproductos() {
        return productos_idproductos;
    }

    public void setProductos_idproductos(int productos_idproductos) {
        this.productos_idproductos = productos_idproductos;
    }

    public int getMovimiento_idmovimiento() {
        return movimiento_idmovimiento;
    }

    public void setMovimiento_idmovimiento(int movimiento_idmovimiento) {
        this.movimiento_idmovimiento = movimiento_idmovimiento;
    }

}