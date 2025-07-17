package mx.com.santander.hexagonalmodularmaven.cliente.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.mapper.ClienteDtoMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteUpdateService;

@RequiredArgsConstructor
@Component
public class ClienteUpdateHandler {
	
	private final ClienteUpdateService clienteUpdateService;
	private final ClienteDtoMapper clienteDtoMapper;
	
	public ClienteDto execute(ClienteUpdateCommand command) {
		return clienteDtoMapper.toDto(clienteUpdateService.execute(command));
	}

}
