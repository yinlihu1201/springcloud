package com.tiger.ui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tiger.ui.domain.Person;

/**
 * 调用Person Service的断路器
 * @author yinlihu
 *
 */
@Service
public class PersonHystrixService {
	@Autowired
	PersonService personService;
	
	@HystrixCommand(fallbackMethod="fallbackSave")
	public List<Person> save(String personName){
		System.out.println("aaa");
		return personService.save(personName);
	}
	
	public List<Person> fallbackSave(String personName){
		List<Person> person = new ArrayList<Person>();
		Person p = new Person("Person Service 故障");
		person.add(p);
		return person;
	}
}
