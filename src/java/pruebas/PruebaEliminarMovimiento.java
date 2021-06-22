
package pruebas;

import controlador.movimientoDAO;
import java.util.ArrayList;
import modelo.movimiento;

public class PruebaEliminarMovimiento {

    public static void main(String[] args) {
        
        movimientoDAO MovDAO = new movimientoDAO();
        
        ArrayList<movimiento> milistamovimiento = MovDAO.ListadoMovimiento("", "");
        for (movimiento M : milistamovimiento) {
            System.out.println(" id : " + M.getIdmovimiento() );
        }
        System.out.println("eliminado");
        MovDAO.EliminarMovimiento(milistamovimiento.get(0));
        milistamovimiento = MovDAO.ListadoMovimiento("", "");
        for (movimiento M : milistamovimiento) {
            System.out.println(" id : " + M.getIdmovimiento());
        }
    }
    
}
