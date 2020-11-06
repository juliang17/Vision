package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.estado_usuario;

public class estado_usuarioDAO {

    public String adicionarestado_usuario(estado_usuario estado) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {

            String Query = "Insert estado_usuario (descripcionestadousuario)" + "values (?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, estado.getdescripcionestadousuario());
            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionar estado_usuario_estado_usuarioDAO/n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public String actualizarestado_usuario(estado_usuario estado) {
        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update estado_usuario set descripcionestadousuario=? where idestadousuario=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, estado.getdescripcionestadousuario());
            sentencia.setInt(2, estado.getidestadousuario());
            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.err.println("Ocurrio un error en actualizar estado usuario/n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public estado_usuario Consultarestado_usuario(String idestadousuario) {

        estado_usuario miestadousuario = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idestadousuario, descripcionestadousuario from estado_usuario where idestadousuario =" + idestadousuario);
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                miestadousuario = new estado_usuario();
                miestadousuario.setidestadousuario(rs.getInt(1));
                miestadousuario.setdescripcionestadousuario(rs.getString(2));
            }
            return miestadousuario;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return miestadousuario;
    }

    public ArrayList<estado_usuario> Consultarlistadoestado_usuario(String Estado) {
        ArrayList<estado_usuario> milistaestado = new ArrayList<estado_usuario>();
        estado_usuario mitipoestado;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idestadousuario, descripcionestadousuario" + " from estado_usuario"
                    + " where idestadousuario like '%" + Estado + "%' ORDER BY idestadousuario; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mitipoestado = new estado_usuario();
                mitipoestado.setidestadousuario(rs.getInt(1));
                mitipoestado.setdescripcionestadousuario(rs.getString(2));
                milistaestado.add(mitipoestado);
            }
            return milistaestado;
        } catch (Exception ex) {
            System.err.println("Ocurrio un error en la consulta de listado en el estado usuario" + ex.getMessage());
        }
        return milistaestado;
    }

    public String Eliminarestado_usuario(estado_usuario estado) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from estado_usuario where idestadousuario = ? and descripcionestadousuario = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, estado.getidestadousuario());
            sentencia.setString(2, estado.getdescripcionestadousuario());
            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en estado_usuarioDAO.Eliminarestado_usuario" + ex.getMessage());
        }
        return mirespuesta;
    }

}
