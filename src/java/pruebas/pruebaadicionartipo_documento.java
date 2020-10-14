package pruebas;

import controlador.tipo_documentoDAO;
import java.util.Scanner;
import modelo.tipo_documento;

public class pruebaadicionartipo_documento {

    public static void main(String[] args) {

        tipo_documentoDAO mitipodocDAO = new tipo_documentoDAO();
        tipo_documento mitipodoc = new tipo_documento();

        Scanner leer = new Scanner(System.in);

        String Nombretipodoc = "";

        System.out.println("Digite un tipo de documento");
        Nombretipodoc = leer.next();

        mitipodoc.setdescripciontipodoc(Nombretipodoc);
        String mirespuesta = mitipodocDAO.adicionartipo_documento(mitipodoc);

        if (mirespuesta.length() == 0) {
            System.out.println("Registro exitoso");
        } else {
            System.out.println("Ocurrio un error" + mirespuesta);
        }
    }

}
