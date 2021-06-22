package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.inventario;

public class inventarioDAO {

    public String AdicionarInventario(inventario Inventario) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "Insert into inventario (entrada, salida, saldo, productos_idproductos)" + "values (?,?,?,?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, Inventario.getEntrada());
            sentencia.setInt(2, Inventario.getSalida());
            sentencia.setInt(3, Inventario.getSaldo());
            sentencia.setInt(4, Inventario.getProductos_idproductos());

            
            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en AdicionarInventario\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public String ActualizarInventario(inventario Inventario) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update inventario set idinventario=?, entrada=?, salida=?, saldo=?, productos_idproductos=? where idinventario=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, Inventario.getIdinventario());
            sentencia.setInt(2, Inventario.getEntrada());
            sentencia.setInt(3, Inventario.getSalida());
            sentencia.setInt(4, Inventario.getSaldo());
            sentencia.setInt(5, Inventario.getProductos_idproductos());
            sentencia.setInt(6, Inventario.getIdinventario());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en ActualizarInventario\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public inventario ConsultarInventario(String idinventario) {
        inventario mi_inventario = null;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "Select idinventario, entrada, salida, saldo, productos_idproductos from inventario where idinventario = " + idinventario;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_inventario = new inventario();
                mi_inventario.setIdinventario(rs.getInt(1));
                mi_inventario.setEntrada(rs.getInt(2));
                mi_inventario.setSalida(rs.getInt(3));
                mi_inventario.setSaldo(rs.getInt(4));
                mi_inventario.setProductos_idproductos(rs.getInt(5));     
            }

            return mi_inventario;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarInventario\n " + ex.getMessage());
        }
        return mi_inventario;
    }

    public ArrayList<inventario> ListadoInventario(String idinventario, String entrada, String salida) {

        ArrayList<inventario> mi_lista_inventario = new ArrayList<inventario>();
        inventario mi_inventario;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro" + idinventario);

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "select idinventario,entrada,salida,saldo, productos_idproductos "
                    + " from inventario"
                    + " where idinventario like '%" + idinventario + "%'"
                    + "  or (entrada) like ('%" + entrada + "%')"
                    + "  or (salida) like ('%" + salida + "%') ORDER BY idinventario;";
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {

                mi_inventario = new inventario();
                mi_inventario.setIdinventario(rs.getInt(1));
                mi_inventario.setEntrada(rs.getInt(2));
                mi_inventario.setSalida(rs.getInt(3));
                mi_inventario.setSaldo(rs.getInt(4));
                mi_inventario.setProductos_idproductos(rs.getInt(5)); 

                mi_lista_inventario.add(mi_inventario);

            }

            return mi_lista_inventario;

        } catch (Exception ex) {

            System.out.println("Error en el ListadoInventario" + "\n" + ex.getMessage());
            return mi_lista_inventario;

        }

    }

    public String EliminarInventario(inventario Inventario) {

        String miRespuesta;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;

        try {

            String Query = "delete from inventario where idinventario = ?  ";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, Inventario.getIdinventario());
            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();
            System.err.println("Ocurrio un error en EliminarInventario" + ex.getMessage());
        }
        return miRespuesta;

    }
}
