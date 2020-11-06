package Pruebas;

import Controlador.PROVEEDORES_DAO;
import java.util.ArrayList;
import modelo.proveedores;

public class pruebaEliminarProveedores {

    public static void main(String[] args) {

        PROVEEDORES_DAO proveedores_dao = new PROVEEDORES_DAO();

        ArrayList<proveedores> listado_proveedores = proveedores_dao.listadoproveedores(1, "");
        for (proveedores P : listado_proveedores) {
            System.out.println(" ID. " + P.getIdProveedores() + " NOMBRE : " + P.getNombreproveedores());
        }
        System.out.println("Se elimino");
        proveedores_dao.Eliminarproveedores(listado_proveedores.get(0));
        listado_proveedores = proveedores_dao.listadoproveedores(1, "");
        for (proveedores P : listado_proveedores) {
            System.out.println(" ID. " + P.getIdProveedores() + " NOMBRE : " + P.getNombreproveedores());
        }
    }

}
