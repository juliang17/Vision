/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.referenciaDAO;
import java.util.ArrayList;
import modelo.referencia_de_pago;

public class pruebaListareferencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        referenciaDAO referencia_de_pago_dao = new referenciaDAO();
        ArrayList<referencia_de_pago> mi_referencia_de_pago = new ArrayList<referencia_de_pago>();
        mi_referencia_de_pago = referencia_de_pago_dao.ConsultarListadoReferencia_de_pago("");

        int size = mi_referencia_de_pago.size();
        System.out.println("<table border=\"1\"><tr><td>idreferenciadepago</td><td>fechadepago</td>><td>medio_de_pago_idMedioDePago</td> ");

        for (referencia_de_pago R : mi_referencia_de_pago) {

            System.out.println("<tr>");
            System.out.println("<td>" + R.getIdreferenciadepago() + "</td>");
            System.out.println("<td>" + R.getFechadepago() + "</td>");
            System.out.println("<td>" + R.getMedio_de_pago_idMedioDePago() + "</td>");

            System.out.println("</tr>");

        }
    }
    
}
