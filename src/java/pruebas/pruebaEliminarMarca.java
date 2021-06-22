package Pruebas;


import controlador.MarcaDAO;
import java.util.ArrayList;
import modelo.marca;

public class pruebaEliminarMarca {

    public static void main(String[] args) {

        MarcaDAO marca_dao = new MarcaDAO();

        ArrayList<marca> listado_marca = marca_dao.ConsultarListadoMarca("", "");
        for (marca M : listado_marca) {
            System.out.println(" ID. " + M.getIdmarca() + " DESCRIP : " + M.getDescripcionmarca());
        }
        System.out.println("Se elimino");
        marca_dao.EliminarMarca(listado_marca.get(0));
        listado_marca = marca_dao.ConsultarListadoMarca("", "");
        for (marca M : listado_marca) {
            System.out.println(" ID. " + M.getIdmarca() + " DESCRIP : " + M.getDescripcionmarca());
        }
    }

}
