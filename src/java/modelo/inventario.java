package modelo;

public class inventario {

    private int idinventario;
    private int entrada;
    private int salida;
    private int saldo;
    private int productos_idproductos;
    private int detalle_movimiento_iddetallemovimiento;

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getProductos_idproductos() {
        return productos_idproductos;
    }

    public void setProductos_idproductos(int productos_idproductos) {
        this.productos_idproductos = productos_idproductos;
    }

    public int getDetalle_movimiento_iddetallemovimiento() {
        return detalle_movimiento_iddetallemovimiento;
    }

    public void setDetalle_movimiento_iddetallemovimiento(int detalle_movimiento_iddetallemovimiento) {
        this.detalle_movimiento_iddetallemovimiento = detalle_movimiento_iddetallemovimiento;
    }
    
    
}
