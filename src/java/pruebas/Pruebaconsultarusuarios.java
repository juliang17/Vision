package pruebas;

import controlador.usuariosDAO;
import modelo.usuarios;

public class Pruebaconsultarusuarios {

    public static void main(String[] args) {

        usuariosDAO misusuariosDAO = new usuariosDAO();
        usuarios misusuarios = misusuariosDAO.Consultarusuarios("1000127213");

        if (misusuarios != null) {
            System.out.println("Usuario encontrado:" + misusuarios.getnumerodocusuario() + "_" + misusuarios.getnombreusuarios() + "_");

        } else {
            System.out.println("Usuario no encontrado");
        }

    }

}
