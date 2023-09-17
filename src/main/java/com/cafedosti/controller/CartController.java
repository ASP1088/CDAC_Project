package com.cafedosti.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cafedosti.dao.CartDao;
import com.cafedosti.model.Cart;

@Controller
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	
	@GetMapping("/addtocart")
	public ModelAndView addFood(@ModelAttribute Cart cart,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
	    
		if(this.cartDao.save(cart) != null ) {
			mv.addObject("status", "Products Added to Cart successfully!!!");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status", "Failed to Add foods to cart!!!");
			mv.setViewName("index");
		}
		
		return mv;
	}
	
	@GetMapping("/deletecart")
	public ModelAndView deleteCart(@RequestParam("cartId") int cartId) {
		ModelAndView mv = new ModelAndView();
		
		Optional<Cart> oC = cartDao.findById(cartId);
		Cart cart = null;
		
		if(oC.isPresent()) {
			cart = oC.get();
		}
		
		this.cartDao.delete(cart);
			mv.addObject("status", "Cart deleted successfully!!!");
			mv.setViewName("index");
		
		return mv;
	}

}
