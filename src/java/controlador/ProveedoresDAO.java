
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.proveedores;

public class ProveedoresDAO {
    
    public String adicionarproveedores(proveedores PROVEEDORES) {

        String mirespuesta;
        controlador.Conexion miconexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "Insert into proveedores (identificacionproveedores, nombreproveedores, correoproveedores, telefonoproveedores)" + "values (?,?,?,?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, PROVEEDORES.getIdentificacionproveedores());
            sentencia.setString(2, PROVEEDORES.getNombreproveedores());
            sentencia.setString(3, PROVEEDORES.getCorreoproveedores());
            sentencia.setInt(4, PROVEEDORES.getTelefonoproveedores());

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
        controlador.Conexion miconexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update proveedores set identificacionproveedores=?, nombreproveedores=?, correoproveedores=?, telefonoproveedores=? where identificacionproveedores=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, PROVEEDORES.getIdentificacionproveedores());
            sentencia.setString(2, PROVEEDORES.getNombreproveedores());
            sentencia.setString(3, PROVEEDORES.getCorreoproveedores());
            sentencia.setInt(4, PROVEEDORES.getTelefonoproveedores());
            sentencia.setString(5, PROVEEDORES.getIdentificacionproveedores());

            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el  Actualizarproveedores\n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public proveedores Consultaproveedores(String identificacionproveedores) {
        proveedores miproveedores = null;

        controlador.Conexion miconexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idProveedores, identificacionproveedores, nombreproveedores, correoproveedores, telefonoproveedores from proveedores where identificacionproveedores = " + identificacionproveedores);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                miproveedores = new proveedores();
                miproveedores.setIdProveedores(rs.getInt(1));
                miproveedores.setIdentificacionproveedores(rs.getString(2));
                miproveedores.setNombreproveedores(rs.getString(3));
                miproveedores.setCorreoproveedores(rs.getString(4));
                miproveedores.setTelefonoproveedores(rs.getInt(5));

            }
            return miproveedores;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return miproveedores;
    }

    public ArrayList<proveedores> listadoproveedores(String identificacionproveedores, String nombreproveedores, String correoproveedores) {
        ArrayList<proveedores> milistaproveedores = new ArrayList<proveedores>();
        proveedores miproveedores;

        controlador.Conexion miConexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + identificacionproveedores);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idProveedores, identificacionproveedores, nombreproveedores, correoproveedores, telefonoproveedores "
                    + " from proveedores "
                    + " where identificacionproveedores like '%" + identificacionproveedores + "%' "
                    + "  or (nombreproveedores) like ('%" + nombreproveedores + "%') "
                    + "  or (correoproveedores) like ('%" + correoproveedores + "%') ORDER BY identificacionproveedores;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                miproveedores = new proveedores();
                miproveedores.setIdProveedores(rs.getInt(1));
                miproveedores.setIdentificacionproveedores(rs.getString(2));
                miproveedores.setNombreproveedores(rs.getString(3));
                miproveedores.setCorreoproveedores(rs.getString(4));
                miproveedores.setTelefonoproveedores(rs.getInt(5));
                milistaproveedores.add(miproveedores);

            }
            return milistaproveedores;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en listadoproveedores" + ex.getMessage());
        }
        return milistaproveedores;
    }

    public String Eliminarproveedores(proveedores Proveedor) {
        String mirespuesta;
        controlador.Conexion miConexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from proveedores where idproveedores = ? and identificacionproveedores = ? ;";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, Proveedor.getIdProveedores());
            sentencia.setString(2, Proveedor.getIdentificacionproveedores());

            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Eliminarproveedores" + ex.getMessage());
        }
        return mirespuesta;
    }

    
}
