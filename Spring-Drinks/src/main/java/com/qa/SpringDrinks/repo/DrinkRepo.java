package com.qa.SpringDrinks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.SpringDrinks.domain.Drink;

public interface DrinkRepo extends JpaRepository<Drink, Long> {

}
