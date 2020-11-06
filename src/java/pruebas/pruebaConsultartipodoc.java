/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.tipodocDAO;
import modelo.tipo_doc_contable;

/**
 *
 * @author Jeffe
 */
public class pruebaConsultartipodoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         tipodocDAO mi_tipo_doc_dao = new tipodocDAO();
        tipo_doc_contable mi_tipo_doc_contable = mi_tipo_doc_dao.ConsultarTipo_doc_contable(0);
        
        if (mi_tipo_doc_contable != null) {
            System.out.println("El tipo docummento contable fue encontrado " + mi_tipo_doc_contable.getIdtipodoccontable() + " " + mi_tipo_doc_contable.getDescripciontipodoccontable() + " ");
        } else {
            System.out.println("El tipo docummento contable no fue encontrada");
        }
    }
    
}
