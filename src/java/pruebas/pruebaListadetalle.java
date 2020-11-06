/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.detalleDAO;
import java.util.ArrayList;
import modelo.detalle_movimiento;

/**
 *
 * @author Jeffe
 */
public class pruebaListadetalle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        detalleDAO detalle_movimiento_dao = new detalleDAO();
        ArrayList<detalle_movimiento> mi_detalle_movimiento = new ArrayList<detalle_movimiento>();
        mi_detalle_movimiento = detalle_movimiento_dao.ListadoDetalleMovimiento(1, "");

        int size = mi_detalle_movimiento.size();
        System.out.println("<table border=\"1\"><tr><td>Iddetallemovimiento</td><td>descripcion</td><td>cantidad</td><td>iva</td><td>subtotal</td><td>precio</td><td>mocimiento_id_movimiento</td><td>productos_idproductos</td> ");

        for (detalle_movimiento D : mi_detalle_movimiento) {

            System.out.println("<tr>");
            System.out.println("<td>" + D.getIddetallemovimiento() + "</td>");
            System.out.println("<td>" + D.getDescripcion() + "</td>");
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
