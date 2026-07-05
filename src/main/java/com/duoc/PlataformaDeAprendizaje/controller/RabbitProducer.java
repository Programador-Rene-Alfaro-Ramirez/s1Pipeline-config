package com.duoc.PlataformaDeAprendizaje.controller;

import com.duoc.PlataformaDeAprendizaje.model.InscripcionDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviar(InscripcionDTO dto) {
        rabbitTemplate.convertAndSend("inscripciones.queue", dto);
    }
}