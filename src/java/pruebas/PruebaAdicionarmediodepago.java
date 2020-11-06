package pruebas;

import controlador.mediodepagoDAO;
import java.util.Scanner;
import modelo.medio_de_pago;

/**
 *
 * @author Jeffe
 */
public class PruebaAdicionarmediodepago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        mediodepagoDAO mi_forma_De_pago_dao = new mediodepagoDAO();
        medio_de_pago mi_forma_De_pago = new medio_de_pago();

        Scanner repuesta = new Scanner(System.in);

        String mediodepago = "";

        System.out.println("Por favor ingrese la forma de pago");
        mediodepago = repuesta.next();

        mi_forma_De_pago.setDescripcionmediodepago(mediodepago);
        String miRespuesta = mi_forma_De_pago_dao.AdicionarMedios_de_pago(mi_forma_De_pago);

        if (miRespuesta.length() == 0) {

            System.out.println("Cambio exitoso");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }

    }

}
