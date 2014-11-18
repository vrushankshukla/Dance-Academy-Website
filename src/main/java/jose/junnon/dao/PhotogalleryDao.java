/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
//import josh.junoon.model.Photogallery;
import jose.junnon.model.Album;
import jose.junnon.model.Photogallery;
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
public class PhotogalleryDao {
     HibernateUtil hibernateUtil = new HibernateUtil();

    public void addPhoto(Photogallery photogallery) {
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//      Integer employeeID = null;
        tx = session.beginTransaction();
        Photogallery photogallery1 = new Photogallery();
//            employee.setId(3l);
        photogallery1.setPhoto(photogallery.getPhoto());
        photogallery1.setDescription(photogallery.getDescription());
        photogallery1.setAlbum(photogallery.getAlbum());
        
        session.save(photogallery1);
        tx.commit();
        session.close();
        hibernateUtil.removeSessionFactory();
}
     public void deletePhoto(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("delete Photogallery where id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public List<Photogallery> retrivePhotoById(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Photogallery.class);
        c.add(Restrictions.eq("id", id));

       List<Photogallery> result=c.list();
session.flush();
session.close();
hibernateUtil.removeSessionFactory();
        return result;

    }

    public void updatePhoto(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
//            Transaction tx = null;
//        tx = session.beginTransaction();
        Query query = session.createQuery("update Photogallery set photo = :stockName"
                + " where  id= :stockCode");
        query.setParameter("stockName", "vrushank");
        query.setParameter("stockCode", 1l);
        int result = query.executeUpdate();
        System.out.println(result);
        session.close();
        hibernateUtil.removeSessionFactory();
    }
   public List<Photogallery> retriveAll(){
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c=session.createCriteria(Photogallery.class) .addOrder(Property.forName("id").desc());
        List<Photogallery> list=c.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return list;
   }
   public List<Photogallery> retrivePhotoByAlblumId(Album id){
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c=session.createCriteria(Photogallery.class);
        c.add(Restrictions.eq("album", id));
        List<Photogallery> list=c.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return list;
       
   }
}