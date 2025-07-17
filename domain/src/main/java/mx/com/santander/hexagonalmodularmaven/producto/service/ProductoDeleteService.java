package mx.com.santander.hexagonalmodularmaven.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoDeleteService {
	
	private final ProductoRepository productoRepository;
	
	
	public boolean execute(Long id) {
		return productoRepository.deleteProducto(id);
	}

}
