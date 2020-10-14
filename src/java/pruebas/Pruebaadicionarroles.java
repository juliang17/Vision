package pruebas;

import controlador.rolesDAO;
import java.util.Scanner;
import modelo.roles;

public class Pruebaadicionarroles {

    public static void main(String[] args) {

        rolesDAO misrolesDAO = new rolesDAO();
        roles misroles = new roles();

        Scanner leer = new Scanner(System.in);

        String Nombreroles = "";

        System.out.println("Digite un rol");
        Nombreroles = leer.next();

        misroles.setdescripcionrol(Nombreroles);
        String mirespuesta = misrolesDAO.adicionarroles(misroles);

        if (mirespuesta.length() == 0) {
            System.out.println("Registro exitoso");
        } else {
            System.out.println("Ocurrio un error" + mirespuesta);
        }

    }

}
