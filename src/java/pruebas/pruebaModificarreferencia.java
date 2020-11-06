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
public class pruebaModificarreferencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        referenciaDAO mi_referenciae_pago_dao = new referenciaDAO();
        referencia_de_pago mi_referencia_pago = new referencia_de_pago();

        Scanner repuesta = new Scanner(System.in);

        int idreferenciadepago;
        String descripcion = "";
        String fechadepago = "";

        System.out.println("Por favor ingrese la descripción de la referencia");
        descripcion = repuesta.nextLine();
        
        System.out.println("Por favor ingrese la fecha de la referencia");
        fechadepago = repuesta.nextLine();
        
        System.out.println("Por favor ingrese el id del medio de pago");
        idreferenciadepago = repuesta.nextInt();

        mi_referencia_pago.setIdreferenciadepago(idreferenciadepago);
        mi_referencia_pago.setDescripcion(descripcion);
        mi_referencia_pago.setFechadepago(idreferenciadepago);
        
        mi_referencia_pago.setIdreferenciadepago(idreferenciadepago);

        mi_referencia_pago.setMedio_de_pago_idMedioDePago_(1);

        String miRespuesta = mi_referenciae_pago_dao.ModificarReferencia(mi_referencia_pago);

        if (miRespuesta.length() == 0) {

            System.out.println("Cambio exitoso");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }
    }
    
}
