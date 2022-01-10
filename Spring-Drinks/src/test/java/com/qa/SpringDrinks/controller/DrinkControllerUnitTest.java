package com.qa.SpringDrinks.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.SpringDrinks.domain.Drink;
import com.qa.SpringDrinks.service.DrinkService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DrinkControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private DrinkService service;
	
	@Test
	public void createTest() throws Exception {
		Drink entry = new Drink("Ginger Beer", "mixed", true, 200);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/drink/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(entryAsJSON));

	}
	
	@Test
	public void realAllTest() throws Exception {
		Drink aDrink = new Drink("Ginger Beer", "mixed", true, 200);
		List<Drink> entry = Arrays.asList(aDrink);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.getAll()).thenReturn(entry);
		
		mvc.perform(get("/drink/readAll")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(entryAsJSON));

	}
	
	@Test
	public void readByIdTest() throws Exception {
		Drink entry = new Drink(2L, "Ginger Beer", "mixed", true, 200);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.getById(2)).thenReturn(entry);
		
		mvc.perform(get("/drink/readById/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(entryAsJSON));

	}
	
	@Test
	public void updateTest() throws Exception {
		Drink entry = new Drink(2L, "Ginger Beer", "mixed", true, 200);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.update(2, entry)).thenReturn(entry); 
		
		mvc.perform(put("/drink/update/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(entryAsJSON));

	}
	
	@Test
	public void deleteTest() throws Exception {
		
		Mockito.when(this.service.delete(2)).thenReturn(true);
		
		mvc.perform(delete("/drink/delete/2")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());

	}
	
	

}