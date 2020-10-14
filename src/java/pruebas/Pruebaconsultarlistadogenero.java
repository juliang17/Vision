package pruebas;

import controlador.GeneroDAO;
import java.util.ArrayList;
import modelo.genero;

public class Pruebaconsultarlistadogenero {

    public static void main(String[] args) {

        GeneroDAO migeneroDAO = new GeneroDAO();
        ArrayList<genero> migenero = new ArrayList<genero>();
        migenero = migeneroDAO.Consultarlistadogenero(' ', "");

        int size = migenero.size();
        System.out.println("<table border=\"1\"><tr><td>idgenero</td><td>descripciongenero</td>");

        for (genero G : migenero) {

            System.out.println("<tr>");
            System.out.println("tb>" + G.getidgenero() + "</tb>");
            System.out.println("tb>" + G.getdescripciongenero() + "</tb>");

            System.out.println("</tr>");
            System.out.println("</table>");
        }

    }

}
