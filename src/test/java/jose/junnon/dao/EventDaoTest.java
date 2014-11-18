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
public class EventDaoTest {
    
    public EventDaoTest() {
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
     * Test of addUsermain method, of class EventDao.
     */
//    @Test
    public void testAddEvent() throws Exception {
        System.out.println("addEvent");
        EventDao instance = new EventDao();
//        instance.addEvent();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEvent method, of class EventDao.
     */
    @Test
    public void testDeleteEvent() {
        System.out.println("deleteEvent");
        EventDao instance = new EventDao();
        instance.deleteEvent(2l);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of retriveEventById method, of class EventDao.
     */
//    @Test
    public void testRetriveEventById() {
        System.out.println("retriveEventById");
        Long id = 2l;
        EventDao instance = new EventDao();
        List expResult = null;
        List result = instance.retriveEventById(id);
        System.out.println(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEvent method, of class EventDao.
     */
//    @Test
    public void testUpdateEvent() {
        System.out.println("updateEvent");
        Long id = null;
        EventDao instance = new EventDao();
        instance.updateEvent(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
