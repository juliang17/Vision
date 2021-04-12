package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.inventario;

public class inventarioDAO {

    public String adicionarinventario(inventario INVENTARIO) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "Insert into inventario (entrada,salida,saldo,productos_idproductos)"
                    + "values (?,?,?,?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, INVENTARIO.getEntrada());
            sentencia.setInt(2, INVENTARIO.getSalida());
            sentencia.setInt(3, INVENTARIO.getSaldo());;
            sentencia.setInt(4, INVENTARIO.getProductos_idproductos());
            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionar inventario_inventarioDAO/n" + ex.getMessage());
        }
        return mirespuesta;

    }

    public String Actualizarinventario(inventario INVENTARIO) {

        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update inventario set idinventario=?,entrada=?, salida=?, saldo=?, productos_idproductos=?, where idinventario=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, INVENTARIO.getIdinventario());
            sentencia.setInt(2, INVENTARIO.getEntrada());
            sentencia.setInt(3, INVENTARIO.getSalida());
            sentencia.setInt(4, INVENTARIO.getSaldo());
            sentencia.setInt(5, INVENTARIO.getProductos_idproductos());
            sentencia.setInt(6, INVENTARIO.getIdinventario());

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el Actualizar inventario_inventarioDAO \n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public inventario Consultarinventario(String idinventario) {
        inventario miinventario = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("Select idinventario, entrada, salida, saldo, productos_idproductos from inventario where idinventario = " + idinventario);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                miinventario = new inventario();
                miinventario.setIdinventario(rs.getInt(1));
                miinventario.setEntrada(rs.getInt(2));
                miinventario.setSalida(rs.getInt(3));
                miinventario.setSaldo(rs.getInt(4));
                miinventario.setProductos_idproductos(rs.getInt(5));
            }
            return miinventario;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return miinventario;
    }

    public ArrayList<inventario> Consultarlistadoinventario(String idinventario, String entrada, String salida) {
        ArrayList<inventario> milistainventario = new ArrayList<inventario>();
        inventario miinventario;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + idinventario);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idinventario, entrada, salida, saldo, productos_idproductos"
                    + " from inventario"
                    + " where idinventario like '%" + idinventario + "%' "
                    + "  or (entrada) like ('%" + entrada + "%')"
                    + "  or (salida) like ('%" + salida + "%') ORDER BY idinventario;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                miinventario = new inventario();
                miinventario.setIdinventario(rs.getInt(1));
                miinventario.setEntrada(rs.getInt(2));
                miinventario.setSalida(rs.getInt(3));
                miinventario.setSaldo(rs.getInt(4));
                miinventario.setProductos_idproductos(rs.getInt(5));
                milistainventario.add(miinventario);

            }
            return milistainventario;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en la consulta de listado en el inventario" + ex.getMessage());
        }
        return milistainventario;
    }

    public String Eliminarinventario(inventario INVENTARIO) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from inventario where idinventario = ?;";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, INVENTARIO.getIdinventario());
            sentencia.execute();
            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en inventarioDAO.Eliminarinventario" + ex.getMessage());
        }
        return mirespuesta;
    }

}
