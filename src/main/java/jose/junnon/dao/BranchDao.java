/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
import jose.junnon.model.Branch;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author SONY
 */
public class BranchDao {
    
    HibernateUtil hibernateUtil = new HibernateUtil();

    public void addBranch(Branch branch) {
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//      Integer employeeID = null;
        tx = session.beginTransaction();
        Branch branch1=new Branch();
//            event.setId(3l);
        branch1.setBranchName(branch.getBranchName());
        branch1.setLine1(branch.getLine1());
        branch1.setLine2(branch.getLine2());
        branch1.setLine3(branch.getLine3());
        branch1.setLine4(branch.getLine4());
        branch1.setPhoto(branch.getPhoto());
        branch1.setLatitude(branch.getLatitude());
        branch1.setLongitude(branch.getLongitude());
        session.save(branch1);
        tx.commit();
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public void deleteBranch(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("delete Branch where id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public List<Branch> retriveBranchById(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Branch.class) .addOrder(Property.forName("id").asc());
        c.add(Restrictions.eq("id", id));
       List<Branch> result=c.list();
session.flush();
session.close();
hibernateUtil.removeSessionFactory();
        return result;


    }



    public List<Branch> retriveAllBranch() {
        Session session = this.hibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Branch.class);
         List<Branch> list=criteria.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return list;
    }

}
