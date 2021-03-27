<%@page import="controlador.detalleDAO"%>
<%@page import="modelo.movimiento"%>
<%@page import="controlador.movimientoDAO"%>
<%@page import="modelo.productos"%>
<%@page import="controlador.ProductoDAO"%>
<%@page import="modelo.detalle_movimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="../Javascript/ValidarDetalle.js" type="text/javascript"></script>
        <title>Detalle movimiento</title>
    </head>
    <body>
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
        <div id="Registrar" class="d-none">
            <h1>Registro detalle movimiento</h1>
            <form action="/VISION/RegistrarDetalle" method="post" onsubmit="return RegistroDetalle()">
                <h5>Descripcion </h5>
                <input type="text" name="descripcion" class="form-control" placeholder="descripcion"  id="txt_descripcion_reg">
                <br>
                <h5>cantidad</h5>
                <input type="number" name="cantidad" class="form-control" placeholder="cantidad" id="txt_cantidad_Reg">
                <br>
                <h5>precio</h5>
                <input type="number" name="precio" class="form-control" placeholder="precio" id="txt_precio_reg">
                <br>
                <h5>iva</h5>
                <input type="number" name="iva" class="form-control" placeholder="iva" id="txt_iva_reg">
                <br>
                <h5>subtotal</h5>
                <input type="number" name="subtotal" class="form-control" placeholder="subtotal" id="txt_subtotal_reg">
                <br>
                <h5><strong>Producto</strong></h5>
                <input type="number" name="productos_idproductos" class="form-control d-none" id="txt_productos_idproductos_reg">
                <%
                    ProductoDAO productos_dao = new ProductoDAO();
                    ArrayList<productos> mi_productos = productos_dao.listadoproductos("", "");
                    out.println("<select class='form-control' id='Selectidproductos' size='1'>");
                    out.println("<option onclick='setproductos_idproductos(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (productos P : mi_productos) {
                        out.println("<option onclick='setproductos_idproductos(\"" + P.getIdproductos() + "\")'>" + P.getNombreproducto() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br>
                <h5><strong>Movimiento</strong></h5>
                <input type="number" name="movimiento_idmovimiento" class="form-control d-none" id="txt_movimiento_idmovimiento_Reg">
                <%
                    movimientoDAO mimovimientoDAO = new movimientoDAO();
                    ArrayList<movimiento> mimovimiento = mimovimientoDAO.Consultarlistadomovimiento("");
                    out.println("<select class='form-control' id='Selectidmovimiento' size='1'>");
                    out.println("<option onclick='setmovimiento_idmovimiento(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (movimiento M : mimovimiento) {
                        out.println("<option onclick='setmovimiento_idmovimiento(\"" + M.getIdmovimiento() + "\")'>" + M.getFechamovimiento() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br>
                <div id="controlRegistro" class="bd-example d-none">
                    <input id="txt_bandera_reg" type="text" class="form-control" name="banderaRegistro">
                </div>
                <button type="submit" class="btn btn-success">Registrar</button>
            </form>
        </div>

        <div id="Actualizar" class="d-none">
            <h1>Actualizar detalle movimiento</h1>
            <form action="/VISION/ActualizarDetalle" method="post">
                <h5>Descripcion </h5>
                <input type="text" name="descripcion" class="form-control" placeholder="descripcion"  id="txt_descripcion_Reg">
                <br>
                <h5>cantidad</h5>
                <input type="number" name="cantidad" class="form-control" placeholder="cantidad" id="txt_cantidad_reg">
                <br>
                <h5>precio</h5>
                <input type="number" name="precio" class="form-control" placeholder="precio" id="txt_precio_reg">
                <br>
                <h5>iva</h5>
                <input type="number" name="iva" class="form-control" placeholder="iva" id="txt_iva_reg">
                <br>
                <h5>subtotal</h5>
                <input type="number" name="subtotal" class="form-control" placeholder="subtotal" id="txt_subtotal_reg">
                <br>
                <br>
                <h5><strong>Producto</strong></h5>
                <input type="number" name="productos_idproductos" class="form-control" id="txt_productos_idproductos_Reg" value="<%=request.getParameter("productos")%>">
                <br>
                <br>
                <h5><strong>movimiento</strong></h5>
                <input type="number" name="movimiento_idmovimiento" class="form-control" id="txt_movimiento_idmovimiento_reg" value="<%=request.getParameter("movimiento")%>">
                <br>
                <button type="submit" class="btn btn-success">Actualizar</button>
            </form>
        </div>    

        <br>
        <div id="Listado" class="bd-example">
            <form action="/VISION/ConsultaDetalle" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group">
                        <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="autofocus" placeholder="Ingresar descripcion."/>
                        <button type="button" class="btn btn-arg" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado detalle movimiento</h2>
                        <div id="Tabla_usuarios">

                            <% detalleDAO detalle_movimiento_dao = new detalleDAO();
                                ArrayList<detalle_movimiento> mi_detalle_movimiento = new ArrayList<detalle_movimiento>();
                                mi_detalle_movimiento = detalle_movimiento_dao.ListadoDetalleMovimiento(buscando);
                                out.println("<table class='table table-dark'><tr><td>Descripcion</td><td>Cantidad</td><td>Precio</td><td>Iva</td><td>Subtotal</td><td>Producto</td><td>Movimiento</td><td>Editar</td><td>Eliminar</td></tr>");
                                for (detalle_movimiento D : mi_detalle_movimiento) {
                                    out.println("<tr>");
                                    out.println("<td>" + D.getCantidad() + "</td>");
                                    out.println("<td>" + D.getPrecio() + "</td>");
                                    out.println("<td>" + D.getIva() + "</td>");
                                    out.println("<td>" + D.getSubtotal() + "</td>");
                                    out.println("<td>" + D.getProductos_idproductos() + "</td>");
                                    out.println("<td>" + D.getMovimiento_idmovimiento() + "</td>");
                                    out.println("<td>" + "<input type = 'submit' class='btn btn-secondary btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + D.getDescripcion() + ")'/>" + "</td>");
                                    out.println("<td>" + "<input type = 'submit' class='btn btn-danger btn btn-login' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + D.getDescripcion() + ")'/>" + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</table>");
                            %>
                        </div>  
                    </div>
                </div>
            </form>
        </div>
    </body>
</body>
</html>
