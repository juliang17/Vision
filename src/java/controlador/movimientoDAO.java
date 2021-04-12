package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.movimiento;

public class movimientoDAO {

    public String adicionarmovimiento(movimiento MOVIMIENTO) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "insert movimiento (fechamovimiento,subtotal,iva,descuento,total,tipo_doc_contable_idtipodoccontable,medio_de_pago_idmediodepago)"
                    + "values (?,?,?,?,?,?,?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, MOVIMIENTO.getFechamovimiento());
            sentencia.setInt(2, MOVIMIENTO.getSubtotal());
            sentencia.setInt(3, MOVIMIENTO.getIva());
            sentencia.setInt(4, MOVIMIENTO.getDescuento());
            sentencia.setInt(5, MOVIMIENTO.getTotal());
            sentencia.setInt(6, MOVIMIENTO.getTipo_doc_contable_idtipodoccontable());
            sentencia.setInt(7, MOVIMIENTO.getMedio_de_pago_idmediodepago());
            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionar movimiento_movimientoDAO/n" + ex.getMessage());
        }
        return mirespuesta;

    }

    public String Actualizarmovimiento(movimiento MOVIMIENTO) {

        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update movimiento set idmovimiento=?,fechamovimiento=?, subtotal=?, iva=?, descuento=?,total=?,tipo_doc_contable_idtipodoccontable=?,medio_de_pago_idmediodepago=? where idmovimiento=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, MOVIMIENTO.getIdmovimiento());
            sentencia.setString(2, MOVIMIENTO.getFechamovimiento());
            sentencia.setInt(3, MOVIMIENTO.getSubtotal());
            sentencia.setInt(4, MOVIMIENTO.getIva());
            sentencia.setInt(5, MOVIMIENTO.getDescuento());
            sentencia.setInt(6, MOVIMIENTO.getTotal());
            sentencia.setInt(7, MOVIMIENTO.getTipo_doc_contable_idtipodoccontable());
            sentencia.setInt(8, MOVIMIENTO.getMedio_de_pago_idmediodepago());

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el Actualizar movimiento_movimientoDAO \n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public movimiento Consultarmovimiento(String fechamovimiento) {
        movimiento mimovimiento = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idmovimiento, fechamovimiento, subtotal, iva, descuento,total,tipo_doc_contable_idtipodoccontable,medio_de_pago_idmediodepago  from movimiento where fechamovimiento = " + fechamovimiento);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                mimovimiento = new movimiento();
                mimovimiento.setIdmovimiento(rs.getInt(1));
                mimovimiento.setFechamovimiento(rs.getString(2));
                mimovimiento.setSubtotal(rs.getInt(3));
                mimovimiento.setIva(rs.getInt(4));
                mimovimiento.setDescuento(rs.getInt(5));
                mimovimiento.setTotal(rs.getInt(6));
                mimovimiento.setTipo_doc_contable_idtipodoccontable(rs.getInt(7));
                mimovimiento.setMedio_de_pago_idmediodepago(rs.getInt(8));
            }
            return mimovimiento;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mimovimiento;
    }

    public ArrayList<movimiento> Consultarlistadomovimiento(String Fechamovimiento) {
        ArrayList<movimiento> milistamovimiento = new ArrayList<movimiento>();
        movimiento mimovimiento;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + Fechamovimiento);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idmovimiento, fechamovimiento, subtotal, iva, descuento,total,tipo_doc_contable_idtipodoccontable,medio_de_pago_idmediodepago"
                    + " from movimiento"
                    + " where Fechamovimiento like '%" + Fechamovimiento + "%' "
                    + "ORDER BY Fechamovimiento; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mimovimiento = new movimiento();
                mimovimiento.setIdmovimiento(rs.getInt(1));
                mimovimiento.setFechamovimiento(rs.getString(2));
                mimovimiento.setSubtotal(rs.getInt(3));
                mimovimiento.setIva(rs.getInt(4));
                mimovimiento.setDescuento(rs.getInt(5));
                mimovimiento.setTotal(rs.getInt(6));
                mimovimiento.setTipo_doc_contable_idtipodoccontable(rs.getInt(7));
                mimovimiento.setMedio_de_pago_idmediodepago(rs.getInt(8));
                milistamovimiento.add(mimovimiento);

            }
            return milistamovimiento;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en la consulta de listado en el movimiento" + ex.getMessage());
        }
        return milistamovimiento;
    }

    public String Eliminarmovimiento(movimiento MOVIMIENTO) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from movimiento where idmovimiento = ?;";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, MOVIMIENTO.getIdmovimiento());
            sentencia.execute();
            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en movimientoDAO.Eliminarmovimiento" + ex.getMessage());
        }
        return mirespuesta;
    }

}
