package pruebas;

import controlador.tipo_movDAO;
import java.util.Scanner;
import modelo.tipo_mov;

public class pruebaModificartipomov {

    public static void main(String[] args) {

        tipo_movDAO miTipoMovDAO = new tipo_movDAO();
        tipo_mov miTipoMov = new tipo_mov();

        Scanner teclado = new Scanner(System.in);

        String id_tipo_mov;
        String descripcionTipoMov = "";

        System.out.println("Digite la descripción del tipo documento contable");
        descripcionTipoMov = teclado.nextLine();

        System.out.println("Digite el id del tipo documento contable");
        id_tipo_mov = teclado.next();

        miTipoMov.setId_tipo_mov(id_tipo_mov);
        miTipoMov.setDescripcionTipoMov(descripcionTipoMov);

        miTipoMov.setId_tipo_mov(id_tipo_mov);


        String miRespuesta = miTipoMovDAO.Modificartipo_mov(miTipoMov);

        if (miRespuesta.length() == 0) {

            System.out.println("Acción completada con éxito");
        } else {
            System.out.println("Ocurrio un error " + miRespuesta);

        }

    }

}
