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
            String Query = "Insert into movimiento (fechamovimiento, subtotal, iva, descuento, total, tipo_doc_contable_idtipodoccontable, medio_de_pago_idmediodepago)" + "values (?,?,?,?,?,?,?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Movimiento.getFechamovimiento());
            sentencia.setInt(2, Movimiento.getSubtotal());
            sentencia.setInt(3, Movimiento.getIva());
            sentencia.setInt(4, Movimiento.getDescuento());
            sentencia.setInt(5, Movimiento.getTotal());
            sentencia.setInt(6, Movimiento.getTipo_doc_contable_idtipodoccontable());
            sentencia.setInt(7, Movimiento.getMedio_de_pago_idmediodepago());

            
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
            String Query = "update movimiento set idmovimiento=?, fechamovimiento=?, subtotal=?, iva=?, descuento=?, total=?, tipo_doc_contable_idtipodoccontable=?, medio_de_pago_idmediodepago=? where idmovimiento=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Movimiento.getIdmovimiento());
            sentencia.setString(2, Movimiento.getFechamovimiento());
            sentencia.setInt(3, Movimiento.getSubtotal());
            sentencia.setInt(4, Movimiento.getIva());
            sentencia.setInt(5, Movimiento.getDescuento());
            sentencia.setInt(6, Movimiento.getTotal());
            sentencia.setInt(7, Movimiento.getTipo_doc_contable_idtipodoccontable());
            sentencia.setInt(8, Movimiento.getMedio_de_pago_idmediodepago());

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

            String Query = "Select idmovimiento, fechamovimiento, subtotal, iva, descuento, total, tipo_doc_contable_idtipodoccontable, medio_de_pago_idmediodepago from movimiento where idmovimiento = " + idmovimiento;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {

                mi_movimiento = new movimiento();
                mi_movimiento.setIdmovimiento(rs.getString(1));
                mi_movimiento.setFechamovimiento(rs.getString(2));
                mi_movimiento.setSubtotal(rs.getInt(3));
                mi_movimiento.setIva(rs.getInt(4));
                mi_movimiento.setDescuento(rs.getInt(5));
                mi_movimiento.setTotal(rs.getInt(6));
                mi_movimiento.setTipo_doc_contable_idtipodoccontable(rs.getInt(7));
                mi_movimiento.setMedio_de_pago_idmediodepago(rs.getInt(8));
            }

            return mi_movimiento;
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarMovimiento\n " + ex.getMessage());
        }
        return mi_movimiento;
    }

    public ArrayList<movimiento> ListadoMovimiento(String idmovimiento, String fechamovimiento) {

        ArrayList<movimiento> mi_lista_movimiento = new ArrayList<movimiento>();
        movimiento mi_movimiento;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro" + idmovimiento);

        try {

            Statement sentencia = nuevaCon.createStatement();

            String Query = "select idmovimiento,fechamovimiento,subtotal,iva, descuento,total,tipo_doc_contable_idtipodoccontable,medio_de_pago_idmediodepago "
                    + " from movimiento"
                    + " where idmovimiento like '%" + idmovimiento + "%'"
                    + "  or (fechamovimiento) like ('%" + fechamovimiento + "%') ORDER BY idmovimiento;";
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {

                mi_movimiento = new movimiento();
                mi_movimiento.setIdmovimiento(rs.getString(1));
                mi_movimiento.setFechamovimiento(rs.getString(2));
                mi_movimiento.setSubtotal(rs.getInt(3));
                mi_movimiento.setIva(rs.getInt(4));
                mi_movimiento.setDescuento(rs.getInt(5));
                mi_movimiento.setTotal(rs.getInt(6));
                mi_movimiento.setTipo_doc_contable_idtipodoccontable(rs.getInt(7));
                mi_movimiento.setMedio_de_pago_idmediodepago(rs.getInt(8));

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
