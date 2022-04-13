package com.dh.clinica.service.mongo;

import com.dh.clinica.model.mongo.Domicilio;
import com.dh.clinica.repository.impl.mongo.DomicilioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {
    private DomicilioRepository domicilioRepositoryMongo;

    public DomicilioService(DomicilioRepository domicilioRepositoryMongo) {
        this.domicilioRepositoryMongo = domicilioRepositoryMongo;
    }

    public Domicilio guardar(Domicilio d){
        return domicilioRepositoryMongo.save(d);
    }

    public List<Domicilio> listar(){
        return domicilioRepositoryMongo.findAll();
    }
    public Domicilio buscar(String id){
        return domicilioRepositoryMongo.findById(id).orElseGet(null);
    }
    public void eliminar(String id){
        domicilioRepositoryMongo.deleteById(id);
    }


}
