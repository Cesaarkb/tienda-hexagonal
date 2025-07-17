package mx.com.santander.hexagonalmodularmaven.producto.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.mapper.ProductoToDtoMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoUpdateService;

@RequiredArgsConstructor
@Component
public class ProductoUpdateHandler {
	
	private final ProductoUpdateService productoUpdateService;
	private final ProductoToDtoMapper productoToDtoMapper;
	
	public ProductoDto execute(ProductoUpdateCommand command) {
		return productoToDtoMapper.toDto(productoUpdateService.execute(command));
	}

}
