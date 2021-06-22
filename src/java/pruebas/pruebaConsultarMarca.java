package Pruebas;


import controlador.MarcaDAO;
import modelo.marca;

public class pruebaConsultarMarca {

    public static void main(String[] args) {

        MarcaDAO marca_dao = new MarcaDAO();
        marca mi_marca = marca_dao.ConsultarMarca("");

        if (mi_marca != null) {
            System.out.println("marca encontrada " + mi_marca.getIdmarca() + " " + mi_marca.getDescripcionmarca() + " ");
        } else {
            System.out.println("Error en la consulta");
        }
    }

}
