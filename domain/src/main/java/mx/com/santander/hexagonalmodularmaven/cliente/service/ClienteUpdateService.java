package mx.com.santander.hexagonalmodularmaven.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.EmailAlreadyExistException;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteUpdateService {
	
	private final ClienteRepository clienteRepository;
	private final ClienteDao clienteDao;
	
	
	public Cliente execute(ClienteUpdateCommand command) {
		Cliente clienteUpd = clienteDao.getById(command.getId());
		
		clienteDao.findByEmail(command.getEmail())
		.ifPresent(clienteDb ->{
			
			if (!clienteDb.getId().equals(command.getId())) {
				throw new EmailAlreadyExistException();
			}
		});
		
		clienteUpd.setNombre(command.getNombre());
		clienteUpd.setApellido(command.getApellido());
		clienteUpd.setEmail(command.getEmail());
		clienteUpd.setDireccion(command.getDireccion());
		clienteUpd.setTelefono(command.getTelefono());
		
		
		return clienteRepository.update(clienteUpd);
		
	}

}
