/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit_example;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eucosta
 */
public class JUnitExampleTest {
    
    public JUnitExampleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Executing @BeforeClass... heavy stuff running here...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Executing @AfterClass... that's all, folks!");
    }
    
    @Before
    public void setUp() {
        System.out.println("Executing @Before... right before this one method...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Executing @After... and this one is done...");
    }

    /**
     * Test of sum method, of class JUnitExample.
     */
    @Test
    public void testGoodSum() {
        System.out.println("goodSum");
        int var1 = 10;
        int var2 = 5;
        
        JUnitExample instance = new JUnitExample();
        int expResult = 15;
        int result = instance.goodSum(var1, var2);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBadSum() {
        System.out.println("badSum");
        int var1 = 10;
        int var2 = 5;
        
        JUnitExample instance = new JUnitExample();
        int expResult = 15;
        int result = instance.badSum(var1, var2);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAssertEquals() {
        System.out.println("testAssertEquals");
        String obj1 = "junit";
        String obj2 = "junit";
        
        assertEquals(obj1, obj2);
    }
    
    @Test
    public void testAssertSame() {
        System.out.println("testAssertSame");
        String obj1 = "junit";
        String obj2 = "junit";

        assertSame(obj1, obj1);
    }
    
    @Test
    public void testAssertNotSame() {
        System.out.println("testAssertNotSame");
        String obj1 = "junit";
        String obj3 = "test";

        assertNotSame(obj1, obj3);
    }

    @Test
    public void testAssertNotNull() {
        System.out.println("testAssertNotNull");
        String obj1 = "junit";
       
        assertNotNull(obj1);
    }
     
    @Test
    public void testAssertNull() {
        System.out.println("testAssertNull");
        String obj5 = null;

        assertNull(obj5);
    }
      
    @Test
    public void testAssertTrue() {
        System.out.println("testAssertTrue");
        Boolean var1 = true;
       
        assertTrue("Th condition is true!", var1);
    }
    
    @Test
    public void testAssertArrayEquals() {
        System.out.println("testAssertArrayEquals");
        int[] arithmetic1 = { 1, 2, 3 };
        int[] arithmetic2 = { 1, 2, 3 };

        assertArrayEquals(arithmetic1, arithmetic2);
    }
}
