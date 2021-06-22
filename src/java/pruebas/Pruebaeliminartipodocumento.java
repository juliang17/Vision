package pruebas;

import controlador.tipo_documentoDAO;
import java.util.ArrayList;
import modelo.tipo_documento;

public class Pruebaeliminartipodocumento {

    public static void main(String[] args) {

        tipo_documentoDAO mitipodocDAO = new tipo_documentoDAO();
        ArrayList<tipo_documento> listatipodoc = mitipodocDAO.Listadotipo_documento("", "");
        for (tipo_documento T : listatipodoc) {
            System.out.println(" id : " + T.getIdtipodoc() + " Descripcion : " + T.getDescripciontipodoc());
        }
        System.out.println("Registro eliminado");
        mitipodocDAO.Eliminartipo_documento(listatipodoc.get(0));
        listatipodoc = mitipodocDAO.Listadotipo_documento("", "");
        for (tipo_documento T : listatipodoc) {
            System.out.println(" id : " + T.getIdtipodoc() + " Descripcion : " + T.getDescripciontipodoc());
        }

    }

}
