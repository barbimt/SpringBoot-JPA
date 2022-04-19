package com.dh.clinica.service.IService;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO);
    public OdontologoDTO leerOdontologo(Integer id);
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundException;
    public void eliminarOdontologo(Integer id) throws BadRequestException, ResourceNotFoundException;
    Set<OdontologoDTO> leerTodos();
}
