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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle movimiento</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>

        <div class="row justify-content-md-center">
            <div class="btn-group">
                <button type="button" class="btn btn-secondary" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Registrar')">
                    Registrar
                </button>
                <button type="button" class="btn btn-secondary" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Listado')">
                    Consultar
                </button>
            </div>
        </div>

        <div id="Registrar" class="container bd-example d-none">
            <div class="container">
                <center><h3>Registrar detalle movimiento</h3></center>
                <br>
                <form action="/VISION/RegistroDetalle" method="post" onsubmit="return validacionDetalle()" class="row g-3">
                        <div class="form-floating col-md-6">
                            <input type="text" name="cantidad" class="form-control" placeholder="Digite la cantidad" id="txt_cantidad_Reg">
                            <label for="floatingInput">Cantidad</label>
                        </div> 
                            <div class="form-floating col-md-6">
                                <input type="text" name="precio" class="form-control" placeholder="Digite el precio" id="txt_precio_Reg">
                                <label for="floatingInput">Precio</label>
                            </div> 
                            <div class="form-floating col-md-6" >
                                <input type="text" name="iva" class="form-control" placeholder="Digite el iva" id="txt_iva_Reg">
                                <label for="floatingInput">Iva</label>
                            </div> 
                            <div class="form-floating col-md-6" >
                                <input type="text" name="subtotal" class="form-control" placeholder="Digite el subtotal" id="txt_subtotal_Reg">
                                <label for="floatingInput">Subtotal</label>
                            </div> 
                            <div class="form-floating col-md-6" >
                                <input type="number" name="productos_idproductos" class="form-control d-none" id="txt_productos_idproductos_Reg"> 
                                <%
                                    ProductoDAO productos_dao = new ProductoDAO();
                                    ArrayList<productos> mi_productos = productos_dao.listadoproductos("", "");
                                    out.println("<select class='form-control' id='SelectIdproductos' size='1'>");
                                    out.println("<option onclick='setProductos_idproductos(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                                    for (productos P : mi_productos) {
                                        out.println("<option onclick='setProductos_idproductos(\"" + P.getIdproductos() + "\")'>" + P.getNombreproducto() + "</option>");
                                    }
                                    out.println("</select>");
                                %>
                                <label for="floatingInput">Producto</label>
                            </div> 
                            <div class="form-floating col-md-6" >
                                <input type="number" name="movimiento_idmovimiento" class="form-control d-none" id="txt_movimiento_idmovimiento_Reg">
                                <%
                                    movimientoDAO movimiento_dao = new movimientoDAO();
                                    ArrayList<movimiento> mi_movimiento = movimiento_dao.ListadoMovimiento("", "");
                                    out.println("<select class='form-control' id='SelectIdmov' size='1'>");
                                    out.println("<option onclick='setmov(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                                    for (movimiento M : mi_movimiento) {
                                        out.println("<option onclick='setmov(\"" + M.getIdmovimiento() + "\")'>" + M.getFechamovimiento()+ "</option>");
                                    }
                                    out.println("</select>");
                                %>
                                <label for="floatingInput">Movimiento</label>
                            </div>
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <button type="submit" class="btn btn-success">Registrar</button>
                </form>
            </div>
        </div>

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
                            out.println("<table class='table table-dark table-striped table-hover table-bordered'><thead class='thead-info'><tr><th>ID</th><th>cantidad</th><th>precio</th><th>iva</th><th>subtotal</th><th>productos_idproductos</th><th>movimiento_idmovimiento</th><th>Eliminar</th></tr></thead>");

                            for (detalle_movimiento C : detalleList) {

                                out.println("<tr>");
                                out.println("<td>" + C.getIddetallemovimiento()+ "</td>");
                                out.println("<td>" + C.getCantidad() + "</td>");
                                out.println("<td>" + C.getPrecio() + "</td>");
                                out.println("<td>" + C.getIva() + "</td>");
                                out.println("<td>" + C.getSubtotal() + "</td>");
                                out.println("<td>" + C.getProductos_idproductos() + "</td>");
                                out.println("<td>" + C.getMovimiento_idmovimiento() + "</td>");

                                out.println("<td>" + "<input type = 'submit' class='btn btn-danger btn btn-login' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + C.getIddetallemovimiento()+ ")'/>" + "</td>");
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

