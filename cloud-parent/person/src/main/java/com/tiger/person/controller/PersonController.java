package com.tiger.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.person.dao.PersonRepository;
import com.tiger.person.domain.Person;

@RestController
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public List<Person> savePerson(@RequestBody String personName){
		Person p = new Person(personName);
		personRepository.save(p);
		List<Person> people = personRepository.findAll(new PageRequest(0, 10)).getContent();
		return people;
	}
	
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public Person findOne(){
		Person people = personRepository.findOne(1L);
		return people;
	}
}
