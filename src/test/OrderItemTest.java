package test;

import objects.OrderItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/** 
* OrderItem Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 27, 2015</pre> 
* @version 1.0 
*/ 
public class OrderItemTest {

    OrderItem oi;

@Before
public void before() throws Exception {

    oi = new OrderItem(4.0,1);

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getPrice() 
* 
*/ 
@Test
public void testGetPrice() throws Exception { 
    double expected = 4.0;
    assertEquals(expected,oi.getPrice(),0.00);
} 

/** 
* 
* Method: setPrice(double price) 
* 
*/ 
@Test
public void testSetPrice() throws Exception { 
    double expected = 2.0;
    oi.setPrice(expected);
    assertEquals(expected, oi.getPrice(),0.00);
} 

/** 
* 
* Method: getOrderID() 
* 
*/ 
@Test
public void testGetOrderID() throws Exception { 
    int expected = 1;
    assertEquals(expected,oi.getOrderID());
} 

/** 
* 
* Method: setOrderID(int orderID) 
* 
*/ 
@Test
public void testSetOrderID() throws Exception {
    int expected = 1;
    oi.setOrderID(expected);
    assertEquals(expected, oi.getOrderID());
} 


} 
