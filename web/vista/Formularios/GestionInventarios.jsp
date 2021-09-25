<%@page import="modelo.productos"%>
<%@page import="controlador.ProductoDAO"%>
<%@page import="modelo.inventario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.inventarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarInventarios.js"></script>
        <script src="https://kit.fontawesome.com/4d836167dd.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="../../PaginaPrincipal.jsp">MAXILINI</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionMovimiento.jsp">Gestión movimientos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionDetalleMovimiento.jsp">Gestión detalle movimiento</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <br>
        <div id="Listado" class="bd-example container">
            <form action="/VISION/ConsultarInventarios" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group ">
                        <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="autofocus" placeholder="Consultar por Id"/>
                        <button type="button" class="btn btn-primary" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado Inventarios</h2>
                        <%
                            inventarioDAO inventariodao = new inventarioDAO();
                            ArrayList<inventario> inventarioList = new ArrayList<inventario>();
                            inventarioList = inventariodao.ListadoInventario(buscando, buscando, buscando);
                            out.println("<table class='table table-dark table-striped table-hover table-bordered'><thead class='thead-info'><tr><th>ID</th><th>Entrada</th><th>Salida</th><th>Saldo</th><th>Producto</th></tr></thead>");

                            for (inventario C : inventarioList) {

                                out.println("<tr>");
                                out.println("<td>" + C.getIdinventario() + "</td>");
                                out.println("<td>" + C.getEntrada() + "</td>");
                                out.println("<td>" + C.getSalida() + "</td>");
                                out.println("<td>" + C.getSaldo() + "</td>");
                                out.println("<td>" + C.getProductos_idproductos() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</table>");
                        %>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
