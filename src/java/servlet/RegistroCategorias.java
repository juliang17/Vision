/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.categoriasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.categorias;

/**
 *
 * @author santy
 */
@WebServlet(name = "RegistroCategorias", urlPatterns = {"/RegistroCategorias"})
public class RegistroCategorias extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        String descripcioncategorias = request.getParameter("descripcioncategorias");
        String Banderaestado = request.getParameter("Banderaregistro");
        
        categoriasDAO categorias_dao = new categoriasDAO();
        categorias mi_categorias = new categorias();
        
        mi_categorias.setDescripcioncategorias(descripcioncategorias);
        
        System.out.println("El valor es " + Banderaestado);
        if (Banderaestado.equals("correcto")) {
            String Respuestaregistrada = categorias_dao.adicionarcategorias(mi_categorias);
            System.out.println("Res " + Respuestaregistrada);
            System.out.println("Res " + Respuestaregistrada.length());
            if (Respuestaregistrada.length() == 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "Categoria registrado con Exito." + "');");
                out.println("window.location.href = '/VISION/Formularios/GestionCategorias.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + Respuestaregistrada + "');");
                out.println("alert('" + "Error Encontrado: "
                        + Respuestaregistrada.replace("'", "") + "');");
                out.println("window.history.back();");
                out.println("</script>");
            }
        } else {
            System.out.println("El valor no es correcto " + Banderaestado);
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
