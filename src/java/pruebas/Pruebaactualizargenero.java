package pruebas;


import controlador.GeneroDAO;
import java.util.Scanner;
import modelo.genero;

public class Pruebaactualizargenero {

    public static void main(String[] args) {
        
        GeneroDAO miGeneroDAO = new GeneroDAO();
        genero migenero = new genero();
        
        Scanner leer = new Scanner(System.in);
        
        String descripciongenero = "";
        
        System.out.println("Digite un genero");
        descripciongenero = leer.next();
                
        migenero.setdescripciongenero(descripciongenero);

        migenero.setidgenero(1);
        
        String mirespuesta = miGeneroDAO.actualizargenero(migenero);
        
        if(mirespuesta.length()==0){
            System.out.println("Genero actualizado");
        } else {
        System.out.println("Error" + mirespuesta);
        }
    }
   
}
