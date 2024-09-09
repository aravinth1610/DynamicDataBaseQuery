package com.example.demo.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cont {

	@Autowired
	private PersonRepo per;
	
	@Autowired
	DynamicGet dyn;
	
	@GetMapping("/")
	public Set<?> dataVal() {
//		per.getDataVal();
		return per.getDataVal();
				//dyn.getTableValues(PersonN.class,"personn","","","*");
		
	}
	
	@PostMapping("/sv")
	public void saveD(@RequestBody PersonN pern) {
		per.save(pern);
	}
	
}
