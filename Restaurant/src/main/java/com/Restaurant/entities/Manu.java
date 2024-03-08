package com.Restaurant.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Manu {
	
	@Id
	private String dishName;
	private int price;
	
	public Manu(String dishName, int price) {
		super();
		this.dishName = dishName;
		this.price = price;
	}

	public Manu() {
		super();
	}
	
}
