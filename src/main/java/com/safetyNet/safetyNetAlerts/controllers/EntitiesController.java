package com.safetyNet.safetyNetAlerts.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.safetyNet.safetyNetAlerts.models.Entities;
import com.safetyNet.safetyNetAlerts.models.Firestation;

@RestController
public class EntitiesController {

	@Autowired
	private EntitiesDaoImple entitiesDaoImple;

	@GetMapping(value = "persons")

	public List<Firestation> entitiesList() {
		return entitiesDaoImple.findAll();
	}

	public void returnAllEntities() {

	}

	public void addAnEntity() {

	}

	@PostMapping(value = "/persons")
	public ResponseEntity<Void> ajouterProduit(@RequestBody Firestation firestation) {

		Firestation entityAdded = entitiesDaoImple.save(firestation);

		if (entityAdded == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(entityAdded.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	public void deleteAnEntity() {

	}

	public void sortAllEntities() {

	}

}
