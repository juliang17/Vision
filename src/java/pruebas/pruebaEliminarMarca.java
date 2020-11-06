package Pruebas;

import Controlador.MARCA_PRODUCTO_DAO;
import java.util.ArrayList;
import modelo.marca;

public class pruebaEliminarMarca {

    public static void main(String[] args) {

        MARCA_PRODUCTO_DAO marca_dao = new MARCA_PRODUCTO_DAO();

        ArrayList<marca> listado_marca = marca_dao.listadomarca(1, "");
        for (marca M : listado_marca) {
            System.out.println(" ID. " + M.getIdmarca() + " DESCRIP : " + M.getDescripcionmarca());
        }
        System.out.println("Se elimino");
        marca_dao.Eliminarmarca(listado_marca.get(0));
        listado_marca = marca_dao.listadomarca(1, "");
        for (marca M : listado_marca) {
            System.out.println(" ID. " + M.getIdmarca() + " DESCRIP : " + M.getDescripcionmarca());
        }
    }

}
