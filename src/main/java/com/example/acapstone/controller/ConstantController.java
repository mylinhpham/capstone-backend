package com.example.acapstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.acapstone.domain.User;
import com.example.acapstone.repository.ConstantRepository;
import com.example.acapstone.domain.Constant;


@RestController
@RequestMapping("/constants")
public class ConstantController {

@Autowired
private ConstantRepository constantRepository; //this is making an object of the ConstantRepository that is the interface from the queries

@GetMapping
public String test() {
	return "Does this even work";
}
//public ResponseEntity<List<Constant>> getAllConstants() {
//	List<Constant> constants = constantRepository.getAllConstants();
//	for(Constant con : constants)
//	{
//		if (con == null) 
//		{
//			return new ResponseEntity<List<Constant>>(HttpStatus.NOT_FOUND);
//		}
//	}
//	return new ResponseEntity<List<Constant>>(constants, HttpStatus.OK);
//}

}
