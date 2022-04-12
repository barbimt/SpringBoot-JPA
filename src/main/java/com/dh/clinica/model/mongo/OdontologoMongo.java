package com.dh.clinica.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
@Document(collection = "odontologos")
public class OdontologoMongo {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;
    private Set<TurnoMongo> turnos;

    public OdontologoMongo() {
    }

    public OdontologoMongo(Integer id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;

    }

    public OdontologoMongo(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Set<TurnoMongo> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<TurnoMongo> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "OdontologoMongo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                ", turnos=" + turnos +
                '}';
    }
}
