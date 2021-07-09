package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.medio_de_pago;

/**
 *
 * @author Jeffe
 */
public class mediodepagoDAO {

    public String AdicionarMedios_de_pago(medio_de_pago Medios_de_pago) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;

        try {

            String Query = "Insert into  medio_de_pago (descripcionmediodepago)" + "values (?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, Medios_de_pago.getDescripcionmediodepago());
            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en AdicionarMedios_de_pago\n" + miRespuesta);

        }

        return miRespuesta;

    }

    public String ModificarMedioPago(medio_de_pago Medios_de_pago) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update medio_de_pago set idMedioDePago=?, descripcionmediodepago=? where idMedioDePago=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Medios_de_pago.getIdMedioDePago());
            sentencia.setString(2, Medios_de_pago.getDescripcionmediodepago());
            sentencia.setString(3, Medios_de_pago.getIdMedioDePago());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en ModificarMedioPago\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public medio_de_pago ConsultarMedio_de_pago(String idMedioDePago) {
        medio_de_pago mi_medio_de_pago = null;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "Select idMedioDePago, descripcionmediodepago from medio_de_pago where idMedioDePago = " + idMedioDePago;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_medio_de_pago = new medio_de_pago();
                mi_medio_de_pago.setIdMedioDePago(rs.getString(1));
                mi_medio_de_pago.setDescripcionmediodepago(rs.getString(2));

            }

            return mi_medio_de_pago;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarMedio_de_pago\n " + ex.getMessage());
        }
        return mi_medio_de_pago;
    }

    public ArrayList<medio_de_pago> ListadoMedioDePago(String idMedioDePago , String descripcionmediodepago) {
        ArrayList<medio_de_pago> listado_medio_de_pago = new ArrayList<medio_de_pago>();
        medio_de_pago mi_medio_de_pago;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + descripcionmediodepago);
        try {
            Statement sentencia = nuevaCon.createStatement();

            String Query = " select idMedioDePago,descripcionmediodepago "
                    + " from medio_de_pago "
                    + " where idMedioDePago like '%" + idMedioDePago + "%' "
                    + "  or (descripcionmediodepago) like ('%" + descripcionmediodepago + "%') ORDER BY idMedioDePago;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_medio_de_pago = new medio_de_pago();
                mi_medio_de_pago.setIdMedioDePago(rs.getString(1));
                mi_medio_de_pago.setDescripcionmediodepago(rs.getString(2));
                listado_medio_de_pago.add(mi_medio_de_pago);
            }
            return listado_medio_de_pago;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ListadoMedioDePago\n " + ex.getMessage());
        }
        return listado_medio_de_pago;
    }

    public String EliminarDetalleMedioDePago(medio_de_pago MedioDePago) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from medio_de_pago where IdMedioDePago = ? and Descripcionmediodepago = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, MedioDePago.getIdMedioDePago());
            sentencia.setString(2, MedioDePago.getDescripcionmediodepago());

            sentencia.execute();

            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();

            System.out.println("Ocurrio un error en EliminarDetalleMedioDePago" + ex.getMessage());
        }
        return miRespuesta;
    }

}
