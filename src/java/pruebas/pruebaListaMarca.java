package Pruebas;


import controlador.MarcaDAO;
import java.util.ArrayList;
import modelo.marca;

public class pruebaListaMarca {

    public static void main(String[] args) {

        MarcaDAO marca_dao = new MarcaDAO();
        ArrayList<marca> mi_marca = new ArrayList<marca>();
        mi_marca = marca_dao.listadomarca("");

        int size = mi_marca.size();
        System.out.println("<table border=\"1\"><tr><td>idmarca</td><td>descripcionmarca</td> ");

        for (marca M : mi_marca) {

            System.out.println("<tr>");
            System.out.println("<td>" + M.getIdmarca() + "</td>");
            System.out.println("<td>" + M.getDescripcionmarca() + "</td>");

            System.out.println("</tr>");

        }
    }

}
