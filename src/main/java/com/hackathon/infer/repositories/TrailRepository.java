package com.hackathon.infer.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.infer.models.Test;

@Repository
public interface TrailRepository extends MongoRepository<Test, String> {
	Test findBy_id(ObjectId _id);
}
