
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.proveedores;

public class ProveedoresDAO {
    
    public String AdicionarProveedor(proveedores Proveedor) {

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "Insert into proveedores (nombreproveedores, identificacionproveedores, correoproveedores, telefonoproveedores)" + "values (?,?,?,?);";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Proveedor.getNombreproveedores());
            sentencia.setString(2, Proveedor.getIdentificacionproveedores());
            sentencia.setString(3, Proveedor.getCorreoproveedores());
            sentencia.setInt(4, Proveedor.getTelefonoproveedores());

            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en AdicionarProveedor\n " + ex.getMessage());
        }
        return miRespuesta;
    }
    
     public String ActualizarProveedor (proveedores Proveedor) { 

        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "update proveedores set nombreproveedores=?, identificacionproveedores=?, correoproveedores=?, telefonoproveedores=? where identificacionproveedores=?";
            sentencia = nuevaCon.prepareStatement(Query);

            sentencia.setString(1, Proveedor.getNombreproveedores());
            sentencia.setString(2, Proveedor.getIdentificacionproveedores());
            sentencia.setString(3, Proveedor.getCorreoproveedores());
            sentencia.setInt(4, Proveedor.getTelefonoproveedores());
            sentencia.setString(5, Proveedor.getIdentificacionproveedores());

            sentencia.executeUpdate();
            miRespuesta = "";
            
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en AtualizarUsuario\n " + ex.getMessage());
        }
        return miRespuesta;
    }
     
     public proveedores ConsultarProveedor(String identificacionproveedores) {
        proveedores mi_proveedor = null;
    
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        try {
            
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = "Select idProveedores, nombreproveedores, identificacionproveedores, correoproveedores, telefonoproveedores from proveedores where identificacionproveedores = " + identificacionproveedores;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()){
            
                mi_proveedor = new proveedores();
                mi_proveedor.setIdProveedores(rs.getInt(1));
                mi_proveedor.setNombreproveedores(rs.getString(2));
                mi_proveedor.setIdentificacionproveedores(rs.getString(3));
                mi_proveedor.setCorreoproveedores(rs.getString(4));
                mi_proveedor.setTelefonoproveedores(rs.getInt(5));
                
            }
   
         return mi_proveedor;            
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ConsultarProveedor\n " + ex.getMessage());
        }
        return mi_proveedor;
    }
     
     public ArrayList<proveedores> ListarProveedor(String nombreproveedores, String identificacionproveedores, String correoproveedores) {
       ArrayList<proveedores>mi_listado_provedores = new ArrayList<proveedores>();
        proveedores mi_proveedor;
        
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        System.out.println("Buscando parametro: " + identificacionproveedores);
        try{
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = " select idProveedores,nombreproveedores,identificacionproveedores,correoproveedores,telefonoproveedores "
                    + " from proveedores "
                    + " where nombreproveedores like '%" + nombreproveedores + "%' "
                    + "  or (identificacionproveedores) like ('%" + identificacionproveedores + "%') "
                    + "  or (correoproveedores) like ('%" + correoproveedores + "%') ORDER BY identificacionproveedores;";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                mi_proveedor = new proveedores();
                mi_proveedor.setIdProveedores(rs.getInt(1));
                mi_proveedor.setNombreproveedores(rs.getString(2));
                mi_proveedor.setIdentificacionproveedores(rs.getString(3));
                mi_proveedor.setCorreoproveedores(rs.getString(4));
                mi_proveedor.setTelefonoproveedores(rs.getInt(5));
                mi_listado_provedores.add(mi_proveedor);
            }
            return mi_listado_provedores;
        }catch (Exception ex) {
            System.out.println("Ha ocurrido un error en ListarProveedor\n " + ex.getMessage());
        }
        return mi_listado_provedores;
    }
     
    public String EliminarProveedor(proveedores Proveedor) {
        
        String miRespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();
        
        PreparedStatement sentencia;
        try{
            String Query = " delete from proveedores where idProveedores = ? and identificacionproveedores = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            
            sentencia.setInt(1, Proveedor.getIdProveedores());
            sentencia.setString(2, Proveedor.getIdentificacionproveedores());
            sentencia.execute();
            miRespuesta = "";
        }catch(Exception ex){
            miRespuesta = ex.getMessage();
            System.out.println("Ha ocurrido un error en EliminarProveedor\n " + ex.getMessage());
        }
        return miRespuesta;
    }
    
}
