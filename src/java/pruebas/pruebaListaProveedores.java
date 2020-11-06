package Pruebas;

import Controlador.PROVEEDORES_DAO;
import java.util.ArrayList;
import modelo.proveedores;

public class pruebaListaProveedores {

    public static void main(String[] args) {

        PROVEEDORES_DAO proveedores_dao = new PROVEEDORES_DAO();
        ArrayList<proveedores> mi_proveedores = new ArrayList<proveedores>();
        mi_proveedores = proveedores_dao.listadoproveedores(0, "");

        int size = mi_proveedores.size();
        System.out.println("<table border=\"1\"><tr><td>idProveedores</td><td>nombreproveedores</td><td>correoproveedores</td><td>telefonoproveedores</td> ");

        for (proveedores P : mi_proveedores) {

            System.out.println("<tr>");
            System.out.println("<td>" + P.getIdProveedores() + "</td>");
            System.out.println("<td>" + P.getNombreproveedores() + "</td>");
            System.out.println("<td>" + P.getCorreoproveedores() + "</td>");
            System.out.println("<td>" + P.getTelefonoproveedores() + "</td>");

            System.out.println("</tr>");

        }
    }

}
