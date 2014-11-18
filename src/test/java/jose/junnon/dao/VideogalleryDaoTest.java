/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SONY
 */
public class VideogalleryDaoTest {
    
    public VideogalleryDaoTest() {
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
     * Test of addVideo method, of class VideogalleryDao.
     */
    @Test
    public void testAddVideo() {
        System.out.println("addVideo");
        VideogalleryDao instance = new VideogalleryDao();
//        instance.addVideo();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteVideo method, of class VideogalleryDao.
     */
//    @Test
    public void testDeleteVideo() {
        System.out.println("deleteVideo");
        VideogalleryDao instance = new VideogalleryDao();
//        instance.deleteVideo();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of retriveById method, of class VideogalleryDao.
     */
//    @Test
    public void testRetriveVideoById() {
        System.out.println("retriveById");
        Long id = 1l;
        VideogalleryDao instance = new VideogalleryDao();
        List expResult = null;
        List result = instance.retriveVideoById(id);
        System.out.println(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVideo method, of class VideogalleryDao.
     */
   
}
