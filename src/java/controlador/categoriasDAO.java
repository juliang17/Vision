package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.categorias;

public class categoriasDAO {

    public String Adicionarcategorias (categorias Categorias) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "Insert into categorias (descripcioncategorias)" + "values (?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Categorias.getDescripcioncategorias());

            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Adicionarcategorias\n " + ex.getMessage());
        }
        return miRespuesta;
    }
    
    public String Atualizarcategorias (categorias Categorias) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update categorias set idcategorias=?, descripcioncategorias=? where idcategorias=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Categorias.getIdcategorias());
            sentencia.setString(2, Categorias.getDescripcioncategorias());
            sentencia.setString(3, Categorias.getIdcategorias());

            sentencia.executeUpdate();
            miRespuesta = "";
            
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Atualizarcategorias\n " + ex.getMessage());
        }
        return miRespuesta;
    }


    public categorias Consultarcategorias (String idcategorias) {
    categorias mi_categorias = null;
    
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {
            
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = "Select idcategorias, descripcioncategorias from categorias where idcategorias = " + idcategorias;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()){
            
                mi_categorias = new categorias();
                mi_categorias.setIdcategorias(rs.getString(1));
                mi_categorias.setDescripcioncategorias(rs.getString(2));
                
            }
            
         return mi_categorias;            
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en Consultarcategorias\n " + ex.getMessage());
        }
        return mi_categorias;
    }
     
    public ArrayList<categorias> Listadocategorias(String idcategorias, String descripcioncategorias) {
        ArrayList<categorias>mi_listado_categorias = new ArrayList<categorias>();
        categorias mi_categorias;
        
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        System.out.println("Buscando parametro: " + idcategorias);
        try{
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = " select idcategorias,descripcioncategorias "
                    + " from categorias "
                    + " where idcategorias like '%" + idcategorias + "%' "
                    + "  or (descripcioncategorias) like ('%" + descripcioncategorias + "%') ORDER BY idcategorias;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                mi_categorias = new categorias();
                mi_categorias.setIdcategorias(rs.getString(1));
                mi_categorias.setDescripcioncategorias(rs.getString(2));
                mi_listado_categorias.add(mi_categorias);
            }
            return mi_listado_categorias;
        }catch (Exception ex) {
            System.out.println("Ha ocurrido un error en Listadocategorias\n " + ex.getMessage());
        }
        return mi_listado_categorias;
    }
 
    public String Eliminarcategorias(categorias Categorias) {
        
        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        PreparedStatement sentencia;
        try{
            String Query = " delete from categorias where idcategorias = ? and descripcioncategorias = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            
            sentencia.setString(1, Categorias.getIdcategorias());
            sentencia.setString(2, Categorias.getDescripcioncategorias());
            sentencia.execute();
            miRespuesta = "";
        }catch(Exception ex){
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en Eliminarcategorias\n " + ex.getMessage());
        }
        return miRespuesta;
    }
}
