package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.genero;

public class GeneroDAO {

    public String Adicionargenero (genero Genero) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "Insert into genero (descripciongenero)" + "values (?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Genero.getDescripciongenero());

            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Adicionargenero\n " + ex.getMessage());
        }
        return miRespuesta;
    }
    
    public String Atualizargenero (genero Genero) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update genero set idgenero=?, descripciongenero=? where idgenero=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Genero.getIdgenero());
            sentencia.setString(2, Genero.getDescripciongenero());
            sentencia.setString(3, Genero.getIdgenero());

            sentencia.executeUpdate();
            miRespuesta = "";
            
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Atualizargenero\n " + ex.getMessage());
        }
        return miRespuesta;
    }


    public genero Consultargenero (String idgenero) {
    genero mi_genero = null;
    
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {
            
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = "Select idgenero, descripciongenero from genero where idgenero = " + idgenero;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()){
            
                mi_genero = new genero();
                mi_genero.setIdgenero(rs.getString(1));
                mi_genero.setDescripciongenero(rs.getString(2));
                
            }
            
         return mi_genero;            
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en Consultargenero\n " + ex.getMessage());
        }
        return mi_genero;
    }
     
    public ArrayList<genero> Listadogenero(String idgenero, String descripciongenero) {
        ArrayList<genero>mi_listado_genero = new ArrayList<genero>();
        genero mi_genero;
        
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        System.out.println("Buscando parametro: " + idgenero);
        try{
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = " select idgenero,descripciongenero "
                    + " from genero "
                    + " where idgenero like '%" + idgenero + "%' "
                    + "  or (descripciongenero) like ('%" + descripciongenero + "%') ORDER BY idgenero;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                mi_genero = new genero();
                mi_genero.setIdgenero(rs.getString(1));
                mi_genero.setDescripciongenero(rs.getString(2));
                mi_listado_genero.add(mi_genero);
            }
            return mi_listado_genero;
        }catch (Exception ex) {
            System.out.println("Ha ocurrido un error en Listadogenero\n " + ex.getMessage());
        }
        return mi_listado_genero;
    }
 
    public String Eliminargenero(genero Genero) {
        
        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        PreparedStatement sentencia;
        try{
            String Query = " delete from genero where idgenero = ? and descripciongenero = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            
            sentencia.setString(1, Genero.getIdgenero());
            sentencia.setString(2, Genero.getDescripciongenero());
            sentencia.execute();
            miRespuesta = "";
        }catch(Exception ex){
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Eliminargenero\n " + ex.getMessage());
        }
        return miRespuesta;
    }
}
