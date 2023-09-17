package com.cafedosti.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cafedosti.dao.FoodDao;
import com.cafedosti.model.Cart;
import com.cafedosti.model.Food;

public class Helper {
	
	@Autowired
	private FoodDao foodDao;
	static int x=1;
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
	static LocalDateTime now = LocalDateTime.now();
	
	static int date=Integer. parseInt(dtf.format(now));
	
    public static String getAlphaNumericOrderId(int n)
    {
    	int i=x;
        for(n=0; i!=0; i=i/10)
        {
        	n++;
        }

        String s = "00000";
        
        int d = Integer. parseInt(dtf.format(now));
        if(date != d)
        {
        	x=1;
        }
        date = d;
        
        return dtf.format(now)+s.substring(0,(3-n))+(x++);
    }
    
    public double getCartAmount(List<Cart> carts) {
    	
    	double price = 0;
    	
    	for(Cart cart : carts) {
    		
    		Food food = null;
    		
    		Optional<Food> optional = foodDao.findById(cart.getFoodId());
    		
    		if(optional.isPresent()) {
    			food = optional.get();
    		}
    		
    		price = (food.getPrice() *  cart.getQuantity()) + price;
    		
    	}
    	
		return price;
    	
    }
    
    
}
