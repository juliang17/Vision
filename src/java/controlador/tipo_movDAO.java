package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.tipo_mov;

public class tipo_movDAO {

    public String Adicionartipo_mov(tipo_mov tipoMov) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;

        try {

            String Query = "Insert into tipo_mov (descripcionTipoMov)" + "values (?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, tipoMov.getDescripcionTipoMov());

            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Adicionartipo_mov\n" + miRespuesta);

        }

        return miRespuesta;

    }

    public String Modificartipo_mov(tipo_mov tipoMov) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update tipo_mov set id_tipo_mov=?, descripcionTipoMov=?, where id_tipo_mov=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, tipoMov.getId_tipo_mov());
            sentencia.setString(2, tipoMov.getDescripcionTipoMov());
            sentencia.setString(3, tipoMov.getId_tipo_mov());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Modificartipo_mov\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public tipo_mov Consultartipo_mov(String id_tipo_mov) {
        
        tipo_mov miTipoMov = null;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select id_tipo_mov , descripcionTipoMov from tipo_mov where id_tipo_mov =" + id_tipo_mov);
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                miTipoMov = new tipo_mov();
                miTipoMov.setId_tipo_mov(rs.getString(1));
                miTipoMov.setDescripcionTipoMov(rs.getString(2));
            }
            return miTipoMov;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return miTipoMov;
    }

    public ArrayList<tipo_mov> ListadoTipoMov(String id_tipo_mov ,String descripcionTipoMov) {
        ArrayList<tipo_mov> listaTipoMov = new ArrayList<tipo_mov>();
        tipo_mov miTipoMov;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + id_tipo_mov);
        try {
            Statement sentencia = nuevaCon.createStatement();

            String Query = " select id_tipo_mov, descripcionTipoMov "
                    + " from tipo_mov "
                    + " where id_tipo_mov like '%" + id_tipo_mov + "%' "
                    + "  or (descripcionTipoMov) like ('%" + descripcionTipoMov + "%') ORDER BY id_tipo_mov;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                miTipoMov = new tipo_mov();
                miTipoMov.setId_tipo_mov(rs.getString(1));
                miTipoMov.setDescripcionTipoMov(rs.getString(2));
                listaTipoMov.add(miTipoMov);
            }
            return listaTipoMov;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ListadoTipoMov\n " + ex.getMessage());
        }
        return listaTipoMov;
    }

    public String EliminarTipoMov(tipo_mov TipoMov) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from tipo_mov where id_tipo_mov = ? and descripcionTipoMov = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, TipoMov.getId_tipo_mov());
            sentencia.setString(2, TipoMov.getDescripcionTipoMov());
            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();

            System.out.println("Ocurrio un error en EliminarTipoMov" + ex.getMessage());
        }
        return miRespuesta;
    }

}
