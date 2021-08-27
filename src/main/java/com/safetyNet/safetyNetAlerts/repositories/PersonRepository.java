package com.safetyNet.safetyNetAlerts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

	public Person findByFirstName(String firstname);
	
	public Person findByFirstNameAndLastName (String firstName, String lastName);
	
	@Query(value = "SELECT  p.firstName ,p.lastName ,p.address ,p.phone FROM Person p  WHERE p.address = ?1 ")
	public List<Person> getFnLnAddressPhoneByAddress (@Param ("address")String address);
	

}
