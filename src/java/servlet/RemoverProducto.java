/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.detalle_movimiento;

/**
 *
 * @author santy
 */
@WebServlet(name = "RemoverProducto", urlPatterns = {"/RemoverProducto"})
public class RemoverProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Remover productos del carrito</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet RemoverElementoCarrito at " + request.getContextPath() + "</h1>");
            int valorcod=Integer.parseInt(request.getParameter("txtcod"));
            int vector = 0;
            out.println("<script>");
                //out.println("alert('"+valorcod+"');");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
           
	    // 2, llama al método remove del carrito de compras
            ArrayList<detalle_movimiento> lista;
            //lista=null;
            HttpSession session=request.getSession();
            lista=(ArrayList<detalle_movimiento>)session.getAttribute("carrito");
            int cont=0,j=0,i=0;
          
               for(detalle_movimiento d: lista)
                 {
                     if(d.getProductos_idproductos() == valorcod )
                     {
                     vector=cont;
                     j++;
                     }
                     cont++;   
                       
                 }
               
            lista.remove(vector);
            if(cont <= 1)
            {
                lista=null;
                request.getSession().removeAttribute("carrito");
            }
	    response.sendRedirect(request.getContextPath()+"/vista/Formularios/registrarVenta.jsp");
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
