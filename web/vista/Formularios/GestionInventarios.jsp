<%@page import="modelo.productos"%>
<%@page import="controlador.ProductoDAO"%>
<%@page import="modelo.inventario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.inventarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarInventarios.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario</title>
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

        <div id="Registrar" class="container bd-example d-none">
                <h1>Registrar Inventario</h1>
                <br>
                <form action="/VISION/RegistroInventario" method="post" onsubmit="return validacionInventario()" class="row g-3">
                        <div class="form-floating col-md-6" >
                            <input type="text" name="entrada" class="form-control" placeholder="Digite la entrada" id="txt_entrada_Reg">
                            <label for="floatingInput">Entrada</label>
                        </div> 
                        <div class="form-floating col-md-6" >
                            <input type="text" name="salida" class="form-control" placeholder="Digite la salida" id="txt_salida_Reg">
                            <label for="floatingInput">Salida</label>
                        </div> 
                            <div class="form-floating col-md-6" >
                                <input type="text" name="saldo" class="form-control" placeholder="Digite el saldo" id="txt_saldo_Reg">
                                <label for="floatingInpur">Saldo</label>
                            </div>  
                            <div class="form-floating col-md-6" >
                                <input type="number" name="productos_idproductos" class="form-control d-none" id="txt_productos_idproductos_Reg"> 
                                <%
                                    ProductoDAO productos_dao = new ProductoDAO();
                                    ArrayList<productos> mi_productos = productos_dao.listadoproductos("", "");
                                    out.println("<select class='form-control' id='SelectIdproductos' size='1'>");
                                    out.println("<option onclick='setProductos_idproductos(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                                    for (productos P : mi_productos) {
                                        out.println("<option onclick='setProductos_idproductos(\"" + P.getIdproductos() + "\")'>" + P.getNombreproducto() + "</option>");
                                    }
                                    out.println("</select>");
                                %>
                                <label for="floatingInput">Productos</label>
                            </div>
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <button type="submit" class="btn btn-success">Registrar</button>
                </form>
            </div>
        </div>

        <div id="Listado" class="bd-example container">
            <form action="/VISION/ConsultarInventarios" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group ">
                        <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="autofocus" placeholder="Consultar por Id"/>
                        <button type="button" class="btn btn-primary" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado Inventarios</h2>
                        <%
                            inventarioDAO inventariodao = new inventarioDAO();
                            ArrayList<inventario> inventarioList = new ArrayList<inventario>();
                            inventarioList = inventariodao.ListadoInventario(buscando, buscando, buscando);
                            out.println("<table class='table table-dark table-striped table-hover table-bordered'><thead class='thead-info'><tr><th>ID</th><th>Entrada</th><th>Salida</th><th>Saldo</th><th>Producto</th><th>Eliminar</th></tr></thead>");

                            for (inventario C : inventarioList) {

                                out.println("<tr>");
                                out.println("<td>" + C.getIdinventario() + "</td>");
                                out.println("<td>" + C.getEntrada() + "</td>");
                                out.println("<td>" + C.getSalida() + "</td>");
                                out.println("<td>" + C.getSaldo() + "</td>");
                                out.println("<td>" + C.getProductos_idproductos() + "</td>");

                                out.println("<td>" + "<input type = 'submit' class='btn btn-danger btn btn-login' value='Eliminar'name='Eliminar'onclick='SetIdConsulta(" + C.getIdinventario()+ ")'/>" + "</td>");
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
