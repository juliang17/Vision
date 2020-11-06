package Pruebas;

import Controlador.MARCA_PRODUCTO_DAO;
import java.util.Scanner;
import modelo.marca;

public class pruebaActualizarMarca {

    public static void main(String[] args) {

        MARCA_PRODUCTO_DAO marca_dao = new MARCA_PRODUCTO_DAO();
        marca mi_marca = new marca();

        Scanner teclado = new Scanner(System.in);

        int idmarca;
        String descripcionmarca = "";

        System.out.println("Ingrese la marca");
        descripcionmarca = teclado.nextLine();

        System.out.println("Ingrese el id");
        idmarca = teclado.nextInt();

        mi_marca.setIdmarca(idmarca);
        mi_marca.setDescripcionmarca(descripcionmarca);

        mi_marca.setIdmarca(idmarca);

        String respuesta = marca_dao.Actualizarmarca(mi_marca);

        if (respuesta.length() == 0) {

            System.out.println("Actualización exitosa");

        } else {

            System.out.println("Ocurrio un error" + respuesta);

        }
    }

}
