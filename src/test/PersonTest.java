package test;

import objects.Address;
import objects.Person;
import objects.Phone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/** 
* Person Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 27, 2015</pre> 
* @version 1.0 
*/ 
public class PersonTest { 

    Person p;

@Before
public void before() throws Exception { 
    p = new Person("billy", new Address("345 street st", "cityville", "ST", "99999"), new Phone("343-434-3434"));
}

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception { 
    String expected = "dude";
    p.setName(expected);
    assertEquals(expected,p.getName());
} 

/** 
* 
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception { 
    String expected = "billy";
    assertEquals(expected,p.getName());
} 

/** 
* 
* Method: getAddresses() 
* 
*/ 
@Test
public void testGetAddresses() throws Exception { 
    ArrayList<Address> expected = new ArrayList<>();
    expected.add(new Address("345 street st", "cityville", "ST", "99999"));
    assertEquals(expected,p.getAddresses());
} 

/** 
* 
* Method: getPhoneNumbers() 
* 
*/ 
@Test
public void testGetPhoneNumbers() throws Exception { 
    ArrayList<Phone> expected = new ArrayList<>();
    expected.add(new Phone("343-434-3434"));
    assertEquals(expected,p.getPhoneNumbers());
} 

/** 
* 
* Method: setPhoneNumbers(ArrayList<Phone> phones) 
* 
*/ 
@Test
public void testSetPhoneNumbers() throws Exception {
    ArrayList<Phone> expected = new ArrayList<>();
    expected.add(new Phone("123-123-1234"));
    p.setPhoneNumbers(expected);
    assertEquals(expected, p.getPhoneNumbers());
} 

/** 
* 
* Method: getAddress(int index) 
* 
*/ 
@Test
public void testGetAddress() throws Exception { 
    Address expected = new Address("345 street st", "cityville", "ST", "99999");
    assertEquals(expected,p.getAddress(0));
} 

/** 
* 
* Method: addAddress(Address address) 
* 
*/ 
@Test
public void testAddAddress() throws Exception {
    Address expected = new Address("666 street st", "cityville", "ST", "88888");
    p.addAddress(expected);
    assertEquals(expected, p.getAddress(1));
} 

/** 
* 
* Method: setAddresses(ArrayList<Address> addresses) 
* 
*/ 
@Test
public void testSetAddresses() throws Exception {
    ArrayList<Address> expected = new ArrayList<>();
    expected.add(new Address("666 street st", "cityville", "ST", "88888"));
    p.setAddresses(expected);
    assertEquals(expected,p.getAddresses());
} 


} 
