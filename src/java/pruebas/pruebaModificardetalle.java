package pruebas;

import controlador.detalleDAO;
import java.util.Scanner;
import modelo.detalle_movimiento;

public class pruebaModificardetalle {

    public static void main(String[] args) {

        detalleDAO mi_detalle_dao = new detalleDAO();
        detalle_movimiento mi_detalle = new detalle_movimiento();

        Scanner teclado = new Scanner(System.in);

        int iddetallemovimiento;
        int cantidad;
        int iva;
        int subtotal;
        int precio;
        int movimiento_idmovimiento;
        int productos_idproductos;

        System.out.println("Digite el id del detalle");
        iddetallemovimiento = teclado.nextInt();

        System.out.println("Digite la cantidad");
        cantidad = teclado.nextInt();

        System.out.println("Digite el precio");
        precio = teclado.nextInt();

        System.out.println("Digite el iva");
        iva = teclado.nextInt();

        System.out.println("Digite el subtotal");
        subtotal = teclado.nextInt();

        System.out.println("Digite el producto");
        productos_idproductos = teclado.nextInt();

        System.out.println("Digite el movimiento");
        movimiento_idmovimiento = teclado.nextInt();

        System.out.println("Digite el id del detalle");
        iddetallemovimiento = teclado.nextInt();

        mi_detalle.setIddetallemovimiento(iddetallemovimiento);
        mi_detalle.setCantidad(cantidad);
        mi_detalle.setPrecio(precio);
        mi_detalle.setIva(iva);
        mi_detalle.setSubtotal(subtotal);
        mi_detalle.setProductos_idproductos(productos_idproductos);
        mi_detalle.setMovimiento_idmovimiento(movimiento_idmovimiento);

        mi_detalle.setIddetallemovimiento(1);
  
        String miRespuesta = mi_detalle_dao.ActualizarDetalle(mi_detalle);

        if (miRespuesta.length() == 0) {

            System.out.println("Acción completada con éxito");
        } else {
            System.out.println("Ocurrio un error " + miRespuesta);
        }

    }
}
