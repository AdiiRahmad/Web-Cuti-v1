/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.DetailKaryawan;
import java.util.List;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;


/**
 *
 * @author Siti Khusnul Azifah
 */
public class DetailKaryawanDAO implements InterfaceCutiDAO {

    public SessionFactory factory;
    public FunctionsDAO fdao;

    public DetailKaryawanDAO() {
        this.fdao = new FunctionsDAO(HibernateUtil.getSessionFactory());
    }

    @Override
    public boolean insert(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean delete(Object object) {
        return fdao.delete(DetailKaryawan.class, Short.decode(object + ""));
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM DetailKaryawan");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM DetailKaryawan WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from DetailKaryawan where nik='" + id + "'");
    }

}
