package com.duoc.PlataformaDeAprendizaje.controller;

import com.duoc.PlataformaDeAprendizaje.model.Curso;
import com.duoc.PlataformaDeAprendizaje.model.InscripcionDTO;
import com.duoc.PlataformaDeAprendizaje.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlataformaController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private RabbitProducer rabbitProducer;

    @GetMapping("/cursos")
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    @PostMapping("/cursos")
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @PostMapping("/inscripciones")
    public String inscribir(@RequestBody InscripcionDTO dto) {
        rabbitProducer.enviar(dto);
        return "Inscripción recibida y enviada a la cola";
    }
}