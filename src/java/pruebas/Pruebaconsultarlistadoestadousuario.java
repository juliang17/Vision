package pruebas;

import controlador.estado_usuarioDAO;
import java.util.ArrayList;
import modelo.estado_usuario;

public class Pruebaconsultarlistadoestadousuario {

    public static void main(String[] args) {

        estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
        ArrayList<estado_usuario> miestado = new ArrayList<estado_usuario>();
        miestado = miestadousuarioDAO.Consultarlistadoestado_usuario("");

        int size = miestado.size();
        System.out.println("<table border\"1\"><tr><td>idestadousuario</td><td>descripcionestadousuario</td>");

        for (estado_usuario E : miestado) {

            System.out.println("<tr>");
            System.out.println("<tb>" + E.getidestadousuario() + "</tb>");
            System.out.println("<tb>" + E.getdescripcionestadousuario() + "</tb>");

            System.out.println("</tr>");
            System.out.println("</table>");
        }

    }

}
