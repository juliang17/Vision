package pruebas;

import controlador.usuariosDAO;
import java.util.ArrayList;
import modelo.usuarios;

public class Pruebaconsultarlistadousuarios {

    public static void main(String[] args) {

        usuariosDAO misusuariosDAO = new usuariosDAO();
        ArrayList<usuarios> misusuarios = new ArrayList<usuarios>();
        misusuarios = misusuariosDAO.Consultarlistadousuarios(' ', "", "");

        int size = misusuarios.size();
        System.out.println("<table border=\"1\"><tr><td>idusuarios</td><td>numerodocusuario</td><td>nombreusuarios</td><td>apellidousuarios</td><td>correousuarios</td><td>telefonousuarios</td><td>direccionusuario</td><td>contraseñausuario</td><td>tipo_documento_idtipodoc</td><td>roles_idroles</td><td>genero_idgenero</td><td>estado_usuario_idestadousuario</td>");

        for (usuarios U: misusuarios) {

            System.out.println("<tr>");
            System.out.println("<tb>" + U.getidusuarios() + "</td>");
            System.out.println("<tb>" + U.getnumerodocusuario() + "</td>");
            System.out.println("<tb>" + U.getnombreusuarios() + "</td>");
            System.out.println("<tb>" + U.getapellidousuarios() + "</td>");
            System.out.println("<tb>" + U.getcorreousuarios() + "</td>");
            System.out.println("<tb>" + U.gettelefonousuarios() + "</td>");
            System.out.println("<tb>" + U.getdireccionusuario() + "</td>");
            System.out.println("<tb>" + U.getcontraseñausuario() + "</td>");
            System.out.println("<tb>" + U.gettipo_documento_idtipodoc() + "</td>");
            System.out.println("<tb>" + U.getroles_idroles() + "</td>");
            System.out.println("<tb>" + U.getgenero_idgenero() + "</td>");
            System.out.println("<tb>" + U.getestado_usuario_idestadousuario() + "</td>");

            System.out.println("</tr>");
            System.out.println("</table>");
        }
        
    }

}
