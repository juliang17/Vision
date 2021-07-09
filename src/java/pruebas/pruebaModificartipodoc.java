package pruebas;

import controlador.tipo_doc_contableDAO;
import java.util.Scanner;
import modelo.tipo_doc_contable;

public class pruebaModificartipodoc {

    public static void main(String[] args) {

        tipo_doc_contableDAO mi_tipo_doc_dao = new tipo_doc_contableDAO();
        tipo_doc_contable mi_tipo_doc = new tipo_doc_contable();

        Scanner teclado = new Scanner(System.in);

        String idtipodoccontable;
        String descripciontipodoccontable = "";

        System.out.println("Digite la descripción del tipo documento contable");
        descripciontipodoccontable = teclado.nextLine();

        System.out.println("Digite el id del tipo documento contable");
        idtipodoccontable = teclado.next();

        mi_tipo_doc.setIdtipodoccontable(idtipodoccontable);
        mi_tipo_doc.setDescripciontipodoccontable(descripciontipodoccontable);

        mi_tipo_doc.setIdtipodoccontable(idtipodoccontable);


        String miRespuesta = mi_tipo_doc_dao.ModificarTipoDocContable(mi_tipo_doc);

        if (miRespuesta.length() == 0) {

            System.out.println("Acción completada con éxito");
        } else {
            System.out.println("Ocurrio un error " + miRespuesta);

        }

    }

}
