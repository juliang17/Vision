
<%@page import="modelo.tipo_documento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.tipo_documentoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarTipoDocumento.js" type="text/javascript"></script>
        <title>Tipo documento</title>
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
        <div id="Registrar" class="d-none">
            <h1>Registro tipo de documento</h1>      
            <form action="/VISION/RegistroTipoDoc" method="post" onsubmit="return RegistroTipodocumento()">
                <h5>Descripcion </h5>
                <input type="text" name="descripciontipodoc" class="form-control" placeholder="Descripcion" id="txt_descripciontipodoc_reg"> 
                <br>
                <div id="controlRegistro" class="bd-example d-none">
                    <input id="txt_bandera_reg" type="text" class="form-control" name="banderaRegistro">
                </div>
                <button type="submit" class="btn btn-success">Registrar</button>     
            </form>         
        </div>

        <div class="container">
            <div class="row justify-content-md-center">
                <div id="Actualizar" class="bd-example d-none">
                    <h1>Actualizar Tipo documento</h1>
                    <form action="/VISION/ActualizarTipodocumento" method = "post">
                        <div class ="form-group">
                            <label>Tipo documento</label>
                            <input type="text" class="form-control" readonly name="descripciontipodoc" value="<%=request.getParameter("descripciontipodoc")%>"/>
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
            <form action="/VISION/ConsultarTipodocumento" method="post">
                <div class="row justify-content-md-center">
                    <div id="Listado" class="bd-example">
                        <div id="ControlRegistro" class="input-group">
                            <input id ="txt_Id_Consultado" type = "text" class="form-control"
                                   name= "IdConsultado" value="<%=buscando%>" autofocus
                                   placeholder="Buscar por Descripcion"/>
                            <button type="button" class="btn btn-primary" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"
                                    onClick="realizarBusqueda()">Buscar</button>
                        </div>
                        <div>
                            <h1>Listado Tipo documento</h1>
                            <div id="Tabla_tipo_documento">

                                <% tipo_documentoDAO mitipodocDAO = new tipo_documentoDAO();
                                   ArrayList<tipo_documento> mitipodoc = new ArrayList<tipo_documento>();
                                    mitipodoc = mitipodocDAO.Consultarlistadotipo_documento(buscando);
                                    out.println("<table class='table table-dark'><tr><td>Descripcion</td><td>Editar</td><td>Eliminar</td></tr>");
                                    for (tipo_documento T : mitipodoc) {
                                        out.println("<tr>");
                                        out.println("<td>" + T.getdescripciontipodoc() + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-primary form-control btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + T.getdescripciontipodoc() + ")'/>"
                                                + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-warning form-control btn btn-login' value= 'Eliminar'name='Eliminar'onclick='SetIdConsulta(" + T.getdescripciontipodoc() + ")'/>"
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
