package modelo;

public class productos {

    private int idproductos;
    private String nombreproducto;
    private int cantidadproducto;
    private int ivaproducto;
    private String descripcionproducto;
    private int precio;
    private int Categorias_idcategorias;
    private int Marca_idmarca;
    private int Unidad_de_medida_idunidadmedida;
    private int Proveedores_idproveedores;

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

    public int getCantidadproducto() {
        return cantidadproducto;
    }

    public void setCantidadproducto(int cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    public int getIvaproducto() {
        return ivaproducto;
    }

    public void setIvaproducto(int ivaproducto) {
        this.ivaproducto = ivaproducto;
    }

    public String getDescripcionproducto() {
        return descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCategorias_idcategorias() {
        return Categorias_idcategorias;
    }

    public void setCategorias_idcategorias(int categorias_idcategorias) {
        this.Categorias_idcategorias = categorias_idcategorias;
    }

    public int getMarca_idmarca() {
        return Marca_idmarca;
    }

    public void setMarca_idmarca(int marca_idmarca) {
        this.Marca_idmarca = marca_idmarca;
    }

    public int getUnidad_de_medida_idunidadmedida() {
        return Unidad_de_medida_idunidadmedida;
    }

    public void setUnidad_de_medida_idunidadmedida(int unidad_de_medida_idunidadmedida) {
        this.Unidad_de_medida_idunidadmedida = unidad_de_medida_idunidadmedida;
    }

    public int getProveedores_idproveedores() {
        return Proveedores_idproveedores;
    }

    public void setProveedores_idproveedores(int proveedores_idproveedores) {
        this.Proveedores_idproveedores = proveedores_idproveedores;
    }
}
