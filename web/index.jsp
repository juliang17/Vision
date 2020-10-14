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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MAXILINI</h1>
        <div class="Formulario">
            <h2>Inicio de sesion</h2>
            <form action="Iniciosesion" method="post">
                <label>Usuario</label><input placeholder="Digite tu usuario" id="" type="text" name="usuarios">
                <br><br>
                <label>Password</label><input placeholder="Digite su contraseña" id="" type="password" name="password">
                <input type="submit" value="Iniciar sesion">
            </form>
        </div>
    </body>
</html>
