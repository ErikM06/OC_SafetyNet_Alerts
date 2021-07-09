package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.safetyNetAlerts.models.Entities;


@Repository
public interface EntitiesDaoImple extends JpaRepository <Entities, Integer> {
	
}
