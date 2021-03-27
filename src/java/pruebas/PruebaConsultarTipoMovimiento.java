package pruebas;

import controlador.TipoMovimientoDAO;
import modelo.tipo_movimiento;

public class PruebaConsultarTipoMovimiento {

    public static void main(String[] args) {
        
        TipoMovimientoDAO TIPOMOVDAO = new TipoMovimientoDAO();
        tipo_movimiento mitipomov = TIPOMOVDAO.Consultartipomovimiento(0);

        if (mitipomov != null) {
            System.out.println("tipo movimiento encontrado" + mitipomov.getIdtipomov() + "_" + mitipomov.getDescripciontipomov() + "_");
        } else {
            System.out.println("Genero no encontrado:");
        }

    }

}
