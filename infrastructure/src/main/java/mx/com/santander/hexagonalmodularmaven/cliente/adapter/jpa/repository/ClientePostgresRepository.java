package mx.com.santander.hexagonalmodularmaven.cliente.adapter.jpa.repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.entity.ClienteEntity;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.jpa.ClienteSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteEntityToDomainMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteToEntityMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
@Repository
@Transactional
public class ClientePostgresRepository implements ClienteRepository{

    private final ClienteSpringJpaAdapterRepository clienteSpringJpaAdapterRepository;
    private final ClienteToEntityMapper clienteToEntityMapper;
    private final ClienteEntityToDomainMapper clienteEntityToDomainMapper;

    @Override
    public Cliente create(Cliente cliente) {
        ClienteEntity clienteEntity = clienteToEntityMapper.toEntity(cliente);
        clienteSpringJpaAdapterRepository.save(clienteEntity);
        return clienteEntityToDomainMapper.toDomain(clienteEntity);
    }

}
