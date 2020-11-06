package pruebas;

import controlador.GeneroDAO;
import java.util.ArrayList;
import modelo.genero;

public class Pruebaeliminargenero {

    public static void main(String[] args) {

        GeneroDAO miGeneroDAO = new GeneroDAO();
        ArrayList<genero> milistagenero = miGeneroDAO.Consultarlistadogenero("");
        for (genero G : milistagenero) {
            System.out.println("id: " + G.getidgenero() + "Descripcion: " + G.getdescripciongenero());
        }
        System.out.println("Registro eliminado");
        miGeneroDAO.Eliminargenero(milistagenero.get(0));
        milistagenero = miGeneroDAO.Consultarlistadogenero("");
        for (genero G : milistagenero) {
            System.out.println("id: " + G.getidgenero() + "Descripcion: " + G.getdescripciongenero());
        }
    }
}
