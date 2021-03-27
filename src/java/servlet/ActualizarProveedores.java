
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

@WebServlet(name = "ActualizarProveedores", urlPatterns = {"/ActualizarProveedores"})
public class ActualizarProveedores extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        String nombre = request.getParameter("nombreproveedores");
        String identificacion = request.getParameter("identificacionproveedores");
        String correo = request.getParameter("correoproveedores");
        String telefono = request.getParameter("telefonoproveedores");

        int Telefono = Integer.parseInt(telefono);

        ProveedoresDAO pdao = new ProveedoresDAO();
        proveedores p = new proveedores();

        p.setNombreproveedores(nombre);
        p.setIdentificacionproveedores(identificacion);
        p.setCorreoproveedores(correo);
        p.setTelefonoproveedores(Telefono);
        
        System.out.println("Número de documento " + identificacion);
        String respuestaRegistrada = pdao.Actualizarproveedores(p);
        if(respuestaRegistrada.length() == 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('"+"Actualización Realizada."+"');");
            out.println("window.location.href = '/VISION/vista/RegistroProveedores.jsp';");
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
