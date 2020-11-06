package Pruebas;

import Controlador.PRODUCTOS_DAO;
import modelo.productos;

public class pruebaConsultarProductos {

    public static void main(String[] args) {

        PRODUCTOS_DAO productos_dao = new PRODUCTOS_DAO();
        productos mi_productos = productos_dao.Consultaproductos(1);

        if (mi_productos != null) {
            System.out.println("producto encontrado " + mi_productos.getIdproductos() + " " + mi_productos.getDescripcionproducto() + " ");
        } else {
            System.out.println("Error en la consulta");
        }
    }

}
