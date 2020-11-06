
package Pruebas;
import Controlador.CATEGORIA_PRODUCTO_DAO;
import java.util.ArrayList;
import modelo.categorias;

public class pruebaListaCategorias {

    public static void main(String[] args) {
        
        CATEGORIA_PRODUCTO_DAO categorias_dao = new CATEGORIA_PRODUCTO_DAO();
        ArrayList<categorias> mi_categorias = new ArrayList<categorias>();
        mi_categorias = categorias_dao.listadocategorias(0, "");

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
