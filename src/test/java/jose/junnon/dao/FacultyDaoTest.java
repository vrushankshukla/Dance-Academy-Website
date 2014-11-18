/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
import jose.junnon.model.Faculty;
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
public class FacultyDaoTest {
    
    public FacultyDaoTest() {
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
     * Test of addUsermain method, of class FacultyDao.
     */
//    @Test
    public void testAddFaculty() throws Exception {
        System.out.println("addFaculty");
        FacultyDao instance = new FacultyDao();
//        instance.addFaculty();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    

    /**
     * Test of deleteFaculty method, of class FacultyDao.
     */
//    @Test
    public void testDeleteFaculty() {
        System.out.println("deleteFaculty");
        FacultyDao instance = new FacultyDao();
//        instance.deleteFaculty();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of retriveById method, of class FacultyDao.
     */
    @Test
    public void testRetriveById() {
        System.out.println("retriveById");
        Long id = 1l;
        FacultyDao instance = new FacultyDao();
        List expResult = null;
        List result = instance.retriveById(id);
        System.out.println(result);
//        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFaculty method, of class FacultyDao.
     */
//    @Test
    public void testUpdateFaculty() {
        System.out.println("updateFaculty");
        Long id = null;
        FacultyDao instance = new FacultyDao();
        instance.updateFaculty(new Faculty(),id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
