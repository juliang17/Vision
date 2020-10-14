package pruebas;

import controlador.estado_usuarioDAO;
import java.util.ArrayList;
import modelo.estado_usuario;

public class Pruebaeliminarestadousuario {

    public static void main(String[] args) {

        estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
        ArrayList<estado_usuario> milistaestadousuario = miestadousuarioDAO.Consultarlistadoestado_usuario(' ', "");
        for (estado_usuario E : milistaestadousuario) {
            System.out.println(" id : " + E.getidestadousuario() + " Descripcion : " + E.getdescripcionestadousuario());
        }
        System.out.println("Registro eliminado");
        miestadousuarioDAO.Eliminarestado_usuario(milistaestadousuario.get(0));
        milistaestadousuario = miestadousuarioDAO.Consultarlistadoestado_usuario(' ', "");
        for (estado_usuario E : milistaestadousuario) {
            System.out.println(" id : " + E.getidestadousuario() + " Descripcion : " + E.getdescripcionestadousuario());
        }

    }

}
