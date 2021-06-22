
package pruebas;

import controlador.inventarioDAO;
import modelo.inventario;

public class PruebaConsultarInventario {

    public static void main(String[] args) {
        
        inventarioDAO INVENDAO = new inventarioDAO();
        inventario miinventario = INVENDAO.ConsultarInventario("1");
        
        if (miinventario != null) {
            System.out.println("inventario encontrado " + miinventario.getIdinventario() + " " + miinventario.getEntrada() + "" );
        } else {
            System.out.println("Error en la consulta");
        }

    }
    
}
