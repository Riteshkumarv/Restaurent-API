package com.Restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Restaurant.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order getByTableNo(int tableNo);
	

}
