package com.hackathon.infer.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * the name of this model class is very important
 * it tells which collection of the db we are using
 * @author lincoln
 *
 */
public class Test {
	@Id
	public ObjectId _id;

	public String name;
	public String species;
	public String breed;

	// Constructors
	public Test() {
	}

	public Test(ObjectId _id, String name, String species, String breed) {
		this._id = _id;
		this.name = name;
		this.species = species;
		this.breed = breed;
	}

	// ObjectId needs to be converted to string
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
}
