package com.cafedosti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cafedosti.dao.CreditCardDetailsDao;
import com.cafedosti.model.CreditCardDetails;

@Controller
public class CreditCardDetailsController {
	
	@Autowired
	private CreditCardDetailsDao creditDao;
	
	@PostMapping("/addcreditcard")
	public ModelAndView addFood(@ModelAttribute CreditCardDetails creditCard) {
		ModelAndView mv = new ModelAndView();
		if(this.creditDao.save(creditCard) != null ) {
			mv.addObject("status", "Credit Card Added Successfully!!!");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status", "");
			mv.setViewName("addCreditCard");
		}
		
		return mv;
	}
	
	@GetMapping("/addcard")
	public String goToCardPage() {
		return "addCreditCard";
	}
	
	@GetMapping("/checkout")
	public String goToPaymentPage() {
		return "payment";
	}
	
	

}
