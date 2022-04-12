package com.dh.clinica.service.mongo;

import com.dh.clinica.model.mongo.OdontologoMongo;
import com.dh.clinica.repository.impl.mongo.OdontologoRepositoryMongo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoServiceMongo {
    private OdontologoRepositoryMongo odontologoRepositoryMongo;

    // Constructor
    public OdontologoServiceMongo(OdontologoRepositoryMongo odontologoRepositoryMongo) {
        this.odontologoRepositoryMongo = odontologoRepositoryMongo;
    }

    public OdontologoMongo guardar(OdontologoMongo o){
        return odontologoRepositoryMongo.save(o);
    }

    public List<OdontologoMongo> listar(){
        return odontologoRepositoryMongo.findAll();
    }

    public OdontologoMongo buscar(Integer id){
        return odontologoRepositoryMongo.findById(id).orElseGet(null);
    }

    public void eliminar(Integer id){
        odontologoRepositoryMongo.deleteById(id);
    }

    public OdontologoMongo editar(OdontologoMongo o){
        return odontologoRepositoryMongo.save(o);
    }
}
