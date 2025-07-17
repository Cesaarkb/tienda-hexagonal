package mx.com.santander.hexagonalmodularmaven.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteDeleteByIdService {
	
	private final ClienteDao clienteDao;
	private final ClienteRepository clienteRepository;
	
	public boolean execute(Long id) {
		Cliente cliente = clienteDao.getById(id);
		return clienteRepository.deleteById(cliente.getId());
	}

}
