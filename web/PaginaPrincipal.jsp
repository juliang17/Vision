

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
        <link href="vista/css/principal.css" rel="stylesheet" type="text/css"/>
        <title>Maxilini</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Maxilini</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Informacion</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Carrito</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Iniciar sesion</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Registrarse</a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <div class="container mt-2">
            <div class="row">
                <div class="col-sm-1">
                    <% ProductoDAO productos_dao = new ProductoDAO();
                        ArrayList<productos> milistaproductos = new ArrayList<productos>();
                        milistaproductos = productos_dao.listadoproductos(3);

                        for (productos P : milistaproductos) {
                            out.print(P.getNombreproducto());
                            out.print(P.getPrecio());
                            out.print(P.getCantidadproducto());
                            out.print(P.getDescripcionproducto());

                        }
                    %>
                </div>
                <div>
                    <a href="Carrito?accion=agregarcarrito$idproductos=${P.getidproductos}" class="btn btn-primary">Agregar al carrito</a>
                    <a href="#" class="btn btn-success">Comprar</a>
                </div>
            </div>
        </div>
    </body>
</html>


