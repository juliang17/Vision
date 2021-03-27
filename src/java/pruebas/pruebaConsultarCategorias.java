package Pruebas;

import controlador.categoriasDAO;
import modelo.categorias;

public class pruebaConsultarCategorias {

    public static void main(String[] args) {

        categoriasDAO categorias_dao = new categoriasDAO();
        categorias mi_categorias = categorias_dao.Consultacategorias(0);

        if (mi_categorias != null) {
            System.out.println("categoria encontrada " + mi_categorias.getIdcategorias() + " " + mi_categorias.getDescripcioncategorias() + " ");
        } else {
            System.out.println("Error en la consulta");
        }
    }

}
