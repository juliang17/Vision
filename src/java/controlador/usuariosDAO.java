package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.usuarios;

public class usuariosDAO {

    public String adicionarusuarios(usuarios USUARIOS) {

        String mirespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "insert usuarios (numerodocusuario,nombreusuarios,apellidousuarios,correousuarios,telefonousuarios,direccionusuario,claveusuario,tipo_documento_idtipodoc,roles_idroles,genero_idgenero,estado_usuario_idestadousuario)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, USUARIOS.getNumerodocusuario());
            sentencia.setString(2, USUARIOS.getNombreusuarios());
            sentencia.setString(3, USUARIOS.getApellidousuarios());
            sentencia.setString(4, USUARIOS.getCorreousuarios());
            sentencia.setString(5, USUARIOS.getTelefonousuarios());
            sentencia.setString(6, USUARIOS.getDireccionusuario());
            sentencia.setString(7, USUARIOS.getClaveusuario());
            sentencia.setInt(8, USUARIOS.getTipo_documento_idtipodoc());
            sentencia.setInt(9, USUARIOS.getRoles_idroles());
            sentencia.setInt(10, USUARIOS.getGenero_idgenero());
            sentencia.setInt(11, USUARIOS.getEstado_usuario_idestadousuario());
            sentencia.execute();
            mirespuesta = "";

        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en adicionar usuarios_usuariosDAO/n" + ex.getMessage());
        }
        return mirespuesta;

    }

    public String Actualizarusuario(usuarios USUARIOS) {

        String mirespuesta = "";
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;

        try {
            String Query = "update usuarios set numerodocusuario=?, nombreusuarios=?, apellidousuarios=?, correousuarios=?, telefonousuarios=?, direccionusuario=?, claveusuario=?, tipo_documento_idtipodoc=?, roles_idroles=?, genero_idgenero=?, estado_usuario_idestadousuario=? where numerodocusuario=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, USUARIOS.getNumerodocusuario());
            sentencia.setString(2, USUARIOS.getNombreusuarios());
            sentencia.setString(3, USUARIOS.getApellidousuarios());
            sentencia.setString(4, USUARIOS.getCorreousuarios());
            sentencia.setString(5, USUARIOS.getTelefonousuarios());
            sentencia.setString(6, USUARIOS.getDireccionusuario());
            sentencia.setString(7, USUARIOS.getClaveusuario());
            sentencia.setInt(8, USUARIOS.getTipo_documento_idtipodoc());
            sentencia.setInt(9, USUARIOS.getRoles_idroles());
            sentencia.setInt(10, USUARIOS.getGenero_idgenero());
            sentencia.setInt(11, USUARIOS.getEstado_usuario_idestadousuario());
            sentencia.setString(12, USUARIOS.getNumerodocusuario());
            sentencia.executeUpdate();

        } catch (Exception ex) {
            mirespuesta = "";
            mirespuesta = ex.getMessage();
            System.err.println("ocurrió un problema en el ActualizarUsuario_UsuarioDAO \n" + ex.getMessage());
        }
        return mirespuesta;
    }

    public usuarios Consultarusuarios(String numerodocusuario) {
        usuarios misusuarios = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = ("select idusuarios, numerodocusuario, nombreusuarios, apellidousuarios, correousuarios, telefonousuarios, direccionusuario, claveusuario, tipo_documento_idtipodoc, roles_idroles, genero_idgenero, estado_usuario_idestadousuario from usuarios where numerodocusuario = " + numerodocusuario);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                misusuarios = new usuarios();
                misusuarios.setIdusuarios(rs.getString(1));
                misusuarios.setNumerodocusuario(rs.getString(2));
                misusuarios.setNombreusuarios(rs.getString(3));
                misusuarios.setApellidousuarios(rs.getString(4));
                misusuarios.setCorreousuarios(rs.getString(5));
                misusuarios.setTelefonousuarios(rs.getString(6));
                misusuarios.setDireccionusuario(rs.getString(7));
                misusuarios.setClaveusuario(rs.getString(8));
                misusuarios.setTipo_documento_idtipodoc(rs.getInt(9));
                misusuarios.setRoles_idroles(rs.getInt(10));
                misusuarios.setGenero_idgenero(rs.getInt(11));
                misusuarios.setEstado_usuario_idestadousuario(rs.getInt(12));
            }
            return misusuarios;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return misusuarios;
    }

    public ArrayList<usuarios> Consultarlistadousuarios(String idusuarios ,String numerodocusuario) {
        ArrayList<usuarios> milistausuarios = new ArrayList<usuarios>();
        usuarios mitipousuario;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + numerodocusuario);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idusuarios, numerodocusuario, nombreusuarios, apellidousuarios, correousuarios, telefonousuarios, direccionusuario, claveusuario, tipo_documento_idtipodoc, roles_idroles, genero_idgenero, estado_usuario_idestadousuario"
                    + " from usuarios"
                    + " where idusuarios like '%" + idusuarios + "%' "
                    + " or (numerodocusuario) like ('%" + numerodocusuario + "%') "
                    + " ORDER BY numerodocusuario; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mitipousuario = new usuarios();
                mitipousuario.setIdusuarios(rs.getString(1));
                mitipousuario.setNumerodocusuario(rs.getString(2));
                mitipousuario.setNombreusuarios(rs.getString(3));
                mitipousuario.setApellidousuarios(rs.getString(4));
                mitipousuario.setCorreousuarios(rs.getString(5));
                mitipousuario.setTelefonousuarios(rs.getString(6));
                mitipousuario.setDireccionusuario(rs.getString(7));
                mitipousuario.setClaveusuario(rs.getString(8));
                mitipousuario.setTipo_documento_idtipodoc(rs.getInt(9));
                mitipousuario.setRoles_idroles(rs.getInt(10));
                mitipousuario.setGenero_idgenero(rs.getInt(11));
                mitipousuario.setEstado_usuario_idestadousuario(rs.getInt(12));
                milistausuarios.add(mitipousuario);

            }
            return milistausuarios;
        } catch (Exception ex) {
            System.out.print("Ocurrio un error en la consulta de listado en el usuario" + ex.getMessage());
        }
        return milistausuarios;
    }

    public String Eliminarusuario(usuarios USUARIO) {
        String mirespuesta;
        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = " delete from usuarios where numerodocusuario = ? and nombreusuarios = ? and apellidousuarios = ? ;";
            sentencia = nuevaCon.prepareStatement(Query);
            
            sentencia.setString(1, USUARIO.getNumerodocusuario());
            sentencia.setString(2, USUARIO.getNombreusuarios());
            sentencia.setString(3, USUARIO.getApellidousuarios());
            sentencia.execute();
            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en usuarioDAO.Eliminarusuario" + ex.getMessage());
        }
        return mirespuesta;
    }

}
