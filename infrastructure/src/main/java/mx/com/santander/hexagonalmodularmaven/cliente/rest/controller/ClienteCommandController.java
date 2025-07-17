package mx.com.santander.hexagonalmodularmaven.cliente.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteCreateReqToCommandMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteUpdateReqToCommandMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.command.ClienteCreateHandler;
import mx.com.santander.hexagonalmodularmaven.cliente.command.ClienteDeleteHandler;
import mx.com.santander.hexagonalmodularmaven.cliente.command.ClienteUpdateHandler;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.rest.controller.dto.ClienteCreateRequest;
import mx.com.santander.hexagonalmodularmaven.cliente.rest.controller.dto.ClienteUpdateRequest;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteCommandController {

private final ClienteCreateReqToCommandMapper clienteCreateReqToCommandMapper;
private final ClienteUpdateReqToCommandMapper clienteUpdateReqToCommandMapper;
private final ClienteCreateHandler clienteCreateHandler;
private final ClienteUpdateHandler clienteUpdateHandler;
private final ClienteDeleteHandler clienteDeleteHandler;

    @PostMapping
    public ResponseEntity<ClienteDto> createCliente(@Valid @RequestBody ClienteCreateRequest clienteRequest) {
        ClienteCreateCommand command = clienteCreateReqToCommandMapper.toCreateCommand(clienteRequest);
        return new ResponseEntity<>(clienteCreateHandler.execute(command), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> updateCliente(@Valid @RequestBody ClienteUpdateRequest request,
    		@PathVariable("id") Long id){
    	ClienteUpdateCommand command = clienteUpdateReqToCommandMapper.toUpdateCommand(request);
    	command.setId(id);
    	return ResponseEntity.ok(clienteUpdateHandler.execute(command));
    }
    
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable("id") Long id) {
		if (clienteDeleteHandler.execute(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.badRequest().build();
	}

}
