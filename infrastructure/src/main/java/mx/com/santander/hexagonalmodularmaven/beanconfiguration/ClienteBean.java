package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteCreateService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteDeleteByIdService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteFindByEmailService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteGetAllService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteGetByIdService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteUpdateService;

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
    
    @Bean
    public ClienteDeleteByIdService clienteDeleteByIdService(ClienteDao clienteDao, ClienteRepository clienteRepository) {
    	return new ClienteDeleteByIdService(clienteDao, clienteRepository);
    }
    
    @Bean
    public ClienteGetAllService clienteGetAllService(ClienteDao clienteDao) {
    	return new ClienteGetAllService(clienteDao);
    }
    
    @Bean
    public ClienteUpdateService clienteUpdateService(ClienteRepository clienteRepository, ClienteDao clienteDao) {
    	return new ClienteUpdateService(clienteRepository, clienteDao);
    }


}
