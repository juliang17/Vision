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

        String numerodocusuarios = request.getParameter("Identificacion");
        String nombreusuarios = request.getParameter("nombres");
        String apellidousuarios = request.getParameter("apellidos");
        String correousuarios = request.getParameter("correo");
        String telefonousuarios = request.getParameter("telefono");
        String direccionusuario = request.getParameter("direccion");
        String contraseñausuario = request.getParameter("Password");
        String tipo_documento_idtipodoc = request.getParameter("tipod");
        String roles_idroles = request.getParameter("roles");
        String genero_idgenero = request.getParameter("genero");
        String estado_usuario_idestadousuario = request.getParameter("estado");
        String BanderaEstado = request.getParameter("BanderaRegistro");

        int Identificacion = Integer.parseInt(numerodocusuarios);
        int telefono = Integer.parseInt(telefonousuarios);
        int tipod = Integer.parseInt(tipo_documento_idtipodoc);
        int roles = Integer.parseInt(roles_idroles);
        int genero = Integer.parseInt(genero_idgenero);
        int estado = Integer.parseInt(estado_usuario_idestadousuario);

        usuariosDAO misusuariosDAO = new usuariosDAO();
        usuarios misusuarios = new usuarios();

        misusuarios.setnumerodocusuario(Identificacion);
        misusuarios.setnombreusuarios(nombreusuarios);
        misusuarios.setapellidousuarios(apellidousuarios);
        misusuarios.setcorreousuarios(correousuarios);
        misusuarios.settelefonousuarios(telefono);
        misusuarios.setdireccionusuario(direccionusuario);
        misusuarios.setcontraseñausuario(contraseñausuario);
        misusuarios.settipo_documento_idtipodoc(tipod);
        misusuarios.setroles_idroles(roles);
        misusuarios.setgenero_idgenero(genero);
        misusuarios.setestado_usuario_idestadousuario(estado);

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
