package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.tipo_documento;

public class tipo_documentoDAO {

    public String adicionartipo_documento(tipo_documento tipodoc) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = ("insert tipo_documento(descripciontipodoc)" + "Values (?)");
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, tipodoc.getdescripciontipodoc());
            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un eror en adicionar tipo_documento_tipo_documentoDAO/n" + ex.getMessage());

        }
        return mirespuesta;
    }

    public String actualizartipo_documento(tipo_documento tipodoc) {
        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " update tipo_documento set descripciontipodoc =? where idtipodoc=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, tipodoc.getdescripciontipodoc());
            sentencia.setInt(2, tipodoc.getidtipodoc());
            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en actualizar tipo_documento_tipo_documentoDAO/n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public tipo_documento Consultartipo_documento(String idtipodoc) {
        tipo_documento mitipodoc = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idtipodoc, descripciontipodoc from tipo_documento where idtipodoc =" + idtipodoc);
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mitipodoc = new tipo_documento();
                mitipodoc.setidtipodoc(rs.getInt(1));
                mitipodoc.setdescripciontipodoc(rs.getString(2));
            }
            return mitipodoc;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mitipodoc;
    }

    public ArrayList<tipo_documento> Consultarlistadotipo_documento(String Tipodoc) {
        ArrayList<tipo_documento> listatipodoc = new ArrayList<tipo_documento>();
        tipo_documento mitipodoc;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idtipodoc, descripciontipodoc" + " from tipo_documento"
                    + " where idtipodoc like '%" + Tipodoc + "%' ORDER BY idtipodoc; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mitipodoc = new tipo_documento();
                mitipodoc.setidtipodoc(rs.getInt(1));
                mitipodoc.setdescripciontipodoc(rs.getString(2));
                listatipodoc.add(mitipodoc);
            }
            return listatipodoc;
        } catch (Exception ex) {
            System.out.println("Ocurrio un error en la consulta de listado en el tipo de documento" + ex.getMessage());
        }
        return listatipodoc;
    }

    public String Eliminartipo_documento(tipo_documento tipodoc) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " Delete from tipo_documento where idtipodoc = ? and descripciontipodoc = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, tipodoc.getidtipodoc());
            sentencia.setString(2, tipodoc.getdescripciontipodoc());
            sentencia.execute();
            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en tipo_documentoDAO.Eliminartipo_documento" + ex.getMessage());
        }
        return mirespuesta;
    }

}
