/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import controller.update.ProsesUpdateKaryawan;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author AdiRahmad
 */
@WebServlet(name = "KaryawanI", urlPatterns = {"/karyawanI"})
public class KaryawanI extends HttpServlet {

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
        String nik = request.getParameter("txtNIK");
        String nama = request.getParameter("txtNama");
        String alamat = request.getParameter("txtAlamat");
        String agama = request.getParameter("txtAgama");
        String jenisKelamin = request.getParameter("gender");
        String sisa = request.getParameter("txtSisaCuti");
        String pesan = "Gagal Merubah Data";
        KaryawanDAO kdao = new KaryawanDAO();
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession(true);

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

        try (PrintWriter out = response.getWriter()) {
            Karyawan k = new Karyawan();
            k.setNik(nik);
            k.setNama(nama);
            k.setAlamat(alamat);
            k.setAgama(agama);
            k.setJenisKelamin(jenisKelamin);
            k.setTanggalLahir(date1);
            k.setTglMulaiKerja(date2);
            k.setSisa(Short.parseShort(sisa));

            if (kdao.update(k)) {
                pesan = "Berhasil Menambah Data dengan ID : " + k.getNik();
            }
            session.setAttribute("karyawanI", k);
            session.setAttribute("pesan", pesan);
            out.println(pesan);
            dispatcher = request.getRequestDispatcher("karyawanController");
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
