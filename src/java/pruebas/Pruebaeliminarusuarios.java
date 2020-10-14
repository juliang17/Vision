package pruebas;

import controlador.usuariosDAO;
import java.util.ArrayList;
import modelo.usuarios;

public class Pruebaeliminarusuarios {

    public static void main(String[] args) {

        usuariosDAO misusuariosDAO = new usuariosDAO();
        ArrayList<usuarios> milistausuarios = misusuariosDAO.Consultarlistadousuarios(' ', "", "");
        for (usuarios U : milistausuarios) {
            System.out.println(" id : " + U.getidusuarios() + " Numero de documento : " + U.getnumerodocusuario()
                    + " Nombres : " + U.getnombreusuarios() + " Apellidos : " + U.getapellidousuarios()
                    + " Correo : " + U.getcorreousuarios() + " Telefono : " + U.gettelefonousuarios()
                    + " Direccion : " + U.getdireccionusuario() + " Contraseña : " + U.getcontraseñausuario()
                    + " Tipo de documento : " + U.gettipo_documento_idtipodoc() + " Rol : " + U.getroles_idroles()
                    + " Genero : " + U.getgenero_idgenero() + " Estado usuario : " + U.getestado_usuario_idestadousuario());
        }
        System.out.println("Usuario eliminado");
        misusuariosDAO.Eliminarusuario(milistausuarios.get(0));
        milistausuarios = misusuariosDAO.Consultarlistadousuarios(' ', "", "");
        for (usuarios U : milistausuarios) {
            System.out.println(" id : " + U.getidusuarios() + " Numero de documento : " + U.getnumerodocusuario()
                    + " Nombres : " + U.getnombreusuarios() + " Apellidos : " + U.getapellidousuarios()
                    + " Correo : " + U.getcorreousuarios() + " Telefono : " + U.gettelefonousuarios()
                    + " Direccion : " + U.getdireccionusuario() + " Contraseña : " + U.getcontraseñausuario()
                    + " Tipo de documento : " + U.gettipo_documento_idtipodoc() + " Rol : " + U.getroles_idroles()
                    + " Genero : " + U.getgenero_idgenero() + " Estado usuario : " + U.getestado_usuario_idestadousuario());
        }
    }
}
