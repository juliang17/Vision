
<%@page import="modelo.movimiento"%>
<%@page import="controlador.movimientoDAO"%>
<%@page import="modelo.medio_de_pago"%>
<%@page import="controlador.mediodepagoDAO"%>
<%@page import="modelo.tipo_doc_contable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.tipo_doc_contableDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarMovimiento.js" type="text/javascript"></script>
        <title>Movimiento</title>
    </head>
    <body style="background-image: url('../imagenes/ropaRosada (1).jpg')" onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
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
                <h1>Registrar movimiento</h1>
                <form action="/VISION/RegistrarMovimiento" method="post" onsubmit="return validacionMovimiento()" >
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                            <h2>fechamovimiento</h2>
                            <input type="date" name="fechamovimiento" class="form-control" placeholder="Digite la fecha movimiento" id="txt_fechamovimiento_Reg">
                        </div> 
                        <div class="form-group col-md-6" >
                            <h2>subtotal</h2>
                            <input type="text" name="subtotal" class="form-control" placeholder="Digite el subtotal" id="txt_subtotal_Reg">
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <h2>iva</h2>
                                <input type="text" name="iva" class="form-control" placeholder="Digite el iva" id="txt_iva_Reg">
                            </div>  
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <h2>descuento</h2>
                                <input type="text" name="descuento" class="form-control" placeholder="Digite el descuento" id="txt_descuento_Reg">
                            </div>  
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <h2>total</h2>
                                <input type="text" name="total" class="form-control" placeholder="Digite el total" id="txt_total_Reg">
                            </div>  
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <h2>Tipo de documento contable</h2>
                                <input type="number" name="tipo_doc_contable_idtipodoccontable" class="form-control d-none" placeholder="Tipo de documento contable" id="txt_tipo_doc_contable_idtipodoccontable_reg"> <br>
                                <%
                                    tipo_doc_contableDAO tipo_doc_contable_dao = new tipo_doc_contableDAO();
                                    ArrayList<tipo_doc_contable> tipo_doc_contable = tipo_doc_contable_dao.ListadoTipoDocContable("");
                                    out.println("<select class='form-control' id='Selectidtipodoccontable' size='1'>");
                                    out.println("<option onclick='settipo_doc_contable_idtipodoccontable(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                                    for (tipo_doc_contable T : tipo_doc_contable) {
                                        out.println("<option onclick='settipo_doc_contable_idtipodoccontable(\"" + T.getIdtipodoccontable() + "\")'>" + T.getDescripciontipodoccontable() + "</option>");
                                    }
                                    out.println("</select>");
                                %>
                            </div>
                            <div class="form-group col-md-12" >
                                <h2>Medio de pago</h2>
                                <input type="number" name="medio_de_pago_idmediodepago" class="form-control d-none" placeholder="Medio de pago" id="txt_medio_de_pago_idmediodepago_reg"> <br>
                                <%
                                    mediodepagoDAO medio_de_pago_dao = new mediodepagoDAO();
                                    ArrayList<medio_de_pago> mi_medio_de_pago = medio_de_pago_dao.ListadoMedioDePago("");
                                    out.println("<select class='form-control' id='Selectidmediodepago' size='1'>");
                                    out.println("<option onclick='setmedio_de_pago_idmediodepago(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                                    for (medio_de_pago M : mi_medio_de_pago) {
                                        out.println("<option onclick='setmedio_de_pago_idmediodepago(\"" + M.getIdMedioDePago() + "\")'>" + M.getDescripcionmediodepago() + "</option>");
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
            <form action="/VISION/ConsultarMovimiento" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group d-none">
                        <input id ="txt_Id_Consultado" type = "text" class="form-control"
                               name= "IdConsultado" value="<%=buscando%>" autofocus
                               placeholder="Buscar por fecha"/>
                        <button type="button" class="btn btn-primary" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false"
                                onClick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado movimiento</h2>
                        <%
                            movimientoDAO MovDAO = new movimientoDAO();
                            ArrayList<movimiento> milistamovimiento = new ArrayList<movimiento>();
                            milistamovimiento = MovDAO.Consultarlistadomovimiento(buscando);
                            out.println("<table class='table table-light table-striped table-hover table-borderless border-dark'><thead class='thead-info'><tr><th>fecha movimiento</th><th>subtotal</th><th>iva</th><th>descuento</th><th>total</th><th>documento contable</th><th>medio de pago</th><th>Eliminar</th><th>Editar</th></tr></thead>");

                            for (movimiento M : milistamovimiento) {

                                out.println("<tr>");
                                out.println("<td>" + M.getFechamovimiento() + "</td>");
                                out.println("<td>" + M.getSubtotal() + "</td>");
                                out.println("<td>" + M.getIva() + "</td>");
                                out.println("<td>" + M.getDescuento() + "</td>");
                                out.println("<td>" + M.getTotal() + "</td>");
                                out.println("<td>" + M.getTipo_doc_contable_idtipodoccontable() + "</td>");
                                out.println("<td>" + M.getMedio_de_pago_idmediodepago() + "</td>");
                                out.println("<td>" + "<input type = 'submit' class='btn btn-secondary btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + M.getFechamovimiento() + ")'/>" + "</td>");
                                out.println("<td>" + "<input type = 'submit' class='btn btn-danger btn btn-login' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + M.getFechamovimiento() + ")'/>" + "</td>");

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
