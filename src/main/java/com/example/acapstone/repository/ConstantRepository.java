package com.example.acapstone.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.acapstone.domain.Constant;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface ConstantRepository extends JpaRepository<Constant, String> {
	  

	  @Query(value = "SELECT * FROM constant", nativeQuery = true)
	  List<Constant> getAllConstants();


	  @Query(value = "SELECT * FROM constant c WHERE LOWER(c.string_name) = LOWER(:searchTerm) limit 1", nativeQuery = true)
	  Constant getConstantByName(@Param("searchTerm") String searchTerm);
	  

	  @Query(value = "SELECT * FROM constant c WHERE LOWER(c.string_value) = LOWER(:searchTerm) limit 1", nativeQuery = true)
	  Constant getConstantByValue(@Param("searchTerm") String searchTerm);
}
