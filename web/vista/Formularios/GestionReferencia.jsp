<%@page import="modelo.referencia_de_pago"%>
<%@page import="controlador.referenciaDAO"%>
<%@page import="modelo.medio_de_pago"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.mediodepagoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarReferencia.js" type="text/javascript"></script>
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
                <button type="button" class="btn btn-secondary" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false" onClick="VolverAlInicio()">
                    Volver al Inicio
                </button>
            </div>
        </div>
        <!--REGISTRAR-->
        <div id="Registrar" class="bd-example d-none">
            <div class="container" style="background-color: white">
                <h1>Registrar referencia de pago </h1>
                <form action="/VISION/RegistrarReferencia" method="post" onsubmit="return ValidarReferencia()" >
                    <div class="form-row" >
                        <div class="form-group col-md-12" >
                            <h2>Fecha de pago:</h2>
                            <input type="date" name="fechadepago" class="form-control" id="txt_fechadepago_Reg">
                        </div> 
                        <h5><strong>Medio de pago</strong></h5>
                        <input type="number" name="medio_de_pago_idMedioDePago" class="form-control d-none" placeholder="Medio de pago" id="txt_medio_de_pago_idMedioDePago_reg"> <br>
                        <%
                            mediodepagoDAO medio_de_pago_dao = new mediodepagoDAO();
                            ArrayList<medio_de_pago> mi_medio_de_pago = medio_de_pago_dao.ListadoMedioDePago("");
                            out.println("<select class='form-control' id='SelectidMedioDePago' size='1'>");
                            out.println("<option onclick='setmedio_de_pago_idMedioDePago(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                            for (medio_de_pago M : mi_medio_de_pago) {
                                out.println("<option onclick='setmedio_de_pago_idMedioDePago(\"" + M.getIdMedioDePago() + "\")'>" + M.getDescripcionmediodepago() + "</option>");
                            }
                            out.println("</select>");
                        %>
                    </div>
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <center><button type="submit" class="btn btn-arg">Registrar</button></center>
                </form>
            </div>
        </div>
        <!--REGISTRAR-->

        <div class="container">
            <div class="row justify-content-md-center">
                <div id="Actualizar" class="bd-example d-none">
                    <h1>Actualizar referencia de pago </h1>
                    <form action="/VISION/ActualizarReferencia" method = "post">
                        <div class ="form-group">
                            <label>Referencia de pago</label>
                            <input type="date" class="form-control" readonly name="fechadepago" value="<%=request.getParameter("fechadepago")%>"/>
                            <br>
                            <h5><strong>Medio de pago</strong></h5>
                            <input type="number" name="medio_de_pago_idMedioDePago" class="form-control" id="txt_medio_de_pago_idMedioDePago_reg" value="<%=request.getParameter("medio_de_pago")%>">
                        </div>
                        <div id="ControlRegistro" class="bd-example d-none">
                            <input type = "text" class="form-control" name="BanderaActualiza"/>
                        </div>
                        <div class="row justify-content-md-center">
                            <div class="btn-group">
                                <input type = "submit" class="btn btn-primary form-control
                                       btn btn-login" value= "Actualizar"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div id="Listado" class="container">
            <form action="/VISION/ConsultarReferencia" method="post">
                <div class="row justify-content-md-center">
                    <div id="Listado" class="bd-example">
                        <div id="ControlRegistro" class="input-group">
                            <input id ="txt_Id_Consultado" type = "text" class="form-control"
                                   name= "IdConsultado" value="<%=buscando%>" autofocus
                                   placeholder="Buscar por fecha de pago"/>
                            <button type="button" class="btn btn-primary" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"
                                    onClick="realizarBusqueda()">Buscar</button>
                        </div>
                        <div>
                            <h1>Listado referencia de pago</h1>
                            <div id="Tabla_referencia_de_pago">

                                <% referenciaDAO referencia_de_pago_dao = new referenciaDAO();
                                    ArrayList<referencia_de_pago> mi_referencia_de_pago = new ArrayList<referencia_de_pago>();
                                    mi_referencia_de_pago = referencia_de_pago_dao.ListadoReferenciaDePago(buscando);
                                    out.println("<table class='table table-dark'><tr><td>fecha de pago</td><td>medio de pago</td><td>Editar</td><td>Eliminar</td></tr>");
                                    for (referencia_de_pago R : mi_referencia_de_pago) {
                                        out.println("<tr>");
                                        out.println("<td>" + R.getFechadepago() + "</td>");
                                         out.println("<td>" + R.getMedio_de_pago_idMedioDePago() + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-primary form-control btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + R.getFechadepago() + ")'/>"
                                                + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-warning form-control btn btn-login' value= 'Eliminar'name='Eliminar'onclick='SetIdConsulta(" + R.getFechadepago() + ")'/>"
                                                + "</td>");
                                        out.println("</tr>");
                                    }
                                    out.println("</table>");
                                %>
                            </div>  
                        </div>       
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
