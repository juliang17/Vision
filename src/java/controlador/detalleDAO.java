package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.detalle_movimiento;

public class detalleDAO {

    public String AdicionarDetalle(detalle_movimiento Detalle) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "Insert into detalle_movimiento (cantidad, precio, iva, subtotal,total_producto, productos_idproductos, movimiento_idmovimiento)" + "values (?,?,?,?,?,?,?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, Detalle.getCantidad());
            sentencia.setDouble(2, Detalle.getPrecio());
            sentencia.setDouble(3, Detalle.getIva());
            sentencia.setDouble(4, Detalle.getSubtotal());
            sentencia.setDouble(5, Detalle.getTotal_producto());
            sentencia.setInt(6, Detalle.getProductos_idproductos());
            sentencia.setInt(7, Detalle.getMovimiento_idmovimiento());

            
            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en AdicionarDetalle\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public String ActualizarDetalle(detalle_movimiento Detalle) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update detalle_movimiento set iddetallemovimiento=?, cantidad=?, precio=?, iva=?, subtotal=?, total_producto=?, productos_idproductos=?, movimiento_idmovimiento=? where iddetallemovimiento=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, Detalle.getIddetallemovimiento());
            sentencia.setInt(2, Detalle.getCantidad());
            sentencia.setDouble(3, Detalle.getPrecio());
            sentencia.setDouble(4, Detalle.getIva());
            sentencia.setDouble(5, Detalle.getSubtotal());
            sentencia.setDouble(6, Detalle.getTotal_producto());
            sentencia.setInt(7, Detalle.getProductos_idproductos());
            sentencia.setInt(8, Detalle.getMovimiento_idmovimiento());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en ActualizarDetalle\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public detalle_movimiento ConsultarDetalle(String iddetallemovimiento) {
        detalle_movimiento mi_detalle_movimiento = null;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "Select iddetallemovimiento, cantidad, precio, iva, subtotal, total_producto, productos_idproductos, movimiento_idmovimiento from detalle_movimiento where iddetallemovimiento = " + iddetallemovimiento;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_detalle_movimiento = new detalle_movimiento();
                mi_detalle_movimiento.setIddetallemovimiento(rs.getInt(1));
                mi_detalle_movimiento.setCantidad(rs.getInt(2));
                mi_detalle_movimiento.setPrecio(rs.getFloat(3));
                mi_detalle_movimiento.setIva(rs.getFloat(4));     
                mi_detalle_movimiento.setSubtotal(rs.getFloat(5)); 
                mi_detalle_movimiento.setTotal_producto(rs.getFloat(6));
                mi_detalle_movimiento.setProductos_idproductos(rs.getInt(7));     
                mi_detalle_movimiento.setMovimiento_idmovimiento(rs.getInt(8));     

            }

            return mi_detalle_movimiento;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarDetalle\n " + ex.getMessage());
        }
        return mi_detalle_movimiento;
    }

    public ArrayList<detalle_movimiento> ListadoDetalle(String iddetallemovimiento, String descripcion) {

        ArrayList<detalle_movimiento> mi_lista_detalle_movimiento = new ArrayList<detalle_movimiento>();
        detalle_movimiento mi_detalle_movimiento;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro" + iddetallemovimiento);

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "select iddetallemovimiento,cantidad,precio,iva,subtotal,total_producto,productos_idproductos,movimiento_idmovimiento "
                    + " from detalle_movimiento"
                    + " where iddetallemovimiento like '%" + iddetallemovimiento + "%'"
                    + " ORDER BY iddetallemovimiento;";
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {

                mi_detalle_movimiento = new detalle_movimiento();
                mi_detalle_movimiento.setIddetallemovimiento(rs.getInt(1));
                mi_detalle_movimiento.setCantidad(rs.getInt(2));
                mi_detalle_movimiento.setPrecio(rs.getFloat(3));
                mi_detalle_movimiento.setIva(rs.getFloat(4));     
                mi_detalle_movimiento.setSubtotal(rs.getFloat(5)); 
                mi_detalle_movimiento.setTotal_producto(rs.getFloat(6));
                mi_detalle_movimiento.setProductos_idproductos(rs.getInt(7));     
                mi_detalle_movimiento.setMovimiento_idmovimiento(rs.getInt(8)); 

                mi_lista_detalle_movimiento.add(mi_detalle_movimiento);

            }

            return mi_lista_detalle_movimiento;

        } catch (Exception ex) {

            System.out.println("Error en el ListadoDetalle" + "\n" + ex.getMessage());
            return mi_lista_detalle_movimiento;

        }

    }

    public String EliminarDetalle(detalle_movimiento Detalle) {

        String miRespuesta;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;

        try {

            String Query = "delete from detalle_movimiento where iddetallemovimiento = ?  ";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, Detalle.getIddetallemovimiento());
            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();
            System.err.println("Ocurrio un error en EliminarInventario" + ex.getMessage());
        }
        return miRespuesta;

    }

}
