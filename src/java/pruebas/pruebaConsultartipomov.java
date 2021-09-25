package pruebas;

import controlador.tipo_movDAO;
import modelo.tipo_mov;


public class pruebaConsultartipomov {

    public static void main(String[] args) {

        tipo_movDAO miTipoMovDAO = new tipo_movDAO();
        tipo_mov miTipoMov = miTipoMovDAO.Consultartipo_mov("");

        if (miTipoMov != null) {
            System.out.println("El tipo movimiento fue encontrado " + miTipoMov.getId_tipo_mov() + " " + miTipoMov.getDescripcionTipoMov() + " ");
        } else {
            System.out.println("El tipo movimiento no fue encontrada");
        }
    }

}
