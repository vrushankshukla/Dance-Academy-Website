  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author krunal
 */
public class HibernateUtil {

    public  SessionFactory sessionFactory;
    
         
    
    public  SessionFactory getSessionFactory() {
     sessionFactory = new Configuration().configure().buildSessionFactory();
     
        return sessionFactory;
    }
    public void removeSessionFactory(){
        sessionFactory.close();
    }
}
