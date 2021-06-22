package Pruebas;

import controlador.categoriasDAO;
import java.util.Scanner;
import modelo.categorias;

public class PruebaAdicionarCategorias {

    public static void main(String[] args) {

        categoriasDAO categorias_dao = new categoriasDAO();
        categorias mi_categorias = new categorias();

        Scanner teclado = new Scanner(System.in);

        String descripcioncategorias = "";

        System.out.println("Ingrese la categoria");
        descripcioncategorias = teclado.next();

        mi_categorias.setDescripcioncategorias(descripcioncategorias);
        String miRespuesta = categorias_dao.Adicionarcategorias(mi_categorias);

        if (miRespuesta.length() == 0) {

            System.out.println("Registro exitosa");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }
    }

}
