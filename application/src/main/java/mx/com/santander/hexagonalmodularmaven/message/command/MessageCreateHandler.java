package mx.com.santander.hexagonalmodularmaven.message.command;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.message.model.dto.command.ClienteCreadoMessage;
import mx.com.santander.hexagonalmodularmaven.message.service.CreateMessageService;

@Component
@RequiredArgsConstructor
public class MessageCreateHandler {
    private final CreateMessageService createMessageService;
    public String execute (ClienteCreadoMessage clienteMessage){
       String mensajeJson = new Gson().toJson(clienteMessage);
    return createMessageService.execute(mensajeJson);
    }
}
