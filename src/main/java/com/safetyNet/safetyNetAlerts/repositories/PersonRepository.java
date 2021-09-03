package com.safetyNet.safetyNetAlerts.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.DTO.FireAddress;
import com.safetyNet.safetyNetAlerts.models.Child;
import com.safetyNet.safetyNetAlerts.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

	public Person findByFirstName(String firstname);
	
	public Person findByFirstNameAndLastName (String firstName, String lastName);
	
	/*
	 * @Query for StationNumverPerHabitantService
	 */
	@Query(value = "SELECT m.birthdate FROM MedicalRecord m INNER JOIN Person p"
			+ " ON m.firstName = p.firstName AND m.lastName = p.lastName "
			+ " INNER JOIN Firestation f ON f.address = p.address WHERE f.station = ?1 and m.birthdate > ?2")
	public List<Date> getChildrenByStation (int station, Date ageLimit);
	
	@Query(value = "SELECT m.birthdate FROM MedicalRecord m INNER JOIN Person p"
			+ " ON m.firstName = p.firstName AND m.lastName = p.lastName "
			+ " INNER JOIN Firestation f ON f.address = p.address WHERE f.station = ?1 and m.birthdate < ?2")
	public List<Date> getAdultByStation (int station, Date ageLimit);
	
	 /*
	  * @Query for ChildAlertService
	  */
	@Query(value = "SELECT p FROM Person p INNER JOIN MedicalRecord m"
			+ " ON m.firstName = p.firstName AND m.lastName = p.lastName WHERE p.address = ?1 ")
	public List<Person> getPersonByAddress (String address);
	
	/*
	 * @Query for childAlertService get the age (need to work on this)
	 */
	@Query(value = "SELECT new com.safetyNet.safetyNetAlerts.models.Child (p.firstName as firstName ,p.lastName as lastName , "
			+ " m.birthdate as birthdate) FROM MedicalRecord m  INNER JOIN Person p  "
			+ " ON m.firstName = p.firstName AND m.lastName = p.lastName WHERE p.address = ?1 and m.birthdate > ?2")
	public List<Child> getChildrenByAddress (String address, Date ageLimit);
	
	/*
	 * @Query for fireAddress
	 */
	
	@Query (value = "SELECT p.firstName as firstName, p.lastName as lastName, p.phone as phone, m.birthdate as birthdate, f.station as station "
			+ " FROM Person p INNER JOIN MedicalRecord m ON p.firstName = m.firstName AND p.lastName = m.lastName INNER JOIN Firestation f "
			+ "  ON p.address = f.address WHERE f.address = ?1")
	public List<FireAddress> getFnLnPhoneStationBirthdateByStation (String address);
	


}
