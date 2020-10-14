package pruebas;

import controlador.estado_usuarioDAO;
import java.util.Scanner;
import modelo.estado_usuario;

public class Pruebaactualizarestadousuario {

    public static void main(String[] args) {

        estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
        estado_usuario miestadousuario = new estado_usuario();

        Scanner leer = new Scanner(System.in);

        String descripcionestadousuario = "";

        System.out.println("Digite la descripcion estado usuario");
        descripcionestadousuario = leer.next();

        miestadousuario.setdescripcionestadousuario(descripcionestadousuario);

        miestadousuario.setidestadousuario(1);

        String mirespuesta = miestadousuarioDAO.actualizarestado_usuario(miestadousuario);

        if (mirespuesta.length() == 0) {
            System.out.println("Estado usuario actualizado");
        } else {
            System.out.println("Error" + mirespuesta);
        }
    }

}
