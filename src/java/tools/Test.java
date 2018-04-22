/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import dao.CutiDAO;
import dao.DetailCutiDAO;
import entities.Cuti;
import java.util.List;

/**
 *
 * @author Siti Khusnul Azifah
 */
public class Test {

    public static void main(String[] args) {
//             List<Object> data = new KaryawanDAO()
        List<Object> data = new CutiDAO()
                .getAll();

        data.stream().map((object) -> (Cuti) object).forEachOrdered((emp) -> {
            System.out.println(emp.getJenisCuti()
            );
        });

        System.out.println(new DetailCutiDAO().getAutoID());
    }
}
