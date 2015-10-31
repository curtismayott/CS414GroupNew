package test;

import objects.Address;
import objects.Employee;
import objects.Phone;
import objects.ROLE;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/** 
* Employee Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 27, 2015</pre> 
* @version 1.0 
*/ 
public class EmployeeTest {

    Employee e;

@Before
public void before() throws Exception {
    e = new Employee("bob bobby", new Address("street","city","state","zip"), new Phone("303-555-7930"),"userbob","123", ROLE.CASHIER);
    e.setUserID(0);
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
    String expected = "0 bob bobby CASHIER";
    assertEquals(expected,e.toString());
} 

/** 
* 
* Method: getUserID() 
* 
*/ 
@Test
public void testGetUserID() throws Exception { 
    int expected = 0;
    assertEquals(expected,e.getUserID());
} 

/** 
* 
* Method: setUserID(int userID) 
* 
*/ 
@Test
public void testSetUserID() throws Exception { 
    int expected = 1;
    e.setUserID(expected);
    assertEquals(expected,e.getUserID());
} 

/** 
* 
* Method: getUsername() 
* 
*/ 
@Test
public void testGetUsername() throws Exception {
    String expected = "userbob";
    assertEquals(expected,e.getUsername());
} 

/** 
* 
* Method: setUsername(String username) 
* 
*/ 
@Test
public void testSetUsername() throws Exception {
    String expected = "bobby";
    e.setUsername(expected);
    assertEquals(expected,e.getUsername());
} 

/** 
* 
* Method: getAuthentication() 
* 
*/ 
@Test
public void testGetAuthentication() throws Exception { 
    String expected = "123";
    assertEquals(expected,e.getAuthentication());
} 

/** 
* 
* Method: setAuthentication(String authentication) 
* 
*/ 
@Test
public void testSetAuthentication() throws Exception {
    String expected = "1234";
    e.setAuthentication(expected);
    assertEquals(expected, e.getAuthentication());
} 

/** 
* 
* Method: setRole(Role role) 
* 
*/ 
@Test
public void testSetRole() throws Exception {
    e.setRole(ROLE.CHEF);
    assertEquals(e.getRole(),ROLE.CHEF);
} 

/** 
* 
* Method: getRole() 
* 
*/ 
@Test
public void testGetRole() throws Exception {
    assertEquals(e.getRole(),ROLE.CASHIER);
} 


} 
