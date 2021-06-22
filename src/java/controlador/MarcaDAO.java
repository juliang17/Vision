package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.marca;

public class MarcaDAO {

    public String AdicionarMarca(marca Marca) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "Insert marca (descripcionmarca)" + "values (?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, Marca.getDescripcionmarca());
            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en AdicionarMarcaDAO\n" + ex.getMessage());
        }
        return miRespuesta;
    }

    public String ActualizarMarca(marca Marca) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update marca set idmarca=?, descripcionmarca=? where idmarca=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Marca.getIdmarca());
            sentencia.setString(2, Marca.getDescripcionmarca());
            sentencia.setString(3, Marca.getIdmarca());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en ActualizarMarcaDAO\n" + ex.getMessage());
        }
        return miRespuesta;
    }

    public marca ConsultarMarca(String idmarca) {
        marca mi_marca = null;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "Select idmarca, descripcionmarca from marca where idmarca =  " + idmarca;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_marca = new marca();
                mi_marca.setIdmarca(rs.getString(1));
                mi_marca.setDescripcionmarca(rs.getString(2));

            }

            return mi_marca;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarMarcaDAO\n " + ex.getMessage());
        }
        return mi_marca;
    }

    public ArrayList<marca> ConsultarListadoMarca(String idmarca, String descripcionmarca) {
        ArrayList<marca> mi_listado_marca = new ArrayList<marca>();
        marca mi_marca;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + idmarca);
        try {
            Statement sentencia = nuevaCon.createStatement();

            String Query = " select idmarca,descripcionmarca "
                    + " from marca "
                    + " where idmarca like '%" + idmarca + "%' "
                    + "  or (descripcionmarca) like ('%" + descripcionmarca + "%') ORDER BY idmarca;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_marca = new marca();
                mi_marca.setIdmarca(rs.getString(1));
                mi_marca.setDescripcionmarca(rs.getString(2));
                mi_listado_marca.add(mi_marca);
            }
            return mi_listado_marca;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarListadoMarcaDAO\n " + ex.getMessage());
        }
        return mi_listado_marca;

    }

    public String EliminarMarca(marca Marca) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from marca where idmarca = ? and descripcionmarca = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, Marca.getIdmarca());
            sentencia.setString(2, Marca.getDescripcionmarca());
            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en EliminarMarcaDAO" + ex.getMessage());
        }
        return miRespuesta;
    }
}
