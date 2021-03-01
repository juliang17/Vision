/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.UnidadDeMedidaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.unidad_de_medida;

/**
 *
 * @author santy
 */
@WebServlet(name = "RegistroUnidadmedida", urlPatterns = {"/RegistroUnidadmedida"})
public class RegistroUnidadmedida extends HttpServlet {

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

        String descripcionunidadmedida = request.getParameter("descripcionunidadmedida");
        String Banderaestado = request.getParameter("Banderaregistro");

        UnidadDeMedidaDAO unidadmedidaDAO = new UnidadDeMedidaDAO();
        unidad_de_medida miunidad = new unidad_de_medida();

        miunidad.setDescripcionunidadmedida(descripcionunidadmedida);

        System.out.println("El valor es " + Banderaestado);
        if (Banderaestado.equals("correcto")) {
            String Respuestaregistrada = unidadmedidaDAO.adicionarunidaddemedida(miunidad);
            System.out.println("Res " + Respuestaregistrada);
            System.out.println("Res " + Respuestaregistrada.length());
            if (Respuestaregistrada.length() == 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "Categoria registrado con Exito." + "');");
                out.println("window.location.href = '/VISION/Formularios/GestionUnidadmedida.jsp';");
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
