package com.dh.clinica.repository.impl.mongo;

import com.dh.clinica.model.mongo.PacienteMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositoryMongo extends MongoRepository<PacienteMongo, Integer> {
}
