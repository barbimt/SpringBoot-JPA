package com.dh.clinica.service;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO);
    public OdontologoDTO leerOdontologo(Integer id);
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDTO);
    public void eliminarOdontologo(Integer id);
    Set<OdontologoDTO> leerTodos();
}
