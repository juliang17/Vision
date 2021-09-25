package pruebas;

import controlador.tipo_movDAO;
import java.util.ArrayList;
import modelo.tipo_mov;

public class pruebaListatipomov {

    public static void main(String[] args) {

        tipo_movDAO tipoMovDAO = new tipo_movDAO();
        ArrayList<tipo_mov> miTipoMov = new ArrayList<tipo_mov>();
        miTipoMov = tipoMovDAO.ListadoTipoMov("", "");

        int size = miTipoMov.size();
        System.out.println("<table border=\"1\"><tr><td>idtipodoccontable</td><td>descripciontipodoccontable</td>");

        for (tipo_mov D : miTipoMov) {

            System.out.println("<tr>");
            System.out.println("<td>" + D.getId_tipo_mov() + "</td>");
            System.out.println("<td>" + D.getDescripcionTipoMov() + "</td>");
            System.out.println("</tr>");

        }
    }

}
