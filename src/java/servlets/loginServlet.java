/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="loginServlet", urlPatterns={"/loginServlet"})
public class loginServlet extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //- Variables que contendran los datos de la sesion
        String login; 
        String password;
         
        login = request.getParameter("login");
        password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Este paso simula la consulta a la base de datos para el usuario y el
        //password
        //Si devuelve 0 las dos cadenas son iguales, uno son diferentes
if (login.compareTo("usuario") == 0  && password.compareTo("12345") == 0){

            out.println ("Login correcto");
            HttpSession session = request.getSession(); // Se obtiene la sesion

            if (session.isNew()) {// Si es una sesion nueva
                out.println ("Sesion Nueva");
                session.setAttribute("login", login); //Se guarda el login
                session.setAttribute("password", password);//Se guarda el password
                Date acceso=new Date(session.getLastAccessedTime()); 
                out.println("Ultimo Acceso"+acceso);
                out.println(session.getId());
                out.println(session.getCreationTime());
            }
            else{
                out.println("Sesion Existente"); //si ya existe la sesion
                //Se obtiene el usuario de la sesion
                login = (String) session.getAttribute("login"); 
                 // Se obtiene el password
                password = (String) session.getAttribute("password"); 
                out.println(login);out.println(password);
            }
        }
        else{
            out.println("login incorrecto");
        }
        out.close();
        
      }       

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

