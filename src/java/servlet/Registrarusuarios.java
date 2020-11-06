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

@WebServlet(name = "Registrarusuarios", urlPatterns = {"/Registrarusuarios"})
public class Registrarusuarios extends HttpServlet {

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

        String Identificacion = request.getParameter("numerodocusuarios");
        String  nombres = request.getParameter("nombreusuarios");
        String apellidos = request.getParameter("apellidousuarios");
        String correo = request.getParameter("correousuarios");
        String telefono = request.getParameter("telefonousuarios");
        String direccion = request.getParameter("direccionusuario");
        String contraseña = request.getParameter("contraseñausuario");
        String tipodocumento = request.getParameter("idtipodoc");
        String roles = request.getParameter("idroles");
        String genero = request.getParameter("idgenero");
        String estado = request.getParameter("idestadousuario");
        String BanderaEstado = request.getParameter("BanderaRegistro");

        int numerodocusuarios= Integer.parseInt(Identificacion);
        int telefonousuarios = Integer.parseInt(telefono);
        int idtipodoc = Integer.parseInt(tipodocumento);
        int idroles = Integer.parseInt(roles);
        int idgenero = Integer.parseInt(genero);
        int idestadousuario = Integer.parseInt(estado);

        usuariosDAO misusuariosDAO = new usuariosDAO();
        usuarios misusuarios = new usuarios();

        misusuarios.setnumerodocusuario(numerodocusuarios);
        misusuarios.setnombreusuarios(nombres);
        misusuarios.setapellidousuarios(apellidos);
        misusuarios.setcorreousuarios(correo);
        misusuarios.settelefonousuarios(telefonousuarios);
        misusuarios.setdireccionusuario(direccion);
        misusuarios.setcontraseñausuario(contraseña);
        misusuarios.settipo_documento_idtipodoc(idtipodoc);
        misusuarios.setroles_idroles(idroles);
        misusuarios.setgenero_idgenero(idgenero);
        misusuarios.setestado_usuario_idestadousuario(idestadousuario);

        System.out.println("El valor es " + BanderaEstado);
        if (BanderaEstado.equals("correcto")) {
            String RespuestaRegistrada = misusuariosDAO.adicionarusuarios(misusuarios);
            System.out.println("Res" + RespuestaRegistrada);
            System.out.println("Res" + RespuestaRegistrada.length());
            if (RespuestaRegistrada.length() == 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "Se registro el usuario correctamente." + "');");
                out.println("window.location.href = '/vision/index.html';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + RespuestaRegistrada + "');");
                out.println("alert('" + "Error Encontrado: "
                        + RespuestaRegistrada.replace("'", "") + "');");
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
