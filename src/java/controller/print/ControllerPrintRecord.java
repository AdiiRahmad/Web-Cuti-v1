/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.DetailCutiDAO;
import dao.JabatanDAO;
import dao.SetujuCutiDAO;
import entities.Cuti;
import entities.DetailCuti;
import entities.Jabatan;
import entities.Karyawan;
import entities.SetujuCuti;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Siti Khusnul Azifah
 */
@WebServlet(name = "ControllerPrintRecord", urlPatterns = {"/controllerPrintRecord"})
public class ControllerPrintRecord extends HttpServlet {

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
        response.setContentType("application/pdf");
        String id = request.getParameter("id");
        OutputStream out = response.getOutputStream();
        RequestDispatcher dispatcher = null;
        try {
            try {
                HttpSession session = request.getSession(true);
                try {
                    Document document = new Document();
                    PdfWriter.getInstance(document, out);

                    document.open();

                    Paragraph par1 = new Paragraph();
                    Font fo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
                    par1.add(new Phrase("Report Data Persetujuan Cuti", fo));
                    par1.setAlignment(Element.ALIGN_CENTER);
                    par1.add(new Phrase(Chunk.NEWLINE));
                    par1.add(new Phrase(Chunk.NEWLINE));
                    document.add(par1);

                    Image img = Image.getInstance("E:\\BootcampCode\\WebCuti\\web\\img\\ecuti-logo.png");
                    img.setAlignment(Element.ALIGN_CENTER);
                    img.scaleToFit(100, 100);
                    document.add(img);

                    PdfPTable tbl = new PdfPTable(9);
                    PdfPCell cel1 = new PdfPCell(new Paragraph("ID Detail Cuti", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell cel2 = new PdfPCell(new Paragraph("NIK", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell cel3 = new PdfPCell(new Paragraph("Nama", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell cel4 = new PdfPCell(new Paragraph("Jenis Cuti", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell cel5 = new PdfPCell(new Paragraph("Tanggal Mulai", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell cel6 = new PdfPCell(new Paragraph("Tanggal Selesai", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell cel7 = new PdfPCell(new Paragraph("Lama Cuti", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell cel8 = new PdfPCell(new Paragraph("Status", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell cel9 = new PdfPCell(new Paragraph("Jabatan", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK)));

                    tbl.addCell(cel1);
                    tbl.addCell(cel2);
                    tbl.addCell(cel3);
                    tbl.addCell(cel4);
                    tbl.addCell(cel5);
                    tbl.addCell(cel6);
                    tbl.addCell(cel7);
                    tbl.addCell(cel8);
                    tbl.addCell(cel9);

                    SetujuCuti sc = (SetujuCuti) new SetujuCutiDAO().getById(id);
                    if (sc!=null) {
                        DetailCuti iddetailcuti = new DetailCuti(sc.getIdDetailCuti().toString());
                        Karyawan nik = new Karyawan(sc.getIdDetailCuti().getNik().toString());
                        Karyawan nama = new Karyawan(sc.getIdDetailCuti().getNik().getNama().toString());
                        Cuti jenis = new Cuti(sc.getIdDetailCuti().getIdCuti().getJenisCuti().toString());
                        DetailCuti tanggalmulai = new DetailCuti(sc.getIdDetailCuti().getTanggalMulai().toString());
                        DetailCuti tanggalselesai = new DetailCuti(sc.getIdDetailCuti().getTanggalSelesai().toString());
                        DetailCuti lamacuti = new DetailCuti(sc.getIdDetailCuti().getLamaCuti().toString());
                        Jabatan jabatan = new Jabatan(sc.getIdJabatan().getJabatan().toString());

                        PdfPCell cel11 = new PdfPCell(new Paragraph(iddetailcuti.toString(), FontFactory.getFont("Arial", 7, Font.NORMAL, BaseColor.BLACK)));
                        PdfPCell cel21 = new PdfPCell(new Paragraph(nik.toString(), FontFactory.getFont("Arial", 7, Font.NORMAL, BaseColor.BLACK)));
                        PdfPCell cel31 = new PdfPCell(new Paragraph(nama.toString(), FontFactory.getFont("Arial", 7, Font.NORMAL, BaseColor.BLACK)));
                        PdfPCell cel41 = new PdfPCell(new Paragraph(jenis.toString(), FontFactory.getFont("Arial", 7, Font.NORMAL, BaseColor.BLACK)));
                        PdfPCell cel51 = new PdfPCell(new Paragraph(tanggalmulai.toString(), FontFactory.getFont("Arial", 7, Font.NORMAL, BaseColor.BLACK)));
                        PdfPCell cel61 = new PdfPCell(new Paragraph(tanggalselesai.toString(), FontFactory.getFont("Arial", 7, Font.NORMAL, BaseColor.BLACK)));
                        PdfPCell cel71 = new PdfPCell(new Paragraph(lamacuti.toString(), FontFactory.getFont("Arial", 7, Font.NORMAL, BaseColor.BLACK)));
                        PdfPCell cel81 = new PdfPCell(new Paragraph(sc.getStatus(), FontFactory.getFont("Arial", 7, Font.NORMAL, BaseColor.BLACK)));
                        PdfPCell cel91 = new PdfPCell(new Paragraph(jabatan.toString(), FontFactory.getFont("Arial", 7, Font.NORMAL, BaseColor.BLACK)));

                        tbl.addCell(cel11);
                        tbl.addCell(cel21);
                        tbl.addCell(cel31);
                        tbl.addCell(cel41);
                        tbl.addCell(cel51);
                        tbl.addCell(cel61);
                        tbl.addCell(cel71);
                        tbl.addCell(cel81);
                        tbl.addCell(cel91);
                    }
                    
                    document.add(tbl);
                    document.close();
                } catch (Exception ex) {
                    ex.getMessage();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        } finally {
            out.close();
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
