package com.cafedosti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cafedosti.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{

//	List<Category> findByNameCategoriesContainingIgnoreCase(String name);
//	@Query(value="select count(p) from Catagory p") Long countOfCategorys();

}
