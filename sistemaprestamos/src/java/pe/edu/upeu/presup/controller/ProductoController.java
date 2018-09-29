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
import pe.edu.upeu.presup.dao.ProductoDao;
import pe.edu.upeu.presup.dao.TipoDao;
import pe.edu.upeu.presup.daoimp.ProductoDaoImp;
import pe.edu.upeu.presup.daoimp.TipoDaoImp;
import pe.edu.upeu.presup.entity.Producto;
import pe.edu.upeu.presup.entity.Tipo;

/**
 *
 * @author EMILY
 */
@WebServlet(name = "pro", urlPatterns = {"/pro"})
public class ProductoController extends HttpServlet {

    private ProductoDao pro = new ProductoDaoImp();
    private TipoDao jio = new TipoDaoImp();
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
        try (PrintWriter out = response.getWriter()) {
            int op = Integer.parseInt(request.getParameter("op"));
            switch (op) {
                case 1:
                    out.println(g.toJson(pro.readAll()));
                    break;
                case 2:
                    Producto p = new Producto(request.getParameter("nom"), request.getParameter("cod"), Integer.parseInt(request.getParameter("est")), Integer.parseInt(request.getParameter("iTip")));
                    pro.create(p);
                    break;
                case 3:
                    pro.deleate(Integer.parseInt(request.getParameter("idP")));
                    break;
                case 4:
                    Producto lo = new Producto(Integer.parseInt(request.getParameter("idP")), Integer.parseInt(request.getParameter("est")));
                    pro.update(lo);
                    out.print(lo);
                    break;
                case 5:
                    out.println(g.toJson(pro.read(Integer.parseInt(request.getParameter("idP")))));
                    break;
                case 6:
                    Producto o = new Producto(request.getParameter("nomTip"));
                    pro.crea(o);
                    break;
                case 7:
                    out.println(g.toJson(pro.liko()));
                    break;
                case 8:
                    out.print(g.toJson(pro.ko()));
                    break;
                case 9:
                    Tipo ti = new Tipo(Integer.parseInt(request.getParameter("idTipo")), request.getParameter("nomTip"));
                    System.out.println(request.getParameter("nomTip"));
                    jio.update(ti);
                    break;
                case 10:
                    out.println(g.toJson(jio.liston(Integer.parseInt(request.getParameter("id")))));
                    System.out.println(Integer.parseInt(request.getParameter("id")));
                    break;
                case 11:
                    int x = Integer.parseInt(request.getParameter("idt"));
                    out.println(g.toJson(pro.buscarTipoById(x)));
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
