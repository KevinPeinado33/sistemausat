/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.presup.dao.TrabajadorDao;
import pe.edu.upeu.presup.dao.UsuarioDao;
import pe.edu.upeu.presup.daoimp.TrabajadorDaoImp;
import pe.edu.upeu.presup.daoimp.UsuarioDaoImp;
import pe.edu.upeu.presup.entity.Trabajador;
import pe.edu.upeu.presup.entity.Usuario;

/**
 *
 * @author nicob
 */
public class UsuCon extends HttpServlet {

    private UsuarioDao myUsu = new UsuarioDaoImp();
    private TrabajadorDao myTraba = new TrabajadorDaoImp();
    private Gson g = new Gson();

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
        switch (op) {
            case 1:
                Usuario usu = new Usuario(
                        request.getParameter("usu"),
                        request.getParameter("cont"),
                        Integer.parseInt(request.getParameter("idr")),                        
                        Integer.parseInt(request.getParameter("idt")));
                out.println(g.toJson(myUsu.create(usu)));
                break;
            case 2 :
                Trabajador trab = new Trabajador(
                        request.getParameter("nom"),
                        request.getParameter("apel"),
                        request.getParameter("dir"),
                        request.getParameter("celular"),
                        request.getParameter("numDni"),
                        request.getParameter("email")
                      );
                out.println(g.toJson(myTraba.create(trab)));
                break;
            case 3:
                Trabajador tr=new Trabajador(
                        request.getParameter("no"),
                        request.getParameter("ape"),
                        request.getParameter("dir"), 
                        request.getParameter("num"), 
                        request.getParameter("numDn"), 
                        request.getParameter("ema"),
                        Integer.parseInt(request.getParameter("idt")));
                Usuario us = new Usuario(
                        request.getParameter("user"),
                        request.getParameter("contra"));
                myTraba.updatePersona(tr,us);
                break;
                
            case 4:
                out.println(g.toJson(myUsu.listarNomUsuario()));
                break;
            case 5:
                out.println(g.toJson(myTraba.listarIdTrabajador()));
                break;
            case 6:
                out.println(g.toJson(myTraba.listarTrabajador()));
                break;
            case 7:
                Usuario u = new Usuario(Integer.parseInt(request.getParameter("idt")));
                myUsu.CambiarEstadoUsuario(u);
                break;
            case 8:
                out.println(g.toJson(myTraba.listarPersona(Integer.parseInt(request.getParameter("idtra")))));
                break;
            case 9:
                Usuario usua = new Usuario(
                        Integer.parseInt(request.getParameter("idu")),
                        request.getParameter("user"),
                        request.getParameter("contra"));
                        myUsu.updateUsuario(usua);
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
