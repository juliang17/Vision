package Pruebas;

import Controlador.PROVEEDORES_DAO;
import modelo.proveedores;

public class pruebaConsultarProveedores {

    public static void main(String[] args) {

        PROVEEDORES_DAO proveedores_dao = new PROVEEDORES_DAO();
        proveedores mi_proveedores = proveedores_dao.Consultaproveedores(1);

        if (mi_proveedores != null) {
            System.out.println("proveedor encontrado " + mi_proveedores.getIdProveedores() + " " + mi_proveedores.getNombreproveedores() + " ");
        } else {
            System.out.println("Error en la consulta");
        }

    }

}
