package pruebas;

import controlador.rolesDAO;
import modelo.roles;
import java.util.ArrayList;

public class Pruebaeliminarroles {

    public static void main(String[] args) {

        rolesDAO misrolesDAO = new rolesDAO();
        ArrayList<roles> milistaroles = misrolesDAO.Consultarlistadoroles("" , "");
        for (roles R : milistaroles) {
            System.out.println(" id : " + R.getIdroles() + " Descripcion : " + R.getDescripcionrol());
        }
        System.out.println("Registro eliminado");
        misrolesDAO.Eliminarroles(milistaroles.get(0));
        milistaroles = misrolesDAO.Consultarlistadoroles("" , "");
        for (roles R : milistaroles) {
            System.out.println(" id : " + R.getIdroles() + " Descripcion : " + R.getDescripcionrol());
        }
    }

}
