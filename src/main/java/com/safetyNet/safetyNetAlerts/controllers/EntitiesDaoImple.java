package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.safetyNet.safetyNetAlerts.models.Entities;
import com.safetyNet.safetyNetAlerts.models.Firestation;


@Repository
public interface EntitiesDaoImple extends JpaRepository <Firestation, Integer> {
	
}
