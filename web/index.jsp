<%-- 
    Document   : index
    Created on : 29/09/2020, 08:12:33 AM
    Author     : santy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="vista/css/Sesion.css" rel="stylesheet" type="text/css"/>
        <title>Inicio de sesion</title>
    </head>
    <body>
        <div class="Formulario">
            <form action="Iniciosesion" method="post">
                <h1>Inicio de sesion</h1>
                <label><strong>Usuario</strong></label>
                <br>
                <input placeholder="Digite tu usuario" id="" type="text" name="usuarios">
                <br><br>
                <label><strong>Password</strong></label>
                <br>
                <input placeholder="Digite su contraseña" id="" type="password" name="password">
                <br><br>
                <input class="boton" type="submit" value="Iniciar sesion">
            </form>
        </div>
    </body>
</html>
