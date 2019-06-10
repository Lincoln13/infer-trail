package com.hackathon.infer.controllers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.infer.models.Test;
import com.hackathon.infer.repositories.TrailRepository;

@RestController
@RequestMapping("/pets")
public class PetsController {
	@Autowired
	private TrailRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Test> getAllPets() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Test getPetById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
 
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Test pets) {
		pets.set_id(id);
		repository.save(pets);
	}
 
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Test createPet(@Valid @RequestBody Test pets) {
		pets.set_id(ObjectId.get());
		repository.save(pets);
		return pets;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePet(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
}