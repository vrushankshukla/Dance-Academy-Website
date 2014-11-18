/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
import jose.junnon.model.PersonInfo;
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
public class PersonInfoDao {
     HibernateUtil hibernateUtil = new HibernateUtil();

    public void addPersonInfo(PersonInfo personInfo) {
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//      Integer employeeID = null;
        tx = session.beginTransaction();
        PersonInfo personInfo1 = new PersonInfo();
//            event.setId(3l);
        personInfo1.setName(personInfo.getName());
        personInfo1.setPhoneNumber(personInfo.getPhoneNumber());
        personInfo1.setEmailId(personInfo.getEmailId());
        session.save(personInfo);
        tx.commit();
        session.close();
        hibernateUtil.removeSessionFactory();
        
    }

    public void deletePersonInfo(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("delete PersonInfo where id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public List<PersonInfo> retrivePersonInfoById(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(PersonInfo.class);
        c.add(Restrictions.eq("id", id));
        List<PersonInfo> result=c.list();
session.flush();
session.close();
hibernateUtil.removeSessionFactory();
        return result;

    }


    public List<PersonInfo> retriveAllPersonInfo() {
        Session session = this.hibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(PersonInfo.class) .addOrder(Property.forName("id").desc());
        List<PersonInfo> list=criteria.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return list;
    }
}
