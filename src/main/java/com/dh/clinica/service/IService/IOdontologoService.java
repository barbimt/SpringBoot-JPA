package com.dh.clinica.service.IService;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException;
    public OdontologoDTO leerOdontologo(Integer id)throws ResourceNotFoundException;
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException, ResourceNotFoundException;
    public void eliminarOdontologo(Integer id) throws BadRequestException, ResourceNotFoundException;
    Set<OdontologoDTO> leerTodos();
}
