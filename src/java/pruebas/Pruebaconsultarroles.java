package pruebas;

import controlador.rolesDAO;
import modelo.roles;

public class Pruebaconsultarroles {

    public static void main(String[] args) {

        rolesDAO misrolesDAO = new rolesDAO();
        roles misroles = misrolesDAO.Consultarroles("");

        if (misroles != null) {
            System.out.println("Rol encontrado:" + misroles.getIdroles() + "_" + misroles.getDescripcionrol() + "_");

        } else {
            System.out.println("Rol no encontrado");
        }

    }

}
