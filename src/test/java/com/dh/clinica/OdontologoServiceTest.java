package com.dh.clinica;

import static org.junit.jupiter.api.Assertions.*;

import com.dh.clinica.model.OdontologoDTO;
import com.dh.clinica.service.IOdontologoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void testCrearOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Eugenia");
        odontologoDTO.setApellido("Lauría");
        odontologoDTO.setMatricula("567");
        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoEugenia =  odontologoService.leerOdontologo(1);

        assertTrue(odontologoEugenia != null );
    }
}