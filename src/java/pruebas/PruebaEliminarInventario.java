package pruebas;

import controlador.inventarioDAO;
import java.util.ArrayList;
import modelo.inventario;

public class PruebaEliminarInventario {

    public static void main(String[] args) {
        
         inventarioDAO INVENDAO = new inventarioDAO();
         ArrayList<inventario> milistainventario = INVENDAO.Consultarlistadoinventario("","","");
        for (inventario I : milistainventario) {
            System.out.println(" id : " + I.getIdinventario() + " Entrada : " + I.getEntrada()
                    + " Salidas : " + I.getSalida() + " Saldo : " + I.getSaldo()
                    + " Producto : " + I.getProductos_idproductos());
        }
        System.out.println("inventario eliminado");
        INVENDAO.Eliminarinventario(milistainventario.get(0));
        milistainventario = INVENDAO.Consultarlistadoinventario("","","");
        for (inventario I : milistainventario) {
            System.out.println(" id : " + I.getIdinventario() + " Entrada : " + I.getEntrada()
                    + " Salida : " + I.getSalida() + " Saldo : " + I.getSaldo()
                    + " Productos : " + I.getProductos_idproductos());
        }

    }

}
