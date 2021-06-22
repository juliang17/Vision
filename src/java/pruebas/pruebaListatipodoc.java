package pruebas;

import controlador.tipo_doc_contableDAO;
import java.util.ArrayList;
import modelo.tipo_doc_contable;

public class pruebaListatipodoc {

    public static void main(String[] args) {

        tipo_doc_contableDAO tipo_doc_contable_dao = new tipo_doc_contableDAO();
        ArrayList<tipo_doc_contable> mi_tipo_doc_contable = new ArrayList<tipo_doc_contable>();
        mi_tipo_doc_contable = tipo_doc_contable_dao.ListadoTipoDocContable(0, "");

        int size = mi_tipo_doc_contable.size();
        System.out.println("<table border=\"1\"><tr><td>idtipodoccontable</td><td>descripciontipodoccontable</td>");

        for (tipo_doc_contable D : mi_tipo_doc_contable) {

            System.out.println("<tr>");
            System.out.println("<td>" + D.getIdtipodoccontable() + "</td>");
            System.out.println("<td>" + D.getDescripciontipodoccontable() + "</td>");
            System.out.println("</tr>");

        }
    }

}
