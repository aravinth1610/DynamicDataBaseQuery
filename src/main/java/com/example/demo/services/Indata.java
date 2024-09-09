package com.example.demo.services;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface Indata {

	String getName();
    String getPhoneNo();
	Set<Authority> getAuthority();	
}
