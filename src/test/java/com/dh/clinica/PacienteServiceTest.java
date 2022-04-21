package com.dh.clinica;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Domicilio;
import com.dh.clinica.model.dto.OdontologoDTO;
import com.dh.clinica.model.dto.PacienteDTO;
import com.dh.clinica.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
 class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;
    private PacienteDTO pacienteDTO;

    @Test
    @Order(1)
    void crearPacienteTest(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Barbi");
        pacienteDTO.setApellido("Torres");
        pacienteDTO.setDni("37832290");
        pacienteDTO.setFechaIngreso(LocalDate.of(2022,05,05));
        pacienteDTO.setDomicilio(new Domicilio("saavedra", "123", "Santa Fe", "Santa Fe")
        );
        pacienteDTO.setEmail("barbi@gmail.com");
        pacienteService.crearPaciente(pacienteDTO);
        Assert.assertTrue(pacienteService.leerPaciente(1)!=null);
        Assert.assertNotNull(pacienteService.leerPaciente(1));
    }

    @Test
    @Order(2)
    public void traerTodosTest() {
        Set<PacienteDTO> pacientes = pacienteService.leerTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 1);
        System.out.println(pacientes);
    }
    @Test
    @Order(3)
    public void eliminarOdontologoTest() throws BadRequestException, ResourceNotFoundException {
        PacienteDTO pacienteGuardado = pacienteService.leerPaciente(1);
        assertNotNull(pacienteService.leerPaciente(pacienteGuardado.getId()));
        pacienteService.eliminarPaciente(1);
        assertNull(pacienteService.leerPaciente(1));
        //assertThrows(com.dh.clinica.exceptions.BadRequestException.class/*org.hibernate.LazyInitializationException.class*//*ConfigDataResourceNotFoundException.class*/, () -> odontologoService.leerOdontologo(odontologoGuardado.getId()));

    }
}
