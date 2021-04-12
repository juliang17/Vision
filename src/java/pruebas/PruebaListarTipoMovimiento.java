package pruebas;

import controlador.TipoMovimientoDAO;
import java.util.ArrayList;
import modelo.tipo_movimiento;

public class PruebaListarTipoMovimiento {

    public static void main(String[] args) {
        
        TipoMovimientoDAO TIPOMOVDAO = new TipoMovimientoDAO();
        ArrayList<tipo_movimiento> milistatipomov = new ArrayList<tipo_movimiento>();
        milistatipomov = TIPOMOVDAO.Consultarlistadotipomovimiento("");

        int size = milistatipomov.size();
        System.out.println("<table border=\"1\"><tr><td>idtipomov</td><td>descripciontipomov</td>");

        for (tipo_movimiento T : milistatipomov) {

            System.out.println("<tr>");
            System.out.println("tb>" + T.getIdtipomov() + "</tb>");
            System.out.println("tb>" + T.getDescripciontipomov() + "</tb>");

            System.out.println("</tr>");
            System.out.println("</table>");
        }
    }

}
