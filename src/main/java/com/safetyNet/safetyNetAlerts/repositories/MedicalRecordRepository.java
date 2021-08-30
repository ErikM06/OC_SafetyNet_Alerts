package com.safetyNet.safetyNetAlerts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;

@Repository
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Integer>{
	
	public MedicalRecord findByFirstName (String firstname);
	
	public MedicalRecord findByFirstNameAndLastName (String firstName, String lastName);
	
	@Query (value ="SELECT m.birthdate FROM MedicalRecord m WHERE m.lastName = ?1" )
	public List<String> getBirthDateWithLastName(String lastName);

}
