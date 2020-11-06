package Pruebas;

import Controlador.MARCA_PRODUCTO_DAO;
import modelo.marca;

public class pruebaConsultarMarca {

    public static void main(String[] args) {

        MARCA_PRODUCTO_DAO marca_dao = new MARCA_PRODUCTO_DAO();
        marca mi_marca = marca_dao.Consultamarca(1);

        if (mi_marca != null) {
            System.out.println("marca encontrada " + mi_marca.getIdmarca() + " " + mi_marca.getDescripcionmarca() + " ");
        } else {
            System.out.println("Error en la consulta");
        }
    }

}
