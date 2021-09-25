

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
        <script src="Javascript/validarProveedor.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/4d836167dd.js" crossorigin="anonymous"></script>
        <link href="css/usuarios.css" rel="stylesheet" type="text/css"/>
        <title>Proveedores</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="../PaginaPrincipal.jsp">MAXILINI</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Formularios/GestionCategorias.jsp">Gestión categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Formularios/GestionMarca.jsp">Gestión marca</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Formularios/GestionUnidadmedida.jsp">Gestión unidad de medida</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Formularios/GestionEstadoProducto.jsp">Gestión estado producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="RegistroProductos.jsp">Gestión productos</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="row justify-content-md-center menu">
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
            <h1>Registrar Proveedor</h1>
            <br>
            <form action="/VISION/RegistroProveedores" method="post" onsubmit="return validarProveedores()" class="row g-3">
                    <div class="form-floating col-md-6">
                        <input type="text" name="identificacionproveedores" class="form-control" placeholder="" id="identificacion">
                        <label for="floatingInput">Numero de identificacion</label>
                    </div>
                    <div class="form-floating col-md-6" >
                        <input type="text" name="nombreproveedores" class="form-control" placeholder="" id="nombre">
                        <label for="floatingInput">Nombre de proveedor</label>
                    </div>
                    <div class="form-floating col-md-6" >
                        <input type="text" name="correoproveedores" class="form-control" placeholder="" id="correo">
                        <label for="floatingInput">Correo</label>
                    </div>
                    <div class="form-floating col-md-6" >
                        <input type="text" name="telefonoproveedores" class="form-control" placeholder="" id="telefono">
                        <label for="floatingInput">Telefono</label>
                    </div>
                <div id="controlRegistro" class="bd-example d-none">
                     <input id="txt_bandera_reg" type="text" class="form-control" name="banderaRegistro">
                </div>
                <div class="d-grid gap-2 col-6 mx-auto">
                <button type="submit" class="btn btn-success">Registrar</button>
                </div>
            </form>
        </div>

       <div id="Actualizar" class="container d-none">
            <h1>Actualizar Proveedor</h1>
            <br>
            <br>
            <form action="/VISION/ActualizarProveedores" method="post">
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
                <center><button type="submit" class="btn btn-primary">Actualizar</button></center>
            </form>
        </div>
                    <br>
        <div id="Listado" class="container">
            <form action="/VISION/ConsultarProveedor" method="post">
                <div class="row justify-content-md-center">
                        <div id="ControlRegistro" class="input-group">
                            <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="" placeholder="Ingresar número de identificación"/>
                            <button type="button" class="btn btn-primary" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                        </div>    
                            <br>
                        <div>
                            <h2 class="title-table">Listado Proveedores</h2>
                            <div id="Tabla_Proveedores"></div>
                            <%
                                ProveedoresDAO proveedordao = new ProveedoresDAO();
                                ArrayList<proveedores> proveedorList = new ArrayList<proveedores>();
                                proveedorList = proveedordao.ListarProveedor(buscando, buscando, buscando);
                                out.println("<table class='table table-dark table-striped table-hover table-bordered'><tr><td>Nombre</td><td>Número de identificación</td><td>Telefono</td><td>Correo</td><td>Actualizar</td><td>Eliminar</td>");

                                for (proveedores P : proveedorList) {

                                    out.println("<tr>");
                                    out.println("<td>" + P.getNombreproveedores()+ "</td>");
                                    out.println("<td>" + P.getIdentificacionproveedores()+ "</td>");
                                    out.println("<td>" + P.getTelefonoproveedores()+ "</td>");
                                    out.println("<td>" + P.getCorreoproveedores()+ "</td>");

                                    out.println("<td>" + "<button type = 'submit' class='btn btn-primary btn btn-login' value=''name='Actualizar'onclick='SetIdConsulta(" + P.getIdentificacionproveedores()+ ")'/>" + "" + "<i class='fas fa-pencil-alt'></i>" + "</button>" + "</td>");
                                    out.println("<td>" + "<button type = 'submit' class='btn btn-danger btn btn-login' value=''name='Eliminar'onclick='SetIdConsulta(" + P.getIdentificacionproveedores()+ ")'/>" + "" + "<i class='fas fa-trash-alt'></i>" + "</button>" + "</td>");
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

