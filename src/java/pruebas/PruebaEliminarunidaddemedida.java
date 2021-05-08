package pruebas;

import controlador.UnidadDeMedidaDAO;
import java.util.ArrayList;
import modelo.unidad_de_medida;

public class PruebaEliminarunidaddemedida {

    public static void main(String[] args) {

        UnidadDeMedidaDAO miunidaddemedidaDAO = new UnidadDeMedidaDAO();
        ArrayList<unidad_de_medida> milistaunidad = miunidaddemedidaDAO.listadounidaddemedida("" , "");
        for (unidad_de_medida U : milistaunidad) {
            System.out.println(" id : " + U.getIdunidadmedida() + " Descripcion : " + U.getDescripcionunidadmedida());
        }
        System.out.println("Registro eliminado");
        miunidaddemedidaDAO.Eliminarunidaddemedida(null);
        milistaunidad = miunidaddemedidaDAO.listadounidaddemedida("" , "");
        for (unidad_de_medida U : milistaunidad) {
            System.out.println(" id : " + U.getIdunidadmedida() + " Descripcion : " + U.getDescripcionunidadmedida());
        }
        
    }

}
