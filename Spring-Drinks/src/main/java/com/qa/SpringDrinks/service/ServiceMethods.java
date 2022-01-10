package com.qa.SpringDrinks.service;

import java.util.List;

public interface ServiceMethods<T> {

	//Create method
	T create(T t);
	
	//Read all method
	List<T> getAll();
	
	//Read by id method
	T getById(long id);
	
	//Update method
	T update(long id, T t);
	
	//Delete method
	boolean delete(long id);
}
