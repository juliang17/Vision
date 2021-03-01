package Pruebas;


import controlador.ProductoDAO;
import modelo.productos;

public class pruebaConsultarProductos {

    public static void main(String[] args) {

        ProductoDAO productos_dao = new ProductoDAO();
        productos mi_productos = productos_dao.Consultaproductos("");

        if (mi_productos != null) {
            System.out.println("producto encontrado " + mi_productos.getIdproductos() + " " + mi_productos.getDescripcionproducto() + " ");
        } else {
            System.out.println("Error en la consulta");
        }
    }

}
