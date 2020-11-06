/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Controlador.CATEGORIA_PRODUCTO_DAO;
import Modelo.categorias;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class pruebaActualizarCategorias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CATEGORIA_PRODUCTO_DAO categorias_dao = new CATEGORIA_PRODUCTO_DAO();
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
