package pruebas;

import controlador.usuariosDAO;
import java.util.Scanner;
import modelo.usuarios;

public class pruebaactualizarusuarios {

    public static void main(String[] args) {

        usuariosDAO misusuariosDAO = new usuariosDAO();
        usuarios misusuarios = new usuarios();

        Scanner leer = new Scanner(System.in);

        int numerodocusuario = 0;
        String nombreusuarios = "";
        String apellidousuarios = "";
        String correousuarios = "";
        int telefonousuarios = 0;
        String direccionusuario = "";
        String contraseñausuario = "";
        int tipo_documento_idtipodoc = 0;
        int roles_idroles = 0;
        int genero_idgenero = 0;
        int estado_usuario_idestadousuario = 0;

        System.out.println("Digite su numero de documento");
        numerodocusuario = leer.nextInt();
        System.out.println("Digite sus nombres");
        nombreusuarios = leer.next();
        System.out.println("Digite sus apellidos");
        apellidousuarios = leer.next();
        System.out.println("Digite su correo");
        correousuarios = leer.next();
        System.out.println("Digite su telefono");
        telefonousuarios = leer.nextInt();
        System.out.println("Digite su direccion");
        direccionusuario = leer.next();
        System.out.println("Digite su contraseña");
        contraseñausuario = leer.next();
        System.out.println("Digite su tipo de documento");
        tipo_documento_idtipodoc = leer.nextInt();
        System.out.println("Digite su rol");
        roles_idroles = leer.nextInt();
        System.out.println("Digite su genero");
        genero_idgenero = leer.nextInt();
        System.out.println("Digite su estado usuario");
        estado_usuario_idestadousuario = leer.nextInt();
        System.out.println("Digite su numero de documento");
        numerodocusuario = leer.nextInt();

        misusuarios.setnumerodocusuario(numerodocusuario);
        misusuarios.setnombreusuarios(nombreusuarios);
        misusuarios.setapellidousuarios(apellidousuarios);
        misusuarios.setcorreousuarios(correousuarios);
        misusuarios.settelefonousuarios(telefonousuarios);
        misusuarios.setdireccionusuario(direccionusuario);
        misusuarios.setcontraseñausuario(contraseñausuario);
        misusuarios.settipo_documento_idtipodoc(tipo_documento_idtipodoc);
        misusuarios.setroles_idroles(roles_idroles);
        misusuarios.setgenero_idgenero(genero_idgenero);
        misusuarios.setestado_usuario_idestadousuario(estado_usuario_idestadousuario);

        misusuarios.setnumerodocusuario(2013542);
        String mirespuesta = misusuariosDAO.Actualizarusuario(misusuarios);
        
        if (mirespuesta.length() == 0) {
            System.out.println("Usuario actualizado");
        } else {
            System.out.println("Error" + mirespuesta);
        }

    }

}
