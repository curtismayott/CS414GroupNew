package test;

import server.objects.Topping;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** 
* Topping Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 27, 2015</pre> 
* @version 1.0 
*/ 
public class ToppingTest {

    Topping t1;

@Before
public void before() throws Exception {
    t1 = new Topping("A","anchovies");
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
    String expected = "anchovies";
    assertEquals(expected,t1.toString());
} 

/** 
* 
* Method: equals(Object o) 
* 
*/ 
@Test
public void testEquals() throws Exception {
    Topping t2 = new Topping("A","anchovies");
    assertEquals(t1,t2);

}
@Test
public void testNotEquals() throws Exception {
    Topping t3 = new Topping("B","beans");
    assertNotEquals(t1,t3);
}

/** 
* 
* Method: getShortName() 
* 
*/ 
@Test
public void testGetShortName() throws Exception { 
    assertEquals(t1.getShortName(),"A");
} 

/** 
* 
* Method: setShortName(String shortName) 
* 
*/ 
@Test
public void testSetShortName() throws Exception { 
    t1.setShortName("E");
    assertEquals(t1.getShortName(),"E");
} 

/** 
* 
* Method: getFullName() 
* 
*/ 
@Test
public void testGetFullName() throws Exception { 
    assertEquals(t1.getFullName(),"anchovies");
} 

/** 
* 
* Method: setFullName(String fullName) 
* 
*/ 
@Test
public void testSetFullName() throws Exception {
    t1.setFullName("hocuspocus");
    assertEquals(t1.getFullName(),"hocuspocus");
} 


} 
