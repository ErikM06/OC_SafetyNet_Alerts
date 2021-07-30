package com.safetyNet.safetyNetAlerts.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.Firestation;

@Repository
public interface FiresationRepository extends CrudRepository<Firestation, Integer> {

}
