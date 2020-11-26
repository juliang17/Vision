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
            String Query = "insert usuarios (numerodocusuario,nombreusuarios,apellidousuarios,correousuarios,telefonousuarios,direccionusuario,contraseñausuario,tipo_documento_idtipodoc,roles_idroles,genero_idgenero,estado_usuario_idestadousuario)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, USUARIOS.getnumerodocusuario());
            sentencia.setString(2, USUARIOS.getnombreusuarios());
            sentencia.setString(3, USUARIOS.getapellidousuarios());
            sentencia.setString(4, USUARIOS.getcorreousuarios());
            sentencia.setInt(5, USUARIOS.gettelefonousuarios());
            sentencia.setString(6, USUARIOS.getdireccionusuario());
            sentencia.setString(7, USUARIOS.getcontraseñausuario());
            sentencia.setInt(8, USUARIOS.gettipo_documento_idtipodoc());
            sentencia.setInt(9, USUARIOS.getroles_idroles());
            sentencia.setInt(10, USUARIOS.getgenero_idgenero());
            sentencia.setInt(11, USUARIOS.getestado_usuario_idestadousuario());
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
            String Query = "update usuarios set numerodocusuario=?, nombreusuarios=?, apellidousuarios=?, correousuarios=?, telefonousuarios=?, direccionusuario=?, contraseñausuario=?, tipo_documento_idtipodoc=?, roles_idroles=?, genero_idgenero=?, estado_usuario_idestadousuario=? where numerodocusuario=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, USUARIOS.getnumerodocusuario());
            sentencia.setString(2, USUARIOS.getnombreusuarios());
            sentencia.setString(3, USUARIOS.getapellidousuarios());
            sentencia.setString(4, USUARIOS.getcorreousuarios());
            sentencia.setInt(5, USUARIOS.gettelefonousuarios());
            sentencia.setString(6, USUARIOS.getdireccionusuario());
            sentencia.setString(7, USUARIOS.getcontraseñausuario());
            sentencia.setInt(8, USUARIOS.gettipo_documento_idtipodoc());
            sentencia.setInt(9, USUARIOS.getroles_idroles());
            sentencia.setInt(10, USUARIOS.getgenero_idgenero());
            sentencia.setInt(11, USUARIOS.getestado_usuario_idestadousuario());
            sentencia.setString(12, USUARIOS.getnumerodocusuario());
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
            String Query = ("select idusuarios, numerodocusuario, nombreusuarios, apellidousuarios, correousuarios, telefonousuarios, direccionusuario, contraseñausuario, tipo_documento_idtipodoc, roles_idroles, genero_idgenero, estado_usuario_idestadousuario from usuarios where numerodocusuario = " + numerodocusuario);
            ResultSet rs = sentencia.executeQuery(Query);

            while (rs.next()) {
                misusuarios = new usuarios();
                misusuarios.setidusuarios(rs.getInt(1));
                misusuarios.setnumerodocusuario(rs.getString(2));
                misusuarios.setnombreusuarios(rs.getString(3));
                misusuarios.setapellidousuarios(rs.getString(4));
                misusuarios.setcorreousuarios(rs.getString(5));
                misusuarios.settelefonousuarios(rs.getInt(6));
                misusuarios.setdireccionusuario(rs.getString(7));
                misusuarios.setcontraseñausuario(rs.getString(8));
                misusuarios.settipo_documento_idtipodoc(rs.getInt(9));
                misusuarios.setroles_idroles(rs.getInt(10));
                misusuarios.setgenero_idgenero(rs.getInt(11));
                misusuarios.setestado_usuario_idestadousuario(rs.getInt(12));
            }
            return misusuarios;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return misusuarios;
    }

    public ArrayList<usuarios> Consultarlistadousuarios(int numerodocusuario, String nombreusuarios, String apellidousuarios) {
        ArrayList<usuarios> milistausuarios = new ArrayList<usuarios>();
        usuarios mitipousuario;

        Conexion miConexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miConexion.getConn();

        System.out.println("Buscando parametro: " + numerodocusuario);
        try {
            Statement sentencia = nuevaCon.createStatement();
            String Query = " select idusuarios, numerodocusuario, nombreusuarios, apellidousuarios, correousuarios, telefonousuarios, direccionusuario, contraseñausuario, tipo_documento_idtipodoc, roles_idroles, genero_idgenero, estado_usuario_idestadousuario"
                    + " from usuarios"
                    + " where numerodocusuario like '%" + numerodocusuario + "%' "
                    + " or (nombreusuarios) like ('%" + nombreusuarios + "%') "
                    + " or (apellidousuarios) like ('%" + apellidousuarios + "%') ORDER BY numerodocusuario; ";
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                mitipousuario = new usuarios();
                mitipousuario.setidusuarios(rs.getInt(1));
                mitipousuario.setnumerodocusuario(rs.getString(2));
                mitipousuario.setnombreusuarios(rs.getString(3));
                mitipousuario.setapellidousuarios(rs.getString(4));
                mitipousuario.setcorreousuarios(rs.getString(5));
                mitipousuario.settelefonousuarios(rs.getInt(6));
                mitipousuario.setdireccionusuario(rs.getString(7));
                mitipousuario.setcontraseñausuario(rs.getString(8));
                mitipousuario.settipo_documento_idtipodoc(rs.getInt(9));
                mitipousuario.setroles_idroles(rs.getInt(10));
                mitipousuario.setgenero_idgenero(rs.getInt(11));
                mitipousuario.setestado_usuario_idestadousuario(rs.getInt(12));
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
            
            sentencia.setString(1, USUARIO.getnumerodocusuario());
            sentencia.setString(2, USUARIO.getnombreusuarios());
            sentencia.setString(3, USUARIO.getapellidousuarios());
            sentencia.execute();
            mirespuesta = "";
        } catch (Exception ex) {
            mirespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en usuarioDAO.Eliminarusuario" + ex.getMessage());
        }
        return mirespuesta;
    }

}
