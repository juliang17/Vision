
package pruebas;

import controlador.UnidadDeMedidaDAO;
import java.util.Scanner;
import modelo.unidad_de_medida;

public class PruebaactualizarUnidadMedida {

    public static void main(String[] args) {
        
        UnidadDeMedidaDAO unidadmedidaDAO = new UnidadDeMedidaDAO();
        unidad_de_medida miunidad = new unidad_de_medida();

        Scanner leer = new Scanner(System.in);

        String descripcionunidadmedida = "";

        System.out.println("Digite la unidad de medida");
        descripcionunidadmedida = leer.next();

        miunidad.setDescripcionunidadmedida(descripcionunidadmedida);

        miunidad.setIdunidadmedida(1);

        String mirespuesta = unidadmedidaDAO.Actualizarunidaddemedida(miunidad);

        if (mirespuesta.length() == 0) {
            System.out.println("Estado usuario actualizado");
        } else {
            System.out.println("Error" + mirespuesta);
        }
    }
    
}
