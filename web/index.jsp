<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link href="vista/css/login.css" rel="stylesheet" type="text/css"/>
        <title>Inicio de sesion</title>
    </head>
    <body>
        <div class="container bg-light">
            <div class="row">
                <div class="col bg">
                    
                </div>
                <div class="col">
                    <h2 class="inicio">Inicio de sesion</h2>
                    <form action="Iniciosesion" method="post">
                        <div class="form-floating mb-3 form-group">
                            <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="usuarios">
                            <label for="floatingInput">Usuarios</label>
                        </div>
                        <div class="form-floating form-group">
                            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
                            <label for="floatingPassword">Password</label>
                        </div>
                        <br>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-success">Iniciar sesion</button> 
                        </div>
                        <div class="my-3">
                            <span>No estas registrado? <a href="vista/RegistroUsuarios.jsp">Registrate</a></span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
