package pruebas;

import controlador.estado_usuarioDAO;
import java.util.Scanner;
import modelo.estado_usuario;

public class pruebaadicionarestadousuario {

    public static void main(String[] args) {

        estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
        estado_usuario miestadousuario = new estado_usuario();

        Scanner leer = new Scanner(System.in);

        String Nombreestadousuario = "";

        System.out.println("Digite el estado usuario");
        Nombreestadousuario = leer.next();

        miestadousuario.setdescripcionestadousuario(Nombreestadousuario);
        String mirespuesta = miestadousuarioDAO.adicionarestado_usuario(miestadousuario);

        if (mirespuesta.length() == 0) {
            System.out.println("Registro exitoso");
        } else {
            System.out.println("Ocurrio un error" + mirespuesta);
        }

    }

}
