package mx.com.santander.hexagonalmodularmaven.message.adapter.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class KafkaConsumerAdapter {
    @KafkaListener(topics = "clientes_creados",groupId = "my-consumer-group")
     public void consumeMessage(String message) {
        log.info("Mensaje consumido: " + message);
    }
}
