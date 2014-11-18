/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
import jose.junnon.model.Usermain;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author krunal
 */
public class UsermainDao {

    HibernateUtil hibernateUtil = new HibernateUtil();

    public void addUsermain(Usermain usermain) {
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//      Integer employeeID = null;
        tx = session.beginTransaction();
        Usermain employee = new Usermain();
//            employee.setId(3l);
        employee.setUsername(usermain.getUsername());
        employee.setPassword1(usermain.getPassword1());
        session.save(employee);
        tx.commit();
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public void deleteUsermain() {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("delete Usermain where id = :id");
        
        q.executeUpdate();
        session.close();
        hibernateUtil.removeSessionFactory();
    }
   public List<Usermain> retriveAll(){
       Session session=hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Usermain.class);
         List<Usermain> result=c.list();
           session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
         return  result;
   }

    public List<Usermain> retriveById(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Usermain.class);
        c.add(Restrictions.eq("id", id));
        List<Usermain> result=c.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return result;

    }

    public void updateUsermain(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
//            Transaction tx = null;
//        tx = session.beginTransaction();
        Query query = session.createQuery("update Usermain set username = :stockName"
                + " where  id= :stockCode");
        query.setParameter("stockName", "vrushank");
        query.setParameter("stockCode", 1l);
        int result = query.executeUpdate();
        System.out.println(result);
        session.close();
        hibernateUtil.removeSessionFactory();
    }
    public List<Usermain> doLogin(String username,String password){
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c=session.createCriteria(Usermain.class);
        c.add(Restrictions.eq("username", username));
        c.add(Restrictions.eq("password1", password));
        List<Usermain> list=c.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return list;
    }
}