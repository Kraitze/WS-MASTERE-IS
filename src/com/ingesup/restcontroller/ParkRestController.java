package com.ingesup.restcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkRestController {
	
	@RequestMapping(value="/rest/Park/{parkId}", method=RequestMethod.GET)
	public ResponseEntity<?> parkGetById(@PathVariable Integer parkId) {
		
		System.out.println(parkId + " SELECTED");
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}