package com.example.demo.services;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<PersonN,Long> {




//	 @Query("select u.name as name,u.phoneNo as phoneNo,u.authority as authority from PersonN u")
//     Set<Indata> getDataVal();
	 
	//LEFT JOIN FETCH p.authority a
	@Query("SELECT p.name AS name, p.phoneNo AS phoneNo,p.authority AS authority FROM PersonN p ")
	Set<Indata> getDataVal();
	

	
//	@Query("SELECT p.name AS name, p.phoneNo AS phoneNo, a AS authority FROM PersonN p LEFT JOIN p.authority a LEFT JOIN a.permissions perm")
//	List<Indata> getDataVal();


//	@Query("SELECT p FROM PersonN p LEFT JOIN FETCH p.authority a LEFT JOIN FETCH a.permissions b")
//	List<PersonN> getDataVal();
	
//	@Query(value="SELECT p FROM PersonN p LEFT JOIN FETCH p.authority a LEFT JOIN FETCH a.permissions b",
//	countQuery = "SELECT COUNT(b) FROM  PersonN b")
//    List<Indata> getDataVal();
	
	
//	@Query(value="SELECT p FROM PersonN p LEFT JOIN FETCH p.authority a LEFT JOIN FETCH a.permissions b",
//	countQuery = "SELECT COUNT(b) FROM  PersonN b")
//List<PersonN> getDataVal();
 	
    	 
// @EntityGraph(attributePaths = {"authority"})
//	 @Query("SELECT p FROM PersonN p LEFT JOIN FETCH p.authority")
//	 List<PersonN> getDataVal();
	
//`	@EntityGraph(attributePaths = {"authority"})
//	@Query("SELECT p FROM PersonN p")
// 	Set<PersonN> getDataVal();  //(Indata)

}
