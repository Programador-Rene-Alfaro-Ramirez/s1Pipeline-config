package com.duoc.PlataformaDeAprendizaje.consumer;

import com.duoc.PlataformaDeAprendizaje.model.InscripcionDTO;
import com.duoc.PlataformaDeAprendizaje.model.ResumenInscripcion;
import com.duoc.PlataformaDeAprendizaje.repository.ResumenInscripcionRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional; // <-- IMPORTANTE: Nueva importación
import java.time.LocalDateTime;

@Component
public class RabbitMQConsumer {

    @Autowired
    private ResumenInscripcionRepository repository;

    @RabbitListener(queues = "${duoc.queue.name}")
    @Transactional // <-- IMPORTANTE: Nueva anotación para manejar la transacción de BD y el ACK de RabbitMQ
    public void consumirMensaje(InscripcionDTO mensaje) {
        System.out.println("=========================================");
        System.out.println("📬 MENSAJE RECIBIDO DESDE LA COLA RABBITMQ");
        System.out.println("Procesando inscripcion de: " + mensaje.getNombre());
        System.out.println("Curso asociado: " + mensaje.getCurso());

        // Transformamos el mensaje (DTO) a la Entidad de BD
        ResumenInscripcion resumen = new ResumenInscripcion();
        resumen.setRut(mensaje.getRut());
        resumen.setNombre(mensaje.getNombre());
        resumen.setCurso(mensaje.getCurso());
        resumen.setFechaProcesamiento(LocalDateTime.now());

        // Guardamos físicamente en Oracle Cloud
        repository.save(resumen);

        System.out.println("✅ Resumen de compra guardado exitosamente en Oracle Cloud.");
        System.out.println("=========================================");
    }
}