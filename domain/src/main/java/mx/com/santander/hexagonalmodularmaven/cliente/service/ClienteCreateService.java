package mx.com.santander.hexagonalmodularmaven.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.EmailAlreadyExistException;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteCreateService {

    private final ClienteRepository clienteRepository;
    private final ClienteDao clienteDao;

    public Cliente execute(ClienteCreateCommand clienteCreateCommand){
          clienteDao.findByEmail(clienteCreateCommand.getEmail())
            .ifPresent(c -> {
                throw new EmailAlreadyExistException();
            });
        Cliente clienteCreado = new Cliente(
            clienteCreateCommand.getNombre(),
            clienteCreateCommand.getApellido(),
            clienteCreateCommand.getEmail(),
            clienteCreateCommand.getTelefono(),
            clienteCreateCommand.getDireccion()
        ); 
        return clienteRepository.create(clienteCreado);
    }

}
