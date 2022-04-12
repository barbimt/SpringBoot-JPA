package com.dh.clinica.service;


import com.dh.clinica.model.Paciente;
import com.dh.clinica.model.PacienteDTO;
import com.dh.clinica.repository.impl.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements  IPacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private Paciente guardarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente crearPaciente(PacienteDTO pacienteDTO) {
        return guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO leerPaciente(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public Paciente modificarPaciente(PacienteDTO pacienteDTO) {
        return guardarPaciente(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Integer id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> leerTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for(Paciente paciente : pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }
    }

