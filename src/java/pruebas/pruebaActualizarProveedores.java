package Pruebas;


import controlador.ProveedoresDAO;
import java.util.Scanner;
import modelo.proveedores;

public class pruebaActualizarProveedores {

    public static void main(String[] args) {

        ProveedoresDAO proveedores_dao = new ProveedoresDAO();
        proveedores mi_proveedores = new proveedores();

        Scanner teclado = new Scanner(System.in);

        int idProveedores;
        String nombreproveedores = "";
        String correoproveedores = "";
        int telefonoproveedores;

        System.out.println("Ingrese el nombre del proveedor");
        nombreproveedores = teclado.nextLine();

        System.out.println("Ingrese el correo");
        correoproveedores = teclado.nextLine();

        System.out.println("Ingrese el telefono");
        telefonoproveedores = teclado.nextInt();

        System.out.println("Ingrese el id");
        idProveedores = teclado.nextInt();

        mi_proveedores.setIdProveedores(idProveedores);
        mi_proveedores.setNombreproveedores(nombreproveedores);
        mi_proveedores.setCorreoproveedores(correoproveedores);
        mi_proveedores.setTelefonoproveedores(telefonoproveedores);

        mi_proveedores.setIdProveedores(idProveedores);

        String respuesta = proveedores_dao.Actualizarproveedores(mi_proveedores);

        if (respuesta.length() == 0) {

            System.out.println("Actualización exitosa");

        } else {

            System.out.println("Ocurrio un error" + respuesta);

        }

    }

}
