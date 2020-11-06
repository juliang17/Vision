package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.proveedores;

public class PROVEEDORES_DAO {

    public String adicionarproveedores(proveedores PROVEEDORES) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "insert proveedores (nombreproveedores, correoproveedores, telefonoproveedores)"
                    + "values (?,?,?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, PROVEEDORES.getNombreproveedores());
            sentencia.setString(2, PROVEEDORES.getCorreoproveedores());
            sentencia.setInt(3, PROVEEDORES.getTelefonoproveedores());

            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionarproveedores/n" + ex.getMessage());
        }
        return mirespuesta;

    }

    public String Actualizarproveedores(proveedores PROVEEDORES) {

        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update proveedores set idproductos=?, nombreproveedores=?, correoproveedores=?, telefonoproveedores=? where idProveedores=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, PROVEEDORES.getIdProveedores());
            sentencia.setString(2, PROVEEDORES.getNombreproveedores());
            sentencia.setString(3, PROVEEDORES.getCorreoproveedores());
            sentencia.setInt(4, PROVEEDORES.getTelefonoproveedores());
            sentencia.setInt(5, PROVEEDORES.getIdProveedores());

            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el  Actualizarproveedores\n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public proveedores Consultaproveedores(int idProveedores) {
        proveedores miproveedores = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idProveedores, nombreproveedores, correoproveedores, telefonoproveedores from proveedores where idProveedores = " + idProveedores);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                miproveedores = new proveedores();
                miproveedores.setIdProveedores(rs.getInt(1));
                miproveedores.setNombreproveedores(rs.getString(2));
                miproveedores.setCorreoproveedores(rs.getString(3));
                miproveedores.setTelefonoproveedores(rs.getInt(4));

            }
            return miproveedores;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return miproveedores;
    }

    public ArrayList<proveedores> listadoproveedores(int idProveedores, String nombreproveedores) {
        ArrayList<proveedores> milistaproveedores = new ArrayList<proveedores>();
        proveedores miproveedores;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + idProveedores);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idProveedores, nombreproveedores, correoproveedores, telefonoproveedores "
                    + " from proveedores"
                    + " where idProveedores like '%" + idProveedores + "%' "
                    + " or (nombreproveedores) like ('%" + nombreproveedores + "%') ORDER BY idProveedores; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                miproveedores = new proveedores();
                miproveedores.setIdProveedores(rs.getInt(1));
                miproveedores.setNombreproveedores(rs.getString(2));
                miproveedores.setCorreoproveedores(rs.getString(3));
                miproveedores.setTelefonoproveedores(rs.getInt(4));
                milistaproveedores.add(miproveedores);

            }
            return milistaproveedores;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en listadoproveedores" + ex.getMessage());
        }
        return milistaproveedores;
    }

    public String Eliminarproveedores(proveedores PROVEEDORES) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from proveedores where idProveedores = ? and nombreproveedores = ?;";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, PROVEEDORES.getIdProveedores());
            sentencia.setString(2, PROVEEDORES.getNombreproveedores());

            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Eliminarproveedores" + ex.getMessage());
        }
        return mirespuesta;
    }

}
