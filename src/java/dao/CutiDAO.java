/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Cuti;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;



/**
 *
 * @author Siti Khusnul Azifah
 */
public class CutiDAO implements InterfaceCutiDAO {

    public SessionFactory factory;
    private Session session;
    private Transaction transaction;
    public FunctionsDAO fdao;

    public CutiDAO() {
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
        return fdao.delete(Cuti.class,object.toString());
    }


    public List<Object> getAll() {
        return fdao.getAll("From Cuti");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("From Cuti WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Cuti where idCuti='" + id + "'");
    }
    
    public String getAutoID () {
        return (String) fdao.getById("SELECT CONCAT('C',LPAD((TO_NUMBER(SUBSTR(MAX(id_cuti),2))+1),3, '0')) as MAX FROM Cuti");
    }

}
