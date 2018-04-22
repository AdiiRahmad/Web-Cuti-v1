/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.update;

import dao.DetailCutiDAO;
import entities.DetailCuti;
import entities.Karyawan;
import entities.Cuti;
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
@WebServlet(name = "ProsesUpdateDetailCuti", urlPatterns = {"/prosesUpdateDetailCuti"})
public class ProsesUpdateDetailCuti extends HttpServlet {

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
        
        Date date1 = null;
        Date date2 = null;
        
        String idDetailCuti = request.getParameter("txtIDDetailCuti");
        String nik = request.getParameter("txtNik");
        String idCuti = request.getParameter("txtJenisCuti");
        String keterangan = request.getParameter("txtKeteranganCuti");
        String tanggalMulai = request.getParameter("txtTanggalMulai");
        try {
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(tanggalMulai);
        } catch (ParseException ex) {
            Logger.getLogger(ProsesUpdateDetailCuti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String tanggalSelesai = request.getParameter("txtTanggalSelesai");
        try {
            date2 = new SimpleDateFormat("yyyy-mm-dd").parse(tanggalSelesai);
        } catch (ParseException ex) {
            Logger.getLogger(ProsesUpdateDetailCuti.class.getName()).log(Level.SEVERE, null, ex);
        }
        String lamacuti = request.getParameter("txtLamaCuti");
        
        String pesan = "Gagal Merubah Data";
        DetailCutiDAO dcdao = new DetailCutiDAO();
        RequestDispatcher dis = null;
        
        try (PrintWriter out = response.getWriter()) {
            
            DetailCuti dcu = new DetailCuti();
            dcu.setIdDetailCuti(idDetailCuti);
            dcu.setNik(new Karyawan(String.valueOf(nik)));
            dcu.setIdCuti(new Cuti(String.valueOf(idCuti)));
            dcu.setKeterangan(keterangan);
            dcu.setTanggalMulai(date1);
            dcu.setTanggalSelesai(date2);
            dcu.setLamaCuti(Short.parseShort(lamacuti));
            if (dcdao.update(dcu)) {
                pesan = "Berhasil mengubah data dengan ID: "
                        + dcu.getIdDetailCuti();
            }
            out.println(pesan);
            dis = request.getRequestDispatcher("detailCutiController");
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
