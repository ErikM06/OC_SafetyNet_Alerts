package com.safetyNet.safetyNetAlerts.repositories;

import java.time.LocalDate;
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
	
	@Query(value = "SELECT m.birthdate FROM MedicalRecord m INNER JOIN Person p"
			+ " ON m.firstName = p.firstName AND m.lastName = p.lastName "
			+ " INNER JOIN Firestation f ON f.address = p.address WHERE f.station = ?1")
	public List<Date> getBirthdateByStation (int station);
	


}
