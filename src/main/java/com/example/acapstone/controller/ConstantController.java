package com.example.acapstone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.acapstone.domain.User;
import com.example.acapstone.repository.ConstantRepository;
import com.example.acapstone.domain.Constant;


@RestController
@RequestMapping(value="/")
public class ConstantController {

	@Autowired
	private ConstantRepository constantRepository;
	
	@CrossOrigin(origins="*")
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
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/constantbyname")
	public ResponseEntity<Constant> getConstantbyName(@RequestParam String currentConstant) {
		return new ResponseEntity<Constant>(constantRepository.getConstantByName(currentConstant), HttpStatus.OK);	
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/constantbyvalue")
	public ResponseEntity<Constant> getConstantByValue(@RequestParam String currentConstant) {
		return new ResponseEntity<Constant>(constantRepository.getConstantByValue(currentConstant), HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*")
	@PutMapping(path="/updateValue", headers="Accept=application/json")
	public  ResponseEntity<?> updateConstant(@RequestParam String stringName, @RequestParam String stringValue) {
		Constant curr = constantRepository.getConstantByName(stringName);
		if(curr == null)
		{
			System.out.println(curr + " curr");
			return ResponseEntity.notFound().build();
		}
		
		curr.updateValue(stringValue);
		constantRepository.save(curr);
		return ResponseEntity.noContent().build(); 
	}
	
	
	@CrossOrigin(origins="*")
	@PutMapping(path="/updateUrl", headers="Accept=application/json")
	public  ResponseEntity<?> updateUrl(@RequestParam String stringName, @RequestParam String newUrl) {
		Constant curr = constantRepository.getConstantByName(stringName);
		if(curr == null)
		{
			System.out.println(curr + " curr");
			return ResponseEntity.notFound().build();
		}
		
		curr.updateUrl(newUrl);
		constantRepository.save(curr);
		return ResponseEntity.noContent().build(); 
	}
	
	
	
	@CrossOrigin(origins="*")
	@DeleteMapping(path="/delete")
	public void deleteConstant(@RequestParam String currentConstant) {
		constantRepository.deleteById(currentConstant);
	}

}
