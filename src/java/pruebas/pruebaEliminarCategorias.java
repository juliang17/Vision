/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Controlador.CATEGORIA_PRODUCTO_DAO;
import Modelo.categorias;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class pruebaEliminarCategorias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CATEGORIA_PRODUCTO_DAO categorias_dao = new CATEGORIA_PRODUCTO_DAO();
        
        ArrayList<categorias> listado_categorias = categorias_dao.listadocategorias(1, "");
        for (categorias M : listado_categorias) {
            System.out.println(" ID. " + M.getIdcategorias() + " DESCRIP : " + M.getDescripcioncategorias());
        }
        System.out.println("Se elimino");
        categorias_dao.Eliminarcategorias(listado_categorias.get(0));
        listado_categorias = categorias_dao.listadocategorias(1, "");
       for (categorias M : listado_categorias) {
            System.out.println(" ID. " + M.getIdcategorias() + " DESCRIP : " + M.getDescripcioncategorias());
        }
    }
    
}
