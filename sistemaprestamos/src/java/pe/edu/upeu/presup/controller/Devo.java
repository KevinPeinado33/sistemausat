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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.presup.dao.DevoDao;
import pe.edu.upeu.presup.dao.DevolucionDao;
import pe.edu.upeu.presup.dao.PrestamoDao;
import pe.edu.upeu.presup.dao.TipoDao;
import pe.edu.upeu.presup.daoimp.DevoDaoImp;
import pe.edu.upeu.presup.daoimp.DevolucionDaoImp;
import pe.edu.upeu.presup.daoimp.PrestamoDaoImp;
import pe.edu.upeu.presup.daoimp.TipoDaoImp;
import pe.edu.upeu.presup.entity.Devon;
import pe.edu.upeu.presup.entity.Prestamo;


/**
 *
 * @author HP
 */
@WebServlet(name = "de", urlPatterns = {"/de"})
public class Devo extends HttpServlet {
    private DevolucionDao d = new DevolucionDaoImp();
    private Gson g = new Gson();
    private DevolucionDao pres=new DevolucionDaoImp();
    private TipoDao t=new TipoDaoImp();
    private DevoDao k=new DevoDaoImp();
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
            int op = Integer.parseInt(request.getParameter("opc"));
           switch(op){
               case 1:
                   out.println(g.toJson(d.listarDevolucion()));
                   break;
               case 2:
                    Prestamo pre = new Prestamo(Integer.parseInt(request.getParameter("idprestamo")),Integer.parseInt(request.getParameter("idproducto")));

                    pres.update(pre);
                    break;
               case 3: 
                   Devon kop = new Devon(request.getParameter("det"),Integer.parseInt(request.getParameter("idpro")));
                   k.create(kop);
                   break;
               case 5:
                    out.println(g.toJson(d.ListarProductosByFecha(request.getParameter("fecha"),request.getParameter("nom"),request.getParameter("ape"))));
                    break;
               case 6: out.print(g.toJson(k.listt()));
               break;
                   
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
