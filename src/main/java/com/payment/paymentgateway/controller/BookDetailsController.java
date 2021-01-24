package com.payment.paymentgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.paymentgateway.model.BooksContent;
import com.payment.paymentgateway.service.StaticContentDataService;

@RestController
public class BookDetailsController {
	
	@Autowired
	private StaticContentDataService service;
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping(value="/getBookDetails", method = RequestMethod.GET)
	public ResponseEntity<BooksContent[]> getBookDetails(){
		
		return new ResponseEntity<BooksContent[]>(service.getBookDetailsContent(),HttpStatus.OK);
	}
}
