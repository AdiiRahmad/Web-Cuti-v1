/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.update;

import dao.KaryawanDAO;
import entities.Karyawan;
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
@WebServlet(name = "ProsesUpdateKaryawan", urlPatterns = {"/prosesUpdateKaryawan"})
public class ProsesUpdateKaryawan extends HttpServlet {

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

        Date date1 = null;
        Date date2 = null;

        response.setContentType("text/html;charset=UTF-8");
        String nik = request.getParameter("txtNIK");
        String nama = request.getParameter("txtNama");
        String alamat = request.getParameter("txtAlamat");
        String agama = request.getParameter("txtAgama");
        String jk = request.getParameter("gender");
        
        String tgllahir = request.getParameter("txtTglLahir");
        try {
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(tgllahir);
        } catch (ParseException ex) {
            Logger.getLogger(ProsesUpdateKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }

        String tglmulaikerja = request.getParameter("txtTglMulaiKerja");
        try {
            date2 = new SimpleDateFormat("yyyy-mm-dd").parse(tglmulaikerja);
        } catch (ParseException ex) {
            Logger.getLogger(ProsesUpdateKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sisacuti = request.getParameter("txtSisaCuti");
        RequestDispatcher dis = null;
        String pesan = "Gagal mengubah data";
        KaryawanDAO kdao = new KaryawanDAO();

        try (PrintWriter out = response.getWriter()) {

            Karyawan kar = new Karyawan();
            kar.setNik(nik);
            kar.setNama(nama);
            kar.setAgama(agama);
            kar.setJenisKelamin(jk);
            kar.setAlamat(alamat);
            kar.setTanggalLahir(date1);
            kar.setTglMulaiKerja(date2);
            kar.setSisa(Short.parseShort(sisacuti));
            if (kdao.update(kar)) {
                pesan = "Berhasil menghubah data dengan ID: "
                        + kar.getNik();
            }
            out.println(pesan);
            dis = request.getRequestDispatcher("karyawanController");
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
