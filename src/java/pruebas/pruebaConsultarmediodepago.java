/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.mediodepagoDAO;
import modelo.medio_de_pago;

/**
 *
 * @author Jeffe
 */
public class pruebaConsultarmediodepago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

         mediodepagoDAO mi_medio_de_pago_dao = new mediodepagoDAO();
       medio_de_pago mi_medio_de_pago = mi_medio_de_pago_dao.ConsultarMedio_de_pago("");
        
        if (mi_medio_de_pago != null) {
            System.out.println("medio de pago fue encontrado " + mi_medio_de_pago.getIdMedioDePago() + " " + mi_medio_de_pago.getDescripcionmediodepago() + " ");
        } else {
            System.out.println("El medio de pago no fue encontrado");
        }
    }
    
}
