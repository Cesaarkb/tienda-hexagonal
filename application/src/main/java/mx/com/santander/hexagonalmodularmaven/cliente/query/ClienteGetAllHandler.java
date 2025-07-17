package mx.com.santander.hexagonalmodularmaven.cliente.query;


import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.mapper.ClienteDtoMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteGetAllService;

@RequiredArgsConstructor
@Component
public class ClienteGetAllHandler {
	
	private final ClienteGetAllService clienteGetAllService;
	private final ClienteDtoMapper clienteDtoMapper;
	
	public List<ClienteDto> execute(){
		return clienteGetAllService.getall().stream()
				.map(clienteDtoMapper::toDto)
				.toList();
	}
}
