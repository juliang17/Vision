package pruebas;

import controlador.tipo_doc_contableDAO;
import java.util.ArrayList;
import modelo.tipo_doc_contable;

public class pruebaEliminarDetalle {

    public static void main(String[] args) {

        tipo_doc_contableDAO tipo_doc_contable_dao = new tipo_doc_contableDAO();

        ArrayList<tipo_doc_contable> listado_tipo_doc_contable = tipo_doc_contable_dao.ListadoTipoDocContable(1, "");
        for (tipo_doc_contable C : listado_tipo_doc_contable) {
            System.out.println(" id : " + C.getIdtipodoccontable() + " descripción : " + C.getDescripciontipodoccontable());
        }
        System.out.println("eliminado");
        tipo_doc_contable_dao.EliminarTipoDocContable(listado_tipo_doc_contable.get(0));
        listado_tipo_doc_contable = tipo_doc_contable_dao.ListadoTipoDocContable(1, "");
        for (tipo_doc_contable C : listado_tipo_doc_contable) {
            System.out.println(" id : " + C.getIdtipodoccontable() + " descripción : " + C.getDescripciontipodoccontable());
        }
    }

}
