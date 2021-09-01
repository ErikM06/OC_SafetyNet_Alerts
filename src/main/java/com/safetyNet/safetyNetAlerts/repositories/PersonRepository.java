package com.safetyNet.safetyNetAlerts.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

	public Person findByFirstName(String firstname);
	
	public Person findByFirstNameAndLastName (String firstName, String lastName);
	
	@Query(value = "SELECT m.birthdate FROM MedicalRecord m INNER JOIN Person p ON m.firstName = p.firstName AND m.lastName = p.lastName WHERE p = ?1 ")
	public List<String> getBirthdateByFnLn (Person person);
	
	@Query(value = "SELECT p FROM Person p INNER JOIN Medicalrecords m ON p.firstName = m.firstname AND p.lastName = m.lastname " +
			"WHERE p.address = ?1 AND m.birthdate > ?2 ")
	public List<Person> findPersonUnder18YearsAtAnAddress(String address, Date eightyYearsLimit);

	

	

}
