package Pruebas;

import controlador.ProductoDAO;
import java.util.Scanner;
import modelo.productos;

public class pruebaActualizarProductos {

    public static void main(String[] args) {

        ProductoDAO productos_dao = new ProductoDAO();
        productos mi_productos = new productos();

        Scanner teclado = new Scanner(System.in);

        String referenciaproducto;
        String nombreproducto;
        int cantidadproducto;
        int ivaproducto;
        String descripcionproducto;
        int precio;
        int Categorias_idcategorias;
        int Marca_idmarca;
        int Unidad_de_medida_idunidadmedida;
        int Proveedores_idproveedores;

        System.out.println("Ingrese la refencia del producto");
        referenciaproducto = teclado.next();
        System.out.println("Ingrese el nombre del producto");
        nombreproducto = teclado.next();
        System.out.println("Ingrese la cantidad");
        cantidadproducto = teclado.nextInt();
        System.out.println("Ingrese el iva");
        ivaproducto = teclado.nextInt();
        System.out.println("Ingrese la descripción");
        descripcionproducto = teclado.next();
        System.out.println("Ingrese el precio");
        precio = teclado.nextInt();
        System.out.println("Ingrese categoria");
        Categorias_idcategorias = teclado.nextInt();
        System.out.println("Ingrese marca");
        Marca_idmarca = teclado.nextInt();
        System.out.println("Ingrese unidad de medida");
        Unidad_de_medida_idunidadmedida = teclado.nextInt();
        System.out.println("Ingrese proveedor");
        Proveedores_idproveedores = teclado.nextInt();
        System.out.println("Ingrese la referencia del producto");
        referenciaproducto = teclado.next();

        mi_productos.setReferenciaproducto(referenciaproducto);
        mi_productos.setNombreproducto(nombreproducto);
        mi_productos.setCantidadproducto(cantidadproducto);
        mi_productos.setIvaproducto(ivaproducto);
        mi_productos.setDescripcionproducto(descripcionproducto);
        mi_productos.setPrecio(precio);
        mi_productos.setCategorias_idcategorias(Categorias_idcategorias);
        mi_productos.setMarca_idmarca(Marca_idmarca);
        mi_productos.setUnidad_de_medida_idunidadmedida(Unidad_de_medida_idunidadmedida);
        mi_productos.setProveedores_idproveedores(Proveedores_idproveedores);

        mi_productos.setReferenciaproducto("");

        String respuesta = productos_dao.Actualizarproductos(mi_productos);

        if (respuesta.length() == 0) {

            System.out.println("Actualización exitosa");

        } else {

            System.out.println("Ocurrio un error" + respuesta);

        }
    }

}
