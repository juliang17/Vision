/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.usuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.usuarios;

@WebServlet(name = "ConsultaUsuarios", urlPatterns = {"/ConsultaUsuarios"})
public class ConsultaUsuarios extends HttpServlet {

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
            String Accion = request.getParameter("Actualizar");
            System.out.println("Accion " + Accion);

            String Identificacion = request.getParameter("IdConsultado");

            usuariosDAO miUsuariodao = new usuariosDAO();
            usuarios usuario = null;

            usuario = miUsuariodao.Consultarusuarios(Identificacion);

            if (Accion != null) {

                if (usuario != null) {

                    response.sendRedirect("/VISION/vista/RegistroUsuarios.jsp?Nombres=" + usuario.getNombreusuarios() + "&"
                            + "Contrasena=" + usuario.getClaveusuario() + "&"
                            + "Telefono=" + usuario.getTelefonousuarios() + "&"
                            + "Direccion=" + usuario.getDireccionusuario() + "&"
                            + "Correo=" + usuario.getCorreousuarios() + "&"
                            + "Apellidos=" + usuario.getApellidousuarios() + "&"
                            + "Estado_usuario=" + usuario.getEstado_usuario_idestadousuario() + "&"
                            + "Tipo_usuario=" + usuario.getRoles_idroles() + "&"
                            + "Tipo_doc=" + usuario.getTipo_documento_idtipodoc() + "&"
                            + "Genero=" + usuario.getGenero_idgenero() + "&"
                            + "NumeroDoc=" + usuario.getNumerodocusuario() + "&"
                            + "Vista=" + "Actualizar" + "&");

                    System.out.println("Salio");

                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "No se ha podido relizar la consulta." + "\n" + "Por favor verificar la identificacion: " + Identificacion + "');");
                    out.println("</script>");
                }

            } else {

                if (usuario != null) {

                    String respuestaRegistrada = miUsuariodao.Eliminarusuario(usuario);
                    if (respuestaRegistrada.length() == 0) {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('" + "Eliminacion Realizada." + "');");

                        out.println("window.location.href = '/VISION/vista/RegistroUsuarios.jsp';");
                        out.println("</script>");

                    } else {

                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('" + "No se ha podido relizar la eliminacion." + respuestaRegistrada.replace("'", "") + "');");
                        out.println("</script>");
                    }
                } else {

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "No se ha podido realizar la consulta." + "\n" + "Por favor verificar la identificacion: " + Identificacion + "');");
                    out.println("</script>");

                }
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
