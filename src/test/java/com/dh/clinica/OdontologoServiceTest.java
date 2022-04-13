package com.dh.clinica;

import static org.junit.jupiter.api.Assertions.*;

import com.dh.clinica.model.mongo.Odontologo;
import com.dh.clinica.service.mongo.OdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void testCrearOdontologo() {
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Eugenia");
        odontologo.setApellido("Lauría");
        odontologo.setMatricula(565);
        odontologoService.guardar(odontologo);

        Odontologo odontologoEugenia =  odontologoService.buscar("1");

        assertTrue(odontologoEugenia != null );
    }
}