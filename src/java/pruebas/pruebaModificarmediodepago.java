/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.mediodepagoDAO;
import java.util.Scanner;
import modelo.medio_de_pago;

/**
 *
 * @author Jeffe
 */
public class pruebaModificarmediodepago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        mediodepagoDAO mi_forma_De_pago_dao = new mediodepagoDAO();
        medio_de_pago mi_forma_De_pago = new medio_de_pago();

        Scanner repuesta = new Scanner(System.in);

        String idMedioDePago;
        String mediodepago = "";

        
        System.out.println("Por favor ingrese la forma de pago");
        mediodepago = repuesta.nextLine();
        
        System.out.println("Por favor ingrese el id");
        idMedioDePago = repuesta.next();

        mi_forma_De_pago.setIdMedioDePago(idMedioDePago);
        mi_forma_De_pago.setDescripcionmediodepago(mediodepago);
        
        mi_forma_De_pago.setIdMedioDePago(idMedioDePago);

        String miRespuesta = mi_forma_De_pago_dao.ModificarMedioPago(mi_forma_De_pago);

        if (miRespuesta.length() == 0) {

            System.out.println("Registro exitoso");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }
    }
    
}
