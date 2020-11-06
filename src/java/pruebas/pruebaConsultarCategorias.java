/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Controlador.CATEGORIA_PRODUCTO_DAO;
import Modelo.categorias;

/**
 *
 * @author hp
 */
public class pruebaConsultarCategorias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CATEGORIA_PRODUCTO_DAO categorias_dao = new CATEGORIA_PRODUCTO_DAO();
        categorias mi_categorias = categorias_dao.Consultacategorias(1);

        if (mi_categorias != null) {
            System.out.println("categoria encontrada " + mi_categorias.getIdcategorias() + " " + mi_categorias.getDescripcioncategorias() + " ");
        } else {
            System.out.println("Error en la consulta");
        }
    }

}
