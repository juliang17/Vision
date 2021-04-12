<%@page import="modelo.inventario"%>
<%@page import="modelo.productos"%>
<%@page import="controlador.ProductoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.inventarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarInventario.js" type="text/javascript"></script>
        <title>Inventario</title>
    </head>
    <body style="background-image: url('../imagenes/ropaRosada (1).jpg')" onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <!--NAV-->
        <div class="row justify-content-md-center div-nav-2">
            <div class="btn-group">
                <button type="button" class="btn btn-dark-1" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Registrar')">
                    Registrar
                </button>
                <button type="button" class="btn btn-dark-1" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Listado')">
                    Consultar
                </button>
            </div>
        </div>
        <!--NAV-->

        <!--FORMULARIO REGISTRAR-->
        <div id="Registrar" class="bd-example d-none">
            <div class="container" style="background-color: white">
                <h1>Registrar Inventario</h1>
                <form action="/VISION/RegistrarInventario" method="post" onsubmit="return validacionInventario()" >
                    <div class="form-row" >
                        <div class="form-group col-md-6" >
                            <h2>entrada:</h2>
                            <input type="text" name="entrada" class="form-control" placeholder="Digite la entrada" id="txt_entrada_Reg">
                        </div> 
                        <div class="form-group col-md-6" >
                            <h2>salida:</h2>
                            <input type="text" name="salida" class="form-control" placeholder="Digite la salida" id="txt_salida_Reg">
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                                <h2>saldo:</h2>
                                <input type="text" name="saldo" class="form-control" placeholder="Digite el saldo" id="txt_saldo_Reg">
                            </div>  
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12" >
                        <input type="number" name="tipo_documento_idtipodoc" class="form-control d-none" placeholder="Tipo Documento" id="txt_tipo_documento_idtipodoc_reg"> <br>
                <input type="number" name="productos_idproductos" class="form-control d-none" placeholder="Producto" id="txt_productos_idproductos_reg"> <br>
                <%
                    ProductoDAO productos_dao = new ProductoDAO();
        ArrayList<productos> mi_productos = productos_dao.listadoproductos("", "");
                    out.println("<select class='form-control' id='SelectIdproductos' size='1'>");
                    out.println("<option onclick='setProductos_idproductos(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (productos P : mi_productos) {
                        out.println("<option onclick='setProductos_idproductos(\"" + P.getReferenciaproducto() + "\")'>" + P.getNombreproducto() + "</option>");
                    }
                    out.println("</select>");
                %>
                    </div>
                    </div>  
                        </div>
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <center><button type="submit" class="btn btn-success">Registrar</button></center>
                </form>
            </div>
        </div>
        <!--FORMULARIO REGISTRAR-->

        <!--FORMULARIO LISTAR-->
        <div id="Listado" class="bd-example contenedor2">
            <form action="/VISION/ConsultarInventario" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group d-none">
                        <input id ="txt_Id_Consultado" type = "text" class="form-control"
                                   name= "IdConsultado" value="<%=buscando%>" autofocus
                                   placeholder="Buscar por entrada o salida"/>
                            <button type="button" class="btn btn-primary" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"
                                    onClick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado Inventario</h2>
                        <%
                            inventarioDAO idao = new inventarioDAO();
                            ArrayList<inventario> iList = new ArrayList<inventario>();
                            iList = idao.Consultarlistadoinventario(buscando, buscando, buscando);
                            out.println("<table class='table table-light table-striped table-hover table-borderless border-dark'><thead class='thead-info'><tr><th>ID</th><th>Entradas</th><th>Salidas</th><th>Saldo</th><th>Producto</th><th>Eliminar</th></tr></thead>");

                            for (inventario C : iList) {

                                out.println("<tr>");
                                out.println("<td>" + C.getIdinventario() + "</td>");
                                out.println("<td>" + C.getEntrada() + "</td>");
                                out.println("<td>" + C.getSalida() + "</td>");
                                out.println("<td>" + C.getSaldo() + "</td>");
                                out.println("<td>" + C.getProductos_idproductos() + "</td>");

                                out.println("<td>" + "<input type = 'submit' class='btn btn-danger btn btn-login' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + C.getIdinventario() + ")'/>" + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</table>");
                        %>
                    </div>
                </div>
            </form>
        </div>
        <!--FORMULARIO LISTAR--> 
    </body>
</html>
