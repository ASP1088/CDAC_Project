package com.cafedosti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafedosti.model.Category;

@Repository
public interface CategoryFoodsDao extends JpaRepository<Category, Integer>{
	
}
