package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.estado_producto;

public class estado_productoDAO {
    
    public String adicionarEstadoProducto(estado_producto estadoP){
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        
        try {
            String Query = "insert into estado_producto(descripcionEstadoProducto) value(?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, estadoP.getDescripcionEstadoProducto());
            sentencia.execute();
            mirespuesta = "";  
        } catch(SQLException e){
            mirespuesta = e.getMessage();
            System.out.println("Ocurrio un error en adicionar estado_producto_estado_productoDAO/n" + e.getMessage());
        }
        return mirespuesta;
    }
    public String actualizarEstadoProducto(estado_producto estadoP){
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        PreparedStatement sentencia;
        
        try{
            String Query = "update estado_producto set descripcionEstadoProducto=? where idestado_producto=? ";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, estadoP.getDescripcionEstadoProducto());
            sentencia.setString(2, estadoP.getIdestado_producto());
            sentencia.execute();
            mirespuesta = "";
        } catch(SQLException e){
            mirespuesta = e.getMessage();
             System.err.println("Ocurrio un error en actualizar estado producto/n" + e.getMessage());
        }
        return mirespuesta;
    }
    public estado_producto ConsultarEstadoProducto(String idestado_producto){
        estado_producto miestadoproducto = null;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idestado_producto , descripcionEstadoProducto from estado_producto where idestado_producto=" + idestado_producto);
            ResultSet rs = sentencia.executeQuery(Query);
            while(rs.next()){
                miestadoproducto = new estado_producto();
                miestadoproducto.setIdestado_producto(rs.getString(1));
                miestadoproducto.setDescripcionEstadoProducto(rs.getString(2));
            }
            return miestadoproducto;
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return miestadoproducto;
    }
    public ArrayList<estado_producto> ConsultarListadoEstadoProducto(String idestado_producto , String descripcionEstadoProducto){
        ArrayList<estado_producto> milistaestadoP = new ArrayList<estado_producto>();
        estado_producto estadoP;
        
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idestado_producto , descripcionEstadoProducto " 
                    + " from estado_producto " 
                    + " where idestado_producto like '%" + idestado_producto + "%' " 
                    + "  or (descripcionEstadoProducto) like ('%" + descripcionEstadoProducto + "%') ORDER BY idestado_producto;";
            ResultSet rs = sentencia.executeQuery(Query);
            while(rs.next()){
                estadoP = new estado_producto();
                estadoP.setIdestado_producto(rs.getString(1));
                estadoP.setDescripcionEstadoProducto(rs.getString(2));
                milistaestadoP.add(estadoP);
            }
            return milistaestadoP;
    } catch(Exception e){
           System.err.println("Ocurrio un error en la consulta de listado en el estado producto" + e.getMessage());
    }
        return milistaestadoP;
    }
    public String EliminarEstadoProducto(estado_producto estadoP){
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try{
            String Query = "delete from estado_producto where idestado_producto= ? and descripcionEstadoProducto = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, estadoP.getIdestado_producto());
            sentencia.setString(2, estadoP.getDescripcionEstadoProducto());
            sentencia.execute();
            mirespuesta = "";
        } catch(SQLException e){
            mirespuesta = e.getMessage();
            System.out.println("Ocurrio un error en estado_productoDAO.Eliminarestado_producto" + e.getMessage());
        }
        return mirespuesta;
    }
}
