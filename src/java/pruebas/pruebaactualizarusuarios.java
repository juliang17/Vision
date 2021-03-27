package pruebas;

import controlador.usuariosDAO;
import java.util.Scanner;
import modelo.usuarios;

public class pruebaactualizarusuarios {

    public static void main(String[] args) {

        usuariosDAO misusuariosDAO = new usuariosDAO();
        usuarios misusuarios = new usuarios();

        Scanner leer = new Scanner(System.in);

        String numerodocusuario = "";
        String nombreusuarios = "";
        String apellidousuarios = "";
        String correousuarios = "";
        String telefonousuarios = "";
        String direccionusuario = "";
        String contraseñausuario = "";
        int tipo_documento_idtipodoc = 0;
        int roles_idroles = 0;
        int genero_idgenero = 0;
        int estado_usuario_idestadousuario = 0;

        System.out.println("Digite su numero de documento");
        numerodocusuario = leer.nextLine();
        System.out.println("Digite sus nombres");
        nombreusuarios = leer.nextLine();
        System.out.println("Digite sus apellidos");
        apellidousuarios = leer.nextLine();
        System.out.println("Digite su correo");
        correousuarios = leer.nextLine();
        System.out.println("Digite su telefono");
        telefonousuarios = leer.nextLine();
        System.out.println("Digite su direccion");
        direccionusuario = leer.nextLine();
        System.out.println("Digite su contraseña");
        contraseñausuario = leer.nextLine();
        System.out.println("Digite su tipo de documento");
        tipo_documento_idtipodoc = leer.nextInt();
        System.out.println("Digite su rol");
        roles_idroles = leer.nextInt();
        System.out.println("Digite su genero");
        genero_idgenero = leer.nextInt();
        System.out.println("Digite su estado usuario");
        estado_usuario_idestadousuario = leer.nextInt();
        System.out.println("Digite su numero de documento");
        numerodocusuario = leer.nextLine();

        misusuarios.setNumerodocusuario(numerodocusuario);
        misusuarios.setNombreusuarios(nombreusuarios);
        misusuarios.setApellidousuarios(apellidousuarios);
        misusuarios.setCorreousuarios(correousuarios);
        misusuarios.setTelefonousuarios(telefonousuarios);
        misusuarios.setDireccionusuario(direccionusuario);
        misusuarios.setClaveusuario(contraseñausuario);
        misusuarios.setTipo_documento_idtipodoc(tipo_documento_idtipodoc);
        misusuarios.setRoles_idroles(roles_idroles);
        misusuarios.setGenero_idgenero(genero_idgenero);
        misusuarios.setEstado_usuario_idestadousuario(estado_usuario_idestadousuario);

        misusuarios.setNumerodocusuario("10021475");
        String mirespuesta = misusuariosDAO.Actualizarusuario(misusuarios);
        
        if (mirespuesta.length() == 0) {
            System.out.println("Usuario actualizado");
        } else {
            System.out.println("Error" + mirespuesta);
        }

    }

}
