package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.productos;

public class PRODUCTOS_DAO {

    public String adicionarproductos(productos PRODUCTOS) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "insert productos (nombreproducto, cantidadproducto, ivaproducto, descripcionproducto, precio)"
                    + "values (?,?,?,?,?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, PRODUCTOS.getNombreproducto());
            sentencia.setInt(2, PRODUCTOS.getCantidadproducto());
            sentencia.setInt(3, PRODUCTOS.getIvaproducto());
            sentencia.setString(4, PRODUCTOS.getDescripcionproducto());
            sentencia.setInt(5, PRODUCTOS.getPrecio());

            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionarproductos/n" + ex.getMessage());
        }
        return mirespuesta;

    }

    public String Actualizarproductos(productos PRODUCTOS) {

        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update productos set idproductos=?, nombreproducto=?, cantidadproducto=?, ivaproducto=?, descripcionproducto=?, precio=? where idproductos=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, PRODUCTOS.getIdproductos());
            sentencia.setString(2, PRODUCTOS.getNombreproducto());
            sentencia.setInt(3, PRODUCTOS.getCantidadproducto());
            sentencia.setInt(4, PRODUCTOS.getIvaproducto());
            sentencia.setString(5, PRODUCTOS.getDescripcionproducto());
            sentencia.setInt(6, PRODUCTOS.getPrecio());
            sentencia.setInt(7, PRODUCTOS.getIdproductos());

            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el  Actualizarproductos\n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public productos Consultaproductos(int idproductos) {
        productos miproductos = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idproductos, nombreproducto, cantidadproducto, ivaproducto, descripcionproducto, precio from productos where idproductos = " + idproductos);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                miproductos = new productos();
                miproductos.setIdproductos(rs.getInt(1));
                miproductos.setNombreproducto(rs.getString(2));
                miproductos.setCantidadproducto(rs.getInt(3));
                miproductos.setIvaproducto(rs.getInt(4));
                miproductos.setDescripcionproducto(rs.getString(5));
                miproductos.setPrecio(rs.getInt(6));

            }
            return miproductos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return miproductos;
    }

    public ArrayList<productos> listadoproductos(int idproductos, int nombreproducto) {
        ArrayList<productos> milistaproductos = new ArrayList<productos>();
        productos miproductos;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + idproductos);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idproductos, nombreproducto, cantidadproducto, ivaproducto, descripcionproducto, precio "
                    + " from productos"
                    + " where idproductos like '%" + idproductos + "%' "
                    + " or (nombreproducto) like ('%" + nombreproducto + "%') ORDER BY idproductos; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                miproductos = new productos();
                miproductos.setIdproductos(rs.getInt(1));
                miproductos.setNombreproducto(rs.getString(2));
                miproductos.setCantidadproducto(rs.getInt(3));
                miproductos.setIvaproducto(rs.getInt(4));
                miproductos.setDescripcionproducto(rs.getString(5));
                miproductos.setPrecio(rs.getInt(6));
                milistaproductos.add(miproductos);

            }
            return milistaproductos;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en listadoproductos" + ex.getMessage());
        }
        return milistaproductos;
    }

    public String Eliminarproductos(productos PRODUCTOS) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from productos where idproductos = ? and nombreproducto = ?;";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, PRODUCTOS.getIdproductos());
            sentencia.setString(2, PRODUCTOS.getNombreproducto());

            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Eliminarproductos" + ex.getMessage());
        }
        return mirespuesta;
    }

}
