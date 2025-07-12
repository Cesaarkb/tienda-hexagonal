package mx.com.santander.hexagonalmodularmaven.message.adapter.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import mx.com.santander.hexagonalmodularmaven.message.model.dto.command.ClienteCreadoMessage;
@Slf4j
@Component
public class KafkaConsumerAdapter {
  
    @KafkaListener(topics = "clientes_creados", groupId = "my-consumer-group")
    public void consumeMessage(String message) {
        log.info("Mensaje consumido (JSON): {}", message);

        ClienteCreadoMessage cliente = new Gson().fromJson(message, ClienteCreadoMessage.class);

        enviarCorreoBienvenida(cliente);
    }

    private void enviarCorreoBienvenida(ClienteCreadoMessage cliente) {
        log.info("Enviando correo de bienvenida a: {} <{}>", cliente.getNombre() + " " + cliente.getApellido(), cliente.getEmail());
    }
}
