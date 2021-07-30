package com.safetyNet.safetyNetAlerts.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.Medicalrecord;

@Repository
public interface MedicalRecordRepository extends CrudRepository<Medicalrecord, Integer>{

}
