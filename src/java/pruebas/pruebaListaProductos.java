package Pruebas;

import Controlador.PRODUCTOS_DAO;
import java.util.ArrayList;
import modelo.productos;

public class pruebaListaProductos {

    public static void main(String[] args) {

        PRODUCTOS_DAO productos_dao = new PRODUCTOS_DAO();
        ArrayList<productos> mi_productos = new ArrayList<productos>();
        mi_productos = productos_dao.listadoproductos(0, 0);

        int size = mi_productos.size();
        System.out.println("<table border=\"1\"><tr><td>idproductos</td><td>nombreproducto</td><td>cantidadproducto</td><td>ivaproducto</td><td>descripcionproducto</td><td>precio</td> ");

        for (productos P : mi_productos) {

            System.out.println("<tr>");
            System.out.println("<td>" + P.getIdproductos() + "</td>");
            System.out.println("<td>" + P.getNombreproducto() + "</td>");
            System.out.println("<td>" + P.getCantidadproducto() + "</td>");
            System.out.println("<td>" + P.getIvaproducto() + "</td>");
            System.out.println("<td>" + P.getDescripcionproducto() + "</td>");
            System.out.println("<td>" + P.getPrecio() + "</td>");

            System.out.println("</tr>");

        }
    }

}
