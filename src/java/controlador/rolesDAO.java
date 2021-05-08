package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.roles;

public class rolesDAO {

    public String adicionarroles(roles ROLES) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "insert roles(descripcionrol)" + "Values (?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, ROLES.getDescripcionrol());
            sentencia.execute();
            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionar roles_rolesDAO/n" + ex.getMessage());

        }
        return mirespuesta;
    }

    public String actualizarroles(roles ROLES) {
        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update roles set descripcionrol=? where idroles=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, ROLES.getDescripcionrol());
            sentencia.setString(2, ROLES.getIdroles());
            sentencia.executeLargeUpdate();

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en actualizar roles_ROLESDAO/n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public roles Consultarroles(String idroles) {

        roles misroles = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idroles, descripcionrol from roles where idroles=" + idroles);
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                misroles = new roles();
                misroles.setIdroles(rs.getString(1));
                misroles.setDescripcionrol(rs.getString(2));
            }
            return misroles;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return misroles;
    }

    public ArrayList<roles> Consultarlistadoroles(String idroles , String descripcionrol) {
        ArrayList<roles> milistaroles = new ArrayList<roles>();
        roles mitiporol;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();


        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idroles,descripcionrol " 
                    + " from roles "
                    + " where idroles like '%" + idroles + "%' " 
                    + "  or (descripcionrol) like ('%" + descripcionrol + "%') ORDER BY idroles;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mitiporol = new roles();
                mitiporol.setIdroles(rs.getString(1));
                mitiporol.setDescripcionrol(rs.getString(2));
                milistaroles.add(mitiporol);
            }
            return milistaroles;
        } catch (Exception ex) {
            System.out.println("Ocurrio un error en la consulta de listado en los roles" + ex.getMessage());
        }
        return milistaroles;
    }

    public String Eliminarroles(roles rol) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from roles where idroles = ? and descripcionrol = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, rol.getIdroles());
            sentencia.setString(2, rol.getDescripcionrol());
            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en rolesDAO.Eliminarroles" + ex.getMessage());
        }
        return mirespuesta;
    }

}
