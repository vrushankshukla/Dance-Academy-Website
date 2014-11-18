/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
import javax.persistence.RollbackException;
import jose.junnon.model.Achievement;
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
public class AchievementDao {
     HibernateUtil hibernateUtil = new HibernateUtil();

    public void addAchievement(Achievement achievement) throws RollbackException {
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//      Integer employeeID = null;
        tx = (Transaction) session.beginTransaction();
     Achievement achievement1 = new Achievement();
//            achievement.setId(3l);
        achievement1.setTitle(achievement.getTitle());
        achievement1.setPhoto(achievement.getPhoto());
        achievement1.setDescription(achievement.getDescription());
        session.save(achievement1);
        tx.commit();
        session.close();
        hibernateUtil.removeSessionFactory();
    }
     public void deleteAchievement(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("delete Achievement where id = :id");
      q.setParameter("id", id);
        q.executeUpdate();
        session.close();
        hibernateUtil.removeSessionFactory();
    }
public List<Achievement> retriveAchievementById(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Achievement.class);
        c.add(Restrictions.eq("id", id));
        List<Achievement> result=c.list();
session.flush();
session.close();
hibernateUtil.removeSessionFactory();
        return result;

    }
public void updateAchievement(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
//            Transaction tx = null;
//        tx = session.beginTransaction();
        Query query = session.createQuery("update Achievement set title = :stockName"
                + " where  id= :stockCode");
        query.setParameter("stockName", "vrushank");
        query.setParameter("stockCode", 1l);
        int result = query.executeUpdate();
        System.out.println(result);
        session.close();
        hibernateUtil.removeSessionFactory();
    }
public List<Achievement> retriveAllAchievment(){
        Session session = this.hibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Achievement.class) .addOrder(Property.forName("id").desc());
         List<Achievement> list=criteria.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return list;
        
}
}

