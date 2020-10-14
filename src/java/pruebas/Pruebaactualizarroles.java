package pruebas;

import controlador.rolesDAO;
import java.util.Scanner;
import modelo.roles;

public class Pruebaactualizarroles {

    public static void main(String[] args) {

        rolesDAO misrolesDAO = new rolesDAO();
        roles misroles = new roles();

        Scanner leer = new Scanner(System.in);

        String descripcionrol = "";

        System.out.println("Digite un rol");
        descripcionrol = leer.next();

        misroles.setdescripcionrol(descripcionrol);

        misroles.setidroles(1);

        String mirespuesta = misrolesDAO.actualizarroles(misroles);

        if (mirespuesta.length() == 0) {
            System.out.println("Rol actualizado");
        } else {
            System.out.println("error" + mirespuesta);
        }
    }

}
