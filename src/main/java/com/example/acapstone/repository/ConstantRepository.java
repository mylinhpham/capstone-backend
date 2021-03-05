package com.example.acapstone.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.acapstone.domain.Constant;

import java.util.List;

@Repository
public interface ConstantRepository extends JpaRepository<Constant, String> {
	  
	  //returns all constants
	  @Query(value = "SELECT * FROM constant", nativeQuery = true)
	  List<Constant> getAllConstants();
	  

		// return specified constant value
	  @Query(value = "SELECT * FROM constant c WHERE LOWER(c.string_name) = LOWER(:searchTerm) limit 1", nativeQuery = true)
	  Constant getConstant(@Param("searchTerm") String searchTerm);
	  
	  //to update the constant value
	  @Query(value = "UPDATE constant SET string_value = :updatedTerm WHERE string_name = :currentConstant", nativeQuery = true)
	  Constant updateConstant(@Param("updatedTerm") String updatedTerm, @Param("currentConstant") String currentConstant);

	  @Query(value = "DELETE constant FROM constant WHERE string_name = :currentConstant", nativeQuery = true)
	  Constant deleteConstant(@Param("currentConstant") String currentConstant);
}
