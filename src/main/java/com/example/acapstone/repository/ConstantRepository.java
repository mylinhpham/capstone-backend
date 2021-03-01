package com.example.acapstone.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.acapstone.domain.Constant;

import java.util.List;

@Repository
public interface ConstantRepository extends JpaRepository<Constant, String> {

		//need to fix this query. this will return specified constant
	  @Query(value = "SELECT * FROM Constant WHERE name = ?1", nativeQuery = true)
	  Constant getConstant(String constantName); 
	 
	  
	  //returns all constants
	  @Query(value = "SELECT * FROM Constant", nativeQuery = true)
	  List<Constant> getAllConstants();
	  
	  
	  //to update the constant value
	  void updateConstant( String constantName, String updatedValue);
	  

}
