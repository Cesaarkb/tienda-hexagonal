package mx.com.santander.hexagonalmodularmaven.cliente.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteCreateReqToCommandMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.command.ClienteCreateHandler;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.rest.controller.dto.ClienteCreateRequest;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteCommandController {

private final ClienteCreateReqToCommandMapper clienteCreateReqToCommandMapper;
private final ClienteCreateHandler clienteCreateHandler;

    @PostMapping()
    public ResponseEntity<ClienteDto> createCliente(@Valid @RequestBody ClienteCreateRequest clienteRequest) {
        ClienteCreateCommand command = clienteCreateReqToCommandMapper.toCreateCommand(clienteRequest);
        return new ResponseEntity<>(clienteCreateHandler.execute(command), HttpStatus.CREATED);
    }
    
}
