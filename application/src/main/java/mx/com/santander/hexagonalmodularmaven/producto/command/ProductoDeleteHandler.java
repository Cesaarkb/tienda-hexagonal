package mx.com.santander.hexagonalmodularmaven.producto.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoDeleteService;

@RequiredArgsConstructor
@Component
public class ProductoDeleteHandler {
	
	private final ProductoDeleteService productoDeleteService;
	
	public boolean execute(Long id) {
		return productoDeleteService.execute(id);
		
	}

}
