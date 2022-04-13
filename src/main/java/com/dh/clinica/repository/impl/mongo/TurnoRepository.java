package com.dh.clinica.repository.impl.mongo;

import com.dh.clinica.model.mongo.Turno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends MongoRepository<Turno, String> {
}