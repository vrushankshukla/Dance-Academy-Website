/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;


import java.util.List;
import jose.junnon.model.Album;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author krunal
 */
public class AlbumDao {
 HibernateUtil hibernateUtil = new HibernateUtil();

 public void addAlbum(Album album){
      Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//      Integer employeeID = null;
        tx = (Transaction) session.beginTransaction();
        Album a=new Album();
        a.setPhoto(album.getPhoto());
        a.setTitle(album.getTitle());
        a.setisactive(Boolean.TRUE);
        session.save(a);
        tx.commit();
//        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
 }
 public List<Album> retriveAlbum(){
      Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Album.class).addOrder(Property.forName("id").desc());
        c.add(Restrictions.eq("isactive",true));
        
        List<Album> result=c.list();
session.flush();
session.close();
hibernateUtil.removeSessionFactory();
        return result;

 }
 public void deleteAlbum(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("update Album set isactive = :isactive where id = :id");
         q.setParameter("isactive",Boolean.FALSE);
        q.setParameter("id", id);
        q.executeUpdate();
        session.close();
        hibernateUtil.removeSessionFactory();
    }
}