<%-- 
    Document   : RegistroUsuarios
    Created on : 25/11/2020, 04:23:21 PM
    Author     : santy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="vista/Javascript/validacionRegistrarUsuarios.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de usuarios</h1>
        <form action="/VISION/registroDeUsuarios" method="post" onsubmit="return RegistroUsuarios()">
            <h5>Nombres </h5>
            <input type="text" name="nombreusuarios" class="form-control" placeholder="Nombres" id="txt_nombreusuarios_Reg"> 
            <br>
            <h5>Apellidos</h5>
            <input type="text" name="apellidousuarios" class="form-control" placeholder="Apellidos" id="txt_apellidousuarios_reg">
            <br>
            <br>
            <p>Seleccione un número para seleccionar un tipo de documento</p>
            <li>1 = Cedula de ciudadania</li>
            <li>2 = Tarjeta de identidad</li >
            <br>
            <h5>Tipo de documento</h5>
            <input type="number" name="tipo_documento_idtipodoc" class="form-control" placeholder="Tipo documento" id="tipo_documento_idtipodoc">
            <br>
            <h5>Identificación Usuario</h5>
            <input type="text" name="numerodocusuarios" class="form-control" placeholder="Numero identificación" id="txt_numerodocusuarios_reg">
            <br>
            <h5>Contraseña</h5>
            <input type="password" name="contraseñausuario" class="form-control" placeholder="clave" id="txt_contraseñausuario_reg">
            <br>
            <h5>Telefono</h5>
            <input type="text" name="telefonousuarios" class="form-control" placeholder="Telefono" id="txt_telefonousuarios_reg">
            <br>
            <h5>Dirección</h5>
            <input type="text" name="direccionusuario" class="form-control" placeholder="Direccion" id="txt_direccionusuario_reg">
            <br>
            <h5>Correo</h5>
            <input type="text" name="correousuario" class="form-control" placeholder="Correo" id="txt_correousuario_reg">
            <br>
            <p>Seleccione un número para escoger un rol de usuario</p>
            <li>1 = Administrado</li>
            <li>2 = Empleado</li>
            <br>
            <h5>Roles</h5>
            <input type="number" name="roles_idroles" class="form-control" placeholder="Roles" id="txt_roles_idroles_reg">
            <br>
            <p>Seleccione un número para seleccionar el estado de usuario</p>
            <li>1 = Activo</li>
            <li>2 = Inactivo</li>
            <br>
            <h5>Estado Usuario</h5>
            <input type="number" name="estado_usuario_idestadousuario" class="form-control" placeholder="Estado usuario" id="txt_estado_usuario_idestadousuario_reg">
            <br>
            <p>Seleccione un número para seleccionar un genero de usuario</p>
            <li>1 = Masculino</li>
            <li>2 = Femenino</li>
            <br>
            <h5>Genero</h5>
            <input type="number" name="genero_idgenero" class="form-control" placeholder="Genero" id="txt_genero_idgenero_reg">
            <br>
            <br>
            <div id="controlRegistro" class="bd-example d-none">
                <input id="txt_bandera_reg" type="text" class="form-control" name="banderaRegistro">
            </div>
            <button type="submit" class="boton">Registrar</button>   
            <br>
        </form>
    </body>
</html>
