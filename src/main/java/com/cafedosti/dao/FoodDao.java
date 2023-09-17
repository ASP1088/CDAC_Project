package com.cafedosti.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cafedosti.model.Food;

@Repository
public interface FoodDao extends JpaRepository<Food, Integer> {
	
	List<Food> findByNameContainingIgnoreCase(String name);
	@Query(value="select count(f) from Food f")
	Long countOfFoods();
	List<Food> findByCategoryId(int categoryId);
	
}
