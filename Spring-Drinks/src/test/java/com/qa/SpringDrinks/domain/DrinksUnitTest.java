package com.qa.SpringDrinks.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DrinksUnitTest {
	
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
	}
	
	@Test
	public void noIdConstructor() {
		Drink drink = new Drink("Fanta", "Orange", true, 500);
		
		assertNotNull(drink.getDrinkName());
		assertNotNull(drink.getColour());
		assertNotNull(drink.isFizzy());
		assertNotNull(drink.getMl());
		
		assertEquals(drink.getDrinkName(), "Fanta");
		assertEquals(drink.getColour(), "Orange"); 
		assertEquals(drink.isFizzy(), true);
		assertEquals(drink.getMl(), 500);
		
	}
	
	@Test
	public void IdConstructor() {
		Drink drink = new Drink(1L, "Fanta", "Orange", true, 500);
		
		assertNotNull(drink.getId());
		assertNotNull(drink.getDrinkName());
		assertNotNull(drink.getColour());
		assertNotNull(drink.isFizzy());
		assertNotNull(drink.getMl());
		
		assertEquals(drink.getId(), 1L);
		assertEquals(drink.getDrinkName(), "Fanta");
		assertEquals(drink.getColour(), "Orange");
		assertEquals(drink.isFizzy(), true);
		assertEquals(drink.getMl(), 500);
		
	}
	
	@Test
	public void settersTest() {
		Drink drink = new Drink();
		
		drink.setId(1L);
		drink.setDrinkName("Pepsi");
		drink.setColour("Blue");
		drink.setFizzy(true);
		drink.setMl(450); 
		
		assertNotNull(drink.getId());
		assertNotNull(drink.getDrinkName());
		assertNotNull(drink.getColour());
		assertNotNull(drink.isFizzy());
		assertNotNull(drink.getMl());
		
		assertEquals(drink.getId(), 1L);
		assertEquals(drink.getDrinkName(), "Pepsi");
		assertEquals(drink.getColour(), "Blue");
		assertEquals(drink.isFizzy(), true);
		assertEquals(drink.getMl(), 450);
		
	}

}
