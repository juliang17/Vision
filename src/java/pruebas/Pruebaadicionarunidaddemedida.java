
package pruebas;

import controlador.UnidadDeMedidaDAO;
import java.util.Scanner;
import modelo.unidad_de_medida;

public class Pruebaadicionarunidaddemedida {

    public static void main(String[] args) {
        
        UnidadDeMedidaDAO unidadmedidaDAO = new UnidadDeMedidaDAO();
        unidad_de_medida miunidad = new unidad_de_medida();

        Scanner teclado = new Scanner(System.in);

        String descripcionunidadmedida = "";

        System.out.println("Ingrese la unidad de medida");
        descripcionunidadmedida = teclado.next();

        miunidad.setDescripcionunidadmedida(descripcionunidadmedida);
        String miRespuesta = unidadmedidaDAO.adicionarunidaddemedida(miunidad);

        if (miRespuesta.length() == 0) {

            System.out.println("Consulta exitosa");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }
    }
    
}
