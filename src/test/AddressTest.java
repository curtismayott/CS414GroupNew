package test;

import server.objects.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** 
* Address Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 27, 2015</pre> 
* @version 1.0 
*/ 
public class AddressTest {

    Address a;

@Before
public void before() throws Exception {
    a = new Address("streetAddr","city","state","90210");
}

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getStreetAddress() 
* 
*/ 
@Test
public void testGetStreetAddress() throws Exception {
    String expected = "streetAddr";
    assertEquals(expected,a.getStreetAddress());
} 

/** 
* 
* Method: setStreetAddress(String streetAddress) 
* 
*/ 
@Test
public void testSetStreetAddress() throws Exception { 
    String expected = "newAddr";
    a.setStreetAddress("newAddr");
    assertEquals(expected,a.getStreetAddress());
} 

/** 
* 
* Method: getCity() 
* 
*/ 
@Test
public void testGetCity() throws Exception { 
    String expected = "city";
    assertEquals(expected,a.getCity());
} 

/** 
* 
* Method: setCity(String city) 
* 
*/ 
@Test
public void testSetCity() throws Exception { 
    String expected = "newCity";
    a.setCity(expected);
    assertEquals(expected,a.getCity());
} 

/** 
* 
* Method: getState() 
* 
*/ 
@Test
public void testGetState() throws Exception { 
    String expected = "state";
    assertEquals(expected,a.getState());
} 

/** 
* 
* Method: setState(String state) 
* 
*/ 
@Test
public void testSetState() throws Exception { 
    String expected = "newState";
    a.setState(expected);
    assertEquals(expected,a.getState());
} 

/** 
* 
* Method: getZipcode() 
* 
*/ 
@Test
public void testGetZipcode() throws Exception { 
    String expected = "90210";
    assertEquals(expected,a.getZipcode());
} 

/** 
* 
* Method: setZipcode(String zipcode) 
* 
*/ 
@Test
public void testSetZipcode() throws Exception { 
    String expected = "90210";
    a.setZipcode(expected);
    assertEquals(expected,a.getZipcode());
} 


} 
