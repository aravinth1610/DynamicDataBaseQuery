package com.example.demo.services;

import java.util.Set;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class PersonN extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Integer personId;
	private String name;
	@Column(name = "mail_id")
	private String mailId;
	@Column(name = "phone_id")
	private String phoneNo;
	
	
	@OneToMany(mappedBy ="person",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@BatchSize(size = 10) 
	private Set<AuthorityBase> authority;
	
	
	public PersonN(String name) {
		super();
		this.name = name;
	}
	
	public PersonN(String name, String mailId) {
		super();
		this.name = name;
		this.mailId = mailId;
	}

	public PersonN(String name, Set<AuthorityBase> authority) {
		super();
		this.name = name;
		this.authority = authority;
	}
	
	
	
}
