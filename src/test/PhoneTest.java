package test;

import server.objects.Phone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** 
* Phone Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 27, 2015</pre> 
* @version 1.0 
*/ 
public class PhoneTest {

    Phone p;

@Before
public void before() throws Exception { 
    p = new Phone("970-555-0987");
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
    assertEquals(p.toString(), "970-555-0987");
} 

/** 
* 
* Method: getNumber() 
* 
*/ 
@Test
public void testGetNumber() throws Exception {
    assertEquals(p.getNumber(), "970-555-0987");
} 

/** 
* 
* Method: setNumber(String number) 
* 
*/ 
@Test
public void testSetNumber() throws Exception { 
    String expected = "970-555-1234";
    p.setNumber(expected);
    assertEquals(expected,p.getNumber());
} 


} 
