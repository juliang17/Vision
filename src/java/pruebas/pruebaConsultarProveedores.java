package Pruebas;

import controlador.ProveedoresDAO;
import modelo.proveedores;

public class pruebaConsultarProveedores {

    public static void main(String[] args) {

        ProveedoresDAO proveedores_dao = new ProveedoresDAO();
        proveedores mi_proveedores = proveedores_dao.ConsultarProveedor("");

        if (mi_proveedores != null) {
            System.out.println("proveedor encontrado " + mi_proveedores.getIdProveedores() + " " + mi_proveedores.getNombreproveedores() + " ");
        } else {
            System.out.println("Error en la consulta");
        }

    }

}
