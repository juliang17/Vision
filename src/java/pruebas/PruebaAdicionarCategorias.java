
package Pruebas;

import Controlador.CATEGORIA_PRODUCTO_DAO;
import java.util.Scanner;
import modelo.categorias;

public class PruebaAdicionarCategorias {

    
    public static void main(String[] args) {
        
       CATEGORIA_PRODUCTO_DAO categorias_dao = new CATEGORIA_PRODUCTO_DAO();
       categorias mi_categorias= new categorias();  
       
       Scanner teclado = new Scanner(System.in);
       
       String descripcioncategorias = "";
        
       System.out.println("Ingrese la categoria");
       descripcioncategorias = teclado.next();
        
       mi_categorias.setDescripcioncategorias(descripcioncategorias);
       String miRespuesta = categorias_dao.adicionarcategorias(mi_categorias);
    
        if (miRespuesta.length() == 0) {

            System.out.println("Consulta exitosa");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }   
    }
    
}
