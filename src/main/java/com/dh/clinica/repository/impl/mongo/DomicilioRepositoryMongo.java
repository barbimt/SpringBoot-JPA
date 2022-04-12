package com.dh.clinica.repository.impl.mongo;

import com.dh.clinica.model.mongo.DomicilioMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepositoryMongo extends MongoRepository<DomicilioMongo, Integer> {
}
