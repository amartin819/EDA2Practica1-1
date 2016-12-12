/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.tree;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alejandro
 */
public class LCSRTreeTest {
    
    public LCSRTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of size method, of class LCSRTree.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LCSRTree instance = new LCSRTree();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class LCSRTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LCSRTree instance = new LCSRTree();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInternal method, of class LCSRTree.
     */
    @Test
    public void testIsInternal() {
        System.out.println("isInternal");
        LCSRTree instance = new LCSRTree();
        boolean expResult = false;
        boolean result = instance.isInternal(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLeaf method, of class LCSRTree.
     */
    @Test
    public void testIsLeaf() {
        System.out.println("isLeaf");
        LCSRTree instance = new LCSRTree();
        boolean expResult = false;
        boolean result = instance.isLeaf(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRoot method, of class LCSRTree.
     */
    @Test
    public void testIsRoot() {
        System.out.println("isRoot");
        LCSRTree instance = new LCSRTree();
        boolean expResult = false;
        boolean result = instance.isRoot(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of root method, of class LCSRTree.
     */
    @Test
    public void testRoot() {
        System.out.println("root");
        LCSRTree instance = new LCSRTree();
        Position expResult = null;
        Position result = instance.root();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parent method, of class LCSRTree.
     */
    @Test
    public void testParent() {
        System.out.println("parent");
        LCSRTree instance = new LCSRTree();
        Position expResult = null;
        Position result = instance.parent(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of children method, of class LCSRTree.
     */
    @Test
    public void testChildren() {
        System.out.println("children");
        LCSRTree instance = new LCSRTree();
        Iterable<? extends Position<E>> expResult = null;
        Iterable<? extends Position<E>> result = instance.children(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class LCSRTree.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        LCSRTree instance = new LCSRTree();
        Iterator<Position<E>> expResult = null;
        Iterator<Position<E>> result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class LCSRTree.
     */
    @Test
    public void testReplace() {
        System.out.println("replace");
        LCSRTree instance = new LCSRTree();
        Object expResult = null;
        Object result = instance.replace(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRoot method, of class LCSRTree.
     */
    @Test
    public void testAddRoot() {
        System.out.println("addRoot");
        Object e = null;
        LCSRTree instance = new LCSRTree();
        Position expResult = null;
        Position result = instance.addRoot(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swapElements method, of class LCSRTree.
     */
    @Test
    public void testSwapElements() {
        System.out.println("swapElements");
        LCSRTree instance = new LCSRTree();
        instance.swapElements(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class LCSRTree.
     */
    @Test
    public void testAdd_GenericType_Position() {
        System.out.println("add");
        LCSRTree instance = new LCSRTree();
        Position expResult = null;
        Position result = instance.add(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class LCSRTree.
     */
    @Test
    public void testAdd_3args() {
        System.out.println("add");
        LCSRTree instance = new LCSRTree();
        Position expResult = null;
        Position result = instance.add(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class LCSRTree.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        LCSRTree instance = new LCSRTree();
        instance.remove(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasChild method, of class LCSRTree.
     */
    @Test
    public void testHasChild() {
        System.out.println("hasChild");
        LCSRTree instance = new LCSRTree();
        boolean expResult = false;
        boolean result = instance.hasChild(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasBro method, of class LCSRTree.
     */
    @Test
    public void testHasBro() {
        System.out.println("hasBro");
        LCSRTree instance = new LCSRTree();
        boolean expResult = false;
        boolean result = instance.hasBro(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
