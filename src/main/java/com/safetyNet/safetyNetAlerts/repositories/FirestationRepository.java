package com.safetyNet.safetyNetAlerts.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.Firestation;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, Integer> {

	public Firestation findByAddress (String address);
	
	
	public Iterable<Firestation> findAllByStation (int station);
}
