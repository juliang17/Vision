package pruebas;

import controlador.tipo_doc_contableDAO;
import modelo.tipo_doc_contable;

public class pruebaConsultartipodoc {

    public static void main(String[] args) {

        tipo_doc_contableDAO mi_tipo_doc_dao = new tipo_doc_contableDAO();
        tipo_doc_contable mi_tipo_doc_contable = mi_tipo_doc_dao.ConsultarTipo_doc_contable("");

        if (mi_tipo_doc_contable != null) {
            System.out.println("El tipo docummento contable fue encontrado " + mi_tipo_doc_contable.getIdtipodoccontable() + " " + mi_tipo_doc_contable.getDescripciontipodoccontable() + " ");
        } else {
            System.out.println("El tipo docummento contable no fue encontrada");
        }
    }

}
