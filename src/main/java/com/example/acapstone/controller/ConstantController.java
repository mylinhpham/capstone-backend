package com.example.acapstone.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.acapstone.repository.ConstantRepository;
import com.example.acapstone.domain.Constant;


@RestController
@RequestMapping(value="/")
public class ConstantController {

	@Autowired
	private ConstantRepository constantRepository;
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/welcome") //fallback page so won't see white error page
	public String welcome() {
		return "Welcome to Interactive Story Telling Team DataBase";
	}
	
	
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
	
	//starting for images//
//	
//	@PostMapping("/setImg")
//    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam String stringName) throws IOException {
//		
//        Constant curr = constantRepository.getConstantByName(stringName);
//		System.out.println("idk if this works UPLOADING IMAGE");
//		if(curr == null)
//		{
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		try {
//			curr.setPicByte(file.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		constantRepository.save(curr);
//		return ResponseEntity.noContent().build();
//    }
//	
//	
//	@GetMapping(value = "/getImg")
//	public Constant downloadImage(@RequestParam String stringName) {
//		
//		 Constant curr = constantRepository.getConstantByName(stringName);
//		 return curr;
//	}
//	
//	// compress the image bytes before storing it in the database
//	public static byte[] compressBytes(byte[] data) {
//		Deflater deflater = new Deflater();
//		deflater.setInput(data);
//		deflater.finish();
//
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		while (!deflater.finished()) {
//			int count = deflater.deflate(buffer);
//			outputStream.write(buffer, 0, count);
//		}
//		try {
//			outputStream.close();
//		} catch (IOException e) {
//		}
//		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//
//		return outputStream.toByteArray();
//	}
//	
//	// uncompress the image bytes before returning it to the angular application
//		public static byte[] decompressBytes(byte[] data) {
//			Inflater inflater = new Inflater();
//			inflater.setInput(data);
//			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//			byte[] buffer = new byte[1024];
//			try {
//				while (!inflater.finished()) {
//					int count = inflater.inflate(buffer);
//					outputStream.write(buffer, 0, count);
//				}
//				outputStream.close();
//			} catch (IOException ioe) {
//			} catch (DataFormatException e) {
//			}
//			return outputStream.toByteArray();
//		}

}
