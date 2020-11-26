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
        int Telefono;
        int tDoc;
        int rol;
        int genero;
        int estado;

        System.out.println("Digite su numero de documento");
        Doc = leer.nextLine();
        System.out.println("Digite sus nombres");
        Nombre = leer.next();
        System.out.println("Digite sus apellidos");
        Apellidos = leer.next();
        System.out.println("Digite su correo");
        Correo = leer.next();
        System.out.println("Digite su telefono");
        Telefono = leer.nextInt();
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

        misusuarios.setnumerodocusuario(Doc);
        misusuarios.setnombreusuarios(Nombre);
        misusuarios.setapellidousuarios(Apellidos);
        misusuarios.setcorreousuarios(Correo);
        misusuarios.settelefonousuarios(Telefono);
        misusuarios.setdireccionusuario(Direccion);
        misusuarios.setcontraseñausuario(Password);
        misusuarios.settipo_documento_idtipodoc(tDoc);
        misusuarios.setroles_idroles(rol);
        misusuarios.setgenero_idgenero(genero);
        misusuarios.setestado_usuario_idestadousuario(estado);
        String mirespuesta = misusuariosDAO.adicionarusuarios(misusuarios);

        if (mirespuesta.length() == 0) {
            System.out.println("Registro exitoso");
        } else {
            System.out.println("ocurrio un error" + mirespuesta);

        }

    }

}
