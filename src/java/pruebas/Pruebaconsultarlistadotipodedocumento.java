package pruebas;

import controlador.tipo_documentoDAO;
import java.util.ArrayList;
import modelo.tipo_documento;

public class Pruebaconsultarlistadotipodedocumento {

    public static void main(String[] args) {

        tipo_documentoDAO mitipodocDAO = new tipo_documentoDAO();
        ArrayList<tipo_documento> mitipodoc = new ArrayList<tipo_documento>();
        mitipodoc = mitipodocDAO.Listadotipo_documento("", "");

        int size = mitipodoc.size();
        System.out.println("<table border=\"1\"><tr><td>idtipodoc</td><td>descripciontipodoc></td>");

        for (tipo_documento T : mitipodoc) {

            System.out.println("<tr>");
            System.out.println("<tb>" + T.getIdtipodoc() + "</tb>");
            System.out.println("<tb>" + T.getDescripciontipodoc() + "</tb>");

            System.out.println("</tr>");
            System.out.println("</table>");
        }

    }

}
