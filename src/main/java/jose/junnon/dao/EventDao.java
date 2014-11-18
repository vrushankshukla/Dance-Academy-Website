/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;


import java.util.List;
import jose.junnon.model.Event;
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
public class EventDao {

    HibernateUtil hibernateUtil = new HibernateUtil();

    public void addEvent(Event event) {
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//      Integer employeeID = null;
        tx = session.beginTransaction();
        Event event1 = new Event();
//            event.setId(3l);
        event1.setTitle(event.getTitle());

        event1.setStartdate(event.getStartdate());
        event1.setEnddate(event.getEnddate());

        event1.setDescription(event.getDescription());
        event1.setPhoto(event.getPhoto());
        event1.setPlace(event.getPlace());
        session.save(event);
        tx.commit();
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public void deleteEvent(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("delete Event where id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public List<Event> retriveEventById(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Event.class);
        c.add(Restrictions.eq("id", id));
        List<Event> result=c.list();
session.flush();
session.close();
hibernateUtil.removeSessionFactory();
        return result;

    }

    public void updateEvent(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
//            Transaction tx = null;
//        tx = session.beginTransaction();
        Query query = session.createQuery("update Event set title = :stockName"
                + " where  id= :stockCode");
        query.setParameter("stockName", "vrushank");
        query.setParameter("stockCode", 2l);
        int result = query.executeUpdate();
        System.out.println(result);
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public List<Event> retriveAllEvent() {
        Session session = this.hibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Event.class) .addOrder(Property.forName("id").desc());
       List<Event> list=criteria.list();
        session.flush();
      session.close();
hibernateUtil.removeSessionFactory();
        return list;
    }
}
