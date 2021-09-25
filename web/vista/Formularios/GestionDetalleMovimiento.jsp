<%@page import="modelo.movimiento"%>
<%@page import="controlador.movimientoDAO"%>
<%@page import="modelo.productos"%>
<%@page import="controlador.ProductoDAO"%>
<%@page import="modelo.detalle_movimiento"%>
<%@page import="controlador.detalleDAO"%>
<%@page import="modelo.inventario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.inventarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarDetalle.js"></script>
        <script src="https://kit.fontawesome.com/4d836167dd.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle movimiento</title>
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
                            <a class="nav-link" aria-current="page" href="GestionInventarios.jsp">Gestión inventario</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <br>
        <div id="Listado" class="bd-example container">
            <form action="/VISION/ConsultarDetalle" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group">
                        <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="autofocus" placeholder="Consultar por Id"/>
                        <button type="button" class="btn btn-primary" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado detalle movimiento</h2>
                        <%
                            detalleDAO detalledao = new detalleDAO();
                            ArrayList<detalle_movimiento> detalleList = new ArrayList<detalle_movimiento>();
                            detalleList = detalledao.ListadoDetalle(buscando, buscando);
                            out.println("<table class='table table-dark table-striped table-hover table-bordered'><thead class='thead-info'><tr><th>ID</th><th>cantidad</th><th>precio</th><th>iva</th><th>subtotal</th><th>Total producto</th><th>Producto</th><th>Movimiento</th></tr></thead>");

                            for (detalle_movimiento C : detalleList) {

                                out.println("<tr>");
                                out.println("<td>" + C.getIddetallemovimiento()+ "</td>");
                                out.println("<td>" + C.getCantidad() + "</td>");
                                out.println("<td>" + C.getPrecio() + "</td>");
                                out.println("<td>" + C.getIva() + "</td>");
                                out.println("<td>" + C.getSubtotal() + "</td>");
                                out.println("<td>" + C.getTotal_producto() + "</td>");
                                out.println("<td>" + C.getProductos_idproductos() + "</td>");
                                out.println("<td>" + C.getMovimiento_idmovimiento() + "</td>");
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

