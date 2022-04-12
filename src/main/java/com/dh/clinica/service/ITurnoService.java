package com.dh.clinica.service;

import com.dh.clinica.model.Turno;
import com.dh.clinica.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    public Turno crearTurno(TurnoDTO turnoDTO);
    public TurnoDTO leerTurno(Integer id);
    public Turno modificarTurno(TurnoDTO turnoDTO);
    public void eliminarTurno(Integer id);
    Set<TurnoDTO> leerTodos();
}
