package pruebas;

import modelo.genero;
import controlador.GeneroDAO;
import java.util.Scanner;


public class Pruebaadicionargenero {

    public static void main(String[] args) {
        
        GeneroDAO miGeneroDAO = new GeneroDAO();
        genero migenero = new genero();

        Scanner leer = new Scanner(System.in);

        String Nombregenero = "";

        System.out.println("Digite descripcion genero");
        Nombregenero = leer.next();

        migenero.setdescripciongenero(Nombregenero);
        String mirespuesta = miGeneroDAO.adicionargenero(migenero);

        if (mirespuesta.length() == 0) {
            System.out.println("Registro exitoso");
        } else {
            System.out.println("ocurrio un error" + mirespuesta);
        }
    }
}
