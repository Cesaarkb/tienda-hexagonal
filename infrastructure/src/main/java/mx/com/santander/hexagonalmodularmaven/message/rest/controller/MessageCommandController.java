package mx.com.santander.hexagonalmodularmaven.message.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.message.command.MessageCreateHandler;
import mx.com.santander.hexagonalmodularmaven.message.model.dto.command.ClienteCreadoMessage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class MessageCommandController {
    private final MessageCreateHandler messageCreateHandler;
    @PostMapping("/crear")
    public ResponseEntity<String> crearCliente(@RequestBody ClienteCreadoMessage cliente) {
        String mensajeEnviado = messageCreateHandler.execute(cliente);
        return ResponseEntity.ok("Mensaje enviado: " + mensajeEnviado);
    }
}
