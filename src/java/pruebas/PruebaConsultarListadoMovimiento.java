package pruebas;

import controlador.movimientoDAO;
import java.util.ArrayList;
import modelo.movimiento;

public class PruebaConsultarListadoMovimiento {

    public static void main(String[] args) {

        movimientoDAO MovDAO = new movimientoDAO();
        ArrayList<movimiento> milistamovimiento = new ArrayList<movimiento>();
        milistamovimiento = MovDAO.Consultarlistadomovimiento("");

        int size = milistamovimiento.size();
        System.out.println("<table border=\"1\"><tr><td>id</td><td>fechamovimiento</td>><td>subtotal</td><td>iva</td><td>descuento</td><td>total</td><td>tipo_doc_contable_idtipodoccontable</td><td>medio_de_pago_idmediodepago</td> ");

        for (movimiento M : milistamovimiento) {

            System.out.println("<tr>");
            System.out.println("<td>" + M.getIdmovimiento() + "</td>");
            System.out.println("<td>" + M.getFechamovimiento() + "</td>");
            System.out.println("<td>" + M.getSubtotal() + "</td>");
            System.out.println("<td>" + M.getIva() + "</td>");
            System.out.println("<td>" + M.getDescuento() + "</td>");
            System.out.println("<td>" + M.getTotal() + "</td>");
            System.out.println("<td>" + M.getTipo_doc_contable_idtipodoccontable() + "</td>");
            System.out.println("<td>" + M.getMedio_de_pago_idmediodepago() + "</td>");

            System.out.println("</tr>");

        }
    }

}
