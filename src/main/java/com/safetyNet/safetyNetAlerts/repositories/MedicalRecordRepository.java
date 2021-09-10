package com.safetyNet.safetyNetAlerts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.DTO.FireAddressView;
import com.safetyNet.safetyNetAlerts.controllers.FireAddressDTO;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;

@Repository
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Integer>{
	
	
	public MedicalRecord findByFirstName (String firstname);
	
	public MedicalRecord findByFirstNameAndLastName (String firstName, String lastName);
	
	@Query (value ="SELECT m.birthdate FROM MedicalRecord m WHERE m.lastName = ?1" )
	public List<String> getBirthDateWithLastName(String lastName);
	
	/*
	 * @Query for fireAddress
	 */
	
	  @Query (value = "SELECT new com.safetyNet.safetyNetAlerts.controllers.FireAddressDTO (m as medicalRecordLs, p.address as address,"
			+ "p.phone as phone, f.station as station)"
			+ "	FROM MedicalRecord m"
     		+ " INNER JOIN Person p ON m.firstName = p.firstName AND m.lastName = p.lastName"
     		+ " INNER JOIN Firestation f ON p.address = f.address"
     		+ " WHERE p.address = ?1 ") 
	public List<FireAddressDTO> getMedicalRecordByAddress (String address); 
} 
