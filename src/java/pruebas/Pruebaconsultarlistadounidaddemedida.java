package pruebas;

import controlador.UnidadDeMedidaDAO;
import java.util.ArrayList;
import modelo.unidad_de_medida;

public class Pruebaconsultarlistadounidaddemedida {

    public static void main(String[] args) {

        UnidadDeMedidaDAO miunidadmedidaDAO = new UnidadDeMedidaDAO();
        ArrayList<unidad_de_medida> miunidad = new ArrayList<unidad_de_medida>();
        miunidad = miunidadmedidaDAO.listadounidaddemedida("" , "");

        int size = miunidad.size();
        System.out.println("<table border=\"1\"><tr><td>idunidadmedida</td><td>descripcionunidadmedida></td>");

        for (unidad_de_medida U : miunidad) {

            System.out.println("<tr>");
            System.out.println("<tb>" + U.getIdunidadmedida() + "</tb>");
            System.out.println("<tb>" + U.getDescripcionunidadmedida() + "</tb>");

            System.out.println("</tr>");
            System.out.println("</table>");
        }
        
    }

}
