package mx.com.santander.hexagonalmodularmaven.message.adapter.kafka;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducerAdapter {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public String produceMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("clientes_creados", message);

        future.thenAccept(result -> {
            System.out.println("Mensaje enviado con éxito al topic: " + result.getRecordMetadata().topic() +
                    ", partition: " + result.getRecordMetadata().partition() +
                    ", offset: " + result.getRecordMetadata().offset());
        }).exceptionally(ex -> {
            System.out.println("Error al enviar el mensaje: " + ex.getMessage());
            return null;
        });

        return message;
    }
}
