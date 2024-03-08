package com.Restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Restaurant.entities.Manu;

@Repository
public interface ManuRepository extends JpaRepository<Manu, String>{

	Manu getByDishName(String dishName);

}
