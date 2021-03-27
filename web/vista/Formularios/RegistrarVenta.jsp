
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Venta</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="" method="post">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d--flex">
                                    <input type="text" name="idusuarios" class="form-control" placeholder="usuario">
                                    <input type="submit" name="accion" valu="BuscarCliente" class="btn btn-outline-success">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreusuarios" class="form-control">
                                </div>  
                            </div>
                            <div class="form-group">
                                <label>Datos del producto</label>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-6 d--flex">
                                    <input type="text" name="idproductos" class="form-control" placeholder="producto">
                                    <input type="submit" name="accion" valu="Buscar" class="btn btn-outline-success">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreproducto" class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" class="form-control" placeholder="producto">
                                </div>
                                <div class="col-sm-3">
                                    <input type="numberr" name="cantidad" class="form-control">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="cantidadproducto" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="accion" value="agregar" class="btn-outline-warning">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                        <label>Numero de serie</label>
                            <input type="text" name="NroSerie" class="form-control">
                    </div>
                        <br>
                    <table class=" table table-hover"
                            <thead>
                            <tr>
                                <th>Nro</th>
                                <th>Id Producto</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>Subtotal</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                    </table>
                    </div>
                    <div class="card-footer">
                        <div>
                            <input type="submit" name="accion" value="Generar venta" class="btn-outline-success">
                            <input type="submit" name="accion" value="Cancelar" class="btn-outline-danger">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
