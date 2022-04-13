package com.dh.clinica.service.mongo;

import com.dh.clinica.model.mongo.Domicilio;
import com.dh.clinica.model.mongo.Paciente;
import com.dh.clinica.repository.impl.mongo.DomicilioRepository;
import com.dh.clinica.repository.impl.mongo.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {
    private PacienteRepository pacienteRepositoryMongo;
@Autowired
private DomicilioRepository domicilioRepository;
    public PacienteService(PacienteRepository pacienteRepositoryMongo) {
        this.pacienteRepositoryMongo = pacienteRepositoryMongo;
    }

    public Paciente guardar(Paciente p){
        Domicilio domicilio = domicilioRepository.findById(p.getDomicilio().getId()).get();
        p.setDomicilio(domicilio);
        return pacienteRepositoryMongo.save(p);
    }

    public List<Paciente> listar(){
        return pacienteRepositoryMongo.findAll();
    }

    public Paciente buscar(String id){
        return pacienteRepositoryMongo.findById(id).orElseGet(null);
    }
    public void eliminar(String id){
        pacienteRepositoryMongo.deleteById(id);
    }
    public Paciente editar(Paciente pacienteMongo){
        return pacienteRepositoryMongo.insert(pacienteMongo);
    }
}
