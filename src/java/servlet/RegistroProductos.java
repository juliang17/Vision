
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

@WebServlet(name = "RegistroProductos", urlPatterns = {"/RegistroProductos"})
public class RegistroProductos extends HttpServlet {

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
        String BanderaEstado = request.getParameter("BanderaRegistro");
        
        
        int Cantidad = Integer.parseInt(cantidadproducto);
        int Iva = Integer.parseInt(ivaproducto);
        int Precio = Integer.parseInt(precio);
        int Categoria = Integer.parseInt(categorias_idcategorias);
        int Marca = Integer.parseInt(marca_idmarca);
        int Unidad = Integer.parseInt(unidad_de_medida_idunidadmedida);
        int Proveedor = Integer.parseInt(proveedores_idproveedores);
        
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
        
        System.out.println("El valor es " + BanderaEstado);
        if (BanderaEstado.equals("Correcto")) {
            String respuestaRegistrada = pdao.adicionarproductos(p);
            System.out.println("Res " + respuestaRegistrada);
            System.out.println("Res " + respuestaRegistrada.length());
            if (respuestaRegistrada.length() == 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "Producto Registrado" + "');");
                out.println("window.location.href = '/VISION/vista/RegistroProductos.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                //out.println("alert('" + respuestaRegistrada + "');");
                out.println("alert('" + "Error encontrado: " + respuestaRegistrada.replace("'", "") + "');");
                out.println("window.history.back();");
                out.println("</script>");

            }
        } else {
            System.out.println("El valor no es correcto " + BanderaEstado);
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
