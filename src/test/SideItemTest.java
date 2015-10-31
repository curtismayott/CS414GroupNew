package test;

import objects.SideItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/** 
* SideItem Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 27, 2015</pre> 
* @version 1.0 
*/ 
public class SideItemTest {
    SideItem s;

@Before
public void before() throws Exception {
    s = new SideItem("garlic knots",3.50);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception { 
    assertEquals(s.toString(),"garlic knots   3.5");
} 

/** 
* 
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception { 
    assertEquals(s.getName(),"garlic knots");
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception { 
    s.setName("garlic balls");
    assertEquals(s.getName(),"garlic balls");
} 


} 
