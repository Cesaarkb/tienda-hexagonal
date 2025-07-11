package mx.com.santander.hexagonalmodularmaven.producto.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.mapper.ProductoToDtoMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoCreateService;

@RequiredArgsConstructor
@Component
public class ProductoCreateHandler {

    private final ProductoCreateService productoCreateService;
    private final ProductoToDtoMapper productoToDtoMapper;

    public ProductoDto execute(ProductoCreateCommand command){
        return productoToDtoMapper.toDto(productoCreateService.execute(command));
    }

}
