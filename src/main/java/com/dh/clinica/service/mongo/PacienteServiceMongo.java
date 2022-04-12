package com.dh.clinica.service.mongo;

import com.dh.clinica.model.mongo.DomicilioMongo;
import com.dh.clinica.model.mongo.OdontologoMongo;
import com.dh.clinica.model.mongo.PacienteMongo;
import com.dh.clinica.repository.impl.mongo.DomicilioRepositoryMongo;
import com.dh.clinica.repository.impl.mongo.PacienteRepositoryMongo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteServiceMongo {
    private PacienteRepositoryMongo pacienteRepositoryMongo;

    public PacienteServiceMongo(PacienteRepositoryMongo pacienteRepositoryMongo) {
        this.pacienteRepositoryMongo = pacienteRepositoryMongo;
    }

    public PacienteMongo guardar(PacienteMongo p){
        return pacienteRepositoryMongo.save(p);
    }

    public List<PacienteMongo> listar(){
        return pacienteRepositoryMongo.findAll();
    }
    public PacienteMongo buscar(Integer id){
        return pacienteRepositoryMongo.findById(id).orElseGet(null);
    }
    public void eliminar(Integer id){
        pacienteRepositoryMongo.deleteById(id);
    }
    public PacienteMongo editar(PacienteMongo pacienteMongo){
        return pacienteRepositoryMongo.insert(pacienteMongo);
    }
}
