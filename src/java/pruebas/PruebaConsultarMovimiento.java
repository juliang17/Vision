
package pruebas;

import controlador.movimientoDAO;
import modelo.movimiento;

public class PruebaConsultarMovimiento {

    public static void main(String[] args) {
        
         movimientoDAO MovDAO = new movimientoDAO();
        movimiento Mov = MovDAO.Consultarmovimiento("");
        
        if (Mov != null) {
            System.out.println("El movimiento fue encontrado " + Mov.getIdmovimiento() + "_" + Mov.getFechamovimiento() + "_"  );
        } else {
            System.out.println("El movimiento no fue encontrada");
        }
    }
    
}
