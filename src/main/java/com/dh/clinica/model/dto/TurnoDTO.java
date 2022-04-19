package com.dh.clinica.model.dto;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class TurnoDTO {
    private Integer id;
    private LocalDate fecha;
    private Time hora;
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Paciente paciente;
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Odontologo odontologo;

    public Integer getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
