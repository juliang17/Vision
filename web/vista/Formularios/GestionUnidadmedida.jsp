
<%@page import="modelo.unidad_de_medida"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.UnidadDeMedidaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarUnidadmedida.js" type="text/javascript"></script>
        <title>Unidad de medida</title>
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
            <h1>Registro unidad de medida</h1>      
            <form action="/VISION/RegistroUnidadmedida" method="post" onsubmit="return RegistroUnidadmedida()">
                <h5>Descripcion </h5>
                <input type="text" name="descripcionunidadmedida" class="form-control" placeholder="descripcion unidad de medida" id="txt_descripcionunidadmedida_reg"> 
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
                    <h1>Actualizar unidad de medida</h1>
                    <form action="/VISION/ActualizarUnidadmedida" method = "post">
                        <div class ="form-group">
                            <label>Unidad de medida</label>
                            <input type="text" class="form-control" readonly name="descripcionunidadmedida" value="<%=request.getParameter("descripcionunidadmedida")%>"/>
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
            <form action="/VISION/ConsultarUnidadmedida" method="post">
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
                            <h1>Listado unidad de medida</h1>
                            <div id="Tabla_categorias">

                                <% UnidadDeMedidaDAO miunidadmedidaDAO = new UnidadDeMedidaDAO();
                                    ArrayList<unidad_de_medida> milistaunidadmedida = new ArrayList<unidad_de_medida>();
                                    milistaunidadmedida = miunidadmedidaDAO.listadounidaddemedida(buscando);
                                    out.println("<table class='table table-dark'><tr><td>Descripcion</td><td>Editar</td><td>Eliminar</td></tr>");
                                    for (unidad_de_medida U : milistaunidadmedida) {
                                        out.println("<tr>");
                                        out.println("<td>" + U.getDescripcionunidadmedida() + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-primary form-control btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + U.getDescripcionunidadmedida() + ")'/>"
                                                + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-warning form-control btn btn-login' value= 'Eliminar'name='Eliminar'onclick='SetIdConsulta(" + U.getDescripcionunidadmedida() + ")'/>"
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
