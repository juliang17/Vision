package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.movimiento;

public class movimientoDAO {

    public String AdicionarMovimiento(movimiento Movimiento) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "Insert into movimiento (numero_documento, fechamovimiento, subtotal, iva, estadoMov, total, usuarios_idusuarios , medio_de_pago_idmediodepago, tipo_mov_id_tipo_mov)" + "values (?,?,?,?,?,?,?,?,?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Movimiento.getNumero_documento());
            sentencia.setString(2, Movimiento.getFechamovimiento());
            sentencia.setDouble(3, Movimiento.getSubtotal());
            sentencia.setDouble(4, Movimiento.getIva());
            sentencia.setInt(5, Movimiento.getEstadoMov());
            sentencia.setDouble(6, Movimiento.getTotal());
            sentencia.setInt(7, Movimiento.getUsuarios_idusuarios());
            sentencia.setInt(8, Movimiento.getMedio_de_pago_idmediodepago());
            sentencia.setInt(9, Movimiento.getTipo_mov_id_tipo_mov());

            
            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en AdicionarMovimiento\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public String ActualizarMovimiento(movimiento Movimiento) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update movimiento set idmovimiento=?, numero_documento=?, fechamovimiento=?, subtotal=?, iva=?, estadoMov=?, total=?, usuarios_idusuarios=? , medio_de_pago_idmediodepago=?, tipo_mov_id_tipo_mov=? where idmovimiento=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Movimiento.getIdmovimiento());
            sentencia.setString(2, Movimiento.getNumero_documento());
            sentencia.setString(3, Movimiento.getFechamovimiento());
            sentencia.setDouble(4, Movimiento.getSubtotal());
            sentencia.setDouble(5, Movimiento.getIva());
            sentencia.setInt(6, Movimiento.getEstadoMov());
            sentencia.setDouble(7, Movimiento.getTotal());
            sentencia.setInt(8, Movimiento.getUsuarios_idusuarios());
            sentencia.setInt(9, Movimiento.getMedio_de_pago_idmediodepago());
            sentencia.setInt(10, Movimiento.getTipo_mov_id_tipo_mov());

            sentencia.executeUpdate();
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en ActualizarMovimiento\n " + ex.getMessage());
        }
        return miRespuesta;
    }

    public movimiento ConsultarMovimiento(String idmovimiento) {
        movimiento mi_movimiento = null;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "Select idmovimiento, numero_documento, fechamovimiento, subtotal, iva, estadoMov, total, usuarios_idusuarios , medio_de_pago_idmediodepago, tipo_mov_id_tipo_mov from movimiento where idmovimiento = " + idmovimiento;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_movimiento = new movimiento();
                mi_movimiento.setIdmovimiento(rs.getString(1));
                mi_movimiento.setNumero_documento(rs.getString(2));
                mi_movimiento.setFechamovimiento(rs.getString(3));
                mi_movimiento.setSubtotal(rs.getDouble(4));
                mi_movimiento.setIva(rs.getDouble(5));
                mi_movimiento.setEstadoMov(rs.getInt(6));
                mi_movimiento.setTotal(rs.getDouble(7));
                mi_movimiento.setUsuarios_idusuarios(rs.getInt(8));
                mi_movimiento.setMedio_de_pago_idmediodepago(rs.getInt(9));
                mi_movimiento.setTipo_mov_id_tipo_mov(rs.getInt(10));
            }

            return mi_movimiento;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarMovimiento\n " + ex.getMessage());
        }
        return mi_movimiento;
    }

    public ArrayList<movimiento> ListadoMovimiento(String idmovimiento, String numero_documento) {

        ArrayList<movimiento> mi_lista_movimiento = new ArrayList<movimiento>();
        movimiento mi_movimiento;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro" + idmovimiento);

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "select idmovimiento,numero_documento,fechamovimiento,subtotal,iva,estadoMov,total,usuarios_idusuarios,medio_de_pago_idmediodepago,tipo_mov_id_tipo_mov "
                    + " from movimiento"
                    + " where idmovimiento like '%" + idmovimiento + "%'"
                    + "  or (numero_documento) like ('%" + numero_documento + "%') ORDER BY idmovimiento;";
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {

                mi_movimiento = new movimiento();
                mi_movimiento.setIdmovimiento(rs.getString(1));
                mi_movimiento.setNumero_documento(rs.getString(2));
                mi_movimiento.setFechamovimiento(rs.getString(3));
                mi_movimiento.setSubtotal(rs.getDouble(4));
                mi_movimiento.setIva(rs.getDouble(5));
                mi_movimiento.setEstadoMov(rs.getInt(6));
                mi_movimiento.setTotal(rs.getDouble(7));
                mi_movimiento.setUsuarios_idusuarios(rs.getInt(rs.getInt(8)));
                mi_movimiento.setMedio_de_pago_idmediodepago(rs.getInt(9));
                mi_movimiento.setTipo_mov_id_tipo_mov(rs.getInt(10));

                mi_lista_movimiento.add(mi_movimiento);

            }

            return mi_lista_movimiento;

        } catch (Exception ex) {

            System.out.println("Error en el ListadoMovimiento" + "\n" + ex.getMessage());
            return mi_lista_movimiento;

        }

    }

    public String EliminarMovimiento(movimiento Movimiento) {

        String miRespuesta;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;

        try {

            String Query = "delete from movimiento where idmovimiento = ?  ";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, Movimiento.getIdmovimiento());
            sentencia.execute();
            miRespuesta = "";

        } catch (Exception ex) {

            miRespuesta = ex.getMessage();
            System.err.println("Ocurrio un error en EliminarMovimiento" + ex.getMessage());
        }
        return miRespuesta;

    }
    
}
