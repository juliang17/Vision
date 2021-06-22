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
        <title>Inventario</title>
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
                <button type="button" class="btn btn-secondary" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false" onClick="VolverAlInicio()">
                    Volver al Inicio
                </button>
            </div>
        </div>

        <div id="Registrar" class="bd-example d-none">
            <div class="container">
                <h1>Registrar Inventario</h1>
                <form action="/VISION/RegistroDetalle" method="post" onsubmit="return validacionDetalle()" >
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                            <h2>Descripcion:</h2>
                            <input type="text" name="descripcion" class="form-control" placeholder="Digite la descripcion" id="txt_descripcion_Reg">
                        </div> 
                        <div class="form-group col-md-6" >
                            <h2>Cantidad:</h2>
                            <input type="text" name="cantidad" class="form-control" placeholder="Digite la cantidad" id="txt_cantidad_Reg">
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-md-6" >
                                <h2>Precio:</h2>
                                <input type="text" name="precio" class="form-control" placeholder="Digite el precio" id="txt_precio_Reg">
                            </div> 
                            <div class="form-group col-md-6" >
                                <h2>Precio:</h2>
                                <input type="text" name="iva" class="form-control" placeholder="Digite el iva" id="txt_iva_Reg">
                            </div> 
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6" >
                                <h2>Subtotal:</h2>
                                <input type="text" name="subtotal" class="form-control" placeholder="Digite el subtotal" id="txt_subtotal_Reg">
                            </div> 
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <input type="number" name="productos_idproductos" class="form-control" id="txt_productos_idproductos_Reg"> <br>
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
                            </div>
                        </div>  
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <input type="number" name="movimiento_idmovimiento" class="form-control" id="txt_movimiento_idmovimiento_Reg"> <br>
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
                            </div>
                        </div>  
                    </div>
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <center><button type="submit" class="btn btn-success">Registrar</button></center>
                </form>
            </div>
        </div>

        <div id="Listado" class="bd-example container">
            <form action="/VISION/ConsultarDetalle" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group d-none">
                        <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="autofocus" placeholder="Ingresar"/>
                        <button type="button" class="btn btn-arg" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado Movimientos</h2>
                        <%
                            detalleDAO detalledao = new detalleDAO();
                            ArrayList<detalle_movimiento> detalleList = new ArrayList<detalle_movimiento>();
                            detalleList = detalledao.ListadoDetalle(buscando, buscando);
                            out.println("<table class='table table-light table-striped table-hover table-borderless border-dark'><thead class='thead-info'><tr><th>ID</th><th>descripcion</th><th>cantidad</th><th>precio</th><th>iva</th><th>subtotal</th><th>productos_idproductos</th><th>movimiento_idmovimiento</th><th>Eliminar</th></tr></thead>");

                            for (detalle_movimiento C : detalleList) {

                                out.println("<tr>");
                                out.println("<td>" + C.getIddetallemovimiento()+ "</td>");
                                out.println("<td>" + C.getDescripcion()+ "</td>");
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

