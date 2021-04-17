
<%@page import="modelo.detalle_movimiento"%>
<%@page import="controlador.detalleDAO"%>
<%@page import="modelo.movimiento"%>
<%@page import="controlador.movimientoDAO"%>
<%@page import="modelo.productos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarDetalle.js" type="text/javascript"></script>
        <title>Detalle movimiento</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <!--NAV-->
        <div class="row justify-content-md-center div-nav-2">
            <div class="btn-group">
                <button type="button" class="btn btn-dark-1" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Registrar')">
                    Registrar
                </button>
                <button type="button" class="btn btn-dark-1" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Listado')">
                    Consultar
                </button>
            </div>
        </div>
        <!--NAV-->

        <!--FORMULARIO REGISTRAR-->
        <div id="Registrar" class="bd-example d-none">
            <div class="container" style="background-color: white">
                <h1>Registrar detalle movimiento</h1>
                <form action="/VISION/RegistrarDetalle" method="post" onsubmit="return validaciondetalle()" >
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                            <h2>cantidad:</h2>
                            <input type="text" name="cantidad" class="form-control" placeholder="Digite la cantidad" id="txt_cantidad_Reg">
                        </div> 
                        <div class="form-group col-md-6" >
                            <h2>precio</h2>
                            <input type="text" name="precio" class="form-control" placeholder="Digite el precio" id="txt_precio_Reg">
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <h2>iva</h2>
                                <input type="text" name="iva" class="form-control" placeholder="Digite el iva" id="txt_iva_Reg">
                            </div>  
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <h2>subtotal</h2>
                                <input type="text" name="subtotal" class="form-control" placeholder="Digite el subtotal" id="txt_subtotal_Reg">
                            </div>  
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <h2>producto</h2>
                                <input type="number" name="productos_idproductos" class="form-control d-none" placeholder="Producto" id="txt_productos_idproductos_Reg"> <br>
                                <%
                                    ProductoDAO productos_dao = new ProductoDAO();
                                    ArrayList<productos> mi_productos = productos_dao.listadoproductos("", "");
                                    out.println("<select class='form-control' id='SelectIdproductos' size='1'>");
                                    out.println("<option onclick='setProductos_idproductos(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                                    for (productos P : mi_productos) {
                                        out.println("<option onclick='setProductos_idproductos(\"" + P.getReferenciaproducto() + "\")'>" + P.getNombreproducto() + "</option>");
                                    }
                                    out.println("</select>");
                                %>
                            </div>
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <h2>movimiento</h2>
                                <input type="number" name="movimiento_idmovimiento" class="form-control d-none" placeholder="Movimiento" id="txt_movimiento_idmovimiento_Reg"> <br>
                                <%
                                    movimientoDAO MovDAO = new movimientoDAO();
                                    ArrayList<movimiento> milistamovimiento = MovDAO.Consultarlistadomovimiento("");
                                    out.println("<select class='form-control' id='SelectIdproductos' size='1'>");
                                    out.println("<option onclick='setmovimiento_idmovimiento(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                                    for (movimiento M : milistamovimiento) {
                                        out.println("<option onclick='setmovimiento_idmovimiento(\"" + M.getIdmovimiento() + "\")'>" + M.getFechamovimiento() + "</option>");
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
        <!--FORMULARIO REGISTRAR-->

        <!--FORMULARIO LISTAR-->
        <div id="Listado" class="bd-example contenedor2">
            <form action="/VSION/ConsultarDetalle" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group">
                            <input id ="txt_Id_Consultado" type = "text" class="form-control"
                                   name= "IdConsultado" value="<%=buscando%>" autofocus
                                   placeholder="Buscar por cantidad"/>
                            <button type="button" class="btn btn-primary" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"
                                    onClick="realizarBusqueda()">Buscar</button>
                        </div>   
                    <div>
                        <h2 class="title-table">Listado detalle movimiento</h2>
                        <%
                            detalleDAO detalle_movimiento_dao = new detalleDAO();
                            ArrayList<detalle_movimiento> mi_detalle_movimiento = new ArrayList<detalle_movimiento>();
                            mi_detalle_movimiento = detalle_movimiento_dao.ListadoDetalleMovimiento(buscando, buscando);
                            out.println("<table class='table table-light table-striped table-hover table-borderless border-dark'><thead class='thead-info'><tr><th>cantidad</th><th>precio</th><th>iva</th><th>subtotal</th><th>Producto</th><th>Movimiento</th><th>Eliminar</th></tr></thead>");

                            for (detalle_movimiento D : mi_detalle_movimiento) {

                                out.println("<tr>");
                                out.println("<td>" + D.getCantidad() + "</td>");
                                out.println("<td>" + D.getPrecio() + "</td>");
                                out.println("<td>" + D.getIva() + "</td>");
                                out.println("<td>" + D.getSubtotal() + "</td>");
                                out.println("<td>" + D.getProductos_idproductos() + "</td>");
                                out.println("<td>" + D.getMovimiento_idmovimiento() + "</td>");

                                out.println("<td>" + "<input type = 'submit' class='btn btn-danger btn btn-login' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + D.getIddetallemovimiento() + ")'/>" + "</td>");
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
