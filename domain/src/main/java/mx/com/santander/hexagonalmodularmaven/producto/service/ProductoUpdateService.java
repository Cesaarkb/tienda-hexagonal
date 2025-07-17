package mx.com.santander.hexagonalmodularmaven.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoUpdateService {
	
	private final ProductoRepository productoRepository;
	private final ProductoDao productoDao;
	
	public Producto execute(ProductoUpdateCommand command) {
		Producto productoUpd = productoDao.getbyId(command.getId());
		
		productoUpd.setNombre(command.getNombre());
		productoUpd.setPrecio(command.getPrecio());
		productoUpd.setStock(command.getStock());
		return productoRepository.saveProducto(productoUpd);
		
	}

}
