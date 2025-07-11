package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteCreateService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteFindByEmailService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteGetByIdService;

@Configuration
public class ClienteBean {

    @Bean
    public ClienteCreateService clienteCreateService(ClienteRepository clienteRepository, ClienteDao clienteDao){
        return new ClienteCreateService(clienteRepository, clienteDao);
    }

    @Bean
    public ClienteGetByIdService clienteGetByIdService(ClienteDao clienteDao){
        return new ClienteGetByIdService(clienteDao);
    }

    @Bean
    public ClienteFindByEmailService clienteFindByEmailService(ClienteDao clienteDao){
        return new ClienteFindByEmailService(clienteDao);
    }


}
