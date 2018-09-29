/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.presup.dao.ReservaDao;
import pe.edu.upeu.presup.daoimp.ReservaDaoImp;
import pe.edu.upeu.presup.entity.DetalleReserva;
import pe.edu.upeu.presup.entity.Reserva;

/**
 *
 * @author Kevin Peinado
 */
public class ReservasController extends HttpServlet {

    private ReservaDao rd = new ReservaDaoImp();
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
                String codigo = request.getParameter("codigo");
                if (!rd.validarProfesorByCodigo(codigo).isEmpty()) {
                    out.println(g.toJson(rd.validarProfesorByCodigo(codigo)));
                } else {
                    out.println(0);
                }
                break;

            case 2:
                out.println(g.toJson(rd.listarProductosReserva()));
                break;

            case 3:
                int idp = Integer.parseInt(request.getParameter("idProducto"));
                out.print(g.toJson(rd.selecionarProdById(idp)));
                break;

            case 4:
                int estado = Integer.parseInt(request.getParameter("estado"));
                String fe_reserva = request.getParameter("fe_reserva");
                String fe_devolucion = request.getParameter("fe_devolucion");
                String aula = request.getParameter("aula");
                int idProfesor = Integer.parseInt(request.getParameter("idp"));
                String fe_prestamo = request.getParameter("fe_prestamo");
                String h_devolucion = request.getParameter("h_devolucion");
                String h_prestamo = request.getParameter("h_prestamo");
                int idReserva = 0;
                idReserva = rd.guardarReserva(new Reserva(estado, fe_reserva, fe_devolucion, aula, idProfesor, fe_prestamo, h_devolucion, h_prestamo));
                if (idReserva > 0) {
                    out.println(idReserva);
                } else {
                    out.println(0);
                }
                break;

            case 5:
                String data = request.getParameter("listProductos");
                int r = 0;
                int iddr = Integer.parseInt(request.getParameter("iddr"));
                JsonParser parser = new JsonParser();
                JsonArray gsonArr = parser.parse(data).getAsJsonArray();
                for (JsonElement obj : gsonArr) {
                    JsonObject gsonObj = obj.getAsJsonObject();
                    DetalleReserva dr = new DetalleReserva(iddr, Integer.parseInt(gsonObj.get("idp").getAsString()));
                    r = rd.guardarDetalleReserva(dr);
                }
                out.println(r);
                break;

            case 6:
                out.println(g.toJson(rd.listarInfromeRegistro()));
                break;

            case 7:
                int idDeRe = Integer.parseInt(request.getParameter("iddr"));
                rd.eliminarDetalleReserva(idDeRe);
                break;
            case 8:
                int idRe = Integer.parseInt(request.getParameter("idr"));
                rd.eliminarReserva(idRe);
                break;
            case 9:
                int idqueb = Integer.parseInt(request.getParameter("idreserva"));
                out.println(g.toJson(rd.buscarProdReservaById(idqueb)));
                break;

            case 10:
                int idResr = Integer.parseInt(request.getParameter("idr"));
                String aular = request.getParameter("aula");
                String fePre = request.getParameter("fePrest");
                String hPre = request.getParameter("hpre");
                String feDevo = request.getParameter("feDevo");
                String hDevo = request.getParameter("hDevo");
                Reserva re = new Reserva(idResr, feDevo, aular, fePre, hDevo, hPre);
                rd.actualizarReserva(re);
                break;

            case 11:
                int idDr = Integer.parseInt(request.getParameter("iddr"));
                int idRes = Integer.parseInt(request.getParameter("idr"));
                int idPro = Integer.parseInt(request.getParameter("idp"));
                DetalleReserva drt = new DetalleReserva(idDr, idRes, idPro);
                rd.actulizarDetallReserva(drt);
                break;

            case 12:
                int idreq = Integer.parseInt(request.getParameter("idreserva"));
                out.println(g.toJson(rd.listarReservaById(idreq)));
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
