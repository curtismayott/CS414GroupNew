package test;

import objects.Address;
import objects.Order;
import objects.Person;
import objects.Phone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* Order Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 27, 2015</pre> 
* @version 1.0 
*/ 
public class OrderTest {

    Order o;

@Before
public void before() throws Exception {
    o = new Order(0, new Person("testPerson", new Address("street","city","state","zip"), new Phone("454-454-4545")));
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

} 

/** 
* 
* Method: getOrderID() 
* 
*/ 
@Test
public void testGetOrderID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setOrderID(int orderID) 
* 
*/ 
@Test
public void testSetOrderID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCustomer() 
* 
*/ 
@Test
public void testGetCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCustomer(Person customerName) 
* 
*/ 
@Test
public void testSetCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPizzas() 
* 
*/ 
@Test
public void testGetPizzas() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPizza(int index) 
* 
*/ 
@Test
public void testGetPizza() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addPizza(Pizza pizza) 
* 
*/ 
@Test
public void testAddPizza() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: removePizza(Pizza pizza) 
* 
*/ 
@Test
public void testRemovePizza() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: removeAllPizzas() 
* 
*/ 
@Test
public void testRemoveAllPizzas() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setPizzas(ArrayList<Pizza> pizzas) 
* 
*/ 
@Test
public void testSetPizzas() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updatePizza(int index, Pizza pizza) 
* 
*/ 
@Test
public void testUpdatePizza() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: sendPizzasToMakeLine() 
* 
*/ 
@Test
public void testSendPizzasToMakeLine() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getOrderTotal() 
* 
*/ 
@Test
public void testGetOrderTotal() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: isPaidFor() 
* 
*/ 
@Test
public void testIsPaidFor() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setIsPaidFor(boolean isPaidFor) 
* 
*/ 
@Test
public void testSetIsPaidFor() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: payForOrder() 
* 
*/ 
@Test
public void testPayForOrder() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addSide(SideItem side) 
* 
*/ 
@Test
public void testAddSide() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSides() 
* 
*/ 
@Test
public void testGetSides() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getDrinks() 
* 
*/ 
@Test
public void testGetDrinks() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getOrderItems() 
* 
*/ 
@Test
public void testGetOrderItems() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: removeItem(OrderItem item) 
* 
*/ 
@Test
public void testRemoveItem() throws Exception { 
//TODO: Test goes here... 
} 


} 
