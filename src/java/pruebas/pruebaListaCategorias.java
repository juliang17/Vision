package Pruebas;

import controlador.categoriasDAO;
import java.util.ArrayList;
import modelo.categorias;

public class pruebaListaCategorias {

    public static void main(String[] args) {

        categoriasDAO categorias_dao = new categoriasDAO();
        ArrayList<categorias> mi_categorias = new ArrayList<categorias>();
        mi_categorias = categorias_dao.listadocategorias("");

        int size = mi_categorias.size();
        System.out.println("<table border=\"1\"><tr><td>idcategorias</td><td>descripcioncategorias</td> ");

        for (categorias C : mi_categorias) {

            System.out.println("<tr>");
            System.out.println("<td>" + C.getIdcategorias() + "</td>");
            System.out.println("<td>" + C.getDescripcioncategorias() + "</td>");

            System.out.println("</tr>");

        }
    }

}
