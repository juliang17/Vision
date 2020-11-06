
package Pruebas;

import Controlador.PRODUCTOS_DAO;
import java.util.Scanner;
import modelo.productos;


public class PruebaAdicionarProductos {

    public static void main(String[] args) {
        
        PRODUCTOS_DAO productos_dao = new PRODUCTOS_DAO();
       productos mi_productos= new productos();  
       
       Scanner teclado = new Scanner(System.in);
       
       String nombreproducto;
       int cantidadproducto;
       int ivaproducto;
       String descripcionproducto;
       int precio;
        
       System.out.println("Ingrese el nombre del producto");
       nombreproducto = teclado.next();

       System.out.println("Ingrese la cantidad");
       cantidadproducto = teclado.nextInt();
       
       System.out.println("Ingrese el iva");
       ivaproducto = teclado.nextInt();
 
       System.out.println("Ingrese la descripción");
       descripcionproducto = teclado.next();
       
       System.out.println("Ingrese el precio");
       precio = teclado.nextInt();
       
       mi_productos.setNombreproducto(nombreproducto);
       mi_productos.setCantidadproducto(cantidadproducto);
       mi_productos.setIvaproducto(ivaproducto);
       mi_productos.setDescripcionproducto(descripcionproducto);
       mi_productos.setPrecio(precio);
       
       String miRespuesta = productos_dao.adicionarproductos(mi_productos);
    
        if (miRespuesta.length() == 0) {

            System.out.println("Consulta exitosa");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }   
        
    }
    
}
