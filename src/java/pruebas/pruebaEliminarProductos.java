package Pruebas;


import controlador.ProductoDAO;
import java.util.ArrayList;
import modelo.productos;

public class pruebaEliminarProductos {

    public static void main(String[] args) {

        ProductoDAO productos_dao = new ProductoDAO();

        ArrayList<productos> listado_productos = productos_dao.listadoproductos(0);
        for (productos P : listado_productos) {
            System.out.println(" ID. " + P.getIdproductos() + " NOMBRE : " + P.getNombreproducto());
        }
        System.out.println("Se elimino");
        productos_dao.Eliminarproductos(listado_productos.get(0));
        listado_productos = productos_dao.listadoproductos(0);
        for (productos P : listado_productos) {
            System.out.println(" ID. " + P.getIdproductos() + " NOMBRE : " + P.getNombreproducto());
        }
    }

}
