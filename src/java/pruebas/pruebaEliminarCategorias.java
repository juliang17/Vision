package Pruebas;

import controlador.categoriasDAO;
import java.util.ArrayList;
import modelo.categorias;

public class pruebaEliminarCategorias {

    public static void main(String[] args) {
        categoriasDAO categorias_dao = new categoriasDAO();

        ArrayList<categorias> listado_categorias = categorias_dao.listadocategorias("");
        for (categorias M : listado_categorias) {
            System.out.println(" ID. " + M.getIdcategorias() + " DESCRIP : " + M.getDescripcioncategorias());
        }
        System.out.println("Se elimino");
        categorias_dao.Eliminarcategorias(listado_categorias.get(0));
        listado_categorias = categorias_dao.listadocategorias("");
        for (categorias M : listado_categorias) {
            System.out.println(" ID. " + M.getIdcategorias() + " DESCRIP : " + M.getDescripcioncategorias());
        }
    }

}
