package pruebas;

import controlador.inventarioDAO;
import java.util.ArrayList;
import modelo.inventario;

public class PruebaListarInventario {

    public static void main(String[] args) {
        
        inventarioDAO INVENDAO = new inventarioDAO();
        ArrayList<inventario> milistainventario = new ArrayList<inventario>();
        milistainventario = INVENDAO.Consultarlistadoinventario(2);

        int size = milistainventario.size();
        System.out.println("<table border=\"1\"><tr><td>idinventario</td><td>entrada</td><td>salida</td><td>saldo</td><td>productos_idproductos</td>");

        for (inventario I: milistainventario) {

            System.out.println("<tr>");
            System.out.println("<tb>" + I.getIdinventario() + "</td>");
            System.out.println("<tb>" + I.getEntrada() + "</td>");
            System.out.println("<tb>" + I.getSalida() + "</td>");
            System.out.println("<tb>" + I.getSaldo() + "</td>");
            System.out.println("<tb>" + I.getProductos_idproductos() + "</td>");

            System.out.println("</tr>");
            System.out.println("</table>");
        }

    }

}
