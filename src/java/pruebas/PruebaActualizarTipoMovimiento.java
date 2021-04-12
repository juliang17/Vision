package pruebas;

import controlador.TipoMovimientoDAO;
import java.util.Scanner;
import modelo.tipo_movimiento;

public class PruebaActualizarTipoMovimiento {

    public static void main(String[] args) {
        
        TipoMovimientoDAO TIPOMOVDAO = new TipoMovimientoDAO();
        tipo_movimiento mitipomov = new tipo_movimiento();
        
        Scanner leer = new Scanner(System.in);
        
        String descripciontipomov = "";
        
        System.out.println("Digite el tipo de movimiento");
        descripciontipomov = leer.next();
                
        mitipomov.setDescripciontipomov(descripciontipomov);

        mitipomov.setIdtipomov(1);
        
        String mirespuesta = TIPOMOVDAO.actualizarTipoMovimiento(mitipomov);
        
        if(mirespuesta.length()==0){
            System.out.println("Tipo movimiento actualizado");
        } else {
        System.out.println("Error" + mirespuesta);
        }

    }

}
