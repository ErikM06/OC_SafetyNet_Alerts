package com.safetyNet.safetyNetAlerts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.models.Person;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, Integer> {

	public Firestation findByAddress (String address);
	
	
	@Query (value = "SELECT p  FROM Person p INNER JOIN Firestation f on p.address = f.address WHERE f.station = ?1 ")
	public List<Person> findAllByStation (int station);
	
	
}
