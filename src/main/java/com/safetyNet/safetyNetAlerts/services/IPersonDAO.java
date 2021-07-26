package com.safetyNet.safetyNetAlerts.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.safetyNet.safetyNetAlerts.models.Person;

public interface IPersonDAO extends CrudRepository<Person, Integer>{
	
	public List<Person>FindById(int id);
	public List<Person>FindByLastName(String lastName);

}
