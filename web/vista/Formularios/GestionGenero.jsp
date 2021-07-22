
<%@page import="modelo.genero"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.GeneroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarGenero.js" type="text/javascript"></script>
        <title>Genero</title>
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
        <!--REGISTRAR-->
        <div id="Registrar" class="container bd-example d-none">
                <h1>Registrar Genero usuarios</h1>
                <br>
                <form action="/VISION/RegistroGeneros" method="post" onsubmit="return validarGenero()" class="row g-3">
                        <div class="form-floating col-md-6" >
                            <input type="text" name="descripciongenero" class="form-control" placeholder="Digite el genero del usuario" id="txt_descripciongenero_Reg">
                            <label for="floatingInput">Genero</label>
                        </div> 
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <button type="submit" class="btn btn-success">Registrar</button>
                </form>
            </div>
        </div>
        <!--REGISTRAR-->

        <div class="container">
            <div class="row justify-content-md-center">
                <div id="Actualizar" class="bd-example d-none">
                    <h1>Actualizar genero</h1>
                    <form action="/VISION/ActualizarGenero" method = "post">
                        <div class ="form-group">
                            <label>Genero</label>
                            <input type="text" class="form-control" readonly name="descripciongenero" value="<%=request.getParameter("descripciongenero")%>"/>
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
            <form action="/VISION/ConsultarGenero" method="post">
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
                            <h1>Listado genero</h1>

                                <% GeneroDAO migeneroDAO = new GeneroDAO();
                                    ArrayList<genero> migenero = new ArrayList<genero>();
                                    migenero = migeneroDAO.Listadogenero(buscando, buscando);
                                    out.println("<table class='table table-dark table-striped table-hover table-bordered'><tr><td>ID</td><td>Descripcion</td><td>Editar</td><td>Eliminar</td></tr>");
                                    for (genero G : migenero) {
                                        out.println("<tr>");
                                        out.println("<td>" + G.getIdgenero()+ "</td>");
                                        out.println("<td>" + G.getDescripciongenero() + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-primary form-control btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + G.getIdgenero()+ ")'/>"
                                                + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-danger form-control btn btn-login' value= 'Eliminar'name='Eliminar'onclick='SetIdConsulta(" + G.getIdgenero()+ ")'/>"
                                                + "</td>");
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
