/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.referenciaDAO;
import java.util.Scanner;
import modelo.referencia_de_pago;

public class pruebaModificarreferencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        referenciaDAO mi_referenciae_pago_dao = new referenciaDAO();
        referencia_de_pago mi_referencia_pago = new referencia_de_pago();

        Scanner repuesta = new Scanner(System.in);

        String idreferenciadepago = "";
        String fechadepago = "";
        int medio_de_pago_idMedioDePago;
        
        System.out.println("Por favor ingrese la fecha de la referencia");
        fechadepago = repuesta.nextLine();
        System.out.println("Por favor ingrese el medio de pago");
        medio_de_pago_idMedioDePago = repuesta.nextInt();
        
        System.out.println("Por favor ingrese el id de la referencia de pago");
        idreferenciadepago = repuesta.nextLine();

        mi_referencia_pago.setIdreferenciadepago(idreferenciadepago);
        mi_referencia_pago.setFechadepago(fechadepago);
        mi_referencia_pago.setMedio_de_pago_idMedioDePago(medio_de_pago_idMedioDePago);
        
        mi_referencia_pago.setIdreferenciadepago(idreferenciadepago);

        String miRespuesta = mi_referenciae_pago_dao.ActualizarReferencia_de_pago(mi_referencia_pago);

        if (miRespuesta.length() == 0) {

            System.out.println("Cambio exitoso");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }
    }
    
}
