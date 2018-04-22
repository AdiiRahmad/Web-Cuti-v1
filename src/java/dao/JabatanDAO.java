/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Jabatan;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;


/**
 *
 * @author Siti Khusnul Azifah
 */
public class JabatanDAO implements InterfaceCutiDAO {

    public SessionFactory factory;

    public FunctionsDAO fdao;

    public JabatanDAO() {
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
        return fdao.delete(Jabatan.class, (Serializable) object);
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM Jabatan");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Jabatan WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Jabatan where idJabatan='" + id + "'");
    }
    
    public String getAutoID () {
        return (String) fdao.getById("SELECT CONCAT('J',LPAD((TO_NUMBER(SUBSTR(MAX(idJabatan),2))+1),3, '0')) as MAX FROM Jabatan");
    }

}
