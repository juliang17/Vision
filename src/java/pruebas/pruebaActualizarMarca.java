package Pruebas;


import controlador.MarcaDAO;
import java.util.Scanner;
import modelo.marca;

public class pruebaActualizarMarca {

    public static void main(String[] args) {

        MarcaDAO marca_dao = new MarcaDAO();
        marca mi_marca = new marca();

        Scanner teclado = new Scanner(System.in);

        String idmarca;
        String descripcionmarca = "";

        System.out.println("Ingrese la marca");
        descripcionmarca = teclado.nextLine();

        System.out.println("Ingrese el id");
        idmarca = teclado.nextLine();

        mi_marca.setIdmarca(idmarca);
        mi_marca.setDescripcionmarca(descripcionmarca);

        mi_marca.setIdmarca(idmarca);

        String respuesta = marca_dao.ActualizarMarca(mi_marca);

        if (respuesta.length() == 0) {

            System.out.println("Actualización exitosa");

        } else {

            System.out.println("Ocurrio un error" + respuesta);

        }
    }

}
