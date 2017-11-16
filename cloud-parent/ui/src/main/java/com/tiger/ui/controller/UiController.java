package com.tiger.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.ui.domain.Person;
import com.tiger.ui.service.PersonHystrixService;
import com.tiger.ui.service.SomeHystrixService;

@RestController
public class UiController {
	@Autowired
	private PersonHystrixService personHystrixService;
	@Autowired
	private SomeHystrixService someHystrixService;
	
	@RequestMapping(value="/dispatch")
	public List<Person> sendMessage(@RequestBody String personName){
		System.out.println(personName);
		return personHystrixService.save(personName);
	}
	@RequestMapping(value="/getSome",produces={MediaType.TEXT_PLAIN_VALUE})
	public String getSome(){
		return someHystrixService.getSome();
	}
}
