package Pruebas;


import controlador.MarcaDAO;
import java.util.Scanner;
import modelo.marca;

public class PruebaAdicionarMarca {

    public static void main(String[] args) {

        MarcaDAO marca_dao = new MarcaDAO();
        marca mi_marca = new marca();

        Scanner teclado = new Scanner(System.in);

        String descripcionmarca = "";

        System.out.println("Ingrese la marca");
        descripcionmarca = teclado.next();

        mi_marca.setDescripcionmarca(descripcionmarca);
        String miRespuesta = marca_dao.AdicionarMarca(mi_marca);

        if (miRespuesta.length() == 0) {

            System.out.println("Consulta exitosa");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }

    }
}
