
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.unidad_de_medida;

public class UnidadDeMedidaDAO {
    public String adicionarunidaddemedida(unidad_de_medida UNIDADMEDIDA) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "insert unidad_de_medida (descripcionunidadmedida)"
                    + "values (?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, UNIDADMEDIDA.getDescripcionunidadmedida());

            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionarunidaddemedida/n" + ex.getMessage());
        }
        return mirespuesta;

    }
    
    public String Actualizarunidaddemedida(unidad_de_medida UNIDADMEDIDA) {

        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update unidad_de_medida set idunidadmedida=?, descripcionunidadmedida=? where descripcionunidadmedida=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, UNIDADMEDIDA.getIdunidadmedida());
            sentencia.setString(2, UNIDADMEDIDA.getDescripcionunidadmedida());
            sentencia.setString(3, UNIDADMEDIDA.getDescripcionunidadmedida());

            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el  Actualizarunidaddemedida\n" + ex.getMessage());
        }
        return mirespuesta;
    }
    
    public unidad_de_medida Consultarunidaddemedida(String descripcionunidadmedida) {
        unidad_de_medida miunidadmedida = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idunidadmedida, descripcionunidadmedida from unidad_de_medida where descripcionunidadmedida = " + descripcionunidadmedida);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                miunidadmedida = new unidad_de_medida();
                miunidadmedida.setIdunidadmedida(rs.getInt(1));
                miunidadmedida.setDescripcionunidadmedida(rs.getString(2));

            }
            return miunidadmedida;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return miunidadmedida;
    }
    
     public ArrayList<unidad_de_medida> listadounidaddemedida(String descripcionunidadmedida) {
        ArrayList<unidad_de_medida> milistaunidadmedida = new ArrayList<unidad_de_medida>();
        unidad_de_medida miunidadmedida;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + descripcionunidadmedida);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idunidadmedida, descripcionunidadmedida "
                    + " from unidad_de_medida"
                    + " where descripcionunidadmedida like '%" + descripcionunidadmedida + "%' "
                    + "ORDER BY descripcionunidadmedida; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                miunidadmedida = new unidad_de_medida();
                miunidadmedida.setIdunidadmedida(rs.getInt(1));
                miunidadmedida.setDescripcionunidadmedida(rs.getString(2));
                milistaunidadmedida.add(miunidadmedida);

            }
            return milistaunidadmedida;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en listadocategorias" + ex.getMessage());
        }
        return milistaunidadmedida;
    }
     
     public String Eliminarunidaddemedida(unidad_de_medida UNIDADMEDIDA) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from unidad_de_medida where idunidadmedida = ? and descripcionunidadmedida = ?;";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, UNIDADMEDIDA.getIdunidadmedida());
            sentencia.setString(2, UNIDADMEDIDA.getDescripcionunidadmedida());

            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Eliminarcategorias" + ex.getMessage());
        }
        return mirespuesta;
    }
    
}
