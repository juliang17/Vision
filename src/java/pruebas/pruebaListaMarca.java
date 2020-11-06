package Pruebas;

import Controlador.MARCA_PRODUCTO_DAO;
import java.util.ArrayList;
import modelo.marca;

public class pruebaListaMarca {

    public static void main(String[] args) {

        MARCA_PRODUCTO_DAO marca_dao = new MARCA_PRODUCTO_DAO();
        ArrayList<marca> mi_marca = new ArrayList<marca>();
        mi_marca = marca_dao.listadomarca(0, "");

        int size = mi_marca.size();
        System.out.println("<table border=\"1\"><tr><td>idmarca</td><td>descripcionmarca</td> ");

        for (marca M : mi_marca) {

            System.out.println("<tr>");
            System.out.println("<td>" + M.getIdmarca() + "</td>");
            System.out.println("<td>" + M.getDescripcionmarca() + "</td>");

            System.out.println("</tr>");

        }
    }

}
