
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
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

        <div id="Registrar" class="bd-example d-none">
            <div class="container">
                <h1>Registrar Productos</h1>
                <br>
                <br>
                <form action="/VISION/RegistroProductos" method="post" onsubmit="return validacionProducto()" >
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                            <h2>Nombre del producto:</h2>
                            <input type="text" name="nombreproducto" class="form-control" id="nombreproducto">
                        </div>
                        <div class="form-group col-md-6" >
                            <h2>Cantidad del producto:</h2>
                            <input type="number" name="cantidadproducto" class="form-control"  id="cantidadproducto">
                        </div>
                    </div>
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                            <h2>Iva:</h2>
                            <input type="number" name="ivaproducto" class="form-control" id="ivaproducto">
                        </div>
                        <div class="form-group col-md-6" >
                            <h2>Descripción:</h2>
                            <input type="text" name="descripcionproducto" class="form-control" id="descripcionproducto">
                        </div>
                    </div>
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                            <h2>Referencia Producto:</h2>
                            <input type="number" name="referenciaproducto" class="form-control" id="referenciaproducto">
                        </div>
                        <div class="form-group col-md-6" >
                            <h2>Precio:</h2>
                            <input type="number" name="precio" class="form-control" id="precio">
                        </div>
                    </div>
                    <div class="form-row" >

                        <div class="form-group col-md-6" >
                            <h2>Categoria:</h2>
                            <input type="number" name="categorias_idcategorias" class="form-control d-none" id="categorias_idcategorias">

                            <%
                                categoriasDAO categorias_dao = new categoriasDAO();
                                ArrayList<categorias> mi_categorias = categorias_dao.listadocategorias(buscando);
                                out.println("<select class='form-control'id ='SelectCategoria' size = '1' >");
                                out.println("<option onclick='setCtegoria(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");

                                for (categorias C : mi_categorias) {
                                    out.println("<option onclick='setCtegoria(\"" + C.getIdcategorias() + "\")'>" + C.getDescripcioncategorias() + "</option>");

                                }
                                out.println("</select>");
                            %>
                        </div>
                        <div class="form-group col-md-6" >
                            <h2>Marca:</h2>
                            <input type="number" name="marca_idmarca" class="form-control d-none" id="marca_idmarca">

                            <%  MarcaDAO quipoDao = new MarcaDAO();
                                ArrayList<marca> miequipo = quipoDao.listadomarca("");
                                out.println("<select class='form-control'id ='SelectMarca' size = '1' >");
                                out.println("<option onclick='setMarca(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");

                                for (marca C : miequipo) {
                                    out.println("<option onclick='setMarca(\"" + C.getIdmarca() + "\")'>" + C.getDescripcionmarca() + "</option>");

                                }

                                out.println("</select>");
                            %>
                        </div>
                    </div>

                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                            <h2>proveedor:</h2>
                            <input type="number" name="proveedores_idproveedores" class="form-control d-none" id="proveedores_idproveedores">

                            <%  ProveedoresDAO pdao = new ProveedoresDAO();
                                ArrayList<proveedores> p = pdao.listadoproveedores("", "", "");
                                out.println("<select class='form-control'id ='SelectP' size = '1' >");
                                out.println("<option onclick='setp(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");

                                for (proveedores C : p) {
                                    out.println("<option onclick='setp(\"" + C.getIdProveedores() + "\")'>" + C.getNombreproveedores() + "</option>");

                                }

                                out.println("</select>");
                            %>
                        </div>
                        <div class="form-group col-md-6" >
                            <input type="number" name="unidad_de_medida_idunidadmedida" value="1" class="form-control d-none" id="unidad_de_medida_idunidadmedida">   
                        </div>
                    </div>
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <center><button type="submit" class="btn btn-arg">Registrar</button></center>
                </form>
            </div>
        </div>

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
                            <h2>proveedor:</h2>
                            <input type="number" readonly="" name="proveedores_idproveedores" class="form-control " id="proveedores_idproveedores" value="<%=request.getParameter("Proveedor")%>">
                        </div>
                        <div class="form-group col-md-6" >
                            <input type="number" readonly="" name="unidad_de_medida_idunidadmedida" class="form-control" id="unidad_de_medida_idunidadmedida" value="<%=request.getParameter("Unidad")%>">   
                        </div>
                    </div>
                    <center><button type="submit" class="btn btn-danger">Actualizar</button></center>
                </form>
            </div>
        </div>
      
        <div id="Listado" class="bd-example form-row">
            <div class="container">

                <form action="/VISION/ConsultarProductos" method="post">
                    <div class="row justify-content-md-center">
                        <div id="Listado" class="bd-example">

                            <div id="ControlRegistro" class="input-group">
                                <input id="txt_Id_Consultado" type="text" class="form-control input-1" name="IdConsultado" value="<%=buscando%>" autofocus placeholder="Buscar por referencia o nombre del producto"/>
                                <button type="button" class="btn btn-info-1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                            </div>

                            <div>
                                <h2>Listado Productos</h2>

                                <%
                                    ProductoDAO prdao = new ProductoDAO();
                                    ArrayList<productos> pList = new ArrayList<productos>();
                                    pList = prdao.listadoproductos(buscando, buscando);
                                    out.println("<table class='table table-light table-striped table-hover table-bordered border-danger'><tr><td>Referencia</td><td>Nombre</td><td>Cantidad</td><td>IVA</td><td>Descripción</td><td>Precio</td><td>Categoria</td><td>Marca</td><td>Unidad de medida</td><td>Proveedor</td><td>Actualizar</td><td>Eliminar</td>");

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
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-secondary' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + C.getReferenciaproducto() + ")'/>" + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-danger' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + C.getReferenciaproducto() + ")'/>" + "</td>");
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
    </body>
</html>

