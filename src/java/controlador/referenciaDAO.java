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

    public String Adicionardetalle_Referencia(referencia_de_pago Refrencia_Pago) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;

        try {

            String Query = "Insert into referencia_de_pago (fechadepago, medio_de_pago_idMedioDePago)" + "values (?,?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Refrencia_Pago.getFechadepago());
            sentencia.setInt(2, Refrencia_Pago.getMedio_de_pago_idMedioDePago());

            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Adicionardetalle_Referencia\n" + miRespuesta);

        }

        return miRespuesta;

    }

    public String ModificarReferencia(referencia_de_pago Refrencia_Pago) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update referencia_de_pago set idreferenciadepago=?, fechadepago=?, medio_de_pago_idMedioDePago=? where idreferenciadepago=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, Refrencia_Pago.getIdreferenciadepago());
            sentencia.setString(2, Refrencia_Pago.getFechadepago());
            sentencia.setInt(3, Refrencia_Pago.getMedio_de_pago_idMedioDePago());
            sentencia.setInt(4, Refrencia_Pago.getIdreferenciadepago());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en ModificarReferencia\n " + ex.getMessage());
        }
        return miRespuesta;
    }

     public referencia_de_pago ConsultarReferencia(String fechadepago) {
             referencia_de_pago mi_referencia_pago = null;


        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "Select idreferenciadepago,fechadepago, medio_de_pago_idMedioDePago from referencia_de_pago where fechadepago = " + fechadepago;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_referencia_pago = new referencia_de_pago();
                mi_referencia_pago.setIdreferenciadepago(rs.getInt(1));
                mi_referencia_pago.setFechadepago(rs.getString(2));
                mi_referencia_pago.setMedio_de_pago_idMedioDePago(rs.getInt(3));
                
            }

            return mi_referencia_pago;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarReferencia\n " + ex.getMessage());
        }
        return mi_referencia_pago;
    }
     
     public ArrayList<referencia_de_pago> ListadoReferenciaDePago(String fechadepago) {
        ArrayList<referencia_de_pago> listado_referencia_de_pago = new ArrayList<referencia_de_pago>();
        referencia_de_pago mi_referencia_pago;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + fechadepago);
        try {
            Statement sentencia = nuevaCon.createStatement();

            String Query = " select idreferenciadepago,fechadepago, medio_de_pago_idMedioDePago "
                    + " from referencia_de_pago "
                    + " where fechadepago like '%" + fechadepago + "%' "
                    + " ORDER BY idreferenciadepago;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_referencia_pago = new referencia_de_pago();
                mi_referencia_pago.setIdreferenciadepago(rs.getInt(1));
                mi_referencia_pago.setFechadepago(rs.getString(2));
                mi_referencia_pago.setMedio_de_pago_idMedioDePago(rs.getInt(3));
                listado_referencia_de_pago.add(mi_referencia_pago);
            }
            return listado_referencia_de_pago;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ListadoReferenciaDePago\n " + ex.getMessage());
        }
        return listado_referencia_de_pago;
    }

     public String EliminarReferenciaDePago (referencia_de_pago ReferenciaDePago) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from referencia_de_pago where idreferenciadepago = ?;";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, ReferenciaDePago.getIdreferenciadepago());

            sentencia.execute();

            miRespuesta = "";

        } catch (Exception ex) {
            
            miRespuesta = ex.getMessage();
            
            System.out.println("Ocurrio un error en EliminarReferenciaDePago" + ex.getMessage());
        }
        return miRespuesta;
    }


}
