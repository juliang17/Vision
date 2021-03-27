

<%@page import="controlador.ProveedoresDAO"%>
<%@page import="modelo.proveedores"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="../Javascript/validarProveedores.js"></script>        
        <script src="../Javascript/realizarBusquedaP.js"></script>        

        <title>proveedores</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        
        <div class="row justify-content-md-center">
            <div class="btn-group">
                <button type="button" class="btn btn-dark" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Registrar')">
                    Registrar
                </button>
                <button type="button" class="btn btn-dark" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Listado')">
                    Consultar
                </button>
                <button type="button" class="btn btn-dark" ><a href="" class="text-decoration-none">Volver al inicio</a></button>
            </div>
        </div>

       <div id="Registrar" class="d-none">
            <h1>Registro Proveedor</h1>
            <br>
            <br>
            <form action="/Vision-master/RegistroProveedores" method="post" onsubmit="return validarProveedores()" >
                <div class="form-row" >
                    <div class="form-group col-md-6" >
                        <h1>Número de Identificación:</h1>
                        <input type="text" name="identificacionproveedores" class="form-control" id="identificacion">
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Nombre:</h2>
                        <input type="text" name="nombreproveedores" class="form-control" id="nombre">
                    </div>
                </div>
                <div class="form-row" >
                    <div class="form-group col-md-6" >
                        <h2>Correo electrónico:</h2>
                        <input type="text" name="correoproveedores" class="form-control" id="correo">
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Número telefónico:</h2>
                        <input type="text" name="telefonoproveedores" class="form-control" id="telefono">
                    </div>
                </div>
                <div id="controlRegistro" class="bd-example d-none">
                     <input id="txt_bandera_reg" type="text" class="form-control" name="banderaRegistro">
                </div>
                <center><button type="submit" class="btn btn-primary">Registrar</button></center>
            </form>
        </div>

       <div id="Actualizar" class="container d-none">
            <h1>Actualizar Proveedor</h1>
            <br>
            <br>
            <form action="/Vision-master/ActualizarProveedores" method="post">
                <div class="form-row" >
                    <div class="form-group col-md-6" >
                        <h1>Número de Identificación:</h1>
                        <input type="text" name="identificacionproveedores" class="form-control" id="identificacion" value="<%=request.getParameter("Identificacion")%>">
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Nombre:</h2>
                        <input type="text" name="nombreproveedores" class="form-control" id="nombre" value="<%=request.getParameter("Nombres")%>">
                    </div>
                </div>
                <div class="form-row" >
                    <div class="form-group col-md-6" >
                        <h2>Correo electrónico:</h2>
                        <input type="text" name="correoproveedores" class="form-control" id="correo" value="<%=request.getParameter("Correo")%>">
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Número telefónico:</h2>
                        <input type="text" name="telefonoproveedores" class="form-control" id="telefono" value="<%=request.getParameter("Telefono")%>">
                    </div>
                </div>
                <center><button type="submit" class="btn btn-primary">Registrar</button></center>
            </form>
        </div>

        <div id="Listado" class="container">
            <form action="/Vision-master/ConsultarProveedor" method="post">
                <div class="row justify-content-md-center">
                        <div id="ControlRegistro" class="input-group">
                            <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="" placeholder="Ingrese identificación o nombres"/>
                            <button type="button" class="btn btn-arg" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                        </div>    
                            <br>
                        <div>
                            <h2 class="title-table">Listado Proveedores</h2>
                            <%
                                ProveedoresDAO pdao = new ProveedoresDAO();
                                ArrayList<proveedores> pList = new ArrayList<proveedores>();
                                pList = pdao.listadoproveedores("", "", "");
                                out.println("<table class='table table-light table-striped table-hover table-borderless border-dark'><tr><td>Nombre</td><td>Identificación</td><td>Telefono</td><td>Correo</td><td>Actualizar</td><td>Eliminar</td>");

                                for (proveedores P : pList) {

                                    out.println("<tr>");
                                    out.println("<td>" + P.getNombreproveedores()+ "</td>");
                                    out.println("<td>" + P.getIdentificacionproveedores()+ "</td>");
                                    out.println("<td>" + P.getTelefonoproveedores() + "</td>");
                                    out.println("<td>" + P.getCorreoproveedores() + "</td>");

                                    out.println("<td>" + "<input type = 'submit' class='btn btn-secondary btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + P.getIdentificacionproveedores()+ ")'/>" + "</td>");
                                    out.println("<td>" + "<input type = 'submit' class='btn btn-danger btn btn-login' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + P.getIdentificacionproveedores()+ ")'/>" + "</td>");
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

