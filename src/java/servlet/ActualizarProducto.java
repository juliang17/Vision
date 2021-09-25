
package servlet;

import controlador.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.productos;

@WebServlet(name = "ActualizarProducto", urlPatterns = {"/ActualizarProducto"})
public class ActualizarProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String referenciaproducto = request.getParameter("referenciaproducto");
        String nombreproducto = request.getParameter("nombreproducto");
        String cantidadproducto = request.getParameter("cantidadproducto");
        String ivaproducto = request.getParameter("ivaproducto");
        String descripcionproducto = request.getParameter("descripcionproducto");
        String precio = request.getParameter("precio");    
        String categorias_idcategorias = request.getParameter("categorias_idcategorias");
        String marca_idmarca = request.getParameter("marca_idmarca");
        String unidad_de_medida_idunidadmedida = request.getParameter("unidad_de_medida_idunidadmedida");
        String proveedores_idproveedores = request.getParameter("proveedores_idproveedores");
        String estado_producto_idestado_producto = request.getParameter("estado_producto_idestado_producto");
        
        
        int Cantidad = Integer.parseInt(cantidadproducto);
        double Iva = Double.parseDouble(ivaproducto);
        double Precio = Double.parseDouble(precio);
        int Categoria = Integer.parseInt(categorias_idcategorias);
        int Marca = Integer.parseInt(marca_idmarca);
        int Unidad = Integer.parseInt(unidad_de_medida_idunidadmedida);
        int Proveedor = Integer.parseInt(proveedores_idproveedores);
        int estadoP = Integer.parseInt(estado_producto_idestado_producto);
        
        ProductoDAO pdao = new ProductoDAO();
        productos p = new productos();
        
        p.setReferenciaproducto(referenciaproducto);
        p.setNombreproducto(nombreproducto);
        p.setCantidadproducto(Cantidad);
        p.setIvaproducto(Iva);
        p.setDescripcionproducto(descripcionproducto);
        p.setPrecio(Precio);
        p.setCategorias_idcategorias(Categoria);
        p.setMarca_idmarca(Marca);
        p.setUnidad_de_medida_idunidadmedida(Unidad);
        p.setProveedores_idproveedores(Proveedor);
        p.setEstado_producto_idestado_producto(estadoP);
        
        System.out.println("Referencia producto " + referenciaproducto);
        String respuestaRegistrada = pdao.Actualizarproductos(p);
        if(respuestaRegistrada.length() == 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('"+"Actualización Realizada."+"');");
            out.println("window.location.href = '/VISION/vista/RegistroProductos.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('"+"No se ha podido relizar la actualizacion."+"\n"+respuestaRegistrada +"');");
            out.println("</script>");
        }
          
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
