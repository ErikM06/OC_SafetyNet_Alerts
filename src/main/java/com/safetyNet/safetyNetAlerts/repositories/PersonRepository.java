package com.safetyNet.safetyNetAlerts.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

	public Person findByFirstName(String firstname);
	

}
