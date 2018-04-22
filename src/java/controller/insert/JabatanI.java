/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import dao.JabatanDAO;
import entities.Cuti;
import entities.Jabatan;
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
@WebServlet(name = "JabatanI", urlPatterns = {"/jabatanI"})
public class JabatanI extends HttpServlet {

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
        
        String id = request.getParameter("txtIDJabatan");
        String jabatan = request.getParameter("txtJabatan");
        String idpimpinan = request.getParameter("txtIDPimpinan");
        String pesan = "Gagal Merubah Data";
        JabatanDAO jdao = new JabatanDAO();
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            Jabatan jb = new Jabatan();
            jb.setIdJabatan(id);
            jb.setJabatan(jabatan);
            jb.setIdPimpinan(new Jabatan (String.valueOf(idpimpinan)));

            if (jdao.update(jb)) {
                pesan = "Berhasil Menambah Data dengan ID : " + jb.getIdJabatan();
            }
            session.setAttribute("jabatanI", jb);
            session.setAttribute("pesan", pesan);
            out.println(pesan);
            dispatcher = request.getRequestDispatcher("jabatanController");
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
