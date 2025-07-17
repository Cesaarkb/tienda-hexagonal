package mx.com.santander.hexagonalmodularmaven.cliente.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteDeleteByIdService;

@RequiredArgsConstructor
@Component
public class ClienteDeleteHandler {
	
	private final ClienteDeleteByIdService clienteDeleteByIdService;
	
	public boolean execute(Long id) {
		return clienteDeleteByIdService.execute(id);
	}

}
