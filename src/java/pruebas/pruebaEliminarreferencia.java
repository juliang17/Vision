/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.referenciaDAO;
import java.util.ArrayList;
import modelo.referencia_de_pago;

/**
 *
 * @author Jeffe
 */
public class pruebaEliminarreferencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        referenciaDAO referencia_de_pago_dao = new referenciaDAO();
        
        ArrayList<referencia_de_pago> listado_referencia_de_pago = referencia_de_pago_dao.ConsultarListadoReferencia_de_pago("", "");
        for (referencia_de_pago R : listado_referencia_de_pago) {
            System.out.println(" id : " + R.getIdreferenciadepago() );
        }
        System.out.println("eliminado");
        referencia_de_pago_dao.EliminarReferencia_de_pago(listado_referencia_de_pago.get(0));
        listado_referencia_de_pago = referencia_de_pago_dao.ConsultarListadoReferencia_de_pago("", "");
        for (referencia_de_pago R : listado_referencia_de_pago) {
            System.out.println(" id : " + R.getIdreferenciadepago());
        }
    }
    
}
