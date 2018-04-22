/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.KaryawanDAO;
import entities.Karyawan;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 *
 * @author Siti Khusnul Azifah
 */
public class Test {
    public static void main(String[] args) {
             List<Object> data = new KaryawanDAO()
                .getAll();
    
         for (Object object : data) {
            Karyawan emp = (Karyawan) object;
            System.out.println(emp.getNik()
            );
        }
    }
}

