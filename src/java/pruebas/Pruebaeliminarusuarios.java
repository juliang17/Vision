package pruebas;

import controlador.usuariosDAO;
import java.util.ArrayList;
import modelo.usuarios;

public class Pruebaeliminarusuarios {

    public static void main(String[] args) {

        usuariosDAO misusuariosDAO = new usuariosDAO();
        ArrayList<usuarios> milistausuarios = misusuariosDAO.Consultarlistadousuarios("", "", "");
        for (usuarios U : milistausuarios) {
            System.out.println(" id : " + U.getIdusuarios() + " Numero de documento : " + U.getNumerodocusuario()
                    + " Nombres : " + U.getNombreusuarios() + " Apellidos : " + U.getApellidousuarios()
                    + " Correo : " + U.getCorreousuarios() + " Telefono : " + U.getTelefonousuarios()
                    + " Direccion : " + U.getDireccionusuario() + " Contraseña : " + U.getClaveusuario()
                    + " Tipo de documento : " + U.getTipo_documento_idtipodoc() + " Rol : " + U.getRoles_idroles()
                    + " Genero : " + U.getGenero_idgenero() + " Estado usuario : " + U.getEstado_usuario_idestadousuario());
        }
        System.out.println("Usuario eliminado");
        misusuariosDAO.Eliminarusuario(milistausuarios.get(0));
        milistausuarios = misusuariosDAO.Consultarlistadousuarios("", "", "");
        for (usuarios U : milistausuarios) {
            System.out.println(" id : " + U.getIdusuarios() + " Numero de documento : " + U.getNumerodocusuario()
                    + " Nombres : " + U.getNombreusuarios() + " Apellidos : " + U.getApellidousuarios()
                    + " Correo : " + U.getCorreousuarios() + " Telefono : " + U.getTelefonousuarios()
                    + " Direccion : " + U.getDireccionusuario() + " Contraseña : " + U.getClaveusuario()
                    + " Tipo de documento : " + U.getTipo_documento_idtipodoc() + " Rol : " + U.getRoles_idroles()
                    + " Genero : " + U.getGenero_idgenero() + " Estado usuario : " + U.getEstado_usuario_idestadousuario());
        }
    }
}
