package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.tipo_movimiento;

public class TipoMovimientoDAO {
    
    public String adicionarTipoMovimiento(tipo_movimiento TIPOMOV) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "insert tipo_movimiento (descripciontipomov)" + "values (?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, TIPOMOV.getDescripciontipomov());
            sentencia.execute();
            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionar tipo_movimiento_TipoMovimientoDAO/n" + ex.getMessage());
        }
        return mirespuesta;
    }
    
    public String actualizarTipoMovimiento(tipo_movimiento TIPOMOV) {
        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update tipo_movimiento set descripciontipomov=? where idtipomov=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, TIPOMOV.getDescripciontipomov());
            sentencia.setInt(2, TIPOMOV.getIdtipomov());
            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.err.println("Ocurrio un error en actualizar tipo_movimiento_TipoMovimientoDAO/n" + ex.getMessage());

        }
        return mirespuesta;
    }
    
    public tipo_movimiento Consultartipomovimiento(int idtipomov) {

        tipo_movimiento mitipomov = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idtipomov, descripciontipomov from tipo_movimiento where idtipomov = " + idtipomov);
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mitipomov = new tipo_movimiento();
                mitipomov.setIdtipomov(rs.getInt(1));
                mitipomov.setDescripciontipomov(rs.getString(2));
            }
            return mitipomov;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mitipomov;
    }
    
     public ArrayList<tipo_movimiento> Consultarlistadotipomovimiento(String TIPOMOV) {
        ArrayList<tipo_movimiento> milistatipomov = new ArrayList<tipo_movimiento>();
        tipo_movimiento mitipomov;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idtipomov, descripciontipomov " + " from tipo_movimiento "
                    + " where idtipomov like '%" + TIPOMOV + "%' ORDER BY idtipomov; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mitipomov = new tipo_movimiento();
                mitipomov.setIdtipomov(rs.getInt(1));
                mitipomov.setDescripciontipomov(rs.getString(2));
                milistatipomov.add(mitipomov);
            }
            return milistatipomov;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en la consulta de listado en el tipo movimiento" + ex.getMessage());
        }
        return milistatipomov;
    }
     
     public String Eliminartipomovimiento(tipo_movimiento TIPOMOV) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from tipo_movimiento where idtipomov = ? and descripciontipomov = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, TIPOMOV.getIdtipomov());
            sentencia.setString(2, TIPOMOV.getDescripciontipomov());
            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en TipoMovimientoDAO.Eliminartipomovimiento" + ex.getMessage());
        }
        return mirespuesta;

    }

}
