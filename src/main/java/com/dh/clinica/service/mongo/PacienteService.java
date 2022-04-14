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
    @Autowired
    private PacienteRepository pacienteRepository;

@Autowired
private DomicilioRepository domicilioRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p){
    Domicilio domicilio = domicilioRepository.save(p.getDomicilio());

        return pacienteRepository.save(p);
    }

    public List<Paciente> listar(){
        return pacienteRepository.findAll();
    }

    public Paciente buscar(String id){
        return pacienteRepository.findById(id).orElseGet(null);
    }
    public void eliminar(String id){
        pacienteRepository.deleteById(id);
    }
    public Paciente editar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
}
