/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.presup.dao.PrestamoDetalleDao;
import pe.edu.upeu.presup.daoimp.DetallePrestamoDaoImp;

/**
 *
 * @author CRIRI
 */
public class DetallePrestamoController extends HttpServlet {

    private PrestamoDetalleDao dp = new DetallePrestamoDaoImp();
    private Gson g=new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int op = Integer.parseInt(request.getParameter("opc"));
            switch (op) {
                case 1:
                    String prod []= request.getParameterValues("prod[]");
                    int idp = Integer.parseInt(request.getParameter("idp"));
                    System.out.println("Imprimiendo el array"+Arrays.toString(prod));
             //       DetallePrestamo d = new DetallePrestamo(Integer.parseInt(request.getParameter("idp")),Integer.parseInt(request.getParameter("prod")));
                    //dp.create(d);
                    if(dp.create(idp,prod)>0){
                        out.println(1);
                    }else{
                        out.println(0);
                    }
                    break;
                case 2:
                     out.println(g.toJson(dp.readDetPre(Integer.parseInt(request.getParameter("idp")))));
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
