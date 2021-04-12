
package pruebas;

import controlador.detalleDAO;
import java.util.ArrayList;
import modelo.detalle_movimiento;

public class pruebaListadetalle {

    public static void main(String[] args) {
        
        detalleDAO detalle_movimiento_dao = new detalleDAO();
        ArrayList<detalle_movimiento> mi_detalle_movimiento = new ArrayList<detalle_movimiento>();
        mi_detalle_movimiento = detalle_movimiento_dao.ListadoDetalleMovimiento("1","");

        int size = mi_detalle_movimiento.size();
        System.out.println("<table border=\"1\"><tr><td>Iddetallemovimiento</td><td>cantidad</td><td>iva</td><td>subtotal</td><td>precio</td><td>movimiento_idmovimiento</td><td>productos_idproductos</td> ");

        for (detalle_movimiento D : mi_detalle_movimiento) {

            System.out.println("<tr>");
            System.out.println("<td>" + D.getIddetallemovimiento() + "</td>");
            System.out.println("<td>" + D.getCantidad() + "</td>");
            System.out.println("<td>" + D.getIva() + "</td>");
            System.out.println("<td>" + D.getSubtotal() + "</td>");
            System.out.println("<td>" + D.getPrecio() + "</td>");
            System.out.println("<td>" + D.getMovimiento_idmovimiento() + "</td>");
            System.out.println("<td>" + D.getProductos_idproductos() + "</td>");


            System.out.println("</tr>");

        }
    }
    
}
