
<%@page import="modelo.tipo_mov"%>
<%@page import="controlador.tipo_movDAO"%>
<%@page import="modelo.usuarios"%>
<%@page import="controlador.usuariosDAO"%>
<%@page import="modelo.movimiento"%>
<%@page import="controlador.movimientoDAO"%>
<%@page import="modelo.medio_de_pago"%>
<%@page import="controlador.mediodepagoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarMovimientos.js"></script>
        <script src="https://kit.fontawesome.com/4d836167dd.js" crossorigin="anonymous"></script>
        <title>Movimiento</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <!--NAV-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="../../PaginaPrincipal.jsp">MAXILINI</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionInventarios.jsp">Gestión inventario</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionDetalleMovimiento.jsp">Gestión detalle movimiento</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--NAV-->
        <br>
        <!--FORMULARIO LISTAR-->
        <div id="Listado" class="bd-example container">
            <form action="/VISION/ConsultarMovimientos" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group">
                        <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="autofocus" placeholder="Consultar por Id"/>
                        <button type="button" class="btn btn-primary" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                    </div> 
                    <div>
                        <h2 class="title-table">Listado movimiento</h2>
                        <%
                            movimientoDAO MovDAO = new movimientoDAO();
                            ArrayList<movimiento> milistamovimiento = new ArrayList<movimiento>();
                            milistamovimiento = MovDAO.ListadoMovimiento(buscando, buscando);
                            out.println("<table class='table table-dark table-striped table-hover table-bordered'><thead class='thead-info'><tr><th>ID</th><th>Numero de documento</th><th>fecha movimiento</th><th>subtotal</th><th>iva</th><th>estado movimiento</th><th>total</th><th>Usuario</th><th>Tipo movimiento</th><th>medio de pago</th></tr></thead>");

                            for (movimiento M : milistamovimiento) {

                                out.println("<tr>");
                                out.println("<td>" + M.getIdmovimiento() + "</td>");
                                out.println("<td>" + M.getNumero_documento() + "</td>");
                                out.println("<td>" + M.getFechamovimiento() + "</td>");
                                out.println("<td>" + M.getSubtotal() + "</td>");
                                out.println("<td>" + M.getIva() + "</td>");
                                out.println("<td>" + M.getEstadoMov() + "</td>");
                                out.println("<td>" + M.getTotal() + "</td>");
                                out.println("<td>" + M.getUsuarios_idusuarios() + "</td>");
                                out.println("<td>" + M.getTipo_mov_id_tipo_mov() + "</td>");
                                out.println("<td>" + M.getMedio_de_pago_idmediodepago() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</table>");
                        %>
                    </div>
                </div>
            </form>
        </div>
        <!--FORMULARIO LISTAR--> 
    </body>
</html>
