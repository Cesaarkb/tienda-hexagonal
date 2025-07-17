package mx.com.santander.hexagonalmodularmaven.cliente.adapter.jpa.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.entity.ClienteEntity;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.jpa.ClienteSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteEntityToDomainMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;
import mx.com.santander.hexagonalmodularmaven.cliente.rest.advice.ClienteNotFoundException;

@RequiredArgsConstructor
@Repository
public class ClientePostgresDao implements ClienteDao{

    private final ClienteSpringJpaAdapterRepository clienteSpringJpaAdapterRepository;
    private final ClienteEntityToDomainMapper clienteEntityToDomainMapper;

    @Override
    public Cliente getById(Long id) {
         ClienteEntity clienteEntity = clienteSpringJpaAdapterRepository
        .findById(id)
        .orElseThrow(ClienteNotFoundException::new);

    return clienteEntityToDomainMapper.toDomain(clienteEntity);
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {
        return clienteSpringJpaAdapterRepository
        .findByEmail(email)
        .map(clienteEntityToDomainMapper::toDomain);
    }

	@Override
	public List<Cliente> getAllClientes() {
		List<ClienteEntity> clientesEntity = clienteSpringJpaAdapterRepository.findAll();
		
		List<Cliente> clientesDomain = clientesEntity.stream()
		.map(clienteEntityToDomainMapper::toDomain)
		.toList();
		
		return clientesDomain;
	}

}
