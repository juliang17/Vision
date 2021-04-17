
package servlet;


import controlador.ProveedoresDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.proveedores;

@WebServlet(name = "ConsultarProveedor", urlPatterns = {"/ConsultarProveedor"})
public class ConsultarProveedor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

            String Accion = request.getParameter("Actualizar");
            System.out.println("Accion " + Accion);

            String Identificacion = request.getParameter("IdConsultado");

            ProveedoresDAO pdao = new ProveedoresDAO();
            proveedores p = null;

            p = pdao.Consultaproveedores(Identificacion);

            if (Accion != null) {

                if (p != null) {

                    response.sendRedirect("/VISION/vista/RegistroProveedores.jsp?Nombres=" + p.getNombreproveedores() + "&"
                            + "Identificacion=" + p.getIdentificacionproveedores() + "&"
                            + "Correo=" + p.getCorreoproveedores() + "&"
                            + "Telefono=" + p.getTelefonoproveedores() + "&"
                            + "Vista=" + "Actualizar" + "&");
                    System.out.println("Salio");

                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "No se ha podido realizar la consulta." + "\n" + "Por favor verificar la identificacion: " + Identificacion + "');");
                    out.println("</script>");
                }

            } else {

                if (p != null) {

                    String respuestaRegistrada = pdao.Eliminarproveedores(p);
                    if (respuestaRegistrada.length() == 0) {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('" + "Eliminacion Realizada." + "');");

                        out.println("window.location.href = '/VISION/vista/RegistroProveedores.jsp';");
                        out.println("</script>");

                    } else {

                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('" + "No se ha podido realizar la eliminacion." + respuestaRegistrada.replace("'", "") + "');");
                        out.println("</script>");
                    }
                } else {

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "No se ha podido realizar la consulta." + "\n" + "Por favor verificar la identificacion: " + Identificacion + "');");
                    out.println("</script>");

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
