package Pruebas;

import Controlador.PRODUCTOS_DAO;
import java.util.ArrayList;
import modelo.productos;

public class pruebaEliminarProductos {

    public static void main(String[] args) {

        PRODUCTOS_DAO productos_dao = new PRODUCTOS_DAO();

        ArrayList<productos> listado_productos = productos_dao.listadoproductos(1, 1);
        for (productos P : listado_productos) {
            System.out.println(" ID. " + P.getIdproductos() + " NOMBRE : " + P.getNombreproducto());
        }
        System.out.println("Se elimino");
        productos_dao.Eliminarproductos(listado_productos.get(0));
        listado_productos = productos_dao.listadoproductos(1, 1);
        for (productos P : listado_productos) {
            System.out.println(" ID. " + P.getIdproductos() + " NOMBRE : " + P.getNombreproducto());
        }
    }

}
