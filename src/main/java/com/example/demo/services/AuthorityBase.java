package com.example.demo.services;

import java.util.Set;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@DynamicInsert
@DynamicUpdate
@Entity
public class AuthorityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authorityId;
	@Column(name = "role_base")
	private String roleBase;
	@Enumerated(value = EnumType.STRING)
	private Roles roles;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_person", referencedColumnName = "person_id")
	@JsonIgnore
	private PersonN person;
	
	  @OneToMany(mappedBy = "authority", cascade = CascadeType.ALL)
	  private Set<Permission> permissions;

}
