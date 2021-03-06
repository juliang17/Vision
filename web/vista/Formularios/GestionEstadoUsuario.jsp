
<%@page import="modelo.estado_usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.estado_usuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarEstadousuario.js" type="text/javascript"></script>
        <title>Estado usuario</title>
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
            <div class="container">
                <h1>Registrar Estado Usuario</h1>
                <form action="/VISION/RegistroEstadoUsuario" method="post" onsubmit="return validarEstadoUsuario()" >
                    <div class="form-row" >
                        <div class="form-group col-md-12" >
                            <h2>Estado usuario:</h2>
                            <input type="text" name="descripcionestadousuario" class="form-control" placeholder="Digite el estado del usuario" id="txt_descripcionestadousuario_Reg">
                        </div> 
                    </div>
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <center><button type="submit" class="btn btn-info">Registrar</button></center>
                </form>
            </div>
        </div>

        <!--REGISTRAR-->

        <!--Actualizar-->

        <div class="container">
            <div class="row justify-content-md-center">
                <div id="Actualizar" class="bd-example d-none">
                    <h1>Actualizar estado usuario</h1>
                    <form action="/VISION/ActualizarEstadoUsuario" method = "post">
                        <div class ="form-group">
                            <label>Estado usuario</label>
                            <input type="text" class="form-control" readonly name="descripcionestadousuario" value="<%=request.getParameter("descripcionestadousuario")%>"/>
                        </div>
                        <div id="ControlRegistro" class="bd-example d-none">
                            <input type = "text" class="form-control" name="BanderaActualiza"/>
                        </div>
                        <div class="row justify-content-md-center">
                            <div class="btn-group">
                                <button type="submit" class="btn btn-success">Actualizar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!--Actualizar-->

        <!--Listar-->

        <div id="Listado" class="container">
            <form action="/VISION/ConsultarEstadoUsuario" method="post">
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
                            <h1>Listado estado usuario</h1>
                            <div id="Tabla_estado_usuario">

                                <% estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
                                    ArrayList<estado_usuario> miestado = new ArrayList<estado_usuario>();
                                    miestado = miestadousuarioDAO.Consultarlistadoestado_usuario(buscando , buscando);
                                    out.println("<table class='table table-dark'><tr><td>Descripcion</td><td>Editar</td><td>Eliminar</td></tr>");
                                    for (estado_usuario E : miestado) {
                                        out.println("<tr>");
                                        out.println("<td>" + E.getDescripcionestadousuario() + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-primary form-control btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + E.getIdestadousuario() + ")'/>"
                                                + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-warning form-control btn btn-login' value= 'Eliminar'name='Eliminar'onclick='SetIdConsulta(" + E.getIdestadousuario() + ")'/>"
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
                            <!--Listar-->
    </body>
</html>
