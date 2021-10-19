package com.safetyNet.safetyNetAlerts.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.DTO.EmailDTO;
import com.safetyNet.safetyNetAlerts.DTO.PersonInfoDTO;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	public Person findByFirstName(String firstname);

	public Person findByFirstNameAndLastName(String firstName, String lastName);

	/*
	 * @Query for StationNumverPerHabitantService
	 */
	@Query(value = "SELECT m.birthdate FROM MedicalRecord m INNER JOIN Person p"
			+ " ON m.firstName = p.firstName AND m.lastName = p.lastName "
			+ " INNER JOIN Firestation f ON f.address = p.address WHERE f.station = ?1 and m.birthdate > ?2")
	public List<Date> getChildrenByStation(int station, Date ageLimit);

	@Query(value = "SELECT m.birthdate FROM MedicalRecord m INNER JOIN Person p"
			+ " ON m.firstName = p.firstName AND m.lastName = p.lastName "
			+ " INNER JOIN Firestation f ON f.address = p.address WHERE f.station = ?1 and m.birthdate < ?2")
	public List<Date> getAdultByStation(int station, Date ageLimit);

	/*
	 * @Query for ChildAlertService
	 */

	@Query(value = "SELECT p " + "FROM Person p INNER JOIN MedicalRecord m"
			+ " ON m.firstName = p.firstName AND m.lastName = p.lastName WHERE p.address = ?1 AND m.birthdate < ?2 ORDER BY m.birthdate DESC ")
	public List<Person> getFamilyByAddress(String address, Date ageLimit);

	/*
	 * @Query for childAlertService get the age (need to work on this)
	 */
	@Query(value = "SELECT  m " + " FROM MedicalRecord m  INNER JOIN Person p  "
			+ " ON m.firstName = p.firstName AND m.lastName = p.lastName WHERE p.address = ?1 AND m.birthdate > ?2 ORDER BY m.birthdate DESC")
	public List<MedicalRecord> getChildrenByAddress(String address, Date ageLimit);

	@Query(value = "SELECT new com.safetyNet.safetyNetAlerts.DTO.PersonInfoDTO (p as person, m as medicalRecord) "
			+ "FROM MedicalRecord m INNER JOIN Person p ON m.firstName = p.firstName AND m.lastName = p.lastName"
			+ " WHERE p.firstName =?1 AND p.lastName =?2  ")

	public List<PersonInfoDTO> getPersonInfoByFirstnameAndLastname(String firstname, String lastname);

	@Query(value = "SELECT new com.safetyNet.safetyNetAlerts.DTO.PersonInfoDTO (p as Pperson, m as medicalRecord)"
			+ " FROM MedicalRecord m INNER JOIN Person p ON m.firstName = p.firstName AND m.lastName = p.lastName"
			+ " WHERE  p.lastName =?1 ")
	public List<PersonInfoDTO> getPersonByLastName(String lastname);

	@Query(value = "SELECT new com.safetyNet.safetyNetAlerts.DTO.EmailDTO (p as Person)"
			+ "FROM Person p WHERE p.city = ?1")
	public List<EmailDTO> getAllEmailFromCity(String city);

}
