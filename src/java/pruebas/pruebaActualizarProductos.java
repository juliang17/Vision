package Pruebas;

import Controlador.PRODUCTOS_DAO;
import java.util.Scanner;
import modelo.productos;

public class pruebaActualizarProductos {

    public static void main(String[] args) {

        PRODUCTOS_DAO productos_dao = new PRODUCTOS_DAO();
        productos mi_productos = new productos();

        Scanner teclado = new Scanner(System.in);

        int idproductos;
        String nombreproducto;
        int cantidadproducto;
        int ivaproducto;
        String descripcionproducto;
        int precio;

        System.out.println("Ingrese el nombre del producto");
        nombreproducto = teclado.nextLine();

        System.out.println("Ingrese la cantidad");
        cantidadproducto = teclado.nextInt();

        System.out.println("Ingrese el iva");
        ivaproducto = teclado.nextInt();

        System.out.println("Ingrese la descripción");
        descripcionproducto = teclado.nextLine();

        System.out.println("Ingrese el precio");
        precio = teclado.nextInt();

        System.out.println("Ingrese el id");
        idproductos = teclado.nextInt();

        mi_productos.setIdproductos(idproductos);
        mi_productos.setNombreproducto(nombreproducto);
        mi_productos.setCantidadproducto(cantidadproducto);
        mi_productos.setIvaproducto(ivaproducto);
        mi_productos.setDescripcionproducto(descripcionproducto);
        mi_productos.setPrecio(precio);

        mi_productos.setIdproductos(idproductos);

        String respuesta = productos_dao.Actualizarproductos(mi_productos);

        if (respuesta.length() == 0) {

            System.out.println("Actualización exitosa");

        } else {

            System.out.println("Ocurrio un error" + respuesta);

        }
    }

}
