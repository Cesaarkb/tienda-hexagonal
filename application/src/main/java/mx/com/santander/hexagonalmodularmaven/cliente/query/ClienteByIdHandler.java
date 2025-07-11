package mx.com.santander.hexagonalmodularmaven.cliente.query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.mapper.ClienteDtoMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteGetByIdService;

@RequiredArgsConstructor
@Component
public class ClienteByIdHandler {

    private final ClienteGetByIdService clienteGetByIdService;
    private final ClienteDtoMapper clienteDtoMapper;

    public ClienteDto execute(Long id){
        return clienteDtoMapper.toDto(clienteGetByIdService.execute(id));
    }

}
