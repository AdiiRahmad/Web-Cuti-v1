/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.update;

import dao.DetailCutiDAO;
import dao.SetujuCutiDAO;
import entities.DetailCuti;
import entities.Karyawan;
import entities.Cuti;
import entities.Jabatan;
import entities.SetujuCuti;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AdiRahmad
 */
@WebServlet(name = "ProsesUpdateSetujuCuti", urlPatterns = {"/prosesUpdateSetujuCuti"})
public class ProsesUpdateSetujuCuti extends HttpServlet {

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
        String idsetuju = request.getParameter("txtIDSetujuCuti");
        String iddetailcuti = request.getParameter("txtIDDetailCuti");
        String status = request.getParameter("txtStatus");
        String idjabatan = request.getParameter("txtIDJabatan");
        String pesan = "Gagal Merubah Data";
        SetujuCutiDAO scdao = new SetujuCutiDAO();
        RequestDispatcher dis = null;
        
        try (PrintWriter out = response.getWriter()) {
            SetujuCuti sc = new SetujuCuti();
            sc.setIdSetujuCuti(idsetuju);
            sc.setIdDetailCuti(new DetailCuti(iddetailcuti));
            sc.setStatus(status);
            sc.setIdJabatan(new Jabatan(idjabatan));
            if (scdao.update(sc)) {
                pesan = "Berhasil mengubah data dengan ID: "
                        + sc.getIdSetujuCuti();
            }
            out.println(pesan);
            dis = request.getRequestDispatcher("setujuCutiController");
            dis.include(request, response);
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
