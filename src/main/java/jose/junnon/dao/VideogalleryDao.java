/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
import jose.junnon.model.Videogallery;
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
public class VideogalleryDao {
     HibernateUtil hibernateUtil = new HibernateUtil();

    public void addVideo(Videogallery videogallery) {
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//      Integer employeeID = null;
        tx = session.beginTransaction();
        Videogallery videogallery1 = new Videogallery();
//            employee.setId(3l);
        videogallery1.setVideo(videogallery.getVideo());
        
        session.save(videogallery1);
        tx.commit();
        session.close();
        hibernateUtil.removeSessionFactory();
}
      public void deleteVideo(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("delete Videogallery where id = :id");
      q.setParameter("id", id);
        q.executeUpdate();
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public List<Videogallery> retriveVideoById(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Videogallery.class);
        c.add(Restrictions.eq("id", id));
        List<Videogallery> result=c.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return result;

    }

//    public void updateVideo(Long id) {
//        Session session = hibernateUtil.getSessionFactory().openSession();
////            Transaction tx = null;
////        tx = session.beginTransaction();
//        Query query = session.createQuery("update Videogallery set video = :stockName"
//                + " where  id= :stockCode");
//        query.setParameter("stockName", "vrushank");
//        query.setParameter("stockCode", 1l);
//        int result = query.executeUpdate();
//        System.out.println(result);
//        session.close();
//    }

   public List<Videogallery> retriveAllVideos(){
        Session session = this.hibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Videogallery.class) .addOrder(Property.forName("id").asc());
        List<Videogallery> list=criteria.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return list;
}
}
