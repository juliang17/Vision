package pruebas;

import controlador.tipo_doc_contableDAO;
import java.util.ArrayList;
import modelo.tipo_doc_contable;

public class pruebaEliminartipodoc {

    public static void main(String[] args) {

        tipo_doc_contableDAO tipo_doc_contable_dao = new tipo_doc_contableDAO();

        ArrayList<tipo_doc_contable> listado_tipo_doc_contable = tipo_doc_contable_dao.ListadoTipoDocContable("");
        for (tipo_doc_contable T : listado_tipo_doc_contable) {
            System.out.println(" id : " + T.getIdtipodoccontable() + " descripción : " + T.getDescripciontipodoccontable());
        }
        System.out.println("eliminado");
        tipo_doc_contable_dao.EliminarTipoDocContable(listado_tipo_doc_contable.get(0));
        listado_tipo_doc_contable = tipo_doc_contable_dao.ListadoTipoDocContable("");
        for (tipo_doc_contable T : listado_tipo_doc_contable) {
            System.out.println(" id : " + T.getIdtipodoccontable() + " descripción : " + T.getDescripciontipodoccontable());
        }
    }

}
