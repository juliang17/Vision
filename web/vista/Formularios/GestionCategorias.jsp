
<%@page import="modelo.categorias"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.categoriasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarCategorias.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/4d836167dd.js" crossorigin="anonymous"></script>
        <link href="../css/usuarios.css" rel="stylesheet" type="text/css"/>
        <title>Categorias</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="../../PaginaPrincipal.jsp">MAXILINI</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionMarca.jsp">Gestión marca</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionUnidadmedida.jsp">Gestión unidad de medida</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="../RegistroProveedores.jsp">Gestión proveedores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionEstadoProducto.jsp">Gestión estado producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="../RegistroProductos.jsp">Gestión productos</a>
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
        <!--REGISTRAR-->
        <div id="Registrar" class="container bd-example d-none">
            <h1>Registrar categorias</h1>
            <br>
            <form action="/VISION/RegistroCategoria" method="post" onsubmit="return validarCategoria()" class="row g-3">
                <div class="form-floating col-md-6">
                    <input type="text" name="descripcioncategorias" class="form-control" placeholder="" id="txt_descripcioncategorias_Reg">
                    <label for="floatingInput">Categoria</label>
                </div> 
                <div id="ControlRegistro" class="bd-example d-none">
                    <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                </div>
                <button type="submit" class="btn btn-success">Registrar</button>
            </form>
        </div>
    </div>
    <!--REGISTRAR-->

    <div id="Actualizar" class="bd-example d-none">
        <h1>Actualizar categorias</h1>
        <form action="/VISION/ActualizarCategorias" method="post">
            <div class="form-row" >
                <div class="form-group col-md-6" >
                    <h2>ID:</h2>
                    <input type="text" name="idcategorias" class="form-control" value="<%=request.getParameter("ID")%>">
                </div> 
                <div class="form-group col-md-6" >
                    <h2>Categoria:</h2>
                    <input type="text" name="descripcioncategorias" class="form-control" id="txt_descripcioncategorias_Reg" value="<%=request.getParameter("descripcioncategorias")%>">
                </div> 
            </div>
            <center><button type="submit" class="btn btn-arg">Actualizar</button></center>
        </form>
    </div>
</div>
<br>
<div id="Listado" class="container">
    <form action="/VISION/ConsultarCategorias" method="post">
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
                <h1>Listado categorias</h1>
                <% categoriasDAO categorias_dao = new categoriasDAO();
                    ArrayList<categorias> milistacategorias = new ArrayList<categorias>();
                    milistacategorias = categorias_dao.Listadocategorias(buscando, buscando);
                    out.println("<table class='table table-dark table-striped table-hover table-bordered'><tr><td>ID</td><td>Descripcion</td><td>Editar</td><td>Eliminar</td></tr>");
                    for (categorias C : milistacategorias) {
                        out.println("<tr>");
                        out.println("<td>" + C.getIdcategorias() + "</td>");
                        out.println("<td>" + C.getDescripcioncategorias() + "</td>");
                        out.println("<td>" + "<button type = 'submit' class='btn btn-primary form-control btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + C.getIdcategorias() + ")'/>" + "" + "<i class='fas fa-pencil-alt'></i>" + "</button>" + "</td>");
                        out.println("<td>" + "<button type = 'submit' class='btn btn-danger form-control btn btn-login' value= 'Eliminar'name='Eliminar'onclick='SetIdConsulta(" + C.getIdcategorias() + ")'/>" + "" + "<i class='fas fa-trash-alt'></i>" + "</button>" + "</td>");
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
