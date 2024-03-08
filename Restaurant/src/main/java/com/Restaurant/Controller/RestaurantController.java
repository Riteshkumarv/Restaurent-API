package com.Restaurant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurant.Service.RestaurentService;
import com.Restaurant.entities.Manu;
import com.Restaurant.entities.Order;

@RestController
public class RestaurantController {

	@Autowired
	RestaurentService restaurentService;
	
	@PostMapping("/addManu")
	public Manu addManu(@RequestBody Manu manu) {
		return restaurentService.addManu(manu);
	}
	
	@GetMapping("/getManu")
	public List<Manu> getManu(){
		return restaurentService.getManu();
	}
	
	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody Order order){
		return restaurentService.placeOrder(order);
	}
	
	@PutMapping("/addOrder/{tableNo}")
	public String addOrder(@PathVariable("tableNo") int tableNo,@RequestBody Order order) {
		return restaurentService.addOrder(tableNo,order);
	}
	
	@GetMapping("/getBill/{tableNo}")
	public int getBill(@PathVariable("tableNo") int tableNo) {
	    return restaurentService.getBill(tableNo);	
	}

}
