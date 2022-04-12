package com.dh.clinica.repository.impl.mongo;

import com.dh.clinica.model.Turno;
import com.dh.clinica.model.mongo.TurnoMongo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepositoryMongo extends MongoRepository<TurnoMongo, Integer> {
}
