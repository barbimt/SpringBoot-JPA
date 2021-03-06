package com.dh.clinica.service;

import com.dh.clinica.model.*;
import com.dh.clinica.model.dto.TurnoDTO;
import com.dh.clinica.repository.impl.OdontologoRepository;
import com.dh.clinica.repository.impl.PacienteRepository;
import com.dh.clinica.repository.impl.TurnoRepository;
import com.dh.clinica.service.IService.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private Turno guardarTurno(TurnoDTO turnoDTO) {
        Paciente paciente = pacienteRepository.findById(turnoDTO.getPaciente().getId()).get();
        Odontologo odontologo = odontologoRepository.findById(turnoDTO.getOdontologo().getId()).get();
        turnoDTO.setPaciente(paciente);
        turnoDTO.setOdontologo(odontologo);
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        return turnoRepository.save(turno);
    }

    @Override
    public Turno crearTurno(TurnoDTO turnoDTO) {
        return guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO leerTurno(Integer id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public Turno modificarTurno(TurnoDTO turnoDTO) {
        return guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Integer id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> leerTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for(Turno turno : turnos) {
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }

}
