package pruebas;

import controlador.TipoMovimientoDAO;
import java.util.Scanner;
import modelo.tipo_movimiento;

public class PruebaAdicionarTipoMovimiento {

    public static void main(String[] args) {
        
        TipoMovimientoDAO TIPOMOVDAO = new TipoMovimientoDAO();
        tipo_movimiento mitipomov = new tipo_movimiento();

        Scanner teclado = new Scanner(System.in);

        String descripciontipomov = "";

        System.out.println("Ingrese el tipo movimiento");
        descripciontipomov = teclado.next();

        mitipomov.setDescripciontipomov(descripciontipomov);
        String miRespuesta = TIPOMOVDAO.adicionarTipoMovimiento(mitipomov);

        if (miRespuesta.length() == 0) {

            System.out.println("Registro exitosa");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }

    }

}
