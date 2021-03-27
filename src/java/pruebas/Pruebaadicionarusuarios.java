package pruebas;

import controlador.usuariosDAO;
import java.util.Scanner;
import modelo.usuarios;

public class Pruebaadicionarusuarios {

    public static void main(String[] args) {

        usuariosDAO misusuariosDAO = new usuariosDAO();
        usuarios misusuarios = new usuarios();

        Scanner leer = new Scanner(System.in);

        String Nombre;
        String Apellidos;
        String Correo;
        String Direccion;
        String Password;
        String Doc; 
        String Telefono;
        int tDoc;
        int rol;
        int genero;
        int estado;

        System.out.println("Digite su numero de documento");
        Doc = leer.nextLine();
        System.out.println("Digite sus nombres");
        Nombre = leer.nextLine();
        System.out.println("Digite sus apellidos");
        Apellidos = leer.nextLine();
        System.out.println("Digite su correo");
        Correo = leer.nextLine();
        System.out.println("Digite su telefono");
        Telefono = leer.nextLine();
        System.out.println("Digite su direccion");
        Direccion = leer.next();
        System.out.println("Digite su contraseña");
        Password = leer.next();
        System.out.println("Digite su tipo de documento");
        tDoc = leer.nextInt();
        System.out.println("Digite su rol");
        rol = leer.nextInt();
        System.out.println("Digite su genero");
        genero = leer.nextInt();
        System.out.println("Digite su estado usuario");
        estado = leer.nextInt();

        misusuarios.setNumerodocusuario(Doc);
        misusuarios.setNombreusuarios(Nombre);
        misusuarios.setApellidousuarios(Apellidos);
        misusuarios.setCorreousuarios(Correo);
        misusuarios.setTelefonousuarios(Telefono);
        misusuarios.setDireccionusuario(Direccion);
        misusuarios.setClaveusuario(Password);
        misusuarios.setTipo_documento_idtipodoc(tDoc);
        misusuarios.setRoles_idroles(rol);
        misusuarios.setGenero_idgenero(genero);
        misusuarios.setEstado_usuario_idestadousuario(estado);
        String mirespuesta = misusuariosDAO.adicionarusuarios(misusuarios);

        if (mirespuesta.length() == 0) {
            System.out.println("Registro exitoso");
        } else {
            System.out.println("ocurrio un error" + mirespuesta);

        }

    }

}
