/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import dao.CutiDAO;
import entities.Cuti;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AdiRahmad
 */
@WebServlet(name = "CutiI", urlPatterns = {"/cutiI"})
public class CutiI extends HttpServlet {

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
        
        String id = request.getParameter("txtIDCuti");
        String jeniscuti = request.getParameter("txtJenisCuti");
        String durasicuti = request.getParameter("txtDurasiCuti");
        String keterangancuti = request.getParameter("txtKeteranganCuti");
        String pesan = "Gagal Merubah Data";
        CutiDAO ddao = new CutiDAO();
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            Cuti cuti = new Cuti();
            cuti.setIdCuti(id);
            cuti.setJenisCuti(jeniscuti);
            cuti.setDurasi(Integer.valueOf(durasicuti));
            cuti.setKeterangan(keterangancuti);

            if (ddao.update(cuti)) {
                pesan = "Berhasil Menambah Data dengan ID : " + cuti.getIdCuti();
            }
            session.setAttribute("cutiI", cuti);
            session.setAttribute("pesan", pesan);
            out.println(pesan);
            dispatcher = request.getRequestDispatcher("cutiController");
            dispatcher.include(request, response);

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
