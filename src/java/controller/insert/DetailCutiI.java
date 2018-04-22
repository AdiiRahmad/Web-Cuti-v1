/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import controller.update.ProsesUpdateDetailCuti;
import dao.CutiDAO;
import dao.DetailCutiDAO;
import dao.KaryawanDAO;
import entities.Cuti;
import entities.DetailCuti;
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
@WebServlet(name = "DetailCutiI", urlPatterns = {"/detailCutiI"})
public class DetailCutiI extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        DetailCutiDAO dcdao = new DetailCutiDAO();
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession(true);

        Date date1 = null;
        Date date2 = null;

        String id = request.getParameter("txtIDDetailCuti");
        String nik = request.getParameter("txtNik");
        String jeniscuti = request.getParameter("txtJenisCuti");
        String keterangancuti = request.getParameter("txtKeteranganCuti");
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

        try (PrintWriter out = response.getWriter()) {
            DetailCuti dc = new DetailCuti();
            dc.setIdDetailCuti(id);
            dc.setNik(new Karyawan(nik));
            dc.setIdCuti(new Cuti(jeniscuti));
            dc.setKeterangan(keterangancuti);
            dc.setTanggalMulai(date1);
            dc.setTanggalSelesai(date2);
            
            Date tglmulai = dc.getTanggalMulai();
            Date tglselesai = dc.getTanggalSelesai();

            Long mulai = tglmulai.getTime();
            Long selesai = tglselesai.getTime();
            Long Selisih = selesai - mulai;
            Long lamaCuti = Selisih / (24 * 60 * 60 * 1000) + 1;
            Short lama = Short.parseShort(lamaCuti.toString());

            Karyawan k = new Karyawan();
            Short sisa = k.getSisa();

            dc.setLamaCuti(lama);

            if (dcdao.update(dc)) {
                pesan = "Berhasil Menambah Data dengan ID : " + dc.getIdDetailCuti();
            }
            session.setAttribute("detailCutiI", dc);
            session.setAttribute("KaryawanList", new KaryawanDAO().getAll());
            session.setAttribute("CutiList", new CutiDAO().getAll());
            session.setAttribute("pesan", pesan);
            out.println(pesan);
            dispatcher = request.getRequestDispatcher("detailCutiController");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DetailCutiI.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DetailCutiI.class.getName()).log(Level.SEVERE, null, ex);
        }
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
