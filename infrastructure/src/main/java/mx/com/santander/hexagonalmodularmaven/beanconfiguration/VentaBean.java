package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.venta.port.repository.VentaRepository;
import mx.com.santander.hexagonalmodularmaven.venta.service.VentaCreateService;

@Configuration
public class VentaBean {

    @Bean
    public VentaCreateService ventaCreateService(VentaRepository ventaRepository, ProductoDao productoDao){
        return new VentaCreateService(ventaRepository, productoDao);
    }
}
