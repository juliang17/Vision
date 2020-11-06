/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.referenciaDAO;
import java.util.Scanner;
import modelo.referencia_de_pago;

/**
 *
 * @author Jeffe
 */
public class PruebaAdicionarreferencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        referenciaDAO mi_referenciae_pago_dao = new referenciaDAO();
        referencia_de_pago mi_referencia_pago = new referencia_de_pago();

        Scanner repuesta = new Scanner(System.in);

        String descripcion = "";
        String fechadepago = "";
        int medio_de_pago_idMedioDePago_;

        System.out.println("Por favor ingrese la descripción de la referencia");
        descripcion = repuesta.nextLine();
        
        System.out.println("Por favor ingrese la fecha de la referencia");
        fechadepago = repuesta.nextLine();
        
        System.out.println("Por favor ingrese el id del medio de pago");
        medio_de_pago_idMedioDePago_ = repuesta.nextInt();

        mi_referencia_pago.setDescripcion(descripcion);
        mi_referencia_pago.setFechadepago(medio_de_pago_idMedioDePago_);
        mi_referencia_pago.setMedio_de_pago_idMedioDePago_(medio_de_pago_idMedioDePago_);

        String miRespuesta = mi_referenciae_pago_dao.ModificarReferencia(mi_referencia_pago);

        if (miRespuesta.length() == 0) {

            System.out.println("Cambio exitoso");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }
    }
    
}
