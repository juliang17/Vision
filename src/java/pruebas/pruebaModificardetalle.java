/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.detalleDAO;
import java.util.Scanner;
import modelo.detalle_movimiento;

/**
 *
 * @author Jeffe
 */
public class pruebaModificardetalle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        detalleDAO mi_detalle_dao = new detalleDAO();
        detalle_movimiento mi_detalle = new detalle_movimiento();

        Scanner teclado = new Scanner(System.in);

        int iddetallemovimiento;
        String descripcion = "";
        int cantidad;
        int iva;
        int subtotal;
        int precio;

        System.out.println("Digite la descripción del detalle");
        descripcion = teclado.nextLine();

        System.out.println("Digite la cantidad del detalle");
        cantidad = teclado.nextInt();

        System.out.println("Digite el iva del detalle");
        iva = teclado.nextInt();

        System.out.println("Digite el subtotal del detalle");
        subtotal = teclado.nextInt();

        System.out.println("Digite el precio del detalle");
        precio = teclado.nextInt();

        System.out.println("Digite el producto del detalle");
        iddetallemovimiento = teclado.nextInt();

        mi_detalle.setIddetallemovimiento(iddetallemovimiento);
        mi_detalle.setDescripcion(descripcion);
        mi_detalle.setCantidad(cantidad);
        mi_detalle.setIva(iva);
        mi_detalle.setSubtotal(subtotal);
        mi_detalle.setPrecio(precio);

        mi_detalle.setIddetallemovimiento(iddetallemovimiento);
        mi_detalle.setMovimiento_idmovimiento(1);
        mi_detalle.setProductos_idproductos(1);
        String miRespuesta = mi_detalle_dao.ModificarDetalle(mi_detalle);

        if (miRespuesta.length() == 0) {

            System.out.println("Acción completada con éxito");
        } else {
            System.out.println("Ocurrio un error " + miRespuesta);
        }

    }
}
