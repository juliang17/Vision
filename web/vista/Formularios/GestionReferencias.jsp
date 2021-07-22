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
        <title>Referencia de pago</title>
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
                <h1>Registrar referencia de pago</h1>
                <br>
                <form action="/VISION/RegistroReferencias" method="post" onsubmit="return validacionReferencia()" class="row g-3">
                        <div class="form-floating col-md-6" >
                            <input type="date" name="fechadepago" class="form-control" placeholder="Digite la fecha de pago" id="txt_fechadepago_Reg">
                            <label for="floatingInput">Fecha de pago</label>
                        </div> 
                        <div class="form-floating col-md-6" >
                            <input type="number" name="medio_de_pago_idMedioDePago" class="form-control d-none" id="txt_medio_de_pago_idMedioDePago_Reg">
                            <%
                                mediodepagoDAO medio_de_pago_dao = new mediodepagoDAO();
                                ArrayList<medio_de_pago> mi_medio_de_pago = medio_de_pago_dao.ListadoMedioDePago("", "");
                                out.println("<select class='form-control' id='Selectidmediodepago' size='1'>");
                                out.println("<option onclick='setMedio_de_pago_idMedioDePago(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                                for (medio_de_pago M : mi_medio_de_pago) {
                                    out.println("<option onclick='setMedio_de_pago_idMedioDePago(\"" + M.getIdMedioDePago() + "\")'>" + M.getDescripcionmediodepago() + "</option>");
                                }
                                out.println("</select>");
                            %>
                            <label for="floatingInput">Medio de pago</label>
                        </div>
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <button type="submit" class="btn btn-success">Registrar</button>
                </form>
            </div>
        </div>

        <div id="Listado" class="bd-example container">
            <form action="/VISION/ConsultarReferencias" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group ">
                        <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="autofocus" placeholder="Consultar por Id"/>
                        <button type="button" class="btn btn-primary" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado referencia de pago</h2>
                        <%
                            referenciaDAO referenciadao = new referenciaDAO();
                            ArrayList<referencia_de_pago> referenciaList = new ArrayList<referencia_de_pago>();
                            referenciaList = referenciadao.ConsultarListadoReferencia_de_pago(buscando);
                            out.println("<table class='table table-dark table-striped table-hover table-bordered'><thead class='thead-info'><tr><th>ID</th><th>Fecha de Pago</th><th>Medio</th><th>Eliminar</th></tr></thead>");

                            for (referencia_de_pago C : referenciaList) {

                                out.println("<tr>");
                                out.println("<td>" + C.getIdreferenciadepago() + "</td>");
                                out.println("<td>" + C.getFechadepago()+ "</td>");
                                out.println("<td>" + C.getMedio_de_pago_idMedioDePago()+ "</td>");

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

