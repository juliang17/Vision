/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.referenciaDAO;
import modelo.referencia_de_pago;

public class pruebaConsultarreferencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        referenciaDAO mi_referenciae_pago_dao = new referenciaDAO();
       referencia_de_pago mi_referenciae_pago = mi_referenciae_pago_dao.ConsultarReferencia("");
        
        if (mi_referenciae_pago != null) {
            System.out.println("referencia de pago fue encontrado " + mi_referenciae_pago.getIdreferenciadepago()+ "_" + mi_referenciae_pago.getFechadepago() + "_"  );
        } else {
            System.out.println("La referencia de pago no fue encontrada");
        }
    }
    
}
