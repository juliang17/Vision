package pruebas;

import controlador.tipo_documentoDAO;
import java.util.Scanner;
import modelo.tipo_documento;

public class Pruebaactualizartipodedocumento {

    public static void main(String[] args) {

        tipo_documentoDAO mitipodocDAO = new tipo_documentoDAO();
        tipo_documento mitipodoc = new tipo_documento();

        Scanner leer = new Scanner(System.in);

        String descripciontipodoc = "";

        System.out.println("Digite el tipo de documento");
        descripciontipodoc = leer.next();

        mitipodoc.setdescripciontipodoc(descripciontipodoc);

        mitipodoc.setidtipodoc(1);

        String mirespuesta = mitipodocDAO.actualizartipo_documento(mitipodoc);

        if (mirespuesta.length() == 0) {
            System.out.println("Tipo de documento actualizado");
        } else {
            System.out.println("Error" + mirespuesta);
        }
    }

}
