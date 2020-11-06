/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.detalleDAO;
import modelo.detalle_movimiento;

/**
 *
 * @author Jeffe
 */
public class pruebaConcultardetalle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        detalleDAO mi_detalle_dao = new detalleDAO();
        detalle_movimiento mi_detalle = mi_detalle_dao.ConsultarDetalle_movimiento(0);
        
        if (mi_detalle != null) {
            System.out.println("detalle movimiento fue encontrado " + mi_detalle.getIddetallemovimiento() + " " + mi_detalle.getDescripcion() + " ");
        } else {
            System.out.println("La detalle movimiento no fue encontrado");
        }
    }

}
