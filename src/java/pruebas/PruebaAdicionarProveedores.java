package Pruebas;


import controlador.ProveedoresDAO;
import java.util.Scanner;
import modelo.proveedores;

public class PruebaAdicionarProveedores {

    public static void main(String[] args) {

        ProveedoresDAO proveedores_dao = new ProveedoresDAO();
        proveedores mi_proveedores = new proveedores();

        Scanner teclado = new Scanner(System.in);

        String nombreproveedores = "";
        String correoproveedores = "";
        int telefonoproveedores;

        System.out.println("Ingrese el nombre del proveedor");
        nombreproveedores = teclado.nextLine();

        System.out.println("Ingrese el correo");
        correoproveedores = teclado.nextLine();

        System.out.println("Ingrese el telefono");
        telefonoproveedores = teclado.nextInt();

        mi_proveedores.setNombreproveedores(nombreproveedores);
        mi_proveedores.setCorreoproveedores(correoproveedores);
        mi_proveedores.setTelefonoproveedores(telefonoproveedores);

        String miRespuesta = proveedores_dao.AdicionarProveedor(mi_proveedores);

        if (miRespuesta.length() == 0) {

            System.out.println("Consulta exitosa");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }
    }

}
