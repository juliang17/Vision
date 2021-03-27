package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.detalle_movimiento;

/**
 *
 * @author Jeffe
 */
public class detalleDAO {

    public String Adicionardetalle_Movimiento(detalle_movimiento Detalle_Movimiento) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;

        try {

            String Query = "Insert into detalle_movimiento (cantidad, iva, subtotal, precio, mocimiento_id_movimiento, productos_idproductos)" + "values (?,?,?,?,?,?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, Detalle_Movimiento.getCantidad());
            sentencia.setInt(2, Detalle_Movimiento.getIva());
            sentencia.setInt(3, Detalle_Movimiento.getSubtotal());
            sentencia.setInt(4, Detalle_Movimiento.getPrecio());
            sentencia.setInt(5, Detalle_Movimiento.getMovimiento_idmovimiento());
            sentencia.setInt(6, Detalle_Movimiento.getProductos_idproductos());

            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Adicionardetalle_Movimiento\n" + miRespuesta);

        }

        return miRespuesta;

    }

    public String ModificarDetalle(detalle_movimiento Detalle_Movimiento) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update detalle_movimiento set iddetallemovimiento=?,cantidad=?, iva=?, subtotal=?, precio=?, mocimiento_id_movimiento=?, productos_idproductos=? where iddetallemovimiento=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, Detalle_Movimiento.getIddetallemovimiento());
            sentencia.setInt(2, Detalle_Movimiento.getCantidad());
            sentencia.setInt(3, Detalle_Movimiento.getIva());
            sentencia.setInt(4, Detalle_Movimiento.getSubtotal());
            sentencia.setInt(5, Detalle_Movimiento.getPrecio());
            sentencia.setInt(6, Detalle_Movimiento.getMovimiento_idmovimiento());
            sentencia.setInt(7, Detalle_Movimiento.getProductos_idproductos());
            sentencia.setInt(8, Detalle_Movimiento.getIddetallemovimiento());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en ModificarDetalle\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public detalle_movimiento ConsultarDetalle_movimiento(int iddetallemovimiento) {
        detalle_movimiento mi_detalle_movimiento = null;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "Select iddetallemovimiento,cantidad, iva, subtotal, precio, mocimiento_id_movimiento, productos_idproductos from detalle_movimiento where iddetallemovimiento = " + iddetallemovimiento;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_detalle_movimiento = new detalle_movimiento();
                mi_detalle_movimiento.setIddetallemovimiento(rs.getInt(1));
                mi_detalle_movimiento.setCantidad(rs.getInt(2));
                mi_detalle_movimiento.setIva(rs.getInt(3));
                mi_detalle_movimiento.setSubtotal(rs.getInt(4));
                mi_detalle_movimiento.setPrecio(rs.getInt(5));
                mi_detalle_movimiento.setMovimiento_idmovimiento(rs.getInt(6));
                mi_detalle_movimiento.setProductos_idproductos(rs.getInt(7));

            }

            return mi_detalle_movimiento;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarDetalle_movimiento\n " + ex.getMessage());
        }
        return mi_detalle_movimiento;
    }

    public ArrayList<detalle_movimiento> ListadoDetalleMovimiento(int iddetallemovimiento) {
        ArrayList<detalle_movimiento> listado_detalle_movimiento = new ArrayList<detalle_movimiento>();
        detalle_movimiento mi_detalle_movimiento;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + iddetallemovimiento);
        try {
            Statement sentencia = nuevaCon.createStatement();

            String Query = " select iddetallemovimiento,cantidad, iva, subtotal, precio, mocimiento_id_movimiento, productos_idproductos "
                    + " from detalle_movimiento "
                    + " where iddetallemovimiento like '%" + iddetallemovimiento + "%' "
                    + "ORDER BY iddetallemovimiento;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_detalle_movimiento = new detalle_movimiento();
                mi_detalle_movimiento.setIddetallemovimiento(rs.getInt(1));
                mi_detalle_movimiento.setCantidad(rs.getInt(2));
                mi_detalle_movimiento.setIva(rs.getInt(3));
                mi_detalle_movimiento.setSubtotal(rs.getInt(4));
                mi_detalle_movimiento.setPrecio(rs.getInt(5));
                mi_detalle_movimiento.setMovimiento_idmovimiento(rs.getInt(6));
                mi_detalle_movimiento.setProductos_idproductos(rs.getInt(7));
                listado_detalle_movimiento.add(mi_detalle_movimiento);
            }
            return listado_detalle_movimiento;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ListadoDetalleMovimiento\n " + ex.getMessage());
        }
        return listado_detalle_movimiento;
    }

    public String EliminarDetalleMovimiento(detalle_movimiento DetalleMovimiento) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from detalle_movimiento where iddetallemovimiento = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, DetalleMovimiento.getIddetallemovimiento());

            sentencia.execute();

            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en EliminarDetalleMovimiento" + ex.getMessage());
        }
        return miRespuesta;
    }

}
