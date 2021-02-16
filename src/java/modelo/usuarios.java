package modelo;

public class usuarios {

    private int idusuarios;
    private String numerodocusuario;
    private String nombreusuarios;
    private String apellidousuarios;
    private String correousuarios;
    private String telefonousuarios;
    private String direccionusuario;
    private String contraseñausuario;
    private int tipo_documento_idtipodoc;
    private int roles_idroles;
    private int genero_idgenero;
    private int estado_usuario_idestadousuario;

    public int getidusuarios() {
        return idusuarios;
    }

    public void setidusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getnumerodocusuario() {
        return numerodocusuario;
    }

    public void setnumerodocusuario(String numerodocusuario) {
        this.numerodocusuario = numerodocusuario;
    }

    public String getnombreusuarios() {
        return nombreusuarios;
    }

    public void setnombreusuarios(String nombreusuarios) {
        this.nombreusuarios = nombreusuarios;
    }

    public String getapellidousuarios() {
        return apellidousuarios;
    }

    public void setapellidousuarios(String apellidousuarios) {
        this.apellidousuarios = apellidousuarios;
    }

    public String getcorreousuarios() {
        return correousuarios;
    }

    public void setcorreousuarios(String correousuarios) {
        this.correousuarios = correousuarios;
    }

    public String gettelefonousuarios() {
        return telefonousuarios;
    }

    public void settelefonousuarios(String telefonousuarios) {
        this.telefonousuarios = telefonousuarios;
    }

    public String getdireccionusuario() {
        return direccionusuario;
    }

    public void setdireccionusuario(String direccionusuario) {
        this.direccionusuario = direccionusuario;
    }

    public String getcontraseñausuario() {
        return contraseñausuario;
    }

    public void setcontraseñausuario(String contraseñausuario) {
        this.contraseñausuario = contraseñausuario;
    }

    public int gettipo_documento_idtipodoc() {
        return tipo_documento_idtipodoc;
    }

    public void settipo_documento_idtipodoc(int tipo_documento_idtipodoc) {
        this.tipo_documento_idtipodoc = tipo_documento_idtipodoc;
    }

    public int getroles_idroles() {
        return roles_idroles;
    }

    public void setroles_idroles(int roles_idroles) {
        this.roles_idroles = roles_idroles;
    }

    public int getgenero_idgenero() {
        return genero_idgenero;
    }

    public void setgenero_idgenero(int genero_idgenero) {
        this.genero_idgenero = genero_idgenero;
    }

    public int getestado_usuario_idestadousuario() {
        return estado_usuario_idestadousuario;
    }

    public void setestado_usuario_idestadousuario(int estado_usuario_idestadousuario) {
        this.estado_usuario_idestadousuario = estado_usuario_idestadousuario;
    }
}
