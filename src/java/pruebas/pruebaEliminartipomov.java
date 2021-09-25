package pruebas;


import controlador.tipo_movDAO;
import java.util.ArrayList;
import modelo.tipo_mov;


public class pruebaEliminartipomov {

    public static void main(String[] args) {

        tipo_movDAO tipoMovDAO = new tipo_movDAO();

        ArrayList<tipo_mov> listadoTipoMov = tipoMovDAO.ListadoTipoMov("", "");
        for (tipo_mov T : listadoTipoMov) {
            System.out.println(" id : " + T.getId_tipo_mov() + " descripción : " + T.getDescripcionTipoMov());
        }
        System.out.println("eliminado");
        tipoMovDAO.EliminarTipoMov(listadoTipoMov.get(0));
        listadoTipoMov = tipoMovDAO.ListadoTipoMov("", "");
        for (tipo_mov T : listadoTipoMov) {
            System.out.println(" id : " + T.getId_tipo_mov() + " descripción : " + T.getDescripcionTipoMov());
        }
    }

}
