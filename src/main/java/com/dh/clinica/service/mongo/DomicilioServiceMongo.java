package com.dh.clinica.service.mongo;

import com.dh.clinica.model.Domicilio;
import com.dh.clinica.model.mongo.DomicilioMongo;
import com.dh.clinica.repository.impl.mongo.DomicilioRepositoryMongo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceMongo {
    private DomicilioRepositoryMongo domicilioRepositoryMongo;

    public DomicilioServiceMongo(DomicilioRepositoryMongo domicilioRepositoryMongo) {
        this.domicilioRepositoryMongo = domicilioRepositoryMongo;
    }

    public DomicilioMongo guardar(DomicilioMongo d){
        return domicilioRepositoryMongo.save(d);
    }

    public List<DomicilioMongo> listar(){
        return domicilioRepositoryMongo.findAll();
    }
    public DomicilioMongo buscar(Integer id){
        return domicilioRepositoryMongo.findById(id).orElseGet(null);
    }
    public void eliminar(Integer id){
        domicilioRepositoryMongo.deleteById(id);
    }


}
