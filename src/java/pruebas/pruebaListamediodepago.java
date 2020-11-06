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
public class pruebaListamediodepago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        mediodepagoDAO medio_de_pago_dao = new mediodepagoDAO();
        ArrayList<medio_de_pago> mi_medio_de_pago = new ArrayList<medio_de_pago>();
        mi_medio_de_pago = medio_de_pago_dao.ListadoMedioDePago(1, "");

        int size = mi_medio_de_pago.size();
        System.out.println("<table border=\"1\"><tr><td>idMedioDePago</td><td>descripcionmediodepago</td>");

        for (medio_de_pago M : mi_medio_de_pago) {

            System.out.println("<tr>");
            System.out.println("<td>" + M.getIdMedioDePago() + "</td>");
            System.out.println("<td>" + M.getDescripcionmediodepago() + "</td>");


            System.out.println("</tr>");

        }
    }
    
}
