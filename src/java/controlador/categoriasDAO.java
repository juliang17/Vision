package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.categorias;

public class categoriasDAO {

    public String adicionarcategorias(categorias CATEGORIAS) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "insert categorias (descripcioncategorias)"
                    + "values (?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, CATEGORIAS.getDescripcioncategorias());

            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionarcategorias/n" + ex.getMessage());
        }
        return mirespuesta;

    }

    public String Actualizarcategorias(categorias CATEGORIAS) {

        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update categorias set idcategorias=?, descripcioncategorias=? where idcategorias=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, CATEGORIAS.getIdcategorias());
            sentencia.setString(2, CATEGORIAS.getDescripcioncategorias());
            sentencia.setInt(3, CATEGORIAS.getIdcategorias());

            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el  Actualizarcategorias\n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public categorias Consultacategorias(int idcategorias) {
        categorias micategorias = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idcategorias, descripcioncategorias from categorias where idcategorias = " + idcategorias);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                micategorias = new categorias();
                micategorias.setIdcategorias(rs.getInt(1));
                micategorias.setDescripcioncategorias(rs.getString(2));

            }
            return micategorias;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return micategorias;
    }

    public ArrayList<categorias> listadocategorias(String descripcioncategorias) {
        ArrayList<categorias> milistacategorias = new ArrayList<categorias>();
        categorias micategorias;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + descripcioncategorias);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idcategorias, descripcioncategorias "
                    + " from categorias"
                    + " where descripcioncategorias like '%" + descripcioncategorias + "%' "
                    + " ORDER BY idcategorias; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                micategorias = new categorias();
                micategorias.setIdcategorias(rs.getInt(1));
                micategorias.setDescripcioncategorias(rs.getString(2));
                milistacategorias.add(micategorias);

            }
            return milistacategorias;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en listadocategorias" + ex.getMessage());
        }
        return milistacategorias;
    }

    public String Eliminarcategorias(categorias CATEGORIAS) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from categorias where idcategorias = ? and descripcioncategorias = ?;";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, CATEGORIAS.getIdcategorias());
            sentencia.setString(2, CATEGORIAS.getDescripcioncategorias());

            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Eliminarcategorias" + ex.getMessage());
        }
        return mirespuesta;
    }
}
