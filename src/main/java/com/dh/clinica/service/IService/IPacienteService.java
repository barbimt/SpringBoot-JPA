package com.dh.clinica.service.IService;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.model.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    public Paciente crearPaciente(PacienteDTO pacienteDTO);
    public PacienteDTO leerPaciente(Integer id);
    public Paciente modificarPaciente(PacienteDTO pacienteDTO);
    public void eliminarPaciente(Integer id);
    Set<PacienteDTO> leerTodos();
}
