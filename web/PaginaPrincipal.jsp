

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
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark" role="navigation">
            <div class="navbar-collapse collapse">
                <ul class="navbar-brand navbar-nav navbar-left ">
                    <li><a class="navbar-brand" href="#">MAXILINI</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-center">
                    <li><a class="nav-link active" aria-current="page" href="#">Informacion</a></li>
                    <li><a class="nav-link active" aria-current="page" href="#">Productos</a></li>
                    <li><a class="nav-link active" aria-current="page" href="#">Carrito</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a class="nav-link active" aria-current="page" href="index.jsp">Iniciar sesion</a></li>
                    <li><a class="nav-link active" aria-current="page" href="vista/RegistroUsuarios.jsp">Registrarse</a></li>
                </ul>
            </div>
        </nav>
        <div class="container mt-2">
            <div class="row">
                <div class="col-sm-1">
                    <% ProductoDAO productos_dao = new ProductoDAO();
                        ArrayList<productos> milistaproductos = new ArrayList<productos>();
                        milistaproductos = productos_dao.listadoproductos("" , "");

                        for (productos P : milistaproductos) {
                            out.print(P.getNombreproducto());
                            out.print(P.getPrecio());
                            out.print(P.getCantidadproducto());
                            out.print(P.getDescripcionproducto());

                        }
                    %>
                </div>
                <div>
                    <a href="#" class="btn btn-primary">Agregar al carrito</a>
                    <a href="#" class="btn btn-success">Comprar</a>
                </div>
            </div>
        </div>
    </body>
</html>


