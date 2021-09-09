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
	
 /*	@Query (value ="SELECT mm, ma FROM medical_record_medications mm INNER JOIN medical_record_allergies ma "
	 		+ "ON medical_record_id WHERE m.firstName = ?1 AND m.lastName = ?2")
	public List<String> getFireMedicationAndAllergie (String firstName, String lastName);  */
} 
