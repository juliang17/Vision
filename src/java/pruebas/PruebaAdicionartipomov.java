package pruebas;

import controlador.tipo_movDAO;
import java.util.Scanner;
import modelo.tipo_mov;


public class PruebaAdicionartipomov {

    public static void main(String[] args) {

        tipo_movDAO miTipoMovDAO = new tipo_movDAO();
        tipo_mov miTipoMov = new tipo_mov();

        Scanner teclado = new Scanner(System.in);

        String descripcionTipoMov = "";

        System.out.println("Digite la descripción del tipo movimiento");
        descripcionTipoMov = teclado.nextLine();


        miTipoMov.setDescripcionTipoMov(descripcionTipoMov);
 

        String miRespuesta = miTipoMovDAO.Adicionartipo_mov(miTipoMov);

        if (miRespuesta.length() == 0) {

            System.out.println("Acción completada con éxito");
        } else {
            System.out.println("Ocurrio un error " + miRespuesta);

        }

    }
}
