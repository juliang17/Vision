package modelo;

public class proveedores {

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getNombreproveedores() {
        return nombreproveedores;
    }

    public void setNombreproveedores(String nombreproveedores) {
        this.nombreproveedores = nombreproveedores;
    }

    public String getCorreoproveedores() {
        return correoproveedores;
    }

    public void setCorreoproveedores(String correoproveedores) {
        this.correoproveedores = correoproveedores;
    }

    public int getTelefonoproveedores() {
        return telefonoproveedores;
    }

    public void setTelefonoproveedores(int telefonoproveedores) {
        this.telefonoproveedores = telefonoproveedores;
    }
    
    private int idProveedores;
    private String nombreproveedores;
    private String correoproveedores;
    private int telefonoproveedores;
}
