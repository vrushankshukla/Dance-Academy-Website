/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
import javax.transaction.RollbackException;
//import javax.transaction.Transaction;
import jose.junnon.model.Faculty;
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
public class FacultyDao {
     HibernateUtil hibernateUtil = new HibernateUtil();

    public void addFaculty(Faculty faculty) throws RollbackException {
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//      Integer employeeID = null;
        tx = (Transaction) session.beginTransaction();
        Faculty faculty1 = new Faculty();
//            employee.setId(3l);
        faculty1.setName(faculty.getName());
        faculty1.setPhoto(faculty.getPhoto());
        faculty1.setDescription(faculty.getDescription());
        session.save(faculty);
        tx.commit();
        session.close();
        hibernateUtil.removeSessionFactory();
    }
   public void deleteFaculty(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("delete Faculty where id = :id");
      q.setParameter("id", id);
        q.executeUpdate();
        session.close();
        hibernateUtil.removeSessionFactory();
    }

    public List<Faculty> retriveById(Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Faculty.class);
        c.add(Restrictions.eq("id", id));
List<Faculty> result=c.list();
session.flush();
session.close();
hibernateUtil.removeSessionFactory();
        return result;

    }

    public void updateFaculty(Faculty faculty,Long id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
        tx = session.beginTransaction();
        Query query = session.createQuery("update Faculty set name = :Name, description = :Description,photo = :photo, designation = :Designation "
                + " where  id= :id");
         query.setParameter("Name", faculty.getName());
         query.setParameter("photo", faculty.getPhoto());
         query.setParameter("Designation",faculty.getDesignation());
        query.setParameter("Description", faculty.getDescription());
        query.setParameter("id",id);
        int result = query.executeUpdate();
        tx.commit();
//        System.out.println(result);
        session.close();
        hibernateUtil.removeSessionFactory();
    }
    public List<Faculty> retriveAllFaculty(){
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Faculty.class)
         .addOrder(Property.forName("id").asc());
        List<Faculty> list=criteria.list();
        session.flush();
        session.close();
        hibernateUtil.removeSessionFactory();
        return list;
}
}
