package com.cafedosti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cafedosti.dao.CategoryDao;
import com.cafedosti.dao.FoodDao;
import com.cafedosti.model.Category;
import com.cafedosti.model.Food;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private FoodDao foodDao;
	
	@GetMapping("/addcategory")
	public String goToAddFoodPage() {
		return "addcategory";
	}
	
	@PostMapping("/addcategory")
	public ModelAndView addStore(@ModelAttribute Category category) {
		ModelAndView mv = new ModelAndView();
		if(this.categoryDao.save(category) != null ) {
			mv.addObject("status", category.getCategoryName()+" Category Successfully Added!!!");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status", category.getCategoryName()+" Failed to Saved!!!");
			mv.setViewName("addpizzastore");
		}
		
		return mv;
	}
	
	@PostMapping("/updatecategory")
	public ModelAndView updateStore(@ModelAttribute Category category) {
		ModelAndView mv = new ModelAndView();
		if(this.categoryDao.save(category) != null ) {
			mv.addObject("status", category.getCategoryName()+" Category Successfully Registered!!!");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status", category.getCategoryName()+" Failed to Registered!!!");
			mv.setViewName("index");
		}
		
		return mv;
	}

	
	@GetMapping("/deletecategory")
	public ModelAndView deleteStore(@RequestParam("categoryId") int categoryId) {
		ModelAndView mv = new ModelAndView();
		
		List<Food> foods = this.foodDao.findByCategoryId(categoryId);
		
		for(Food food : foods) {
			foodDao.delete(food);
		}
		
		Optional<Category> oC = categoryDao.findById(categoryId);
		Category category = null;
		
		if(oC.isPresent()) {
			category = oC.get();
		}
		
		this.categoryDao.delete(category);
			mv.addObject("status", "Category deleted successfully!!!");
			mv.setViewName("index");
		
		return mv;
		
	}
	
	
	@GetMapping("/updatecategory")
	public ModelAndView updateStore(@RequestParam("categoryId") int storeId) {
		ModelAndView mv = new ModelAndView();
		
		Optional<Category> oC = categoryDao.findById(storeId);
		Category category = null;
		
		if(oC.isPresent()) {
			category = oC.get();
		}
			mv.addObject("category",category);
			mv.setViewName("updatecategory");
		
		return mv;
	}

}
