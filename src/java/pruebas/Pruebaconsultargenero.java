package pruebas;

import controlador.GeneroDAO;
import modelo.genero;

public class Pruebaconsultargenero {

    public static void main(String[] args) {

        GeneroDAO migeneroDAO = new GeneroDAO();
        genero migenero = migeneroDAO.Consultargenero("");

        if (migenero != null) {
            System.out.println("Genero encontrado" + migenero.getIdgenero() + "_" + migenero.getDescripciongenero() + "_");
        } else {
            System.out.println("Genero no encontrado:");
        }

    }

}
