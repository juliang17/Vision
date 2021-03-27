package Pruebas;


import controlador.ProductoDAO;
import java.util.ArrayList;
import modelo.productos;

public class pruebaListaProductos {

    public static void main(String[] args) {

        ProductoDAO productos_dao = new ProductoDAO();
        ArrayList<productos> mi_productos = new ArrayList<productos>();
        mi_productos = productos_dao.listadoproductos("","");

        int size = mi_productos.size();
        System.out.println("<table border=\"1\"><tr><td>idproductos</td><td>nombreproducto</td><td>cantidadproducto</td><td>ivaproducto</td><td>descripcionproducto</td><td>precio</td><td>Categoria</td><td>Marca</td><td>UnidadDemedida</td><td>Proveedoes</td> ");

        for (productos P : mi_productos) {

            System.out.println("<tr>");
            System.out.println("<td>" + P.getIdproductos() + "</td>");
            System.out.println("<td>" + P.getNombreproducto() + "</td>");
            System.out.println("<td>" + P.getCantidadproducto() + "</td>");
            System.out.println("<td>" + P.getIvaproducto() + "</td>");
            System.out.println("<td>" + P.getDescripcionproducto() + "</td>");
            System.out.println("<td>" + P.getPrecio() + "</td>");
            System.out.println("<td>" + P.getCategorias_idcategorias() + "</td>");
            System.out.println("<td>" + P.getMarca_idmarca() + "</td>");
            System.out.println("<td>" + P.getUnidad_de_medida_idunidadmedida() + "</td>");
            System.out.println("<td>" + P.getProveedores_idproveedores() + "</td>");

            System.out.println("</tr>");
            System.out.println("</table>");

        }
    }

}
