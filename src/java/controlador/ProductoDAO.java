
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.productos;

public class ProductoDAO {
    
    public String adicionarproductos(productos PRODUCTOS) {

        String mirespuesta;
        controlador.Conexion miconexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "insert productos (nombreproducto, cantidadproducto, ivaproducto, descripcionproducto, precio, categorias_idcategorias, marca_idmarca, unidad_de_medida_idunidadmedida, proveedores_idproveedores)"
                    + "values (?,?,?,?,?,?,?,?,?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, PRODUCTOS.getNombreproducto());
            sentencia.setInt(2, PRODUCTOS.getCantidadproducto());
            sentencia.setInt(3, PRODUCTOS.getIvaproducto());
            sentencia.setString(4, PRODUCTOS.getDescripcionproducto());
            sentencia.setInt(5, PRODUCTOS.getPrecio());
            sentencia.setInt(6, PRODUCTOS.getCategorias_idcategorias());
            sentencia.setInt(7, PRODUCTOS.getMarca_idmarca());
            sentencia.setInt(8, PRODUCTOS.getUnidad_de_medida_idunidadmedida());
            sentencia.setInt(9, PRODUCTOS.getProveedores_idproveedores());

            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionarproductos/n" + ex.getMessage());
        }
        return mirespuesta;

    }

    public String Actualizarproductos(productos PRODUCTOS) {

        String mirespuesta = "";
        controlador.Conexion miconexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update productos set idproductos=?, nombreproducto=?, cantidadproducto=?, ivaproducto=?, descripcionproducto=?, precio=?, Categorias_idcategorias=?, Marca_idmarca=?, Unidad_de_medida_idunidadmedida=?, Proveedores_idproveedores=?, where idproductos=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, PRODUCTOS.getIdproductos());
            sentencia.setString(2, PRODUCTOS.getNombreproducto());
            sentencia.setInt(3, PRODUCTOS.getCantidadproducto());
            sentencia.setInt(4, PRODUCTOS.getIvaproducto());
            sentencia.setString(5, PRODUCTOS.getDescripcionproducto());
            sentencia.setInt(6, PRODUCTOS.getPrecio());
            sentencia.setInt(7, PRODUCTOS.getCategorias_idcategorias());
            sentencia.setInt(8, PRODUCTOS.getMarca_idmarca());
            sentencia.setInt(9, PRODUCTOS.getUnidad_de_medida_idunidadmedida());
            sentencia.setInt(10, PRODUCTOS.getProveedores_idproveedores());
            sentencia.setInt(11, PRODUCTOS.getIdproductos());

            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el  Actualizarproductos\n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public productos Consultaproductos(String nombreproducto) {
        productos miproductos = null;

        controlador.Conexion miconexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idproductos, nombreproducto, cantidadproducto, ivaproducto, descripcionproducto, precio, Categorias_idcategorias, Marca_idmarca, Unidad_de_medida_idunidadmedida, Proveedores_idproveedores from productos where idproductos = " + nombreproducto);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                miproductos = new productos();
                miproductos.setIdproductos(rs.getInt(1));
                miproductos.setNombreproducto(rs.getString(2));
                miproductos.setCantidadproducto(rs.getInt(3));
                miproductos.setIvaproducto(rs.getInt(4));
                miproductos.setDescripcionproducto(rs.getString(5));
                miproductos.setPrecio(rs.getInt(6));
                miproductos.setCategorias_idcategorias(rs.getInt(7));
                miproductos.setMarca_idmarca(rs.getInt(8));
                miproductos.setUnidad_de_medida_idunidadmedida(rs.getInt(9));
                miproductos.setProveedores_idproveedores(rs.getInt(10));

            }
            return miproductos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return miproductos;
    }

    public ArrayList<productos> listadoproductos(int idproductos) {
        ArrayList<productos> milistaproductos = new ArrayList<productos>();
        productos miproductos;

        controlador.Conexion miconexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        System.out.println("Buscando parametro: " + idproductos);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idproductos, nombreproducto, cantidadproducto, ivaproducto, descripcionproducto, precio, Categorias_idcategorias, Marca_idmarca, Unidad_de_medida_idunidadmedida, Proveedores_idproveedores "
                    + " from productos"
                    + " where idproducto like '%" + idproductos + "%' "
                    + " or (idproducto) like ('%" + idproductos + "%') ORDER BY idproductos; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                miproductos = new productos();
                miproductos.setIdproductos(rs.getInt(1));
                miproductos.setNombreproducto(rs.getString(2));
                miproductos.setCantidadproducto(rs.getInt(3));
                miproductos.setIvaproducto(rs.getInt(4));
                miproductos.setDescripcionproducto(rs.getString(5));
                miproductos.setPrecio(rs.getInt(6));
                miproductos.setCategorias_idcategorias(rs.getInt(7));
                miproductos.setMarca_idmarca(rs.getInt(8));
                miproductos.setUnidad_de_medida_idunidadmedida(rs.getInt(9));
                miproductos.setProveedores_idproveedores(rs.getInt(10));
                milistaproductos.add(miproductos);

            }
            return milistaproductos;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en listadoproductos" + ex.getMessage());
        }
        return milistaproductos;
    }

    public String Eliminarproductos(productos PRODUCTOS) {
        String mirespuesta;
        controlador.Conexion miconexion = new controlador.Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from productos where idproductos = ? and nombreproducto = ?;";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, PRODUCTOS.getIdproductos());
            sentencia.setString(2, PRODUCTOS.getNombreproducto());

            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en Eliminarproductos" + ex.getMessage());
        }
        return mirespuesta;
    }


}
