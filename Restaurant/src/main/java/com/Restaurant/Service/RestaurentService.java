package com.Restaurant.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.Repository.ManuRepository;
import com.Restaurant.Repository.OrderRepository;
import com.Restaurant.entities.Manu;
import com.Restaurant.entities.Order;

import jakarta.annotation.PostConstruct;

@Service
public class RestaurentService {
	
	@Autowired
	ManuRepository manuRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@PostConstruct
	public void manu() {
		
		List<Manu>list = new ArrayList<>(); 
		
		Manu manu1 = new Manu("chiken",240);
		Manu manu2 = new Manu("panner",240);
		Manu manu3 = new Manu("chikenBiryani",240);
		Manu manu4 = new Manu("chikenRost",240);
		Manu manu5 = new Manu("pannerChilli",240);
		Manu manu6 = new Manu("rice",80);
		Manu manu7 = new Manu("roti",15);
		
		list.add(manu1);
		list.add(manu2);
		list.add(manu3);
		list.add(manu4);
		list.add(manu5);
		list.add(manu6);
		list.add(manu7);
		
		manuRepository.saveAll(list);
	}
	
	public Manu addManu(Manu manu) {
		return manuRepository.save(manu);
	}

	public List<Manu> getManu() {
		return manuRepository.findAll();
	}

	public Order placeOrder(Order order) {
		return orderRepository.save(order);
	}

	public String addOrder(int tableNo,Order order) {
		
		List<String> list1= order.getManu();
		
		Order order1 = orderRepository.getByTableNo(tableNo);
		
		List<String> list2 = order1.getManu();
		
		List<String> dishName = new ArrayList<>();
		
		for(String s : list1) {
			dishName.add(s);
		}
		
		for(String s : list2) {
			dishName.add(s);
		}
		
		
		orderRepository.save(new Order(tableNo , dishName));
		return "Order Added Success Fully";
		
	}

	public int getBill(int tableNo) {
		
		int bill = 0;
		
		Order order = orderRepository.getByTableNo(tableNo);
		if(order != null) {
			
		List<String>dishName = order.getManu();
		
	       	 for(String dishName1 : dishName) {
	       		 
		     	Manu manu = manuRepository.getByDishName(dishName1);
		     	
		     	bill += manu.getPrice();
		     	
		     }
		}
		
		return bill;
		
	}

	
	
}
