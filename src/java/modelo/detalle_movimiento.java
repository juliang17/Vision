package modelo;

public class detalle_movimiento {

    private int iddetallemovimiento;
    private String nombre_producto;
    private int cantidad;
    private float precio;
    private float iva;
    private float subtotal;
    private float total_producto;
    private int productos_idproductos;
    private int movimiento_idmovimiento;

    public int getIddetallemovimiento() {
        return iddetallemovimiento;
    }

    public void setIddetallemovimiento(int iddetallemovimiento) {
        this.iddetallemovimiento = iddetallemovimiento;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal_producto() {
        return total_producto;
    }

    public void setTotal_producto(float total_producto) {
        this.total_producto = total_producto;
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
