package com.example.acapstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.acapstone.domain.User;
import com.example.acapstone.repository.ConstantRepository;
import com.example.acapstone.domain.Constant;


@RestController
@RequestMapping(value="/")
public class ConstantController {

	@Autowired
	private ConstantRepository constantRepository;

	@GetMapping(path="/constants")
	public ResponseEntity<List<Constant>> getAllConstants() {
		List<Constant> constants = constantRepository.getAllConstants();
		for(Constant con : constants)
		{
			if (con.equals(null)) 
			{
				return new ResponseEntity<List<Constant>>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<List<Constant>>(constants, HttpStatus.OK);
	}
	
	@GetMapping(path="/constant") //update the url links // HATEOS
	public ResponseEntity<Constant> getConstant(@RequestParam String currentConstant) {
		return new ResponseEntity<Constant>(constantRepository.getConstant(currentConstant), HttpStatus.OK);
		
	}
	
	@PostMapping(path="/update") //may or may not return entity based on you/whats better
	public ResponseEntity<Constant> updaterConstant(@RequestParam String currentConstant, @RequestParam String updatedValue) {
		return new ResponseEntity<Constant>(constantRepository.updateConstant(currentConstant, updatedValue),  HttpStatus.OK); 
	}
	
	//delete constant, multiple updates, etc. 

}
