package pruebas;

import controlador.usuariosDAO;
import java.util.ArrayList;
import modelo.usuarios;

public class Pruebaconsultarlistadousuarios {

    public static void main(String[] args) {

        usuariosDAO misusuariosDAO = new usuariosDAO();
        ArrayList<usuarios> misusuarios = new ArrayList<usuarios>();
        misusuarios = misusuariosDAO.Consultarlistadousuarios("", "", "");

        int size = misusuarios.size();
        System.out.println("<table border=\"1\"><tr><td>idusuarios</td><td>numerodocusuario</td><td>nombreusuarios</td><td>apellidousuarios</td><td>correousuarios</td><td>telefonousuarios</td><td>direccionusuario</td><td>clave</td><td>tipo_documento_idtipodoc</td><td>roles_idroles</td><td>genero_idgenero</td><td>estado_usuario_idestadousuario</td>");

        for (usuarios U: misusuarios) {

            System.out.println("<tr>");
            System.out.println("<tb>" + U.getIdusuarios() + "</td>");
            System.out.println("<tb>" + U.getNumerodocusuario() + "</td>");
            System.out.println("<tb>" + U.getNombreusuarios() + "</td>");
            System.out.println("<tb>" + U.getApellidousuarios() + "</td>");
            System.out.println("<tb>" + U.getCorreousuarios() + "</td>");
            System.out.println("<tb>" + U.getTelefonousuarios() + "</td>");
            System.out.println("<tb>" + U.getDireccionusuario() + "</td>");
            System.out.println("<tb>" + U.getClaveusuario() + "</td>");
            System.out.println("<tb>" + U.getTipo_documento_idtipodoc() + "</td>");
            System.out.println("<tb>" + U.getRoles_idroles() + "</td>");
            System.out.println("<tb>" + U.getGenero_idgenero() + "</td>");
            System.out.println("<tb>" + U.getEstado_usuario_idestadousuario() + "</td>");

            System.out.println("</tr>");
            System.out.println("</table>");
        }
        
    }

}
