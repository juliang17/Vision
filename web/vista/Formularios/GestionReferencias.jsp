<%@page import="modelo.medio_de_pago"%>
<%@page import="controlador.mediodepagoDAO"%>
<%@page import="modelo.referencia_de_pago"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.referenciaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarReferencia.js"></script>
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
                <form action="/VISION/RegistroReferencias" method="post" onsubmit="return validacionRefrencia()" >
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                            <h2>descripcion</h2>
                            <input type="text" name="descripcion" class="form-control" placeholder="Digite la descripcion" id="txt_descripcion_Reg">
                        </div> 
                        <div class="form-group col-md-6" >
                            <h2>Fecha de pago</h2>
                            <input type="date" name="fechadepago" class="form-control" placeholder="Digite la fecha de pago" id="txt_fechadepago_Reg">
                        </div> 
                        <div class="form-group col-md-12" >
                            <h2>Medio de pago</h2>
                            <input type="number" name="medio_de_pago_idMedioDePago_" class="form-control d-none" placeholder="Medio de pago" id="txt_medio_de_pago_idmediodepago_Reg"> <br>
                            <%
                                mediodepagoDAO medio_de_pago_dao = new mediodepagoDAO();
                                ArrayList<medio_de_pago> mi_medio_de_pago = medio_de_pago_dao.ListadoMedioDePago("", "");
                                out.println("<select class='form-control' id='Selectidmediodepago' size='1'>");
                                out.println("<option onclick='setmedio_de_pago_idmediodepago(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                                for (medio_de_pago M : mi_medio_de_pago) {
                                    out.println("<option onclick='setmedio_de_pago_idmediodepago(\"" + M.getIdMedioDePago() + "\")'>" + M.getDescripcionmediodepago() + "</option>");
                                }
                                out.println("</select>");
                            %>
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
            <form action="/VISION/ConsultarReferencias" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group d-none">
                        <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="autofocus" placeholder="Ingresar "/>
                        <button type="button" class="btn btn-arg" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado Movimientos</h2>
                        <%
                            referenciaDAO referenciadao = new referenciaDAO();
                            ArrayList<referencia_de_pago> referenciaList = new ArrayList<referencia_de_pago>();
                            referenciaList = referenciadao.ConsultarListadoReferencia_de_pago(buscando, buscando);
                            out.println("<table class='table table-light table-striped table-hover table-borderless border-dark'><thead class='thead-info'><tr><th>ID</th><th>Descripción</th><th>Fecha de Pago</th><th>Medio</th><th>Eliminar</th></tr></thead>");

                            for (referencia_de_pago C : referenciaList) {

                                out.println("<tr>");
                                out.println("<td>" + C.getIdreferenciadepago() + "</td>");
                                out.println("<td>" + C.getDescripcion()+ "</td>");
                                out.println("<td>" + C.getFechadepago()+ "</td>");
                                out.println("<td>" + C.getMedio_de_pago_idMedioDePago_()+ "</td>");

                                out.println("<td>" + "<input type = 'submit' class='btn btn-danger btn btn-login' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + C.getIdreferenciadepago()+ ")'/>" + "</td>");
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

