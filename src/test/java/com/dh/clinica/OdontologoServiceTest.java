package com.dh.clinica;

import static org.junit.jupiter.api.Assertions.*;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.dto.OdontologoDTO;
import com.dh.clinica.service.IService.IOdontologoService;

import com.dh.clinica.service.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;
    private OdontologoDTO odontologoDTO;

    @Test
    @Order(1)
    void crearOdontologoTest(){
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setMatricula("123");
        odontologoDTO.setApellido("Torres");
        odontologoDTO.setNombre("Barbi");
        odontologoService.crearOdontologo(odontologoDTO);
        Assert.assertTrue(odontologoService.leerOdontologo(1)!=null);
        Assert.assertNotNull(odontologoService.leerOdontologo(1));
    }
    @Test
    @Order(2)
    public void traerTodosTest() {
        Set<OdontologoDTO> odontologos = odontologoService.leerTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() == 1);
        System.out.println(odontologos);
    }

    @Test
    @Order(3)
    public void eliminarOdontologoTest() throws BadRequestException, ResourceNotFoundException {
        OdontologoDTO odontologoGuardado = odontologoService.leerOdontologo(1);
        assertNotNull(odontologoService.leerOdontologo(odontologoGuardado.getId()));
        odontologoService.eliminarOdontologo(1);
        assertNull(odontologoService.leerOdontologo(1));
        //assertThrows(com.dh.clinica.exceptions.BadRequestException.class/*org.hibernate.LazyInitializationException.class*//*ConfigDataResourceNotFoundException.class*/, () -> odontologoService.leerOdontologo(odontologoGuardado.getId()));

    }


}