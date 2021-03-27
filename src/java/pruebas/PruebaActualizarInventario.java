package pruebas;

import controlador.inventarioDAO;
import java.util.Scanner;
import modelo.inventario;

public class PruebaActualizarInventario {

    public static void main(String[] args) {

        inventarioDAO INVENDAO = new inventarioDAO();
        inventario miinventario = new inventario();
        
        Scanner teclado = new Scanner(System.in);

        int idinventario;
        int entrada;
        int salida;
        int saldo;
        int productos_idproductos;

        System.out.println("Ingrese el id");
        idinventario = teclado.nextInt();
        System.out.println("Ingrese la cantidad entrante");
        entrada = teclado.nextInt();
        System.out.println("Ingrese la cantidad saliente");
        salida = teclado.nextInt();
        System.out.println("Ingrese la cantidad restante");
        saldo = teclado.nextInt();
        System.out.println("Ingrese el producto");
        productos_idproductos = teclado.nextInt();
        System.out.println("Ingrese el id");
        idinventario = teclado.nextInt();

        miinventario.setIdinventario(idinventario);
        miinventario.setEntrada(entrada);
        miinventario.setSalida(salida);
        miinventario.setSaldo(saldo);
        miinventario.setProductos_idproductos(productos_idproductos);

        miinventario.setIdinventario(idinventario);

        String respuesta = INVENDAO.Actualizarinventario(miinventario);

        if (respuesta.length() == 0) {

            System.out.println("Actualización exitosa");

        } else {

            System.out.println("Ocurrio un error" + respuesta);

        }

    }

}
