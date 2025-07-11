package mx.com.santander.hexagonalmodularmaven.cliente.port.dao;

import java.util.Optional;

import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;

public interface ClienteDao {

    Cliente getById(Long id);
    Optional<Cliente> findByEmail(String email);

}
