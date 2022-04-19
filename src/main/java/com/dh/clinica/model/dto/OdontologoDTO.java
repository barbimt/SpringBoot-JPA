package com.dh.clinica.model.dto;

public class OdontologoDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;



    public Integer getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }



}
