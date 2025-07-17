package mx.com.santander.hexagonalmodularmaven.producto.query;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.mapper.ProductoToDtoMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoGetAllService;

@RequiredArgsConstructor
@Component
public class ProductoGetAllHandler {
	
	private final ProductoGetAllService productoGetAllService;
	private final ProductoToDtoMapper productoToDtoMapper;
	
	public List<ProductoDto> execute(){
		return productoGetAllService.execute().stream()
				.map(productoToDtoMapper::toDto)
				.toList();
	}

}
