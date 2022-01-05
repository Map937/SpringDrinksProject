package com.qa.SpringDrinks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.SpringDrinks.domain.Drink;
import com.qa.SpringDrinks.repo.DrinkRepo;

@Service
public class DrinkService implements ServiceMethods<Drink> {
	
	private DrinkRepo repo;

	private DrinkService(DrinkRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Drink create(Drink drink) {
		return this.repo.save(drink);
	}

	@Override
	public List<Drink> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Drink getById(long id) {
		Optional<Drink> optionalDrink = this.repo.findById(id);
		if(optionalDrink.isPresent()) {
			return optionalDrink.get();  
		}
		return null;
	}

	@Override
	public Drink update(long id, Drink drink) {
		Optional<Drink> optionalDrink = this.repo.findById(id);
		if(optionalDrink.isPresent()) { 
			Drink existingDrink = optionalDrink.get();
		    existingDrink.setBrand(drink.getBrand()); 
		    existingDrink.setColour(drink.getColour());
		    existingDrink.setIsFizzy(drink.getIsFizzy());
		    existingDrink.setMl(drink.getMl());
			
		    this.repo.saveAndFlush(existingDrink);
		
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
}
