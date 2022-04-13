package com.dh.clinica.repository.impl.mongo;

import com.dh.clinica.model.mongo.Domicilio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends MongoRepository<Domicilio, String> {
}
