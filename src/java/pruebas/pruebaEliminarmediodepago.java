/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.mediodepagoDAO;
import java.util.ArrayList;
import modelo.medio_de_pago;

/**
 *
 * @author Jeffe
 */
public class pruebaEliminarmediodepago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        mediodepagoDAO medio_de_pago_dao = new mediodepagoDAO();
        
        ArrayList<medio_de_pago> listado_medio_de_pago = medio_de_pago_dao.ListadoMedioDePago(1, "");
        for (medio_de_pago M : listado_medio_de_pago) {
            System.out.println(" id : " + M.getIdMedioDePago() + " descripción : " + M.getDescripcionmediodepago());
        }
        System.out.println("eliminado");
        medio_de_pago_dao.EliminarDetalleMedioDePago(listado_medio_de_pago.get(0));
        listado_medio_de_pago = medio_de_pago_dao.ListadoMedioDePago(1, "");
        for (medio_de_pago M : listado_medio_de_pago) {
            System.out.println(" id : " + M.getIdMedioDePago() + " descripción : " + M.getDescripcionmediodepago());
        }
    }
    
}
