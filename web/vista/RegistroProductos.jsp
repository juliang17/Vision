
<%@page import="modelo.estado_producto"%>
<%@page import="controlador.estado_productoDAO"%>
<%@page import="modelo.unidad_de_medida"%>
<%@page import="controlador.UnidadDeMedidaDAO"%>
<%@page import="modelo.productos"%>
<%@page import="controlador.ProductoDAO"%>
<%@page import="modelo.proveedores"%>
<%@page import="controlador.ProveedoresDAO"%>
<%@page import="modelo.marca"%>
<%@page import="modelo.marca"%>
<%@page import="controlador.MarcaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.categorias"%>
<%@page import="controlador.categoriasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="Javascript/validarProductos.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/4d836167dd.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/usuarios.css" rel="stylesheet" type="text/css"/>
        <title>Productos</title>
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
                            <a class="nav-link" aria-current="page" href="RegistroProveedores.jsp">Gestión proveedores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Formularios/GestionEstadoProducto.jsp">Gestión estado producto</a>
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
            <h1>Registrar Productos</h1>
            <br>
            <form action="/VISION/RegistroProductos" method="post" onsubmit="return validacionProducto()" class="row g-3">
                <div class="form-floating col-md-12" >
                    <input type="text" name="nombreproducto" class="form-control" placeholder="" id="nombreproducto">
                    <label for="floatingInput">Nombre del producto</label>
                </div>
                <div class="form-floating col-md-6" >
                    <input type="number" name="cantidadproducto" class="form-control" placeholder="" id="cantidadproducto">
                    <label for="floatingInput">Cantidad</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="number" name="ivaproducto" class="form-control" placeholder="" id="ivaproducto">
                    <label for="floatingInput">Iva</label>
                </div>
                <div class="form-floating col-md-12" >
                    <input type="text" name="descripcionproducto" class="form-control" placeholder="" id="descripcionproducto">
                    <label for="floatingInput">Descripcion producto</label>
                </div>
                <div class="form-floating col-md-6" >
                    <input type="number" name="referenciaproducto" class="form-control" placeholder="" id="referenciaproducto">
                    <label for="floatingInput">Referencia producto</label>
                </div>
                <div class="form-floating col-md-6" >
                    <input type="number" name="precio" class="form-control" placeholder="" id="precio">
                    <label for="floatingInput">Precio</label>
                </div>
                <div class="form-floating col-md-6" >
                    <input type="number" name="categorias_idcategorias" class="form-control d-none" id="categorias_idcategorias">

                    <%
                        categoriasDAO categorias_dao = new categoriasDAO();
                        ArrayList<categorias> mi_categorias = categorias_dao.Listadocategorias("", "");
                        out.println("<select class='form-control'id ='SelectCategoria' size = '1' >");
                        out.println("<option onclick='setCtegoria(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");

                        for (categorias C : mi_categorias) {
                            out.println("<option onclick='setCtegoria(\"" + C.getIdcategorias() + "\")'>" + C.getDescripcioncategorias() + "</option>");

                        }
                        out.println("</select>");
                    %>
                    <label for="floatingInput">Categoria</label>
                </div>
                <div class="form-floating col-md-6" >
                    <input type="number" name="marca_idmarca" class="form-control d-none" id="marca_idmarca">

                    <%  MarcaDAO quipoDao = new MarcaDAO();
                        ArrayList<marca> miequipo = quipoDao.ConsultarListadoMarca("", "");
                        out.println("<select class='form-control'id ='SelectMarca' size = '1' >");
                        out.println("<option onclick='setMarca(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");

                        for (marca C : miequipo) {
                            out.println("<option onclick='setMarca(\"" + C.getIdmarca() + "\")'>" + C.getDescripcionmarca() + "</option>");

                        }

                        out.println("</select>");
                    %>
                    <label for="floatingInput">Marca</label>
                </div>
                <div class="form-floating col-md-6" >
                    <input type="number" name="proveedores_idproveedores" class="form-control d-none" id="proveedores_idproveedores">

                    <%  ProveedoresDAO pdao = new ProveedoresDAO();
                        ArrayList<proveedores> p = pdao.ListarProveedor("", "", "");
                        out.println("<select class='form-control'id ='SelectP' size = '1' >");
                        out.println("<option onclick='setp(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");

                        for (proveedores C : p) {
                            out.println("<option onclick='setp(\"" + C.getIdProveedores() + "\")'>" + C.getNombreproveedores() + "</option>");

                        }

                        out.println("</select>");
                    %>
                    <label for="floatingInput">Proveedor</label>
                </div>
                <div class="form-floating col-md-6" >
                    <input type="number" name="unidad_de_medida_idunidadmedida" value="1" class="form-control d-none" id="unidad_de_medida_idunidadmedida">  
                    <%  UnidadDeMedidaDAO unidadDao = new UnidadDeMedidaDAO();
                        ArrayList<unidad_de_medida> U = unidadDao.listadounidaddemedida("", "");
                        out.println("<select class='form-control'id ='SelectP' size = '1' >");
                        out.println("<option onclick='setUnidad(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");

                        for (unidad_de_medida C : U) {
                            out.println("<option onclick='setUnidad(\"" + C.getIdunidadmedida() + "\")'>" + C.getDescripcionunidadmedida() + "</option>");

                        }

                        out.println("</select>");
                    %>
                    <label for="floatingInput">Unidad de medida</label>
                </div>
                <div class="form-floating col-md-6" >
                    <input type="number" name="estado_producto_idestado_producto" value="1" class="form-control d-none" id="estado_producto_idestado_producto">  
                    <%  estado_productoDAO estadoPDAO = new estado_productoDAO();
                        ArrayList<estado_producto> estadoP = estadoPDAO.ConsultarListadoEstadoProducto(buscando, buscando);
                        out.println("<select class='form-control'id ='SelectP' size = '1' >");
                        out.println("<option onclick='setEstado(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");

                        for (estado_producto E : estadoP) {
                            out.println("<option onclick='setEstado(\"" + E.getIdestado_producto() + "\")'>" + E.getDescripcionEstadoProducto() + "</option>");

                        }

                        out.println("</select>");
                    %>
                    <label for="floatingInput">Estado producto</label>
                </div>    
                <div id="ControlRegistro" class="bd-example d-none">
                    <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                </div>
                <button type="submit" class="btn btn-success">Registrar</button>
            </form>
        </div>
    </div>

    <!--REGISTRAR-->

    <!--ACTUALIZAR-->

    <div id="Actualizar" class="bd-example d-none">
        <div class="container">
            <h1>Actualizar Productos</h1>
            <br>
            <br>                              
            <form action="/VISION/ActualizarProducto" method="post">
                <div class="form-row" >
                    <div class="form-group col-md-6" >
                        <h2>Nombre del producto:</h2>
                        <input type="text" name="nombreproducto" class="form-control" id="nombreproducto" value="<%=request.getParameter("Nombres")%>">
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Cantidad del producto:</h2>
                        <input type="number" name="cantidadproducto" class="form-control"  id="cantidadproducto" value="<%=request.getParameter("Cantidad")%>">
                    </div>
                </div>
                <div class="form-row" >
                    <div class="form-group col-md-6" >
                        <h2>Iva:</h2>
                        <input type="number" name="ivaproducto" class="form-control" id="ivaproducto" value="<%=request.getParameter("Iva")%>">
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Descripción:</h2>
                        <input type="text" name="descripcionproducto" class="form-control" id="descripcionproducto" value="<%=request.getParameter("Descripcion")%>">
                    </div>
                </div>
                <div class="form-row" >
                    <div class="form-group col-md-6" >
                        <h2>Referencia Producto:</h2>
                        <input type="number" readonly="" name="referenciaproducto" class="form-control" id="referenciaproducto" value="<%=request.getParameter("Referencia")%>">
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Precio:</h2>
                        <input type="number" name="precio" class="form-control" id="precio" value="<%=request.getParameter("Precio")%>">
                    </div>
                </div>
                <div class="form-row" >

                    <div class="form-group col-md-6" >
                        <h2>Categoria:</h2>
                        <input type="number" readonly="" name="categorias_idcategorias" class="form-control " id="categorias_idcategorias" value="<%=request.getParameter("Categoria")%>">
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Marca:</h2>
                        <input type="number" readonly="" name="marca_idmarca" class="form-control " id="marca_idmarca" value="<%=request.getParameter("Marca")%>">
                    </div>
                </div>
                <div class="form-row" >
                    <div class="form-group col-md-6" >
                        <h2>Proveedor:</h2>
                        <input type="number" readonly="" name="proveedores_idproveedores" class="form-control " id="proveedores_idproveedores" value="<%=request.getParameter("Proveedor")%>">
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Unidad de medida:</h2>
                        <input type="number" readonly="" name="unidad_de_medida_idunidadmedida" class="form-control" id="unidad_de_medida_idunidadmedida" value="<%=request.getParameter("Unidad")%>">   
                    </div>
                    <div class="form-group col-md-6" >
                        <h2>Estado Producto:</h2>
                        <input type="number" readonly="" name="estado_producto_idestado_producto" class="form-control" id="estado_producto_idestado_producto" value="<%=request.getParameter("estadoP")%>">   
                    </div>
                </div>
                <br>
                <center><button type="submit" class="btn btn-success">Actualizar</button></center>
            </form>
        </div>
    </div>
    <br>
    <div id="Listado" class="bd-example form-row">
        <div class="container">

            <!--CONSULTAR-->

            <form action="/VISION/ConsultarProductos" method="post">
                <div class="row justify-content-md-center">
                    <div id="Listado" class="bd-example">

                        <div id="ControlRegistro" class="input-group">
                            <input id="txt_Id_Consultado" type="text" class="form-control input-1" name="IdConsultado" value="<%=buscando%>" autofocus placeholder="Buscar por referencia o nombre del producto"/>
                            <button type="button" class="btn btn-primary" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                        </div>
                        <!--CONSULTAR-->

                        <!--LISTAR-->

                        <div>
                            <h2>Listado Productos</h2>

                            <%
                                ProductoDAO prdao = new ProductoDAO();
                                ArrayList<productos> pList = new ArrayList<productos>();
                                pList = prdao.listadoproductos(buscando, buscando);
                                out.println("<table class='table table-dark table-striped table-hover table-bordered'><tr><td>Referencia</td><td>Nombre</td><td>Cantidad</td><td>IVA</td><td>Descripción</td><td>Precio</td><td>Categoria</td><td>Marca</td><td>Unidad de medida</td><td>Proveedor</td><td>Estado Producto</td><td>Actualizar</td><td>Eliminar</td>");

                                for (productos C : pList) {

                                    out.println("<tr>");
                                    out.println("<td>" + C.getReferenciaproducto() + "</td>");
                                    out.println("<td>" + C.getNombreproducto() + "</td>");
                                    out.println("<td>" + C.getCantidadproducto() + "</td>");
                                    out.println("<td>" + C.getIvaproducto() + "</td>");
                                    out.println("<td>" + C.getDescripcionproducto() + "</td>");
                                    out.println("<td>" + C.getPrecio() + "</td>");
                                    out.println("<td>" + C.getCategorias_idcategorias() + "</td>");
                                    out.println("<td>" + C.getMarca_idmarca() + "</td>");
                                    out.println("<td>" + C.getUnidad_de_medida_idunidadmedida() + "</td>");
                                    out.println("<td>" + C.getProveedores_idproveedores() + "</td>");
                                    out.println("<td>" + C.getEstado_producto_idestado_producto() + "</td>");
                                    out.println("<td>" + "<button type = 'submit' class='btn btn-primary btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + C.getReferenciaproducto() + ")'/>" + "" + "<i class='fas fa-pencil-alt'></i>" + "</button>" + "</td>");
                                    out.println("<td>" + "<button type = 'submit' class='btn btn-danger btn btn-login' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + C.getReferenciaproducto() + ")'/>" + "" + "<i class='fas fa-trash-alt'></i>" + "</button>" + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</table>");
                            %>

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!--LISTAR-->
</body>
</html>

