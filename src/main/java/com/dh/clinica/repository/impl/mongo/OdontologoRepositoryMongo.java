package com.dh.clinica.repository.impl.mongo;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.mongo.OdontologoMongo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepositoryMongo extends MongoRepository<OdontologoMongo, Integer> {
    /*
    @Query("SELECT o FROM odontologo o WHERE LOWER(o.nombre) LIKE('%' || LOWER(?1) || '%')")
    Optional<Odontologo> buscarOdontologoPorNombre(String nombre);*/
}
