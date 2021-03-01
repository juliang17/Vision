package modelo;

public class Carritomodelo {

    int item;
    int idproductos;
    String nombreproducto;
    String descripcionproducto;
    double precio;
    int cantidadproducto;
    double subtotal;

    public Carritomodelo() {
    }

    public Carritomodelo(int item, int idproductos, String nombreproducto, String descripcionproducto, double precio, int cantidadproducto, double subtotal) {
        this.item = item;
        this.idproductos = idproductos;
        this.nombreproducto = nombreproducto;
        this.descripcionproducto = descripcionproducto;
        this.precio = precio;
        this.cantidadproducto = cantidadproducto;
        this.subtotal = subtotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(int idproductos) {
        this.idproductos = idproductos;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getDescripcionproducto() {
        return descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadproducto() {
        return cantidadproducto;
    }

    public void setCantidadproducto(int cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
