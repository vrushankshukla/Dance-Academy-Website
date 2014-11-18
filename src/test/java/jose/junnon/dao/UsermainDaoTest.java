/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import jose.junnon.model.Usermain;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krunal
 */
public class UsermainDaoTest {
    
    public UsermainDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUsermain method, of class UsermainDao.
     */
//    @Test
    public void testAddUsermain() {
        System.out.println("addUsermain");
        UsermainDao instance = new UsermainDao();
        Usermain usermain=new Usermain();
        usermain.setPassword1("vrushank");
        usermain.setUsername("manan");
        instance.addUsermain(usermain);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUsermain method, of class UsermainDao.
     */
//    @Test
    public void testDeleteUsermain() {
        System.out.println("deleteUsermain");
        UsermainDao instance = new UsermainDao();
        instance.deleteUsermain();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of retriveById method, of class UsermainDao.
     */
//    @Test
    public void testRetriveById() {
        System.out.println("retriveById");
        Long id = 1l;
        UsermainDao instance = new UsermainDao();
//        List expResult = null;
        List<Usermain> result = instance.retriveById(id);
        for(Usermain u:result){
            System.out.println(u.getUsername()+"  "+u.getPassword1());
        }
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUsermain method, of class UsermainDao.
     */
//    @Test
    public void testUpdateUsermain() {
        System.out.println("updateUsermain");
        Long id = 1l;
        UsermainDao instance = new UsermainDao();
        instance.updateUsermain(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of doLogin method, of class UsermainDao.
     */
    @Test
    public void testDoLogin() {
        System.out.println("doLogin");
        String username = "manan";
        String password = "vrushank";
        UsermainDao instance = new UsermainDao();
//        List expResult = null;
        List<Usermain> result = instance.doLogin(username, password);
        for(Usermain u:result){
            System.out.println(u.getId());
        }
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
