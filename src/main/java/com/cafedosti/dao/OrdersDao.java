package com.cafedosti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafedosti.model.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer>{
	
	List<Orders> findByOrderId(String orderId);
	List<Orders> findByUserId(int userId);
	List<Orders> findByOrderDate(String orderDate);
	List<Orders> findByOrderDateAndUserId(String orderDate, int userId);

}
