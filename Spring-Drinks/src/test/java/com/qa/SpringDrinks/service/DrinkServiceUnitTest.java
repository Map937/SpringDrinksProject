package com.qa.SpringDrinks.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.SpringDrinks.domain.Drink;
import com.qa.SpringDrinks.repo.DrinkRepo;

@SpringBootTest
public class DrinkServiceUnitTest {
	
	@Autowired
	DrinkService service;
	
	@MockBean
	DrinkRepo repo;
	
	@Test
	public void createTest() {
		//given
		Drink input = new Drink("Sprite", "Green", true, 300);
		Drink output = new Drink(1L, "Sprite", "Green", true, 300);
		
		//when
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		//then
		assertEquals(output, this.service.create(input));
		
		//verify
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
		
		
	}
	
	@Test
	public void getAllTest() {
		
		//given
		Drink drink = new Drink(1L, "Coke", "Red", true, 500); 
				
		List<Drink> output = Arrays.asList(drink);
		
		//when
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		//then
		assertNotNull(output);
		
		assertEquals(output, this.service.getAll());
		
		//verify
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getByIdTest() {
		
		//given
		Drink Fanta = new Drink(2L, "Fanta", "Orange", true, 500);
		
		Optional<Drink> optionalFanta = Optional.of(Fanta); 
		
		long id = 2;
		
		//when
		Mockito.when(this.repo.findById(id)).thenReturn(optionalFanta);	
		
		//then
		assertNotNull(optionalFanta); 
		
		assertEquals(Fanta, this.service.getById(2)); 
		
		//verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test
	public void updateTest() {
		
		//given
		
		Drink orangeJuice = new Drink(3L, "Orange Juice", "Blue", false, 200);
		
		Optional<Drink> optionalOrangeJuice = Optional.of(orangeJuice);
		
		Drink replacingOrangeJuice = new Drink(3L, "Grape Juice", "Purple", false, 400);
		
		long id = 3;
		
		//when
		Mockito.when(this.repo.findById(id)).thenReturn(optionalOrangeJuice);
		Mockito.when(this.repo.saveAndFlush(replacingOrangeJuice)).thenReturn(replacingOrangeJuice);
		
		//then
		assertNotNull(optionalOrangeJuice); 
		assertEquals(optionalOrangeJuice, this.repo.findById(id));
		
		assertNotNull(replacingOrangeJuice); 
		assertEquals(replacingOrangeJuice, this.service.update(id, replacingOrangeJuice));
		
		//verify
		Mockito.verify(this.repo, Mockito.times(2)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(replacingOrangeJuice);
		
	}
	
	@Test
	public void deleteTest() {
		
		//when
		Mockito.when(this.repo.existsById(8L)).thenReturn(false);
		
		
		//then
		assertTrue(this.service.delete(8L));
		
		//verify
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(8L);
		
	}
	
	

}