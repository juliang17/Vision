<%@page import="modelo.tipo_mov"%>
<%@page import="controlador.tipo_movDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarTipoMov.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/4d836167dd.js" crossorigin="anonymous"></script>
        <title>Tipo de movimiento</title>
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
                <h1>Registrar tipo de movimiento</h1>
                <br>
                <form action="/VISION/RegistrarTipoMov" method="post" onsubmit="return validarTipoMov()" class="row g-3">
                        <div class="form-floating col-md-6" >
                            <input type="text" name="descripcionTipoMov" class="form-control" placeholder="Digite el tipo de movimiento" id="txt_descripcionTipoMov_Reg">
                            <label for="floatingInput">Tipo de movimiento</label>
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
                    <h1>Actualizar tipo de movimiento</h1>
                    <form action="/VISION/ActualizarTipoMov" method = "post">
                        <div class ="form-group">
                            <label>Tipo de movimiento</label>
                            <input type="text" class="form-control" readonly name="descripcionTipoMov" value="<%=request.getParameter("descripcionTipoMov")%>"/>
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
            <form action="/VISION/ConsultarTipoMov" method="post">
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
                            <h1>Listado tipo de movimiento</h1>
                            <div id="Tabla_tipo_mov">

                                <% tipo_movDAO miTipoMovDAO = new tipo_movDAO();
                                    ArrayList<tipo_mov> miTipoMov = new ArrayList<tipo_mov>();
                                    miTipoMov = miTipoMovDAO.ListadoTipoMov(buscando, buscando);
                                    out.println("<table class='table table-dark table-striped table-hover table-bordered'><tr><td>Descripcion</td><td>Editar</td><td>Eliminar</td></tr>");
                                    for (tipo_mov T : miTipoMov) {
                                        out.println("<tr>");
                                        out.println("<td>" + T.getDescripcionTipoMov() + "</td>");
                                        out.println("<td>" + "<button type = 'submit' class='btn btn-primary form-control btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + T.getId_tipo_mov() + ")'/>" + "" + "<i class='fas fa-pencil-alt'></i>" + "</button>" + "</td>");
                                        out.println("<td>" + "<button type = 'submit' class='btn btn-danger form-control btn btn-login' value= 'Eliminar'name='Eliminar'onclick='SetIdConsulta(" + T.getId_tipo_mov() + ")'/>" + "" + "<i class='fas fa-trash-alt'></i>" + "</button>" + "</td>");
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
