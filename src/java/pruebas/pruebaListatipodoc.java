/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.tipodocDAO;
import java.util.ArrayList;
import modelo.tipo_doc_contable;

/**
 *
 * @author Jeffe
 */
public class pruebaListatipodoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        tipodocDAO tipo_doc_contable_dao = new tipodocDAO();
        ArrayList<tipo_doc_contable> mi_tipo_doc_contable = new ArrayList<tipo_doc_contable>();
        mi_tipo_doc_contable = tipo_doc_contable_dao.ListadoTipoDocContable(1, "");

        int size = mi_tipo_doc_contable.size();
        System.out.println("<table border=\"1\"><tr><td>idtipodoccontable</td><td>descripciontipodoccontable</td><td>tipo_movimiento_idTipoMov ");

        for (tipo_doc_contable D : mi_tipo_doc_contable) {

            System.out.println("<tr>");
            System.out.println("<td>" + D.getIdtipodoccontable() + "</td>");
            System.out.println("<td>" + D.getDescripciontipodoccontable() + "</td>");
            System.out.println("<td>" + D.getTipo_movimiento_idTipoMov() + "</td>");

            System.out.println("</tr>");

        }
    }
    
}
