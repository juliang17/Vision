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

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Inicio de sesion</title>
    </head>
    <body>
        <div class="Formulario">
            <form action="Iniciosesion" method="post">
                <h1>Inicio de sesion</h1>
                <div class="form-floating mb-3">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="usuarios">
                    <label for="floatingInput">Usuarios</label>
                </div>
                <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
            <label for="floatingPassword">Password</label>
        </div>
                <button type="submit" class="btn btn-success">Iniciar sesion</button>   
            </form>
        </div>

        
    </body>
</html>
