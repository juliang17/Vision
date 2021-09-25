

<%@page import="controlador.ProductoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="vista/Javascript/VisualizaOculta.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link href="vista/css/paginaInicio.css" rel="stylesheet" type="text/css"/>
        <title>Maxilini</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="PaginaPrincipal.jsp">MAXILINI</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="vista/RegistroUsuarios.jsp">Gestión usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="vista/RegistroProductos.jsp">Gestión Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="vista/Formularios/GestionInventarios.jsp">Gestión Inventario</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="vista/Formularios/GestionarMovimientos.jsp">Facturación</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="imagen"></div>
    </body>
</html>


