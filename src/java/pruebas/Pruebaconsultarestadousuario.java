package pruebas;

import controlador.estado_usuarioDAO;
import modelo.estado_usuario;

public class Pruebaconsultarestadousuario {

    public static void main(String[] args) {

        estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
        estado_usuario miestadousuario = miestadousuarioDAO.Consultarestado_usuario("");

        if (miestadousuario != null) {
            System.out.println("Estado usuario encontrado:" + miestadousuario.getidestadousuario() + "_" + miestadousuario.getdescripcionestadousuario() + "_");
        } else {
            System.out.println("Estado usuario no encontrado");
        }
    }

}
