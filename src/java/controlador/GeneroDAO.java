package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.genero;

public class GeneroDAO {

    public String adicionargenero(genero GENERO) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "insert genero (descripciongenero)" + "values (?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, GENERO.getdescripciongenero());
            sentencia.execute();
            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionar genero_GeneroDAO/n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public String actualizargenero(genero GENERO) {
        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update genero set descripciongenero=? where idgenero=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, GENERO.getdescripciongenero());
            sentencia.setInt(2, GENERO.getidgenero());
            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.err.println("Ocurrio un error en actualizar genero_GeneroDAO/n" + ex.getMessage());

        }
        return mirespuesta;
    }

    public genero Consultargenero(int idgenero) {

        genero migenero = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idgenero, descripciongenero from genero where idgenero = " + idgenero);
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                migenero = new genero();
                migenero.setidgenero(rs.getInt(1));
                migenero.setdescripciongenero(rs.getString(2));
            }
            return migenero;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return migenero;
    }

    public ArrayList<genero> Consultarlistadogenero(int idgenero, String descripciongenero) {
        ArrayList<genero> milistagenero = new ArrayList<genero>();
        genero mitipogenero;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro" + idgenero);

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idgenero, descripciongenero " + " from genero "
                    + " where idgenero like '%" + idgenero + "%' "
                    + " or (descripciongenero) like ('%" + descripciongenero + "%') ORDER BY idgenero; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mitipogenero = new genero();
                mitipogenero.setidgenero(rs.getInt(1));
                mitipogenero.setdescripciongenero(rs.getString(2));
                milistagenero.add(mitipogenero);
            }
            return milistagenero;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en la consulta de listado en el genero" + ex.getMessage());
        }
        return milistagenero;
    }

    public String Eliminargenero(genero GENERO) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from genero where idgenero = ? and descripciongenero = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, GENERO.getidgenero());
            sentencia.setString(2, GENERO.getdescripciongenero());
            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en generoDAO.Eliminargenero" + ex.getMessage());
        }
        return mirespuesta;

    }
}
