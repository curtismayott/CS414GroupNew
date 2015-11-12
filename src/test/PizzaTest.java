package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import server.objects.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/** 
* Pizza Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 27, 2015</pre> 
* @version 1.0 
*/ 
public class PizzaTest {

    Pizza p;
    ArrayList<Topping> tops;

    @Before
public void before() throws Exception {
    tops = new ArrayList<>();
    tops.add(new Topping("a", "artichoke"));
    tops.add(new Topping("b", "bacon"));
    p = new Pizza(tops, new Sauce("m","marinara"), new PizzaSize("L","large", 6.99), PIZZA_STATUS.NEW, 6.99);
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
    String expected = "large marinara " + tops.toString() + " $6.99";
    assertEquals(expected,p.toString());
} 

/** 
* 
* Method: equals(Object o) 
* 
*/ 
@Test
public void testEquals() throws Exception {
    ArrayList<Topping> tops1 = new ArrayList<>();
    tops1.add(new Topping("a", "artichoke"));
    tops1.add(new Topping("b", "bacon"));
    Pizza p1 = new Pizza(tops1, new Sauce("m","marinara"), new PizzaSize("L","large", 6.99), PIZZA_STATUS.NEW, 9.99);
    assertEquals(p,p1);
}

@Test
public void testNotEquals() throws Exception {
    ArrayList<Topping> tops1 = new ArrayList<>();
    tops1.add(new Topping("c", "cartichoke"));
    tops1.add(new Topping("b", "bacon"));
    Pizza p1 = new Pizza(tops1, new Sauce("m","marinara"), new PizzaSize("M","medium", 6.99), PIZZA_STATUS.NEW, 9.99);
    assertNotEquals(p, p1);
}

/** 
* 
* Method: getToppingList() 
* 
*/ 
@Test
public void testGetToppingList() throws Exception { 
    assertEquals(tops,p.getToppingList());
} 

/** 
* 
* Method: setToppingList(ArrayList<Topping> toppings) 
* 
*/ 
@Test
public void testSetToppingList() throws Exception {
    ArrayList<Topping> tops1 = new ArrayList<>();
    tops1.add(new Topping("c", "cartichoke"));
    tops1.add(new Topping("b", "bacon"));
    p.setToppingList(tops1);
    assertEquals(tops1,p.getToppingList());
} 

/** 
* 
* Method: getSauce() 
* 
*/ 
@Test
public void testGetSauce() throws Exception {
    Sauce expected = new Sauce("m","marinara");
    assertEquals(expected,p.getSauce());
} 

/** 
* 
* Method: setSauce(Sauce sauce) 
* 
*/ 
@Test
public void testSetSauce() throws Exception { 
    Sauce expected = new Sauce("r","ranch");
    p.setSauce(expected);
    assertEquals(p.getSauce(),expected);
} 

/** 
* 
* Method: getSize() 
* 
*/ 
@Test
public void testGetSize() throws Exception { 
    PizzaSize expected = new PizzaSize("L","large", 6.99);
    assertEquals(expected,p.getSize());
} 

/** 
* 
* Method: setSize(PizzaSize size) 
* 
*/ 
@Test
public void testSetSize() throws Exception {
    PizzaSize expected = new PizzaSize("M","medium", 5.99);
    p.setSize(expected);
    assertEquals(expected, p.getSize());
} 

/** 
* 
* Method: getStatus() 
* 
*/ 
@Test
public void testGetStatus() throws Exception { 
    assertEquals(p.getStatus(),PIZZA_STATUS.NEW);
} 

/** 
* 
* Method: setStatus(PIZZA_STATUS status) 
* 
*/ 
@Test
public void testSetStatus() throws Exception { 
    p.setStatus(PIZZA_STATUS.COMPLETED);
    assertEquals(p.getStatus(),PIZZA_STATUS.COMPLETED);
} 

/** 
* 
* Method: sendPizzaToMakeline() 
* 
*/ 
@Test
public void testSendPizzaToMakeline() throws Exception { 
    p.sendPizzaToMakeline();
    assertEquals(p.getStatus(),PIZZA_STATUS.MAKELINE);
} 

/** 
* 
* Method: loadPizza() 
* 
*/ 
@Test
public void testLoadPizza() throws Exception {
    p.loadPizza();
    assertEquals(p.getStatus(),PIZZA_STATUS.LOADED);
} 

/** 
* 
* Method: completePizza() 
* 
*/ 
@Test
public void testCompletePizza() throws Exception {
    p.completePizza();
    assertEquals(p.getStatus(),PIZZA_STATUS.COMPLETED);
} 

/** 
* 
* Method: calculatePrice() 
* 
*/ 
@Test
public void testCalculatePrice() throws Exception {
    p.calculatePrice();
    assertEquals(8.99,p.getPrice(),0.00);
} 

/** 
* 
* Method: getPrice() 
* 
*/ 
@Test
public void testGetPrice() throws Exception {
    p.calculatePrice();
    assertEquals(8.99,p.getPrice(),0.00);
} 

/** 
* 
* Method: setPrice(double price) 
* 
*/ 
@Test
public void testSetPrice() throws Exception {
    p.setPrice(7.88);
    assertEquals(p.getPrice(), 7.88, 0.00);
} 

/** 
* 
* Method: setOrderID(int orderID) 
* 
*/ 
@Test
public void testSetOrderID() throws Exception {
    p.setOrderID(0);
    assertEquals(p.getOrderID(),0);
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
* Method: makelineToString() 
* 
*/ 
@Test
public void testMakelineToString() throws Exception { 
    String expected = "large " + "marinara " + tops.toString() + " $" + p.getPrice();
    assertEquals(expected,p.toString());
} 


} 
