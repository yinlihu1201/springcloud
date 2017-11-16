package com.tiger.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiger.person.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
