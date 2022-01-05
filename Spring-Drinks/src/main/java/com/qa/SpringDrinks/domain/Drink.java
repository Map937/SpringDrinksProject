package com.qa.SpringDrinks.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(nullable = false)
	private String brand; 
	
	@Column(nullable = false)
	private String colour;
	
	@Column(nullable = false)
	private boolean isFizzy;
	
	@Column(nullable = false)
	private int ml;
	
	//Default Constructor
	public Drink() {}
	
	//Testing Constructor
	public Drink(String brand, String colour, boolean isFizzy, int ml) {
		super(); 
		this.brand = brand;
		this.colour = colour;
		this.isFizzy = isFizzy;
		this.ml = ml;
	}
	
	//Main Constructor
	public Drink(long id, String brand, String colour, boolean isFizzy, int ml) {
		super();
		this.id = id;
		this.brand = brand;
		this.colour = colour;
		this.isFizzy = isFizzy;
		this.ml = ml;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public boolean isFizzy() {
		return isFizzy;
	}

	public void setFizzy(boolean isFizzy) {
		this.isFizzy = isFizzy;
	}

	public int getMl() {
		return ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", brand=" + brand + ", colour=" + colour + ", isFizzy=" + isFizzy + ", ml=" + ml
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, colour, isFizzy, ml);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(colour, other.colour) && isFizzy == other.isFizzy
				&& ml == other.ml;
	}
	
	

}
