
package pruebas;

import controlador.inventarioDAO;
import java.util.Scanner;
import modelo.inventario;

public class PruebaAdicionarInventario {

    public static void main(String[] args) {
       
        inventarioDAO INVENDAO = new inventarioDAO();
        inventario miinventario = new inventario();
       
       Scanner teclado = new Scanner(System.in);
       
       int entrada;
       int salida;
       int saldo;
       int productos_idproductos;
        
       System.out.println("Ingrese la cantidad entrante");
       entrada = teclado.nextInt();
       System.out.println("Ingrese la cantidad saliente ");
       salida = teclado.nextInt();
       System.out.println("Ingrese el la cantidad restante");
       saldo = teclado.nextInt();
       System.out.println("Ingrese el producto");
       productos_idproductos = teclado.nextInt();
 
       
       
       miinventario.setEntrada(entrada);
       miinventario.setSalida(salida);
       miinventario.setSaldo(saldo);
       miinventario.setProductos_idproductos(productos_idproductos);
       
       String miRespuesta = INVENDAO.adicionarinventario(miinventario);
    
        if (miRespuesta.length() == 0) {

            System.out.println("registro exitoso");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        } 
    }
    
}
