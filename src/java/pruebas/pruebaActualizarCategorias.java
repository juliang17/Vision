package Pruebas;

import controlador.categoriasDAO;
import java.util.Scanner;
import modelo.categorias;

public class pruebaActualizarCategorias {

    public static void main(String[] args) {

        categoriasDAO categorias_dao = new categoriasDAO();
        categorias mi_categorias = new categorias();

        Scanner teclado = new Scanner(System.in);

        String idcategorias;
        String descripcioncategorias = "";

        System.out.println("Ingrese la categoria");
        descripcioncategorias = teclado.next();

        System.out.println("Ingrese el id");
        idcategorias = teclado.next();

        mi_categorias.setIdcategorias(idcategorias);
        mi_categorias.setDescripcioncategorias(descripcioncategorias);

        mi_categorias.setIdcategorias(idcategorias);

        String respuesta = categorias_dao.Atualizarcategorias(mi_categorias);

        if (respuesta.length() == 0) {

            System.out.println("Actualización exitosa");

        } else {

            System.out.println("Ocurrio un error" + respuesta);

        }
    }

}
