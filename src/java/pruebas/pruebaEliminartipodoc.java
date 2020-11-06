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
public class pruebaEliminartipodoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        tipodocDAO tipo_doc_contable_dao = new tipodocDAO();
        
        ArrayList<tipo_doc_contable> listado_tipo_doc_contable = tipo_doc_contable_dao.ListadoTipoDocContable(1, "");
        for (tipo_doc_contable T : listado_tipo_doc_contable) {
            System.out.println(" id : " + T.getIdtipodoccontable() + " descripción : " + T.getDescripciontipodoccontable());
        }
        System.out.println("eliminado");
        tipo_doc_contable_dao.EliminarTipoDocContable(listado_tipo_doc_contable.get(0));
        listado_tipo_doc_contable = tipo_doc_contable_dao.ListadoTipoDocContable(1, "");
        for (tipo_doc_contable T : listado_tipo_doc_contable) {
            System.out.println(" id : " + T.getIdtipodoccontable() + " descripción : " + T.getDescripciontipodoccontable());
        }
    }
    
}
