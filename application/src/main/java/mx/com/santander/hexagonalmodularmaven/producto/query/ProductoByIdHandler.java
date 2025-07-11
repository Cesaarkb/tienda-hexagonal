package mx.com.santander.hexagonalmodularmaven.producto.query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.mapper.ProductoToDtoMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoGetByIdService;

@RequiredArgsConstructor
@Component
public class ProductoByIdHandler {

    private final ProductoGetByIdService productoGetByIdService;
    private final ProductoToDtoMapper productoToDtoMapper;

    public ProductoDto execute(Long id){
        return productoToDtoMapper.toDto(productoGetByIdService.execute(id));
    }

}
