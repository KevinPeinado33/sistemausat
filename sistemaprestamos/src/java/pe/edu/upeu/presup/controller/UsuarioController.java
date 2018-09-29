/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upeu.presup.dao.UsuarioDao;
import pe.edu.upeu.presup.daoimp.UsuarioDaoImp;

/**
 *
 * @author Kevin Peinado pat= {uc}
 */
public class UsuarioController extends HttpServlet {

    private Gson g = new Gson();
    private UsuarioDao usu = new UsuarioDaoImp();

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
        int op = Integer.parseInt(request.getParameter("op"));
        HttpSession sesion = request.getSession();
        HashMap<String, Object> datos = new HashMap<>();
        datos = usu.validar(request.getParameter("user"), request.getParameter("pass"));
        switch (op) {
            case 1:
                if (datos.size() > 0) {
                    System.out.println(datos);
                    sesion.setAttribute("iduser", datos.get("idu"));
                    sesion.setAttribute("user", datos.get("user"));
                    String nombres = datos.get("nom") + " " + datos.get("apell");
                    sesion.setAttribute("nombres", nombres);
                    sesion.setAttribute("rol", datos.get("rol"));
                    sesion.setAttribute("idr", datos.get("irol"));
                    sesion.setAttribute("idt", datos.get("itra"));
                    out.print(datos);
                } else {
                    out.print(0);
                }
                break;
            case 2:
                String usuario = request.getParameter("usus");
                out.print(g.toJson(usu.validarUsu(usuario)));
                break;
            case 3:
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                int idusuario = Integer.parseInt(request.getParameter("idusuario"));
                usu.insertIntentos(cantidad, idusuario);
                break;
            case 4:
                usu.desactivarUsuario(request.getParameter("estado"), Integer.parseInt(request.getParameter("idtrab")));
                break;
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
