package com.duoc.PlataformaDeAprendizaje.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESUMEN_INSCRIPCION")
public class ResumenInscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rut;
    private String nombre;
    private String curso;
    private LocalDateTime fechaProcesamiento;

    public ResumenInscripcion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public LocalDateTime getFechaProcesamiento() { return fechaProcesamiento; }
    public void setFechaProcesamiento(LocalDateTime fechaProcesamiento) { this.fechaProcesamiento = fechaProcesamiento; }
}