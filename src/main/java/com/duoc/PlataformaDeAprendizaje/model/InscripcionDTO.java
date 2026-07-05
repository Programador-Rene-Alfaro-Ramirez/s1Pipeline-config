package com.duoc.PlataformaDeAprendizaje.model;

import java.io.Serializable;

public class InscripcionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String rut;
    private String nombre;
    private String curso;
    private String fecha;

    public InscripcionDTO() {}

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}