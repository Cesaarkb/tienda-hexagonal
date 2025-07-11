package mx.com.santander.hexagonalmodularmaven.cliente.service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;

@RequiredArgsConstructor
public class ClienteFindByEmailService {

    private final ClienteDao clienteDao;

    public Optional<Cliente> execute(String email){
     return clienteDao.findByEmail(email);
    }


}
