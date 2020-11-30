/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controlador.PROVEEDORES_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.proveedores;

/**
 *
 * @author santy
 */
public class RegistroProveedores extends HttpServlet {

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

            String nombreproveedores = request.getParameter("nombreproveedores");
            String correoproveedores = request.getParameter("correoproveedores");
            String telefonoproveedores = request.getParameter("telefonoproveedores");
            String BanderaProveedor = request.getParameter("BanderaReg");

            int Telefono = Integer.parseInt("telefonoproveedores");

            proveedores misproveedores = new proveedores();
            PROVEEDORES_DAO misproveedoresDAO = new PROVEEDORES_DAO();

            misproveedores.setNombreproveedores(nombreproveedores);
            misproveedores.setCorreoproveedores(correoproveedores);
            misproveedores.setTelefonoproveedores(Telefono);

            System.out.println("El valor es " + BanderaProveedor);
            if (BanderaProveedor.equals("Correcto")) {
                String respuestaRegistrada = misproveedoresDAO.adicionarproveedores(misproveedores);
                System.out.println("Res " + respuestaRegistrada);
                System.out.println("Res " + respuestaRegistrada.length());
                if (respuestaRegistrada.length() == 0) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "Registro realizado." + "');");
                    out.println("window.location.href = '/VISION/index.jsp';");
                    out.println("</script>");
                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('"+ respuestaRegistrada + "');");
                    out.println("alert('" + "Error encontrado: " + respuestaRegistrada.replace("", "") + "');");
                    out.println("window.history.back();");
                    out.println("</script>");
                }
            } else {
                System.out.println("El valor es correcto " + BanderaProveedor);
            }
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
