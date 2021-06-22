/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.referencia_de_pago;

/**
 *
 * @author Jeffe
 */
public class referenciaDAO {

    public String Adicionarreferencia_de_pago(referencia_de_pago Referencia_de_pago) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "Insert referencia_de_pago (descripcion, fechadepago, medio_de_pago_idMedioDePago_)" + "values (?,?,?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, Referencia_de_pago.getDescripcion());
            sentencia.setString(2, Referencia_de_pago.getFechadepago());
            sentencia.setInt(3, Referencia_de_pago.getMedio_de_pago_idMedioDePago_());

            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en AdicionarReferencia_de_pago\n" + ex.getMessage());
        }
        return miRespuesta;
    }

    public String ActualizarReferencia_de_pago(referencia_de_pago Referencia_de_pago) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update referencia_de_pago set idreferenciadepago=?, descripcion=?, fechadepago=?, medio_de_pago_idMedioDePago_ where idreferenciadepago=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Referencia_de_pago.getIdreferenciadepago());
            sentencia.setString(2, Referencia_de_pago.getDescripcion());
            sentencia.setString(3, Referencia_de_pago.getFechadepago());
            sentencia.setInt(4, Referencia_de_pago.getMedio_de_pago_idMedioDePago_());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en ActualizarReferencia_de_pago\n" + ex.getMessage());
        }
        return miRespuesta;
    }

    public referencia_de_pago ConsultarReferencia_de_pago(String idreferenciadepago) {
        referencia_de_pago mi_referencia_de_pago = null;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "Select idreferenciadepago, descripcion, fechadepago, medio_de_pago_idMedioDePago_ from referencia_de_pago where idreferenciadepago =  " + idreferenciadepago;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_referencia_de_pago = new referencia_de_pago();
                mi_referencia_de_pago.setIdreferenciadepago(rs.getString(1));
                mi_referencia_de_pago.setDescripcion(rs.getString(2));
                mi_referencia_de_pago.setFechadepago(rs.getString(3));
                mi_referencia_de_pago.setMedio_de_pago_idMedioDePago_(rs.getInt(4));

            }

            return mi_referencia_de_pago;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarReferencia_de_pago\n " + ex.getMessage());
        }
        return mi_referencia_de_pago;
    }

    public ArrayList<referencia_de_pago> ConsultarListadoReferencia_de_pago(String idreferenciadepago, String descripcion) {
        ArrayList<referencia_de_pago> mi_referencia_de_pago = new ArrayList<referencia_de_pago>();
        referencia_de_pago mi_referencia;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + idreferenciadepago);
        try {
            Statement sentencia = nuevaCon.createStatement();

            String Query = " select idreferenciadepago,descripcion,fechadepago,medio_de_pago_idMedioDePago_  "
                    + " from referencia_de_pago "
                    + " where idreferenciadepago like '%" + idreferenciadepago + "%' "
                    + "  or (descripcion) like ('%" + descripcion + "%') ORDER BY idreferenciadepago;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_referencia = new referencia_de_pago();
                mi_referencia.setIdreferenciadepago(rs.getString(1));
                mi_referencia.setDescripcion(rs.getString(2));
                mi_referencia.setFechadepago(rs.getString(3));
                mi_referencia.setMedio_de_pago_idMedioDePago_(rs.getInt(4));
                mi_referencia_de_pago.add(mi_referencia);
            }
            return mi_referencia_de_pago;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarReferencia_de_pago\n " + ex.getMessage());
        }
        return mi_referencia_de_pago;

    }

    public String EliminarReferencia_de_pago(referencia_de_pago Referencia_de_pago) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from referencia_de_pago where idreferenciadepago = ? and descripcion = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, Referencia_de_pago.getIdreferenciadepago());
            sentencia.setString(2, Referencia_de_pago.getDescripcion());
            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en EliminarReferencia_de_pago" + ex.getMessage());
        }
        return miRespuesta;
        }
    }

