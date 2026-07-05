package com.duoc.PlataformaDeAprendizaje.repository;

import com.duoc.PlataformaDeAprendizaje.model.ResumenInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumenInscripcionRepository extends JpaRepository<ResumenInscripcion, Long> {
}