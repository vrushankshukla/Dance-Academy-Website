/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.dao;

import java.util.List;
import jose.junnon.model.Photogallery;
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
public class PhotogalleryDaoTest {
    
    public PhotogalleryDaoTest() {
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
     * Test of addUsermain method, of class PhotogalleryDao.
     */
//    @Test
    public void testAddPhoto() {
        System.out.println("addUsermain");
        Photogallery p=new Photogallery();
        p.setDescription("test");
        p.setPhoto("test");
        PhotogalleryDao instance = new PhotogalleryDao();
        instance.addPhoto(p);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePhoto method, of class PhotogalleryDao.
     */
//    @Test
    public void testDeletePhoto() {
        System.out.println("deletePhoto");
        Long id=2l;
        PhotogalleryDao instance = new PhotogalleryDao();
        Photogallery   p=new Photogallery();
        instance.deletePhoto(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of retrivePhotoById method, of class PhotogalleryDao.
     */
//    @Test
    public void testRetrivePhotoById() {
        System.out.println("retrivePhotoById");
        Long id = 1l;
        PhotogalleryDao instance = new PhotogalleryDao();
        List expResult = null;
        List result = instance.retrivePhotoById(id);
        System.out.println(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePhoto method, of class PhotogalleryDao.
     */
//    @Test
    public void testUpdatePhoto() {
        System.out.println("updatePhoto");
        Long id = null;
        PhotogalleryDao instance = new PhotogalleryDao();
        instance.updatePhoto(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of retriveAll method, of class PhotogalleryDao.
     */
    @Test
    public void testRetriveAll() {
        System.out.println("retriveAll");
        PhotogalleryDao instance = new PhotogalleryDao();
        List expResult = null;
        List<Photogallery> result = instance.retriveAll();
    for(Photogallery p:result){
        System.out.println(p.getDescription());
    }
    }
}
