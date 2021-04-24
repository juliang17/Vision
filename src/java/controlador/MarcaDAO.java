package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.marca;

public class MarcaDAO {

    public String adicionarmarca(marca MARCA) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "insert marca (descripcionmarca)"
                    + "values (?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, MARCA.getDescripcionmarca());

            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionarmarca/n" + ex.getMessage());
        }
        return mirespuesta;

    }

    public String Actualizarmarca(marca MARCA) {

        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update marca set idmarca=?, descripcionmarca=? where idmarca=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, MARCA.getIdmarca());
            sentencia.setString(2, MARCA.getDescripcionmarca());
            sentencia.setInt(3, MARCA.getIdmarca());

            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el  Actualizarmarca\n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public marca Consultamarca(String descripcionmarca) {
        marca mimarca = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idmarca, descripcionmarca from marca where descripcionmarca = " + descripcionmarca);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                mimarca = new marca();
                mimarca.setIdmarca(rs.getInt(1));
                mimarca.setDescripcionmarca(rs.getString(2));

            }
            return mimarca;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mimarca;
    }

    public ArrayList<marca> listadomarca(String descripcionmarca) {
        ArrayList<marca> milistamimarca = new ArrayList<marca>();
        marca mimarca;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + descripcionmarca);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idmarca, descripcionmarca "
                    + " from marca"
                    + " where descripcionmarca like '%" + descripcionmarca + "%' "
                    + "ORDER BY idmarca; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mimarca = new marca();
                mimarca.setIdmarca(rs.getInt(1));
                mimarca.setDescripcionmarca(rs.getString(2));
                milistamimarca.add(mimarca);

            }
            return milistamimarca;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en listadomarca" + ex.getMessage());
        }
        return milistamimarca;
    }

    public String Eliminarmarca(marca MARCA) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from marca where idmarca = ? and descripcionmarca = ?;";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, MARCA.getIdmarca());
            sentencia.setString(2, MARCA.getDescripcionmarca());

            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Eliminarmarca" + ex.getMessage());
        }
        return mirespuesta;
    }
}
