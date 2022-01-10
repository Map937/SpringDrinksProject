package com.qa.SpringDrinks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.SpringDrinks.domain.Drink;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:drink-schema.sql", "classpath:drink-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DrinkControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		Drink entry = new Drink("Coke", "Red", true, 500);
		Drink result = new Drink(2L, "Coke", "Red", true, 500);
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(post("/drink/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void readAllTest() throws Exception {
		Drink input = new Drink("Coke", "Red", true, 500);
		List<Drink> entry = Arrays.asList(input);
		
		Drink output = new Drink(1L, "Coke", "Red", true, 500);
		List<Drink> result = Arrays.asList(output);
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(get("/drink/readAll")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(resultAsJSON));
		
		
	}
	
	@Test
	public void readByIdTest() throws Exception {
		
	
		Drink result = new Drink(1L, "Coke", "Red", true, 500);
		
		
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(get("/drink/readById/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(resultAsJSON));

	}
	
	@Test
	public void updateTest() throws Exception {
		
		Drink entry = new Drink("Ginger Beer", "mixed", true, 200);
		Drink result = new Drink(1L, "Ginger Beer", "mixed", true, 200);
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
 
		
		mvc.perform(put("/drink/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(resultAsJSON));

	}
	
	@Test
	public void deleteTest() throws Exception {
		
		mvc.perform(delete("/drink/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
				

	}
	

}