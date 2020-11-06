package Pruebas;

import Controlador.MARCA_PRODUCTO_DAO;
import java.util.Scanner;
import modelo.marca;

public class PruebaAdicionarMarca {

    public static void main(String[] args) {

        MARCA_PRODUCTO_DAO marca_dao = new MARCA_PRODUCTO_DAO();
        marca mi_marca = new marca();

        Scanner teclado = new Scanner(System.in);

        String descripcionmarca = "";

        System.out.println("Ingrese la marca");
        descripcionmarca = teclado.next();

        mi_marca.setDescripcionmarca(descripcionmarca);
        String miRespuesta = marca_dao.adicionarmarca(mi_marca);

        if (miRespuesta.length() == 0) {

            System.out.println("Consulta exitosa");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }

    }
}
