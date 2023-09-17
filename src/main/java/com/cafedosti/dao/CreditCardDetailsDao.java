package com.cafedosti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafedosti.model.CreditCardDetails;

@Repository
public interface CreditCardDetailsDao extends JpaRepository<CreditCardDetails, Integer> {
	
	CreditCardDetails findByCreditCardNumberAndValidFromAndValidTo(String cardNo, String validFrom, String validTo);

}
