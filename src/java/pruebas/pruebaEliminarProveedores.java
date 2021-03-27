package Pruebas;

import controlador.ProveedoresDAO;
import java.util.ArrayList;
import modelo.proveedores;

public class pruebaEliminarProveedores {

    public static void main(String[] args) {

        ProveedoresDAO proveedores_dao = new ProveedoresDAO();

        ArrayList<proveedores> listado_proveedores = proveedores_dao.listadoproveedores("","","");
        for (proveedores P : listado_proveedores) {
            System.out.println(" ID. " + P.getIdProveedores() + " NOMBRE : " + P.getNombreproveedores());
        }
        System.out.println("Se elimino");
        proveedores_dao.Eliminarproveedores(listado_proveedores.get(0));
        listado_proveedores = proveedores_dao.listadoproveedores("","","");
        for (proveedores P : listado_proveedores) {
            System.out.println(" ID. " + P.getIdProveedores() + " NOMBRE : " + P.getNombreproveedores());
        }
    }

}
