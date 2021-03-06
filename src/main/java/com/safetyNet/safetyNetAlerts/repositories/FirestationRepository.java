package com.safetyNet.safetyNetAlerts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.DTO.FloodDTO;
import com.safetyNet.safetyNetAlerts.DTO.PhoneAddressDTO;
import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.models.Person;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, Integer> {

	public Firestation findByAddress(String address);

	@Query(value = "SELECT p  FROM Person p INNER JOIN Firestation f on p.address = f.address WHERE f.station = ?1 ")
	public List<Person> findAllByStation(int station);

	@Query(value = "Select new com.safetyNet.safetyNetAlerts.DTO.PhoneAddressDTO (p as person ) FROM Person p INNER JOIN Firestation f "
			+ " ON p.address = f.address  WHERE f.station = ?1 ORDER BY p.address")
	public List<PhoneAddressDTO> findPhoneByStation(int station);

	@Query(value = "Select new com.safetyNet.safetyNetAlerts.DTO.FloodDTO (p as person, m as medicalRecord) "
			+ " FROM Person p " + "INNER JOIN MedicalRecord m ON p.firstName = m.firstName AND p.lastName = m.lastName "
			+ "INNER JOIN Firestation f ON f.address = p.address  WHERE f.station = ?1 ORDER BY p.address")
	public List<FloodDTO> getPersonAndMedicalInfoByListOfStation(int oneStationNumber);

}
