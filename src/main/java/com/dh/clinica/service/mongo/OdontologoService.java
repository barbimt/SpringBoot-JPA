package com.dh.clinica.service.mongo;

import com.dh.clinica.model.mongo.Odontologo;
import com.dh.clinica.repository.impl.mongo.OdontologoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoService {
    private OdontologoRepository odontologoRepositoryMongo;

    // Constructor
    public OdontologoService(OdontologoRepository odontologoRepositoryMongo) {
        this.odontologoRepositoryMongo = odontologoRepositoryMongo;
    }

    public Odontologo guardar(Odontologo o){
        return odontologoRepositoryMongo.save(o);
    }

    public List<Odontologo> listar(){
        return odontologoRepositoryMongo.findAll();
    }

    public Odontologo buscar(String id){
        return odontologoRepositoryMongo.findById(id).orElseGet(null);
    }

    public void eliminar(String id){
        odontologoRepositoryMongo.deleteById(id);
    }

    public Odontologo editar(Odontologo o){
        return odontologoRepositoryMongo.save(o);
    }
}
