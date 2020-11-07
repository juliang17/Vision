package Pruebas;

import Controlador.categoriasDAO;
import java.util.Scanner;
import modelo.categorias;

public class pruebaActualizarCategorias {

    public static void main(String[] args) {

        categoriasDAO categorias_dao = new categoriasDAO();
        categorias mi_categorias = new categorias();

        Scanner teclado = new Scanner(System.in);

        int idcategorias;
        String descripcioncategorias = "";

        System.out.println("Ingrese la categoria");
        descripcioncategorias = teclado.next();

        System.out.println("Ingrese el id");
        idcategorias = teclado.nextInt();

        mi_categorias.setIdcategorias(idcategorias);
        mi_categorias.setDescripcioncategorias(descripcioncategorias);

        mi_categorias.setIdcategorias(idcategorias);

        String respuesta = categorias_dao.Actualizarcategorias(mi_categorias);

        if (respuesta.length() == 0) {

            System.out.println("Actualización exitosa");

        } else {

            System.out.println("Ocurrio un error" + respuesta);

        }
    }

}
