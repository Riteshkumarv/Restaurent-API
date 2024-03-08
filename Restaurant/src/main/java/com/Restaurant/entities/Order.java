package com.Restaurant.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "order1")
public class Order {
	
	@Id
	private int tableNo;
	private List<String> manu;
	
	public Order(int tableNo, List<String> manu) {
		super();
		this.tableNo = tableNo;
		this.manu = manu;
	}
	
	public Order() {
		super();
	}
		
	
	
}
