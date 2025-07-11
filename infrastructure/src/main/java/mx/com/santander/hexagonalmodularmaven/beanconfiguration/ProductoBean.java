package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoCreateService;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoGetByIdService;

@Configuration
public class ProductoBean {

    @Bean
    public ProductoCreateService productoCreateService(ProductoRepository productoRepository){
        return new ProductoCreateService(productoRepository);
    }

    @Bean
    public ProductoGetByIdService productoGetByIdService(ProductoDao productoDao){
        return new ProductoGetByIdService(productoDao);
    }

}
