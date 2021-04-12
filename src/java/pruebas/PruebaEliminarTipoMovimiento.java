package pruebas;

import controlador.TipoMovimientoDAO;
import java.util.ArrayList;
import modelo.tipo_movimiento;

public class PruebaEliminarTipoMovimiento {

    public static void main(String[] args) {
        
        TipoMovimientoDAO TIPOMOVDAO = new TipoMovimientoDAO();
        ArrayList<tipo_movimiento> milistatipomov = TIPOMOVDAO.Consultarlistadotipomovimiento("");
        for (tipo_movimiento T : milistatipomov) {
            System.out.println(" id : " + T.getIdtipomov() + " Descripcion : " + T.getDescripciontipomov());
        }
        System.out.println("Registro eliminado");
       TIPOMOVDAO.Eliminartipomovimiento(null);
        milistatipomov = TIPOMOVDAO.Consultarlistadotipomovimiento("");
        for (tipo_movimiento T : milistatipomov) {
            System.out.println(" id : " + T.getIdtipomov() + " Descripcion : " + T.getDescripciontipomov());
        }

    }

}
