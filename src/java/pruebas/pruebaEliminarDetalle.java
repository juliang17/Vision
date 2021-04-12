package pruebas;

import controlador.detalleDAO;
import java.util.ArrayList;
import modelo.detalle_movimiento;

public class pruebaEliminarDetalle {

    public static void main(String[] args) {

        detalleDAO detalle_movimiento_dao = new detalleDAO();
        ArrayList<detalle_movimiento> mi_detalle_movimiento = detalle_movimiento_dao.ListadoDetalleMovimiento("", "");
        for (detalle_movimiento D : mi_detalle_movimiento) {
            System.out.println(" id : " + D.getIddetallemovimiento() + " Cantidad : " + D.getCantidad()
                    + " Precio : " + D.getPrecio() + " Iva : " + D.getIva()
                    + " Subtotal : " + D.getSubtotal() + " Producto : " + D.getProductos_idproductos()
                    + " Movimiento : " + D.getMovimiento_idmovimiento());
        }
        System.out.println("detalle movimiento eliminado");
        detalle_movimiento_dao.EliminarDetalleMovimiento(mi_detalle_movimiento.get(0));
        mi_detalle_movimiento = detalle_movimiento_dao.ListadoDetalleMovimiento("", "");
        for (detalle_movimiento D : mi_detalle_movimiento) {
            System.out.println(" id : " + D.getIddetallemovimiento() + " Cantidad : " + D.getCantidad()
                    + " Precio : " + D.getPrecio() + " Iva : " + D.getIva()
                    + " Subtotal : " + D.getSubtotal() + " Producto : " + D.getProductos_idproductos()
                    + " Movimiento : " + D.getMovimiento_idmovimiento());
        }

    }

}
