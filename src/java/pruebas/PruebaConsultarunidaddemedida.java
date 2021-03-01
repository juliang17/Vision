package pruebas;

import controlador.UnidadDeMedidaDAO;
import modelo.unidad_de_medida;

public class PruebaConsultarunidaddemedida {

    public static void main(String[] args) {

        UnidadDeMedidaDAO miunidadmedidaDAO = new UnidadDeMedidaDAO();
        unidad_de_medida miunidad = miunidadmedidaDAO.Consultarunidaddemedida("");

        if (miunidad != null) {
            System.out.println("unida de medida encontrado" + miunidad.getIdunidadmedida() + "_" + miunidad.getDescripcionunidadmedida() + "_");
        } else {
            System.out.println("Genero no encontrado:");
        }
    }

}
