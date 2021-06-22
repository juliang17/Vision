package pruebas;

import controlador.tipo_documentoDAO;
import modelo.tipo_documento;

public class Pruebaconsultartipodedocumento {

    public static void main(String[] args) {

        tipo_documentoDAO mitipodocDAO = new tipo_documentoDAO();
        tipo_documento mitipodoc = mitipodocDAO.Consultartipo_documento("1");

        if (mitipodoc != null) {
            System.out.println("Tipo de documento encontrado:" + mitipodoc.getIdtipodoc() + "_" + mitipodoc.getDescripciontipodoc() + "_");
        } else {
            System.out.println("Tipo de documento no encontrado");
        }
    }

}
