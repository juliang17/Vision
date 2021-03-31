package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.tipo_doc_contable;

public class tipo_doc_contableDAO {

    public String Adicionartipo_doc_contable(tipo_doc_contable tipoDocContable) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;

        try {

            String Query = "Insert into tipo_doc_contable (descripciontipodoccontable)" + "values (?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, tipoDocContable.getDescripciontipodoccontable());

            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Adicionartipo_doc_contable\n" + miRespuesta);

        }

        return miRespuesta;

    }

    public String ModificarTipoDocContable(tipo_doc_contable tipoDocContable) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update tipo_doc_contable set idtipodoccontable=?, descripciontipodoccontable=? where idtipodoccontable=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, tipoDocContable.getIdtipodoccontable());
            sentencia.setString(2, tipoDocContable.getDescripciontipodoccontable());
            sentencia.setInt(4, tipoDocContable.getIdtipodoccontable());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en ModificarTipoDocContable\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public tipo_doc_contable ConsultarTipo_doc_contable(int idtipodoccontable) {
        tipo_doc_contable mi_tipo_doc_contable = null;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "Select idtipodoccontable, descripciontipodoccontable from tipo_doc_contable where idtipodoccontable = " + idtipodoccontable;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_tipo_doc_contable = new tipo_doc_contable();
                mi_tipo_doc_contable.setIdtipodoccontable(rs.getInt(1));
                mi_tipo_doc_contable.setDescripciontipodoccontable(rs.getString(2));
            }

            return mi_tipo_doc_contable;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarReferencia\n " + ex.getMessage());
        }
        return mi_tipo_doc_contable;
    }

    public ArrayList<tipo_doc_contable> ListadoTipoDocContable(int idtipodoccontable, String descripciontipodoccontable) {
        ArrayList<tipo_doc_contable> listado_tipo_doc_contable = new ArrayList<tipo_doc_contable>();
        tipo_doc_contable mi_tipo_doc_contable;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + idtipodoccontable);
        try {
            Statement sentencia = nuevaCon.createStatement();

            String Query = " select idtipodoccontable, descripciontipodoccontable "
                    + " from tipo_doc_contable "
                    + " where idtipodoccontable like '%" + idtipodoccontable + "%' "
                    + "  or (descripciontipodoccontable) like ('%" + descripciontipodoccontable + "%') ORDER BY idtipodoccontable;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_tipo_doc_contable = new tipo_doc_contable();
                mi_tipo_doc_contable.setIdtipodoccontable(rs.getInt(1));
                mi_tipo_doc_contable.setDescripciontipodoccontable(rs.getString(2));
                listado_tipo_doc_contable.add(mi_tipo_doc_contable);
            }
            return listado_tipo_doc_contable;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ListadoTipoDocContable\n " + ex.getMessage());
        }
        return listado_tipo_doc_contable;
    }

    public String EliminarTipoDocContable(tipo_doc_contable TipoDocContable) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from tipo_doc_contable where idtipodoccontable = ? and descripciontipodoccontable = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, TipoDocContable.getIdtipodoccontable());
            sentencia.setString(2, TipoDocContable.getDescripciontipodoccontable());

            sentencia.execute();

            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();

            System.out.println("Ocurrio un error en EliminarTipoDocContable" + ex.getMessage());
        }
        return miRespuesta;
    }

}
