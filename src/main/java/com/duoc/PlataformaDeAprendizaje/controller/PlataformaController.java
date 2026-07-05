package com.duoc.PlataformaDeAprendizaje.controller;

import com.duoc.PlataformaDeAprendizaje.model.Curso;
import com.duoc.PlataformaDeAprendizaje.model.InscripcionDTO;
import com.duoc.PlataformaDeAprendizaje.model.ResumenInscripcion;
import com.duoc.PlataformaDeAprendizaje.repository.CursoRepository;
import com.duoc.PlataformaDeAprendizaje.repository.ResumenInscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlataformaController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ResumenInscripcionRepository resumenInscripcionRepository;

    @Autowired
    private RabbitProducer rabbitProducer;

    // --- Endpoints de Cursos ---

    @GetMapping("/cursos")
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    @PostMapping("/cursos")
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    // --- Endpoints de Inscripciones ---

    @GetMapping("/inscripciones")
    public List<ResumenInscripcion> listarInscripciones() {
        return resumenInscripcionRepository.findAll();
    }

    @PostMapping("/inscripciones")
    public String inscribir(@RequestBody InscripcionDTO dto) {
        rabbitProducer.enviar(dto);
        return "Inscripción recibida y enviada a la cola";
    }
}