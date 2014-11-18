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
public class AchievementDaoTest {
    
    public AchievementDaoTest() {
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
     * Test of addUsermain method, of class AchievementDao.
     */
//    @Test
    public void testAddUsermain() {
        System.out.println("addUsermain");
        AchievementDao instance = new AchievementDao();
//        instance.addAchievement();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUsermain method, of class AchievementDao.
     */
    
//    @Test
    public void testDeleteUsermain() {
        System.out.println("deleteUsermain");
        AchievementDao instance = new AchievementDao();
//        instance.deleteAchievement();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

  



    /**
     * Test of retriveById method, of class AchievementDao.
     */
//    @Test
    public void testRetriveAchievementById() {
        System.out.println("retriveAchievementById");
        Long id = 3l;
        AchievementDao achievementDao = new AchievementDao();
        List expResult = null;
        List result = achievementDao.retriveAchievementById(id);
        System.out.println(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateAchievement() {
        System.out.println("updateAchievement");
        Long id = null;
        AchievementDao instance = new AchievementDao();
        instance.updateAchievement(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
