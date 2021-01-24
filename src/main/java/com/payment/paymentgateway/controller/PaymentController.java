package com.payment.paymentgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.paymentgateway.model.PaymentRequest;
import com.payment.paymentgateway.service.PaymentService;
import com.stripe.exception.StripeException;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping
	public ResponseEntity<String> completePayment(@RequestBody PaymentRequest paymentRequest)
					throws StripeException{
		String chargeId = paymentService.charge(paymentRequest);
		return chargeId != null ? new ResponseEntity<String>(chargeId,HttpStatus.OK) :
			 new ResponseEntity<String>("Please check the card details",HttpStatus.BAD_REQUEST);
	}
}
