
package pruebas;

import controlador.detalleDAO;
import modelo.detalle_movimiento;

public class pruebaConcultardetalle {

    public static void main(String[] args) {
        detalleDAO mi_detalle_dao = new detalleDAO();
        detalle_movimiento mi_detalle = mi_detalle_dao.ConsultarDetalle_movimiento(0);
        
        if (mi_detalle != null) {
            System.out.println("detalle movimiento fue encontrado " + mi_detalle.getIddetallemovimiento() + " ");
        } else {
            System.out.println("La detalle movimiento no fue encontrado");
        }
    }

}
