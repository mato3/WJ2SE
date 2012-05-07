/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topology.storage;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Mao
 */
public class StorageTest {
    Storage instance;
    Aisle a = new Aisle(1,1);
    Rack r = new Rack(1,1);
    public StorageTest() {
        instance = new Storage();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Object object = a;
        //Storage instance = new Storage();
        
        instance.insert(object);
        
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        Object object = a;
        //Storage instance = new Storage();
        instance.remove(object);
    
    }

    @Test
    public void testFind() {
        System.out.println("find");
        String key = "R1";
        instance.insert(r);
        Object expResult = r;
        Object result = instance.find(key);
        assertEquals(expResult, result);
      
    }
}
