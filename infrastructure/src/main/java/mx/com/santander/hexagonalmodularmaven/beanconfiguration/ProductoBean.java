package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoCreateService;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoDeleteService;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoGetAllService;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoGetByIdService;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoUpdateService;

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
    
    @Bean
    public ProductoDeleteService productoDeleteService(ProductoRepository productoRepository) {
    	return new ProductoDeleteService(productoRepository);
    }
    
    @Bean
    public ProductoGetAllService productoGetAllService(ProductoDao productoDao) {
    	return new ProductoGetAllService(productoDao);
    }
    
    @Bean
    public ProductoUpdateService productoUpdateService(ProductoRepository productoRepository,
    		ProductoDao productoDao) {
    	return new ProductoUpdateService(productoRepository, productoDao);
    }

}
