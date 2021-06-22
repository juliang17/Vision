package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.tipo_documento;

public class tipo_documentoDAO {

    public String Adicionartipo_documento (tipo_documento Tipo_documento) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "Insert into tipo_documento (descripciontipodoc)" + "values (?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Tipo_documento.getDescripciontipodoc());

            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Adicionartipo_documento\n " + ex.getMessage());
        }
        return miRespuesta;
    }
    
    public String Atualizartipo_documento (tipo_documento Tipo_documento) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update tipo_documento set idtipodoc=?, descripciontipodoc=? where idtipodoc=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Tipo_documento.getIdtipodoc());
            sentencia.setString(2, Tipo_documento.getDescripciontipodoc());
            sentencia.setString(3, Tipo_documento.getIdtipodoc());

            sentencia.executeUpdate();
            miRespuesta = "";
            
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Atualizartipo_documento\n " + ex.getMessage());
        }
        return miRespuesta;
    }


    public tipo_documento Consultartipo_documento (String idtipodoc) {
    tipo_documento mi_tipo_documento = null;
    
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {
            
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = "Select idtipodoc, descripciontipodoc from tipo_documento where idtipodoc = " + idtipodoc;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()){
            
                mi_tipo_documento = new tipo_documento();
                mi_tipo_documento.setIdtipodoc(rs.getString(1));
                mi_tipo_documento.setDescripciontipodoc(rs.getString(2));
                
            }
            
         return mi_tipo_documento;            
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en Consultartipo_documento\n " + ex.getMessage());
        }
        return mi_tipo_documento;
    }
     
    public ArrayList<tipo_documento> Listadotipo_documento(String idtipodoc, String descripciontipodoc) {
        ArrayList<tipo_documento>mi_listado_tipo_documento = new ArrayList<tipo_documento>();
        tipo_documento mi_tipo_documento;
        
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        System.out.println("Buscando parametro: " + idtipodoc);
        try{
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = " select idtipodoc,descripciontipodoc "
                    + " from tipo_documento "
                    + " where idtipodoc like '%" + idtipodoc + "%' "
                    + "  or (descripciontipodoc) like ('%" + descripciontipodoc + "%') ORDER BY idtipodoc;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                mi_tipo_documento = new tipo_documento();
                mi_tipo_documento.setIdtipodoc(rs.getString(1));
                mi_tipo_documento.setDescripciontipodoc(rs.getString(2));
                mi_listado_tipo_documento.add(mi_tipo_documento);
            }
            return mi_listado_tipo_documento;
        }catch (Exception ex) {
            System.out.println("Ha ocurrido un error en Listadotipo_documento\n " + ex.getMessage());
        }
        return mi_listado_tipo_documento;
    }
 
    public String Eliminartipo_documento(tipo_documento Tipo_documento) {
        
        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        PreparedStatement sentencia;
        try{
            String Query = " delete from tipo_documento where idtipodoc = ? and descripciontipodoc = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            
            sentencia.setString(1, Tipo_documento.getIdtipodoc());
            sentencia.setString(2, Tipo_documento.getDescripciontipodoc());
            sentencia.execute();
            miRespuesta = "";
        }catch(Exception ex){
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Eliminartipo_documento\n " + ex.getMessage());
        }
        return miRespuesta;
    }

}
