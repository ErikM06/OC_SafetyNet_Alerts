package com.safetyNet.safetyNetAlerts.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.safetyNet.safetyNetAlerts.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{

	//Person getLastName(String lastname);
	

}
