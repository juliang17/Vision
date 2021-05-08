package pruebas;

import controlador.rolesDAO;
import java.util.ArrayList;
import modelo.roles;

public class Pruebaconsultarlistadoroles {

    public static void main(String[] args) {

        rolesDAO misrolesDAO = new rolesDAO();
        ArrayList<roles> misroles = new ArrayList<roles>();
        misroles = misrolesDAO.Consultarlistadoroles("" , "");

        int size = misroles.size();
        System.out.println("<table border=\"1\"><tr><td>idroles</td><td>descripcionrol</td>");

        for (roles R : misroles) {

            System.out.println("<tr>");
            System.out.println("<tb>" + R.getIdroles() + "</tb>");
            System.out.println("<tb>" + R.getDescripcionrol() + "</tb>");

            System.out.println("</tr>");
            System.out.println("</table>");

        }

    }

}
